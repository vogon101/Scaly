package com.freddieposer.scaly.typechecker.types

import com.freddieposer.scaly.AST.{Dcl, DefDef, FunParam, ScalyASTType, ScalyClassDef, ScalyTemplate, Statement, ValDef, VarDef}
import com.freddieposer.scaly.typechecker.context.{ThisTypeContext, TypeContext}
import com.freddieposer.scaly.typechecker.context.TypeContext.TypeMap

case class ScalyASTClassType(
                              name: String,
                              parent: Option[ScalyType],
                              node: ScalyClassDef
                            ) extends ASTScalyType with PlaceholderType {

  private var _visited: Boolean = false

  override def visited: Boolean = _visited

  override lazy val members: TypeMap = construct {

    def convertClause(clause: List[FunParam]): ScalyType =
      clause match {
        case Nil => ScalyValType.ScalyUnitType
        case x :: Nil => ScalyASTPlaceholderType(x.pType)
        case _ => ScalyTupleType(clause.map(p => ScalyASTPlaceholderType(p.pType)))
      }

    def comvertParams(params: List[List[FunParam]], finalRet: ScalyType): ScalyType = {
      params match {
        case c :: Nil => ScalyFunctionType(convertClause(c), finalRet)
        case c :: cs  => ScalyFunctionType(convertClause(c), comvertParams(cs, finalRet))
        case Nil => ScalyFunctionType(ScalyValType.ScalyUnitType, finalRet)
      }
    }

    node.body match {
      case Some(ScalyTemplate(stats)) =>
        stats.map { case d: Dcl => d match {
          case ValDef(id, declType, rhs) => id -> ScalyASTPlaceholderType(declType.get)
          case VarDef(id, declType, rhs) => id -> ScalyASTPlaceholderType(declType.get)
          case DefDef(id, params, retType, body) =>
            id -> comvertParams(params, ScalyASTPlaceholderType(retType.get))
              //TODO: Return could be none - inference
        }}.toMap
      case None => Map()
    }
  }

}

case class ScalyASTPlaceholderType(node: ScalyASTType) extends ASTScalyType with PlaceholderType {
  override lazy val members: TypeMap = ???
}