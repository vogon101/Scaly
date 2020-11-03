package com.freddieposer.scaly.backend.pyc.utils

import java.util.concurrent.atomic.AtomicInteger

import com.freddieposer.scaly.backend.pyc.defs.PycTypeBytes

import scala.collection.mutable.ArrayBuffer

abstract class ByteArrayStream {

  def bytes: Array[Byte]

  protected[ByteArrayStream] var _offset: AtomicInteger = new AtomicInteger(0)

  def offset:Int = _offset.get()

  def reset(): Unit = _offset.set(0)

  def take_bytes(n: Int):List[Byte] = {
    if (offset + n > bytes.length) throw new Error(s"No more bytes ${offset + n}")
    bytes.slice(offset, _offset.addAndGet(n)).toList
  }

  def take(n: Int): List[Int] = take_bytes(n).map(_ & 0xff)

  def head(): Int = take(1).head

  def readLong(rev: Boolean = true): Int = {
    val bs_r = take(4).map(_.toInt)
    val bs = if (rev) bs_r.reverse else bs_r
    bs(3) + bs(2) * (1 << 8) + bs(1) * (1 << 16) + bs.head * (1 << 24)
  }

  def isConsumed: Boolean = offset >= bytes.length

  def skip(n: Int): ByteArrayStream = {_offset.addAndGet(n); this}

  override def toString: String = f"BAS(${bytes.map(_.toHexString).mkString(" ")})"

}

object ByteArrayStream {

  def apply(bytes: Array[Byte]): ImmutableByteArrayStream = new ImmutableByteArrayStream(bytes)

  def apply(bytes: List[Byte]): ImmutableByteArrayStream = new ImmutableByteArrayStream(bytes.toArray)

  def apply(chars: Array[Char]): ImmutableByteArrayStream = new ImmutableByteArrayStream(chars.map(_.toByte))

  def apply(bytes: Byte*): ImmutableByteArrayStream = new ImmutableByteArrayStream(bytes.toArray)

  def apply(typ: PycTypeBytes.TypeByte): ImmutableByteArrayStream = ByteArrayStream(typ.toByte)

  def fromLongs(longs: Int*): ImmutableByteArrayStream = {
    val x = new MutableByteArrayStream()
    x.writeLongs(longs.toList)
    x.freeze
  }

  def join(bass: List[ByteArrayStream]): ImmutableByteArrayStream =
    bass.foldLeft(ByteArrayStream()) { case (x,y) => x + y }

}

class ImmutableByteArrayStream (override val bytes: Array[Byte]) extends ByteArrayStream {

  def + (that: ByteArrayStream): ImmutableByteArrayStream = ByteArrayStream(Array(bytes, that.bytes).flatten)

}

class MutableByteArrayStream (private val _m_bytes: ArrayBuffer[Byte] = ArrayBuffer()) extends ByteArrayStream {

  override def bytes: Array[Byte] = _m_bytes.toArray

  def write(byte: Byte): Unit = _m_bytes.append(byte)

  def write(bytes: Array[Byte]): Unit = _m_bytes.appendAll(bytes)

  def write(bytes: ByteArrayStream): Unit = write(bytes.bytes)

  def writeLong(n: Int, rev: Boolean = true): Unit = {
    val bs = Array(
      n & 0xff, (n >> 8) & 0xff, (n >> 16) & 0xff, (n >> 24) & 0xff
    ).map(_.toByte)
    write(if (!rev) bs.reverse else bs)
  }

  def writeLongs(ns: List[Int], rev: Boolean = true): Unit = ns.foreach(n => writeLong(n, rev))

  def freeze: ImmutableByteArrayStream = new ImmutableByteArrayStream(bytes)

}