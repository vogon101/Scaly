package com.freddieposer.scaly.backend.pyc
import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets

import com.freddieposer.scaly.PrettyPrinter

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

abstract class PyObject extends PrettyPrinter{

  def shortName: String = getClass.toString

}

object PyObject {

  val TYPE_NULL            =   '0'
  val TYPE_NONE            =   'N'
  val TYPE_FALSE           =   'F'
  val TYPE_TRUE            =   'T'
  val TYPE_STOPITER        =   'S'
  val TYPE_ELLIPSIS        =   '.'
  val TYPE_INT             =   'i'
  /* TYPE_INT64 is not gene=rated anymore.
     Supported for backward= compatibility only. */
  val TYPE_INT64           =   'I'
  val TYPE_FLOAT           =   'f'
  val TYPE_BINARY_FLOAT    =   'g'
  val TYPE_COMPLEX         =   'x'
  val TYPE_BINARY_COMPLEX  =   'y'
  val TYPE_LONG            =   'l'
  val TYPE_STRING          =   's'
  val TYPE_INTERNED        =   't'
  val TYPE_REF             =   'r'
  val TYPE_TUPLE           =   '('
  val TYPE_LIST            =   '['
  val TYPE_DICT            =   '{'
  val TYPE_CODE            =   'c'
  val TYPE_UNICODE         =   'u'
  val TYPE_UNKNOWN         =   '?'
  val TYPE_SET             =   '<'
  val TYPE_FROZENSET       =   '>'
  val FLAG_REF: Char       =   0x80/* with a type, add obj to index */

  val TYPE_ASCII           =   'a'
  val TYPE_ASCII_INTERNED  =   'A'
  val TYPE_SMALL_TUPLE     =   ')'
  val TYPE_SHORT_ASCII     =   'z'
  val TYPE_SHORT_ASCII_INTERNED = 'Z'

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
    //println(s"$r -> $o")
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


class PyString (val str: List[Byte]) extends PyObject {
  override def toString: String = str.map(x => f"$x%02x").grouped(4).map(_.mkString(" ")).mkString("\n")

  override def shortName: String = f"PyString($as_text})"
  def as_text:String = new String(str.grouped(2).flatMap(_.reverse).map(_.toChar).toArray)

  def as_ints: List[Int] = str.map(_ & 0xff)

}

object PyString {

  def readPyString()(implicit data: ByteArrayStream): PyString = {
    val length = data.bReadLong()
    new PyString(data.take_bytes(length))
  }

}

//Mutable to allow it to be in ref-list whilst being built
class PyTuple (private var _objectsBuffer: ListBuffer[PyObject]) extends PyObject {

  override def prettyPrint(indent: Int): String = _prettyPrint(indent)

  override def shortName: String = f"PyTuple(n=${objects.length})"

  override def toString: String = prettyPrint(0)

  def objects: List[PyObject] = _objectsBuffer.toList


  def _prettyPrint(indent: Int): String = {
    val inner = objects.zipWithIndex.map{ case (s, i) => i.toString + s.prettyPrint(1)}.mkString("\t\n")
    f"""
       |PyTuple (${objects.length}):
       |$inner
       |""".stripMargin.split("\n").mkString("\n" + "\t".repeat(indent)).substring(2)
  }

}

object PyTuple {

  def readPyTuple(flag: Int, isSmall: Boolean = false)(implicit data: ByteArrayStream, refList: RefList): PyTuple = {
    val length = if (isSmall) data.head() else data.bReadLong()
    val itemsBuffer = new ListBuffer[PyObject]
    val pt = new PyTuple(itemsBuffer)
    refList.append(pt, flag)
    for (o <- Range(0, length))
      itemsBuffer.append(PyObject.read_object())
    pt
  }

}

class PyAscii (val text: String) extends PyObject {
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