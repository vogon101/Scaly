package com.freddieposer.scaly.typechecker

import com.freddieposer.scaly.AST._
import com.freddieposer.scaly.typechecker.Variance.Variance
import com.freddieposer.scaly.typechecker.context.{BaseTypeContext, ThisTypeContext, TypeContext}
import com.freddieposer.scaly.typechecker.types._
import com.freddieposer.scaly.typechecker.Utils._
import com.freddieposer.scaly.typechecker._TypeCheckResult._

import scala.annotation.tailrec

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

  def TCRFold[T](acc: TCR)(f: (T, TypeCheckSuccess) => TCR)(xs: List[T]): TCR =
    xs.foldLeft(acc) {
      case (e@Left(_), _) => e
      case (Right(s), x) =>
        f(x, s).map { case s2@Success(typ, node) => Successes(typ, node, List(s))(s2.ctx) }
    }

  def addToError(node: ScalyAST, context: TypeContext)(f: => TCR): TCR =
    f.left.map(new TypeErrorContext(_, node)(context))

  def typeCheck(): TCR = {

    ast.statements.map {
      case node@ScalyClassDef(id, parents, body, params) =>
        //TODO: Inheritance
        val ctx = new ThisTypeContext(ScalyASTClassType(id, None, node), Some(globalContext))
        body.map(stat =>
          TCRFold[Statement](Right(Success(ScalyValType.ScalyUnitType, UnitLiteral)(ctx))) {
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
      case (xs, acc) => ScalyFunctionType(Some(ScalyTupleType(xs)), acc)
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
          val errors = paramResults.map(_.collect { case (_, e@Left(_)) => e }).collect { case xs@_ :: _ => xs }
          errors match {
            case Nil =>
              val paramTypes = paramResults.map { ps => ps.map { case (n, Right(t)) => n -> t.typ } }
              retType match {
                case Some(rt) => convertType(rt).flatMap {
                  case Success(declaredRT, _) =>
                    typeCheck(body)(ctx.child(Map(), ((id -> declaredRT) :: paramTypes.flatten).toMap), variance).flatMap {
                      case Success(actualRetType, node) =>
                        doesUnify(actualRetType, declaredRT)
                          .mapError(stat)
                          //TODO: Include the successes and actual type information
                          .map(us =>
                            Success(buildFunctionType(actualRetType, paramTypes.map(_.map(_._2))), stat)
                          )
                    }

                }
                case None =>
                  typeCheck(body)(ctx.addVars(paramTypes.flatten), variance)
                //TODO: Update the type in the context

              }
            //TODO Add info
            case (x :: _) :: _ => x
          }

        }
        case VarDef(id, typ, rhs) => ???
        case ValDef(id, declType, rhs) => ???
      }
    }
  }


  def convertType(astType: ScalyASTType)(implicit ctx: TypeContext): TCR = addToError(astType, ctx) {
    astType match {
      case ASTScalyTypeName(name) =>
        ctx.getWellFormedType(name)
          .toRight(TypeError(s"Cannot find type name $name", astType))
          .map(Success(_, astType))
      case ASTScalyTypeSelect(lhs, rhs) => ???
      case ASTScalyTupleType(types) =>
        types
          .map(convertType)
          .collapse
          .map(successes => Successes(ScalyTupleType(successes.toTypes), astType, successes))
      case ASTScalyFunctionType(arguments, returnType) =>
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

  private def typeCheck_Expr(expr: Expr)(implicit ctx: TypeContext, variance: Variance): TCR = addToError(expr, ctx) {
    expr match {

      case l: Literal => Right(Success(ScalyValType.literalType(l), expr))
      case SelectExpr(lhs, rhs) => ???
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
              .map(doesUnify(_, formalTypes).mapError(expr))
              .collapse
              //TODO: Apply unification results
              //TODO: Include the success of the RHS
              .map(rhs_success => Successes(rType, expr, lhs_success :: Nil))
          //TODO: Apply syntax
          case _ => Left(TypeError("Application of non-functional type", expr))
        }
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

  private def doesUnify(t1: ScalyType, t2: ScalyType)(implicit ctx: TypeContext, variance: Variance): UR =
    (t1, t2) match {
      case (x: ScalyASTPlaceholderType, _) =>
        convertType(x.node)
          .mapError(t1, t2)
          .flatMap { t => doesUnify(t.typ, t2) }
      case (_, x: ScalyASTPlaceholderType) =>
        convertType(x.node)
          .mapError(t1, t2)
          .map { t => doesUnify(t.typ, t1) }.collapse
      case (static1: StaticScalyType, static2: StaticScalyType) =>
        doesUnify_static(static1, static2)

    }

  def doesUnify_static(t1: StaticScalyType, t2: StaticScalyType)(implicit ctx: TypeContext, variance: Variance): UR =
    (t1, t2) match {
      case (ScalyFunctionType(from1, to1), ScalyFunctionType(from2, to2)) =>
        (from1, from2) match {
          case (None, None) => doesUnify(to1, to2)
          case (Some(f1), Some(f2)) =>
            doesUnify(f1, f2)
              .flatMap(ur =>
                doesUnify(to1, to2)
                  .map(ur2 => UnificationCombination(t1, t2, ur, ur2))
              )
          case _ => ???
        }

      case (ScalyFunctionType(None, rt), _) => doesUnify(rt, t2)
      case (_, ScalyFunctionType(None, _)) => doesUnify_static(t2, t1)

      case (ScalyValType(n1), ScalyValType(n2)) if (n1 equals n2) => Right(UnificationSuccess(t1, t2))

      case (ScalyTupleType(x :: Nil), y) => doesUnify(x, y)
      case (y, ScalyTupleType(x :: Nil)) => doesUnify(x, y)

      case (ScalyValType.ScalyUnitType, ScalyTupleType(Nil)) => Right(UnificationSuccess(t1, t2))
      case (ScalyTupleType(Nil), ScalyValType.ScalyUnitType) => Right(UnificationSuccess(t1, t2))
      //TODO: Unit and Nothing types - needs a notion of _co/contra_ variance
      case _ => Left(UnificationFailure(t1, t2, s"Cannot unify static types [$t1] and [$t2]"))
    }


}
