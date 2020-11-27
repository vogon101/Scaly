package com.freddieposer.scaly.AST

sealed abstract class ScalyAST

sealed trait TopLevelStatement extends ScalyAST

case class CompilationUnit(statements: List[TopLevelStatement]) extends ScalyAST

sealed abstract class ScalyASTType extends ScalyAST

case class ASTScalyTypeName(name: String) extends ScalyASTType

case class ASTScalyTypeSelect(lhs: Expr, rhs: String) extends ScalyASTType

case class ASTScalyTupleType(types: List[ScalyASTType]) extends ScalyASTType

case class ASTScalyFunctionType(arguments: List[ScalyASTType], returnType: ScalyASTType) extends ScalyASTType

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
                       paramType: ScalyASTType,
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
                   declType: Option[ScalyASTType],
                   rhs: Expr
                 ) extends Dcl

case class VarDef(
                   id: String,
                   declType: Option[ScalyASTType],
                   rhs: Expr
                 ) extends Dcl

case class DefDef(
                   id: String,
                   params: List[List[FunParam]],
                   retType: Option[ScalyASTType],
                   body: Expr
                 ) extends Dcl

case class FunParam(
                name: String,
                pType: ScalyASTType
                ) extends ScalyAST