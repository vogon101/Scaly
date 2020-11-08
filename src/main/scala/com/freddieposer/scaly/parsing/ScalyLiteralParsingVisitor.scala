package com.freddieposer.scaly.parsing

import com.freddieposer.scaly.parsing.antlr.{ScalyBaseVisitor, ScalyParser}
import com.freddieposer.scaly.parsing.parsetree._

class ScalyLiteralParsingVisitor extends ScalyBaseVisitor[Literal] {

  override def visitLiteral_int(ctx: ScalyParser.Literal_intContext): Literal = ???

  override def visitLiteral_float(ctx: ScalyParser.Literal_floatContext): Literal = ???

  override def visitLiteral_bool(ctx: ScalyParser.Literal_boolContext): Literal = ???

  override def visitLiteral_char(ctx: ScalyParser.Literal_charContext): Literal = ???

  override def visitLiteral_string(ctx: ScalyParser.Literal_stringContext): Literal = ???

  override def visitLiteral_symbol(ctx: ScalyParser.Literal_symbolContext): Literal = ???

  override def visitLiteral_null(ctx: ScalyParser.Literal_nullContext): Literal = NullLiteral
  
}
