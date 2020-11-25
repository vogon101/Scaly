package com.freddieposer.scaly.typechecker.context

import com.freddieposer.scaly.typechecker.context.TypeContext.TypeMap
import com.freddieposer.scaly.typechecker.types.ScalyType

import scala.collection.mutable

class TypeContext(
                   val types: TypeMap,
                   val vars: TypeMap,
                   val parent: Option[TypeContext],
                 ) {

  private type MMap[K, V] = mutable.Map[K, V]

  def getWellFormedType(name: String): Option[ScalyType] =
    if (types isDefinedAt name) types get name
    else parent.flatMap(_ getWellFormedType name)

  def getVarType(name: String): Option[ScalyType] =
    if (vars isDefinedAt name) vars get name
    else parent.flatMap(_ getVarType name)

  def addType(e: (String, ScalyType)): TypeContext =
    TypeContext(types + e, vars, parent)

  def addVar(e: (String, ScalyType)): TypeContext =
    TypeContext(types, vars + e, parent)

  override def toString: String =
    f"""
       |Context:
       |  Types: $types
       |  Vars: $vars
       |  Parent: $parent
       |""".stripMargin

}

object TypeContext {
  type TypeMap = Map[String, ScalyType]

  def apply(types: TypeMap, vars: TypeMap, parent: Option[TypeContext] = None): TypeContext =
    new TypeContext(types, vars, parent)

}

