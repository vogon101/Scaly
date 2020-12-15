package com.freddieposer.scaly.typechecker.types

import com.freddieposer.scaly.AST._
import com.freddieposer.scaly.typechecker.context.TypeContext.TypeMap
import com.freddieposer.scaly.typechecker.types.stdtypes.{ScalyObject, ScalyValType}

case class ScalyASTPlaceholderType(node: AST_ScalyType) extends ASTScalyType with PlaceholderType {
  override lazy val memberTypes: TypeMap = ???
  override lazy val parent: Option[ScalyType] = ???
}

class ScalyASTClassType(
                         val name: String,
                         private val _parent: Option[ScalyType],
                         val node: ScalyClassDef
                       ) extends ASTScalyType with PlaceholderType {


  override lazy val parent: Option[ScalyType] = _parent.orElse(Some(ScalyObject))

  override lazy val memberTypes: TypeMap = construct {

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

  override def equals(obj: Any): Boolean = obj match {
    case that: ScalyASTClassType =>
      (that.name == name) && (that.node equals node) && (that.parent equals parent)
    case _ => false
  }

  override def toString: String = s"ClassType($name < $parent)"

}

object ScalyASTClassType {

  def apply(name: String, _parent: Option[ScalyType], node: ScalyClassDef): ScalyASTClassType =
    new ScalyASTClassType(name, _parent, node)

  def unapply(arg: ScalyASTClassType): Option[(String, Option[ScalyType], ScalyClassDef)] =
    Some((arg.name, arg.parent, arg.node))


}

