package com.freddieposer.scaly.backend.internal

import com.freddieposer.scaly.backend.CompilationContext
import com.freddieposer.scaly.backend.ISTCompiler.{GLOBAL_LAZY_PREFIX, THIS_NAME}
import com.freddieposer.scaly.backend.internal.Bytecode._
import com.freddieposer.scaly.backend.internal.CodeGenerationUtils._
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes.{LOAD_CONST, RETURN_VALUE, ROT_TWO}
import com.freddieposer.scaly.backend.pyc.{PyAscii, PyNone, PyTuple}
import com.freddieposer.scaly.typechecker.context.TypeContext.Location
import com.freddieposer.scaly.typechecker.types.SymbolSource
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType.{ScalyNothingType, ScalyStringType}

//TODO: Refactor this
object BytecodeSnippets {

  def ThrowException(message: PyAscii): IST_Sequence = {
    import PyOpcodes._
    IST_Application(
      IST_Name("Exception", Location(SymbolSource.GLOBAL)),
      List(IST_Literal(message, ScalyStringType)),
      ScalyNothingType
    ) + (RAISE_VARARGS, 1.toByte)
  }

  def PrintTopThree: IST_Sequence = {
    import PyOpcodes.ROT_THREE
    PrintString("TOS") + PrintTop +
      ~ROT_THREE + PrintString("TOS1") + PrintTop +
      ~ROT_THREE + PrintString("TOS2") + PrintTop + ~ROT_THREE
  }


  def PrintTop: IST_Sequence = {
    import PyOpcodes.{DUP_TOP, POP_TOP}
    (~DUP_TOP).r + IST_Application(IST_Name("print", Location(SymbolSource.GLOBAL)), List((~ROT_TWO).r), ScalyNothingType) + ~POP_TOP
  }

  def PrintString(str: String): IST_Sequence = {
    import PyOpcodes.POP_TOP
    IST_Application(IST_Name("print", Location(SymbolSource.GLOBAL)), List(IST_Literal(str.toPy, ScalyStringType)), ScalyNothingType) + ~POP_TOP
  }

  def loadThis(ctx: CompilationContext): Bytecode = {
    import PyOpcodes.{LOAD_DEREF, LOAD_FAST}
    if (ctx.isBoxed(THIS_NAME.text)) (LOAD_DEREF, ctx.freeOrCell(THIS_NAME))
    else (LOAD_FAST, ctx.varname(THIS_NAME))
  }


  def TestCaddy(ctx: CompilationContext): BytecodeList = {
    import PyOpcodes._
    BytecodeList(
      (LOAD_NAME, ctx.name("print".toPy)),
      (LOAD_NAME, ctx.name((GLOBAL_LAZY_PREFIX + "Main$").toPy)),
      (CALL_FUNCTION, 0.toByte),
      (LOAD_METHOD, ctx.name("main".toPy)),
      (CALL_METHOD, 0.toByte),
      (CALL_FUNCTION, 1.toByte),
      ~POP_TOP
    )
  }

  def ImportSTDLib(ctx: CompilationContext): BytecodeList = {
    import PyOpcodes._
    BytecodeList(
      (LOAD_CONST, ctx.const(0.toPy)),
      (LOAD_CONST, ctx.const(PyTuple(List("*".toPy)))),
      (IMPORT_NAME, ctx.name("pyScaly_lib".toPy)),
      ~IMPORT_STAR
    )
  }

  def ReturnNone(ctx: CompilationContext): BytecodeList = BytecodeList(
    (LOAD_CONST, ctx.const(PyNone)), (RETURN_VALUE, 0.toByte)
  )

}
