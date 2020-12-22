package com.freddieposer.scaly.backend.pyc

import com.freddieposer.scaly.backend.pyc.defs.PycTypeBytes
import com.freddieposer.scaly.backend.pyc.utils.{ByteArrayStream, RefList}
import com.freddieposer.scaly.utils.PrettyPrinter


abstract class PyObject extends PrettyPrinter {

  def shortName: String = getClass.toString

  def toBytes: ByteArrayStream

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
          case _ => throw new Error(s"Unknown object type ${typ.toHexString} (${typ.toChar} / ${data.offset.toHexString})")
        }
        refList.append(retval, flag)
    }

  }

  def readRef()(implicit data: ByteArrayStream, refList: RefList): PyObject = {
    val r = data.readLong()
    val o = refList(r)
    if (o == PyNone) throw new Error(s"Bad reference ${r}")
    o
  }

}

abstract class PyBoolean(val value: Boolean) extends PyObject {
  override def toString: String = s"Py${value.toString}"
}

object PyTrue extends PyBoolean(true) {
  override def toBytes: ByteArrayStream = ByteArrayStream(PycTypeBytes.TYPE_TRUE)
}

object PyFalse extends PyBoolean(false) {
  override def toBytes: ByteArrayStream = ByteArrayStream(PycTypeBytes.TYPE_FALSE)
}

object PyNone extends PyObject {
  override def toString: String = "PyNone"

  override def shortName: String = toString

  override def toBytes: ByteArrayStream = ByteArrayStream(PycTypeBytes.TYPE_NONE)
}


class PyString(val str: List[Byte]) extends PyObject {
  override def toString: String = str.map(x => f"$x%02x").grouped(4).map(_.mkString(" ")).mkString("\n")

  override def shortName: String = f"PyString($as_text})"

  def as_text: String = new String(str.grouped(2).flatMap(_.reverse).map(_.toChar).toArray)

  def as_ints: List[Int] = str.map(_ & 0xff)

  def ->(that: PyString) = new PyString(str ++ that.str)

  def -->(those: Iterable[PyString]): PyString =
    new PyString(str ++ those.flatMap(_.str))

  override def toBytes: ByteArrayStream =
    ByteArrayStream(PycTypeBytes.TYPE_STRING) + ByteArrayStream.fromLongs(str.length) + ByteArrayStream(str)
}

object PyString {

  def readPyString()(implicit data: ByteArrayStream): PyString = {
    val length = data.readLong()
    new PyString(data.take_bytes(length))
  }

  lazy val empty = new PyString(Nil)

}


class PyAscii(val text: String) extends PyObject {
  override def toString: String = f"PyAscii( $text )"

  override def shortName: String = toString

  override def toBytes: ByteArrayStream =
    (
      if (text.length < 255)
        ByteArrayStream(PycTypeBytes.TYPE_SHORT_ASCII) + ByteArrayStream((text.length & 0xff).toByte)
      else
        ByteArrayStream(PycTypeBytes.TYPE_ASCII) + ByteArrayStream.fromLongs(text.length)
      ) + ByteArrayStream(text.toCharArray)

  override def equals(obj: Any): Boolean = obj match {
    case a: PyAscii => text equals a.text
    case _ => false
  }
}

object PyAscii {

  def apply(text: String): PyAscii = new PyAscii(text)

  def readPyAscii(isSmall: Boolean = false)(implicit data: ByteArrayStream): PyAscii = {
    val length = if (isSmall) data.head() else data.readLong()
    new PyAscii(new String(data.take(length).map(_.toChar).toArray))
  }

}

class PyInt(val value: Int) extends PyObject {
  override def toString: String = f"PyInt($value)"

  override def shortName: String = toString

  override def toBytes: ByteArrayStream =
    ByteArrayStream(PycTypeBytes.TYPE_INT) + ByteArrayStream.fromLongs(value)

  override def equals(obj: Any): Boolean = obj match {
    case a: PyInt => value equals a.value
    case _ => false
  }
}

object PyInt {

  def readPyInt()(implicit data: ByteArrayStream): PyInt = {
    new PyInt(data.readLong())
  }

}