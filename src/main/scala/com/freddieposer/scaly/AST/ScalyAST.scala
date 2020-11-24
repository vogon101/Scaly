package com.freddieposer.scaly.AST

sealed abstract class ScalyAST

sealed trait TopLevelStatement extends ScalyAST

case class CompilationUnit(statements: List[TopLevelStatement]) extends ScalyAST

abstract class ScalyType extends ScalyAST

case class ScalyTypeName(name: String) extends ScalyType

case class ScalyTypeSelect(lhs: Expr, rhs: String) extends ScalyType

case class ScalyTupleType(types: List[ScalyType]) extends ScalyType

case class ScalyFunctionType(arguments: List[ScalyType], returnType: ScalyType) extends ScalyType

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
                       paramType: ScalyType,
                       defaultValue: Option[Expr]
                     )

sealed abstract class Statement extends ScalyAST {

}

case class ValDef(
                   id: String,
                   declType: Option[ScalyType],
                   rhs: Expr
                 ) extends Statement

case class VarDef(
                   id: String,
                   declType: Option[ScalyType],
                   rhs: Expr
                 ) extends Statement

case class DefDef(
                   id: String,
                   params: List[List[FunParam]],
                   retType: Option[ScalyType],
                   body: Expr
                 ) extends Statement

case class FunParam(
                name: String,
                pType: ScalyType
                )