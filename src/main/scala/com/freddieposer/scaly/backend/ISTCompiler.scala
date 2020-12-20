package com.freddieposer.scaly.backend

import com.freddieposer.scaly.backend.internal.{IST_Class, IST_CompilationUnit}
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes.PyOpcode
import com.freddieposer.scaly.backend.pyc.{PyAscii, PyCodeObject, PyNone, PyObject, PyString, PyTuple}

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

class ISTCompiler(_filename: String) {

  private val filename = _filename.toPy

  class CompilationContext {

    private val _constants: ArrayBuffer[PyObject] = ArrayBuffer()
    private val _names: ArrayBuffer[PyAscii] = ArrayBuffer()

    def constants: PyTuple = PyTuple(_constants.toList)
    def names: PyTuple = PyTuple(_names.toList)

    private def _getter[T](o: T, l: ArrayBuffer[T]): Byte = {

      val i = l.indexWhere(_ equals o)

      if (i == -1) {
        l.append(o)
        ((l.length - 1) & 0xff).toByte
      } else (i & 0xff).toByte

    }

    def const(c: PyObject): Byte = _getter(c, _constants)

    def name(n: PyAscii): Byte = _getter(n, _names)

  }


  def compile(ist: IST_CompilationUnit): PyCodeObject = {

    val ctx = new CompilationContext

    val classes = ist.classes.map(compileClass(_, ctx))

    val code = {
      import PyOpcodes._
      buildCode (implicit a1 => implicit a2 => classes.flatMap { c =>
        List(
          LOAD_BUILD_CLASS,
          (LOAD_CONST, ctx.const(c)),
          (LOAD_CONST, ctx.const(c.name)),
          MAKE_FUNCTION,
          (LOAD_CONST, ctx.const(c.name)),
          (CALL_FUNCTION, 2.toByte),
          (STORE_NAME, ctx.name(c.name)),
          (LOAD_CONST, ctx.const(PyNone)),
          RETURN_VALUE
        )
      })
    }


//    val varnames = ???
//    val freeVars = ???
//    val cellVars = ???
    val name = "<module>".toPy
//    val lnotab = ???

    val stackSize: Int = 10 // ???

    new PyCodeObject(
      0, 0, 0, 0, stackSize, 64, 1,
      code, ctx.constants, ctx.names, PyTuple.empty, PyTuple.empty, PyTuple.empty, name, filename, new PyString(List())
    )
  }

  def compileClass(istClass: IST_Class, outerContext: CompilationContext): PyCodeObject = {


    val stackSize: Int = 10 // ???

    val ctx: CompilationContext = new CompilationContext

    val code = {
      import PyOpcodes._
      buildCode ( implicit a1 => implicit a2 => List(
        (LOAD_NAME, ctx.name("__name__".toPy)),
        (STORE_NAME, ctx.name("__module__".toPy)),
        (LOAD_CONST, ctx.const(istClass.name.toPy)),
        (STORE_NAME, ctx.name("__qualname__".toPy)),
        (LOAD_CONST, ctx.const(PyNone)),
        RETURN_VALUE
      ))
    }

    new PyCodeObject(
      0, 0, 0, 0, stackSize, 64, 1,
      code, ctx.constants, ctx.names, PyTuple.empty, PyTuple.empty, PyTuple.empty, istClass.name.toPy, filename, new PyString(List())
    )

  }

  private class R
  private val r = new R

  def buildCode(f: (PyOpcode => R) => (((PyOpcode, Byte)) => R) => List[R]): PyString = {
    val bytes: ListBuffer[Byte] = ListBuffer()
    def adder(opcode: PyOpcode): R  = {
      bytes ++= List(opcode.byte, 0.toByte)
      r
    }
    def adderArg(t: (PyOpcode, Byte)): R = {
      bytes ++= List(t._1.byte, t._2)
      r
    }
    f(adder)(adderArg)
    new PyString(bytes.toList)
  }

  abstract class PyConverter(val value: AnyVal) {
    def toPy: PyObject
  }

  implicit class StringPyConverter(val value: String) {
    def toPy: PyAscii = new PyAscii(value)
  }

}
