package com.freddieposer.scaly.typechecker.context

import com.freddieposer.scaly.typechecker.types.ScalyValType

object BaseTypeContext extends TypeContext(
  ScalyValType.valTypes, Map(), None
)
