package com.freddieposer.scaly.backend.pyc

import com.freddieposer.scaly.backend.CompilationContext
import com.freddieposer.scaly.backend.pyc.defs.{PyOpcodeArgType, PyOpcodes, PycTypeBytes}
import com.freddieposer.scaly.backend.pyc.utils.{ByteArrayStream, MutableByteArrayStream, RefList}

class PyCodeObject(
                    val nargs: Int,
                    val nposOnlyArgs: Int,
                    val nkwargs: Int,
                    val nlocals: Int,
                    val stackSize: Int,
                    val flags: Int,
                    val firstLineNumber: Int,
                    val code: PyString,
                    val consts: PyTuple,
                    val names: PyTuple,
                    val varnames: PyTuple,
                    val freeVars: PyTuple,
                    val cellVars: PyTuple,
                    val name: PyAscii,
                    val filename: PyAscii,
                    val lnotab: PyString
                  ) extends PyObject {

  def getConstant(i: Int): PyObject = consts.objects(i)

  def getName(i: Int): PyObject = names.objects(i)

  override def prettyPrint(indent: Int): String = _prettyPrint(indent)

  override def toString: String = prettyPrint(0)

  override def shortName: String = f"PyCodeObject(${name})"

  def _prettyPrint(indent: Int): String = {
    val sb = new StringBuilder("\t".repeat(indent) + "Code Object:\n")
    val strs = List(
      s"Num Args    : $nargs",
      s"Num Kwargs  : $nkwargs",
      s"Num Locals  : $nlocals",
      s"StackSize   : $stackSize",
      s"Flags       : $flags",
      s"Line 1 no   : $firstLineNumber",
      s"Name: $name",
      s"Code:", formatCode(),
      s"Consts:", consts.prettyPrint(1).split("\n"),
      s"Names:", names.prettyPrint(1).split("\n"),
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

  def formatCode(): List[String] =
    code.as_ints.zipWithIndex.grouped(2).map {
      case List((op, i), (arg, _)) =>
        val opcode = PyOpcodes.opcodeMap(op)
        f"$i%3d ${PyOpcodes.opcodeMap(op)}%20s # " + (if (opcode.takesArg)
          opcode.argType match {
            case Some(PyOpcodeArgType.IDX_CONST_LIST) =>
              f"$arg%-2d - ${getConstant(arg).shortName}"
            case Some(PyOpcodeArgType.IDX_NAME_LIST) =>
              f"$arg%-2d - ${getName(arg).shortName}"
            case Some(PyOpcodeArgType.LOCAL_VAR_NUM) =>
              f"$arg%-2d - ${varnames.objects(arg).shortName}"
            case Some(PyOpcodeArgType.IDX_CELL) =>
              f"$arg%-2d - " +
                (if (arg < cellVars.length)
                  f"${cellVars.objects(arg).shortName} [CV]"
                else f"${freeVars.objects(arg - cellVars.length).shortName} [FV]")
            case _ => f"$arg%-2d"
          } else "")
    }.toList

  def toBytes: ByteArrayStream = {

    val bytes = new MutableByteArrayStream()

    bytes.writeLongs(List(
      nargs, nposOnlyArgs, nkwargs, nlocals, stackSize, flags
    ))

    bytes.write(
      ByteArrayStream.join(List(
        code.toBytes,
        consts.toBytes,
        names.toBytes,
        varnames.toBytes,
        freeVars.toBytes,
        cellVars.toBytes,
        filename.toBytes,
        name.toBytes
      ))
    )

    bytes.writeLong(firstLineNumber)

    bytes.write(lnotab.toBytes)

    ByteArrayStream(PycTypeBytes.TYPE_CODE) + bytes

  }

}

object PyCodeObject {
  def read_pycode(flag: Int)(implicit data: ByteArrayStream, refList: RefList): PyCodeObject = {

    val idx = refList.reserve(flag)

    val nargs = data.readLong()
    val nposOnlyArgs = data.readLong()
    val nkwargs = data.readLong()
    val nlocals = data.readLong()
    val stackSize = data.readLong()
    val flags = data.readLong()
    val code = PyObject.read_object().asInstanceOf[PyString]
    val consts = PyObject.read_object().asInstanceOf[PyTuple]
    val names = PyObject.read_object().asInstanceOf[PyTuple]
    val varnames = PyObject.read_object().asInstanceOf[PyTuple]
    val freeVars = PyObject.read_object().asInstanceOf[PyTuple]
    val cellVars = PyObject.read_object().asInstanceOf[PyTuple]
    val filename = PyObject.read_object().asInstanceOf[PyAscii]
    val name = PyObject.read_object().asInstanceOf[PyAscii]
    val firstLineNumber = data.readLong()
    val lnotab = PyObject.read_object().asInstanceOf[PyString]

    val x = new PyCodeObject(
      nargs, nposOnlyArgs, nkwargs, nlocals, stackSize, flags, firstLineNumber,
      code, consts, names, varnames, freeVars, cellVars, name, filename, lnotab
    )
    refList.insert(x, idx, flag)
  }

  def apply(
             ctx: CompilationContext, code: PyString,
             name: PyAscii, filename: PyAscii,
             nargs: Int, nPosOnly: Int, nLocals: Int, stackSize: Int, flags: Int,
             freeVars: PyTuple = PyTuple.empty, cellVars: PyTuple = PyTuple.empty,
             lnotab: PyString = PyString.empty,
             firstLineNo: Int = 1, nKwargs: Int = 0
           ): PyCodeObject = {
    //TODO: Excludes kwargs
    new PyCodeObject(
      nargs, nPosOnly, nKwargs, nLocals, stackSize, flags, firstLineNo,
      code, ctx.constants, ctx.names, ctx.varnames, freeVars, cellVars, name, filename, lnotab
    )
  }

}