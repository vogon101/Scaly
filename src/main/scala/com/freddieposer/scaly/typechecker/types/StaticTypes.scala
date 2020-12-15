package com.freddieposer.scaly.typechecker.types

import com.freddieposer.scaly.typechecker.context.TypeContext
import com.freddieposer.scaly.typechecker.context.TypeContext.TypeMap
import com.freddieposer.scaly.typechecker.types.ScalyType.defaultMembers

case class ScalyClassType(name: String, override val parent: Option[ScalyType], myMembers: TypeMap) extends StaticScalyType {

  override val members: TypeMap = defaultMembers ++ myMembers

}

case class ScalyFunctionType(from: Option[ScalyType], to: ScalyType) extends StaticScalyType {

  override val members: TypeMap = defaultMembers ++ Map()

}

class ScalyTupleType private (val elems: List[ScalyType]) extends StaticScalyType {

  override lazy val members: TypeMap = defaultMembers ++ Map(
    elems.zipWithIndex.map { case (e, i) => f"_$i" -> e }: _*
  )

}

object ScalyTupleType {

  def apply(elems: List[ScalyType]): ScalyType = elems match {
    case Nil => ScalyValType.ScalyUnitType
    case x :: Nil => x
    case _ => ScalyTupleType(elems)
  }

  def unapply(arg: ScalyTupleType): Option[List[ScalyType]] = Some(arg.elems)

}

case class ScalyPlaceholderType() extends StaticScalyType with PlaceholderType {
  override lazy val members: TypeMap = ???
}

case class ScalyPlaceholderTypeName(name: String) extends StaticScalyType with PlaceholderType {
  override def members: TypeMap = ???
}



