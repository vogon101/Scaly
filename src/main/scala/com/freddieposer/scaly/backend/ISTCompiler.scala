package com.freddieposer.scaly.backend

import com.freddieposer.scaly.backend.internal._
import com.freddieposer.scaly.backend.pyc._
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes.{CALL_FUNCTION, CALL_METHOD, LOAD_METHOD, LOAD_NAME, POP_TOP, RETURN_VALUE}

class ISTCompiler(_filename: String) {

  import CodeGenerationUtils._

  private val filename = _filename.toPy

  private def withContext(f: CompilationContext => PyCodeObject): PyCodeObject = {
    val ctx = new CompilationContext
    f(ctx)
  }


  def compile(ist: IST_CompilationUnit): PyCodeObject = withContext { ctx =>

    val classes = ist.classes.map(compileClass(_, ctx))

    val code = {
      import PyOpcodes._
      buildCode(implicit a1 => implicit a2 => classes.flatMap { c =>
        List(
          ~LOAD_BUILD_CLASS,
          (LOAD_CONST, ctx.const(c)),
          (LOAD_CONST, ctx.const(c.name)),
          ~MAKE_FUNCTION,
          (LOAD_CONST, ctx.const(c.name)),
          (CALL_FUNCTION, 2.toByte),
          (STORE_NAME, ctx.name(c.name))
        )
      })
    } -> TestCaddy(ctx) -> ReturnNone(ctx)


    //    val varnames = ???
    //    val freeVars = ???
    //    val cellVars = ???
    val name = "<module>".toPy
    //    val lnotab = ???

    val stackSize: Int = 10 // ???

    new PyCodeObject(
      0, 0, 0, 0, stackSize, 64, 1,
      code, ctx.constants, ctx.names, PyTuple.empty, PyTuple.empty, PyTuple.empty, name, filename, new PyString(List())
    )
  }

  def compileClass(istClass: IST_Class, outerContext: CompilationContext): PyCodeObject = withContext { ctx =>

    val stackSize: Int = 10 // ???

    val functions = istClass.defMembers.map(t => compileFunction(t._1, t._2, ctx))
    import PyOpcodes._

    val code = {
      buildCode(implicit a1 => implicit a2 => List(
        (LOAD_NAME, ctx.name("__name__".toPy)),
        (STORE_NAME, ctx.name("__module__".toPy)),
        (LOAD_CONST, ctx.const(istClass.name.toPy)),
        (STORE_NAME, ctx.name("__qualname__".toPy))
      ))
    } --> functions.map(func => buildCode { implicit a1 =>
      implicit a2 =>
        List(
          (LOAD_CONST, ctx.const(func)),
          (LOAD_CONST, ctx.const(func.name)),
          (MAKE_FUNCTION, func.nargs.toByte),
          (STORE_NAME, ctx.name(func.name))
        )
    }) -> ReturnNone(ctx)

    new PyCodeObject(
      0, 0, 0, 0, stackSize, 64, 1,
      code, ctx.constants, ctx.names, PyTuple.empty, PyTuple.empty, PyTuple.empty, istClass.name.toPy, filename, new PyString(List())
    )

  }

  //Context should track max stack size
  def compileFunction(name: String, istFunction: IST_Function, outerContext: CompilationContext): PyCodeObject =
    withContext { ctx =>

      val stackSize = 10
      val nLocals = istFunction.args.length // TODO: + number of other locals

      val code = compileExpression(istFunction.body, ctx) -> buildCode(RETURN_VALUE)
      println(code.str)

      //TODO: Understand flags
      new PyCodeObject(istFunction.args.length, istFunction.args.length, 0, nLocals, stackSize, 67, 1,
        code, ctx.constants, ctx.names, PyTuple.empty, PyTuple.empty, PyTuple.empty, name.toPy, filename, PyString.empty)
    }

  def compileExpression(expression: IST_Expression, ctx: CompilationContext): PyString =
    buildCode { implicit a1 =>
      implicit a2 =>
        import PyOpcodes._
        expression match {
          case IST_Function(args, body) => ???
          case IST_FunctionCall(lhs, rhs) => ???
          case IST_If(cond, tBranch, fBranch) => ???
          case IST_Select(lhs, rhs) =>
            //TODO: This syntax is horrible
            useCode(compileExpression(lhs, ctx))
            //TODO: Not everything is a method!
            c(LOAD_METHOD, ctx.name(rhs.toPy))
          case IST_Application(lhs, args) =>
            useCode(compileExpression(lhs, ctx))
            args.foreach(arg => useCode(compileExpression(arg, ctx)))
            c(CALL_METHOD, args.length.toByte)
          case literal: IST_Literal => c(LOAD_CONST, ctx.const(literal.py))
          case block: IST_Block => useCode(compileBlock(block, ctx))
        }
    }

  //Currently doesn't return - should be managed by compileFunction
  def compileBlock(block: IST_Block, ctx: CompilationContext): PyString =
    block.statements.map {
      case expr: IST_Expression => compileExpression(expr, ctx)
        //TODO: Blocks can contain statements
      case _ => ???
    }.foldRight(PyString.empty)(_ -> _)


  private def TestCaddy(ctx: CompilationContext): PyString = buildCode { implicit a1 =>
    implicit a2 =>
      List(
        (LOAD_NAME, ctx.name("print".toPy)),
        (LOAD_NAME, ctx.name("Main".toPy)),
        (LOAD_METHOD, ctx.name("main".toPy).toByte),
        (CALL_METHOD, 0.toByte),
        (CALL_FUNCTION, 1.toByte),
        ~POP_TOP
      )
  }

}
