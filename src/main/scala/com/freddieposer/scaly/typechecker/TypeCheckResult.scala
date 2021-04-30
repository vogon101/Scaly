package com.freddieposer.scaly.typechecker

import com.freddieposer.scaly.AST.ScalyAST
import com.freddieposer.scaly.CompilerError
import com.freddieposer.scaly.typechecker.context.TypeContext

sealed case class TypeError(message: String,
                            node: ScalyAST
                           )(implicit val ctx: TypeContext) extends CompilerError

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

class TypeErrorCombination(
                            _m: String,
                            _n: ScalyAST,
                            val others: List[TypeError]
                          )(implicit _c: TypeContext) extends TypeError(_m, _n) {

  override def toString: String = f"Type Error $message with\n ${others.mkString("\n")}\n at $node"

}