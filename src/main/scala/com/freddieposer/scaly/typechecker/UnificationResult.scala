package com.freddieposer.scaly.typechecker

import com.freddieposer.scaly.typechecker.context.TypeContext
import com.freddieposer.scaly.typechecker.types.ScalyType

abstract class _UnificationResult(val t1: ScalyType, val t2: ScalyType)
                                 (implicit val ctx: TypeContext) {

  def map(f: UnificationSuccess => _UnificationResult): _UnificationResult

}

class UnificationSuccess(override val t1: ScalyType,
                         override val t2: ScalyType
                        )(implicit _ctx: TypeContext) extends _UnificationResult(t1, t2) {
  override def map(f: UnificationSuccess => _UnificationResult): _UnificationResult = f(this)
}

object EmptyUS extends UnificationSuccess(null, null)(null)

object UnificationSuccess {

  def apply(t1: ScalyType, t2: ScalyType)(implicit _ctx: TypeContext): UnificationSuccess =
    new UnificationSuccess(t1, t2)(_ctx)

  def unapply(arg: UnificationSuccess): Option[(ScalyType, ScalyType)] = Some((arg.t1, arg.t2))

}

case class UnificationCombination(override val t1: ScalyType,
                                  override val t2: ScalyType,
                                  ur1: _UnificationResult,
                                  ur2: _UnificationResult
                                 )(implicit _ctx: TypeContext) extends UnificationSuccess(t1, t2)

case class UnificationFailure(override val t1: ScalyType,
                              override val t2: ScalyType,
                              message: String
                             )(implicit _ctx: TypeContext) extends _UnificationResult(t1, t2) {
  override def map(f: UnificationSuccess => _UnificationResult): _UnificationResult = this
}

class UnificationFailureFromTypeCheck(
                                       override val t1: ScalyType,
                                       override val t2: ScalyType,
                                       val error: TypeError
                                     )(implicit _ctx: TypeContext) extends UnificationFailure(t1, t2, error.message)