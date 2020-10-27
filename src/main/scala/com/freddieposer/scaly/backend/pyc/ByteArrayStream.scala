package com.freddieposer.scaly.backend.pyc

import java.util.concurrent.atomic.AtomicInteger

class ByteArrayStream (val bytes: Array[Byte]) {

  private var _offset: AtomicInteger = new AtomicInteger(0)

  def offset:Int = _offset.get()

  def reset(): Unit = _offset.set(0)

  def take(n: Int): List[Int] = take_bytes(n).map(_ & 0xff)

  def take_bytes(n: Int):List[Byte] = {
    if (offset + n > bytes.length) throw new Error(s"No more bytes ${offset + n}")
    bytes.slice(offset, _offset.addAndGet(n)).toList
  }

  def head(): Int = take(1).head

  def bReadLong(rev: Boolean = true): Int = {
    val bs_r = take(4).map(_.toInt)
    val bs = if (rev) bs_r.reverse else bs_r
    bs(3) + bs(2) * (1 << 8) + bs(1) * (1 << 16) + bs.head * (1 << 24)
  }

  def isConsumed: Boolean = offset >= bytes.length

  def skip(n: Int): ByteArrayStream = {_offset.addAndGet(n); this}

}
