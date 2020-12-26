package com.freddieposer.scaly.tests

import com.freddieposer.scaly.utils.Logger

object TestSuite {


  def main(args: Array[String]): Unit = {
    if (new TypeCheckerSpec("test_suite/typecheker").testAll()) {
      Logger.success("TypeChecker Passed")
    } else {
      Logger.error("TypeChecker Failed")
    }

    if (new CompilerSpec("test_suite/compiler", "tmp.pyc").testAll()) {
      Logger.success("Compiler passed")
    } else {
      Logger.error("Compiler failed")
    }

  }


}
