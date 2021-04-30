package com.freddieposer.scaly.application
import com.freddieposer.scaly.application.CompilerMode.{COMPILE, COMPILE_AND_RUN}
import com.freddieposer.scaly.backend.pyc.PycFile
import com.freddieposer.scaly.typechecker.TypeError
import com.freddieposer.scaly.utils.Logger
import com.freddieposer.scaly.{CompilationPipeline, SyntaxError}
import scopt.OParser

import java.io.File
import java.nio.file.{Files, NoSuchFileException, Path, Paths}
import scala.jdk.CollectionConverters.CollectionHasAsScala

object Compiler {

  val DEFAULT_OUTPUT_FILE = "compiled.pyc"
  val Q = '"'

  def main(args: Array[String]): Unit = {
    val builder = OParser.builder[CommandConfig]
    val parser = {
      import builder._
      OParser.sequence(
        programName("scaly"),
        head("scaly", "0.1"),

        opt[File]('i', "in")
          .required()
          .valueName("<file>")
          .action((x, c) => c.copy(inputFile = Some(x)))
          .text("in is a required file property"),

        opt[File]('o', "out")
          .valueName("<file>")
          .action((x, c) => c.copy(inputFile = Some(x))),

        help("help")
          .text("Prints the usage text"),

        cmd("run")
          .action((_, c) => c.copy(mode = COMPILE_AND_RUN))
          .text("Run the compiled program")

      )
    }
    OParser.parse(parser, args, CommandConfig()) match {
      case Some(CommandConfig(Some(in), out, r)) =>
        val inPath = in.toPath
        val outPath = out.map(_.toPath).getOrElse(Paths.get(s"${in.getName}.pyc"))
        val c = compile(inPath, outPath)
        if (r == COMPILE_AND_RUN && c) run(outPath)
      case _ =>
    }
  }

  private def compile(in: Path, out: Path): Boolean = {
    val lines = try {
      Files.readAllLines(in).asScala.mkString("\n")
    } catch {
      case e: NoSuchFileException =>
        Logger.error(s"Cannot find file ${in.toAbsolutePath}")
        return false
    }
    val pipeline = CompilationPipeline.standard

    pipeline.compile("placeholder", lines) match {
      case Left(SyntaxError(e)) =>
        Logger.error(s"Syntax error in file ${in.getFileName}")
        Logger.error(e.toString())
        false
      case Left(e: TypeError) =>
        Logger.error(s"Unable to typecheck ${in.getFileName}")
        Logger.error(e.toString)
        false
      case Right(pyo) =>
        val f = PycFile(pyo)
        Files.write(out, f.toBytes.bytes)
        true
     }
  }

  private def run(in: Path): Unit = {
    import sys.process._
//    val command = s"bash test_files/run_compiled.sh $Q${in.toAbsolutePath.toString}$Q"
    val command = s"python3 $Q${in.toAbsolutePath}$Q"
    try {
      Logger.debug(command)
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

}
