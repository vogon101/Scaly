package com.freddieposer.scaly.backend

import com.freddieposer.scaly.backend.pyc.{PyAscii, PyObject, PyTuple}

import scala.collection.mutable.ArrayBuffer

class CompilationContext {

  private val _constants: ArrayBuffer[PyObject] = ArrayBuffer()
  private val _names: ArrayBuffer[PyAscii] = ArrayBuffer()
  private val _varnames: ArrayBuffer[PyAscii] = ArrayBuffer()

  private var _inClass: Boolean = false

  def inClass: Boolean = _inClass

  def withClass[T](f: => T): T = {
    _inClass = true
    val res = f
    _inClass = false
    res
  }

  def constants: PyTuple = PyTuple(_constants.toList)

  def names: PyTuple = PyTuple(_names.toList)

  def varnames: PyTuple = PyTuple(_varnames.toList)

  def const(c: PyObject): Byte = _getter(c, _constants)

  def name(n: PyAscii): Byte = _getter(n, _names)

  def varname(n: PyAscii): Byte = _getter(n, _varnames)

  private def _getter[T](o: T, l: ArrayBuffer[T]): Byte = {

    val i = l.indexWhere(_ equals o)

    if (i == -1) {
      l.append(o)
      ((l.length - 1) & 0xff).toByte
    } else (i & 0xff).toByte

  }

}
