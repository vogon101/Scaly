package com.freddieposer.scaly.tests

import com.freddieposer.scaly.AST.ASTBuilder
import com.freddieposer.scaly.backend.internal.IST_CompilationUnit
import com.freddieposer.scaly.typechecker.TypeChecker
import com.freddieposer.scaly.typechecker.Utils.TCR
import com.freddieposer.scaly.utils.Logger

import java.nio.file.{Files, Path}
import scala.jdk.CollectionConverters.CollectionHasAsScala

abstract class TestSpec {

  val folder: Path

  assert(folder.toFile.isDirectory)

  val files: List[Path] =
    folder.toFile.listFiles.filter(_.isFile).map(_.toPath).toList

  val directories: List[Path] =
    folder.toFile.listFiles.filter(_.isDirectory).map(_.toPath).toList

  private val successTests = files.filter(_.getFileName.toString.startsWith("S"))
  private val failTests = files.filter(_.getFileName.toString.startsWith("F"))

  def testAll(): Boolean = {
    Logger.log(s"Testing ${folder.getFileName}")
    (successTests.map(run(expectation = true)) ++
      failTests.map(run(expectation = false)(_)) ++
      directories.map(descend).map(_.testAll())).forall(b => b)
  }

  def run(expectation: Boolean)(file: Path): Boolean = {
    val lines = Files.readAllLines(file).asScala.mkString("\n")
    Logger.log(s"Running test ${file.getFileName}")
    import scala.meta._

    val x = lines.parse[scala.meta.Source].get
    val ast = ASTBuilder.fromScalaMeta(x)
    val tc = new TypeChecker(ast)
    val tcRes = tc.typeCheck()

    val res = runTest(file.getFileName.toString, lines, tcRes)
    if (res._1 == expectation) {
      Logger.success(s"Test ${file.getFileName.toString} passed")
      true
    } else {
      Logger.error(s"Test ${file.getFileName.toString} failed")
      res._2()
      false
    }

  }

  def runTest(filename: String, text: String, tcRes: TCR[IST_CompilationUnit]): (Boolean, () => Unit)

  def descend(f: Path): TestSpec

}
