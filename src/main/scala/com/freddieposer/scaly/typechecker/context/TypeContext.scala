package com.freddieposer.scaly.typechecker.context

import com.freddieposer.scaly.typechecker.context.TypeContext.{Location, TypeMap}
import com.freddieposer.scaly.typechecker.types.{ScalyType, SymbolSource}
import com.freddieposer.scaly.typechecker.types.SymbolSource.SymbolSource

import scala.collection.mutable

class TypeContext(
                   val types: TypeMap,
                   val vars: TypeMap,
                   val parent: Option[TypeContext],
                 ) {

  private type MMap[K, V] = mutable.Map[K, V]

  def escalateVar(name: String): Option[Location] = getVarType(name)

  def getWellFormedType(name: String): Option[Location] =
    if (types isDefinedAt name) types get name
    else parent.flatMap(_ getWellFormedType name)

  def getVarType(name: String): Option[Location] =
    if (vars isDefinedAt name) vars get name
    else parent.flatMap(_ escalateVar name)

  final def addType(e: (String, Location)): TypeContext = addTypes(List(e))

  final def addVar(e: (String, Location)): TypeContext = addVars(List(e))

  def addVars(es: List[(String, Location)]): TypeContext =
    TypeContext(types, vars ++ es, parent)

  def addVars(es: TypeMap): TypeContext =
    TypeContext(types, vars ++ es, parent)

  def addTypes(es: List[(String, Location)]): TypeContext =
    TypeContext(types ++ es, vars, parent)

  def extend(types: TypeMap, vars: TypeMap): TypeContext =
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

  case class Location(typ: ScalyType, source: SymbolSource) {
    def writable: Option[Location] = SymbolSource.writable(source).map(Location(typ, _))
  }

  implicit def WrapLocation(t: (ScalyType, SymbolSource)) = Location(t._1, t._2)

  type TypeMap = Map[String, Location]

  def apply(types: TypeMap, vars: TypeMap, parent: Option[TypeContext] = None): TypeContext =
    new TypeContext(types, vars, parent)

  def buildTypeMap(map: Map[String, ScalyType], source: SymbolSource): TypeMap =
    map.map { case (s, t) => s -> (t, source) }

  def buildTypeMap(source: SymbolSource)(items: (String, ScalyType)*): TypeMap = buildTypeMap(items.toMap, source)

  implicit def unwrapLocation(location: Location): ScalyType = location.typ

}

