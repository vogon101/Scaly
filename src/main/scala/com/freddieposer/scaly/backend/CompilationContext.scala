package com.freddieposer.scaly.backend

import com.freddieposer.scaly.backend.pyc.{PyAscii, PyObject, PyTuple}

import scala.collection.mutable.ArrayBuffer

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
