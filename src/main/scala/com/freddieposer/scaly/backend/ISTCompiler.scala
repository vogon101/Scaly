package com.freddieposer.scaly.backend

import com.freddieposer.scaly.backend.CompilationContext.withContext
import com.freddieposer.scaly.backend.ISTCompiler.{GLOBAL_LAZY_PREFIX, THIS_NAME}
import com.freddieposer.scaly.backend.internal.Bytecode._
import com.freddieposer.scaly.backend.internal.BytecodeSnippets._
import com.freddieposer.scaly.backend.internal.CodeGenerationUtils.StringPyConverter
import com.freddieposer.scaly.backend.internal._
import com.freddieposer.scaly.backend.pyc._
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes
import com.freddieposer.scaly.typechecker.context.TypeContext.Location
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType._
import com.freddieposer.scaly.typechecker.types.{ScalyFunctionType, ScalyType, SymbolSource}


class ISTCompiler(_filename: String) {

  import CodeGenerationUtils._

  val nameMangler: Map[String, String] = Map(
    "+" -> "__add__",
    "*" -> "__mul__",
    "-" -> "__sub__",
    "/" -> "__div__",
    "<" -> "__lt__",
    "<=" -> "__le__",
    ">" -> "__gt__",
    ">=" -> "__ge__",
    "==" -> "__eq__",
    "&&" -> "__and__",
    "||" -> "__or__",
    "unary_-" -> "__neg__"
  )
  private val filename = _filename.toPy

  def compile(ist: IST_CompilationUnit): PyCodeObject = withContext { ctx =>

    val classes = ist.classes.map(compileClass(_, ctx))

    val code: BytecodeList = ImportSTDLib(ctx) --> {
      import PyOpcodes._
      classes.zip(ist.classes).flatMap { case (pycode, istClass) =>

        val parent = istClass.typ.parent
          .map(
            p => p.globalName.map {
              name => (LOAD_NAME, ctx.name(name.toPy)).toBCL
            }.getOrElse(throw new Error(s"Cannot inherit from $p"))
          )

        val objectCode = istClass match {
          case _: IST_Class => BytecodeList.empty
          case IST_Object(name, _, _, _, _, typ) =>
            BuildGlobalLazy(GLOBAL_LAZY_PREFIX + name + "$", name + "$", ctx, typ) -->
              (STORE_NAME, ctx.name((GLOBAL_LAZY_PREFIX + name + "$").toPy)).toBCL
        }

        BytecodeList(
          ~LOAD_BUILD_CLASS,
          (LOAD_CONST, ctx.const(pycode)),
          (LOAD_CONST, ctx.const(pycode.name)),
          ~MAKE_FUNCTION,
          (LOAD_CONST, ctx.const(pycode.name))
        ) --> parent.getOrElse(BytecodeList.empty) --> BytecodeList(
          (CALL_FUNCTION, (2 + parent.map(_ => 1).getOrElse(0)).toByte),
          (STORE_NAME, ctx.name(pycode.name))
        ) --> objectCode
      }
    } --> TestCaddy(ctx) --> ReturnNone(ctx)


    val name = "<module>".toPy

    //TODO
    val stackSize: Int = 10 // ???

    new PyCodeObject(
      0, 0, 0, 0, stackSize, 64, 1,
      code.compile, ctx.constants, ctx.names, PyTuple.empty, PyTuple.empty,
      PyTuple.empty, name, filename, new PyString(List())
    )
  }

  def compileClass(istClass: IST_Template, outerContext: CompilationContext): PyCodeObject = withContext { ctx =>
    val stackSize: Int = 20 // ???

    val constructor = compileConstructor(istClass)

    val name = istClass match {
      case c:IST_Class => c.name
      case o:IST_Object => o.name + "$"
    }

    val functions = constructor :: ctx.withClass {
      istClass.defs.map(t => compileFunction(t._1, t._2.func, ctx))
    }.toList

    val code: BytecodeList = {
      import PyOpcodes._
      BytecodeList(
        (LOAD_NAME, ctx.name("__name__".toPy)),
        (STORE_NAME, ctx.name("__module__".toPy)),
        (LOAD_CONST, ctx.const(name.toPy)),
        (STORE_NAME, ctx.name("__qualname__".toPy))
      ) --> functions.flatMap(func => BytecodeList(
        (LOAD_CONST, ctx.const(func)),
        (LOAD_CONST, ctx.const(func.name)),
        (MAKE_FUNCTION, 0.toByte),
        (STORE_NAME, ctx.name(func.name))
      )).toBCL --> ReturnNone(ctx)
    }

    new PyCodeObject(
      0, 0, 0, 0, stackSize, 64, 1,
      code.compile, ctx.constants, ctx.names, PyTuple.empty, PyTuple.empty, PyTuple.empty, name.toPy, filename, PyString.empty
    )

  }

