package com.freddieposer.scaly.typechecker.types

import com.freddieposer.scaly.AST.{ScalyAST, ScalyClassDef, ScalyTemplate, Statement}
import com.freddieposer.scaly.typechecker.context.TypeContext._
import com.freddieposer.scaly.typechecker.context.{ThisTypeContext, TypeContext}
import com.freddieposer.scaly.typechecker.types.ScalyType._

import scala.collection.mutable

trait PlaceholderType

sealed abstract class ScalyType {

  def members: TypeMap

  def visited: Boolean

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


