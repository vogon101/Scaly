package com.freddieposer.scaly.typechecker.types

import com.freddieposer.scaly.AST._
import com.freddieposer.scaly.typechecker.context.TypeContext.TypeMap

case class ScalyASTPlaceholderType(node: AST_ScalyType) extends ASTScalyType with PlaceholderType {
  override lazy val members: TypeMap = ???
  override lazy val parent: Option[ScalyType] = ???
}

case class ScalyASTClassType(
                              name: String,
                              parent: Option[ScalyType],
                              node: ScalyClassDef
                            ) extends ASTScalyType with PlaceholderType {


  override lazy val members: TypeMap = construct {

    def convertClause(clause: List[FunParam]): ScalyType =
      clause match {
        case Nil => ScalyValType.ScalyUnitType
        case x :: Nil => ScalyASTPlaceholderType(x.pType)
        case _ => ScalyTupleType(clause.map(p => ScalyASTPlaceholderType(p.pType)))
      }

    def convertParams(params: List[List[FunParam]], finalRet: ScalyType): ScalyType = {
      params match {
        case c :: Nil => ScalyFunctionType(Some(convertClause(c)), finalRet)
        case c :: cs => ScalyFunctionType(Some(convertClause(c)), convertParams(cs, finalRet))
        case Nil => ScalyFunctionType(None, finalRet)
      }
    }

    node.body match {
      case Some(ScalyTemplate(stats)) =>
        stats.map { case d: Dcl => d match {
          case ValDef(id, declType, rhs) => id -> ScalyASTPlaceholderType(declType.get)
          case VarDef(id, declType, rhs) => id -> ScalyASTPlaceholderType(declType.get)
          case DefDef(id, params, retType, body) =>
            id -> convertParams(params, ScalyASTPlaceholderType(retType.get))
          //TODO: Return could be none - inference
        }
        }.toMap
      case None => Map()
    }
  }

  private val _visited: Boolean = false

  override def visited: Boolean = _visited

}

