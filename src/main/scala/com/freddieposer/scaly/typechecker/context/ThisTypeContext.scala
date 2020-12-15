package com.freddieposer.scaly.typechecker.context

import com.freddieposer.scaly.typechecker.context.TypeContext.TypeMap
import com.freddieposer.scaly.typechecker.types.ScalyType

class ThisTypeContext private(
                               val owner: ScalyType,
                               val _p: Option[TypeContext],
                               _t: TypeMap,
                               _v: TypeMap
                             ) extends TypeContext(_t, _v, _p) {

  def this(o: ScalyType, _p: Option[TypeContext]) = this(o, _p, Map(), Map())

  override def getVarType(name: String): Option[ScalyType] =
    if (name equals "this") Some(owner)
    else owner.getOwnMember(name)
      .orElse(super.getVarType(name))

  override def addTypes(e: List[(String, ScalyType)]): TypeContext =
    new ThisTypeContext(owner, _p, types ++ e, vars)

  override def addVars(es: List[(String, ScalyType)]): TypeContext =
    new ThisTypeContext(owner, parent, types, vars ++ es)

}
