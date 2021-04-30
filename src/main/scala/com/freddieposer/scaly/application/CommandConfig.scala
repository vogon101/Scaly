package com.freddieposer.scaly.application

import com.freddieposer.scaly.application.CompilerMode.{COMPILE, CompilerMode}

import java.io.File

case class CommandConfig(
                          inputFile: Option[File] = None,
                          outputFile: Option[File] = None,
                          mode: CompilerMode = COMPILE
                        ) {

}

object CompilerMode extends Enumeration {

  type CompilerMode = Value

  val COMPILE, COMPILE_AND_RUN = Value

}