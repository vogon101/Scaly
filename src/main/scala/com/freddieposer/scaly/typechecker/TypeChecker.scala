package com.freddieposer.scaly.typechecker

import com.freddieposer.scaly.AST._
import com.freddieposer.scaly.typechecker.Variance.Variance
import com.freddieposer.scaly.typechecker.context.{BaseTypeContext, ThisTypeContext, TypeContext}
import com.freddieposer.scaly.typechecker.types._
import com.freddieposer.scaly.typechecker.Utils._

class TypeChecker(
                   val ast: CompilationUnit
                 ) {

  abstract class UnificationResult()(implicit ctx: TypeContext)

  case class UnificationSuccess(t1: ScalyType, t2: ScalyType)(implicit _ctx: TypeContext) extends UnificationResult

  case class UnificationComnination(ur1: UnificationResult, ur2: UnificationResult)(implicit _ctx: TypeContext) extends UnificationResult

  lazy val globalContext: TypeContext = {
    var _gc: TypeContext = BaseTypeContext
    ast.statements.foreach {
      case c@ScalyClassDef(id, parents, _, _) =>
        _gc = _gc addType (id -> ScalyASTClassType(id, parents.headOption.map(ScalyPlaceholderTypeName), c))
      case ScalyObjectDef(id, parents, body) => ???
    }
    _gc
  }

  def typeCheck(): Option[TypeError] = {

    ast.statements.map {
      case node@ScalyClassDef(id, parents, body, params) =>
        //TODO: Inheritance
        val ctx = new ThisTypeContext(ScalyASTClassType(id, None, node), Some(globalContext))
        body.flatMap(stat =>
          stat.stats
            .map(typeCheck(_)(ctx, Variance.IN))
            .collapse match {
            case Left(e) => Some(e)
            case Right(t) => None
          }
        )
      case ScalyObjectDef(id, parents, body) => ???
    }.foldLeft(None: Option[TypeError]) {
      case (e@Some(_), _) => e
      case (_, e@Some(_)) => e
      case _ => None
    }

  }

  def updateContext(id: String)
                   (f: () => Either[TypeError, (ScalyType, TypeContext)])
                   (implicit context: TypeContext): Either[TypeError, (ScalyType, TypeContext)] = {
    f().map { case (t, c) => (t, c.addVar(id -> t)) }
  }

  def typeCheck(stat: Statement)(implicit ctx: TypeContext, variance: Variance): Either[TypeError, (ScalyType, TypeContext)] = stat match {
    case e: Expr => typeCheck_Expr(e).map((_, ctx))
    case d: Dcl => d match {
      case DefDef(id, params, retType, body) => updateContext(id) { () =>
        val paramTypes = params.flatten.map(p => p.name -> convertType(p.pType)).map {
          case (_, Left(e)) => Left(e)
          case (name, Right(t)) => Right((name, t))
        }.collapse
        paramTypes match {
          case Left(e) => Left(e)
          case Right(pts) =>
            retType match {
              case Some(rt) => convertType(rt) match {
                case Left(e) => Left(e)
                case Right(t) =>
                  typeCheck(body)(ctx.child(Map(), ((id -> t) :: pts).toMap), variance) match {
                    case Left(e) => Left(e)
                    case Right((actualRetType, _)) =>
                      doesUnify(actualRetType, t).map(x => (ScalyValType.ScalyNothingType, ctx))
                  }

              }
              case None =>
                typeCheck(body)(ctx.addVars(pts), variance)
                //TODO: Update the type in the context
                Right((ScalyValType.ScalyNothingType, ctx))
            }
        }
      }
      case VarDef(id, typ, rhs) => ???
      case ValDef(id, declType, rhs) => ???
    }
  }

  def convertType(astType: ScalyASTType)(implicit ctx: TypeContext): Either[TypeError, ScalyType] = astType match {
    case ASTScalyTypeName(name) =>
      ctx.getWellFormedType(name).toRight(TypeError(s"Cannot find type name $name", astType))
    case ASTScalyTypeSelect(lhs, rhs) => ???
    case ASTScalyTupleType(types) =>
      types.map(convertType).collapse.map(ScalyTupleType)
    case ASTScalyFunctionType(arguments, returnType) =>
      (arguments.map(convertType).collapse, convertType(returnType)) match {
        case (Left(e), _) => Left(e)
        case (_, Left(e)) => Left(e)
        case (Right(Nil), Right(ret)) => Right(ScalyFunctionType(ScalyValType.ScalyUnitType, ret))
        case (Right(arg :: Nil), Right(ret)) => Right(ScalyFunctionType(arg, ret))
        case (Right(args), Right(ret)) => Right(ScalyFunctionType(ScalyTupleType(args), ret))
      }
  }

  private def typeCheck_Expr(expr: Expr)(implicit ctx: TypeContext, variance: Variance): Either[TypeError, ScalyType] = expr match {

    case l: Literal => Right(ScalyValType.literalType(l))
    case SelectExpr(lhs, rhs) => ???
    case IDExpr(name) =>
      ctx.getVarType(name)
        .toRight(TypeError(s"Cannot find type $name", expr))

    case TupleExpr(elems) =>
      elems
        .map(typeCheck_Expr)
        .collapse
        .map(ts => ScalyTupleType(ts))
    case Application(lhs, actuals) =>
      typeCheck_Expr(lhs).flatMap {
        case ScalyFunctionType(formalTypes, rType) =>
          actuals
            .map(typeCheck_Expr).collapse
            .map(ScalyTupleType)
            .map(doesUnify(_, formalTypes)).collapse
            //TODO: Apply unification results
            .map(_ => rType)
        //TODO: Apply syntax
        case _ => Left(TypeError("Application of non-functional type", expr))
      }
    case Block(statements) =>
      statements
        .foldLeft(Right((ScalyValType.ScalyUnitType, ctx)): Either[TypeError, (ScalyType, TypeContext)]) {
          case (Right((_, _c)), statement) =>
            typeCheck(statement)(_c, variance)
          case (Left(e), _) => Left(e)
        }.map(_._1)
  }

  private def doesUnify(t1: ScalyType, t2: ScalyType)(implicit ctx: TypeContext, variance: Variance): Either[TypeError, UnificationResult] =
    (t1, t2) match {
      case (x: ScalyASTPlaceholderType, _) =>
        convertType(x.node).map { t => doesUnify(t, t2) }.collapse
      case (_, x: ScalyASTPlaceholderType) =>
        convertType(x.node).map { t => doesUnify(t, t1) }.collapse
      case (static1: StaticScalyType, static2: StaticScalyType) =>
        doesUnify_static(static1, static2)

    }


  def doesUnify_static(t1: StaticScalyType, t2: StaticScalyType)(implicit ctx: TypeContext, variance: Variance): Either[TypeError, UnificationResult] =
    (t1, t2) match {
      case (ScalyFunctionType(from1, to1), ScalyFunctionType(from2, to2)) =>
        doesUnify(from1, from2)
          .map(ur =>
            doesUnify(to1, to2)
              .map(ur2 => UnificationComnination(ur, ur2))
          ).collapse

      case (ScalyFunctionType(ScalyTupleType(Nil), rt), _) => doesUnify(rt, t2)
      case (_, ScalyFunctionType(ScalyTupleType(Nil), _)) => doesUnify_static(t2, t1)

      case (ScalyValType(n1), ScalyValType(n2)) if (n1 equals n2) => Right(UnificationSuccess(t1, t2))

      case (ScalyTupleType(x :: Nil), y)  => doesUnify(x, y)
      case (y, ScalyTupleType(x :: Nil))  => doesUnify(x, y)

      case (ScalyValType.ScalyUnitType, ScalyTupleType(Nil)) => Right(UnificationSuccess(t1, t2))
      case (ScalyTupleType(Nil), ScalyValType.ScalyUnitType) => Right(UnificationSuccess(t1, t2))
        //TODO: Unit and Nothing types - needs a notion of _co/contra_ variance
      case _ => Left(TypeError(s"Cannot unify static types $t1, $t2", null))
    }




}
