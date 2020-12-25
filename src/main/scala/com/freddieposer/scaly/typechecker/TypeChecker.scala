package com.freddieposer.scaly.typechecker

import com.freddieposer.scaly.AST._
import com.freddieposer.scaly.backend.internal._
import com.freddieposer.scaly.backend.pyc.PyNone
import com.freddieposer.scaly.typechecker.Utils._
import com.freddieposer.scaly.typechecker.Variance.Variance
import com.freddieposer.scaly.typechecker.context.TypeContext.{Location, buildTypeMap}
import com.freddieposer.scaly.typechecker.context.TypeInterpretation.TypeToInterpretation
import com.freddieposer.scaly.typechecker.context.{BaseTypeContext, ThisTypeContext, TypeContext}
import com.freddieposer.scaly.typechecker.types._
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType.{ScalyBooleanType, ScalyUnitType}

class TypeChecker(
                   val ast: CompilationUnit
                 ) {


  def addToError[T <: IST](node: ScalyAST, context: TypeContext)(f: => TCR[T]): TCR[T] =
    f.left.map(new TypeErrorContext(_, node)(context))

  def typeCheck(): TCR[IST_CompilationUnit] = {

    val types: Map[String, ScalyASTClassType] =
      ast.statements.map {
        case c@ScalyClassDef(id, parents, _, _) =>
          id -> ScalyASTClassType(id, parents.headOption.map(ScalyPlaceholderTypeName), c)
        case ScalyObjectDef(id, parents, body) => ???
      }.toMap

    val globalContext = BaseTypeContext.addTypes(types.map { case (id, typ) => id -> Location(typ, SymbolSource.GLOBAL) }.toList)

    ast.statements.map {
      //TODO: Parents
      case ScalyClassDef(id, parents, body, params) =>
        val ctx = new ThisTypeContext(types(id), Some(globalContext))
        body.map(template =>
          template.stats.map(stat =>
            typeCheck(stat)(ctx, Variance.IN)
          ).collapse)
          .getOrElse(Right(Nil))
          .map(stats => ISTBuilder.buildISTClass(id, stats, types(id)))
      case ScalyObjectDef(id, parents, body) => ???
    }.collapse.map(new IST_CompilationUnit(_))
  }

  //TODO: Passing the context with the IST? - see block
  //  def updateContext[T <: IST](id: String)
  //                             (f: () => TCR[T])
  //                             (implicit context: TypeContext): TCR[T] = {
  //    f().map { case s@Success(t, n) => Success(t, n)(s.ctx.addVar(id -> t)) }
  //  }


  private def convertType(astType: AST_ScalyType)(implicit context: TypeContext): TCR[ScalyType] = addToError(astType, context) {
    astType match {
      case AST_ScalyTypeName(name) =>
        context.getWellFormedType(name)
          .toRight(TypeError(s"Cannot find type name $name", astType))
          .map(l => l.typ)
      case AST_ScalyTypeSelect(lhs, rhs) => ???
      case AST_TupleScalyType(types) =>
        types
          .map(convertType)
          .collapse
          .map(res => ScalyTupleType(res))
      case AST_FunctionScalyType(arguments, returnType) =>
        (arguments.map(convertType).collapse, convertType(returnType)) match {
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


  def typeCheck(stat: Statement)(implicit ctx: TypeContext, variance: Variance): TCR[IST_Statement] = addToError(stat, ctx) {
    stat match {
      case e: Expr => typeCheck_Expr(e)

      case d: Dcl => d match {
        case DefDef(id, params, retType, body) =>
          val paramResults = params.map(ps =>
            ps.map(p => p.name -> convertType(p.pType))
          )
          val errors: List[TypeError] = paramResults.map(_.collect { case (_, e@Left(_)) => e })
            .collect { case xs@_ :: _ => xs }.flatten.map(_.value)
          errors match {
            case Nil =>
              val paramTypes = paramResults.map { ps => ps.map { case (n, Right(t)) => n -> t.typ }.toMap }
              val ptList = paramTypes.map(_.values.toList)
              retType match {
                //Return type is specified
                case Some(rt) => convertType(rt).flatMap { declaredRT =>
                  val extendedContext = ctx.extend(
                    Map(),
                    buildTypeMap(paramTypes.flatten.toMap, SymbolSource.LOCAL)
                      + (id -> (ScalyFunctionType.build(declaredRT, ptList), SymbolSource.MEMBER))
                  )
                  typeCheck_Expr(body)(extendedContext, variance)
                    .flatMap { actualRetType =>
                      doesUnify(actualRetType.typ, declaredRT)(ctx, Variance.CO)
                        .mapError(stat)
                        .map { _ =>
                          IST_Def(id, paramTypes, actualRetType, ScalyFunctionType.build(actualRetType.typ, ptList))
                        }
                    }
                }
                //No return type declared - infer it. Cannot be recursive
                case None =>
                  typeCheck_Expr(body)(ctx.addVars(buildTypeMap(paramTypes.flatten.toMap, SymbolSource.LOCAL)), variance)
                    .map(bodyExpr => IST_Def(id, paramTypes, bodyExpr, ScalyFunctionType.build(bodyExpr.typ, ptList)))

                //TODO: Update the type in the context?

              }
            //TODO Add info
            case es@_ :: _ => Left(TypeError(s"Cannot typecheck parameters for def: $stat", stat))
          }


        case m@MemberDcl(id, typ, rhs) =>
          typeCheck_Expr(rhs).flatMap { rhsExpr =>
            typ.map(convertType) match {
              case Some(dt) => dt.flatMap { declaredType =>
                doesUnify(rhsExpr.typ, declaredType)(ctx, Variance.CO)
                  .mapError(stat)
                  .map(_ => m match {
                    case _: ValDef => IST_Val(id, rhsExpr, rhsExpr.typ)
                    case _: VarDef => IST_Var(id, rhsExpr, rhsExpr.typ)
                  })
              }
              case None => m match {
                case _: ValDef => Right(IST_Val(id, rhsExpr, rhsExpr.typ))
                case _: VarDef => Right(IST_Var(id, rhsExpr, rhsExpr.typ))
              }
            }
          }

      }
    }
  }

  private def typeCheck_Expr(expr: Expr)(implicit ctx: TypeContext, variance: Variance): TCR[IST_Expression] = addToError(expr, ctx) {
    expr match {
      case l: Literal =>
        Right(ISTBuilder.buildLiteral(l, ScalyValType.literalType(l)))

      case SelectExpr(lhs, rhs) =>
        typeCheck_Expr(lhs).flatMap { lhsExpr =>
          lhsExpr.typ.getMember(rhs)
            .map(l => IST_Select(lhsExpr, rhs, l.typ))
            .left.map(TypeError(_, expr))
        }

      case IDExpr(name) =>
        ctx.getVarType(name)
          .toRight(TypeError(s"Cannot find type $name", expr))
          .map(IST_Name(name, _))

      case TupleExpr(elems) =>
        elems
          .map(typeCheck_Expr)
          .collapse
          .flatMap(ts => ScalyTupleType(ts.map(_.typ)) match {
            case ScalyUnitType => Right(IST_Literal(PyNone, ScalyUnitType))
            case tuple: ScalyTupleType => Right(IST_TupleExpr(ts, tuple))
            case _ => typeCheck_Expr(elems.head)
          })

      case Application(lhs, actuals) =>
        typeCheck_Expr(lhs).flatMap { lhsExpr =>
          lhsExpr.typ match {
            case ScalyFunctionType(None, rType) =>
              actuals match {
                case Nil => Right(IST_Application(lhsExpr, Nil, rType))
                case _ => rType match {
                  case ScalyFunctionType(from, to) => ???
                  case _ => Left(TypeError("Cannot apply to non-unit function", expr))
                }
              }
            case ScalyFunctionType(Some(formalTypes), rType) =>
              //TODO: formalTypes can be None - this would be invalid?
              actuals
                .map(typeCheck_Expr).collapse.flatMap { actualTypes =>
                doesUnify(ScalyTupleType(actualTypes.map(_.typ)), formalTypes)(ctx, Variance.CO)
                  .mapError(expr)
                  .map(_ => IST_Application(lhsExpr, actualTypes, rType))
              }
            //TODO: Apply syntax
            case _ => Left(TypeError("Application of non-functional type", expr))
          }
        }

      case IfExpr(cond, tBranch, fBranch) =>
        typeCheck_Expr(cond)
          .flatMap { condExpr =>
            doesUnify(condExpr.typ, ScalyBooleanType)(ctx, Variance.CO)
              .mapError(cond)
              .flatMap(_ => typeCheck_Expr(tBranch).flatMap(
                tBranchExpr => typeCheck_Expr(fBranch).flatMap(
                  fBranchExpr => doesUnify(tBranchExpr.typ, fBranchExpr.typ)(ctx, Variance.IN)
                    .mapError(expr)
                    .flatMap {
                      //TODO: Common parent - the return type may not be tBranchExpr if they are not the same
                      //TODO: No false branch
                      _ => Right(IST_If(condExpr, tBranchExpr, Some(fBranchExpr), tBranchExpr.typ))
                    }
                )
              ))
          }
      case Block(statements) =>
        val res = statements
          .foldLeft((Right(IST_Literal(PyNone, ScalyUnitType)) :: Nil): List[TCR[IST_Statement]]) {
            case ((x@Right(_: IST_Statement)) :: xs, stat) =>
              //TODO: Update the context! - here if there is a val or var the context will have changed so
              //  we need to deal with that. Removed contexts from TCR when made it IST so may need to add that in
              typeCheck(stat)(ctx, variance) :: x :: xs
            case ((e@Left(_)) :: _, _) => e :: Nil
          }
        res match {
          case Left(e) :: _ => Left(e)
          case xs@Right(x) :: _ => Right(IST_Block(xs.map { case Right(z) => z }.reverse, x.typ))
        }

      case NewExpr(astType@AST_ScalyTypeName(name), params) =>
        convertType(astType).map { typ =>
          params.map(typeCheck_Expr)
          if (params.nonEmpty) ???
          else IST_New(name, Nil, typ)
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
