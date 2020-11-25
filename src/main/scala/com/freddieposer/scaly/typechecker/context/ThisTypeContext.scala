package com.freddieposer.scaly.typechecker.context

import com.freddieposer.scaly.typechecker.context.TypeContext.TypeMap
import com.freddieposer.scaly.typechecker.types.ScalyType

class ThisTypeContext(
                     val owner: ScalyType,
                     val _p: Option[TypeContext]
                     ) extends TypeContext(Map(), Map(), _p){

  override def getVarType(name: String): Option[ScalyType] =
    if (name equals "this") Some(owner)
    else super.getVarType(name)

}
