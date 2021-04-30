package com.freddieposer.scaly

import com.freddieposer.scaly.AST.{ASTBuilder, CompilationUnit}
import com.freddieposer.scaly.backend.ISTCompilationPipeline
import com.freddieposer.scaly.backend.internal.ISTBuilder
import com.freddieposer.scaly.backend.pyc.PyCodeObject
import com.freddieposer.scaly.typechecker.{TypeChecker, TypeError}

import scala.meta.parsers.Parsed


class CompilationPipeline(val frontend: String => Either[Parsed.Error, CompilationUnit],
                          val backend: String => ISTCompilationPipeline) {

  def compile(filename: String, source: String): Either[CompilerError, PyCodeObject] = {
    frontend(source)
      .left.map(SyntaxError)
      .flatMap(TypeChecker.typeCheck)
      .map(backend(filename).compile)
  }

}

object CompilationPipeline {

  def standard = new CompilationPipeline(
    (source) => {
      import scala.meta._
      source.parse[Source].toEither.map(ASTBuilder.fromScalaMeta)
    },
    ISTCompilationPipeline.standard
  )

}