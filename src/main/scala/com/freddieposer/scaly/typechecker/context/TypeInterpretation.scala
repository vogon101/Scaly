package com.freddieposer.scaly.typechecker.context

import com.freddieposer.scaly.AST.{AST_FunctionScalyType, AST_ScalyType, AST_ScalyTypeName, AST_ScalyTypeSelect, AST_TupleScalyType}
import com.freddieposer.scaly.typechecker.{Success, TypeError, TypeErrorContext}
import com.freddieposer.scaly.typechecker.Utils.TCR
import com.freddieposer.scaly.typechecker._TypeCheckResult.Successes
import com.freddieposer.scaly.typechecker.types.{ScalyFunctionType, ScalyTupleType, ScalyType, ScalyValType}
import com.freddieposer.scaly.AST._
import com.freddieposer.scaly.typechecker.Variance.Variance
import com.freddieposer.scaly.typechecker.context.{BaseTypeContext, ThisTypeContext, TypeContext}
import com.freddieposer.scaly.typechecker.types._
import com.freddieposer.scaly.typechecker.Utils._
import com.freddieposer.scaly.typechecker._TypeCheckResult._
import com.freddieposer.scaly.typechecker.context.TypeContext.TypeMap

class TypeInterpretation(val subject: ScalyType)(implicit val context: TypeContext) {

  //TODO: Make this an either
  def getMember(memberName: String): Either[String, ScalyType] = subject match {
    case staticType: StaticScalyType => staticType match {
      case ScalyPlaceholderTypeName(name) =>
        context.getWellFormedType(name)
          .toRight(s"Cannot convert type $name under $context")
          .flatMap(getMemberOfWellFormedType(_, memberName))
      case x: ScalyType => getMemberOfWellFormedType(x, memberName)
    }
    case astType: ASTScalyType => astType match {
      case ScalyASTClassType(name, parent, node) => ???
      case ScalyASTPlaceholderType(node) => ???
      case _ => ???
    }
  }

  private def getMemberOfWellFormedType(typ: ScalyType, memberName: String): Either[String, ScalyType] =
    typ.getMember(memberName)
      .orElse(typ.parent.flatMap(p => TypeInterpretation(p).getMember(memberName).toOption))
      .toRight(s"Type $typ does not have member $memberName")


}

object TypeInterpretation {

  def apply(subject: ScalyType)(implicit context: TypeContext): TypeInterpretation = new TypeInterpretation(subject)(context)

}
