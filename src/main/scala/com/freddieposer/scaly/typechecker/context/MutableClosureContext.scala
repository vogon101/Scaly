package com.freddieposer.scaly.typechecker.context

import com.freddieposer.scaly.typechecker.context.TypeContext.{Location, TypeMap}
import com.freddieposer.scaly.typechecker.types.SymbolSource

import scala.collection.mutable.ListBuffer
import scala.collection.{immutable, mutable}

/**
 * Context for a function used to track which variables are accessed for closures. This is a mutable datastructure.
 */
class MutableClosureContext private(
                                     override val types: TypeMap,
                                     override val vars: TypeMap,
                                     val outer: TypeContext,
                                     private val _freeVars: ListBuffer[String],
                                     private val _closedVars: mutable.Map[String, Location]
                                   ) extends TypeContext(types, vars, Some(outer)) {

  override def getVarType(name: String): Option[Location] =
    if (vars isDefinedAt name) vars get name
    else outer.escalateVar(name).map { //Add to free vars
      case l@Location(_, SymbolSource.CLOSURE | SymbolSource.CLOSURE_WRITABLE) =>
        addFreeVar(name)
        l
      case l@Location(_, SymbolSource.CLOSURE_MEMBER_WRITABLE | SymbolSource.CLOSURE_MEMBER) =>
        addFreeVar("this")
        l
      case x => x
    }

  private def addFreeVar(name: String): Unit =
    if (!_freeVars.contains(name)) _freeVars.addOne(name)

  override def escalateVar(name: String): Option[Location] =
    if (vars.isDefinedAt(name)) vars.get(name).map {
      //Add to cell vars, return closure
      case l@Location(t, SymbolSource.LOCAL) =>
        addClosedVar(name, l)
        Location(t, SymbolSource.CLOSURE)
      case l@Location(t, SymbolSource.LOCAL_WRITABLE) =>
        addClosedVar(name, l)
        Location(t, SymbolSource.CLOSURE_WRITABLE)
      case x => x
    }
    else outer.escalateVar(name).map {
      case l@Location(t, SymbolSource.THIS) =>
        addClosedVar(name, l)
        Location(t, SymbolSource.CLOSURE)
      case Location(t, SymbolSource.MEMBER) =>
        escalateVar("this")
        Location(t, SymbolSource.CLOSURE_MEMBER)
      case Location(t, SymbolSource.MEMBER) =>
        escalateVar("this")
        Location(t, SymbolSource.CLOSURE_MEMBER_WRITABLE)
      case x => x
    }

  override def addVars(es: List[(String, Location)]): TypeContext =
    new MutableClosureContext(types, vars ++ es, outer, _freeVars, _closedVars)

  override def addVars(es: TypeMap): TypeContext =
    new MutableClosureContext(types, vars ++ es, outer, _freeVars, _closedVars)

  override def addTypes(es: List[(String, Location)]): TypeContext =
    new MutableClosureContext(types ++ es, vars, outer, _freeVars, _closedVars)

  def freeVars(outerContext: TypeContext): immutable.Map[String, Location] =
    freeVars.map(x => x -> outerContext.getVarType(x)).map {
      case (_, None) => ???
      case (n, Some(l)) => n -> l
    }.toMap

  /**
   * Variables that the function this represents access from an outer closure
   *
   * @return
   */
  def freeVars: List[String] = _freeVars.toList

  /**
   * Variables of this function that are accessed by inner functions as part of a closure
   *
   * @return
   */
  def closedVars: immutable.Map[String, Location] = _closedVars.toMap

  private def addClosedVar(name: String, location: Location): Unit =
    if (!_closedVars.contains(name)) _closedVars.addOne(name -> location)

}

object MutableClosureContext {

  def apply(vars: TypeMap, outer: TypeContext): MutableClosureContext =
    new MutableClosureContext(Map(), vars, outer, ListBuffer(), mutable.Map())

}
