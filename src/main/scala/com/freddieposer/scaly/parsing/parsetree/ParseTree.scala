package com.freddieposer.scaly.parsing.parsetree

sealed trait ParseTree {

}

class CompilationUnit(val topStatements: List[TopStatement]) extends ParseTree

abstract class Def extends ParseTree

abstract class Dcl extends ParseTree

abstract class Expr extends ParseTree

abstract class Literal extends Expr

sealed trait TopStatement extends Def

class ScalyClassDef(
                     val id: String,
                     val parents: Option[String],
                     val body: Option[TemplateBody]
                   ) extends TopStatement

class ScalyObjectDef(

                    ) extends Def with TopStatement

class TemplateBody(val statements: List[TemplateStatement]) extends ParseTree

sealed trait TemplateStatement extends ParseTree

final case class TemplateDef(mDef: Def, modifiers: List[String]) extends TemplateStatement

final case class TemplateDcl(mDcl: Dcl, modifiers: List[String]) extends TemplateStatement

final case class TemplateExpr(mExpr: Expr) extends TemplateStatement

class FunDef extends Def

class PatVarDef extends Def

