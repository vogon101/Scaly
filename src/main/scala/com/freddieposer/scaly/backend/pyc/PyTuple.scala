package com.freddieposer.scaly.backend.pyc

import com.freddieposer.scaly.backend.pyc.defs.PycTypeBytes
import com.freddieposer.scaly.backend.pyc.utils.{ByteArrayStream, RefList}

import scala.collection.mutable.ListBuffer

/**
 * Represents a PyTuple in a .pyc file.
 * It is a mutable object to allow it to be placed on the ref-list before it is
 * done being created
 *
 * @param _objectsBuffer - Mutable object list, should not be touched after creation
 */
class PyTuple(private var _objectsBuffer: ListBuffer[PyObject]) extends PyObject {

  override def prettyPrint(indent: Int): String = _prettyPrint(indent)

  override def shortName: String = f"PyTuple(n=${objects.length})"

  override def toString: String = prettyPrint(0)

  /**
   * @return Objects of the tuple
   */
  def objects: List[PyObject] = _objectsBuffer.toList

  def _prettyPrint(indent: Int): String = {
    if (objects.isEmpty) f"${"\t".repeat(indent)}PyTuple(-)"
    else {
      val inner = objects.zipWithIndex.map { case (s, i) => i.toString + s.prettyPrint(1) }.mkString("\t\n")
      f"""
         |PyTuple (${objects.length}):
         |$inner

         |""".stripMargin.split("\n").mkString("\n" + "\t".repeat(indent)).substring(2
      )
    }
  }

  override def toBytes: ByteArrayStream =
    (if (objects.length < 255)
      ByteArrayStream(PycTypeBytes.TYPE_SMALL_TUPLE.toByte, (objects.length & 0xff).toByte)
    else
      ByteArrayStream(PycTypeBytes.TYPE_TUPLE) + ByteArrayStream.fromLongs(objects.length)
      ) + ByteArrayStream.join(objects.map(_.toBytes))
}

object PyTuple {

  /**
   * Read a tuple from a byte stream
   *
   * @param flag    Flag
   * @param isSmall Small tuple =? size < 255
   * @param data    Stream of bytes
   * @param refList Working reflist
   * @return
   */
  def readPyTuple(flag: Int, isSmall: Boolean = false)(implicit data: ByteArrayStream, refList: RefList): PyTuple = {
    val length = if (isSmall) data.head() else data.readLong()
    val itemsBuffer = new ListBuffer[PyObject]
    val pt = new PyTuple(itemsBuffer)
    refList.append(pt, flag)
    for (o <- Range(0, length))
      itemsBuffer.append(PyObject.read_object())
    pt
  }

}