package com.freddieposer.scaly.backend.pyc

import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets

import com.freddieposer.scaly.backend.pyc.utils.{ByteArrayStream, RefList}
import com.freddieposer.scaly.utils.PrettyPrinter

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

abstract class PyObject extends PrettyPrinter {

  def shortName: String = getClass.toString

}

object PyObject {

  import defs.PycTypeBytes._

  def read_object()(implicit data: ByteArrayStream, refList: RefList): PyObject = {

    val hd = data.head() & 0xff
    val flag = hd & FLAG_REF
    val typ = hd & ~FLAG_REF

    typ match {
      // Do not go on reflist
      case TYPE_NONE => PyNone
      case TYPE_TRUE => PyTrue
      case TYPE_FALSE => PyFalse
      case TYPE_REF => readRef()

      //Deal with reflist themselves
      case TYPE_CODE => PyCodeObject.read_pycode(flag)
      case TYPE_SMALL_TUPLE => PyTuple.readPyTuple(flag, isSmall = true)
      case TYPE_TUPLE => PyTuple.readPyTuple(flag)

      // Reflist after creation
      case _ =>
        val retval = typ match {
          case TYPE_STRING => PyString.readPyString()
          case TYPE_SHORT_ASCII | TYPE_SHORT_ASCII_INTERNED => PyAscii.readPyAscii(isSmall = true)
          case TYPE_ASCII | TYPE_ASCII_INTERNED => PyAscii.readPyAscii()
          case TYPE_INT => PyInt.readPyInt()
          case _ => throw new Error(s"Unknown object type ${typ.toHexString} (${typ.toChar})")
        }
        refList.append(retval, flag)
    }

  }

  def readRef()(implicit data: ByteArrayStream, refList: RefList): PyObject = {
    val r = data.bReadLong()
    val o = refList(r)
    if (o == PyNone) throw new Error(s"Bad reference ${r}")
    o
  }

}

abstract class PyBoolean(val value: Boolean) extends PyObject

object PyTrue extends PyBoolean(true)

object PyFalse extends PyBoolean(false)

object PyNone extends PyObject {
  override def toString: String = "PyNone"

  override def shortName: String = toString
}


class PyString(val str: List[Byte]) extends PyObject {
  override def toString: String = str.map(x => f"$x%02x").grouped(4).map(_.mkString(" ")).mkString("\n")

  override def shortName: String = f"PyString($as_text})"

  def as_text: String = new String(str.grouped(2).flatMap(_.reverse).map(_.toChar).toArray)

  def as_ints: List[Int] = str.map(_ & 0xff)

}

object PyString {

  def readPyString()(implicit data: ByteArrayStream): PyString = {
    val length = data.bReadLong()
    new PyString(data.take_bytes(length))
  }

}


class PyAscii(val text: String) extends PyObject {
  override def toString: String = f"PyAscii( $text )"

  override def shortName: String = toString
}

object PyAscii {

  def readPyAscii(isSmall: Boolean = false)(implicit data: ByteArrayStream): PyAscii = {
    val length = if (isSmall) data.head() else data.bReadLong()
    new PyAscii(new String(data.take(length).map(_.toChar).toArray))
  }

}

class PyInt(val value: Int) extends PyObject {
  override def toString: String = f"PyInt($value)"

  override def shortName: String = toString
}

object PyInt {

  def readPyInt()(implicit data: ByteArrayStream): PyInt = {
    new PyInt(data.bReadLong())
  }

}