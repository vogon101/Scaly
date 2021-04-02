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

    final override def equals(that: Any): Boolean = that match {
      case bc: Bytecode => this eq bc
      case _ => false
    }

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

    def r: RawISTExpr = RawISTExpr(this.toBCL)
  }

  object BytecodeOpcode {
    def apply(o: PyOpcode, a: Byte): BytecodeOpcode = new BytecodeOpcode((o, a))

    def unapply(arg: BytecodeOpcode): Option[(PyOpcode, Byte)] = Some(arg.t)
  }

  implicit class BytecodeOpcodeWithMarker(val t: (PyOpcode, BytecodeMarker)) extends Bytecode {
    override val length: Int = 4

    override def toString: String = f"BC(${t._1}, ${t._2})"
  }

  object BytecodeOpcodeWithMarker {
    def apply(op: PyOpcode, m: BytecodeMarker): BytecodeOpcodeWithMarker = new BytecodeOpcodeWithMarker(op, m)

    def unapply(arg: BytecodeOpcodeWithMarker): Option[(PyOpcode, BytecodeMarker)] = Some(arg.t)
  }

  sealed abstract class BytecodeMarker extends Bytecode {
    override val length: Int = 0
  }

  class BytecodeAbsoluteMarker extends BytecodeMarker {
    override def toString: String = s"BCM{A} + ${hashCode()}"
  }

  class BytecodeRelativeMarker extends BytecodeMarker {
    override def toString: String = s"BCM{R} + ${hashCode()}"
  }

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

  implicit class ExtendedListOfRawISTs(rists: List[RawISTExpr]) {
    def flat: RawISTExpr = RawISTExpr(rists.map(_.bcl).flat)
  }

  implicit class ExtendedListOfISTSequence(istseqs: List[IST_Sequence]) {
    def flat: IST_Sequence = IST_Sequence(istseqs.flatMap(_.statements), istseqs.last.typ)
  }

  implicit class ExtendedIST_Statement(expr: IST_Expression) {

    def + (that: IST_Expression): IST_Sequence = expr match {
      case IST_Sequence(stats, typ) => IST_Sequence(stats ::: List(that), that.typ)
      case _ => that match {
        case IST_Sequence(stats, typ) => IST_Sequence(expr :: stats, typ)
        case _ => IST_Sequence(expr :: that :: Nil, that.typ)
      }
    }

    def + (that: (PyOpcode, Byte)): IST_Sequence = this + that.r

  }

}
