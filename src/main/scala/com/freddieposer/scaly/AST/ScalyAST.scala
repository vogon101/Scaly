package com.freddieposer.scaly.AST

sealed abstract class ScalyAST

sealed trait TopLevelStatement extends ScalyAST

case class CompilationUnit(statements: List[TopLevelStatement]) extends ScalyAST

sealed abstract class AST_ScalyType extends ScalyAST

case class AST_ScalyTypeName(name: String) extends AST_ScalyType

case class AST_ScalyTypeSelect(lhs: Expr, rhs: String) extends AST_ScalyType

case class AST_TupleScalyType(types: List[AST_ScalyType]) extends AST_ScalyType

case class AST_FunctionScalyType(arguments: List[AST_ScalyType], returnType: AST_ScalyType) extends AST_ScalyType

abstract class Expr extends Statement

abstract class Literal extends Expr

sealed abstract class TemplateDef extends TopLevelStatement {

  val id: String
  val parents: List[(AST_ScalyTypeName, List[Expr])]
  val body: Option[ScalyTemplate]

}

object TemplateDef {

  def unapply(arg: TemplateDef): Option[(String, List[(AST_ScalyTypeName, List[Expr])], Option[ScalyTemplate])] =
    Some(arg.id, arg.parents, arg.body)

}

case class ScalyClassDef(
                          id: String,
                          //TODO: Good god this is horrible
                          parents: List[(AST_ScalyTypeName, List[Expr])],
                          body: Option[ScalyTemplate],
                          //TODO: Multiple sets of class params
                          params: List[ClassParam]
                        ) extends TemplateDef

case class ScalyObjectDef(
                           id: String,
                           parents: List[(AST_ScalyTypeName, List[Expr])],
                           body: Option[ScalyTemplate]
                         ) extends TemplateDef

case class ScalyTemplate(stats: List[Statement]) extends ScalyAST

sealed abstract class ClassParam {
  val modifiers: List[String]
  val id: String
  val paramType: AST_ScalyType
  val defaultValue: Option[Expr]
}

case class ValClassParam(modifiers: List[String], id: String, paramType: AST_ScalyType, defaultValue: Option[Expr]) extends ClassParam

case class VarClassParam(modifiers: List[String], id: String, paramType: AST_ScalyType, defaultValue: Option[Expr]) extends ClassParam

case class NonMemberClassParam(modifiers: List[String], id: String, paramType: AST_ScalyType, defaultValue: Option[Expr]) extends ClassParam

sealed abstract class Statement extends ScalyAST

sealed abstract class Dcl extends Statement {
  val id: String
}

object Dcl {
  def unapply(arg: Dcl): Option[String] = Some(arg.id)
}

sealed abstract class MemberDcl extends Dcl {
  val declType: Option[AST_ScalyType]
  val rhs: Expr
}

object MemberDcl {

  def unapply(arg: MemberDcl): Option[(String, Option[AST_ScalyType], Expr)] =
    Some((arg.id, arg.declType, arg.rhs))

}

case class ValDef(
                   id: String,
                   declType: Option[AST_ScalyType],
                   rhs: Expr
                 ) extends MemberDcl

case class VarDef(
                   id: String,
                   declType: Option[AST_ScalyType],
                   rhs: Expr
                 ) extends MemberDcl

case class DefDef(
                   id: String,
                   params: List[List[FunParam]],
                   retType: Option[AST_ScalyType],
                   body: Expr
                 ) extends Dcl

case class FunParam(
                     name: String,
                     pType: AST_ScalyType
                   ) extends ScalyAST

class Pattern extends ScalyAST {

}

case class MatchCase(pattern: Pattern, guard: Option[Expr], result: Expr)