package com.freddieposer.scaly.typechecker.types

import com.freddieposer.scaly.AST.{Dcl, ScalyClassDef, ScalyTemplate, Statement}
import com.freddieposer.scaly.typechecker.context.{ThisTypeContext, TypeContext}
import com.freddieposer.scaly.typechecker.context.TypeContext.TypeMap

case class ScalyASTClassType(
                              name: String,
                              parent: Option[ScalyType],
                              node: ScalyClassDef
                            ) extends ASTScalyType with PlaceholderType {

  private var _visited: Boolean = false

  override def visited: Boolean = _visited

  override def members: TypeMap = construct {
    node.body match {
      case Some(ScalyTemplate(stats)) =>
        stats.map {
          case x @ Dcl(id) => id -> ScalyASTPlaceholderType(x)
        }.toMap
      case None => Map()
    }
  }

}

case class ScalyASTPlaceholderType(node: Statement) extends ASTScalyType with PlaceholderType {
  override lazy val members: TypeMap = ???
}