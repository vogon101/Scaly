package com.freddieposer.scaly.AST

import scala.meta._

object ASTBuilder {

  def fromScalaMeta(source: Source): CompilationUnit =
    CompilationUnit(source.stats.map(buildTopLevel))

  private def buildTopLevel(stat: Stat): TopLevelStatement =
    stat match {
      case Defn.Class(mods, name, tparams, ctor, templ) =>
        val classParams = ctor.paramss match {
          case Nil => Nil
          case ps :: Nil => ps.map(buildClassParam)
          case _ => ???
        }

        ScalyClassDef(
          name.value,
          templ.inits.map { init: Init =>
            (AST_ScalyTypeName(init.tpe.toString), init.argss.headOption.map(_.map(buildExpr)).getOrElse(Nil))
          },
          if (templ.stats.isEmpty) None else Some(ScalyTemplate(templ.stats.map(buildStatement))),
          classParams
        )
      case Defn.Object(mods, name, templ) =>
        ScalyObjectDef(
          name.value,
          templ.inits.map { init: Init =>
            (AST_ScalyTypeName(init.tpe.toString), init.argss.headOption.map(_.map(buildExpr)).getOrElse(Nil))
          },
          if (templ.stats.isEmpty) None else Some(ScalyTemplate(templ.stats.map(buildStatement))),
        )

    }

  private def buildClassParam(param: Term.Param): ClassParam = {

    //TODO: Assuming that val/var is always last mod if it exists
    //TODO: Default values

    val mods = param.mods.map(_.toString)
    val declType = buildScalyType(param.decltpe.get)

    param.mods match {
      case Nil =>
        NonMemberClassParam(mods, param.name.value, declType, None)
      case Mod.ValParam() :: Nil =>
        ValClassParam(mods, param.name.value, declType, None)
      case Mod.VarParam() :: Nil =>
        VarClassParam(mods, param.name.value, declType, None)
      case _ => ???
    }


  }

  private def buildStatement(stat: Stat): Statement =
    stat match {
      case Defn.Val(mods, pats, decl, rhs) => ValDef(
        pats.map { case Pat.Var(name) => name.value }.head, //TODO: Other possible patterns
        decl.map(buildScalyType),
        buildExpr(rhs)
      )
      case Defn.Var(mods, pats, decl, rhs) => VarDef(
        pats.map { case Pat.Var(name) => name.value }.head, //TODO: Other possible patterns
        decl.map(buildScalyType),
        buildExpr(rhs.get) //TODO: This is an option - why?
      )
      case Defn.Def(mods, name, tparams, paramss, declType, body) => DefDef(
        name.value,
        paramss.map(_.map(buildParam)),
        declType.map(buildScalyType),
        buildExpr(body)
      )
      case term: Term => buildExpr(term)

    }

  private def buildParam(param: Term.Param): FunParam =
  //TODO: this is an option - why?
    FunParam(param.name.value, param.decltpe.map(buildScalyType).get)

  private def buildScalyType(typ: Type): AST_ScalyType =
    typ match {
      case Type.Name(name) => AST_ScalyTypeName(name)
      case Type.Tuple(types) => AST_TupleScalyType(types.map(buildScalyType))
      case Type.Select(lhs, rhs) => AST_ScalyTypeSelect(buildExpr(lhs), rhs.value)
      case Type.Function(params, res) =>
        AST_FunctionScalyType(params.map(buildScalyType), buildScalyType(res))
      case Lit.Unit() => AST_ScalyTypeName("Unit")
    }

  private def buildExpr(term: Term): Expr =
    term match {
      case l: Lit => buildLiteral(l)
      case Term.Apply(fun, args) => Application(buildExpr(fun), args.map(buildExpr))
      case Term.ApplyInfix(lhs, op, targs, args) =>
        Application(SelectExpr(buildExpr(lhs), op.value), args.map(buildExpr))
      case Term.ApplyUnary(Name(op), arg) =>
        Application(SelectExpr(buildExpr(arg), f"unary_$op"), List(buildExpr(arg)))
      case Term.Tuple(args) => TupleExpr(args.map(buildExpr))
      case Term.Block(stats) => Block(stats.map(buildStatement))
      case Term.Select(lhs, name) => SelectExpr(buildExpr(lhs), name.value)
      case Term.Name(value) => IDExpr(value)
      case Term.This(qual) => IDExpr("this")
      case Term.If(cond, tBranch, fBranch) => IfExpr(buildExpr(cond), buildExpr(tBranch), buildExpr(fBranch))
      case Term.New(Init(tpe, name, Nil)) => NewExpr(buildScalyType(tpe), Nil)
      case Term.New(Init(tpe, name, args :: Nil)) => NewExpr(buildScalyType(tpe), args.map(buildExpr))
      case Term.Assign(lhs, rhs) => AssignExpr(buildExpr(lhs), buildExpr(rhs))
      case Term.While(cond, body) => WhileExpr(buildExpr(cond), buildExpr(body))
      case Term.Function(params, body) => FunctionExpr(params.map(buildParam), buildExpr(body))
    }

  private def buildLiteral(lit: Lit): Literal =
    lit match {
      case Lit.String(value) => StringLiteral(value)
      case Lit.Boolean(value) => BooleanLiteral(value)
      case Lit.Double(value) => DoubleLiteral(value.toDouble)
      case Lit.Float(value) => FloatLiteral(value.toFloat)
      case Lit.Char(value) => CharLiteral(value)
      case Lit.Symbol(value) => SymbolLiteral(value)
      case Lit.Int(value) => IntLiteral(value)
      case Lit.Null() => NullLiteral
      case Lit.Unit() => UnitLiteral
    }

}
