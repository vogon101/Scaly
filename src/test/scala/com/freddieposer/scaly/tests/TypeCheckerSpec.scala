package com.freddieposer.scaly.tests

import com.freddieposer.scaly.AST.ASTBuilder
import com.freddieposer.scaly.backend.internal.IST_CompilationUnit
import com.freddieposer.scaly.typechecker.TypeChecker
import com.freddieposer.scaly.typechecker.Utils.TCR
import com.freddieposer.scaly.utils.Logger

import java.nio.file.{Files, Path, Paths}
import scala.jdk.CollectionConverters.CollectionHasAsScala

class TypeCheckerSpec(val folder: String) extends TestSpec {

  def runTest(filename: String, text: String, tcRes: TCR[IST_CompilationUnit]): Boolean = {
    tcRes match {
      case Left(value) =>
        Logger.log(s"Unable to typecheck $filename")
        false
      case Right(value) =>
        Logger.log(s"Able to typecheck $filename")
        true
    }

  }


}