  def compileConstructor(istClass: IST_Template): PyCodeObject = withContext { ctx =>

    import PyOpcodes._

    val constructorName = "__init__".toPy
    val stackSize = 20
    //    val stackSize = List(
    //      2, // Add params as attrs
    //      istClass.statements.map(_.maxStack), //Body of constructor
    //      istClass.parentParams.map(_.maxStack).max + 3 //Calling parents
    //    ).max + 2 //Buffer

    val nargs = 1 + istClass.params.length
    val localNames = THIS_NAME :: istClass.params.map(_.id.toPy)

    val parentConstructor = istClass.parent.map { p =>

      val paramCode = istClass.parentParams.map(compileExpression(_, ctx)).flat

      BytecodeList(
        (LOAD_GLOBAL, ctx.name(p.toPy)),
        (LOAD_METHOD, ctx.name(constructorName)),
        (LOAD_FAST, ctx.varname(THIS_NAME))
      ) --> paramCode -->
        (CALL_METHOD, (1 + istClass.parentParams.length).toByte).toBCL
    }

    localNames.foreach(n => ctx.varname(n))

    // Max stack: 2
    val paramStatements: List[BytecodeList] = istClass.params.map { p =>
      BytecodeList(
        (LOAD_FAST, ctx.varname(p.id.toPy)),
        (LOAD_FAST, ctx.varname(THIS_NAME)),
        (STORE_ATTR, ctx.name(p.id.toPy))
      )
    }

    val bcStatements: List[BytecodeList] = istClass.statements.map {
      case IST_Member(id, expr) =>
        compileExpression(expr, ctx) -->
          BytecodeList(
            (LOAD_FAST, ctx.varname(THIS_NAME)),
            (STORE_ATTR, ctx.name(id.toPy))
          )

      case expression: IST_Expression =>
        compileExpression(expression, ctx) --> (~POP_TOP).toBCL
    }

    val code = {
      paramStatements.flatten -->
        parentConstructor.getOrElse(BytecodeList.empty) -->
        bcStatements.flatten -->
        BytecodeList((LOAD_CONST, ctx.const(PyNone)), ~RETURN_VALUE)
    }

    PyCodeObject(ctx, code.compile, constructorName, filename, nargs, nargs, nargs, stackSize, 67)

  }

  //Context should track max stack size
  def compileFunction(_name: String, istFunction: IST_Function, outerContext: CompilationContext): PyCodeObject =
    withContext { ctx =>
      import PyOpcodes.RETURN_VALUE
      val name = nameMangler.getOrElse(_name, _name)

      istFunction.closedVars.foreach(c => ctx.cell(c._1.toPy))
      istFunction.freeVars.foreach(c => ctx.free(c._1.toPy))

      val (nargs, localNames) = if (outerContext.inClass) (
        istFunction.args.length + 1,
        THIS_NAME :: istFunction.args.map(_.toPy)
      ) else (
        istFunction.args.length,
        istFunction.args.map(_.toPy)
      )

      //Add some buffer
      val stackSize = istFunction.body.maxStack + 10
      localNames.foreach(ctx.varname)
      // TODO: + number of other locals


      val code: BytecodeList =
        compileExpression(istFunction.body, ctx) --> ~RETURN_VALUE

      //TODO: Understand flags
      PyCodeObject(
        ctx, code.compile, name.toPy, filename, nargs, nargs,
        ctx.varnames.length, stackSize, 67, ctx.freevars, ctx.cellvars
      )
    }

