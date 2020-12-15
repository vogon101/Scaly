package com.freddieposer.scaly.typechecker.context

import com.freddieposer.scaly.typechecker.types.stdtypes.{ScalyObject, ScalyValType}

object BaseTypeContext extends TypeContext(
  ScalyValType.valTypes ++ Map(
    "Object" -> ScalyObject
  ),
  Map(),
  None
)
