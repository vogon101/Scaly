package com.freddieposer.scaly.typechecker.context

import com.freddieposer.scaly.typechecker.context.TypeContext.buildTypeMap
import com.freddieposer.scaly.typechecker.types.SymbolSource
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyObjectUtils._
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType.{ScalyStringType, ScalyUnitType}
import com.freddieposer.scaly.typechecker.types.stdtypes.{ScalyObject, ScalyValType}

object BaseTypeContext extends TypeContext(
  ScalyValType.valTypes ++ buildTypeMap(SymbolSource.GLOBAL)(
    "Object" -> ScalyObject
  ),
  buildTypeMap(SymbolSource.GLOBAL)(
    "print" -> (ScalyObject --> ScalyUnitType),
    "str" -> (ScalyObject --> ScalyStringType)
  ),
  None
)
