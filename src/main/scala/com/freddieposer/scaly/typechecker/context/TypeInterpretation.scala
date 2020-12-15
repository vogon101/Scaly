package com.freddieposer.scaly.typechecker.context

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
      case ScalyASTPlaceholderType(node) => ???
      case _ => ???
    }
  }

  private def getMemberOfWellFormedType(typ: ScalyType, memberName: String): Either[String, ScalyType] =
    typ.getOwnMember(memberName)
      .orElse(typ.parent.flatMap(p => TypeInterpretation(p).getMember(memberName).toOption))
      .toRight(s"Type $typ does not have member $memberName")


}

object TypeInterpretation {

  def apply(subject: ScalyType)(implicit context: TypeContext): TypeInterpretation =
    new TypeInterpretation(subject)(context)

  implicit def TypeToInterpretation(subject: ScalyType)(implicit context: TypeContext): TypeInterpretation =
    TypeInterpretation(subject)
}
