package com.freddieposer.scaly.typechecker

import com.freddieposer.scaly.AST._
import com.freddieposer.scaly.backend.internal._
import com.freddieposer.scaly.backend.pyc.PyNone
import com.freddieposer.scaly.typechecker.TypeCheckerUtils._
import com.freddieposer.scaly.typechecker.Variance.Variance
import com.freddieposer.scaly.typechecker.context.TypeContext.{Location, buildTypeMap}
import com.freddieposer.scaly.typechecker.context.TypeInterpretation._
import com.freddieposer.scaly.typechecker.context._
import com.freddieposer.scaly.typechecker.types.SymbolSource.SymbolSource
import com.freddieposer.scaly.typechecker.types._
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType.{ScalyBooleanType, ScalyNothingType, ScalyUnitType, literalType}

import scala.annotation.tailrec

object TypeChecker {

  //TODO: This is a hack - remove
  def typeCheck(ast: CompilationUnit): TCR[IST_CompilationUnit] = {
    try {
      _typeCheck(ast)
    } catch {
      case e@InferenceError(node) => Left(TypeError(e.getMessage, node)(EmptyContext))
    }
  }

  //TODO: Clean up this code
  //  Ideas:  - Helper function for checking parameter types
  //            - And if they unify with actuals
  //          - Remove UnificationSuccess

  //TODO: Better errors with line numbers

