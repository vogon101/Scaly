package com.freddieposer.scaly.backend

import com.freddieposer.scaly.backend.internal._
import com.freddieposer.scaly.backend.pyc._
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes.ROT_TWO
import com.freddieposer.scaly.typechecker.context.TypeContext.Location
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType._
import com.freddieposer.scaly.typechecker.types.{ScalyFunctionType, ScalyType, SymbolSource}


class ISTCompiler(_filename: String) {

  import CodeGenerationUtils._

  private val filename = _filename.toPy

  private val THIS_NAME: PyAscii = "this".toPy
  private val GLOBAL_LAZY_PREFIX: String = "__global__lazyImpl_"


  private def withContext(f: CompilationContext => PyCodeObject): PyCodeObject = {
    val ctx = new CompilationContext
    f(ctx)
  }

  val nameMangler: Map[String, String] = Map(
    "+" -> "__add__",
    "*" -> "__mul__",
    "-" -> "__sub__",
    "/" -> "__div__",
    "<" -> "__lt__",
    "<=" -> "__le__",
    ">" -> "__gt__",
    ">=" -> "__ge__",
    "==" -> "__eq__"
  )


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
            BuildGlobalLazy(GLOBAL_LAZY_PREFIX + name, name, ctx, typ) -->
              (STORE_NAME, ctx.name((GLOBAL_LAZY_PREFIX + name).toPy)).toBCL
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
    val stackSize: Int = 10 // ???

    val constructor = compileConstructor(istClass)

    val functions = constructor :: ctx.withClass {
      istClass.defs.map(t => compileFunction(t._1, t._2.func, ctx))
    }.toList

    val code: BytecodeList = {
      import PyOpcodes._
      BytecodeList(
        (LOAD_NAME, ctx.name("__name__".toPy)),
        (STORE_NAME, ctx.name("__module__".toPy)),
        (LOAD_CONST, ctx.const(istClass.name.toPy)),
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
      code.compile, ctx.constants, ctx.names, PyTuple.empty, PyTuple.empty, PyTuple.empty, istClass.name.toPy, filename, PyString.empty
    )

  }

