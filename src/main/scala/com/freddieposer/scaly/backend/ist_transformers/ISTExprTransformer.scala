package com.freddieposer.scaly.backend.ist_transformers

import com.freddieposer.scaly.backend.internal._

trait ISTExprTransformer {

  def transform(ist: IST_CompilationUnit): IST_CompilationUnit = {
    new IST_CompilationUnit(ist.classes.map {
      case IST_Class(name, params, parent, parentParams, defs, statements, typ) =>
        IST_Class(
          name, params, parent,
          parentParams.map(transformExpr),
          defs.map { case (k, v) => k -> transformStatement(v).asInstanceOf[IST_Def] },
          statements.map(transformStatement),
          typ
        )
      case IST_Object(name, parent, parentParams, defs, statements, typ) =>
        IST_Object(
          name, parent,
          parentParams.map(transformExpr),
          defs.map { case (k, v) => k -> transformStatement(v).asInstanceOf[IST_Def] },
          statements.map(transformStatement),
          typ
        )
    })
  }

  def transformExpr(ist: IST_Expression): IST_Expression

  final def transformStatement(stat: IST_Statement): IST_Statement = stat match {
    case member: IST_Member => member match {
      case IST_Def(id, params, expr, typ, closedVars, freeVars) =>
        IST_Def(id, params, transformExpr(expr), typ, closedVars, freeVars)
      case IST_Val(id, expr, location) =>
        IST_Val(id, transformExpr(expr), location)
      case IST_Var(id, expr, location) =>
        IST_Var(id, transformExpr(expr), location)
    }
    case expr: IST_Expression => transformExpr(expr)
  }

  def descend(expr: IST_Expression): IST_Expression = expr match {
    case RawISTExpr(_) => expr
    case IST_Name(_, _) => expr
    case IST_Literal(_, _) => expr

    case IST_Function(args, body, typ, closedVars, freeVars) =>
      IST_Function(args, transformExpr(body), typ, closedVars, freeVars)
    case IST_If(cond, tBranch, fBranch, typ) =>
      IST_If(transformExpr(cond), transformExpr(tBranch), fBranch.map(transformExpr), typ)

    case IST_Block(stats, typ) =>
      IST_Block(stats.map(transformStatement), typ)
    case IST_Sequence(stats, typ) =>
      IST_Sequence(stats.map(transformStatement), typ)


    case IST_Application(lhs, args, typ) =>
      IST_Application(transformExpr(lhs), args.map(transformExpr), typ)
    case IST_New(name, args, typ) =>
      IST_New(name, args.map(transformExpr), typ)
    case IST_Select(lhs, rhs, typ) =>
      IST_Select(transformExpr(lhs), rhs, typ)

    case IST_Assignment(name, location, rhs) =>
      IST_Assignment(name, location, transformExpr(rhs))
    case IST_TupleExpr(elems, typ) =>
      IST_TupleExpr(elems.map(transformExpr), typ)
    case IST_While(cond, body) =>
      IST_While(transformExpr(cond), transformExpr(body))
    case IST_IsNone(lhs) =>
      IST_IsNone(transformExpr(lhs))
    case IST_Match(lhs, cases, typ) =>
      IST_Match(transformExpr(lhs), cases, typ)
    case IST_Subscript(lhs, rhs, typ) =>
      IST_Subscript(transformExpr(lhs), rhs, typ)
  }

}