  def typeCheck(stat: Statement, source: SymbolSource)(implicit ctx: TypeContext): TCR[(IST_Statement, TypeContext)] =
    addToError(stat, ctx) {
      stat match {
        case e: Expr => typeCheck_Expr(e).map(t => (t, ctx))

        case d: Dcl => d match {
          case d: DefDef => typeCheck_def(d, source)
          case m@MemberDcl(id, typ, rhs) =>
            typeCheck_Expr(rhs).flatMap { rhsExpr =>
              (typ.map(_.fromAST) match {
                case Some(dt) => dt.flatMap { declaredType =>
                  doesUnify(rhsExpr.typ, declaredType)(ctx, Variance.CO)
                    .mapError(stat)
                }
                case None => Right(EmptyUS)
              }).map { _ =>
                m match {
                  case _: ValDef =>
                    (
                      IST_Val(id, rhsExpr, Location(rhsExpr.typ, source)),
                      ctx.addVar(id -> Location(rhsExpr.typ, source))
                    )
                  case _: VarDef =>
                    (
                      IST_Val(id, rhsExpr, Location(rhsExpr.typ, SymbolSource.writable(source).get)),
                      ctx.addVar(id -> Location(rhsExpr.typ, SymbolSource.writable(source).get))
                    )
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
          ps.map(p => p.name -> p.pType.fromAST)
        )

        val errors: List[TypeError] = paramResults.map(_.collect { case (_, e@Left(_)) => e })
          .collect { case xs@_ :: _ => xs }.flatten.map(_.value)

        if (errors.nonEmpty)
          return Left(new TypeErrorCombination(s"Cannot typecheck parameter types for def: $defDef", defDef, errors))

        val paramTypes = paramResults.map { ps => ps.map { case (n, Right(t)) => n -> t.typ }.toMap }
        val ptList = paramTypes.map(_.values.toList)
        (retType match {
          case Some(rt) => rt.fromAST.map { declaredRT =>
            (MutableClosureContext(
              buildTypeMap(paramTypes.flatten.toMap, SymbolSource.LOCAL) +
                (id -> (
                  ScalyFunctionType.build(declaredRT, ptList),
                  SymbolSource.localClosure(SymbolSource.nonWritable(source)))
                  ),
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
                val newCtx = ctx.addVar(id -> Location(fType, source))

                val location =
                  if (eCtx.freeVars.contains(id)) {
                    newCtx.escalateVar(id)
                    Location(fType, SymbolSource.localClosure(source))
                  }
                  else Location(fType, source)

                (
                  IST_Def(id, paramTypes, actualRetType, fType, eCtx.closedVars, eCtx.freeVars(newCtx), location.writable.get),
                  newCtx,
                )
              }
            }
        }

    }
  }

  private def canMatch(typ: ScalyType, pattern: Pattern)(implicit context: TypeContext): TCR[IST_Pattern] = addToError(pattern, context) {
    pattern match {
      case LiteralPattern(literal) =>
        doesUnify(typ, literalType(literal))(context, Variance.CO)
          .mapError(pattern)
          .map(_ => IST_LiteralPattern(ISTBuilder.buildLiteral(literal)))
      case VariablePattern(name) => Right(IST_VariablePattern(name, typ))
      case WildcardPattern => Right(IST_WildcardPattern(typ))
      case TuplePattern(pats) =>
        typ match {
          case ScalyTupleType(elems) if elems.length == pats.length =>
            (elems zip pats)
              .map { case (x, y) => canMatch(x, y) }
              .collapse
              .map(IST_TuplePattern)
          case _ =>
            Left(TypeError(s"Pattern $pattern cannot match $typ", pattern))
        }
      case ExtractorPattern(name, pats) =>
        context.getVarType(name)
          .flatMap(typeLocation => typeLocation.getOwnMemberLocation("unapply").map(l => (typeLocation, l)))
          .map {
            case (typeLocation, unapplyLocation@Location(unapplyType, _)) =>
              val fType = unapplyType match {
                case t: ScalyASTPlaceholderType => t.node.fromAST
                case ScalyFunctionType(Some(f: ScalyASTPlaceholderType), t: ScalyASTPlaceholderType) =>
                  f.node.fromAST.flatMap(from => t.node.fromAST.flatMap(to => Right(ScalyFunctionType(Some(from), to))))
                case ScalyFunctionType(Some(f: ScalyASTPlaceholderType), to) =>
                  f.node.fromAST.flatMap(from => Right(ScalyFunctionType(Some(from), to)))
                case ScalyFunctionType(from, t: ScalyASTPlaceholderType) =>
                  t.node.fromAST.flatMap(to => Right(ScalyFunctionType(from, to)))
                case t => Right(t)
              }
              fType.flatMap {
                case t@ScalyFunctionType(Some(from), inner) =>

                  (inner match {
                    case inner: ScalyTupleType => canMatch(inner, TuplePattern(pats))
                    case _ if pats.length == 1 => canMatch(inner, pats.head)
                    case _ => Left(TypeError(s"Cannot match patterns $pats to $inner type", pattern))
                  }).map {
                      case IST_TuplePattern(compiledPats) =>
                        IST_ExtractorPattern(
                          IST_Select(IST_Name(name, typeLocation), "unapply", Location(t, SymbolSource.MEMBER)),
                          compiledPats, from
                        )
                      case p => IST_ExtractorPattern(
                        IST_Select(IST_Name(name, typeLocation), "unapply", Location(t, SymbolSource.MEMBER)),
                        p :: Nil, from
                      )
                    }

                case _ => Left(TypeError(s"Cannot match non-functional unapply type $fType", pattern))
              }
          }.getOrElse(Left(TypeError(s"Cannot find unnapply on $name", pattern)))
      case NamePattern(name) =>
        context.getVarType(name)
          .map(l => l -> doesUnify(l.typ, typ)(context, Variance.CO))
          .map {
            case _ -> Left(value) => Left(TypeError(s"Pattern $pattern type ${value.t1} does not unify with $typ", pattern))
            case l -> Right(value) => Right(IST_NamePattern(name, l, value.t1))
          }.getOrElse(Left(TypeError(s"Cannot find name $name for pattern", pattern)))
      case _ => Left(TypeError(s"Pattern $pattern cannot match $typ", pattern))
    }
  }

  private def addToError[T](node: ScalyAST, context: TypeContext)(f: => TCR[T]): TCR[T] =
    f.left.map(new TypeErrorContext(_, node)(context))

  private def _typeCheck(ast: CompilationUnit): TCR[IST_CompilationUnit] = {

    val types: Map[String, ScalyASTTemplateType] =
      ast.statements.map {
        case c@ScalyClassDef(id, Nil, _, _) =>
          id -> ScalyASTClassType(id, None, c)
        //TODO: Multiple parents
        case c@ScalyClassDef(id, (parent, _) :: Nil, _, _) =>
          id -> ScalyASTClassType(id, Some(ScalyPlaceholderTypeName(parent.name)), c)
        case o@ScalyObjectDef(id, Nil, _) =>
          (id + "$") -> ScalyASTObjectType(id, None, o)
        case o@ScalyObjectDef(id, (parent, _) :: Nil, _) =>
          (id + "$") -> ScalyASTObjectType(id, Some(ScalyPlaceholderTypeName(parent.name)), o)
      }.toMap

    val globalObjects: Map[String, Location] =
      types.flatMap {
        case _ -> (t@ScalyASTObjectType(_, _, _)) => Some(t.name -> Location(t, SymbolSource.GLOBAL_LAZY))
        case _ => None
      }

    val globalContext = BaseTypeContext
      .addTypes(types.map { case (id, typ) => id -> Location(typ, SymbolSource.GLOBAL) }.toList)
      .addVars(globalObjects)

    def getTType(id: String): ScalyASTTemplateType =
      types.get(id).orElse(types.get(id + "$")).get

    def checkBody(stat: TemplateDef, params: TCR[List[(ClassParam, ScalyType)]]): TCR[IST_Template] = params.flatMap { paramTypes =>
      stat match {
        case TemplateDef(id, parents, body) =>
          val ctx = new ThisTypeContext(getTType(id), Some(globalContext))

          val constructorParams = paramTypes.map {
            case (p: VarClassParam, pt) => p.id -> Location(pt, SymbolSource.MEMBER)
            case (p, pt) => p.id -> Location(pt, SymbolSource.MEMBER)
          }

          // TODO: Typecheck default constructor expressions
          //TODO: Add constructor params - currently they show up as members in the context but not
          //  in the class members - _should_ mean that they cannot be accessed from outside but this
          //  is a bit of a hack until public/private is working
          //Typecheck the application of the parent if it exists
          val parentResult: TCR[List[IST_Expression]] = parents.headOption.map { case (p, pActualParams) =>
            implicit val parentConsCtx: TypeContext = globalContext.addVars(constructorParams)
            p.fromAST.flatMap { parent =>
              (parent.constructor, pActualParams) match {
                case (None, Nil) => Right(Nil)
                case (None, _ :: _) =>
                  Left(TypeError(s"Parent ${p.name} of $id does not take construcor parameters", stat))
                case (Some(formalParams), actualParams) =>
                  formalParams.map(fp => fp.paramType.fromAST)
                    .collapse.flatMap { formalsTypes =>
                    canApply(formalsTypes, actualParams, stat)
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
              .map(stats => stat match {
                case _: ScalyClassDef => ISTBuilder.buildISTClass(id, pr, stats.map(_._1), getTType(id))
                case _: ScalyObjectDef => ISTBuilder.buildISTObject(id, pr, stats.map(_._1), getTType(id))
              })
          })

      }
    }


    ast.statements.map {
      case stat@ScalyClassDef(_, _, _, params) =>
        val paramTypes = params.map(p => interpret(p.paramType, globalContext).fromAST)
          .collapse
          .map { paramTypes => params.zip(paramTypes) }
        checkBody(stat, paramTypes)

      case stat: ScalyObjectDef => checkBody(stat, Right(Nil))
    }.collapse.map(new IST_CompilationUnit(_))
  }

  private def typeCheck_Expr(expr: Expr)(implicit ctx: TypeContext): TCR[IST_Expression] = addToError(expr, ctx) {
    expr match {
      case l: Literal =>
        Right(ISTBuilder.buildLiteral(l))

      case SelectExpr(lhs, rhs) =>
        typeCheck_Expr(lhs).flatMap { lhsExpr =>
          lhsExpr.typ.getMember(rhs)
            .map {
              case l@Location(_: ScalyFunctionTypeWithTarg, _) =>
                IST_Select(lhsExpr, rhs, l)
              case l@Location(ScalyFunctionType(None, to), _) =>
                IST_Application(IST_Select(lhsExpr, rhs, l), Nil, to)
              case l => IST_Select(lhsExpr, rhs, l)
            }
//            .map(l => IST_Select(lhsExpr, rhs, l))
            .left.map(TypeError(_, expr))
        }

      case IDExpr(name) =>
        ctx.getVarType(name)
          .toRight(TypeError(s"Cannot find variable $name", expr))
          .map {
            case l@Location(_: ScalyFunctionTypeWithTarg, _) =>
              IST_Name(name, l)
            case l@Location(ScalyFunctionType(None, to), _) =>
              IST_Application(IST_Name(name, l), Nil, to)
            case l => IST_Name(name, l)
          }
//          .map(IST_Name(name, _))

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
            case scalyType: ScalyASTPlaceholderType => scalyType.node.fromAST
            case x => Right(x)
          }
          lhsTyp.flatMap {

            case ScalyFunctionTypeWithTarg(None, to) =>
              Right(IST_Application(lhsExpr, Nil, ScalyFunctionTypeWithTarg(None, to)))

            case ScalyFunctionType(None, rType) =>
              actuals match {
                case Nil => Right(IST_Application(lhsExpr, Nil, rType))
                case _ => rType match {
                  case ScalyFunctionType(from, to) => ???
                  case _ => Left(TypeError("Cannot apply to non-unit function", expr))
                }
              }
            case ScalyFunctionType(Some(formalTypes), rType) =>
              canApply(formalTypes, actuals, expr)
                .map(exprs => IST_Application(lhsExpr, exprs, rType))

            case obj =>
              obj.getMember("apply") match {
                case Right(Location(_: ScalyFunctionType, _)) => typeCheck_Expr(Application(SelectExpr(lhs, "apply"), actuals))
                case Right(Location(typ, _)) => Left(TypeError(s"Cannot apply $actuals to non-functional $typ", expr))
                case e@Left(_) => Left(TypeError(s"Object $obj doesn't contain an apply member", expr))
              }
          }
        }

      case ApplicationWithType(lhs, targ :: Nil) =>
        typeCheck_Expr(lhs).flatMap { lhsExpr =>
          lhsExpr.typ match {
            case ScalyFunctionTypeWithTarg(None, to) =>
              targ.fromAST map { targType =>
                  IST_ApplicationWithType(lhsExpr, targType :: Nil, to)
              }
            case x => Left(TypeError(s"Only functions with one type argument and no parameters are supported, got $x", expr))
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
        astType.fromAST.flatMap { typ =>
          typ.constructor.map(constructor => {
            constructor.map(p => p.paramType.fromAST).collapse.flatMap { formals =>
              canApply(formals, params, expr)
            }.map(actuals => IST_New(name, actuals, typ))
          }).getOrElse(Left(TypeError(s"Cannot construct $typ", expr)))
        }

      case AssignExpr(lhs, rhs) => lhs match {
        case SelectExpr(_, _) | IDExpr(_) => typeCheck_Expr(lhs).flatMap { compiledLHS =>
          val location = compiledLHS match {
            case IST_Name(_, location) => location
            case IST_Select(_, _, location) => location
          }

          if (SymbolSource.isWritable(location.source))
            typeCheck_Expr(rhs).flatMap { compiledRHS =>
              doesUnify(compiledRHS.typ, location.typ)(ctx, Variance.CO)
                .mapError(expr)
                .map { _ => compiledLHS match {
                  case n: IST_Name => IST_Assignment(n, compiledRHS)
                  case s:IST_Select => IST_SelectAssignment(s, compiledRHS)
                }}
            }
          else Left(TypeError(s"Cannot assign to $lhs [location $location]", expr))

        }
      }

      case WhileExpr(cond, body) => typeCheck_Expr(cond).flatMap { condIST =>
        doesUnify(condIST.typ, ScalyBooleanType)(ctx, Variance.CO)
          .mapError(expr)
          .flatMap { _ =>
            typeCheck_Expr(body).map { bodyIST => IST_While(condIST, bodyIST) }
          }
      }

      case FunctionExpr(params, body) =>
        params.map(p => p.pType.fromAST
          .map(p.name -> Location(_, SymbolSource.LOCAL)))
          .collapse
          .flatMap { paramTypes =>
            val eCtx = MutableClosureContext(paramTypes.toMap, ctx)
            typeCheck_Expr(body)(eCtx).map { bodyIST =>
              IST_Function.build(
                List(paramTypes.map { case (n, l) => n -> l.typ }.toMap),
                bodyIST, bodyIST.typ,
                eCtx.closedVars, eCtx.freeVars(ctx)
              )
            }
          }

      case MatchExpr(lhs, cases) =>
        typeCheck_Expr(lhs).flatMap { lexpr =>
          cases.map { c => canMatch(lexpr.typ, c.pattern) }
            .collapse
            .flatMap { patterns =>
              patterns.zip(cases).map { case (pat, c) =>
                val ectx = MutableClosureContext(buildTypeMap(pat.bindings.toMap, SymbolSource.LOCAL), ctx)
                typeCheck_Expr(c.result)(ectx).map((_, ectx))
              }.collapse
                .flatMap(retExprs => unify(retExprs.map(_._1.typ)) match {
                  case None => Left(TypeError(s"Cannot unify return types of $retExprs for patterns", expr))
                  case Some(retType) =>
                    val compiledCases = patterns.zip(retExprs).map {
                      case (p, (body, ectx)) => IST_Case(p, body, ectx.closedVars, ectx.freeVars(ctx))
                    }
                    Right((compiledCases, retType))
                })
            }.map { case (cs, retType) => IST_Match(lexpr, cs, retType) }
        }
    }
  }

  private def unify(ts: List[ScalyType])(implicit ctx: TypeContext): Option[ScalyType] = {
    ts.foldLeft(Some(ScalyNothingType): Option[ScalyType]) {
      case (Some(x), y) =>
        doesUnify(x, y)(ctx, Variance.CO)
          .map(_ => y)
          .left.map(_ => doesUnify(y, x)(ctx, Variance.CO).map(_ => x).toOption)
        match {
          case Left(x@Some(_)) => x
          case Right(x) => Some(x)
          case Left(None) => None
        }
      case (None, _) => None
    }
  }

  /**
   * Does t1 unify with t2 under the given variance
   * Unifies if:
   *  - t1 == t2
   *  - t1 &#60; t2 and CO-VARIANT
   *  - t1 > t2 and CONTRA-VARIANT
   *
   * NOTE: For variance we need to be incredibly careful with the order of these types
   *
   * @return
   */
  private def doesUnify(t1: ScalyType, t2: ScalyType)(implicit ctx: TypeContext, variance: Variance): UR =
    (t1, t2) match {
      case _ if variance == Variance.CONTRA => doesUnify(t2, t1)(ctx, Variance.CO)
      case _ if t1.equals(t2) => Right(UnificationSuccess(t1, t2))
      case (x: ScalyASTPlaceholderType, _) =>
        x.node.fromAST
          .mapError(t1, t2)
          .flatMap { t => doesUnify(t.typ, t2) }
      case (_, x: ScalyASTPlaceholderType) =>
        x.node.fromAST
          .mapError(t1, t2)
          .map { t => doesUnify(t1, t.typ) }.collapse

      case (static1: StaticScalyType, static2: StaticScalyType) =>
        doesUnifyStatic(static1, static2)


      case _ if (variance == Variance.CO) =>
        if (t1.isSubtypeOf(t2)) Right(UnificationSuccess(t1, t2))
        else Left(UnificationFailure(t1, t2, s"$t1 is not a subtype of $t2"))

      case (x: ScalyASTClassType, y: ScalyASTClassType) =>
        //TODO: currently just checks reference equality
        if (x equals y) Right(UnificationSuccess(x, y))
        else Left(UnificationFailure(x, y, s"Classes ${x.name} and ${y.name} are not equal"))

      case _ => Left(UnificationFailure(t1, t2, s"Cannot unify types ${t1} and ${t2} under $variance"))

    }

  private def canApply(formals: ScalyType, actuals: List[Expr], node: ScalyAST)(implicit ctx: TypeContext): TCR[List[IST_Expression]] =
    formals match {
      case ScalyUnitType =>
        if (actuals.isEmpty) Right(Nil)
        else Left(TypeError(s"Expected no params, got ${actuals.length} for $node", node))
      case ScalyTupleType(elems) => canApply(elems, actuals, node)
      case _ => canApply(List(formals), actuals, node)
    }

  private def canApply(formals: List[ScalyType], actuals: List[Expr], node: ScalyAST)(implicit ctx: TypeContext): TCR[List[IST_Expression]] = {
    if (formals.length != actuals.length)
      return Left(TypeError(s"Expected ${formals.length} params got ${actuals.length} params for $node", node))

    actuals.map(typeCheck_Expr)
      .collapse
      .flatMap { actualsIST =>
        actualsIST
          .zip(formals)
          .map { case (a, f) => doesUnify(a.typ, f)(ctx, Variance.CO).mapError(node) }
          .collapse
          .map(_ => actualsIST)
      }
  }

  @tailrec
  private def doesUnifyStatic(t1: StaticScalyType, t2: StaticScalyType)(implicit ctx: TypeContext, variance: Variance): UR = {
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
      case (_, ScalyFunctionType(None, _)) => doesUnifyStatic(t2, t1)(ctx, variance.flip)

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


}
