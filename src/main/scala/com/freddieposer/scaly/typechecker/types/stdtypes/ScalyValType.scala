package com.freddieposer.scaly.typechecker.types.stdtypes

import com.freddieposer.scaly.AST._
import com.freddieposer.scaly.typechecker.context.TypeContext.{TypeMap, buildTypeMap}
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyObjectUtils._
import com.freddieposer.scaly.typechecker.types.{ScalyType, StaticScalyType, SymbolSource}

sealed abstract case class ScalyValType(name: String) extends StaticScalyType {

  override val parent: Option[ScalyType] = Some(ScalyAny)

  override def constructor: Option[List[ClassParam]] = None

  override protected def memberTypes: TypeMap = Map()
}

object ScalyValType {

  lazy val valTypes: TypeMap = buildTypeMap(SymbolSource.GLOBAL)(
    "String" -> ScalyStringType,
    "Int" -> ScalyIntType,
    "Float" -> ScalyFloatType,
    "Double" -> ScalyDoubleType,
    "Char" -> ScalyCharType,
    "Boolean" -> ScalyBooleanType,
    "Unit" -> ScalyUnitType,
    "Symbol" -> ScalySymbolType,
    "Nothing" -> ScalyNothingType,
    "Null" -> ScalyNullType
  )

  def literalType(l: Literal): StaticScalyType= l match {
    case NullLiteral => ScalyNullType
    case UnitLiteral => ScalyUnitType
    case IntLiteral(_) => ScalyIntType
    case CharLiteral(_) => ScalyCharType
    case FloatLiteral(_) => ScalyFloatType
    case DoubleLiteral(_) => ScalyDoubleType
    case SymbolLiteral(_) => ScalySymbolType
    case StringLiteral(_) => ScalyStringType
    case BooleanLiteral(_) => ScalyBooleanType
  }

  private def numericConverterTypes(typ: ScalyValType): TypeMap = buildTypeMap(SymbolSource.MEMBER)(
    "toInt" -> (O --> ScalyIntType),
    "toFloat" -> (O --> ScalyFloatType),
    "toDouble" -> (O --> ScalyDoubleType),
    "toChar" -> (O --> ScalyCharType),
    "unary_-" -> (ScalyUnitType --> typ),
    "+" -> (typ --> typ),
    "-" -> (typ --> typ),
    "*" -> (typ --> typ),
    "<" -> (typ --> ScalyBooleanType),
    ">" -> (typ --> ScalyBooleanType),
    ">=" -> (typ --> ScalyBooleanType),
    "<=" -> (typ --> ScalyBooleanType)
  )

  object ScalyStringType extends ScalyValType("String") {
    override protected lazy val memberTypes: TypeMap = buildTypeMap(SymbolSource.MEMBER)(
      "+" -> (ScalyStringType --> ScalyStringType),
      "*" -> (ScalyIntType --> ScalyStringType)
    )
  }

  object ScalyIntType extends ScalyValType("Int") {
    override protected lazy val memberTypes: TypeMap = buildTypeMap(SymbolSource.MEMBER)(
      "+" -> (ScalyIntType --> ScalyIntType),
      "imag" -> (O --> ScalyIntType),
      "to_bytes" -> (List(ScalyIntType, ScalyStringType).T --> ScalyStringType)
    ) ++ numericConverterTypes(ScalyIntType)
  }

  object ScalyFloatType extends ScalyValType("Float") {
    override protected lazy val memberTypes: TypeMap = buildTypeMap(SymbolSource.MEMBER)(
      "+" -> (ScalyFloatType --> ScalyFloatType)
    ) ++ numericConverterTypes(ScalyFloatType)
  }

  object ScalyDoubleType extends ScalyValType("Double") {
    override protected lazy val memberTypes: TypeMap = buildTypeMap(SymbolSource.MEMBER)(
      "+" -> (ScalyDoubleType --> ScalyDoubleType)
    ) ++ numericConverterTypes(ScalyDoubleType)
  }

  object ScalyCharType extends ScalyValType("Char") {
    override protected lazy val memberTypes: TypeMap = buildTypeMap(SymbolSource.MEMBER)(
      "+" -> (ScalyCharType --> ScalyCharType)
    ) ++ numericConverterTypes(ScalyCharType)
  }

  object ScalyBooleanType extends ScalyValType("Boolean") {
    override protected val memberTypes: TypeMap = buildTypeMap(SymbolSource.MEMBER)(
      "&&" -> (ScalyBooleanType --> ScalyBooleanType),
      "||" -> (ScalyBooleanType --> ScalyBooleanType)
    )
  }

  object ScalyUnitType extends ScalyValType("Unit")

  object ScalySymbolType extends ScalyValType("Symbol")

  object ScalyNothingType extends ScalyValType("Nothing")

  object ScalyNullType extends StaticScalyType {
    override val parent: Option[ScalyType] = None
    override def constructor: Option[List[ClassParam]] = None
    override protected def memberTypes: TypeMap = Map()
  }

}
