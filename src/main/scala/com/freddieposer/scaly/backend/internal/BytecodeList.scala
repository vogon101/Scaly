package com.freddieposer.scaly.backend.internal

import com.freddieposer.scaly.backend.internal.Bytecode._
import com.freddieposer.scaly.backend.pyc.PyString
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes.EXTENDED_ARG

class BytecodeList(val bytecodes: List[Bytecode]) extends Iterable[Bytecode] {

  /**
   * Compile this to bytes for use as code in a PyCodeObject
   *
   * @return
   */
  def compile: PyString =
    new PyString(bytecodes.flatMap {
      case BytecodeByte(value) => List(value)
      case _: BytecodeMarker => Nil
      case BytecodeOpcode(op, arg) => List(op.byte, arg)
      case bc@BytecodeOpcodeWithMarker(op, marker) =>
        val value = marker match {
          case m: BytecodeAbsoluteMarker =>
            bytecodes
              .takeWhile(_ ne m)
              .foldRight(0)(_.length + _)
          case m: BytecodeRelativeMarker =>
            bytecodes
              .dropWhile(_ ne bc)
              .drop(1)
              .takeWhile(_ ne m)
              .foldRight(0)(_.length + _)
        }

        List(EXTENDED_ARG.byte, ((value >> 8) & 0xff).toByte, op.byte, (value & 0xff).toByte)

    })


  override def iterator: Iterator[Bytecode] = bytecodes.iterator

  def -->(bs: BytecodeList): BytecodeList =
    new BytecodeList(bytecodes ++ bs.bytecodes)

  def -->(b: Bytecode): BytecodeList =
    new BytecodeList(bytecodes ++ (b :: Nil))

  def raw: RawISTExpr = RawISTExpr(this)

}

object BytecodeList {

  val empty = new BytecodeList(Nil)

  def apply(bs: Bytecode*): BytecodeList = new BytecodeList(bs.toList)

}
