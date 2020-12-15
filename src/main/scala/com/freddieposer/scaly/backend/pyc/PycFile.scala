package com.freddieposer.scaly.backend.pyc

import com.freddieposer.scaly.backend.pyc.utils.{ByteArrayStream, MutableByteArrayStream, RefList}

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

  def toBytes: ByteArrayStream = {

    val bytes = new MutableByteArrayStream()

    bytes.writeLong(magic, rev = false)
    bytes.writeLong(bit_field, rev = false)
    // These will be wrong, they should be generated
    bytes.writeLong(moddate, rev = false)
    bytes.writeLong(fileSize, rev = false)

    bytes.write(codeObject.toBytes)

    bytes.freeze

  }

}

object PycFile {

  /**
   * Magic number defined for pyc files compatible with python 3.8
   */
  val MAGIC_NUMBER = 0x550d0d0a

  def readFromBytes(bytes: ByteArrayStream): PycFile = {
    val magic = bytes.readLong(false)
    val bits = bytes.readLong(false)
    val moddate = bytes.readLong(false)
    val filesize = bytes.readLong(false)

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