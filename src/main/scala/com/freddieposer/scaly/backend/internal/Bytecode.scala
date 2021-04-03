package com.freddieposer.scaly.backend.internal

import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes.PyOpcode

sealed abstract class Bytecode {

  val length: Int

  final override def equals(that: Any): Boolean = that match {
    case bc: Bytecode => this eq bc
    case _ => false
  }

  override def toString: String = f"BC($length)"

  def r: RawISTExpr = RawISTExpr(this.toBCL)

  def toBCL: BytecodeList = BytecodeList(this)

}

object Bytecode {

  implicit class BytecodeByte(val value: Byte) extends Bytecode {
    override val length: Int = 1
  }

  sealed abstract class BytecodeMarker extends Bytecode {
    override val length: Int = 0
  }

  implicit class BytecodeOpcode(val t: (PyOpcode, Byte)) extends Bytecode {
    override val length: Int = 2

    override def toString: String = f"BC(${t._1}, ${t._2})"
  }

  class BytecodeAbsoluteMarker extends BytecodeMarker {
    override def toString: String = s"BCM{A} + ${hashCode()}"
  }

  implicit class BytecodeOpcodeWithMarker(val t: (PyOpcode, BytecodeMarker)) extends Bytecode {
    override val length: Int = 4

    override def toString: String = f"BC(${t._1}, ${t._2})"
  }

  class BytecodeRelativeMarker extends BytecodeMarker {
    override def toString: String = s"BCM{R} + ${hashCode()}"
  }

  object BytecodeByte {
    def apply(value: Byte): BytecodeByte = new BytecodeByte(value)

    def unapply(arg: BytecodeByte): Option[Byte] = Some(arg.value)
  }

  object BytecodeOpcode {
    def apply(o: PyOpcode, a: Byte): BytecodeOpcode = new BytecodeOpcode((o, a))

    def unapply(arg: BytecodeOpcode): Option[(PyOpcode, Byte)] = Some(arg.t)
  }

  object BytecodeOpcodeWithMarker {
    def apply(op: PyOpcode, m: BytecodeMarker): BytecodeOpcodeWithMarker = new BytecodeOpcodeWithMarker(op, m)

    def unapply(arg: BytecodeOpcodeWithMarker): Option[(PyOpcode, BytecodeMarker)] = Some(arg.t)
  }

  object BytecodeMarker {
    def absolute: BytecodeMarker = new BytecodeAbsoluteMarker

    def relative: BytecodeMarker = new BytecodeRelativeMarker
  }

}

