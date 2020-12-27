package com.freddieposer.scaly.typechecker

import com.freddieposer.scaly.AST.ScalyAST
import com.freddieposer.scaly.typechecker.context.TypeContext

sealed case class TypeError(message: String,
                     node: ScalyAST
                    )(implicit val ctx: TypeContext)

class TypeErrorContext(val inner: TypeError, override val node: ScalyAST)
                      (implicit override val ctx: TypeContext) extends TypeError(inner.message, node) {

  override def toString: String = f"Error at $node with $ctx\n${inner.toString}"

}

class TypeErrorFromUnificationFailure(
                                       val failure: UnificationFailure,
                                       val _node: ScalyAST
                                     )(implicit override val ctx: TypeContext) extends TypeError(failure.message, _node) {

  override def toString: String = s"Failed to Unify: ${failure.message} at $node"

}