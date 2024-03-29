package com.freddieposer.scaly.typechecker.types

import com.freddieposer.scaly.AST.ClassParam
import com.freddieposer.scaly.typechecker.context.TypeContext.{TypeMap, buildTypeMap}
import com.freddieposer.scaly.typechecker.types.ScalyType.defaultMembers
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType.ScalyNothingType
import com.freddieposer.scaly.typechecker.types.stdtypes.{ScalyAny, ScalyObject, ScalyValType}

case class ScalyFunctionType(from: Option[ScalyType], to: ScalyType) extends StaticScalyType {

  override lazy val parent: Option[ScalyType] = Some(ScalyAny)

  override val memberTypes: TypeMap = defaultMembers ++ Map()

  override def constructor: Option[List[ClassParam]] = None

}

object ScalyFunctionType {
  def build(returnType: ScalyType, types: List[List[ScalyType]]): ScalyType = {
    types.foldRight(returnType) {
      case (Nil, acc) => ScalyFunctionType(Some(ScalyValType.ScalyUnitType), acc)
      case (x :: Nil, acc) => ScalyFunctionType(Some(x), acc)
      case (xs, acc) => ScalyFunctionType(Some(ScalyTupleType(xs)), acc)
    }
  }
}

class ScalyFunctionTypeWithTarg(f: Option[ScalyType], t: ScalyType) extends ScalyFunctionType(f, t)

object ScalyFunctionTypeWithTarg {
  def unapply(arg: ScalyFunctionTypeWithTarg): Option[(Option[ScalyType], ScalyType)] = Some(arg.from, arg.to)

  def apply(f: Option[ScalyType], t: ScalyType): ScalyFunctionTypeWithTarg = new ScalyFunctionTypeWithTarg(f, t)
}

class ScalyTupleType private(val elems: List[ScalyType]) extends StaticScalyType {

  override lazy val parent: Option[ScalyType] = Some(ScalyObject)

  override lazy val memberTypes: TypeMap = defaultMembers ++ buildTypeMap(Map(
    elems.zipWithIndex.map { case (e, i) => f"_${i + 1}" -> e }: _*
  ), SymbolSource.MEMBER)

  override def toString: String = s"TupleType(${elems.mkString(", ")})"

  override def constructor: Option[List[ClassParam]] = None

  override def equals(obj: Any): Boolean = obj match {
    case ScalyTupleType(xs) => elems.zip(xs).forall {case (x,y) => x equals y}
    case _ => false
  }

}

object ScalyTupleType {

  def apply(elems: List[ScalyType]): ScalyType = elems match {
    case Nil => ScalyValType.ScalyUnitType
    case x :: Nil => x
    case _ => new ScalyTupleType(elems)
  }

  def unapply(arg: ScalyTupleType): Option[List[ScalyType]] = Some(arg.elems)

}


case class ScalyPlaceholderTypeName(name: String) extends StaticScalyType with PlaceholderType {
  override lazy val parent: Option[ScalyType] = None
  override val globalName: Option[String] = Some(name)

  override def memberTypes: TypeMap = ???

  override def constructor: Option[List[ClassParam]] = ???
}