  def compileExpression(expression: IST_Expression, ctx: CompilationContext): BytecodeList = {
    import PyOpcodes._
    expression match {
      case f: IST_Function =>
        makeFunction("<anon>", f, ctx)
      case IST_TupleExpr(elems, _) =>
        (LOAD_GLOBAL, ctx.name("ScalyTuple".toPy)).toBCL -->
          elems.map(compileExpression(_, ctx)).flat -->
          (BUILD_TUPLE, elems.length.toByte) -->
          (CALL_FUNCTION, 1.toByte).toBCL
      case IST_If(cond, tBranch, Some(fBranch), _) =>
        val falseMarker = BytecodeMarker.absolute
        val endMarker = BytecodeMarker.relative
        compileExpression(cond, ctx) -->
          (POP_JUMP_IF_FALSE, falseMarker) -->
          compileExpression(tBranch, ctx) -->
          (JUMP_FORWARD, endMarker) -->
          falseMarker -->
          compileExpression(fBranch, ctx) --> endMarker
      case IST_If(cond, tBranch, None, _) =>
        val endMarker = BytecodeMarker.absolute
        compileExpression(cond, ctx) -->
          (POP_JUMP_IF_FALSE, endMarker) -->
          compileExpression(tBranch, ctx) -->
          endMarker

      case IST_Select(lhs, rhs, _) =>
        val name = nameMangler.getOrElse(rhs, rhs)
        compileExpression(lhs, ctx) -->
          (LOAD_ATTR, ctx.name(name.toPy))

      case IST_Application(lhs, args, _) =>
        compileExpression(lhs, ctx) -->
          args.flatMap(arg => compileExpression(arg, ctx)) -->
          (CALL_FUNCTION, args.length.toByte)

      case IST_ApplicationWithType(lhs, targs, _) =>
        compileExpression(lhs, ctx) -->
          targs.map(targ => targ.globalName.map {
              name => (LOAD_GLOBAL, ctx.name(name.toPy)).toBCL
            }.getOrElse(throw new Error(s"Cannot use $targ as type argument"))
          ).flat -->
          (CALL_FUNCTION, 1.toByte)

      case literal: IST_Literal =>
        BytecodeList((LOAD_CONST, ctx.const(literal.py)))

      case block: IST_Sequence => compileBlock(block, ctx)

      case IST_Name(_name, location) =>
        val name = nameMangler.getOrElse(_name, _name)
        import com.freddieposer.scaly.typechecker.types.SymbolSource._
        location.source match {
          case LOCAL | LOCAL_WRITABLE if ctx.isBoxed(name) =>
            (LOAD_DEREF, ctx.freeOrCell(name.toPy)).toBCL
          case LOCAL | LOCAL_WRITABLE =>
            (LOAD_FAST, ctx.varname(name.toPy)).toBCL
          case CLOSURE | CLOSURE_WRITABLE =>
            (LOAD_DEREF, ctx.free(name.toPy)).toBCL
          case MEMBER | MEMBER_WRITABLE | CLOSURE_MEMBER | CLOSURE_MEMBER_WRITABLE =>
            BytecodeList(
              loadThis(ctx),
              (LOAD_ATTR, ctx.name(name.toPy))
            )
          case GLOBAL =>
            (LOAD_GLOBAL, ctx.name(name.toPy)).toBCL
          case GLOBAL_LAZY => BytecodeList(
            (LOAD_GLOBAL, ctx.name((GLOBAL_LAZY_PREFIX + name + "$").toPy)),
            (CALL_FUNCTION, 0.toByte)
          )
          case THIS => loadThis(ctx).toBCL

        }
      //TODO: This could simply be rewritten to be a function application?
      case IST_New(name, args, _) =>
        (LOAD_GLOBAL, ctx.name(name.toPy)).toBCL -->
          args.map(compileExpression(_, ctx)).flat -->
          (CALL_FUNCTION, args.length.toByte).toBCL

      case IST_Assignment(IST_Name(_name, location), rhs) =>
        val name = nameMangler.getOrElse(_name, _name)
        import com.freddieposer.scaly.typechecker.types.SymbolSource._
        compileExpression(rhs, ctx) --> (location.source match {
          case LOCAL_WRITABLE if ctx.isBoxed(name) =>
            (STORE_DEREF, ctx.freeOrCell(name.toPy)).toBCL
          case LOCAL_WRITABLE =>
            (STORE_FAST, ctx.varname(name.toPy)).toBCL
          case CLOSURE_WRITABLE =>
            (STORE_DEREF, ctx.free(name.toPy)).toBCL
          case MEMBER_WRITABLE | CLOSURE_MEMBER_WRITABLE => BytecodeList(
            loadThis(ctx),
            (STORE_ATTR, ctx.name(name.toPy))
          )
          case GLOBAL =>
            (STORE_GLOBAL, ctx.name(name.toPy)).toBCL
          case _ => throw new Exception(s"Cannot assign to $location ($name)")
        }) --> (LOAD_CONST, ctx.const(PyNone))

      case IST_SelectAssignment(IST_Select(lhs, member, _), rhs) =>
        val name = nameMangler.getOrElse(member, member)
        import SymbolSource._
        compileExpression(rhs, ctx) -->
          compileExpression(lhs, ctx) -->
          (STORE_ATTR, ctx.name(name.toPy))

      case IST_While(cond, body) =>
        val endMarker = BytecodeMarker.absolute
        val condMarker = BytecodeMarker.absolute
        condMarker.toBCL -->
          compileExpression(cond, ctx) -->
          (POP_JUMP_IF_FALSE, endMarker) -->
          compileExpression(body, ctx) -->
          ~POP_TOP --> //Removes result of expression
          (JUMP_ABSOLUTE, condMarker) -->
          endMarker --> (LOAD_CONST, ctx.const(PyNone))

      case IST_IsNone(lhs) =>
        compileExpression(lhs, ctx) --> BytecodeList(
          (LOAD_CONST, ctx.const(PyNone)),
          (COMPARE_OP, 8.toByte)
        )

      case _: IST_Match =>
        throw new Error("Cannot compile IST_Match - use a PatternMatchingTransformer in the pipeline")

      case RawISTExpr(bcl) => bcl
      case IST_Subscript(lhs, rhs, _) =>
        compileExpression(lhs, ctx) -->
          (LOAD_CONST, ctx.const(rhs.toPy)) -->
          ~BINARY_SUBSCR
    }
  }


