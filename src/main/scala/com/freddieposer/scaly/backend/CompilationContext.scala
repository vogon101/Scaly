package com.freddieposer.scaly.backend

import com.freddieposer.scaly.backend.internal.CodeGenerationUtils.StringPyConverter
import com.freddieposer.scaly.backend.pyc.{PyAscii, PyObject, PyTuple}

import scala.collection.mutable.ArrayBuffer

class CompilationContext {

  private val _constants: ArrayBuffer[PyObject] = ArrayBuffer()
  private val _names: ArrayBuffer[PyAscii] = ArrayBuffer()
  private val _varnames: ArrayBuffer[PyAscii] = ArrayBuffer()
  private val _cellvars: ArrayBuffer[PyAscii] = ArrayBuffer()
  private val _freevars: ArrayBuffer[PyAscii] = ArrayBuffer()



  private var _inClass: Boolean = false

  def inClass: Boolean = _inClass

  def withClass[T](f: => T): T = {
    val _old = _inClass
    _inClass = true
    val res = f
    _inClass = _old
    res
  }

  def withoutClass[T](f: => T): T = {
    val _old = _inClass
    _inClass = false
    val res = f
    _inClass = _old
    res
  }

  def constants: PyTuple = PyTuple(_constants.toList)

  def names: PyTuple = PyTuple(_names.toList)

  def varnames: PyTuple = PyTuple(_varnames.toList)

  def cellvars: PyTuple = PyTuple(_cellvars.toList)

  def freevars: PyTuple = PyTuple(_freevars.toList)

  def const(c: PyObject): Byte = _getter(c, _constants)

  def name(n: PyAscii): Byte = _getter(n, _names)

  def varname(n: PyAscii): Byte = _getter(n, _varnames)

  def cell(n: PyAscii): Byte = _getter(n, _cellvars)

  def free(n: PyAscii): Byte = (_getter(n, _freevars) + cellvars.length.toByte).toByte

  private def _getter[T](o: T, l: ArrayBuffer[T]): Byte = {

    val i = l.indexWhere(_ equals o)

    if (i == -1) {
      l.append(o)
      ((l.length - 1) & 0xff).toByte
    } else (i & 0xff).toByte

  }

  def isCellVar(n: String): Boolean = _cellvars.contains(n.toPy)

  def isFreeVar(n: String): Boolean = _freevars.contains(n.toPy)

  def isBoxed(n: String): Boolean = isCellVar(n) || isFreeVar(n)

  def freeOrCell(n: PyAscii): Byte =
    if (isCellVar(n.text)) cell(n)
    else free(n)

}
