package com.freddieposer.scaly.backend.pyc

import scala.collection.mutable.ArrayBuffer

class PyCodeObject(
                    val nargs: Int,
                    val nkwargs: Int,
                    val nlocals: Int,
                    val stackSize: Int,
                    val flags: Int,
                    val firstLineNumber: Int,
                    val code: PyString,
                    val consts: PyTuple,
                    val names: PyObject,
                    val varnames: PyObject, //These seem to be refs? - Perhaps they could be Eithers
                    val freeVars: PyObject,
                    val cellVars: PyObject,
                    val name: PyObject,//PyAscii,
                    val filename: PyObject,//PyAscii,
                    val lnotab: PyString,
                    private var _parent: Option[PyCodeObject] = None
                  ) extends PyObject {

  def constants_tuple: PyTuple = consts.asInstanceOf[PyTuple]

  def names_tuple: PyTuple = names.asInstanceOf[PyTuple]

  def getConstant(i: Int): PyObject =
    constants_tuple.objects(i) //.flatMap(resolveConstant _)

  def getName(i: Int): PyObject =
    names_tuple.objects(i) //.flatMap(resolveName _)

  override def prettyPrint(indent: Int): String = _prettyPrint(indent)

  override def toString: String = prettyPrint(0)

  override def shortName: String = f"PyCodeObject(${name})"

  def parent: Option[PyCodeObject] = _parent

  def setParents(parent: Option[PyCodeObject]): Unit = {
    _parent = parent
    constants_tuple.objects.foreach {
      case child: PyCodeObject => child.setParents(Some(this))
      case _ =>
    }
  }

  def _prettyPrint(indent: Int): String = {
    val sb = new StringBuilder("\t".repeat(indent) + "Code Object:\n")
    val strs = List(
      s"Num Args    : $nargs",
      s"Num Kwargs  : $nkwargs",
      s"Num Locals  : $nlocals",
      s"StackSize   : $stackSize",
      s"Flags       : $flags",
      s"Line 1 no   : $firstLineNumber",
      s"Name:", name.prettyPrint(1).split("\n"),
      s"Code:", formatCode(),
      s"Consts:", constants_tuple.prettyPrint(1).split("\n"),

      s"Names:", names_tuple.prettyPrint(1).split("\n"),
      s"Varnames:", varnames.prettyPrint(1).split("\n"),
      s"Freevars:", freeVars.prettyPrint(1).split("\n"),
      s"CellVars", cellVars.prettyPrint(1).split("\n"),
      s"Name:", name.prettyPrint(1).split("\n"),
      s"Filename: $filename",
      s"LNotab:", lnotab.prettyPrint(1).split("\n")
    ).flatMap {
      case x: String => List(x)
      case xs: Array[String] => xs.toList
      case xs: List[String] => xs
    }
    sb.append(
      strs.map("\t".repeat(indent) + "  ] " + _).mkString("\n")
    )
    sb.toString()
  }

  def formatCode(): List[String] = {
    code.as_ints.zipWithIndex.grouped(2).map {
      case List((op, i), (arg, _)) => {
        val opcode = PyOpcode.opcodeMap(op)
        opcode.argType match {
          case Some(PyOpcodeArgType.IDX_CONST_LIST) =>
            f"${i / 2}%3d ${PyOpcode.opcodeMap(op)}%20s # $arg%-2d - ${getConstant(arg).shortName}"
          case Some(PyOpcodeArgType.IDX_NAME_LIST) =>
            f"${i / 2}%3d ${PyOpcode.opcodeMap(op)}%20s # $arg%-2d - ${getName(arg).shortName}"
          case _ => f"${i / 2}%3d ${PyOpcode.opcodeMap(op)}%20s # $arg%-2d"
        }
      }
    }.toList
  }


}

object PyCodeObject {
  def read_pycode(flag: Int)(implicit data: ByteArrayStream, refList: RefList): PyCodeObject = {

    val idx = refList.reserve(flag)

    val nargs = data.bReadLong()
    val nkwargs = data.bReadLong()
    val nlocals = data.bReadLong()
    val stackSize = data.bReadLong()
    val flags = data.bReadLong()
    val code = PyObject.read_object().asInstanceOf[PyString] // Hack
    val consts = PyObject.read_object().asInstanceOf[PyTuple]
    val names = PyObject.read_object().asInstanceOf[PyTuple]
    val varnames = PyObject.read_object().asInstanceOf[PyTuple]
    val freeVars = PyObject.read_object().asInstanceOf[PyTuple]
    val cellVars = PyObject.read_object()//.asInstanceOf[PyTuple]
    val filename = PyObject.read_object().asInstanceOf[PyAscii]
    val name = PyObject.read_object().asInstanceOf[PyAscii]
    val firstLineNumber = data.bReadLong()
    val lnotab = PyObject.read_object().asInstanceOf[PyString]

    val x = new PyCodeObject(
        nargs, nkwargs, nlocals, stackSize, flags, firstLineNumber,
        code, consts, names, varnames, freeVars, cellVars, name, filename, lnotab
    )
    refList.insert(x, idx, flag)

  }
}