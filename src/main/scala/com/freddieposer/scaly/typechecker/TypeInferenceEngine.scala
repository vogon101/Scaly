package com.freddieposer.scaly.typechecker

import com.freddieposer.scaly.AST.{Expr, FunctionExpr, Literal, TupleExpr}
import com.freddieposer.scaly.typechecker.types.{ScalyFunctionType, ScalyTupleType, ScalyType}
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType

object TypeInferenceEngine {

  def infer(rhs: Expr): ScalyType = rhs match {
    case literal: Literal => ScalyValType.literalType(literal)
    case TupleExpr(elems) => ScalyTupleType(elems.map(infer))
    case _ => throw InferenceError(rhs)
  }

}

case class InferenceError(node: Expr) extends Exception(s"Cannot infer type of expression $node")