  def compileConstructor(istClass: IST_Template): PyCodeObject = withContext { ctx =>

    import PyOpcodes._

    val constructorName = "__init__".toPy
    val stackSize = 10
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
      val stackSize = istFunction.body.maxStack + 2
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
        val falseMarker = Marker.absolute
        val endMarker = Marker.relative
        compileExpression(cond, ctx) -->
          (POP_JUMP_IF_FALSE, falseMarker) -->
          compileExpression(tBranch, ctx) -->
          (JUMP_FORWARD, endMarker) -->
          falseMarker -->
          compileExpression(fBranch, ctx) --> endMarker
      case IST_If(cond, tBranch, None, _) =>
        val endMarker = Marker.absolute
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
            (LOAD_GLOBAL, ctx.name((GLOBAL_LAZY_PREFIX + name).toPy)),
            (CALL_FUNCTION, 0.toByte)
          )
          case THIS => loadThis(ctx).toBCL

        }
      //TODO: This could simply be rewritten to be a function application?
      case IST_New(name, args, _) =>
        (LOAD_GLOBAL, ctx.name(name.toPy)).toBCL -->
          args.map(compileExpression(_, ctx)).flat -->
          (CALL_FUNCTION, args.length.toByte).toBCL

      case IST_Assignment(_name, location, rhs) =>
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

      case IST_While(cond, body) =>
        val endMarker = Marker.absolute
        val condMarker = Marker.absolute
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

      case m: IST_Match => compileMatch(m, ctx)
      case RawISTExpr(bcl) => bcl
      case IST_Subscript(lhs, rhs, _) =>
        compileExpression(lhs, ctx) -->
          (LOAD_CONST, ctx.const(rhs.toPy)) -->
          ~BINARY_SUBSCR
    }
  }

  //Currently doesn't return - should be managed by compileFunction
  def compileBlock(block: IST_Sequence, ctx: CompilationContext): BytecodeList = {

    import PyOpcodes._
    val bc = block.statements.map {
      case expr: IST_Expression =>
        block match {
          case IST_Block(_, _) => compileExpression(expr, ctx) --> (~POP_TOP).toBCL
          case _ => compileExpression(expr, ctx)
        }

      case m: IST_Member => m match {
        case d@IST_Def(id, _, _, _, _, freeVars) =>
          makeFunction(id, d.func, ctx) -->
            (STORE_FAST, ctx.varname(id.toPy))
        case IST_Val(id, expr, location) =>
          compileExpression(IST_Assignment(id, location.writable.get, expr), ctx)
        case IST_Var(id, expr, location) =>
          compileExpression(IST_Assignment(id, location.writable.get, expr), ctx)
      }
      //We need to be popping items off the stack here but we can only do this IF they add things
      //thus all functions NEED to return a PY_NONE if they don't return something else!
    }.foldLeft(BytecodeList.empty)(_ --> _)
    block match {
      case IST_Block(statements, typ) => new BytecodeList(bc.dropRight(1).toList)
      case _ => new BytecodeList(bc.toList)
    }
  }

  //TODO: Swap to using functions for the case bodies so that the context is respected
  //  and outer vars aren't overwritten! (Currently violates type safety)
  def compileMatch(matchExpr: IST_Match, ctx: CompilationContext): BytecodeList = ctx.withMatch {
    import PyOpcodes._

    val IST_Match(lhs, cases, _) = matchExpr

    val assign =
      IST_Assignment(ctx.match_name, Location(lhs.typ, SymbolSource.LOCAL_WRITABLE), (~DUP_TOP).r) + (~POP_TOP)

    val patternsBC = cases.map(c => compilePattern(c.pattern, ctx))

    def descend(ps: List[(IST_Case, IST_CompiledPattern)]): IST_Expression = ps match {
      case Nil => ThrowException("Match error".toPy)
      case (c, IST_CompiledPattern(binds, cond)) :: rest =>
        (~DUP_TOP).r +
          IST_If(
            cond,
            (~DUP_TOP).r +
              IST_Function(c.pattern.bindings.keys.toList, c.rhs, ScalyFunctionType(None, ScalyNothingType), c.closedVars, c.freeVars) +
              (~ROT_TWO).r + binds + (CALL_FUNCTION, c.pattern.bindings.size.toByte).r,
            Some(descend(rest)),
            c.typ
          )
    }

    val matchIST = lhs + assign + descend(cases zip patternsBC)

    val x = compileExpression(matchIST, ctx)
    x

  }

  def compilePatternCondition(pattern: IST_Pattern): IST_Expression = {
    import PyOpcodes._
    pattern match {
      case IST_LiteralPattern(literal) =>
        literal + (COMPARE_OP, 2.toByte)
      case IST_VariablePattern(name, matchType) =>
        (~POP_TOP).r + IST_Literal(PyTrue, ScalyBooleanType)
      case IST_TuplePattern(pats) =>
        pats.map(compilePatternCondition)
          .zipWithIndex.map {
          case (cond, 0) =>
            (~DUP_TOP).r + IST_Literal(0.toPy, ScalyIntType) + (~BINARY_SUBSCR) + cond
          case (cond, i) =>
            (~ROT_TWO).r + (~DUP_TOP) + IST_Literal(i.toPy, ScalyIntType) + (~BINARY_SUBSCR) +
              cond +
              (~ROT_THREE) + (~ROT_THREE) + (~BINARY_AND)
        }.flat + ~ROT_TWO + ~POP_TOP
    }
  }

  def compilePatternBindings(pattern: IST_Pattern, ctx: CompilationContext): IST_Expression = {
    import PyOpcodes._
    pattern match {
      case IST_LiteralPattern(_) => (~POP_TOP).r
      case IST_VariablePattern(_, _) => (~NOP).r
      case IST_TuplePattern(pats) =>
        val outerName = ctx.match_name
        (~POP_TOP).r + pats.zipWithIndex.map {
          case (pattern, i) => ctx.withMatch {
            val innerBind = compilePatternBindings(pattern, ctx)
            IST_Name(outerName, Location.local) +
              IST_Assignment(ctx.match_name, Location.local_w, IST_Literal(i.toPy, ScalyIntType) + (~BINARY_SUBSCR)) +
              ~POP_TOP +
              IST_Name(ctx.match_name, Location.local) +
              innerBind
          }
        }.flat
    }
  }

  def compilePattern(pattern: IST_Pattern, ctx: CompilationContext): IST_CompiledPattern =
    IST_CompiledPattern(compilePatternBindings(pattern, ctx), compilePatternCondition(pattern))


  case class IST_CompiledPattern(binds: IST_Expression, cond: IST_Expression)

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

  private def loadThis(ctx: CompilationContext): Bytecode = {
    import PyOpcodes.{LOAD_DEREF, LOAD_FAST}
    if (ctx.isBoxed(THIS_NAME.text)) (LOAD_DEREF, ctx.freeOrCell(THIS_NAME))
    else (LOAD_FAST, ctx.varname(THIS_NAME))
  }


  private def TestCaddy(ctx: CompilationContext): BytecodeList = {
    import PyOpcodes._
    BytecodeList(
      (LOAD_NAME, ctx.name("print".toPy)),
      (LOAD_NAME, ctx.name((GLOBAL_LAZY_PREFIX + "Main").toPy)),
      (CALL_FUNCTION, 0.toByte),
      (LOAD_METHOD, ctx.name("main".toPy)),
      (CALL_METHOD, 0.toByte),
      (CALL_FUNCTION, 1.toByte),
      ~POP_TOP
    )
  }

  private def ImportSTDLib(ctx: CompilationContext): BytecodeList = {
    import PyOpcodes._
    BytecodeList(
      (LOAD_CONST, ctx.const(0.toPy)),
      (LOAD_CONST, ctx.const(PyTuple(List("*".toPy)))),
      (IMPORT_NAME, ctx.name("pyScaly_lib".toPy)),
      ~IMPORT_STAR
    )
  }

  //TODO: Clean this up
  //TODO: Make this more efficient (overwrite function?)
  private def BuildGlobalLazy(name: String, constructorName: String, ctx: CompilationContext, typ: ScalyType): BytecodeList = {

    val location = Location(typ, SymbolSource.GLOBAL)
    val locationName = name + "_loc"

    compileExpression(
      IST_Block(List(
        IST_Assignment(locationName, location, IST_Literal(PyNone, ScalyUnitType)),
        IST_Function(
          Nil,
          IST_Block(List(
            IST_If(
              IST_IsNone(IST_Name(locationName, location)),
              IST_Assignment(locationName, location, IST_New(constructorName, Nil, typ)),
              Some(IST_Literal(PyNone, ScalyUnitType)),
              ScalyUnitType
            ), IST_Name(locationName, location)
          ), typ),
          ScalyFunctionType(Some(ScalyUnitType), typ), Map(), Map()
        )
      ), ScalyFunctionType(Some(ScalyUnitType), typ)), ctx
    )
  }

  private def ThrowException(message: PyAscii): IST_Sequence = {
    import PyOpcodes._
    IST_Application(
      IST_Name("Exception", Location(SymbolSource.GLOBAL)),
      List(IST_Literal(message, ScalyStringType)),
      ScalyNothingType
    ) + (RAISE_VARARGS, 1.toByte)
  }

  private def PrintTopThree: IST_Sequence = {
    PrintString("TOS") //+ PrintTop +
    //      ~ROT_THREE + PrintString("TOS1") + PrintTop +
    //      ~ROT_THREE + PrintString("TOS2") + PrintTop + ~ROT_THREE

  }


  private def PrintTop: IST_Sequence = {
    import PyOpcodes.{DUP_TOP, POP_TOP}

    (~DUP_TOP).r + IST_Application(IST_Name("print", Location(SymbolSource.GLOBAL)), List((~ROT_TWO).r), ScalyNothingType) + ~POP_TOP
  }

  private def PrintString(str: String): IST_Sequence = {
    import PyOpcodes.POP_TOP
    IST_Application(IST_Name("print", Location(SymbolSource.GLOBAL)), List(IST_Literal(str.toPy, ScalyStringType)), ScalyNothingType) + ~POP_TOP
  }

}
