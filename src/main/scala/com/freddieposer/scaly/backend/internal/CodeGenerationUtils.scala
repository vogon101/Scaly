package com.freddieposer.scaly.backend.internal

import com.freddieposer.scaly.backend.internal.Bytecode._
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes.PyOpcode
import com.freddieposer.scaly.backend.pyc.{PyAscii, PyInt}

object CodeGenerationUtils {

  implicit class StringPyConverter(val value: String) {
    def toPy: PyAscii = new PyAscii(value)
  }

  implicit class IntPyConverter(val value: Int) {
    def toPy: PyInt = new PyInt(value)
  }

  implicit class ExtendedOpcode(val opcode: PyOpcode) {
    def ~ : (PyOpcode, Byte) = (opcode, 0.toByte)

    def unary_~ : (PyOpcode, Byte) = (opcode, 0.toByte)
  }

  implicit def ListToBytecodeList(bs: List[Bytecode]): BytecodeList = new BytecodeList(bs)

  implicit class ExtendedIterableOfBytecodes(bs: Iterable[Bytecode]) {
    def toBCL: BytecodeList = new BytecodeList(bs.toList)
  }

  implicit class ExtendedListOfBytecodeLists(bcls: List[BytecodeList]) {
    def flat: BytecodeList = bcls.foldLeft(BytecodeList.empty)(_ --> _)
  }

  implicit class ExtendedListOfRawISTs(rists: List[RawISTExpr]) {
    def flat: RawISTExpr = RawISTExpr(rists.map(_.bcl).flat)
  }

  implicit class ExtendedListOfISTSequence(istseqs: List[IST_Sequence]) {
    def flat: IST_Sequence = IST_Sequence(istseqs.flatMap(_.statements), istseqs.last.typ)
  }

  implicit class ExtendedIST_Statement(expr: IST_Expression) {

    def +(that: (PyOpcode, Byte)): IST_Sequence = this + that.r

    def +(that: IST_Expression): IST_Sequence = expr match {
      case IST_Sequence(stats, typ) => IST_Sequence(stats ::: List(that), that.typ)
      case _ => that match {
        case IST_Sequence(stats, typ) => IST_Sequence(expr :: stats, typ)
        case _ => IST_Sequence(expr :: that :: Nil, that.typ)
      }
    }

  }

}
