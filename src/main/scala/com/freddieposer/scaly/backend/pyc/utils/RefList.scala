package com.freddieposer.scaly.backend.pyc.utils

import com.freddieposer.scaly.backend.pyc.{PyNone, PyObject}

import scala.collection.mutable.ListBuffer


class RefList {

  private val _reflist = new ListBuffer[PyObject]

  def reserve(flag: Int): Int = {
    if (flag == 0) return 0
    val i = _reflist.length
    _reflist.append(PyNone)
    i
  }

  def insert[T <: PyObject](o: T, i: Int, flag: Int): T = {
    if (flag != 0) {
      _reflist(i) = o
    }
    o
  }

  def append[T <: PyObject](o: T, flag: Int): T = {
    if (flag != 0) {
      _reflist.append(o)
    }
    o
  }

  def apply(i: Int): PyObject = _reflist(i)

}
