package com.freddieposer.scaly.backend

import com.freddieposer.scaly.backend.internal._
import com.freddieposer.scaly.backend.pyc._
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes.{POP_TOP, STORE_FAST}

class ISTCompiler(_filename: String) {

  import CodeGenerationUtils._

  private val filename = _filename.toPy

  private val THIS_NAME: PyAscii = "this".toPy

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

        BytecodeList(
          ~LOAD_BUILD_CLASS,
          (LOAD_CONST, ctx.const(pycode)),
          (LOAD_CONST, ctx.const(pycode.name)),
          ~MAKE_FUNCTION,
          (LOAD_CONST, ctx.const(pycode.name))
        ) --> parent.getOrElse(BytecodeList.empty) --> BytecodeList(
          (CALL_FUNCTION, (2 + parent.map(_ => 1).getOrElse(0)).toByte),
          (STORE_NAME, ctx.name(pycode.name))
        )
      }
    } --> TestCaddy(ctx) --> ReturnNone(ctx)


    val name = "<module>".toPy

    val stackSize: Int = 10 // ???

    new PyCodeObject(
      0, 0, 0, 0, stackSize, 64, 1,
      code.compile, ctx.constants, ctx.names, PyTuple.empty, PyTuple.empty,
      PyTuple.empty, name, filename, new PyString(List())
    )
  }

  def compileClass(istClass: IST_Class, outerContext: CompilationContext): PyCodeObject = withContext { ctx =>
    val stackSize: Int = 10 // ???

    val constructor = compileConstructor(istClass.stats, istClass.typ.parent.flatMap(_.globalName))

    val functions = {
      //TODO: Actual objects
      if (istClass.name == "Main")
        istClass.defs.map(t => compileFunction(t._1, t._2.func, ctx))
      else ctx.withClass {
        istClass.defs.map(t => compileFunction(t._1, t._2.func, ctx))
      }
    } ++ (if (istClass.name != "Main") constructor :: Nil else Nil)


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

  //TODO: constructor args
  def compileConstructor(statements: List[IST_Statement], parentName: Option[String]): PyCodeObject = withContext { ctx =>
    import PyOpcodes._

    val name = "__init__"
    val stackSize = 10

    val nargs = 1
    val localNames = THIS_NAME :: Nil

    //TODO: Constructor parameters for parent
    val parentConstructor = parentName.map { p =>
      BytecodeList(
        (LOAD_GLOBAL, ctx.name(p.toPy)),
        (LOAD_METHOD, ctx.name(name.toPy)),
        (LOAD_FAST, ctx.name(THIS_NAME)),
        (CALL_METHOD, 1.toByte)
      )
    }

    localNames.foreach(n => ctx.varname(n))

    val bcStatements: List[BytecodeList] = statements.map {
      case IST_Member(id, expr) =>
        compileExpression(expr, ctx) -->
          BytecodeList(
            (LOAD_FAST, ctx.varname(THIS_NAME)),
            (STORE_ATTR, ctx.name(id.toPy))
          )

      case expression: IST_Expression =>
        compileExpression(expression, ctx) --> (~POP_TOP).toBCL
    }
    val code =
      parentConstructor.getOrElse(BytecodeList.empty) -->
        bcStatements.foldLeft(BytecodeList.empty)(_ --> _) -->
        BytecodeList((LOAD_CONST, ctx.const(PyNone)), ~RETURN_VALUE)

    PyCodeObject(ctx, code.compile, name.toPy, filename, nargs, nargs, nargs, stackSize, 67)

  }

  //Context should track max stack size
  def compileFunction(_name: String, istFunction: IST_Function, outerContext: CompilationContext): PyCodeObject =
    withContext { ctx =>
      import PyOpcodes.RETURN_VALUE
      val name = nameMangler.getOrElse(_name, _name)

      val (nargs, localNames) = if (outerContext.inClass) (
        istFunction.args.length + 1,
        THIS_NAME :: istFunction.args.map(_.toPy)
      ) else (
        istFunction.args.length,
        istFunction.args.map(_.toPy)
      )

      localNames.foreach(n => ctx.varname(n))

      val stackSize = 10
      // TODO: + number of other locals

      val code: BytecodeList =
        compileExpression(istFunction.body, ctx) --> ~RETURN_VALUE

      //TODO: Understand flags
      PyCodeObject(
        ctx, code.compile, name.toPy, filename, nargs, nargs,
        ctx.varnames.length, stackSize, 67
      )
    }

  def compileExpression(expression: IST_Expression, ctx: CompilationContext): BytecodeList = {
    import PyOpcodes._
    expression match {
      case IST_Function(args, body, typ) => ???
      case IST_If(cond, tBranch, Some(fBranch), typ) =>
        val falseMarker = Marker.absolute
        val endMarker = Marker.relative
        compileExpression(cond, ctx) -->
          (POP_JUMP_IF_FALSE, falseMarker) -->
          compileExpression(tBranch, ctx) -->
          (JUMP_FORWARD, endMarker) -->
          falseMarker -->
          compileExpression(fBranch, ctx) --> endMarker
      case IST_If(cond, tBranch, None, typ) =>
        val endMarker = Marker.absolute
        compileExpression(cond, ctx) -->
          (POP_JUMP_IF_FALSE, endMarker) -->
          compileExpression(tBranch, ctx) -->
          endMarker

      case IST_Select(lhs, rhs, typ) =>
        val name = nameMangler.getOrElse(rhs, rhs)
        compileExpression(lhs, ctx) -->
          (LOAD_ATTR, ctx.name(name.toPy))

      case IST_Application(lhs, args, typ) =>
        compileExpression(lhs, ctx) -->
          args.flatMap(arg => compileExpression(arg, ctx)) -->
          (CALL_FUNCTION, args.length.toByte)

      case literal: IST_Literal =>
        BytecodeList((LOAD_CONST, ctx.const(literal.py)))

      case block: IST_Block => compileBlock(block, ctx)

      case IST_Name(_name, location) =>
        val name = nameMangler.getOrElse(_name, _name)
        import com.freddieposer.scaly.typechecker.types.SymbolSource._
        location.source match {
          case LOCAL | LOCAL_WRITABLE =>
            BytecodeList((LOAD_FAST, ctx.varname(name.toPy)))
          case MEMBER | MEMBER_WRITABLE =>
            BytecodeList(
              (LOAD_FAST, ctx.varname(THIS_NAME)),
              (LOAD_ATTR, ctx.name(name.toPy))
            )
          case GLOBAL =>
            BytecodeList((LOAD_GLOBAL, ctx.name(name.toPy)))
          case THIS =>
            BytecodeList((LOAD_NAME, ctx.varname(THIS_NAME)))

        }
      //TODO: This could simply be rewritten to be a function application?
      case IST_New(name, args, typ) => BytecodeList(
        (LOAD_GLOBAL, ctx.name(name.toPy)),
        (CALL_FUNCTION, 0.toByte)
      )

      case IST_Assignment(_name, location, rhs) =>
        val name = nameMangler.getOrElse(_name, _name)
        import com.freddieposer.scaly.typechecker.types.SymbolSource._
        compileExpression(rhs, ctx) --> (location.source match {
          case LOCAL_WRITABLE => (STORE_FAST, ctx.varname(name.toPy)).toBCL
          case MEMBER_WRITABLE => BytecodeList(
            (LOAD_FAST, ctx.varname(THIS_NAME)),
            (STORE_ATTR, ctx.name(name.toPy))
          )
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
    }
  }

  //Currently doesn't return - should be managed by compileFunction
  def compileBlock(block: IST_Block, ctx: CompilationContext): BytecodeList = {
    //TODO: Currently everything leaves something on the stack - could be more efficient if it didn't
    new BytecodeList(block.statements.map {
      case expr: IST_Expression => compileExpression(expr, ctx) --> (~POP_TOP).toBCL
      //TODO: Blocks can contain defs
      case m: IST_Member => m match {
        case IST_Def(id, params, expr, typ) => ???
        case IST_Val(id, expr, typ) =>
          compileExpression(expr, ctx) --> (STORE_FAST, ctx.varname(id.toPy))
        case IST_Var(id, expr, typ) =>
          compileExpression(expr, ctx) --> (STORE_FAST, ctx.varname(id.toPy))
      }
      //TODO: We need to be popping items off the stack here but we can only do this IF they add things
      // thus all functions NEED to return a PY_NONE if they don't return something else!
    }.foldLeft(BytecodeList.empty)(_ --> _).dropRight(1).toList)
  }


  private def TestCaddy(ctx: CompilationContext): BytecodeList = {
    import PyOpcodes._
    BytecodeList(
      (LOAD_NAME, ctx.name("print".toPy)),
      (LOAD_NAME, ctx.name("Main".toPy)),
      (LOAD_METHOD, ctx.name("main".toPy).toByte),
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


}
