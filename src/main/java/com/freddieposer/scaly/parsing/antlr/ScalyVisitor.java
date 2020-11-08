// Generated from C:/Users/fredd/Google Drive/10. Cambridge/1. Work/6. Part II Dissertation/Scaly/src/main/grammar\Scaly.g4 by ANTLR 4.8
package com.freddieposer.scaly.parsing.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ScalyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ScalyVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ScalyParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(ScalyParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#ids}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIds(ScalyParser.IdsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#stableId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStableId(ScalyParser.StableIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#type_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_(ScalyParser.Type_Context ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#functionArgTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArgTypes(ScalyParser.FunctionArgTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#infixType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixType(ScalyParser.InfixTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#compoundType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundType(ScalyParser.CompoundTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleType(ScalyParser.SimpleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypes(ScalyParser.TypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#refinement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefinement(ScalyParser.RefinementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#refineStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefineStat(ScalyParser.RefineStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#typePat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePat(ScalyParser.TypePatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#ascription}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAscription(ScalyParser.AscriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ScalyParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr1(ScalyParser.Expr1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#prefixDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixDef(ScalyParser.PrefixDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#postfixExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpr(ScalyParser.PostfixExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#infixExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixExpr(ScalyParser.InfixExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#prefixExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpr(ScalyParser.PrefixExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#simpleExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpr(ScalyParser.SimpleExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpr1(ScalyParser.SimpleExpr1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#exprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprs(ScalyParser.ExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#argumentExprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentExprs(ScalyParser.ArgumentExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#blockExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockExpr(ScalyParser.BlockExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ScalyParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#blockStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(ScalyParser.BlockStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#resultExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResultExpr(ScalyParser.ResultExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(ScalyParser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#pattern1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern1(ScalyParser.Pattern1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#pattern2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern2(ScalyParser.Pattern2Context ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#pattern3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern3(ScalyParser.Pattern3Context ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#simplePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimplePattern(ScalyParser.SimplePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#patterns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatterns(ScalyParser.PatternsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#paramClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamClauses(ScalyParser.ParamClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#paramClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamClause(ScalyParser.ParamClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(ScalyParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(ScalyParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#paramType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamType(ScalyParser.ParamTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#classParamClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassParamClauses(ScalyParser.ClassParamClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#classParamClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassParamClause(ScalyParser.ClassParamClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#classParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassParams(ScalyParser.ClassParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#classParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassParam(ScalyParser.ClassParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#bindings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindings(ScalyParser.BindingsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#binding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinding(ScalyParser.BindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(ScalyParser.ModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#localModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalModifier(ScalyParser.LocalModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#accessModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessModifier(ScalyParser.AccessModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#accessQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessQualifier(ScalyParser.AccessQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#templateBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateBody(ScalyParser.TemplateBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#templateStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateStat(ScalyParser.TemplateStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcl(ScalyParser.DclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#valDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValDcl(ScalyParser.ValDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#varDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDcl(ScalyParser.VarDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#funDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDcl(ScalyParser.FunDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#funSig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunSig(ScalyParser.FunSigContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#patVarDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatVarDef(ScalyParser.PatVarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef(ScalyParser.DefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#patDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatDef(ScalyParser.PatDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(ScalyParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#funDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDef(ScalyParser.FunDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#tmplDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTmplDef(ScalyParser.TmplDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(ScalyParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#objectDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectDef(ScalyParser.ObjectDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#classTemplateOpt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassTemplateOpt(ScalyParser.ClassTemplateOptContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#classTemplate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassTemplate(ScalyParser.ClassTemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#classParents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassParents(ScalyParser.ClassParentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#constr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstr(ScalyParser.ConstrContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#constrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstrExpr(ScalyParser.ConstrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#constrBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstrBlock(ScalyParser.ConstrBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#selfInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfInvocation(ScalyParser.SelfInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#topStatSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopStatSeq(ScalyParser.TopStatSeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#topStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopStat(ScalyParser.TopStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScalyParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(ScalyParser.CompilationUnitContext ctx);
}