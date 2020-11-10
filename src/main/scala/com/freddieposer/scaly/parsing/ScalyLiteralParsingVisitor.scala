package com.freddieposer.scaly.parsing

import com.freddieposer.scaly.parsing.antlr.{ScalyBaseVisitor, ScalyParser, ScalyVisitor}
import com.freddieposer.scaly.parsing.parsetree._

trait ScalyLiteralParsingVisitor {

  val literalVisitor: ScalyVisitor[Literal]

   def visitLiteral_int(ctx: ScalyParser.Literal_intContext): Literal =
    IntLiteral(ctx.getText.toInt)

   def visitLiteral_float(ctx: ScalyParser.Literal_floatContext): Literal =
    FloatLiteral(ctx.getText.toFloat)

   def visitLiteral_bool(ctx: ScalyParser.Literal_boolContext): Literal =
    BooleanLiteral(ctx.getText equals "true")

   def visitLiteral_char(ctx: ScalyParser.Literal_charContext): Literal =
    CharLiteral(ctx.getText.charAt(0))

   def visitLiteral_string(ctx: ScalyParser.Literal_stringContext): Literal =
    StringLiteral(ctx.getText)

   def visitLiteral_symbol(ctx: ScalyParser.Literal_symbolContext): Literal =
    SymbolLiteral(Symbol(ctx.getText))

   def visitLiteral_null(ctx: ScalyParser.Literal_nullContext): Literal = NullLiteral
  
}