  def compileBlock(block: IST_Sequence, ctx: CompilationContext): BytecodeList = {

    import PyOpcodes._

    import com.freddieposer.scaly.typechecker.types.SymbolSource._
    val bc = block.statements.map {
      case expr: IST_Expression =>
        block match {
          case IST_Block(_, _) => compileExpression(expr, ctx) --> (~POP_TOP).toBCL
          case _ => compileExpression(expr, ctx)
        }

      case m: IST_Member => m match {
        case d@IST_Def(id, _, _, _, _, freeVars, location) =>
          makeFunction(id, d.func, ctx) -->
            (location.source match {
            case CLOSURE | CLOSURE_WRITABLE =>
              (STORE_DEREF, ctx.freeOrCell(id.toPy))
            case _ =>
              (STORE_FAST, ctx.varname(id.toPy))
          })
        case IST_Val(id, expr, location) =>
          compileExpression(IST_Assignment(IST_Name(id, location.writable.get), expr), ctx)
        case IST_Var(id, expr, location) =>
          compileExpression(IST_Assignment(IST_Name(id, location.writable.get), expr), ctx)
      }
      //We need to be popping items off the stack here but we can only do this IF they add things
      //thus all functions NEED to return a PY_NONE if they don't return something else!
    }.foldLeft(BytecodeList.empty)(_ --> _)
    block match {
      case IST_Block(statements, typ) => new BytecodeList(bc.dropRight(1).toList)
      case _ => new BytecodeList(bc.toList)
    }
  }

  def makeFunction(id: String, func: IST_Function, ctx: CompilationContext): BytecodeList = {
    import PyOpcodes._
    ctx.withoutClass {
      (if (func.freeVars.nonEmpty)
        func.freeVars
          .map(n => (LOAD_CLOSURE, ctx.freeOrCell(n._1.toPy)).toBCL)
          .toList.flat --> (BUILD_TUPLE, func.freeVars.size.toByte)
      else BytecodeList.empty) --> BytecodeList(
        (LOAD_CONST, ctx.const(compileFunction(id, func, ctx))),
        (LOAD_CONST, ctx.const(id.toPy)),
        (MAKE_FUNCTION, (if (func.freeVars.nonEmpty) 8 else 0).toByte),
      )
    }

  }

  //TODO: Clean this up
  //TODO: Make this more efficient (overwrite function?)
  private def BuildGlobalLazy(name: String, constructorName: String, ctx: CompilationContext, typ: ScalyType): BytecodeList = {

    val location = Location(typ, SymbolSource.GLOBAL)
    val locationName = name + "_loc"
    val istName = IST_Name(locationName, location)

    compileExpression(
      IST_Block(List(
        IST_Assignment(istName, IST_Literal(PyNone, ScalyUnitType)),
        IST_Function(
          Nil,
          IST_Block(List(
            IST_If(
              IST_IsNone(IST_Name(locationName, location)),
              IST_Assignment(istName, IST_New(constructorName, Nil, typ)),
              Some(IST_Literal(PyNone, ScalyUnitType)),
              ScalyUnitType
            ), IST_Name(locationName, location)
          ), typ),
          ScalyFunctionType(Some(ScalyUnitType), typ), Map(), Map()
        )
      ), ScalyFunctionType(Some(ScalyUnitType), typ)), ctx
    )
  }


}

object ISTCompiler {
  val THIS_NAME: PyAscii = "this".toPy
  val GLOBAL_LAZY_PREFIX: String = "__global__lazyImpl_"
}
