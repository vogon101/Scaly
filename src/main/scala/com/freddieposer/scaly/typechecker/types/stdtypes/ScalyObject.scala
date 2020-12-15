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

