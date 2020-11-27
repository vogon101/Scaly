package com.freddieposer.scaly
import java.nio.file.{Files, Paths}

import com.freddieposer.scaly.AST.{ASTBuilder, ScalyClassDef}
import com.freddieposer.scaly.backend.pyc.utils.ImmutableByteArrayStream
import com.freddieposer.scaly.backend.pyc.PycFile
import com.freddieposer.scaly.typechecker.TypeChecker
import com.freddieposer.scaly.typechecker.context.BaseTypeContext

import scala.jdk.CollectionConverters.ListHasAsScala

object Test {

  def test_pyc(): Unit = {
    var bytes = Files.readAllBytes(Paths.get("test_files/test2.pyc"))
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

    val lines = Files.readAllLines(Paths.get("test_files/test1.scala")).asScala.mkString("\n")
    println(lines)

    import scala.meta._

    val x = lines.parse[scala.meta.Source].get
    println(x.structure)
    println(x.stats.head.children)
    val ast = ASTBuilder.fromScalaMeta(x)
    val tc = new TypeChecker(ast)

//    for ((name, typ) <- tc.globalContext.types)
//      println(f"$name : ${typ.members}")

    println(tc.typeCheck())

  }

  def main(args: Array[String]): Unit = {
    test_parsing()
  }

}

