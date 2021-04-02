package com.freddieposer.scaly.AST



case class LiteralPattern(literal: Literal) extends Pattern
case class VariablePattern(name: String) extends Pattern
case class TuplePattern(pats: List[Pattern]) extends Pattern