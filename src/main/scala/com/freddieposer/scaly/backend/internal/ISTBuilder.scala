package com.freddieposer.scaly.backend.internal

import com.freddieposer.scaly.AST.{Application, Block, CompilationUnit, Dcl, DefDef, Expr, FunParam, IDExpr, IfExpr, Literal, MemberDcl, ScalyAST, ScalyClassDef, ScalyObjectDef, SelectExpr, Statement, TupleExpr, ValDef, VarDef}

object ISTBuilder {

  def buildIST(ast: CompilationUnit): IST_CompilationUnit = {

    new IST_CompilationUnit(ast.statements.map {
      case ScalyClassDef(id, parents, body, params) =>
        //TODO: parents
        val statements = body.map(_.stats.groupBy {
          case _: Expr   => "EXPR"
          case _: VarDef => "VAR"
          case _: ValDef => "VAL"
          case _: DefDef => "DEF"
        }).getOrElse(Map())

        val vals = statements.get("VAL").map {case ds: List[ValDef] => ds.map {
          case ValDef(id, _, rhs) => id -> ???
        }.toMap}.getOrElse(Map())


        val vars = statements.get("VAR").map {case ds: List[VarDef] => ds.map {
          case VarDef(id, _, rhs) => id -> ???
        }.toMap}.getOrElse(Map())


        val defs: Map[String, IST_Function] = statements.get("DEF").map {case ds: List[DefDef] => ds.map {
          case DefDef(id, params, _, body) => id -> buildFunction(params, body)
        }.toMap}.getOrElse(Map())

        IST_Class(id, vals, vars, defs)
      case ScalyObjectDef(id, parents, body) => ???
    })

  }

  def buildFunction(params: List[List[FunParam]], expr: Expr): IST_Function = params match {
    case Nil => ???
    case x :: Nil => IST_Function(x.map(_.name), buildExpr(expr))
    case x :: xs =>IST_Function(x.map(_.name), buildFunction(xs, expr))
  }

  def buildStatement(statement: Statement): IST_Statement = statement match {
    case expr: Expr => buildExpr(expr)
    case dcl: Dcl => ???
  }

  def buildExpr(expr: Expr): IST_Expression = expr match {
    case literal: Literal => buildLiteral(literal)
    case IDExpr(name) => ???
    case TupleExpr(elems) => ???
    case Block(statements) =>
      IST_Block(statements.map(buildStatement))
    case SelectExpr(lhs, rhs) => ???
    case Application(lhs, args) => ???
    case IfExpr(cond, tBranch, fBranch) =>
      IST_If(buildExpr(cond), buildExpr(tBranch), Some(buildExpr(fBranch)))
  }

  def buildLiteral(literal: Literal): IST_Literal = ???


}
