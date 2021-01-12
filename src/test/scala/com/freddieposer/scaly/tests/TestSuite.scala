package com.freddieposer.scaly.tests

import com.freddieposer.scaly.utils.Logger

object TestSuite {


  def main(args: Array[String]): Unit = {
    val suites = List(
      "TypeChecker" -> new TypeCheckerSpec("test_suite/typechecker"),
      "Compiler" -> new CompilerSpec("test_suite/compiler", "tmp.pyc")
    )

    if (suites.map { case (name, suite) =>
      if (suite.testAll()) {
        Logger.success(s"$name Passed")
        true
      } else {
        Logger.error(s"$name Failed")
        false
      }
    }.forall(x => x)) {
      Logger.success(s"Test Suites Passed")
    } else {
      Logger.error(s"Test Suites Failed")
    }

  }


}
