// Generated from C:/Users/fredd/Google Drive/10. Cambridge/1. Work/6. Part II Dissertation/Scaly/src/main/grammar\Scaly.g4 by ANTLR 4.8
package com.freddieposer.scaly.parsing.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ScalyParser}.
 */
public interface ScalyListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ScalyParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(ScalyParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(ScalyParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#topStatSeq}.
	 * @param ctx the parse tree
	 */
	void enterTopStatSeq(ScalyParser.TopStatSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#topStatSeq}.
	 * @param ctx the parse tree
	 */
	void exitTopStatSeq(ScalyParser.TopStatSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#topStat}.
	 * @param ctx the parse tree
	 */
	void enterTopStat(ScalyParser.TopStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#topStat}.
	 * @param ctx the parse tree
	 */
	void exitTopStat(ScalyParser.TopStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ScalyParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ScalyParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_int}
	 * labeled alternative in {@link ScalyParser#literal_inner}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_int(ScalyParser.Literal_intContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_int}
	 * labeled alternative in {@link ScalyParser#literal_inner}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_int(ScalyParser.Literal_intContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_float}
	 * labeled alternative in {@link ScalyParser#literal_inner}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_float(ScalyParser.Literal_floatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_float}
	 * labeled alternative in {@link ScalyParser#literal_inner}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_float(ScalyParser.Literal_floatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_bool}
	 * labeled alternative in {@link ScalyParser#literal_inner}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_bool(ScalyParser.Literal_boolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_bool}
	 * labeled alternative in {@link ScalyParser#literal_inner}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_bool(ScalyParser.Literal_boolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_char}
	 * labeled alternative in {@link ScalyParser#literal_inner}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_char(ScalyParser.Literal_charContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_char}
	 * labeled alternative in {@link ScalyParser#literal_inner}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_char(ScalyParser.Literal_charContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_string}
	 * labeled alternative in {@link ScalyParser#literal_inner}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_string(ScalyParser.Literal_stringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_string}
	 * labeled alternative in {@link ScalyParser#literal_inner}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_string(ScalyParser.Literal_stringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_symbol}
	 * labeled alternative in {@link ScalyParser#literal_inner}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_symbol(ScalyParser.Literal_symbolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_symbol}
	 * labeled alternative in {@link ScalyParser#literal_inner}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_symbol(ScalyParser.Literal_symbolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_null}
	 * labeled alternative in {@link ScalyParser#literal_inner}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_null(ScalyParser.Literal_nullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_null}
	 * labeled alternative in {@link ScalyParser#literal_inner}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_null(ScalyParser.Literal_nullContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#ids}.
	 * @param ctx the parse tree
	 */
	void enterIds(ScalyParser.IdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#ids}.
	 * @param ctx the parse tree
	 */
	void exitIds(ScalyParser.IdsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#stableId}.
	 * @param ctx the parse tree
	 */
	void enterStableId(ScalyParser.StableIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#stableId}.
	 * @param ctx the parse tree
	 */
	void exitStableId(ScalyParser.StableIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#type_}.
	 * @param ctx the parse tree
	 */
	void enterType_(ScalyParser.Type_Context ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#type_}.
	 * @param ctx the parse tree
	 */
	void exitType_(ScalyParser.Type_Context ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#functionArgTypes}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgTypes(ScalyParser.FunctionArgTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#functionArgTypes}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgTypes(ScalyParser.FunctionArgTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#infixType}.
	 * @param ctx the parse tree
	 */
	void enterInfixType(ScalyParser.InfixTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#infixType}.
	 * @param ctx the parse tree
	 */
	void exitInfixType(ScalyParser.InfixTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#compoundType}.
	 * @param ctx the parse tree
	 */
	void enterCompoundType(ScalyParser.CompoundTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#compoundType}.
	 * @param ctx the parse tree
	 */
	void exitCompoundType(ScalyParser.CompoundTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void enterSimpleType(ScalyParser.SimpleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void exitSimpleType(ScalyParser.SimpleTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#types}.
	 * @param ctx the parse tree
	 */
	void enterTypes(ScalyParser.TypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#types}.
	 * @param ctx the parse tree
	 */
	void exitTypes(ScalyParser.TypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#refinement}.
	 * @param ctx the parse tree
	 */
	void enterRefinement(ScalyParser.RefinementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#refinement}.
	 * @param ctx the parse tree
	 */
	void exitRefinement(ScalyParser.RefinementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#refineStat}.
	 * @param ctx the parse tree
	 */
	void enterRefineStat(ScalyParser.RefineStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#refineStat}.
	 * @param ctx the parse tree
	 */
	void exitRefineStat(ScalyParser.RefineStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#typePat}.
	 * @param ctx the parse tree
	 */
	void enterTypePat(ScalyParser.TypePatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#typePat}.
	 * @param ctx the parse tree
	 */
	void exitTypePat(ScalyParser.TypePatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#ascription}.
	 * @param ctx the parse tree
	 */
	void enterAscription(ScalyParser.AscriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#ascription}.
	 * @param ctx the parse tree
	 */
	void exitAscription(ScalyParser.AscriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ScalyParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ScalyParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr1_if}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterExpr1_if(ScalyParser.Expr1_ifContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr1_if}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitExpr1_if(ScalyParser.Expr1_ifContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr1_while}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterExpr1_while(ScalyParser.Expr1_whileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr1_while}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitExpr1_while(ScalyParser.Expr1_whileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr1_try}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterExpr1_try(ScalyParser.Expr1_tryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr1_try}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitExpr1_try(ScalyParser.Expr1_tryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr1_dowhile}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterExpr1_dowhile(ScalyParser.Expr1_dowhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr1_dowhile}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitExpr1_dowhile(ScalyParser.Expr1_dowhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr1_throw}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterExpr1_throw(ScalyParser.Expr1_throwContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr1_throw}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitExpr1_throw(ScalyParser.Expr1_throwContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr1_return}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterExpr1_return(ScalyParser.Expr1_returnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr1_return}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitExpr1_return(ScalyParser.Expr1_returnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr1_assignment}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterExpr1_assignment(ScalyParser.Expr1_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr1_assignment}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitExpr1_assignment(ScalyParser.Expr1_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr1_assignment2}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterExpr1_assignment2(ScalyParser.Expr1_assignment2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code expr1_assignment2}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitExpr1_assignment2(ScalyParser.Expr1_assignment2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code expr1_postfix}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterExpr1_postfix(ScalyParser.Expr1_postfixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr1_postfix}
	 * labeled alternative in {@link ScalyParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitExpr1_postfix(ScalyParser.Expr1_postfixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#prefixDef}.
	 * @param ctx the parse tree
	 */
	void enterPrefixDef(ScalyParser.PrefixDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#prefixDef}.
	 * @param ctx the parse tree
	 */
	void exitPrefixDef(ScalyParser.PrefixDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpr(ScalyParser.PostfixExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpr(ScalyParser.PostfixExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#infixExpr}.
	 * @param ctx the parse tree
	 */
	void enterInfixExpr(ScalyParser.InfixExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#infixExpr}.
	 * @param ctx the parse tree
	 */
	void exitInfixExpr(ScalyParser.InfixExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#prefixExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpr(ScalyParser.PrefixExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#prefixExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpr(ScalyParser.PrefixExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpr(ScalyParser.SimpleExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpr(ScalyParser.SimpleExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExpr1_underscore}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpr1_underscore(ScalyParser.SimpleExpr1_underscoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExpr1_underscore}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpr1_underscore(ScalyParser.SimpleExpr1_underscoreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExpr1_member1}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpr1_member1(ScalyParser.SimpleExpr1_member1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExpr1_member1}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpr1_member1(ScalyParser.SimpleExpr1_member1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExpr1_member2}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpr1_member2(ScalyParser.SimpleExpr1_member2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExpr1_member2}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpr1_member2(ScalyParser.SimpleExpr1_member2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExpr1_application}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpr1_application(ScalyParser.SimpleExpr1_applicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExpr1_application}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpr1_application(ScalyParser.SimpleExpr1_applicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExpr1_stableID}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpr1_stableID(ScalyParser.SimpleExpr1_stableIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExpr1_stableID}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpr1_stableID(ScalyParser.SimpleExpr1_stableIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExpr1_brackets}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpr1_brackets(ScalyParser.SimpleExpr1_bracketsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExpr1_brackets}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpr1_brackets(ScalyParser.SimpleExpr1_bracketsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExpr1_literal}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpr1_literal(ScalyParser.SimpleExpr1_literalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExpr1_literal}
	 * labeled alternative in {@link ScalyParser#simpleExpr1}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpr1_literal(ScalyParser.SimpleExpr1_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#exprs}.
	 * @param ctx the parse tree
	 */
	void enterExprs(ScalyParser.ExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#exprs}.
	 * @param ctx the parse tree
	 */
	void exitExprs(ScalyParser.ExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#argumentExprs}.
	 * @param ctx the parse tree
	 */
	void enterArgumentExprs(ScalyParser.ArgumentExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#argumentExprs}.
	 * @param ctx the parse tree
	 */
	void exitArgumentExprs(ScalyParser.ArgumentExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#blockExpr}.
	 * @param ctx the parse tree
	 */
	void enterBlockExpr(ScalyParser.BlockExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#blockExpr}.
	 * @param ctx the parse tree
	 */
	void exitBlockExpr(ScalyParser.BlockExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ScalyParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ScalyParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#blockStat}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(ScalyParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#blockStat}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(ScalyParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#resultExpr}.
	 * @param ctx the parse tree
	 */
	void enterResultExpr(ScalyParser.ResultExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#resultExpr}.
	 * @param ctx the parse tree
	 */
	void exitResultExpr(ScalyParser.ResultExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(ScalyParser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(ScalyParser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#pattern1}.
	 * @param ctx the parse tree
	 */
	void enterPattern1(ScalyParser.Pattern1Context ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#pattern1}.
	 * @param ctx the parse tree
	 */
	void exitPattern1(ScalyParser.Pattern1Context ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#pattern2}.
	 * @param ctx the parse tree
	 */
	void enterPattern2(ScalyParser.Pattern2Context ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#pattern2}.
	 * @param ctx the parse tree
	 */
	void exitPattern2(ScalyParser.Pattern2Context ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#pattern3}.
	 * @param ctx the parse tree
	 */
	void enterPattern3(ScalyParser.Pattern3Context ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#pattern3}.
	 * @param ctx the parse tree
	 */
	void exitPattern3(ScalyParser.Pattern3Context ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#simplePattern}.
	 * @param ctx the parse tree
	 */
	void enterSimplePattern(ScalyParser.SimplePatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#simplePattern}.
	 * @param ctx the parse tree
	 */
	void exitSimplePattern(ScalyParser.SimplePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#patterns}.
	 * @param ctx the parse tree
	 */
	void enterPatterns(ScalyParser.PatternsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#patterns}.
	 * @param ctx the parse tree
	 */
	void exitPatterns(ScalyParser.PatternsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#paramClauses}.
	 * @param ctx the parse tree
	 */
	void enterParamClauses(ScalyParser.ParamClausesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#paramClauses}.
	 * @param ctx the parse tree
	 */
	void exitParamClauses(ScalyParser.ParamClausesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#paramClause}.
	 * @param ctx the parse tree
	 */
	void enterParamClause(ScalyParser.ParamClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#paramClause}.
	 * @param ctx the parse tree
	 */
	void exitParamClause(ScalyParser.ParamClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(ScalyParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(ScalyParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(ScalyParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(ScalyParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#paramType}.
	 * @param ctx the parse tree
	 */
	void enterParamType(ScalyParser.ParamTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#paramType}.
	 * @param ctx the parse tree
	 */
	void exitParamType(ScalyParser.ParamTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#classParamClauses}.
	 * @param ctx the parse tree
	 */
	void enterClassParamClauses(ScalyParser.ClassParamClausesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#classParamClauses}.
	 * @param ctx the parse tree
	 */
	void exitClassParamClauses(ScalyParser.ClassParamClausesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#classParamClause}.
	 * @param ctx the parse tree
	 */
	void enterClassParamClause(ScalyParser.ClassParamClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#classParamClause}.
	 * @param ctx the parse tree
	 */
	void exitClassParamClause(ScalyParser.ClassParamClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#classParams}.
	 * @param ctx the parse tree
	 */
	void enterClassParams(ScalyParser.ClassParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#classParams}.
	 * @param ctx the parse tree
	 */
	void exitClassParams(ScalyParser.ClassParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#classParam}.
	 * @param ctx the parse tree
	 */
	void enterClassParam(ScalyParser.ClassParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#classParam}.
	 * @param ctx the parse tree
	 */
	void exitClassParam(ScalyParser.ClassParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#bindings}.
	 * @param ctx the parse tree
	 */
	void enterBindings(ScalyParser.BindingsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#bindings}.
	 * @param ctx the parse tree
	 */
	void exitBindings(ScalyParser.BindingsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#binding}.
	 * @param ctx the parse tree
	 */
	void enterBinding(ScalyParser.BindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#binding}.
	 * @param ctx the parse tree
	 */
	void exitBinding(ScalyParser.BindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(ScalyParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(ScalyParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#localModifier}.
	 * @param ctx the parse tree
	 */
	void enterLocalModifier(ScalyParser.LocalModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#localModifier}.
	 * @param ctx the parse tree
	 */
	void exitLocalModifier(ScalyParser.LocalModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void enterAccessModifier(ScalyParser.AccessModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void exitAccessModifier(ScalyParser.AccessModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#accessQualifier}.
	 * @param ctx the parse tree
	 */
	void enterAccessQualifier(ScalyParser.AccessQualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#accessQualifier}.
	 * @param ctx the parse tree
	 */
	void exitAccessQualifier(ScalyParser.AccessQualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#templateBody}.
	 * @param ctx the parse tree
	 */
	void enterTemplateBody(ScalyParser.TemplateBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#templateBody}.
	 * @param ctx the parse tree
	 */
	void exitTemplateBody(ScalyParser.TemplateBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#templateStat}.
	 * @param ctx the parse tree
	 */
	void enterTemplateStat(ScalyParser.TemplateStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#templateStat}.
	 * @param ctx the parse tree
	 */
	void exitTemplateStat(ScalyParser.TemplateStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#dcl}.
	 * @param ctx the parse tree
	 */
	void enterDcl(ScalyParser.DclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#dcl}.
	 * @param ctx the parse tree
	 */
	void exitDcl(ScalyParser.DclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#valDcl}.
	 * @param ctx the parse tree
	 */
	void enterValDcl(ScalyParser.ValDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#valDcl}.
	 * @param ctx the parse tree
	 */
	void exitValDcl(ScalyParser.ValDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#varDcl}.
	 * @param ctx the parse tree
	 */
	void enterVarDcl(ScalyParser.VarDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#varDcl}.
	 * @param ctx the parse tree
	 */
	void exitVarDcl(ScalyParser.VarDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#funDcl}.
	 * @param ctx the parse tree
	 */
	void enterFunDcl(ScalyParser.FunDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#funDcl}.
	 * @param ctx the parse tree
	 */
	void exitFunDcl(ScalyParser.FunDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#funSig}.
	 * @param ctx the parse tree
	 */
	void enterFunSig(ScalyParser.FunSigContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#funSig}.
	 * @param ctx the parse tree
	 */
	void exitFunSig(ScalyParser.FunSigContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#patVarDef}.
	 * @param ctx the parse tree
	 */
	void enterPatVarDef(ScalyParser.PatVarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#patVarDef}.
	 * @param ctx the parse tree
	 */
	void exitPatVarDef(ScalyParser.PatVarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#def}.
	 * @param ctx the parse tree
	 */
	void enterDef(ScalyParser.DefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#def}.
	 * @param ctx the parse tree
	 */
	void exitDef(ScalyParser.DefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#patDef}.
	 * @param ctx the parse tree
	 */
	void enterPatDef(ScalyParser.PatDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#patDef}.
	 * @param ctx the parse tree
	 */
	void exitPatDef(ScalyParser.PatDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(ScalyParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(ScalyParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#funDef}.
	 * @param ctx the parse tree
	 */
	void enterFunDef(ScalyParser.FunDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#funDef}.
	 * @param ctx the parse tree
	 */
	void exitFunDef(ScalyParser.FunDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#tmplDef}.
	 * @param ctx the parse tree
	 */
	void enterTmplDef(ScalyParser.TmplDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#tmplDef}.
	 * @param ctx the parse tree
	 */
	void exitTmplDef(ScalyParser.TmplDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(ScalyParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(ScalyParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#objectDef}.
	 * @param ctx the parse tree
	 */
	void enterObjectDef(ScalyParser.ObjectDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#objectDef}.
	 * @param ctx the parse tree
	 */
	void exitObjectDef(ScalyParser.ObjectDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#classTemplateOpt}.
	 * @param ctx the parse tree
	 */
	void enterClassTemplateOpt(ScalyParser.ClassTemplateOptContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#classTemplateOpt}.
	 * @param ctx the parse tree
	 */
	void exitClassTemplateOpt(ScalyParser.ClassTemplateOptContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#classTemplate}.
	 * @param ctx the parse tree
	 */
	void enterClassTemplate(ScalyParser.ClassTemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#classTemplate}.
	 * @param ctx the parse tree
	 */
	void exitClassTemplate(ScalyParser.ClassTemplateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#classParents}.
	 * @param ctx the parse tree
	 */
	void enterClassParents(ScalyParser.ClassParentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#classParents}.
	 * @param ctx the parse tree
	 */
	void exitClassParents(ScalyParser.ClassParentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#constr}.
	 * @param ctx the parse tree
	 */
	void enterConstr(ScalyParser.ConstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#constr}.
	 * @param ctx the parse tree
	 */
	void exitConstr(ScalyParser.ConstrContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#constrExpr}.
	 * @param ctx the parse tree
	 */
	void enterConstrExpr(ScalyParser.ConstrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#constrExpr}.
	 * @param ctx the parse tree
	 */
	void exitConstrExpr(ScalyParser.ConstrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#constrBlock}.
	 * @param ctx the parse tree
	 */
	void enterConstrBlock(ScalyParser.ConstrBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#constrBlock}.
	 * @param ctx the parse tree
	 */
	void exitConstrBlock(ScalyParser.ConstrBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScalyParser#selfInvocation}.
	 * @param ctx the parse tree
	 */
	void enterSelfInvocation(ScalyParser.SelfInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScalyParser#selfInvocation}.
	 * @param ctx the parse tree
	 */
	void exitSelfInvocation(ScalyParser.SelfInvocationContext ctx);
}