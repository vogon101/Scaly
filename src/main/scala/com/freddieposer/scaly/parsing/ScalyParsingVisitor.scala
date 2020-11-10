package com.freddieposer.scaly.parsing

import com.freddieposer.scaly.parsing.antlr.{ScalyBaseVisitor, ScalyParser, ScalyVisitor}
import com.freddieposer.scaly.parsing.parsetree._

import scala.jdk.CollectionConverters.ListHasAsScala
import java.util

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor

class ScalyParsingVisitor
  extends AbstractParseTreeVisitor[ParseTree]
  with ScalyVisitor[ParseTree]
  with ScalyExprParsingVisitor
  with ScalyLiteralParsingVisitor
{

  import ScalyParser._
  //super\.[a-zA-Z_1-9]+\(ctx\)

  override val exprVisitor: ScalyVisitor[Expr] = this.asInstanceOf[ScalyVisitor[Expr]]
  override val literalVisitor: ScalyVisitor[Literal] = this.asInstanceOf[ScalyVisitor[Literal]]

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

  override def visitFunDef(ctx: FunDefContext): FunDef = {
    ???
  }

  override def visitPatVarDef(ctx: PatVarDefContext): PatVarDef = {
    ???
  }

  override def visitTopStatSeq(ctx: TopStatSeqContext): ParseTree = ???

  override def visitIds(ctx: IdsContext): ParseTree = ???

  override def visitStableId(ctx: StableIdContext): ParseTree = ???

  override def visitType_(ctx: Type_Context): ParseTree = ???

  override def visitFunctionArgTypes(ctx: FunctionArgTypesContext): ParseTree = ???

  override def visitInfixType(ctx: InfixTypeContext): ParseTree = ???

  override def visitCompoundType(ctx: CompoundTypeContext): ParseTree = ???

  override def visitSimpleType(ctx: SimpleTypeContext): ParseTree = ???

  override def visitTypes(ctx: TypesContext): ParseTree = ???

  override def visitRefinement(ctx: RefinementContext): ParseTree = ???

  override def visitRefineStat(ctx: RefineStatContext): ParseTree = ???

  override def visitTypePat(ctx: TypePatContext): ParseTree = ???

  override def visitAscription(ctx: AscriptionContext): ParseTree = ???

  override def visitPrefixDef(ctx: PrefixDefContext): ParseTree = ???

  override def visitBlock(ctx: BlockContext): ParseTree = ???

  override def visitBlockStat(ctx: BlockStatContext): ParseTree = ???

  override def visitPattern(ctx: PatternContext): ParseTree = ???

  override def visitPattern1(ctx: Pattern1Context): ParseTree = ???

  override def visitPattern2(ctx: Pattern2Context): ParseTree = ???

  override def visitPattern3(ctx: Pattern3Context): ParseTree = ???

  override def visitSimplePattern(ctx: SimplePatternContext): ParseTree = ???

  override def visitPatterns(ctx: PatternsContext): ParseTree = ???

  override def visitParamClauses(ctx: ParamClausesContext): ParseTree = ???

  override def visitParamClause(ctx: ParamClauseContext): ParseTree = ???

  override def visitParams(ctx: ParamsContext): ParseTree = ???

  override def visitParam(ctx: ParamContext): ParseTree = ???

  override def visitParamType(ctx: ParamTypeContext): ParseTree = ???

  override def visitClassParamClauses(ctx: ClassParamClausesContext): ParseTree = ???

  override def visitClassParamClause(ctx: ClassParamClauseContext): ParseTree = ???

  override def visitClassParams(ctx: ClassParamsContext): ParseTree = ???

  override def visitClassParam(ctx: ClassParamContext): ParseTree = ???

  override def visitBindings(ctx: BindingsContext): ParseTree = ???

  override def visitBinding(ctx: BindingContext): ParseTree = ???

  override def visitModifier(ctx: ModifierContext): ParseTree = ???

  override def visitLocalModifier(ctx: LocalModifierContext): ParseTree = ???

  override def visitAccessModifier(ctx: AccessModifierContext): ParseTree = ???

  override def visitAccessQualifier(ctx: AccessQualifierContext): ParseTree = ???

  override def visitValDcl(ctx: ValDclContext): ParseTree = ???

  override def visitVarDcl(ctx: VarDclContext): ParseTree = ???

  override def visitFunDcl(ctx: FunDclContext): ParseTree = ???

  override def visitFunSig(ctx: FunSigContext): ParseTree = ???

  override def visitPatDef(ctx: PatDefContext): ParseTree = ???

  override def visitVarDef(ctx: VarDefContext): ParseTree = ???

  override def visitClassTemplateOpt(ctx: ClassTemplateOptContext): ParseTree = ???

  override def visitClassTemplate(ctx: ClassTemplateContext): ParseTree = ???

  override def visitClassParents(ctx: ClassParentsContext): ParseTree = ???

  override def visitConstr(ctx: ConstrContext): ParseTree = ???

  override def visitConstrBlock(ctx: ConstrBlockContext): ParseTree = ???

  override def visitSelfInvocation(ctx: SelfInvocationContext): ParseTree = ???
}
