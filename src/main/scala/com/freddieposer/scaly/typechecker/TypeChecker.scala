package com.freddieposer.scaly.typechecker

import com.freddieposer.scaly.AST._
import com.freddieposer.scaly.backend.internal._
import com.freddieposer.scaly.backend.pyc.PyNone
import com.freddieposer.scaly.typechecker.TypeCheckerUtils._
import com.freddieposer.scaly.typechecker.Variance.Variance
import com.freddieposer.scaly.typechecker.context.TypeContext.{Location, buildTypeMap}
import com.freddieposer.scaly.typechecker.context.TypeInterpretation.TypeToInterpretation
import com.freddieposer.scaly.typechecker.context.{BaseTypeContext, MutableClosureContext, ThisTypeContext, TypeContext}
import com.freddieposer.scaly.typechecker.types.SymbolSource.SymbolSource
import com.freddieposer.scaly.typechecker.types._
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType.{ScalyBooleanType, ScalyUnitType}

class TypeChecker(
                   val ast: CompilationUnit
                 ) {


  private def addToError[T](node: ScalyAST, context: TypeContext)(f: => TCR[T]): TCR[T] =
    f.left.map(new TypeErrorContext(_, node)(context))

  //TODO: Clean up this code
  //  Ideas:  - Helper function for checking parameter types
  //            - And if they unify with actuals
  //          - Remove UnificationSuccess

  //TODO: Better errors with line numbers

  def typeCheck(): TCR[IST_CompilationUnit] = {

    val types: Map[String, ScalyASTClassType] =
      ast.statements.map {
        case c@ScalyClassDef(id, Nil, _, _) =>
          id -> ScalyASTClassType(id, None, c)
        //TODO: Multiple parents
        case c@ScalyClassDef(id, (parent, _) :: Nil, _, _) =>
          id -> ScalyASTClassType(id, Some(ScalyPlaceholderTypeName(parent.name)), c)
        case ScalyObjectDef(id, parents, body) => ???
      }.toMap

    val globalContext = BaseTypeContext.addTypes(types.map { case (id, typ) => id -> Location(typ, SymbolSource.GLOBAL) }.toList)

    ast.statements.map {
      case stat@ScalyClassDef(id, parents, body, params) =>

        // TODO: Typecheck default constructor expressions

        val ctx = new ThisTypeContext(types(id), Some(globalContext))


        params.map(p => convertType(p.paramType)(globalContext)).collapse.flatMap { paramTypes =>
          //TODO: Add constructor params - currently they show up as members in the context but not
          //  in the class members - _should_ mean that they cannot be accessed from outside but this
          //  is a bit of a hack until public/private is working
          val constructorParams = params.zip(paramTypes).map {
            case (p: VarClassParam, pt) => p.id -> Location(pt, SymbolSource.MEMBER)
            case (p, pt) => p.id -> Location(pt, SymbolSource.MEMBER)
          }

          //Typecheck the application of the parent if it exists
          val parentResult: TCR[List[IST_Expression]] = parents.headOption.map { case (p, pActualParams) =>
            implicit val parentConsCtx = globalContext.addVars(constructorParams)
            convertType(p).flatMap { parent =>
              (parent.constructor, pActualParams) match {
                case (None, Nil) => Right(Nil)
                case (None, _ :: _) =>
                  Left(TypeError(s"Parent ${p.name} of $id does not take construcor parameters", stat))
                case (Some(formalParams), actualParams) =>
                  if (formalParams.length != actualParams.length)
                    Left(TypeError(s"Parent ${p.name} of $id expects ${formalParams.length} constructor params, got ${actualParams.length}", stat))
                  else
                    actualParams.map(typeCheck_Expr(_)(parentConsCtx)).collapse.flatMap { actualsTypes =>
                      formalParams.map(fp => convertType(fp.paramType)).collapse.flatMap { formalsTypes =>
                        actualsTypes.zip(formalsTypes)
                          .map { case (t1, t2) => doesUnify(t1.typ, t2)(parentConsCtx, Variance.CO).mapError(stat) }
                          .collapse.map(_ => actualsTypes)
                      }
                    }
                case _ =>
                  Left(TypeError(s"Params for parent ${p.name} of class $id do not match", stat))
              }
            }
          }.getOrElse(Right(Nil))

          //Typecheck the body of the class
          parentResult.flatMap(pr => {
            val consCtx = ctx.addVars(constructorParams)
            body.map { template =>
              template.stats.map(stat =>
                typeCheck(stat, SymbolSource.MEMBER)(consCtx)
              ).collapse
            }.getOrElse(Right(Nil))
              .map(stats => ISTBuilder.buildISTClass(id, pr, stats.map(_._1), types(id)))
          })
        }


      case ScalyObjectDef(id, parents, body) => ???
    }.collapse.map(new IST_CompilationUnit(_))
  }


  def typeCheck(stat: Statement, source: SymbolSource)(implicit ctx: TypeContext): TCR[(IST_Statement, TypeContext)] =
    addToError(stat, ctx) {
      stat match {
        case e: Expr => typeCheck_Expr(e).map(t => (t, ctx))

        case d: Dcl => d match {
          case d: DefDef => typeCheck_def(d, source)
          case m@MemberDcl(id, typ, rhs) =>
            typeCheck_Expr(rhs).flatMap { rhsExpr =>
              typ.map(convertType) match {
                case Some(dt) => dt.flatMap { declaredType =>
                  doesUnify(rhsExpr.typ, declaredType)(ctx, Variance.CO)
                    .mapError(stat)
                    .map(_ => m match {
                      case _: ValDef => (
                        IST_Val(id, rhsExpr, Location(rhsExpr.typ, SymbolSource.LOCAL)),
                        ctx.addVar(id -> Location(rhsExpr.typ, source))
                      )
                      case _: VarDef => (
                        IST_Var(id, rhsExpr, Location(rhsExpr.typ, SymbolSource.LOCAL_WRITABLE)),
                        ctx.addVar(id -> Location(rhsExpr.typ, SymbolSource.writable(source).get))
                      )
                    })
                }
                case None => m match {
                  case _: ValDef =>
                    Right((
                      IST_Val(id, rhsExpr, Location(rhsExpr.typ, SymbolSource.LOCAL)),
                      ctx.addVar(id -> Location(rhsExpr.typ, source))
                    ))
                  case _: VarDef =>
                    Right((
                      IST_Val(id, rhsExpr, Location(rhsExpr.typ, SymbolSource.LOCAL)),
                      ctx.addVar(id -> Location(rhsExpr.typ, SymbolSource.writable(source).get))
                    ))
                }
              }
            }

        }
      }
    }

  def typeCheck_def(defDef: DefDef, source: SymbolSource)(implicit ctx: TypeContext): TCR[(IST_Def, TypeContext)] = addToError(defDef, ctx) {
    defDef match {
      case DefDef(id, params, retType, body) =>
        val paramResults = params.map(ps =>
          ps.map(p => p.name -> convertType(p.pType))
        )

        val errors: List[TypeError] = paramResults.map(_.collect { case (_, e@Left(_)) => e })
          .collect { case xs@_ :: _ => xs }.flatten.map(_.value)


        if (errors.nonEmpty)
          return Left(new TypeErrorCombination(s"Cannot typecheck parameters for def: $defDef", defDef, errors))

        val paramTypes = paramResults.map { ps => ps.map { case (n, Right(t)) => n -> t.typ }.toMap }
        val ptList = paramTypes.map(_.values.toList)
        (retType match {
          case Some(rt) => convertType(rt).map { declaredRT =>
            (MutableClosureContext(
              buildTypeMap(paramTypes.flatten.toMap, SymbolSource.LOCAL) +
                (id -> (ScalyFunctionType.build(declaredRT, ptList), SymbolSource.MEMBER)),
              ctx
            ), Some(declaredRT))
          }
          case None =>
            Right((MutableClosureContext(buildTypeMap(paramTypes.flatten.toMap, SymbolSource.LOCAL), ctx), None))
        }).flatMap { case (eCtx, rtOpt) =>
          typeCheck_Expr(body)(eCtx)
            .flatMap { actualRetType =>
              (rtOpt match {
                case Some(declaredRT) =>
                  doesUnify(actualRetType.typ, declaredRT)(ctx, Variance.CO)
                    .mapError(defDef)
                case None => Right(EmptyUS)
              }).map { _ =>
                val fType = ScalyFunctionType.build(actualRetType.typ, ptList)
                val freeVars = eCtx.freeVars.map(x => x -> ctx.getVarType(x)).map {
                  case (_, None) => ???
                  case (n, Some(l)) => n -> l
                }.toMap
                (
                  IST_Def(id, paramTypes, actualRetType, fType, eCtx.closedVars, freeVars),
                  ctx.addVar(id -> Location(fType, source))
                )
              }
            }
        }

    }
  }

  private def typeCheck_Expr(expr: Expr)(implicit ctx: TypeContext): TCR[IST_Expression] = addToError(expr, ctx) {
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
          .toRight(TypeError(s"Cannot find variable $name", expr))
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
          val lhsTyp = lhsExpr.typ match {
            case scalyType: ScalyASTPlaceholderType => convertType(scalyType.node)
            case x => Right(x)
          }
          lhsTyp.flatMap {
            case ScalyFunctionType(None, rType) =>
              actuals match {
                case Nil => Right(IST_Application(lhsExpr, Nil, rType))
                case _ => rType match {
                  case ScalyFunctionType(from, to) => ???
                  case _ => Left(TypeError("Cannot apply to non-unit function", expr))
                }
              }
            case ScalyFunctionType(Some(formalTypes), rType) =>
              actuals
                .map(typeCheck_Expr).collapse.flatMap { actualTypes =>
                doesUnify(ScalyTupleType(actualTypes.map(_.typ)), formalTypes)(ctx, Variance.CO)
                  .mapError(expr)
                  .map(_ => IST_Application(lhsExpr, actualTypes, rType))
              }
            case obj =>
              obj.getMember("apply") match {
                case Right(Location(_: ScalyFunctionType, _)) => typeCheck_Expr(Application(SelectExpr(lhs, "apply"), actuals))
                case Right(Location(typ, _)) => Left(TypeError(s"Cannot apply $actuals to non-functional $typ", expr))
                case e@Left(_) => Left(TypeError(s"Object $obj doesn't contain an apply member", expr))
              }
          }
        }

      case IfExpr(cond, tBranch, fBranch) =>
        typeCheck_Expr(cond)
          .flatMap { condExpr =>
            doesUnify(condExpr.typ, ScalyBooleanType)(ctx, Variance.CO)
              .mapError(cond).flatMap(_ => typeCheck_Expr(tBranch).flatMap(
              tBranchExpr => typeCheck_Expr(fBranch).flatMap(
                fBranchExpr => doesUnify(tBranchExpr.typ, fBranchExpr.typ)(ctx, Variance.IN)
                  .mapError(expr).flatMap {
                  //TODO: Common parent - the return type may not be tBranchExpr if they are not the same
                  //TODO: No false branch
                  _ => Right(IST_If(condExpr, tBranchExpr, Some(fBranchExpr), tBranchExpr.typ))
                }
              )
            ))
          }

      case Block(statements) =>
        val res = statements
          .foldLeft((Right((IST_Literal(PyNone, ScalyUnitType), ctx)) :: Nil): List[TCR[(IST_Statement, TypeContext)]]) {
            case ((x@Right((_, nctx))) :: xs, stat) =>
              typeCheck(stat, SymbolSource.LOCAL)(nctx) :: x :: xs
            case ((e@Left(_)) :: _, _) => e :: Nil
          }
        res match {
          case Left(e) :: _ => Left(e)
          case xs@Right((x, _)) :: _ =>
            //Drop the first element which is a simple PyNone literal
            Right(IST_Block(xs.map { case Right(z) => z._1 }.reverse.tail, x.typ))
        }

      case NewExpr(astType@AST_ScalyTypeName(name), params) =>
        convertType(astType).flatMap { typ =>
          typ.constructor.map(constructor => {
            if (constructor.length == params.length) {
              params.map(typeCheck_Expr).collapse.flatMap { actualsExpressions =>
                constructor.map(p => convertType(p.paramType)).collapse.flatMap { formalTypes =>
                  actualsExpressions.zip(formalTypes)
                    .map { case (a, f) => doesUnify(a.typ, f)(ctx, Variance.CO).mapError(expr) }
                    .collapse
                    .map(_ => IST_New(name, actualsExpressions, typ))
                }
              }
            } else {
              Left(TypeError(s"${constructor.length} params required for $typ constructor but got ${params.length}", expr))
            }
          }).getOrElse(Left(TypeError(s"Cannot construct $typ", expr)))
        }

      case AssignExpr(lhs, rhs) => lhs match {
        case IDExpr(_) => typeCheck_Expr(lhs).flatMap {
          case IST_Name(name, location) =>
            if (SymbolSource.isWritable(location.source))
              typeCheck_Expr(rhs).flatMap { ist =>
                doesUnify(ist.typ, location.typ)(ctx, Variance.CO).mapError(expr).map(_ => IST_Assignment(name, location, ist))
              }
            else Left(TypeError(s"Cannot assign to $name [location $location]", expr))
        }
        case _ => ???
      }

      case WhileExpr(cond, body) => typeCheck_Expr(cond).flatMap { condIST =>
        doesUnify(condIST.typ, ScalyBooleanType)(ctx, Variance.CO)
          .mapError(expr)
          .flatMap { _ =>
            typeCheck_Expr(body).map { bodyIST => IST_While(condIST, bodyIST) }
          }
      }


    }
  }

  //

  /**
   * Does t1 unify with t2 under the given variance
   * Unifies if:
   *  - t1 == t2
   *  - t1 &#60; t2 and CO-VARIANT
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

  def doesUnify_static(t1: StaticScalyType, t2: StaticScalyType)(implicit ctx: TypeContext, variance: Variance): UR = {
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


  /**
   * Convert a type from an AST node to an actual type
   *
   * @param astType Type to be converted
   * @param context Type context at point of conversion
   * @return
   */
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

}
