package com.freddieposer.scaly.AST

case class SelectExpr(lhs: Expr, rhs: String) extends Expr

case class TupleExpr(elems: List[Expr]) extends Expr

case class Application(lhs: Expr, args: List[Expr]) extends Expr

case class Block(statements: List[Statement]) extends Expr

case class IDExpr(name: String) extends Expr

case class IfExpr(cond: Expr, tBranch: Expr, fBranch: Expr) extends Expr

case class NewExpr(typ: AST_ScalyType, params: List[Expr]) extends Expr


