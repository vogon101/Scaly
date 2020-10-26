package com.freddieposer.scaly

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

import com.freddieposer.scaly.backend.pyc.{ByteArrayStream, PyObject, PycFile}

import scala.io.Source

object Test {

  def main(args: Array[String]): Unit = {
    val bytes = Files.readAllBytes(Paths.get("test2.pyc"))
    println(f" ".repeat(5) + Range(0, 16).map(x => f"${x}%x").mkString("  "))
    println(
      bytes.map((String.format("%02x", _)))
        .grouped(16).map(_.mkString(" "))
        .zipWithIndex.map{case (s, i) => f"${i}%04x $s"}
        .mkString("\n")
    )
    val pyobj = PycFile.readFromBytes(new ByteArrayStream(bytes))
    println(pyobj)
  }

}

