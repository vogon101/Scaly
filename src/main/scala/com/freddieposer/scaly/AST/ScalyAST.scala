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

case class ScalyClassDef(
                          id: String,
                          parents: List[String],
                          body: Option[ScalyTemplate],
                          params: List[List[ClassParam]]
                        ) extends ScalyAST with TopLevelStatement

case class ScalyObjectDef(
                           id: String,
                           parents: List[String],
                           body: Option[ScalyTemplate]
                         ) extends ScalyAST with TopLevelStatement

case class ScalyTemplate(stats: List[Statement]) extends ScalyAST

case class ClassParam(
                       modifiers: List[String],
                       memberType: String,
                       id: String,
                       paramType: AST_ScalyType,
                       defaultValue: Option[Expr]
                     )

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