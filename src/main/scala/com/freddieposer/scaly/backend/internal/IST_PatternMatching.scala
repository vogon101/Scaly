package com.freddieposer.scaly.backend.internal
import com.freddieposer.scaly.typechecker.context.TypeContext.Location
import com.freddieposer.scaly.typechecker.types.{ScalyTupleType, ScalyType}
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType.ScalyNothingType

import scala.collection.SeqMap

sealed case class IST_Case (pattern: IST_Pattern, rhs: IST_Expression, closedVars: Map[String, Location], freeVars: Map[String, Location]) extends IST {
  override val typ: ScalyType = rhs.typ
}

sealed abstract class IST_Pattern extends IST {
  override val typ: ScalyType = ScalyNothingType
  val matchType: ScalyType

  //TODO: What was the plan here?
  val bindings: SeqMap[String, ScalyType]

  override def toString: String = s"Pattern with $bindings"

}

case class IST_LiteralPattern(literal: IST_Literal) extends IST_Pattern {
  override val bindings: SeqMap[String, ScalyType] = SeqMap.empty
  override val matchType: ScalyType = literal.typ

  override def toString: String = s"LiteralPattern($literal)"
}

case class IST_VariablePattern(name: String, override val matchType: ScalyType) extends IST_Pattern {
  override val bindings: SeqMap[String, ScalyType] = SeqMap((name, matchType))
}

case class IST_TuplePattern(pats: List[IST_Pattern]) extends IST_Pattern {
  override val matchType: ScalyType = ScalyTupleType(pats.map(_.matchType))
  override val bindings: SeqMap[String, ScalyType] = SeqMap.from(pats.flatMap(_.bindings)) //TODO: ordering?
}