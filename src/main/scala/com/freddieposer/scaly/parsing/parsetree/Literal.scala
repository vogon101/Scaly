package com.freddieposer.scaly.parsing.parsetree

case class IntLiteral(value: Int) extends Literal

case class FloatLiteral(value: Float) extends Literal

case class BooleanLiteral(value: Boolean) extends Literal

case class CharLiteral(value: Char) extends Literal

case class StringLiteral(value: String) extends Literal

case class SymbolLiteral(value: Symbol) extends Literal

case object NullLiteral extends Literal