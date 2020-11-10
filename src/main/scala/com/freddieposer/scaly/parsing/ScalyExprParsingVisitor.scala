package com.freddieposer.scaly.parsing

import com.freddieposer.scaly.parsing.antlr.{ScalyBaseVisitor, ScalyVisitor}
import com.freddieposer.scaly.parsing.antlr.ScalyParser._
import com.freddieposer.scaly.parsing.parsetree.{DoWhileExpr, Expr, IfExpr, ParseTree, ReturnExpr, ThrowExpr, TryExpr, WhileExpr}

import scala.jdk.CollectionConverters.CollectionHasAsScala

trait ScalyExprParsingVisitor {

  val exprVisitor: ScalyVisitor[Expr]

   def visitExpr(ctx: ExprContext): Expr =
    if (ctx.expr1() == null) ???
    else ctx.expr1().accept(exprVisitor)

   def visitExpr1_if(ctx: Expr1_ifContext): Expr =
    IfExpr(
      ctx.expr(0).accept(exprVisitor),
      ctx.expr(1).accept(exprVisitor),
      ctx.expr().asScala.toList.lift(2).map(_ accept exprVisitor)
    )

   def visitExpr1_while(ctx: Expr1_whileContext): Expr =
    WhileExpr(
      ctx.expr(0).accept(exprVisitor),
      ctx.expr(1).accept(exprVisitor)
    )

   def visitExpr1_try(ctx: Expr1_tryContext): Expr =
    TryExpr(
      ctx.expr(0).accept(exprVisitor),
      ???, ??? //TODO
    )

   def visitExpr1_dowhile(ctx: Expr1_dowhileContext): Expr =
    DoWhileExpr(
      ctx.expr(1).accept(exprVisitor),
      ctx.expr(0).accept(exprVisitor)
    )

   def visitExpr1_throw(ctx: Expr1_throwContext): Expr =
    ThrowExpr(ctx.expr().accept(exprVisitor))

   def visitExpr1_return(ctx: Expr1_returnContext): Expr =
    ReturnExpr(ctx.expr().accept(exprVisitor))

  //TODO
   def visitExpr1_assignment(ctx: Expr1_assignmentContext): Expr = ???

  //TODO
   def visitExpr1_assignment2(ctx: Expr1_assignment2Context): Expr = ???

  //TODO
   def visitExpr1_postfix(ctx: Expr1_postfixContext): Expr = ???

   def visitPostfixExpr(ctx: PostfixExprContext): Expr = ???

   def visitInfixExpr(ctx: InfixExprContext): Expr = ???

   def visitPrefixExpr(ctx: PrefixExprContext): Expr = ???

   def visitSimpleExpr(ctx: SimpleExprContext): Expr = ???

   def visitSimpleExpr1(ctx: SimpleExpr1Context): Expr = ???

   def visitSimpleExpr1_underscore(ctx: SimpleExpr1_underscoreContext): Expr = ???

   def visitSimpleExpr1_member1(ctx: SimpleExpr1_member1Context): Expr = ???

   def visitSimpleExpr1_member2(ctx: SimpleExpr1_member2Context): Expr = ???

   def visitSimpleExpr1_application(ctx: SimpleExpr1_applicationContext): Expr = ???

   def visitSimpleExpr1_stableID(ctx: SimpleExpr1_stableIDContext): Expr = ???

   def visitSimpleExpr1_brackets(ctx: SimpleExpr1_bracketsContext): Expr = ???

   def visitSimpleExpr1_literal(ctx: SimpleExpr1_literalContext): Expr = ???

   def visitExprs(ctx: ExprsContext): Expr = ???

   def visitArgumentExprs(ctx: ArgumentExprsContext): Expr = ???

   def visitBlockExpr(ctx: BlockExprContext): Expr = ???

   def visitResultExpr(ctx: ResultExprContext): Expr = ???

   def visitConstrExpr(ctx: ConstrExprContext): Expr = ???
}
