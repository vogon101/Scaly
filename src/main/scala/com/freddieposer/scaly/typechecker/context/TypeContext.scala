package com.freddieposer.scaly.typechecker.context

import com.freddieposer.scaly.typechecker.context.TypeContext.TypeMap
import com.freddieposer.scaly.typechecker.types.ScalyType

import scala.collection.mutable

class TypeContext(
                   val types: TypeMap,
                   val vars: TypeMap,
                   val parent: Option[TypeContext],
                 ) {

  println(parent)

  private type MMap[K, V] = mutable.Map[K, V]

  def getWellFormedType(name: String): Option[ScalyType] =
    if (types isDefinedAt name) types get name
    else parent.flatMap(_ getWellFormedType name)

  def getVarType(name: String): Option[ScalyType] =
    if (vars isDefinedAt name) vars get name
    else parent.flatMap(_ getVarType name)

  final def addType(e: (String, ScalyType)): TypeContext = addTypes(List(e))

  final def addVar(e: (String, ScalyType)): TypeContext = addVars(List(e))

  def addVars(es: List[(String, ScalyType)]): TypeContext =
    TypeContext(types, vars ++ es, parent)

  def addTypes(es: List[(String, ScalyType)]): TypeContext =
    TypeContext(types ++ es, vars, parent)

  def child(types: TypeMap, vars: TypeMap): TypeContext =
    TypeContext(types, vars, Some(this))

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

