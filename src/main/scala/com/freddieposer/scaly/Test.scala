package com.freddieposer.scaly

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

import com.freddieposer.scaly.backend.pyc.defs.PycTypeBytes
import com.freddieposer.scaly.backend.pyc.utils.{ByteArrayStream, ImmutableByteArrayStream, MutableByteArrayStream}
import com.freddieposer.scaly.backend.pyc.{PyObject, PycFile}

import scala.io.Source

object Test {

  def main(args: Array[String]): Unit = {

    var bytes = Files.readAllBytes(Paths.get("test2.pyc"))
    println(f" ".repeat(5) + Range(0, 16).map(x => f"${x}%x").mkString("  "))
    println(
      bytes.map((String.format("%02x", _)))
        .grouped(16).map(_.mkString(" "))
        .zipWithIndex.map{case (s, i) => f"${i}%04x $s"}
        .mkString("\n")
    )
    val pyobj = PycFile.readFromBytes(new ImmutableByteArrayStream(bytes))
    println(pyobj)

    val out = pyobj.toBytes
    bytes = out.bytes
    println(f" ".repeat(5) + Range(0, 16).map(x => f"${x}%x").mkString("  "))
    println(
      bytes.map((String.format("%02x", _)))
        .grouped(16).map(_.mkString(" "))
        .zipWithIndex.map{case (s, i) => f"${i}%04x $s"}
        .mkString("\n")
    )
    println(PycFile.readFromBytes(out))

    Files.write(Paths.get("out.pyc"), out.bytes)


  }

}

