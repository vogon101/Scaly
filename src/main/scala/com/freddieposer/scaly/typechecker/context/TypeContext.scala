package com.freddieposer.scaly.typechecker.context

import com.freddieposer.scaly.typechecker.context.TypeContext.{Location, TypeMap}
import com.freddieposer.scaly.typechecker.types.SymbolSource.SymbolSource
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType.ScalyUnitType
import com.freddieposer.scaly.typechecker.types.{ScalyType, SymbolSource}

import scala.collection.mutable

class TypeContext(
                   val types: TypeMap,
                   val vars: TypeMap,
                   val parent: Option[TypeContext],
                 ) {

  private type MMap[K, V] = mutable.Map[K, V]

  /**
   * Used only within `TypeContext.getVarType` - Assumed that this is coming from an another context for the purpose of
   * calculating closures.
   *
   * @param name Name of variable to look for
   * @return
   */
  def escalateVar(name: String): Option[Location] = getVarType(name)

  def getWellFormedType(name: String): Option[Location] =
    if (types isDefinedAt name) types get name
    else if (types isDefinedAt (name + "$")) types get (name + "$")
    else parent.flatMap(_ getWellFormedType name)
      .orElse(parent.flatMap(_ getWellFormedType (name + "$")))

  def getVarType(name: String): Option[Location] =
    if (vars isDefinedAt name) vars get name
    else parent.flatMap(_ escalateVar name)

  final def addType(e: (String, Location)): TypeContext = addTypes(List(e))

  def addTypes(es: List[(String, Location)]): TypeContext =
    TypeContext(types ++ es, vars, parent)

  final def addVar(e: (String, Location)): TypeContext = addVars(List(e))

  def addVars(es: List[(String, Location)]): TypeContext =
    TypeContext(types, vars ++ es, parent)

  def addVars(es: TypeMap): TypeContext =
    TypeContext(types, vars ++ es, parent)

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

  type TypeMap = Map[String, Location]

  def apply(types: TypeMap, vars: TypeMap, parent: Option[TypeContext] = None): TypeContext =
    new TypeContext(types, vars, parent)

  implicit def WrapLocation(t: (ScalyType, SymbolSource)) = Location(t._1, t._2)

  def buildTypeMap(source: SymbolSource)(items: (String, ScalyType)*): TypeMap = buildTypeMap(items.toMap, source)

  def buildTypeMap(map: Map[String, ScalyType], source: SymbolSource): TypeMap =
    map.map { case (s, t) => s -> (t, source) }

  case class Location(typ: ScalyType, source: SymbolSource) {
    def writable: Option[Location] = SymbolSource.writable(source).map(Location(typ, _))
  }

  object Location {
    def apply(typ: ScalyType, source: SymbolSource) = new Location(typ, source)

    def local: Location = Location(SymbolSource.LOCAL)

    def local_w: Location = Location(SymbolSource.LOCAL_WRITABLE)

    def apply(source: SymbolSource) = new Location(ScalyUnitType, source)
  }

  implicit def unwrapLocation(location: Location): ScalyType = location.typ

}

final object EmptyContext extends TypeContext(Map(), Map(), None) {


}

