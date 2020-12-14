package com.freddieposer.scaly
import java.nio.file.{Files, Paths}

import com.freddieposer.scaly.AST.{ASTBuilder, ScalyClassDef}
import com.freddieposer.scaly.backend.pyc.utils.ImmutableByteArrayStream
import com.freddieposer.scaly.backend.pyc.PycFile
import com.freddieposer.scaly.typechecker.TypeChecker
import com.freddieposer.scaly.typechecker.context.BaseTypeContext

import scala.jdk.CollectionConverters.ListHasAsScala
import scala.meta.{Defn, Stat}

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

  def printAST(stat: Stat, indent: Int): Unit = stat match {
    case Defn.Class(mods, name, tparams, ctor, templ) =>
      println(s"${"\t" * indent}Class $name")
      for (s <- templ.children) s match {
        case stat: Stat => printAST(stat, indent + 1)
        case x => println(s"${"\t" * indent}$x")
      }

    case Defn.Def(mods, name, tparams, paramss, decltpe, body) =>
      println(s"${"\t" * indent}Def $name ($paramss => $decltpe)")
      printAST(body, indent + 1)

    case x => println(s"${"\t" * indent}${x.structure}")
  }

  def test_parsing(): Unit = {

    val lines = Files.readAllLines(Paths.get("test_files/test1.scala")).asScala.mkString("\n")
    println(lines)

    import scala.meta._

    val x = lines.parse[scala.meta.Source].get

    println(x.structure)
    println(x.stats.head.children.map(_.structure).mkString("\n"))
    printAST(x.stats.head, 0)
    val ast = ASTBuilder.fromScalaMeta(x)
    val tc = new TypeChecker(ast)

//    for ((name, typ) <- tc.globalContext.types)
//      println(f"$name : ${typ.members}")

    val res = tc.typeCheck()
    println(res)



  }

  def main(args: Array[String]): Unit = {
    test_parsing()
  }

}

