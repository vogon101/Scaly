package com.freddieposer.scaly.typechecker.types

import com.freddieposer.scaly.AST.{ClassParam, ScalyAST}
import com.freddieposer.scaly.backend.internal.IST
import com.freddieposer.scaly.typechecker.context.TypeContext._
import com.freddieposer.scaly.typechecker.types.ScalyType._

import scala.collection.mutable

trait PlaceholderType {

}

sealed abstract class ScalyType extends IST {

  override val typ: ScalyType = this
  val parent: Option[ScalyType]

  def visited: Boolean

  def getOwnMemberLocation(id: String): Option[Location] =
    memberTypes.get(id)

  def getMemberLocation(id: String): Option[Location] =
    parent.flatMap(_.getMemberLocation(id)).orElse(getOwnMemberLocation(id))

  def globalName: Option[String] = None

  def constructor: Option[List[ClassParam]]

  protected def memberTypes: TypeMap

}

object ScalyType {

  lazy val defaultMembers: TypeMap = Map(

  )

}

abstract class StaticScalyType extends ScalyType {
  override val visited: Boolean = true
}

abstract class ASTScalyType extends ScalyType {

  val node: ScalyAST
  private var _visited: Boolean = false

  override def visited: Boolean = _visited

  protected def constructMutable(f: mutable.Map[String, Location] => Unit): TypeMap = {
    _visited = true
    val ms = mutable.Map[String, Location]()
    f(ms)
    defaultMembers ++ ms.toMap
  }

  protected def construct(f: => TypeMap): TypeMap = {
    _visited = true
    f
  }

}

//TODO: Mixins


