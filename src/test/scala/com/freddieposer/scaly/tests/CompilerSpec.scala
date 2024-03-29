package com.freddieposer.scaly.tests

import com.freddieposer.scaly.backend.{ISTCompilationPipeline, ISTCompiler}
import com.freddieposer.scaly.backend.internal.IST_CompilationUnit
import com.freddieposer.scaly.backend.pyc.PycFile
import com.freddieposer.scaly.typechecker.TypeCheckerUtils.TCR
import com.freddieposer.scaly.utils.Logger

import java.nio.file.{Files, Path, Paths}
import java.util.NoSuchElementException

class CompilerSpec(val folder: Path, val tmp_file: String) extends TestSpec {

  def this(_f: String, tmp: String) = this(Paths.get(_f), tmp)

  val tmpFile: Path = Paths.get(tmp_file)

  override def runTest(filename: String, text: String, tcRes: TCR[IST_CompilationUnit]): (Boolean, () => Unit) = {

    tcRes match {
      case Left(value) =>
        Logger.error(f"Failed to typecheck $filename")
        Logger.debug(value.toString)
        (false, () => println(value))

      case Right(ist) =>

        val expectation = getExpectation(text)
        val pyCodeObject = ISTCompilationPipeline.standard("placeholder").compile(ist)
        val f = PycFile(pyCodeObject)
        Files.write(tmpFile, f.toBytes.bytes)
        import sys.process._
        val command = s"bash test_files/run_compiled.sh ${'"'}${tmp_file}${'"'}"
        try {
          val res: String = command.!!
//          val trimmedExpectation = expectation.substring(3, expectation.length-4)
          if (res.dropRight(2).replace("\r\n", "\n") == expectation) (true, () => {})
          else {
            (false, () => {
              Logger.debug(ist.toString)
              Logger.debug(pyCodeObject.toString)
              Logger.warn(s"Expected:\n$expectation")
              Logger.warn(f"Actual:\n$res")
            })
          }
        } catch {
          case e: RuntimeException =>
            (false, () => {
              Logger.warn("Runtime exception")
              Logger.warn(e.toString)
              Logger.debug(ist.toString)
              Logger.debug(pyCodeObject.toString)
              Logger.debug(s"Expected:\n$expectation")

            })
        }

    }

  }

  override def descend(f: Path): TestSpec = new CompilerSpec(f, tmp_file)

  private def getExpectation(s: String): String = {
    var i = 2
    var x = ""
    assert(s.substring(0, 3) == "/*\n")
    while (!x.contains("\n */")) {
      i += 1
      x += s.charAt(i)
    }
    x.substring(0, i - 6)
  }

}
