package com.freddieposer.scaly.typechecker.types.stdtypes

import com.freddieposer.scaly.typechecker.types.{ScalyFunctionType, ScalyFunctionTypeWithTarg, ScalyTupleType, ScalyType}

object ScalyObjectUtils {

  object O {
    def -->(rhs: ScalyType): ScalyFunctionType =
      ScalyFunctionType(None, rhs)
    def -@-> (rhs: ScalyType): ScalyFunctionTypeWithTarg =
      new ScalyFunctionTypeWithTarg(None, rhs)

  }

  implicit def ListToTypeTuple(ts: List[ScalyType]): ScalyType = ScalyTupleType(ts)

  implicit class FunctionBuilder(val lhs: ScalyType) {

    def -->(rhs: ScalyType): ScalyFunctionType =
      ScalyFunctionType(Some(lhs), rhs)

    def -@-> (rhs: ScalyType): ScalyFunctionTypeWithTarg =
      new ScalyFunctionTypeWithTarg(Some(lhs), rhs)

  }

  implicit class ExtendedList(ts: List[ScalyType]) {
    def T: ScalyType = ScalyTupleType(ts)
  }


}
