package com.freddieposer.scaly.AST

case class IntLiteral(value: Int) extends Literal

case class FloatLiteral(value: Float) extends Literal

case class DoubleLiteral(value: Double) extends Literal

case class BooleanLiteral(value: Boolean) extends Literal

case class CharLiteral(value: Char) extends Literal

case class StringLiteral(value: String) extends Literal

case class SymbolLiteral(value: Symbol) extends Literal

case object NullLiteral extends Literal

case object UnitLiteral extends Literal