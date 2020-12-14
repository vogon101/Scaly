package com.freddieposer.scaly.typechecker

import com.freddieposer.scaly.AST.ScalyAST
import com.freddieposer.scaly.typechecker.context.TypeContext
import com.freddieposer.scaly.typechecker.types.ScalyType

abstract class _TypeCheckResult(val node: ScalyAST)(implicit val ctx: TypeContext) {

}

object _TypeCheckResult {

  def Successes(typ: ScalyType, node: ScalyAST, supports: List[TypeCheckSuccess])
               (implicit ctx: TypeContext): TypeCheckSuccess =
    new TypeCheckSuccess_Combination(typ, node, supports)

  def Failure(message: String, node: ScalyAST)(implicit ctx: TypeContext): TypeError =
    TypeError(message, node)

  def Failure(failure: TypeError): Option[(String, ScalyAST)] =
    TypeError.unapply(failure)

}

class TypeCheckSuccess(val typ: ScalyType,
                       override val node: ScalyAST
                      )(implicit ctx: TypeContext) extends _TypeCheckResult(node) {

  override def toString: String = f"Success ($node : $typ)"

}

object Success {

  def apply(typ: ScalyType, node: ScalyAST)(implicit ctx: TypeContext): TypeCheckSuccess =
    new TypeCheckSuccess(typ, node)

  def unapply(success: TypeCheckSuccess): Option[(ScalyType, ScalyAST)] =
    Some (success.typ, success.node)

}


class TypeCheckSuccess_Combination(_typ: ScalyType,
                                  _node: ScalyAST,
                                   val supports: List[TypeCheckSuccess]
                                  )(implicit ctx: TypeContext) extends TypeCheckSuccess(_typ, _node) {

  override def toString: String = f"Success ($node : $typ) \n\t with \n\t ${supports.mkString("\t\n")}"

}

case class TypeError(message: String,
                     override val node: ScalyAST
                    )(implicit ctx: TypeContext) extends _TypeCheckResult(node)

class TypeErrorContext(inner: TypeError, override val node: ScalyAST)
                      (implicit ctx: TypeContext) extends TypeError(inner.message, node) {

  override def toString: String = f"Error at $node with $ctx\n${inner.toString}"

}

class TypeErrorFromUnificationFailure(
                                     val failure: UnificationFailure,
                                     val _node: ScalyAST
                                     ) (implicit ctx: TypeContext) extends TypeError(failure.message, _node)