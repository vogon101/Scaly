package com.freddieposer.scaly.AST

sealed abstract class ScalyAST

sealed trait TopLevelStatement extends ScalyAST

case class CompilationUnit(statements: List[TopLevelStatement]) extends ScalyAST

abstract class ASTScalyType extends ScalyAST

case class ASTScalyTypeName(name: String) extends ASTScalyType

case class ASTScalyTypeSelect(lhs: Expr, rhs: String) extends ASTScalyType

case class ASTScalyTupleType(types: List[ASTScalyType]) extends ASTScalyType

case class ASTScalyFunctionType(arguments: List[ASTScalyType], returnType: ASTScalyType) extends ASTScalyType

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
                       paramType: ASTScalyType,
                       defaultValue: Option[Expr]
                     )

sealed abstract class Statement extends ScalyAST

sealed abstract class Dcl extends Statement {
  val id: String
}

object Dcl {
  def unapply(arg: Dcl): Option[String] = Some(arg.id)
}

case class ValDef(
                   id: String,
                   declType: Option[ASTScalyType],
                   rhs: Expr
                 ) extends Dcl

case class VarDef(
                   id: String,
                   declType: Option[ASTScalyType],
                   rhs: Expr
                 ) extends Dcl

case class DefDef(
                   id: String,
                   params: List[List[FunParam]],
                   retType: Option[ASTScalyType],
                   body: Expr
                 ) extends Dcl

case class FunParam(
                name: String,
                pType: ASTScalyType
                ) extends ScalyAST