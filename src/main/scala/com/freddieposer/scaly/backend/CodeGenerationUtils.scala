package com.freddieposer.scaly.backend

import com.freddieposer.scaly.backend.pyc.{PyAscii, PyNone, PyObject, PyString}
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes.{LOAD_CONST, PyOpcode, RETURN_VALUE}

import scala.collection.mutable.ListBuffer

object CodeGenerationUtils {

  //TODO: Nicer system than this
  class R
  val r = new R

  def buildCode(f: (Byte => R) => (((PyOpcode, Byte)) => R) => List[R]): PyString = {
    val bytes: ListBuffer[Byte] = ListBuffer()

    def byteAdder(t: Byte): R = {
      bytes ++= List(t)
      r
    }

    def adderArg(t: (PyOpcode, Byte)): R = {
      bytes ++= List(t._1.byte, t._2)
      r
    }

    f(byteAdder)(adderArg)
    new PyString(bytes.toList)
  }

  def buildCode(o: PyOpcode): PyString = new PyString(List(o.byte, 0.toByte))

  def useCode(code: PyString)(implicit a1: Byte => R): List[R] = {
    code.str.map(a1)
  }

  abstract class PyConverter(val value: AnyVal) {
    def toPy: PyObject
  }

  implicit class StringPyConverter(val value: String) {
    def toPy: PyAscii = new PyAscii(value)
  }

  implicit class ExtendedOpcode(val opcode: PyOpcode) {
    def ~ : (PyOpcode, Byte) = (opcode, 0.toByte)

    def unary_~ : (PyOpcode, Byte) = (opcode, 0.toByte)
  }

  def c (opcode: PyOpcode, byte: Byte)(implicit a2: ((PyOpcode, Byte)) => R): List[R] = List(a2((opcode, byte)))

  implicit def NullByteAdder(opcode: PyOpcode): (PyOpcode, Byte) = (opcode, 0.toByte)

//  implicit def ListWrapper(r: R): List[R] = List(r)

  def ReturnNone(ctx: CompilationContext): PyString = new PyString(List(
    LOAD_CONST.byte, ctx.const(PyNone), RETURN_VALUE.byte, 0.toByte
  ))

}
