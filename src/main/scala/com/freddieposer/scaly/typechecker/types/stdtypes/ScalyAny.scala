package com.freddieposer.scaly.typechecker.types.stdtypes

import com.freddieposer.scaly.AST.ClassParam
import com.freddieposer.scaly.typechecker.context.TypeContext.{TypeMap, buildTypeMap}
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType.{ScalyBooleanType, ScalyStringType}
import com.freddieposer.scaly.typechecker.types.{ScalyType, StaticScalyType, SymbolSource}

object ScalyAny extends StaticScalyType {

  override lazy val parent: Option[ScalyType] = None

  import ScalyObjectUtils._

  override protected lazy val memberTypes: TypeMap = buildTypeMap(Map(
    "==" -> (ScalyAny --> ScalyBooleanType),
    "__bases__" -> (O --> ScalyObject),
    "__str__" -> (O --> ScalyStringType),
    "__eq__" -> (O --> ScalyStringType)
  ), SymbolSource.MEMBER)

  override def toString: String = "ScalyAny"

  override def globalName: Option[String] = Some("ScalyAny")

  override def constructor: Option[List[ClassParam]] = None

}
