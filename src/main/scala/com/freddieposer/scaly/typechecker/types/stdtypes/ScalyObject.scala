package com.freddieposer.scaly.typechecker.types.stdtypes

import com.freddieposer.scaly.typechecker.context.TypeContext.TypeMap
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType.{ScalyBooleanType, ScalyStringType, ScalyUnitType}
import com.freddieposer.scaly.typechecker.types.{ScalyFunctionType, ScalyTupleType, ScalyType, StaticScalyType}

object ScalyObject extends StaticScalyType {

  override lazy val parent: Option[ScalyType] = None

  import ScalyObjectUtils._

  override protected lazy val memberTypes: TypeMap = Map(
    "toString" -> (O --> ScalyStringType),
    "equals" -> (ScalyObject --> ScalyBooleanType)
  )

  override def toString: String = "ScalyObject"

}

object ScalyObjectUtils {

  object O {
    def --> (rhs: ScalyType): ScalyFunctionType =
      ScalyFunctionType(None, rhs)
  }

  implicit def ListToTypeTuple(ts: List[ScalyType]): ScalyType = ScalyTupleType(ts)

  implicit class FunctionBuilder(val lhs: ScalyType) {

    def --> (rhs: ScalyType): ScalyFunctionType =
      ScalyFunctionType(Some(lhs), rhs)

  }


}