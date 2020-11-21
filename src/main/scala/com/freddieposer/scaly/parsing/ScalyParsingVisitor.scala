package com.freddieposer.scaly.parsing

import com.freddieposer.scaly.parsing.antlr.{ScalyParser, ScalyVisitor}
import com.freddieposer.scaly.parsing.parsetree._
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor

class ScalyParsingVisitor
  extends AbstractParseTreeVisitor[ParseTree]
    with ScalyVisitor[ParseTree]
    with ScalyExprParsingVisitor
    with ScalyLiteralParsingVisitor {

  import ScalyParser._
  import PTWrappers._
  //super\.[a-zA-Z_1-9]+\(ctx\)

  private val parsingUtils = new ParsingUtils[ParseTree](visit)

  import parsingUtils._

  override protected[this] val exprVisitor: ScalyVisitor[Expr] = this.asInstanceOf[ScalyVisitor[Expr]]
  override protected[this] val literalVisitor: ScalyVisitor[Literal] = this.asInstanceOf[ScalyVisitor[Literal]]

  override def visitCompilationUnit(ctx: CompilationUnitContext): CompilationUnit =
    new CompilationUnit(ctx.topStatSeq().topStat().map(visitTopStat))

  override def visitTopStat(ctx: TopStatContext): TopStatement = visitTmplDef(ctx.tmplDef())

  override def visitTmplDef(ctx: TmplDefContext): TopStatement = {
    if (ctx.classDef() != null) visitClassDef(ctx.classDef())
    else if (ctx.objectDef() != null) visitObjectDef(ctx.objectDef())
    else throw new Error
  }

  override def visitObjectDef(ctx: ObjectDefContext): ScalyObjectDef = {
    val id = ctx.Id().getText
    val classTemplate = Option(ctx.classTemplateOpt().classTemplate())

    classTemplate match {
      case Some(template) => new ScalyObjectDef(
        id, Some(template.classParents().getText), Option(template.templateBody()).map(visitTemplateBody)
      )
      case None => new ScalyObjectDef(
        id, None, Option(ctx.classTemplateOpt().templateBody()).map(visitTemplateBody)
      )
    }


  }

  override def visitClassDef(ctx: ClassDefContext): ScalyClassDef = {

    val id = ctx.Id().getText
    val classTemplate = Option(ctx.classTemplateOpt().classTemplate())
    val classParams = ctx.classParamClauses().classParamClause().map(visitClassParamClause)

    classTemplate match {
      case Some(template) => new ScalyClassDef(
        id,
        Some(template.classParents().getText),
        Option(template.templateBody()).map(visitTemplateBody),
        classParams
      )
      case None => new ScalyClassDef(
        id, None, Option(ctx.classTemplateOpt().templateBody()).map(visitTemplateBody), classParams
      )
    }

  }

  override def visitTemplateBody(ctx: TemplateBodyContext): TemplateBody =
    new TemplateBody(ctx.templateStat.map(visitTemplateStat))

  override def visitTemplateStat(ctx: TemplateStatContext): TemplateStatement = {
    //TODO: currently losing info
    val modifiers = ctx.modifier.map(_.getText)

    if (ctx.`def`() != null) {
      TemplateDef(visitDef(ctx.`def`()), modifiers)
    } else if (ctx.dcl() != null) {
      TemplateDcl(visitAs[Dcl](ctx.dcl()), modifiers)
    } else {
      TemplateExpr(visitExpr(ctx.expr()))
    }

  }

  override def visitDef(ctx: DefContext): Def =
    visitOne[Def](
      ctx.patVarDef(), ctx.funDef(), ctx.tmplDef()
    )

  override def visitDclValDcl(ctx: DclValDclContext): Dcl =
    visitValDcl(ctx.valDcl())

  override def visitDclVarDcl(ctx: DclVarDclContext): ParseTree =
    visitVarDcl(ctx.varDcl())

  override def visitDclDefDcl(ctx: DclDefDclContext): ParseTree =
    visitFunDcl(ctx.funDcl())

  override def visitFunDef(ctx: FunDefContext): FunDef =
    FunDef(
      //TODO: This is duplicate code AND wil not work for extra constructors!
      FunDcl(
        ctx.funSig().Id().getText,
        visitParamClauses(ctx.funSig().paramClauses()),
        Option(ctx.type_()).map(visitType_)
      ), visitExpr(ctx.expr())
    )


  override def visitPatVarDefVal(ctx: PatVarDefValContext): ParseTree = ???

  override def visitPatVarDefVar(ctx: PatVarDefVarContext): ParseTree = ???

  override def visitTopStatSeq(ctx: TopStatSeqContext): PTSeq[TopStatement] = {
    new PTSeq(ctx.topStat().map(visitTopStat))
  }


  override def visitType_(ctx: Type_Context): ScalyType =
    if (ctx.functionArgTypes() != null)
      ScalyFunctionType(
        visitFunctionArgTypes(ctx.functionArgTypes()),
        visitType_(ctx.type_())
      )
    else visitInfixType(ctx.infixType())

  override def visitFunctionArgTypes(ctx: FunctionArgTypesContext): PTSeq[ScalyType] =
    if (ctx.infixType() != null) List(visitInfixType(ctx.infixType()))
    else ctx.paramType().map(visitParamType)

  override def visitInfixType(ctx: InfixTypeContext): ScalyType =
    visitCompoundType(ctx.compoundType())

  override def visitCompoundType(ctx: CompoundTypeContext): ScalyType =
    visitAnnotType(ctx.annotType())

  override def visitSimpleType(ctx: SimpleTypeContext): ScalyType =
    if(ctx.stableId() != null) ScalyTypeName(visitStableId(ctx.stableId()))
    else ScalyTupleType(visitTypes(ctx.types()))

  override def visitTypes(ctx: TypesContext): PTSeq[ScalyType] =
    ctx.type_().map(visitType_)

  override def visitTypePat(ctx: TypePatContext): ParseTree = ???

  override def visitAscription(ctx: AscriptionContext): ParseTree = ???

  override def visitPrefixDef(ctx: PrefixDefContext): ParseTree = ???

  override def visitBlockStatDef(ctx: BlockStatDefContext): ParseTree =
    visitDef(ctx.`def`())

  override def visitBlockStatTmplDef(ctx: BlockStatTmplDefContext): ParseTree = {
    //TODO: Modifiers!!!
    visitTmplDef(ctx.tmplDef())
  }

  override def visitBlockStatExpr(ctx: BlockStatExprContext): Expr =
    visitAs[Expr](ctx.expr1())

  override def visitPattern(ctx: PatternContext): ParseTree = ???

  override def visitPattern1(ctx: Pattern1Context): ParseTree = ???

  override def visitPattern2(ctx: Pattern2Context): ParseTree = ???

  override def visitPattern3(ctx: Pattern3Context): ParseTree = ???

  override def visitSimplePattern(ctx: SimplePatternContext): ParseTree = ???

  override def visitPatterns(ctx: PatternsContext): ParseTree = ???

  override def visitParamClauses(ctx: ParamClausesContext): PTSeq[ParamClause] =
    ctx.paramClause().map(visitParamClause)

  override def visitParamClause(ctx: ParamClauseContext): ParamClause =
    new ParamClause(ctx.params().param().map(visitParam))

  override def visitParam(ctx: ParamContext): Param =
    new Param(
      ctx.Id().getText,
      Option(ctx.paramType()).map(visitParamType),
      Option(ctx.expr()).map(visitExpr)
    )

  //TODO
  override def visitParamType(ctx: ParamTypeContext): ScalyType =
    visitType_(ctx.type_())

  override def visitClassParamClauses(ctx: ClassParamClausesContext): PTSeq[ClassParamClause] =
    ctx.classParamClause().map(visitClassParamClause)

  override def visitClassParamClause(ctx: ClassParamClauseContext): ClassParamClause =
    new ClassParamClause(
      visitClassParams(ctx.classParams())
    )


  override def visitClassParams(ctx: ClassParamsContext): PTSeq[ClassParam] =
    ctx.classParam().map {
      case c: ClassParamValContext => visitClassParamVal(c)
      case c: ClassParamVarContext => visitClassParamVar(c)
    }


  override def visitClassParamVal(ctx: ClassParamValContext): ClassParam = {
    new ClassParam(
      ctx.modifier().map(_.getText),
      "Val",
      ctx.Id().getText,
      visitParamType(ctx.paramType()),
      Option(ctx.expr()).map(visitExpr)
    )
  }

  override def visitClassParamVar(ctx: ClassParamVarContext): ClassParam = ???

  override def visitBindings(ctx: BindingsContext): ParseTree = ???

  override def visitBinding(ctx: BindingContext): ParseTree = ???

  override def visitModifier(ctx: ModifierContext): ParseTree = ???

  override def visitLocalModifier(ctx: LocalModifierContext): ParseTree = ???

  override def visitAccessModifier(ctx: AccessModifierContext): ParseTree = ???

  override def visitAccessQualifier(ctx: AccessQualifierContext): ParseTree = ???

  override def visitValDcl(ctx: ValDclContext): ValDcl =
    ValDcl(ctx.ids().Id().map(_.getText), visitType_(ctx.type_()))

  override def visitVarDcl(ctx: VarDclContext): VarDcl =
    VarDcl(ctx.ids().Id().map(_.getText), visitType_(ctx.type_()))

  override def visitFunDcl(ctx: FunDclContext): FunDcl =
    FunDcl(
      ctx.funSig().Id().getText,
      visitParamClauses(ctx.funSig().paramClauses()),
      Option(ctx.type_()).map(visitType_)
    )

  override def visitFunSig(ctx: FunSigContext): ParseTree = ???

  override def visitPatDef(ctx: PatDefContext): ParseTree = ???

  override def visitVarDef(ctx: VarDefContext): ParseTree = ???

  override def visitClassTemplateOpt(ctx: ClassTemplateOptContext): ParseTree = ???

  override def visitClassTemplate(ctx: ClassTemplateContext): ParseTree = ???

  override def visitClassParents(ctx: ClassParentsContext): ParseTree = ???

  override def visitAnnotType(ctx: AnnotTypeContext): ScalyType =
    visitSimpleType(ctx.simpleType())

  // Unused - should never be reached
  // TODO: This violates type safety
  override def visitIds(ctx: IdsContext): ParseTree = !!!

  override def visitParams(ctx: ParamsContext): ParseTree = !!!

  override def visitBlock(ctx: BlockContext): ParseTree = !!!

  // TODO: Extra constructors
  override def visitConstrExpr(ctx: ConstrExprContext): ParseTree = ???

  override def visitConstr(ctx: ConstrContext): ParseTree = ???

  override def visitConstrBlock(ctx: ConstrBlockContext): ParseTree = ???

  override def visitSelfInvocation(ctx: SelfInvocationContext): ParseTree = ???

}
