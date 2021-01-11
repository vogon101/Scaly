package com.freddieposer.scaly.typechecker.context

import com.freddieposer.scaly.typechecker.context.TypeContext.{Location, TypeMap}
import com.freddieposer.scaly.typechecker.types.SymbolSource

import scala.collection.{immutable, mutable}
import scala.collection.mutable.ListBuffer

class MutableClosureContext(
                             override val types: TypeMap,
                             override val vars: TypeMap,
                             val outer: TypeContext,
                             private val _freeVars: ListBuffer[String],
                             private val _closedVars: mutable.Map[String, Location]
                           ) extends TypeContext(types, vars, Some(outer)) {

  private def addFreeVar(name: String): Unit =
    if (!_freeVars.contains(name)) _freeVars.addOne(name)

  private def addClosedVar(name: String, location: Location): Unit =
    if (!_closedVars.contains(name)) _closedVars.addOne(name -> location)

  override def getVarType(name: String): Option[Location] =
    if (vars isDefinedAt name) vars get name
    else outer.escalateVar(name) match { //Add to free vars
      case lopt @ Some(l @ Location(_, SymbolSource.CLOSURE | SymbolSource.CLOSURE_WRITABLE)) =>
        addFreeVar(name)
        lopt
      case x => x
    }

  override def escalateVar(name: String): Option[Location] =
    if (vars.isDefinedAt(name)) vars.get(name).map {
      //Add to cell vars, return closure
      case l @ Location(t, SymbolSource.LOCAL) =>
        addClosedVar(name, l)
        Location(t, SymbolSource.CLOSURE)
      case l @ Location(t, SymbolSource.LOCAL_WRITABLE) =>
        addClosedVar(name, l)
        Location(t, SymbolSource.CLOSURE_WRITABLE)
      case x => x
    }
    else outer.escalateVar(name)

  override def addVars(es: List[(String, Location)]): TypeContext =
    new MutableClosureContext(types, vars ++ es, outer, _freeVars, _closedVars)

  override def addVars(es: TypeMap): TypeContext =
    new MutableClosureContext(types, vars ++ es, outer, _freeVars, _closedVars)

  override def addTypes(es: List[(String, Location)]): TypeContext =
    new MutableClosureContext(types ++ es, vars, outer, _freeVars, _closedVars)

  def freeVars: List[String] = _freeVars.toList

  def closedVars: immutable.Map[String, Location] = _closedVars.toMap

}

object MutableClosureContext {

  def apply(vars: TypeMap, outer: TypeContext): MutableClosureContext =
    new MutableClosureContext(Map(), vars, outer, ListBuffer(), mutable.Map())

}
