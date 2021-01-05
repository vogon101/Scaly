package com.freddieposer.scaly.tests

import com.freddieposer.scaly.backend.ISTCompiler
import com.freddieposer.scaly.backend.internal.IST_CompilationUnit
import com.freddieposer.scaly.backend.pyc.PycFile
import com.freddieposer.scaly.typechecker.Utils.TCR
import com.freddieposer.scaly.utils.Logger

import java.nio.file.{Files, Path, Paths}

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

        val regex = "\\/\\*\n((.|\n)+)\n \\*\\/".r
        //TODO: Make robust
        val expectation = regex.findFirstMatchIn(text).get.group(1)

        val pyCodeObject = new ISTCompiler("placeholder").compile(ist)
        val f = PycFile(pyCodeObject)
        Files.write(tmpFile, f.toBytes.bytes)
        import sys.process._
        val command = s"bash test_files/run_compiled.sh ${'"'}${tmp_file}${'"'}"
        val res = command.!!
        if (res.dropRight(2).replace("\r\n", "\n") == expectation) (true, () => {})
        else {
          (false, () => {
            Logger.debug(ist.toString)
            Logger.debug(pyCodeObject.toString)
            Logger.warn(s"Expected:\n$expectation")
            Logger.warn("Actual:\n" + res.toString)
          })
        }

    }

  }

  override def descend(f: Path): TestSpec = new CompilerSpec(f, tmp_file)
}
