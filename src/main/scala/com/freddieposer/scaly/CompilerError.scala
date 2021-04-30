package com.freddieposer.scaly

import scala.meta.parsers.Parsed

trait CompilerError {

}

case class SyntaxError(error: Parsed.Error) extends CompilerError
