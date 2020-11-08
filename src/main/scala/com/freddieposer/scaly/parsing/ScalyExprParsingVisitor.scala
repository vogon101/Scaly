package com.freddieposer.scaly.parsing

import com.freddieposer.scaly.parsing.antlr.ScalyBaseVisitor
import com.freddieposer.scaly.parsing.antlr.ScalyParser._
import com.freddieposer.scaly.parsing.parsetree.{Expr, ParseTree}

class ScalyExprParsingVisitor extends ScalyBaseVisitor[Expr] {
  
  override def visitExpr1_if(ctx: Expr1_ifContext): Expr = ???

  override def visitExpr1_while(ctx: Expr1_whileContext): Expr = ???

  override def visitExpr1_try(ctx: Expr1_tryContext): Expr = ???

  override def visitExpr1_dowhile(ctx: Expr1_dowhileContext): Expr = ???

  override def visitExpr1_throw(ctx: Expr1_throwContext): Expr = ???

  override def visitExpr1_return(ctx: Expr1_returnContext): Expr = ???

  override def visitExpr1_assignment(ctx: Expr1_assignmentContext): Expr = ???

  override def visitExpr1_assignment2(ctx: Expr1_assignment2Context): Expr = ???

  override def visitExpr1_postfix(ctx: Expr1_postfixContext): Expr = ???

}
