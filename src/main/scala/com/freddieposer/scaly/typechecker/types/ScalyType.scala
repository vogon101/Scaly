package com.freddieposer.scaly.typechecker.types

import com.freddieposer.scaly.AST.ScalyAST
import com.freddieposer.scaly.backend.internal.IST
import com.freddieposer.scaly.typechecker.context.TypeContext._
import com.freddieposer.scaly.typechecker.types.ScalyType._

import scala.collection.mutable

trait PlaceholderType {

}

sealed abstract class ScalyType extends IST {

  override val typ: ScalyType = this

  protected def memberTypes: TypeMap

  val parent: Option[ScalyType]

  def visited: Boolean

  def getOwnMember(id: String): Option[Location] =
    memberTypes.get(id)

  def getMember(id: String): Option[Location] =
    parent.flatMap(_.getMember(id)).orElse(getOwnMember(id))

  def globalName: Option[String] = None

}

object ScalyType {

  lazy val defaultMembers: TypeMap = Map(

  )

}

abstract class StaticScalyType extends ScalyType {
  override val visited: Boolean = true
}

abstract class ASTScalyType extends ScalyType {

  private var _visited: Boolean = false

  override def visited: Boolean = _visited

  val node: ScalyAST

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


