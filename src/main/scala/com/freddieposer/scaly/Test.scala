package com.freddieposer.scaly

import com.freddieposer.scaly.AST.ASTBuilder
import com.freddieposer.scaly.backend.ISTCompilationPipeline
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
  val DUMP_PYTHON_FILE = "test_files/t.py"
  val DUMP_INPUT_FILE = "test_files/t.pyc"
  //  val SCALA_INPUT_FILE = "test_files/typesafety_matches.sc"
  val SCALA_INPUT_FILE = "test_files/compileTest.scala"

  def test_pyc(): Unit = {
    import sys.process._
//    s"bash test_files/compile.sh $Q$DUMP_PYTHON_FILE$Q $Q$DUMP_INPUT_FILE$Q".!

    var bytes2 = Files.readAllBytes(Paths.get(COMPILED_OUTPUT_FILE))
    val pyobj2 = PycFile.readFromBytes(new ImmutableByteArrayStream(bytes2))
    println(pyobj2)

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

    val ast = ASTBuilder.fromScalaMeta(x)

    //    for ((name, typ) <- tc.globalContext.types)
    //      println(f"$name : ${typ.members}")

    val res = TypeChecker.typeCheck(ast)

    res match {
      case Left(value) =>
        println("Unable to typecheck program")
        printError(value)
      case Right(value) =>
        println("Success!")
        println(value)
    }


  }

  def test_compile(): Boolean = {


    val lines = Files.readAllLines(Paths.get(SCALA_INPUT_FILE)).asScala.mkString("\n")
    println(lines)

    val pipeline = CompilationPipeline.standard

    pipeline.compile("placeholder", lines) match {
      case Left(SyntaxError(e)) =>
        println(s"Syntax error in file $SCALA_INPUT_FILE")
        println(e)
        false
      case Left(e: TypeError) =>
        println(s"Unable to typecheck $SCALA_INPUT_FILE")
        printError(e)
        false
      case Right(pyo) =>
        val f = PycFile(pyo)
        Files.write(Paths.get(COMPILED_OUTPUT_FILE), f.toBytes.bytes)
        true
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

    if(test_compile()) {
      test_pyc()
      test_run()
    }
  }

}

