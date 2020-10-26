package com.freddieposer.scaly.backend.pyc

import java.io.File

class PycFile(
               val magic: Int,
               val bit_field: Int,
               val moddate: Int,
               val fileSize: Int,
               val codeObject: PyCodeObject
             ) {

  override def toString: String =
    f"""
       |PycFile:
       |  Magic       : $magic%08x
       |  Bit Field   : $bit_field%08x
       |  Mod Date    : $moddate%08x
       |  File Size   : $fileSize%08x
       |  Code:
       |  ${codeObject.prettyPrint(1)}
       |""".stripMargin

}

object PycFile {

  //TODO: These should all really be optional returns
  def readFromBytes(bytes: ByteArrayStream): PycFile = {
    val magic = bytes.bReadLong(false)
    val bits = bytes.bReadLong(false)
    val moddate = bytes.bReadLong(false)
    val filesize = bytes.bReadLong(false)
    new PycFile(
      magic,
      bits,
      moddate,
      filesize,
      PyCodeObject.read_pycode()(bytes.skip(1))
    )
  }

}