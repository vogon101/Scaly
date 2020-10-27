package com.freddieposer.scaly.backend.pyc

import java.io.File

import com.freddieposer.scaly.backend.pyc.utils.{ByteArrayStream, RefList}

import scala.collection.mutable.ArrayBuffer

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

  /**
   * Magic number defined for pyc files compatible with python 3.8
   */
  val MAGIC_NUMBER = 0x550d0d0a

  def readFromBytes(bytes: ByteArrayStream): PycFile = {
    val magic = bytes.bReadLong(false)
    val bits = bytes.bReadLong(false)
    val moddate = bytes.bReadLong(false)
    val filesize = bytes.bReadLong(false)

    assert(MAGIC_NUMBER == magic, s"Incorrect magic number in file (Expected ${MAGIC_NUMBER}, got ${magic})")

    val pyRefs = new RefList

    val retval = new PycFile(
      magic,
      bits,
      moddate,
      filesize,
      PyObject.read_object()(bytes, pyRefs).asInstanceOf[PyCodeObject]
    )
    retval
  }

}