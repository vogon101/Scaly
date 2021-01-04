package com.freddieposer.scaly.backend.internal

import com.freddieposer.scaly.backend.CompilationContext
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes.{LOAD_CONST, PyOpcode, RETURN_VALUE}
import com.freddieposer.scaly.backend.pyc.{PyAscii, PyInt, PyNone}

object CodeGenerationUtils {

  implicit class StringPyConverter(val value: String) {
    def toPy: PyAscii = new PyAscii(value)
  }

  implicit class IntPyConverter(val value: Int) {
    def toPy: PyInt = new PyInt(value)
  }

  def ReturnNone(ctx: CompilationContext): BytecodeList = BytecodeList(
    (LOAD_CONST, ctx.const(PyNone)), (RETURN_VALUE, 0.toByte)
  )

  sealed abstract class Bytecode {

    val length: Int

    def toBCL: BytecodeList = BytecodeList(this)

    override def toString: String = f"BC($length)"

  }

  implicit class BytecodeByte(val value: Byte) extends Bytecode {
    override val length: Int = 1
  }

  object BytecodeByte {
    def apply(value: Byte): BytecodeByte = new BytecodeByte(value)

    def unapply(arg: BytecodeByte): Option[Byte] = Some(arg.value)
  }

  implicit class BytecodeOpcode(val t: (PyOpcode, Byte)) extends Bytecode {
    override val length: Int = 2

    override def toString: String = f"BC(${t._1}, ${t._2})"
  }

  object BytecodeOpcode {
    def apply(o: PyOpcode, a: Byte): BytecodeOpcode = new BytecodeOpcode((o, a))

    def unapply(arg: BytecodeOpcode): Option[(PyOpcode, Byte)] = Some(arg.t)
  }

  implicit class BytecodeOpcodeWithMarker(val t: (PyOpcode, BytecodeMarker)) extends Bytecode {
    override val length: Int = 2

    override def toString: String = f"BC(${t._1}, ${t._2})"
  }

  object BytecodeOpcodeWithMarker {
    def apply(op: PyOpcode, m: BytecodeMarker): BytecodeOpcodeWithMarker = new BytecodeOpcodeWithMarker(op, m)

    def unapply(arg: BytecodeOpcodeWithMarker): Option[(PyOpcode, BytecodeMarker)] = Some(arg.t)
  }

  sealed abstract class BytecodeMarker extends Bytecode {
    override val length: Int = 0

    override def equals(that: Any): Boolean = that match {
      case obj: BytecodeMarker => this eq obj
      case _ => false
    }
  }

  class BytecodeAbsoluteMarker extends BytecodeMarker

  class BytecodeRelativeMarker extends BytecodeMarker

  object Marker {
    def absolute: BytecodeMarker = new BytecodeAbsoluteMarker

    def relative: BytecodeMarker = new BytecodeRelativeMarker
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


}
