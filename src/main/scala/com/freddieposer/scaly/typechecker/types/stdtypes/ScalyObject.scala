package com.freddieposer.scaly.typechecker.types.stdtypes

import com.freddieposer.scaly.AST.ClassParam
import com.freddieposer.scaly.typechecker.context.TypeContext.{TypeMap, buildTypeMap}
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType.{ScalyBooleanType, ScalyStringType}
import com.freddieposer.scaly.typechecker.types.{ScalyType, StaticScalyType, SymbolSource}

object ScalyObject extends StaticScalyType {

  override lazy val parent: Option[ScalyType] = Some(ScalyAny)

  import ScalyObjectUtils._

  override protected lazy val memberTypes: TypeMap = buildTypeMap(Map(
    "toString" -> (O --> ScalyStringType),
    "equals" -> (ScalyObject --> ScalyBooleanType),
    "isInstanceOf" -> (O -@-> ScalyBooleanType)
  ), SymbolSource.MEMBER)

  override def toString: String = "ScalyObject"

  override def globalName: Option[String] = Some("ScalyObject")

  //TODO: Constructor for ScalyObject?
  override def constructor: Option[List[ClassParam]] = None

}

