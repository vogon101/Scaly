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
	 * Visit a parse tree produced by {@link ScalyParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(ScalyParser.CompilationUnitContext ctx);
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
	 * Visit a parse tree produced by the {@code literal_int}
	 * labeled alternative in {@link ScalyParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_int(ScalyParser.Literal_intContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_float}
	 * labeled alternative in {@link ScalyParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_float(ScalyParser.Literal_floatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_bool}
	 * labeled alternative in {@link ScalyParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_bool(ScalyParser.Literal_boolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_char}
	 * labeled alternative in {@link ScalyParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_char(ScalyParser.Literal_charContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_string}
	 * labeled alternative in {@link ScalyParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_string(ScalyParser.Literal_stringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_symbol}
	 * labeled alternative in {@link ScalyParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_symbol(ScalyParser.Literal_symbolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_null}
	 * labeled alternative in {@link ScalyParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_null(ScalyParser.Literal_nullContext ctx);
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
	 * Visit a parse tree produced by {@link ScalyParser#annotType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotType(ScalyParser.AnnotTypeContext ctx);
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
	 * Visit a parse tree produced by the {@code expr1_if}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr1_if(ScalyParser.Expr1_ifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr1_while}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr1_while(ScalyParser.Expr1_whileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr1_try}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr1_try(ScalyParser.Expr1_tryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr1_dowhile}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr1_dowhile(ScalyParser.Expr1_dowhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr1_throw}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr1_throw(ScalyParser.Expr1_throwContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr1_return}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr1_return(ScalyParser.Expr1_returnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr1_assignment}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr1_assignment(ScalyParser.Expr1_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr1_assignment2}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr1_assignment2(ScalyParser.Expr1_assignment2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code expr1_postfix}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr1_postfix(ScalyParser.Expr1_postfixContext ctx);
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
	 * Visit a parse tree produced by the {@code simpleExpr1_underscore}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpr1_underscore(ScalyParser.SimpleExpr1_underscoreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleExpr1_member1}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpr1_member1(ScalyParser.SimpleExpr1_member1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleExpr1_member2}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpr1_member2(ScalyParser.SimpleExpr1_member2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleExpr1_application}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpr1_application(ScalyParser.SimpleExpr1_applicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleExpr1_stableID}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpr1_stableID(ScalyParser.SimpleExpr1_stableIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleExpr1_brackets}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpr1_brackets(ScalyParser.SimpleExpr1_bracketsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleExpr1_literal}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpr1_literal(ScalyParser.SimpleExpr1_literalContext ctx);
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
	 * Visit a parse tree produced by the {@code blockStatDef}
	 * labeled alternative in {@link ScalyParser#blockStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatDef(ScalyParser.BlockStatDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStatTmplDef}
	 * labeled alternative in {@link ScalyParser#blockStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatTmplDef(ScalyParser.BlockStatTmplDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStatExpr}
	 * labeled alternative in {@link ScalyParser#blockStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatExpr(ScalyParser.BlockStatExprContext ctx);
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
	 * Visit a parse tree produced by the {@code classParamVal}
	 * labeled alternative in {@link ScalyParser#classParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassParamVal(ScalyParser.ClassParamValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classParamVar}
	 * labeled alternative in {@link ScalyParser#classParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassParamVar(ScalyParser.ClassParamVarContext ctx);
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
	 * Visit a parse tree produced by the {@code dclValDcl}
	 * labeled alternative in {@link ScalyParser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclValDcl(ScalyParser.DclValDclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dclVarDcl}
	 * labeled alternative in {@link ScalyParser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclVarDcl(ScalyParser.DclVarDclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dclDefDcl}
	 * labeled alternative in {@link ScalyParser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclDefDcl(ScalyParser.DclDefDclContext ctx);
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
	 * Visit a parse tree produced by the {@code patVarDefVal}
	 * labeled alternative in {@link ScalyParser#patVarDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatVarDefVal(ScalyParser.PatVarDefValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code patVarDefVar}
	 * labeled alternative in {@link ScalyParser#patVarDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatVarDefVar(ScalyParser.PatVarDefVarContext ctx);
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
}