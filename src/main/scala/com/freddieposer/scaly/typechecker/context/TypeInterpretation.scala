package com.freddieposer.scaly.typechecker.context

import com.freddieposer.scaly.AST.AST_ScalyTypeName
import com.freddieposer.scaly.typechecker.context.TypeInterpretation.TypeToInterpretation
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType._
import com.freddieposer.scaly.typechecker.types.{ScalyType, _}

class TypeInterpretation(val subject: ScalyType)(implicit val context: TypeContext) {

  //TODO: Refactor the TypeCheckResult to not (always) require a node so there is one result type
  def getMember(memberName: String): Either[String, ScalyType] = subject match {
    case staticType: StaticScalyType => staticType match {
      case ScalyPlaceholderTypeName(name) =>
        context.getWellFormedType(name)
          .toRight(s"Cannot convert type $name under $context")
          .flatMap(getMemberOfWellFormedType(_, memberName))
      case x: ScalyType => getMemberOfWellFormedType(x, memberName)
    }
    case astType: ASTScalyType => astType match {
      case classType: ScalyASTClassType => getMemberOfWellFormedType(classType, memberName)
      case ScalyASTPlaceholderType(AST_ScalyTypeName(name)) =>
        context.getWellFormedType(name)
          .toRight(s"Cannot convert type $name under $context")
          .flatMap(getMemberOfWellFormedType(_, memberName))
      case _ => ???
    }
  }

  private def getMemberOfWellFormedType(typ: ScalyType, memberName: String): Either[String, ScalyType] =
    typ.getOwnMember(memberName)
      .orElse(typ.parent.flatMap(p => TypeInterpretation(p).getMember(memberName).toOption))
      .toRight(s"Type $typ does not have member $memberName")

  def isSubtypeOf(obj: ScalyType): Boolean = (subject, obj) match {
    case (ScalyPlaceholderTypeName(name), t2) =>
      context.getWellFormedType(name).exists(_ isSubtypeOf t2)
    case (t1, ScalyPlaceholderTypeName(name)) =>
      context.getWellFormedType(name).exists(t1 isSubtypeOf _)

    case (ScalyNothingType, _) => true
    case (ScalyNullType, t) if (t.isInstanceOf[ScalyValType] && !t.equals(ScalyStringType)) => false
    case (ScalyNullType, _) => true

    case (ScalyTupleType(ts1), ScalyTupleType(ts2)) => ts1.zip(ts2).forall { case (a, b) => a.isSubtypeOf(b) }

    case (t1, t2) => (t1 equals t2) || (t1.parent.exists(_.isSubtypeOf(t2)))
  }

}

object TypeInterpretation {

  def apply(subject: ScalyType)(implicit context: TypeContext): TypeInterpretation =
    new TypeInterpretation(subject)(context)

  implicit def TypeToInterpretation(subject: ScalyType)(implicit context: TypeContext): TypeInterpretation =
    TypeInterpretation(subject)
}
