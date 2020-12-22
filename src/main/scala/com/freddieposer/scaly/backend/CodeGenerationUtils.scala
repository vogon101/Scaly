package com.freddieposer.scaly.backend

import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes.{LOAD_CONST, PyOpcode, RETURN_VALUE}
import com.freddieposer.scaly.backend.pyc.{PyAscii, PyNone, PyString}

import scala.collection.mutable.ListBuffer

object CodeGenerationUtils {

  implicit class StringPyConverter(val value: String) {
    def toPy: PyAscii = new PyAscii(value)
  }


//
//  def buildCode(f: (Byte => R) => (((PyOpcode, Byte)) => R) => List[R]): PyString = {
//    val bytes: ListBuffer[Byte] = ListBuffer()
//
//    def byteAdder(t: Byte): R = {
//      bytes ++= List(t)
//      r
//    }
//
//    def opAdder(t: (PyOpcode, Byte)): R = {
//      bytes ++= List(t._1.byte, t._2)
//      r
//    }
//
//    f(byteAdder)(opAdder)
//    new PyString(bytes.toList)
//  }
//
//  def buildCode(o: PyOpcode): PyString = new PyString(List(o.byte, 0.toByte))

//  def buildCode(f: List[Bytecode]): BytecodeList


//  def useCode(code: PyString)(implicit a1: Byte => R): List[R] = {
//    code.str.map(a1)
//  }


//  def c(opcode: PyOpcode, byte: Byte)(implicit a2: ((PyOpcode, Byte)) => R): List[R] = List(a2((opcode, byte)))

  def ReturnNone(ctx: CompilationContext): BytecodeList = BytecodeList(
    (LOAD_CONST, ctx.const(PyNone)), (RETURN_VALUE, 0.toByte)
  )

  sealed abstract class Bytecode {

    val length: Int

    def toBCL: BytecodeList = BytecodeList(this)

  }

  class BytecodeList(val bytecodes: List[Bytecode]) extends Iterable[Bytecode] {

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

    def --> (bs: BytecodeList): BytecodeList =
      new BytecodeList(bytecodes ++ bs.bytecodes)

    def --> (b: Bytecode): BytecodeList =
      new BytecodeList(bytecodes ++ (b :: Nil))

  }

  object BytecodeList {

    def apply(bs: Bytecode*): BytecodeList = new BytecodeList(bs.toList)
    val empty = new BytecodeList(Nil)

  }

  implicit class ExtendedOpcode(val opcode: PyOpcode) {
    def ~ : (PyOpcode, Byte) = (opcode, 0.toByte)

    def unary_~ : (PyOpcode, Byte) = (opcode, 0.toByte)
  }

  implicit def ListToBytecodeList(bs: List[Bytecode]): BytecodeList = new BytecodeList(bs)

  implicit class ExtendedIterableOfBytecodes(bs: Iterable[Bytecode]) {
    def toBCL: BytecodeList = new BytecodeList(bs.toList)
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
  }

  object BytecodeOpcode {
    def apply(o: PyOpcode, a: Byte): BytecodeOpcode = new BytecodeOpcode((o, a))
    def unapply(arg: BytecodeOpcode): Option[(PyOpcode, Byte)] = Some(arg.t)
  }

  implicit class BytecodeOpcodeWithMarker(val t: (PyOpcode, BytecodeMarker)) extends Bytecode {
    override val length: Int = 2
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

  //TODO: Relative forward and backwards?
  class BytecodeRelativeMarker extends BytecodeMarker

  object Marker {
    def absolute: BytecodeMarker = new BytecodeAbsoluteMarker
    def relative: BytecodeMarker = new BytecodeRelativeMarker
  }


}
