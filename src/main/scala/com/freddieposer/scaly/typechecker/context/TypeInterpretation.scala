package com.freddieposer.scaly.typechecker.context

import com.freddieposer.scaly.AST.{AST_ScalyType, AST_ScalyTypeName}
import com.freddieposer.scaly.typechecker.context.TypeContext._
import com.freddieposer.scaly.typechecker.context.TypeInterpretation.{ASTTypeToInterpretation, TypeToInterpretation}
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType._
import com.freddieposer.scaly.typechecker.types.{ScalyType, _}

/**
 * A TypeInterpretation provides methods on `ScalyType` that are interpreted under a `TypeContext`
 */
class TypeInterpretation(val subject: ScalyType)(implicit val context: TypeContext) {

  /**
   * Get a member of the type `subject`, interpreting the type if it is an AST
   *
   * @param memberName Member name to look for
   * @return
   */
  def getMember(memberName: String): Either[String, Location] = subject match {
    //TODO: Members of special objects - eg Functions.toString
    case staticType: StaticScalyType => staticType match {
      case ScalyPlaceholderTypeName(name) =>
        context.getWellFormedType(name)
          .toRight(s"Cannot convert type $name under $context")
          .flatMap(getMemberOfWellFormedType(_, memberName))
      case x: ScalyType => getMemberOfWellFormedType(x, memberName)
    }
    case astType: ASTScalyType => astType match {
      case templateType: ScalyASTTemplateType => getMemberOfWellFormedType(templateType, memberName)
      case ScalyASTPlaceholderType(astTyp) =>
        astTyp.fromAST
          .left.map(e => e.message)
          .flatMap(typ => getMemberOfWellFormedType(typ, memberName))
      case _ => ???
    }
  }

  /**
   * Returns true if `subject` < `obj`
   *
   * @param obj
   * @return
   */
  def isSubtypeOf(obj: ScalyType): Boolean = (subject, obj) match {
    case (ScalyPlaceholderTypeName(name), t2) =>
      context.getWellFormedType(name).exists(_.typ isSubtypeOf t2)
    case (t1, ScalyPlaceholderTypeName(name)) =>
      context.getWellFormedType(name).exists(t1 isSubtypeOf _)

    case (ScalyASTPlaceholderType(AST_ScalyTypeName(name)), t2) =>
      context.getWellFormedType(name).exists(_.typ isSubtypeOf t2)

    case (t1, ScalyASTPlaceholderType(AST_ScalyTypeName(name))) =>
      context.getWellFormedType(name).exists(t1.typ isSubtypeOf _)


    case (ScalyNothingType, _) => true
    case (ScalyNullType, t) if (t.isInstanceOf[ScalyValType] && !t.equals(ScalyStringType)) => false
    case (ScalyNullType, _) => true

    case (ScalyTupleType(ts1), ScalyTupleType(ts2)) => ts1.zip(ts2).forall { case (a, b) => a.isSubtypeOf(b) }


    case (t1, t2) => (t1 equals t2) || (t1.parent.exists(_.isSubtypeOf(t2)))
  }

  private def getMemberOfWellFormedType(typ: ScalyType, memberName: String): Either[String, Location] =
    typ.getOwnMemberLocation(memberName)
      .orElse(typ.parent.flatMap(p => TypeInterpretation(p).getMember(memberName).toOption))
      .toRight(s"Type $typ does not have member $memberName")
}

object TypeInterpretation {

  def interpret(subject: ScalyType, context: TypeContext): TypeInterpretation = TypeInterpretation(subject)(context)

  def apply(subject: ScalyType)(implicit context: TypeContext): TypeInterpretation =
    new TypeInterpretation(subject)(context)

  implicit def TypeToInterpretation(subject: ScalyType)(implicit context: TypeContext): TypeInterpretation =
    TypeInterpretation(subject)

  implicit def ASTTypeToInterpretation(subject: AST_ScalyType)(implicit context: TypeContext): ASTTypeInterpretation =
    ASTTypeInterpretation(subject)

  def interpret(subject: AST_ScalyType, context: TypeContext): ASTTypeInterpretation = ASTTypeInterpretation(subject)(context)


}
