package com.freddieposer.scaly.typechecker

import com.freddieposer.scaly.AST._
import com.freddieposer.scaly.typechecker.Utils._
import com.freddieposer.scaly.typechecker.Variance.Variance
import com.freddieposer.scaly.typechecker._TypeCheckResult._
import com.freddieposer.scaly.typechecker.context.TypeInterpretation.TypeToInterpretation
import com.freddieposer.scaly.typechecker.context.{BaseTypeContext, ThisTypeContext, TypeContext}
import com.freddieposer.scaly.typechecker.types._
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType.ScalyBooleanType

class TypeChecker(
                   val ast: CompilationUnit
                 ) {


  lazy val globalContext: TypeContext = {
    var _gc: TypeContext = BaseTypeContext
    ast.statements.foreach {
      case c@ScalyClassDef(id, parents, _, _) =>
        _gc = _gc addType (id -> ScalyASTClassType(id, parents.headOption.map(ScalyPlaceholderTypeName), c))
      case ScalyObjectDef(id, parents, body) => ???
    }
    _gc
  }

  def addToError(node: ScalyAST, context: TypeContext)(f: => TCR): TCR =
    f.left.map(new TypeErrorContext(_, node)(context))

  def typeCheck(): TCR = {

    ast.statements.map {
      case node@ScalyClassDef(id, parents, body, params) =>
        val ctx = new ThisTypeContext(ScalyASTClassType(id, None, node), Some(globalContext))
        body.map(stat =>
          Right(Success(ScalyValType.ScalyUnitType, UnitLiteral)(ctx)).collect[Statement] {
            case (statement, acc) => typeCheck(statement)(acc.ctx, Variance.IN)
          }(stat.stats)
        ).getOrElse(Right(Success(ScalyValType.ScalyUnitType, node)(ctx)))

      case ScalyObjectDef(id, parents, body) => ???
    }.collapse.map(Successes(ScalyValType.ScalyUnitType, ast, _)(globalContext))
  }

  def updateContext(id: String)
                   (f: () => TCR)
                   (implicit context: TypeContext): TCR = {
    f().map { case s@Success(t, n) => Success(t, n)(s.ctx.addVar(id -> t)) }
  }

  def buildFunctionType(returnType: ScalyType, types: List[List[ScalyType]]): ScalyType = {
    types.foldRight(returnType) {
      case (Nil, acc) => ScalyFunctionType(Some(ScalyValType.ScalyUnitType), acc)
      case (x :: Nil, acc) => ScalyFunctionType(Some(x), acc)
      case (xs, acc) => ScalyFunctionType(Some(ScalyTupleType(xs)), acc)
    }
  }

  private def convertType(astType: AST_ScalyType)(implicit context: TypeContext): TCR = addToError(astType, context) {
    astType match {
      case AST_ScalyTypeName(name) =>
        context.getWellFormedType(name)
          .toRight(TypeError(s"Cannot find type name $name", astType))
          .map(Success(_, astType))
      case AST_ScalyTypeSelect(lhs, rhs) => ???
      case AST_TupleScalyType(types) =>
        types
          .map(convertType)
          .collapse
          .map(successes => Successes(ScalyTupleType(successes.toTypes), astType, successes))
      case AST_FunctionScalyType(arguments, returnType) =>
        (arguments.map(convertType).collapse, convertType(returnType)) match {
          case (Left(e), _) => Left(e)
          case (_, Left(e)) => Left(e)
          case (Right(Nil), Right(ret)) =>
            Right(Successes(
              ScalyFunctionType(Some(ScalyValType.ScalyUnitType), ret.typ), astType, List(ret)
            ))
          case (Right(arg :: Nil), Right(ret)) =>
            Right(Successes(
              ScalyFunctionType(Some(arg.typ), ret.typ), astType, List(arg, ret)
            ))
          case (Right(args), Right(ret)) =>
            Right(Successes(
              ScalyFunctionType(Some(ScalyTupleType(args.toTypes)), ret.typ), astType, ret :: args
            ))
        }
    }
  }


  def typeCheck(stat: Statement)(implicit ctx: TypeContext, variance: Variance): TCR = addToError(stat, ctx) {
    stat match {
      case e: Expr => typeCheck_Expr(e)
      case d: Dcl => d match {
        case DefDef(id, params, retType, body) => updateContext(id) { () =>
          val paramResults = params.map(ps =>
            ps.map(p => p.name -> convertType(p.pType))
            //.collect { case (_, e@Left(_)) => e }
          )
          val errors = paramResults.map(_.collect { case (_, e@Left(_)) => e }).collect { case xs@_ :: _ => xs }.flatten
          errors match {
            case Nil =>
              val paramTypes = paramResults.map { ps => ps.map { case (n, Right(t)) => n -> t.typ } }
              retType match {
                case Some(rt) => convertType(rt).flatMap {
                  case Success(declaredRT, _) =>
                    typeCheck(body)(ctx.extend(Map(), ((id -> buildFunctionType(declaredRT, paramTypes.map(_.map(_._2)))) :: paramTypes.flatten).toMap), variance)
                      .flatMap {
                        case Success(actualRetType, node) =>
                          doesUnify(actualRetType, declaredRT)(ctx, Variance.CO)
                            .mapError(stat)
                            //TODO: Include the successes and actual type information
                            .map(us => Success(buildFunctionType(actualRetType, paramTypes.map(_.map(_._2))), stat))
                      }

                }
                case None =>
                  typeCheck(body)(ctx.addVars(paramTypes.flatten), variance)
                //TODO: Update the type in the context

              }
            //TODO Add info
            case es@_ :: _ => Left(TypeError(s"Cannot typecheck parameters for def: $stat", stat))
          }

        }
        case MemberDcl(_, typ, rhs) =>
          typeCheck(rhs).flatMap {
            case Success(actualType, _) => typ match {
              case Some(t: AST_ScalyType) => convertType(t).flatMap {
                case Success(declaredType, _) =>
                  doesUnify(actualType, declaredType)(ctx, Variance.CO)
                    .mapError(stat)
                    .map(us => Success(actualType, stat))
              }
              case None => typeCheck(rhs)
            }
          }
      }
    }
  }

  private def typeCheck_Expr(expr: Expr)(implicit ctx: TypeContext, variance: Variance): TCR = addToError(expr, ctx) {
    expr match {

      case l: Literal => Right(Success(ScalyValType.literalType(l), expr))
      case SelectExpr(lhs, rhs) =>
        typeCheck_Expr(lhs).flatMap {
          case Success(typ, _) =>
            typ.getMember(rhs)
              .map(Success(_, expr))
              .left.map(Failure(_, expr))
        }
      case IDExpr(name) =>
        ctx.getVarType(name)
          .toRight(TypeError(s"Cannot find type $name", expr))
          .map(Success(_, expr))

      case TupleExpr(elems) =>
        elems
          .map(typeCheck_Expr)
          .collapse
          .map(ts =>
            Successes(ScalyTupleType(ts.toTypes), expr, ts)
          )
      case Application(lhs, actuals) =>
        typeCheck_Expr(lhs).flatMap { case lhs_success@Success(t, _) => t match {
          case ScalyFunctionType(None, rType) =>
            actuals match {
              case Nil => Right(Success(rType, expr))
              case _ => rType match {
                case ScalyFunctionType(from, to) => ???
                case _ => Left(Failure("Cannot apply to non-unit function", expr))
              }
            }
          case ScalyFunctionType(Some(formalTypes), rType) =>
            //TODO: formalTypes can be None - this would be invalid?
            actuals
              .map(typeCheck_Expr).collapse
              .map(ts => ScalyTupleType(ts.toTypes))
              .map(doesUnify(_, formalTypes)(ctx, Variance.CO).mapError(expr))
              .collapse
              //TODO: Apply unification results
              //TODO: Include the success of the RHS
              .map(rhs_success => Successes(rType, expr, lhs_success :: Nil))
          //TODO: Apply syntax
          case _ => Left(TypeError("Application of non-functional type", expr))
        }
        }
      case IfExpr(cond, tBranch, fBranch) =>
        typeCheck(cond)
          .flatMap { case condSuccess@Success(t, _) =>
            doesUnify(t, ScalyBooleanType)(ctx, Variance.CO)
              .mapError(cond)
              .flatMap(boolSuccess => typeCheck(tBranch).flatMap(
                tBranchSuccess => typeCheck(fBranch).flatMap(
                  fBranchSuccess => doesUnify(tBranchSuccess.typ, fBranchSuccess.typ)(ctx, Variance.IN)
                    .mapError(expr)
                    .flatMap {
                      //TODO: Common parent
                      us =>
                        Right(Successes(
                          tBranchSuccess.typ,
                          expr,
                          List(condSuccess, tBranchSuccess, fBranchSuccess)
                        ))
                    }
                )
              ))
          }
      case Block(statements) =>
        statements
          .foldLeft(Right(Success(ScalyValType.ScalyUnitType, expr)): TCR) {
            case (Right(x: TypeCheckSuccess), statement) =>
              typeCheck(statement)(x.ctx, variance)
            case (Left(e), _) => Left(e)
          }
    }
  }

  //

  /**
   * Does t1 unify with t2 under the given variance
   * Unifies if:
   *  - t1 == t2
   *  - t1 < t2 and CO-VARIANT
   *  - t1 > t2 and CONTRA-VARIANT
   *
   * NOTE: For variance we need to be incredibly careful with the order of these types
   *
   * @param t1
   * @param t2
   * @param ctx
   * @param variance
   * @return
   */
  private def doesUnify(t1: ScalyType, t2: ScalyType)(implicit ctx: TypeContext, variance: Variance): UR =
    (t1, t2) match {
      case _ if variance == Variance.CONTRA => doesUnify(t2, t1)(ctx, Variance.CO)
      case (x: ScalyASTPlaceholderType, _) =>
        convertType(x.node)
          .mapError(t1, t2)
          .flatMap { t => doesUnify(t.typ, t2) }
      case (_, x: ScalyASTPlaceholderType) =>
        convertType(x.node)
          .mapError(t1, t2)
          .map { t => doesUnify(t1, t.typ) }.collapse

      case (static1: StaticScalyType, static2: StaticScalyType) =>
        doesUnify_static(static1, static2)


      case _ if (variance == Variance.CO) =>
        if (t1.isSubtypeOf(t2)) Right(UnificationSuccess(t1, t2))
        else Left(UnificationFailure(t1, t2, s"$t1 is not a subtype of $t2"))

      case (x: ScalyASTClassType, y: ScalyASTClassType) =>
        //TODO: currently just checks reference equality
        if (x equals y) Right(UnificationSuccess(x, y))
        else Left(UnificationFailure(x, y, s"Classes ${x.name} and ${y.name} are not equal"))

      case _ => Left(UnificationFailure(t1, t2, s"Cannot unify types ${t1} and ${t2} under $variance"))

    }

  def doesUnify_static(t1: StaticScalyType, t2: StaticScalyType)(implicit ctx: TypeContext, variance: Variance): UR =
    (t1, t2) match {
      case _ if variance == Variance.CONTRA => doesUnify(t2, t1)(ctx, Variance.CO)
      case (ScalyFunctionType(from1, to1), ScalyFunctionType(from2, to2)) =>
        (from1, from2) match {
          case (None, None) => doesUnify(to1, to2)
          case (Some(f1), Some(f2)) =>
            doesUnify(f1, f2)(ctx, variance.flip)
              .flatMap(ur =>
                doesUnify(to1, to2)
                  .map(ur2 => UnificationCombination(t1, t2, ur, ur2))
              )
          case _ => ???
        }

      case (ScalyFunctionType(None, rt), _) => doesUnify(rt, t2)
      case (_, ScalyFunctionType(None, _)) => doesUnify_static(t2, t1)(ctx, variance.flip)

      case (ScalyValType(n1), ScalyValType(n2)) if (n1 equals n2) => Right(UnificationSuccess(t1, t2))

      case (ScalyTupleType(x :: Nil), y) => doesUnify(x, y)
      case (y, ScalyTupleType(x :: Nil)) => doesUnify(x, y)(ctx, variance.flip)

      case (ScalyValType.ScalyUnitType, ScalyTupleType(Nil)) => Right(UnificationSuccess(t1, t2))
      case (ScalyTupleType(Nil), ScalyValType.ScalyUnitType) => Right(UnificationSuccess(t1, t2))

      case _ if (variance == Variance.CO) =>
        if (t1.isSubtypeOf(t2)) Right(UnificationSuccess(t1, t2))
        else Left(UnificationFailure(t1, t2, s"Static types: $t1 is not a subtype of $t2"))

      case _ => Left(UnificationFailure(t1, t2, s"Cannot unify static types [$t1] and [$t2]"))
    }


}
