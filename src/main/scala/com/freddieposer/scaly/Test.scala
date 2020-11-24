package com.freddieposer.scaly

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

import com.freddieposer.scaly.AST.ASTBuilder
import com.freddieposer.scaly.backend.pyc.utils.ImmutableByteArrayStream
import com.freddieposer.scaly.backend.pyc.PycFile

import scala.jdk.CollectionConverters.ListHasAsScala
import scala.io.Source

object Test {

  def test_pyc(): Unit = {
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

  def test_parsing(): Unit = {

    val lines = Files.readAllLines(Paths.get("parsing_test.scala")).asScala.mkString("\n")
    println(lines)
//
//    val cu = ScalyParserUtils.parse(lines)
//    println(cu.toStringTree.prettyPrint())

    import scala.meta._

    val x = lines.parse[scala.meta.Source].get
    println(x.structure)
    println(x.stats.head.children)
    println(ASTBuilder.fromScalaMeta(x))

  }

  def main(args: Array[String]): Unit = {
    test_parsing()
  }

}

