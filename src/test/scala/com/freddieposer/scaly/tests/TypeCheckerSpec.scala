package com.freddieposer.scaly.tests

import com.freddieposer.scaly.backend.internal.IST_CompilationUnit
import com.freddieposer.scaly.typechecker.Utils.TCR
import com.freddieposer.scaly.utils.Logger

import java.nio.file.{Path, Paths}

class TypeCheckerSpec(val folder: Path) extends TestSpec {

  def this(_f: String) = this(Paths.get(_f))

  def runTest(filename: String, text: String, tcRes: TCR[IST_CompilationUnit]): (Boolean, () => Unit) = {
    tcRes match {
      case Left(value) =>
        Logger.debug(s"Unable to typecheck $filename")
        (false, () => Logger.error(value.toString))
      case Right(value) =>
        Logger.debug(s"Able to typecheck $filename")
        (true, () => Logger.error(value.toString))
    }

  }

  override def descend(f: Path): TestSpec = new TypeCheckerSpec(f)
}
