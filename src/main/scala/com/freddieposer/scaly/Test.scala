package com.freddieposer.scaly

import com.freddieposer.scaly.AST.ASTBuilder
import com.freddieposer.scaly.backend.ISTCompiler
import com.freddieposer.scaly.backend.pyc.PycFile
import com.freddieposer.scaly.backend.pyc.utils.ImmutableByteArrayStream
import com.freddieposer.scaly.typechecker.{TypeChecker, TypeError, TypeErrorContext, TypeErrorFromUnificationFailure}
import com.freddieposer.scaly.utils.Logger

import java.nio.file.{Files, Paths}
import scala.annotation.tailrec
import scala.jdk.CollectionConverters.ListHasAsScala
import scala.meta.{Defn, Stat}

object Test {

  val Q = '"'
  val COMPILED_OUTPUT_FILE = "test_files/compiled.pyc"
  val DUMP_PYTHON_FILE = "test_files/simple_class.py"
  val DUMP_INPUT_FILE = "test_files/sclass.pyc"
  val SCALA_INPUT_FILE = "test_files/test1.scala"

  def test_pyc(): Unit = {
    import sys.process._
    //    var bytes1 = Files.readAllBytes(Paths.get(COMPILED_OUTPUT_FILE))
    //    val pyobj1 = PycFile.readFromBytes(new ImmutableByteArrayStream(bytes1))
    //    println(pyobj1)

    s"bash test_files/compile.sh $Q$DUMP_PYTHON_FILE$Q $Q$DUMP_INPUT_FILE$Q".!

    var bytes2 = Files.readAllBytes(Paths.get(DUMP_INPUT_FILE))
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
      println(error)
      println(error.ctx)
  }

  def test_tc(): Unit = {

    val lines = Files.readAllLines(Paths.get(SCALA_INPUT_FILE)).asScala.mkString("\n")
    //    println(lines)

    import scala.meta._

    val x = lines.parse[scala.meta.Source].get

    //    println(x.structure)
    //    println(x.stats.head.children.map(_.structure).mkString("\n"))
    //    printAST(x.stats.head, 0)
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
      case Right(ist) =>
        println("Success!")
        println(ist)

        //        val ist = ISTBuilder.buildIST(ast)
        val pyCodeObject = new ISTCompiler("placeholder").compile(ist)
        println(pyCodeObject)
        val f = PycFile(pyCodeObject)
        Files.write(Paths.get("test_files/compiled.pyc"), f.toBytes.bytes)

    }

  }

  def test_run(): Unit = {
    import sys.process._
    val command = s"bash test_files/run_compiled.sh $Q${COMPILED_OUTPUT_FILE}$Q"
    try {
      println(command)
      val logger = ProcessLogger(
        println(_), Logger.error
      )
      val res = command ! logger
      println(res)
    }
    catch {
      case e: RuntimeException => println(e)
    }
  }

  def main(args: Array[String]): Unit = {
    //    test_tc()
    test_pyc()
    test_compile()
    test_run()
  }

}

