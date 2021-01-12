package com.freddieposer.scaly.typechecker.context

import com.freddieposer.scaly.AST._
import com.freddieposer.scaly.typechecker.TypeCheckerUtils.{ListOfEithers, TCR}
import com.freddieposer.scaly.typechecker.TypeError
import com.freddieposer.scaly.typechecker.context.TypeInterpretation.ASTTypeToInterpretation
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType
import com.freddieposer.scaly.typechecker.types.{ScalyFunctionType, ScalyTupleType, ScalyType}

class ASTTypeInterpretation(val subject: AST_ScalyType)(implicit val context: TypeContext) {

  /**
   * Convert a type from an AST node to an actual type
   *
   * @return
   */
  def fromAST: TCR[ScalyType] = //addToError(astType, context) {
    subject match {
      case AST_ScalyTypeName(name) =>
        context.getWellFormedType(name)
          .toRight(TypeError(s"Cannot find type name $name", subject))
          .map(l => l.typ)
      case AST_ScalyTypeSelect(lhs, rhs) => ???
      case AST_TupleScalyType(types) =>
        types
          .map(_.fromAST)
          .collapse
          .map(res => ScalyTupleType(res))
      case AST_FunctionScalyType(arguments, returnType) =>
        (arguments.map(_.fromAST).collapse, returnType.fromAST) match {
          case (Left(e), _) => Left(e)
          case (_, Left(e)) => Left(e)
          case (Right(Nil), Right(ret)) =>
            Right(ScalyFunctionType(Some(ScalyValType.ScalyUnitType), ret.typ))
          case (Right(arg :: Nil), Right(ret)) =>
            Right(ScalyFunctionType(Some(arg.typ), ret.typ))
          case (Right(args), Right(ret)) =>
            Right(ScalyFunctionType(Some(ScalyTupleType(args)), ret.typ))
        }
    }

}

object ASTTypeInterpretation {

  def apply(subject: AST_ScalyType)(implicit context: TypeContext): ASTTypeInterpretation =
    new ASTTypeInterpretation(subject)(context)

}
