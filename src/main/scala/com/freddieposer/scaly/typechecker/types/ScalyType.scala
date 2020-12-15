package com.freddieposer.scaly.typechecker.types

import com.freddieposer.scaly.AST.{ScalyAST, ScalyClassDef, ScalyTemplate, Statement}
import com.freddieposer.scaly.typechecker.context.TypeContext._
import com.freddieposer.scaly.typechecker.context.{ThisTypeContext, TypeContext}
import com.freddieposer.scaly.typechecker.types.ScalyType._

import scala.collection.mutable

trait PlaceholderType

sealed abstract class ScalyType {

  protected def members: TypeMap

  val parent: Option[ScalyType]

  def visited: Boolean

  //TODO: TypeInterpretation should allow a class to be interpreted within a TypeContext etc
  //  This could be syntactic sugar to help slim down the TypeChecker - taking over functions like
  //  convert type. I do not want to have this function have knowledge of the TypeChecker so
  //  having an explicit interpretation might be a good compromise.
  //  This probably needs sitting down and actually planning out but ¯\_(ツ)_/¯
  def getMember(id: String)(implicit context: TypeContext): Option[ScalyType] =
    members.get(id).orElse(parent.flatMap(_.getMember(id)))


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


