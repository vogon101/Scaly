package com.freddieposer.scaly.typechecker.types

import com.freddieposer.scaly.AST._
import com.freddieposer.scaly.typechecker.context.TypeContext.TypeMap

sealed case class ScalyValType(name: String) extends StaticScalyType {
  override def members: TypeMap = ???

  //TODO: Parents for val types
  override val parent: Option[ScalyType] = None
}

object ScalyValType {

  def literalType(l: Literal): ScalyValType = l match {
    case NullLiteral => ScalyNothingType
    case UnitLiteral => ScalyUnitType
    case IntLiteral(_) => ScalyIntType
    case CharLiteral(_) => ScalyCharType
    case FloatLiteral(_) => ScalyFloatType
    case DoubleLiteral(_) => ScalyDoubleType
    case SymbolLiteral(_) => ScalySymbolType
    case StringLiteral(_) => ScalyStringType
    case BooleanLiteral(_) => ScalyBooleanType
  }


  lazy val valTypes: Map[String, ScalyValType] = Map(
    "String" -> ScalyStringType,
    "Int" -> ScalyIntType,
    "Float" -> ScalyFloatType,
    "Double" -> ScalyDoubleType,
    "Char" -> ScalyCharType,
    "Boolean" -> ScalyBooleanType,
    "Unit" -> ScalyUnitType,
    "Symbol" -> ScalySymbolType,
    "Nothing" -> ScalyNothingType
  )

  object ScalyStringType extends ScalyValType("String")

  object ScalyIntType extends ScalyValType("Int")

  object ScalyFloatType extends ScalyValType("Float")

  object ScalyDoubleType extends ScalyValType("Double")

  object ScalyCharType extends ScalyValType("Char")

  object ScalyBooleanType extends ScalyValType("Boolean")

  object ScalyUnitType extends ScalyValType("Unit")

  object ScalySymbolType extends ScalyValType("Symbol")

  object ScalyNothingType extends ScalyValType("Nothing")

}
