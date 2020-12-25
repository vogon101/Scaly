package com.freddieposer.scaly.backend.internal

import com.freddieposer.scaly.backend.internal.CodeGenerationUtils.{Bytecode, BytecodeAbsoluteMarker, BytecodeByte, BytecodeMarker, BytecodeOpcode, BytecodeOpcodeWithMarker, BytecodeRelativeMarker}
import com.freddieposer.scaly.backend.pyc.PyString

class BytecodeList(val bytecodes: List[Bytecode]) extends Iterable[Bytecode] {

  /**
   * Compile this to bytes for use as code in a PyCodeObject
   *
   * @return
   */
  def compile: PyString =
    new PyString(bytecodes.flatMap { bc =>
      bc match {
        case BytecodeByte(value) => List(value)
        case _: BytecodeMarker => Nil
        case BytecodeOpcode(op, arg) => List(op.byte, arg)
        case BytecodeOpcodeWithMarker(op, marker) =>
          List(op.byte, marker match {
            case m: BytecodeAbsoluteMarker =>
              bytecodes
                .takeWhile(_ != m)
                .foldRight(0)(_.length + _)
                .toByte
            case m: BytecodeRelativeMarker =>
              (bytecodes
                .dropWhile(_ != bc)
                .drop(1)
                .takeWhile(_ != m)
                .foldRight(0)(_.length + _)
                ).toByte
          })
      }
    })


  override def iterator: Iterator[Bytecode] = bytecodes.iterator

  def -->(bs: BytecodeList): BytecodeList =
    new BytecodeList(bytecodes ++ bs.bytecodes)

  def -->(b: Bytecode): BytecodeList =
    new BytecodeList(bytecodes ++ (b :: Nil))

}

object BytecodeList {

  def apply(bs: Bytecode*): BytecodeList = new BytecodeList(bs.toList)

  val empty = new BytecodeList(Nil)

}
