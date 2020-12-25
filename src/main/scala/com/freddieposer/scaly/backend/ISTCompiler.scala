package com.freddieposer.scaly.backend

import com.freddieposer.scaly.backend.internal._
import com.freddieposer.scaly.backend.pyc._
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes.POP_TOP

class ISTCompiler(_filename: String) {

  import CodeGenerationUtils._

  private val filename = _filename.toPy

  val THIS_NAME = "_this"

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

    val code: BytecodeList = {
      import PyOpcodes._
      classes.flatMap { c =>
        BytecodeList(
          ~LOAD_BUILD_CLASS,
          (LOAD_CONST, ctx.const(c)),
          (LOAD_CONST, ctx.const(c.name)),
          ~MAKE_FUNCTION,
          (LOAD_CONST, ctx.const(c.name)),
          (CALL_FUNCTION, 2.toByte),
          (STORE_NAME, ctx.name(c.name))
        )
      }
    } --> TestCaddy(ctx) --> ReturnNone(ctx)


    //    val varnames = ???
    //    val freeVars = ???
    //    val cellVars = ???
    val name = "<module>".toPy
    //    val lnotab = ???

    val stackSize: Int = 10 // ???

    new PyCodeObject(
      0, 0, 0, 0, stackSize, 64, 1,
      code.compile, ctx.constants, ctx.names, PyTuple.empty, PyTuple.empty, PyTuple.empty, name, filename, new PyString(List())
    )
  }

  def compileClass(istClass: IST_Class, outerContext: CompilationContext): PyCodeObject = withContext { ctx =>

    val stackSize: Int = 10 // ???

    val tmp: Map[String, IST_Def] = istClass.members.flatMap {
      case d: (String, IST_Def) => Some(d)
      case _ => None
    }


    val functions = {
      //TODO: Actual objects
      if (istClass.name == "Main")
        tmp.map(t => compileFunction(t._1, t._2.func, ctx))
      else ctx.withClass {
        tmp.map(t => compileFunction(t._1, t._2.func, ctx))
      }
    }

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
      code.compile, ctx.constants, ctx.names, PyTuple.empty, PyTuple.empty, PyTuple.empty, istClass.name.toPy, filename, new PyString(List())
    )

  }

  //Context should track max stack size
  def compileFunction(_name: String, istFunction: IST_Function, outerContext: CompilationContext): PyCodeObject =
    withContext { ctx =>
      import PyOpcodes.RETURN_VALUE
      val name = nameMangler.getOrElse(_name, _name)

      val (nOtherLocals, nargs, localNames) = if (outerContext.inClass) (
        0,
        istFunction.args.length + 1,
        THIS_NAME :: istFunction.args
      ) else (
        0,
        istFunction.args.length,
        istFunction.args
      )

      localNames.foreach(n => ctx.varname(n.toPy))

      val stackSize = 10
      // TODO: + number of other locals

      val code: BytecodeList =
        compileExpression(istFunction.body, ctx) --> ~RETURN_VALUE

      //TODO: Understand flags
      PyCodeObject(
        ctx, code.compile, name.toPy, filename, nargs, istFunction.args.length,
        nOtherLocals + nargs, stackSize, 67, varnames = PyTuple(localNames.map(_.toPy))
      )
    }

  def compileExpression(expression: IST_Expression, ctx: CompilationContext): BytecodeList = {
    println(expression)
    import PyOpcodes._
    expression match {
      case IST_Function(args, body, typ) => ???
      //      case IST_FunctionCall(lhs, rhs) => ???
      case IST_If(cond, tBranch, Some(fBranch), typ) =>
        val falseMarker = Marker.absolute
        val endMarker = Marker.relative
        compileExpression(cond, ctx) -->
          (POP_JUMP_IF_FALSE, falseMarker) -->
          compileExpression(tBranch, ctx) -->
          //          ~POP_TOP -->
          (JUMP_FORWARD, endMarker) -->
          falseMarker -->
          compileExpression(fBranch, ctx) --> endMarker
      case IST_If(cond, tBranch, None, typ) =>
        val endMarker = Marker.absolute
        compileExpression(cond, ctx) -->
          (POP_JUMP_IF_FALSE, endMarker) -->
          compileExpression(tBranch, ctx) -->
          //          ~POP_TOP -->
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
          case LOCAL =>
            BytecodeList((LOAD_FAST, ctx.varname(name.toPy)))
          case MEMBER =>
            BytecodeList(
              (LOAD_FAST, ctx.varname(THIS_NAME.toPy)),
              (LOAD_ATTR, ctx.name(name.toPy))
            )
          case GLOBAL =>
            BytecodeList((LOAD_GLOBAL, ctx.name(name.toPy)))
          case THIS =>
            BytecodeList((LOAD_NAME, ctx.varname(THIS_NAME.toPy)))

        }
      //TODO: This could simply be rewritten to be a function application?
      case IST_New(name, args, typ) => BytecodeList(
        (LOAD_GLOBAL, ctx.name(name.toPy)),
        (CALL_FUNCTION, 0.toByte)
      )

    }
  }

  //Currently doesn't return - should be managed by compileFunction
  def compileBlock(block: IST_Block, ctx: CompilationContext): BytecodeList =
    block.statements.map {
      case expr: IST_Expression => compileExpression(expr, ctx)
      //TODO: Blocks can contain statements
      case _ => ???
      //    }.foldRight(BytecodeList.empty)(_ --> _)

      //TODO: We need to be popping items off the stack here but we can only do this IF they add things
      // thus all functions NEED to return a PY_NONE if they don't return something else!
    }.flatMap(_ :: (~POP_TOP).toBCL :: Nil)
      .dropRight(1).foldLeft(BytecodeList.empty)(_ --> _)


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


}
