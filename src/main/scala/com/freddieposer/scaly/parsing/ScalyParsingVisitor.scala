package com.freddieposer.scaly.parsing

import com.freddieposer.scaly.parsing.antlr.{ScalyBaseVisitor, ScalyParser}
import com.freddieposer.scaly.parsing.parsetree._

import scala.jdk.CollectionConverters.ListHasAsScala
import java.util

import org.antlr.v4.runtime.ParserRuleContext

class ScalyParsingVisitor extends ScalyBaseVisitor[ParseTree] {

  import ScalyParser._

  private implicit def ListToList[T](xs: util.List[T]): List[T] = xs.asScala.toList

  //WARNING: Yes, this does violate type safety for the sake of nicer code
  //TODO: Could use the Option(null) constructor to make this all nicer
  private def visitOpt[T](ctx: ParserRuleContext): Option[T] =
    if (ctx == null) None
    else Some(visit(ctx).asInstanceOf[T])

  override def visitCompilationUnit(ctx: CompilationUnitContext): CompilationUnit =
    new CompilationUnit(ctx.topStatSeq().topStat().map(visitTopStat))

  override def visitTopStat(ctx: TopStatContext): TopStatement = visitTmplDef(ctx.tmplDef())

  override def visitTmplDef(ctx: TmplDefContext): TopStatement = {
    if (ctx.classDef() != null) visitClassDef(ctx.classDef())
    else if (ctx.objectDef() != null) visitObjectDef(ctx.objectDef())
    else throw new Error
  }

  override def visitObjectDef(ctx: ObjectDefContext): ScalyObjectDef = ???

  override def visitClassDef(ctx: ClassDefContext): ScalyClassDef = {

    val id = ctx.Id().getText
    val classTemplate = ctx.classTemplateOpt()

    if (classTemplate.classTemplate() != null)
      new ScalyClassDef(
        id,
        Some(classTemplate.classTemplate().classParents().getText),
        visitOpt(classTemplate.classTemplate().templateBody())
      )
    else if (classTemplate.templateBody() != null) {
      new ScalyClassDef(
        id, None, visitOpt(classTemplate.templateBody())
      )
    }
    else new ScalyClassDef(id, None, None)

  }

  override def visitTemplateBody(ctx: TemplateBodyContext): TemplateBody =
    new TemplateBody(ctx.templateStat.map(visitTemplateStat))

  override def visitTemplateStat(ctx: TemplateStatContext): TemplateStatement = {
    //TODO: currently losing info
    val modifiers = ctx.modifier.map(_.getText)

    if (ctx.`def`() != null) {
      TemplateDef(visitDef(ctx.`def`()), modifiers)
    } else if (ctx.dcl() != null) {
      TemplateDcl(visitDcl(ctx.dcl()), modifiers)
    } else {
      TemplateExpr(visitExpr(ctx.expr()))
    }

  }

  override def visitDef(ctx: DefContext): Def = {
    if (ctx.patVarDef() != null) {
      visitPatVarDef(ctx.patVarDef())
    } else if (ctx.funDef() != null) {
      visitFunDef(ctx.funDef())
    } else { //if (ctx.tmplDef() != null)
      visitTmplDef(ctx.tmplDef())
    }
  }

  override def visitDcl(ctx: DclContext): Dcl = {
    ???
  }

  override def visitExpr(ctx: ExprContext): Expr = {
    ???
  }

  override def visitFunDef(ctx: FunDefContext): FunDef = {
    ???
  }

  override def visitPatVarDef(ctx: PatVarDefContext): PatVarDef = {
    ???
  }

}
