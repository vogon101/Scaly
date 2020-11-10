package com.freddieposer.scaly.parsing.parsetree

// All inherit from com.freddieposer.scaly.parsing.Expr

case class IfExpr(cond: Expr, yes: Expr, no: Option[Expr]) extends Expr

case class WhileExpr(cond: Expr, body: Expr) extends Expr

case class TryExpr(body: Expr, catchBlock: Option[Expr], finallyBlock: Option[Expr]) extends Expr

case class DoWhileExpr(cond: Expr, body: Expr) extends Expr

case class ThrowExpr(body: Expr) extends Expr

case class ReturnExpr(arg: Expr) extends Expr

case class AssignmentExpr () extends Expr {
  ??? // TODO
}

case class AssignmentExpr2 () extends Expr {
  ??? // TODO
}

case class PostfixExpr () extends Expr {
  ??? // TODO
}