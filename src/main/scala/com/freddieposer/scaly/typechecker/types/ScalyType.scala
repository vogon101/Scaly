package com.freddieposer.scaly.typechecker.types

import com.freddieposer.scaly.AST.ScalyAST
import com.freddieposer.scaly.typechecker.context.TypeContext._
import com.freddieposer.scaly.typechecker.types.ScalyType._

import scala.collection.mutable

trait PlaceholderType

sealed abstract class ScalyType {

  protected def members: TypeMap

  val parent: Option[ScalyType]

  def visited: Boolean

  def getOwnMember(id: String): Option[ScalyType] =
    members.get(id)

}

object ScalyType {

  lazy val defaultMembers: TypeMap = Map(

  )

}

abstract class StaticScalyType extends ScalyType {
  override val visited: Boolean = true
  //TODO: Parents for static types
  override val parent: Option[ScalyType] = None
}

abstract class ASTScalyType extends ScalyType {

  private var _visited: Boolean = false

  override def visited: Boolean = _visited

  val node: ScalyAST

  protected def constructMutable(f: mutable.Map[String, ScalyType] => Unit): TypeMap = {
    _visited = true
    val ms = mutable.Map[String, ScalyType]()
    f(ms)
    defaultMembers ++ ms.toMap
  }

  protected def construct(f: => TypeMap): TypeMap = {
    _visited = true
    f
  }

}

//TODO: Mixins


