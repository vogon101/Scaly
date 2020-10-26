package com.freddieposer.scaly.backend.pyc
import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets

import com.freddieposer.scaly.PrettyPrinter

sealed abstract class PyObject extends PrettyPrinter{

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

  def read_object()(implicit data: ByteArrayStream): PyObject = {
    val hd = data.head() & 0xff
    val typ = hd & ~FLAG_REF
    //print(f"${data.offset - 1}%04d ${typ.toHexString} (${typ.toChar}) ")
    typ match {
      case TYPE_NONE => PyNone
      case TYPE_TRUE => PyTrue
      case TYPE_FALSE => PyFalse
      case TYPE_REF => PyRef.read_pyref()
      case TYPE_STRING => PyString.read_pystring()
      case TYPE_SHORT_ASCII | TYPE_SHORT_ASCII_INTERNED => PyAscii.read_pyascii(isSmall = true)
      case TYPE_ASCII | TYPE_ASCII_INTERNED => PyAscii.read_pyascii()
      case TYPE_INT => PyInt.read_pyInt()
      case TYPE_SMALL_TUPLE => PyTuple.read_pytuple(isSmall = true)
      case TYPE_TUPLE => PyTuple.read_pytuple()
      case TYPE_CODE => PyCodeObject.read_pycode()
      case _ => throw new Error(s"Unknown object type ${typ.toHexString} (${typ.toChar})")
    }
  }

}

abstract class PyBoolean(val value: Boolean) extends PyObject

object PyTrue extends PyBoolean(true)
object PyFalse extends PyBoolean(false)

object PyNone extends PyObject {
  override def toString: String = "PyNone"
}

class PyCodeObject (
                   val nargs: Int,
                   val nkwargs: Int,
                   val nlocals: Int,
                   val stackSize: Int,
                   val flags: Int,
                   val firstLineNumber: Int,
                   val code: PyString,
                   val consts: PyObject,
                   val names: PyObject,
                   val varnames: PyObject, //These seem to be refs? - Perhaps they could be Eithers
                   val freeVars: PyObject,
                   val cellVars: PyObject,
                   val name: PyObject,
                   val filename: PyObject,
                   val lnotab: PyObject
                   ) extends PyObject {

  override def prettyPrint(indent: Int): String = _prettyPrint(indent)

  override def toString: String = prettyPrint(0)

  def _prettyPrint(indent: Int): String = {
    val sb = new StringBuilder("\t".repeat(indent) + "Code Object:\n")
    val strs = List(
      s"Num Args    : $nargs",
      s"Num Kwargs  : $nkwargs",
      s"Num Locals  : $nlocals",
      s"StackSize   : $stackSize",
      s"Flags       : $flags",
      s"Line 1 no   : $firstLineNumber",
      s"Code:", formatCode(),
      s"Consts:", consts.prettyPrint(1).split("\n"),
      s"Names:", names.prettyPrint(1).split("\n"),
      s"Varnames:", varnames.prettyPrint(1).split("\n"),
      s"Freevars:", freeVars.prettyPrint(1).split("\n"),
      s"CellVars", cellVars.prettyPrint(1).split("\n"),
      s"Name:", name.prettyPrint(1).split("\n"),
      s"Filename: $filename",
      s"LNotab:", lnotab.prettyPrint(1).split("\n")
    ).flatMap{
      case x: String => List(x)
      case xs: Array[String] => xs.toList
      case xs: List[String] => xs
    }
    sb.append(
      strs.map("\t".repeat(indent) + "  ] " +  _).mkString("\n")
    )
    sb.toString()
  }

  def formatCode(): List[String] = {
    code.str.zipWithIndex.grouped(2).map{
      case List((op, i), (arg, _)) => f"${i/2}%3d ${PyOpcode.opcodeMap(op)}%20s" + " # " + arg
    }.toList
  }

}

object PyCodeObject {
  def read_pycode()(implicit data: ByteArrayStream): PyCodeObject = {
    val nargs = data.bReadLong()
    val nkwargs = data.bReadLong()
    val nlocals = data.bReadLong()
    val stackSize = data.bReadLong()
    val flags = data.bReadLong()
    val code = PyObject.read_object().asInstanceOf[PyString]
    val consts = PyObject.read_object()//.asInstanceOf[PyTuple]
    val names = PyObject.read_object()//.asInstanceOf[PyTuple]
    val varnames = PyObject.read_object()//.asInstanceOf[PyTuple]
    val freeVars = PyObject.read_object()//.asInstanceOf[PyTuple]
    val cellVars = PyObject.read_object()
    val name = PyObject.read_object()//.asInstanceOf[PyAscii]
    val filename = PyObject.read_object()//.asInstanceOf[PyAscii]
    val firstLineNumber = data.bReadLong()
    val lnotab = PyObject.read_object()
    new PyCodeObject(
      nargs, nkwargs, nlocals, stackSize, flags, firstLineNumber,
      code, consts, names, varnames, freeVars, cellVars, name, filename, lnotab
    )

  }
}


class PyString (val str: List[Int]) extends PyObject {
  override def toString: String = str.map(x => f"$x%02x").grouped(4).map(_.mkString(" ")).mkString("\n")
}

object PyString {

  def read_pystring()(implicit data: ByteArrayStream): PyString = {
    val length = data.bReadLong()
    new PyString(data.take(length))
  }

}

class PyTuple (val objects: List[PyObject]) extends PyObject {

  override def prettyPrint(indent: Int): String = _prettyPrint(indent)

  override def toString: String = prettyPrint(0)

  def _prettyPrint(indent: Int): String = {
    val inner = objects.zipWithIndex.map{ case (s, i) => i.toString + s.prettyPrint(1)}.mkString("\t\n")
    f"""
       |PyTuple (${objects.length}):
       |$inner
       |""".stripMargin.split("\n").mkString("\n" + "\t".repeat(indent)).substring(2)
  }

}

object PyTuple {

  def read_pytuple(isSmall: Boolean = false)(implicit data: ByteArrayStream): PyTuple = {
    val length = if (isSmall) data.head().toInt else data.bReadLong()
    new PyTuple(Range(0, length).map(_ => PyObject.read_object()).toList)
  }

}

class PyAscii (val text: String) extends PyObject {
  override def toString: String = f"PyAscii( $text )"
}

object PyAscii {

  def read_pyascii(isSmall: Boolean = false)(implicit data: ByteArrayStream): PyAscii = {
    val length = if (isSmall) data.head() else data.bReadLong()
    new PyAscii(new String(data.take(length).map(_.toChar).toArray))
  }

}

class PyRef(val ref: Int) extends PyObject {
  override def toString: String = f"PyRef($ref)"
}

object PyRef {

  def read_pyref()(implicit data: ByteArrayStream): PyRef = {
    val r = data.bReadLong()
    new PyRef(r)
  }

}

class PyInt(val value: Int) extends PyObject {
  override def toString: String = f"PyInt($value)"
}

object PyInt {

  def read_pyInt()(implicit data: ByteArrayStream): PyInt = {
    new PyInt(data.bReadLong())
  }

}