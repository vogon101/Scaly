package com.freddieposer.scaly.parsing.parsetree

// All inherit from com.freddieposer.scaly.parsing.Expr

case class IfExpr(cond: Expr, yes: Expr, no: Option[Expr]) extends Expr

case class WhileExpr(cond: Expr, body: Expr) extends Expr

case class TryExpr(body: Expr, catchBlock: Option[Expr], finallyBlock: Option[Expr]) extends Expr

case class DoWhileExpr(cond: Expr, body: Expr) extends Expr

case class ThrowExpr(body: Expr) extends Expr

case class ReturnExpr(arg: Expr) extends Expr

case class AssignmentExpr() extends Expr {
  ??? // TODO
}

case class AssignmentExpr2() extends Expr {
  ??? // TODO
}

case class PostfixExpr(infixExpr: Expr, postfixID: Option[String]) extends Expr {
  override def toStringTree: StringTree =
    postfixID match {
      case None => infixExpr.toStringTree
      case Some(id) => StringTreeNode("Postfix Expr", List(
        "lhs" -> infixExpr.toStringTree,
        "rhs" -> id
      ))
    }
}

abstract class InfixExpr extends Expr

//TODO: Postfix(Prefix(Expr)) with no prefix or postfix shouldn't be wrapped
//  transform in parse visitor
case class PrefixExpr(expr: Expr, prefix: Option[String]) extends InfixExpr {
  override def toStringTree: StringTree =
    prefix match {
      case None => expr.toStringTree
      case Some(id) => StringTreeNode("Prefix Expr", List(
        "lhs" -> id,
        "rhs" -> expr.toStringTree
      ))
    }
}

//case class InfixApplicationExpr(lhs: InfixExpr, id: String, rhs: InfixExpr) extends InfixExpr

case class InstantiationExpr(instType: ScalyType) extends Expr

case object UnderscoreExpr extends Expr {
  override def toStringTree: StringTree = "_"
}

case object UnitExpr extends Expr {
  override def toStringTree: StringTree = "()"
}

case class MemberAccessExpr(expr: Expr, id: String) extends Expr {
  override def toStringTree: StringTree = expr match {
    case MemberAccessExpr(le, lid) => StringTreeNode("Member Access", List(
      "lhs" -> le.toStringTree,
      "rhs" -> f"$lid.$id"
    ))
    case _ => StringTreeNode("Member Access", List(
      "lhs" -> expr.toStringTree,
      "rhs" -> id
    ))
  }
}

case class ApplicationExpr(lhs: Expr, args: List[Expr]) extends Expr {
  override def toStringTree: StringTree = StringTreeNode("Application", List(
    "lhs" -> lhs.toStringTree,
    "args" -> StringTree.fromIndexedList("", args)
  ))
}

//TODO: Using strings here is not great given this can include special cases (super, this)
case class IDExpr(members: List[String]) extends Expr {

  def ::(that: IDExpr): IDExpr = IDExpr(that.members ::: members)

  override def toString: String = f"ID(${members.mkString(".")})"

  override def toStringTree: StringTree = toString

}

case class TupleExpr(members: List[Expr]) extends Expr {
  override def toStringTree: StringTree = StringTree.fromIndexedList("Tuple", members)
}

case class BlockExpr(statements: List[ParseTree], result: Option[Expr]) extends Expr {
  override def toStringTree: StringTree = StringTreeNode ("Block", List(
    "statements" -> StringTree.fromIndexedList("", statements),
    "result" -> result
  ))
}