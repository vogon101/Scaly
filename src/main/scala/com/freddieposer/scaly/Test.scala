package com.freddieposer.scaly

import com.freddieposer.scaly.AST.ASTBuilder
import com.freddieposer.scaly.backend.ISTCompiler
import com.freddieposer.scaly.backend.internal.ISTBuilder
import com.freddieposer.scaly.backend.pyc.PycFile
import com.freddieposer.scaly.backend.pyc.utils.ImmutableByteArrayStream
import com.freddieposer.scaly.typechecker.{TypeChecker, TypeError, TypeErrorContext, TypeErrorFromUnificationFailure}

import java.nio.file.{Files, Paths}
import scala.annotation.tailrec
import scala.jdk.CollectionConverters.ListHasAsScala
import scala.meta.{Defn, Stat}

object Test {

  //TODO: An actual test suite
  def test_pyc(): Unit = {
    var bytes1 = Files.readAllBytes(Paths.get("test_files/compiled.pyc"))
    val pyobj1 = PycFile.readFromBytes(new ImmutableByteArrayStream(bytes1))
    println(pyobj1)

    var bytes2 = Files.readAllBytes(Paths.get("test_files/sclass.pyc"))
    val pyobj2 = PycFile.readFromBytes(new ImmutableByteArrayStream(bytes2))
    println(pyobj2)


//    println(f" ".repeat(5) + Range(0, 16).map(x => f"${x}%x").mkString("  "))
//    println(
//      bytes.map((String.format("%02x", _)))
//        .grouped(16).map(_.mkString(" "))
//        .zipWithIndex.map { case (s, i) => f"${i}%04x $s" }
//        .mkString("\n")
//    )


//    val out = pyobj.toBytes
//    bytes = out.bytes
////    println(f" ".repeat(5) + Range(0, 16).map(x => f"${x}%x").mkString("  "))
////    println(
////      bytes.map((String.format("%02x", _)))
////        .grouped(16).map(_.mkString(" "))
////        .zipWithIndex.map { case (s, i) => f"${i}%04x $s" }
////        .mkString("\n")
////    )
//    println(PycFile.readFromBytes(out))
//
//    Files.write(Paths.get("test_files/sclass2.pyc"), out.bytes)
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

  @tailrec
  def printError(error: TypeError): Unit = error match {
    case context: TypeErrorContext =>
      println(s"Error at ${context.node}")
      printError(context.inner)
    case failure: TypeErrorFromUnificationFailure =>
      println(failure)
    case _ =>
  }

  def test_tc(): Unit = {

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

    res match {
      case Left(value) =>
        println("Unable to typecheck program")
        printError(value)
      case Right(value) =>
        println("Success!")
        println(value)
    }


  }

  def test_compile(): Unit = {


    val lines = Files.readAllLines(Paths.get("test_files/compileTest.scala")).asScala.mkString("\n")
    println(lines)

    import scala.meta._

    val x = lines.parse[scala.meta.Source].get
    val ast = ASTBuilder.fromScalaMeta(x)
    val tc = new TypeChecker(ast)

    val res = tc.typeCheck()

    res match {
      case Left(value) =>
        println("Unable to typecheck program")
        printError(value)
      case Right(value) =>
        println("Success!")
        println(value)

        val ist = ISTBuilder.buildIST(ast)
        val pyCodeObject = new ISTCompiler("placeholder").compile(ist)
        println(pyCodeObject)
        val f = PycFile(pyCodeObject)
        Files.write(Paths.get("test_files/compiled.pyc"), f.toBytes.bytes)

    }

  }

  def main(args: Array[String]): Unit = {
    test_pyc()
    test_compile()
  }

}

