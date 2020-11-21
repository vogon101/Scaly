package com.freddieposer.scaly.parsing

import com.freddieposer.scaly.parsing.antlr.{ScalyBaseVisitor, ScalyVisitor}
import com.freddieposer.scaly.parsing.antlr.ScalyParser._
import com.freddieposer.scaly.parsing.parsetree.PTWrappers.PTSeq
import com.freddieposer.scaly.parsing.parsetree._

import scala.jdk.CollectionConverters.CollectionHasAsScala

trait ScalyExprParsingVisitor {

  protected[this] val exprVisitor: ScalyVisitor[Expr]
  private val parsingUtils = new ParsingUtils[Expr](exprVisitor.visit)
  import parsingUtils._

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

  //TODO - ignoring ascriptions
  def visitExpr1_postfix(ctx: Expr1_postfixContext): Expr =
    visitPostfixExpr(ctx.postfixExpr())

  def visitPostfixExpr(ctx: PostfixExprContext): Expr =
    PostfixExpr(visitInfixExpr(ctx.infixExpr()), Option(ctx.Id()).map(_.getText))

  def visitInfixExpr(ctx: InfixExprContext): Expr =
    if (ctx.prefixExpr() != null) visitPrefixExpr(ctx.prefixExpr())
    else ApplicationExpr(
      MemberAccessExpr(ctx.infixExpr(0).accept(exprVisitor), ctx.Id().getText),
      List(visitInfixExpr(ctx.infixExpr(1)))
    )

  def visitPrefixExpr(ctx: PrefixExprContext): PrefixExpr =
    PrefixExpr(
      visitOne[Expr](ctx.simpleExpr(), ctx.simpleExpr1()),
      Option(ctx.prefixDef()).map(_.getText)
    )

  def visitSimpleExpr(ctx: SimpleExprContext): Expr =
    if (ctx.blockExpr() != null) visitBlockExpr(ctx.blockExpr())
    else InstantiationExpr(???)

  def visitSimpleExpr1_underscore(ctx: SimpleExpr1_underscoreContext): Expr = UnderscoreExpr

  def visitSimpleExpr1_member1(ctx: SimpleExpr1_member1Context): Expr =
    MemberAccessExpr(ctx.simpleExpr().accept(exprVisitor), ctx.Id().getText)

  def visitSimpleExpr1_member2(ctx: SimpleExpr1_member2Context): ParseTree =
    MemberAccessExpr(ctx.simpleExpr1().accept(exprVisitor), ctx.Id().getText)

  def visitSimpleExpr1_application(ctx: SimpleExpr1_applicationContext): ApplicationExpr =
    ApplicationExpr(ctx.simpleExpr1().accept(exprVisitor), visitArgumentExprs(ctx.argumentExprs()))

  def visitSimpleExpr1_stableID(ctx: SimpleExpr1_stableIDContext): IDExpr =
    visitStableId(ctx.stableId())

  def visitSimpleExpr1_brackets(ctx: SimpleExpr1_bracketsContext): Expr =
    if (ctx.exprs() == null) UnitExpr
    else visitExprs(ctx.exprs()).toList match {
      case Nil => UnitExpr
      case x :: Nil => x
      case xs => TupleExpr(xs)
    }

  def visitSimpleExpr1_literal(ctx: SimpleExpr1_literalContext): Literal = visitAs[Literal](ctx.literal())

  def visitExprs(ctx: ExprsContext): PTSeq[Expr] =
    ctx.expr().map(_.accept(exprVisitor))

  def visitArgumentExprs(ctx: ArgumentExprsContext): PTSeq[Expr] =
    Option(ctx.exprs()).map(visitExprs).getOrElse(List())

  def visitBlockExpr(ctx: BlockExprContext): Expr =
    BlockExpr(
      ctx.block().blockStat().map(visitAs[ParseTree](_)),
      Option(ctx.block().resultExpr()).map(visitResultExpr)
    )

  def visitResultExpr(ctx: ResultExprContext): Expr = visitAs[Expr](ctx.expr1())

  def visitStableId(ctx: StableIdContext): IDExpr =
    if (ctx.stableId() != null) visitStableId(ctx.stableId()) :: IDExpr(List(ctx.Id().getText))
    else IDExpr(List(ctx.Id().getText))

}
