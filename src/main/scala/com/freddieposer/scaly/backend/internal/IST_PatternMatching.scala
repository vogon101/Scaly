package com.freddieposer.scaly.backend.internal
import com.freddieposer.scaly.typechecker.types.ScalyType
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType.ScalyNothingType

sealed case class IST_Case (pattern: IST_Pattern, rhs: IST_Expression) extends IST {
  override val typ: ScalyType = rhs.typ
}

sealed abstract class IST_Pattern extends IST {
  override val typ: ScalyType = ScalyNothingType
  val matchType: ScalyType

  //TODO: What was the plan here?
  val bindings: List[(String, ScalyType)]

}

case class IST_LiteralPattern(literal: IST_Literal) extends IST_Pattern {
  override val bindings: List[(String, ScalyType)] = Nil
  override val matchType: ScalyType = literal.typ
}

case class IST_VariablePattern(name: String, override val matchType: ScalyType) extends IST_Pattern {
  override val bindings: List[(String, ScalyType)] = List((name, matchType))
}