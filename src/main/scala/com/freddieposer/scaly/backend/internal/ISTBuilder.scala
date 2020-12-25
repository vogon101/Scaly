package com.freddieposer.scaly.backend.internal

import com.freddieposer.scaly.AST._
import com.freddieposer.scaly.backend.pyc._
import com.freddieposer.scaly.typechecker.types.ScalyASTClassType
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType

object ISTBuilder {

  def buildISTClass(id: String, stats: List[IST_Statement], typ: ScalyASTClassType) =
    IST_Class(id, stats.filter {
      case _: IST_Member => true
      case _: IST_Expression => false
    }.map { case m: IST_Member => m.id -> m }.toMap, typ)

  def buildLiteral(literal: Literal, typ: ScalyValType): IST_Literal = IST_Literal(literal match {
    case NullLiteral => PyNone
    case UnitLiteral => ???
    case IntLiteral(value) => new PyInt(value)
    case StringLiteral(value) => PyAscii(value)
    case BooleanLiteral(true) => PyTrue
    case BooleanLiteral(false) => PyFalse
  }, typ)

}
