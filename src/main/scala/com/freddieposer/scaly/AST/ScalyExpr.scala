package com.freddieposer.scaly.AST

case class SelectExpr(lhs: Expr, rhs: String) extends Expr

case class TupleExpr(elems: List[Expr]) extends Expr

case class Application(lhs: Expr, args: List[Expr]) extends Expr

case class ApplicationWithType(lhs: Expr, targs: List[AST_ScalyType]) extends Expr

case class Block(statements: List[Statement]) extends Expr

case class IDExpr(name: String) extends Expr

case class IfExpr(cond: Expr, tBranch: Expr, fBranch: Expr) extends Expr

case class NewExpr(typ: AST_ScalyType, params: List[Expr]) extends Expr

case class AssignExpr(lhs: Expr, rhs: Expr) extends Expr

case class WhileExpr(cond: Expr, body: Expr) extends Expr

case class FunctionExpr(params: List[FunParam], body: Expr) extends Expr

case class MatchExpr(lhs: Expr, cases: List[MatchCase]) extends Expr