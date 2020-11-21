// Generated from C:/Users/fredd/Google Drive/10. Cambridge/1. Work/6. Part II Dissertation/Scaly/src/main/grammar\Scaly.g4 by ANTLR 4.8
package com.freddieposer.scaly.parsing.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ScalyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, Id=44, BooleanLiteral=45, 
		CharacterLiteral=46, SymbolLiteral=47, IntegerLiteral=48, StringLiteral=49, 
		FloatingPointLiteral=50, Varid=51, BoundVarid=52, Paren=53, Delim=54, 
		Semi=55, NL=56, NEWLINE=57, WS=58, COMMENT=59, LINE_COMMENT=60;
	public static final int
		RULE_compilationUnit = 0, RULE_topStatSeq = 1, RULE_topStat = 2, RULE_literal = 3, 
		RULE_ids = 4, RULE_stableId = 5, RULE_type_ = 6, RULE_functionArgTypes = 7, 
		RULE_infixType = 8, RULE_compoundType = 9, RULE_annotType = 10, RULE_simpleType = 11, 
		RULE_types = 12, RULE_typePat = 13, RULE_ascription = 14, RULE_expr = 15, 
		RULE_expr1 = 16, RULE_prefixDef = 17, RULE_postfixExpr = 18, RULE_infixExpr = 19, 
		RULE_prefixExpr = 20, RULE_simpleExpr = 21, RULE_simpleExpr1 = 22, RULE_exprs = 23, 
		RULE_argumentExprs = 24, RULE_blockExpr = 25, RULE_block = 26, RULE_blockStat = 27, 
		RULE_resultExpr = 28, RULE_pattern = 29, RULE_pattern1 = 30, RULE_pattern2 = 31, 
		RULE_pattern3 = 32, RULE_simplePattern = 33, RULE_patterns = 34, RULE_paramClauses = 35, 
		RULE_paramClause = 36, RULE_params = 37, RULE_param = 38, RULE_paramType = 39, 
		RULE_classParamClauses = 40, RULE_classParamClause = 41, RULE_classParams = 42, 
		RULE_classParam = 43, RULE_bindings = 44, RULE_binding = 45, RULE_modifier = 46, 
		RULE_localModifier = 47, RULE_accessModifier = 48, RULE_accessQualifier = 49, 
		RULE_templateBody = 50, RULE_templateStat = 51, RULE_dcl = 52, RULE_valDcl = 53, 
		RULE_varDcl = 54, RULE_funDcl = 55, RULE_funSig = 56, RULE_patVarDef = 57, 
		RULE_def = 58, RULE_patDef = 59, RULE_varDef = 60, RULE_funDef = 61, RULE_tmplDef = 62, 
		RULE_classDef = 63, RULE_objectDef = 64, RULE_classTemplateOpt = 65, RULE_classTemplate = 66, 
		RULE_classParents = 67, RULE_constr = 68, RULE_constrExpr = 69, RULE_constrBlock = 70, 
		RULE_selfInvocation = 71;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "topStatSeq", "topStat", "literal", "ids", "stableId", 
			"type_", "functionArgTypes", "infixType", "compoundType", "annotType", 
			"simpleType", "types", "typePat", "ascription", "expr", "expr1", "prefixDef", 
			"postfixExpr", "infixExpr", "prefixExpr", "simpleExpr", "simpleExpr1", 
			"exprs", "argumentExprs", "blockExpr", "block", "blockStat", "resultExpr", 
			"pattern", "pattern1", "pattern2", "pattern3", "simplePattern", "patterns", 
			"paramClauses", "paramClause", "params", "param", "paramType", "classParamClauses", 
			"classParamClause", "classParams", "classParam", "bindings", "binding", 
			"modifier", "localModifier", "accessModifier", "accessQualifier", "templateBody", 
			"templateStat", "dcl", "valDcl", "varDcl", "funDcl", "funSig", "patVarDef", 
			"def", "patDef", "varDef", "funDef", "tmplDef", "classDef", "objectDef", 
			"classTemplateOpt", "classTemplate", "classParents", "constr", "constrExpr", 
			"constrBlock", "selfInvocation"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-'", "'null'", "','", "'.'", "'=>'", "'('", "')'", "':'", "'_'", 
			"'*'", "'if'", "'else'", "'while'", "'try'", "'catch'", "'finally'", 
			"'do'", "'throw'", "'return'", "'='", "'+'", "'~'", "'!'", "'new'", "'{'", 
			"'}'", "'|'", "'@'", "'val'", "'var'", "'override'", "'abstract'", "'final'", 
			"'sealed'", "'private'", "'protected'", "'['", "'this'", "']'", "'def'", 
			"'class'", "'object'", "'extends'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "Id", "BooleanLiteral", 
			"CharacterLiteral", "SymbolLiteral", "IntegerLiteral", "StringLiteral", 
			"FloatingPointLiteral", "Varid", "BoundVarid", "Paren", "Delim", "Semi", 
			"NL", "NEWLINE", "WS", "COMMENT", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Scaly.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ScalyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompilationUnitContext extends ParserRuleContext {
		public TopStatSeqContext topStatSeq() {
			return getRuleContext(TopStatSeqContext.class,0);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			topStatSeq();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TopStatSeqContext extends ParserRuleContext {
		public List<TopStatContext> topStat() {
			return getRuleContexts(TopStatContext.class);
		}
		public TopStatContext topStat(int i) {
			return getRuleContext(TopStatContext.class,i);
		}
		public TopStatSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topStatSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterTopStatSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitTopStatSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitTopStatSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopStatSeqContext topStatSeq() throws RecognitionException {
		TopStatSeqContext _localctx = new TopStatSeqContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topStatSeq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(146);
				topStat();
				}
				}
				setState(149); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__40) | (1L << T__41))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TopStatContext extends ParserRuleContext {
		public TmplDefContext tmplDef() {
			return getRuleContext(TmplDefContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public TopStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterTopStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitTopStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitTopStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopStatContext topStat() throws RecognitionException {
		TopStatContext _localctx = new TopStatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_topStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) {
				{
				{
				setState(151);
				modifier();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157);
			tmplDef();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Literal_intContext extends LiteralContext {
		public TerminalNode IntegerLiteral() { return getToken(ScalyParser.IntegerLiteral, 0); }
		public Literal_intContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterLiteral_int(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitLiteral_int(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitLiteral_int(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Literal_nullContext extends LiteralContext {
		public Literal_nullContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterLiteral_null(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitLiteral_null(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitLiteral_null(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Literal_boolContext extends LiteralContext {
		public TerminalNode BooleanLiteral() { return getToken(ScalyParser.BooleanLiteral, 0); }
		public Literal_boolContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterLiteral_bool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitLiteral_bool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitLiteral_bool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Literal_symbolContext extends LiteralContext {
		public TerminalNode SymbolLiteral() { return getToken(ScalyParser.SymbolLiteral, 0); }
		public Literal_symbolContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterLiteral_symbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitLiteral_symbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitLiteral_symbol(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Literal_floatContext extends LiteralContext {
		public TerminalNode FloatingPointLiteral() { return getToken(ScalyParser.FloatingPointLiteral, 0); }
		public Literal_floatContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterLiteral_float(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitLiteral_float(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitLiteral_float(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Literal_charContext extends LiteralContext {
		public TerminalNode CharacterLiteral() { return getToken(ScalyParser.CharacterLiteral, 0); }
		public Literal_charContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterLiteral_char(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitLiteral_char(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitLiteral_char(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Literal_stringContext extends LiteralContext {
		public TerminalNode StringLiteral() { return getToken(ScalyParser.StringLiteral, 0); }
		public Literal_stringContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterLiteral_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitLiteral_string(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitLiteral_string(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_literal);
		int _la;
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new Literal_intContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(159);
					match(T__0);
					}
				}

				setState(162);
				match(IntegerLiteral);
				}
				break;
			case 2:
				_localctx = new Literal_floatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(163);
					match(T__0);
					}
				}

				setState(166);
				match(FloatingPointLiteral);
				}
				break;
			case 3:
				_localctx = new Literal_boolContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				match(BooleanLiteral);
				}
				break;
			case 4:
				_localctx = new Literal_charContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(168);
				match(CharacterLiteral);
				}
				break;
			case 5:
				_localctx = new Literal_stringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(169);
				match(StringLiteral);
				}
				break;
			case 6:
				_localctx = new Literal_symbolContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(170);
				match(SymbolLiteral);
				}
				break;
			case 7:
				_localctx = new Literal_nullContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(171);
				match(T__1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdsContext extends ParserRuleContext {
		public List<TerminalNode> Id() { return getTokens(ScalyParser.Id); }
		public TerminalNode Id(int i) {
			return getToken(ScalyParser.Id, i);
		}
		public IdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ids; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterIds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitIds(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitIds(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdsContext ids() throws RecognitionException {
		IdsContext _localctx = new IdsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(Id);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(175);
				match(T__2);
				setState(176);
				match(Id);
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StableIdContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public StableIdContext stableId() {
			return getRuleContext(StableIdContext.class,0);
		}
		public StableIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stableId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterStableId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitStableId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitStableId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StableIdContext stableId() throws RecognitionException {
		return stableId(0);
	}

	private StableIdContext stableId(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StableIdContext _localctx = new StableIdContext(_ctx, _parentState);
		StableIdContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_stableId, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(183);
			match(Id);
			}
			_ctx.stop = _input.LT(-1);
			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StableIdContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stableId);
					setState(185);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(186);
					match(T__3);
					setState(187);
					match(Id);
					}
					} 
				}
				setState(192);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Type_Context extends ParserRuleContext {
		public FunctionArgTypesContext functionArgTypes() {
			return getRuleContext(FunctionArgTypesContext.class,0);
		}
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public InfixTypeContext infixType() {
			return getRuleContext(InfixTypeContext.class,0);
		}
		public Type_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterType_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitType_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitType_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_Context type_() throws RecognitionException {
		Type_Context _localctx = new Type_Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_type_);
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				functionArgTypes();
				setState(194);
				match(T__4);
				setState(195);
				type_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				infixType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArgTypesContext extends ParserRuleContext {
		public InfixTypeContext infixType() {
			return getRuleContext(InfixTypeContext.class,0);
		}
		public List<ParamTypeContext> paramType() {
			return getRuleContexts(ParamTypeContext.class);
		}
		public ParamTypeContext paramType(int i) {
			return getRuleContext(ParamTypeContext.class,i);
		}
		public FunctionArgTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterFunctionArgTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitFunctionArgTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitFunctionArgTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgTypesContext functionArgTypes() throws RecognitionException {
		FunctionArgTypesContext _localctx = new FunctionArgTypesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionArgTypes);
		int _la;
		try {
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				infixType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(T__5);
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5 || _la==Id) {
					{
					setState(202);
					paramType();
					setState(207);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(203);
						match(T__2);
						setState(204);
						paramType();
						}
						}
						setState(209);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(212);
				match(T__6);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InfixTypeContext extends ParserRuleContext {
		public CompoundTypeContext compoundType() {
			return getRuleContext(CompoundTypeContext.class,0);
		}
		public InfixTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infixType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterInfixType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitInfixType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitInfixType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InfixTypeContext infixType() throws RecognitionException {
		InfixTypeContext _localctx = new InfixTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_infixType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			compoundType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundTypeContext extends ParserRuleContext {
		public AnnotTypeContext annotType() {
			return getRuleContext(AnnotTypeContext.class,0);
		}
		public CompoundTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterCompoundType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitCompoundType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitCompoundType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundTypeContext compoundType() throws RecognitionException {
		CompoundTypeContext _localctx = new CompoundTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_compoundType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			annotType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotTypeContext extends ParserRuleContext {
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public AnnotTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterAnnotType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitAnnotType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitAnnotType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotTypeContext annotType() throws RecognitionException {
		AnnotTypeContext _localctx = new AnnotTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_annotType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			simpleType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleTypeContext extends ParserRuleContext {
		public StableIdContext stableId() {
			return getRuleContext(StableIdContext.class,0);
		}
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public SimpleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterSimpleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitSimpleType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitSimpleType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleTypeContext simpleType() throws RecognitionException {
		SimpleTypeContext _localctx = new SimpleTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_simpleType);
		try {
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				stableId(0);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				match(T__5);
				setState(223);
				types();
				setState(224);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypesContext extends ParserRuleContext {
		public List<Type_Context> type_() {
			return getRuleContexts(Type_Context.class);
		}
		public Type_Context type_(int i) {
			return getRuleContext(Type_Context.class,i);
		}
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_types);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			type_();
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(229);
				match(T__2);
				setState(230);
				type_();
				}
				}
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypePatContext extends ParserRuleContext {
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TypePatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typePat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterTypePat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitTypePat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitTypePat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypePatContext typePat() throws RecognitionException {
		TypePatContext _localctx = new TypePatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_typePat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			type_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AscriptionContext extends ParserRuleContext {
		public InfixTypeContext infixType() {
			return getRuleContext(InfixTypeContext.class,0);
		}
		public AscriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ascription; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterAscription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitAscription(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitAscription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AscriptionContext ascription() throws RecognitionException {
		AscriptionContext _localctx = new AscriptionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ascription);
		try {
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				match(T__7);
				setState(239);
				infixType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(T__7);
				setState(241);
				match(T__8);
				setState(242);
				match(T__9);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BindingsContext bindings() {
			return getRuleContext(BindingsContext.class,0);
		}
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expr);
		try {
			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__5:
					{
					setState(245);
					bindings();
					}
					break;
				case T__8:
					{
					setState(246);
					match(T__8);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(249);
				match(T__4);
				setState(250);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				expr1();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr1Context extends ParserRuleContext {
		public Expr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr1; }
	 
		public Expr1Context() { }
		public void copyFrom(Expr1Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Expr1_assignmentContext extends Expr1Context {
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SimpleExprContext simpleExpr() {
			return getRuleContext(SimpleExprContext.class,0);
		}
		public SimpleExpr1Context simpleExpr1() {
			return getRuleContext(SimpleExpr1Context.class,0);
		}
		public Expr1_assignmentContext(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterExpr1_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitExpr1_assignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitExpr1_assignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr1_postfixContext extends Expr1Context {
		public PostfixExprContext postfixExpr() {
			return getRuleContext(PostfixExprContext.class,0);
		}
		public AscriptionContext ascription() {
			return getRuleContext(AscriptionContext.class,0);
		}
		public Expr1_postfixContext(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterExpr1_postfix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitExpr1_postfix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitExpr1_postfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr1_tryContext extends Expr1Context {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr1_tryContext(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterExpr1_try(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitExpr1_try(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitExpr1_try(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr1_whileContext extends Expr1Context {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(ScalyParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(ScalyParser.NL, i);
		}
		public Expr1_whileContext(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterExpr1_while(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitExpr1_while(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitExpr1_while(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr1_dowhileContext extends Expr1Context {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr1_dowhileContext(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterExpr1_dowhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitExpr1_dowhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitExpr1_dowhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr1_throwContext extends Expr1Context {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr1_throwContext(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterExpr1_throw(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitExpr1_throw(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitExpr1_throw(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr1_assignment2Context extends Expr1Context {
		public SimpleExpr1Context simpleExpr1() {
			return getRuleContext(SimpleExpr1Context.class,0);
		}
		public ArgumentExprsContext argumentExprs() {
			return getRuleContext(ArgumentExprsContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr1_assignment2Context(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterExpr1_assignment2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitExpr1_assignment2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitExpr1_assignment2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr1_ifContext extends Expr1Context {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(ScalyParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(ScalyParser.NL, i);
		}
		public Expr1_ifContext(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterExpr1_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitExpr1_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitExpr1_if(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr1_returnContext extends Expr1Context {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr1_returnContext(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterExpr1_return(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitExpr1_return(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitExpr1_return(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr1Context expr1() throws RecognitionException {
		Expr1Context _localctx = new Expr1Context(_ctx, getState());
		enterRule(_localctx, 32, RULE_expr1);
		int _la;
		try {
			setState(327);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new Expr1_ifContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				match(T__10);
				setState(255);
				match(T__5);
				setState(256);
				expr();
				setState(257);
				match(T__6);
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(258);
					match(NL);
					}
					}
					setState(263);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(264);
				expr();
				setState(267);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(265);
					match(T__11);
					setState(266);
					expr();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new Expr1_whileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(269);
				match(T__12);
				setState(270);
				match(T__5);
				setState(271);
				expr();
				setState(272);
				match(T__6);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(273);
					match(NL);
					}
					}
					setState(278);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(279);
				expr();
				}
				break;
			case 3:
				_localctx = new Expr1_tryContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(281);
				match(T__13);
				setState(282);
				expr();
				setState(285);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(283);
					match(T__14);
					setState(284);
					expr();
					}
					break;
				}
				setState(289);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(287);
					match(T__15);
					setState(288);
					expr();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new Expr1_dowhileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(291);
				match(T__16);
				setState(292);
				expr();
				setState(293);
				match(T__12);
				setState(294);
				match(T__5);
				setState(295);
				expr();
				setState(296);
				match(T__6);
				}
				break;
			case 5:
				_localctx = new Expr1_throwContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(298);
				match(T__17);
				setState(299);
				expr();
				}
				break;
			case 6:
				_localctx = new Expr1_returnContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(300);
				match(T__18);
				setState(302);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(301);
					expr();
					}
					break;
				}
				}
				break;
			case 7:
				_localctx = new Expr1_assignmentContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(313);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(309);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						setState(304);
						simpleExpr();
						}
						break;
					case 2:
						{
						setState(305);
						simpleExpr1(0);
						setState(307);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__8) {
							{
							setState(306);
							match(T__8);
							}
						}

						}
						break;
					}
					setState(311);
					match(T__3);
					}
					break;
				}
				setState(315);
				match(Id);
				setState(316);
				match(T__19);
				setState(317);
				expr();
				}
				break;
			case 8:
				_localctx = new Expr1_assignment2Context(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(318);
				simpleExpr1(0);
				setState(319);
				argumentExprs();
				setState(320);
				match(T__19);
				setState(321);
				expr();
				}
				break;
			case 9:
				_localctx = new Expr1_postfixContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(323);
				postfixExpr();
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(324);
					ascription();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixDefContext extends ParserRuleContext {
		public PrefixDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterPrefixDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitPrefixDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitPrefixDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixDefContext prefixDef() throws RecognitionException {
		PrefixDefContext _localctx = new PrefixDefContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_prefixDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixExprContext extends ParserRuleContext {
		public InfixExprContext infixExpr() {
			return getRuleContext(InfixExprContext.class,0);
		}
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public TerminalNode NL() { return getToken(ScalyParser.NL, 0); }
		public PostfixExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterPostfixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitPostfixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitPostfixExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixExprContext postfixExpr() throws RecognitionException {
		PostfixExprContext _localctx = new PostfixExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_postfixExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			infixExpr(0);
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(332);
				match(Id);
				}
				break;
			}
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(335);
				match(NL);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InfixExprContext extends ParserRuleContext {
		public PrefixExprContext prefixExpr() {
			return getRuleContext(PrefixExprContext.class,0);
		}
		public List<InfixExprContext> infixExpr() {
			return getRuleContexts(InfixExprContext.class);
		}
		public InfixExprContext infixExpr(int i) {
			return getRuleContext(InfixExprContext.class,i);
		}
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public TerminalNode NL() { return getToken(ScalyParser.NL, 0); }
		public InfixExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infixExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterInfixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitInfixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitInfixExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InfixExprContext infixExpr() throws RecognitionException {
		return infixExpr(0);
	}

	private InfixExprContext infixExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InfixExprContext _localctx = new InfixExprContext(_ctx, _parentState);
		InfixExprContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_infixExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(339);
			prefixExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(349);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InfixExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_infixExpr);
					setState(341);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(342);
					match(Id);
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NL) {
						{
						setState(343);
						match(NL);
						}
					}

					setState(346);
					infixExpr(2);
					}
					} 
				}
				setState(351);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrefixExprContext extends ParserRuleContext {
		public SimpleExprContext simpleExpr() {
			return getRuleContext(SimpleExprContext.class,0);
		}
		public SimpleExpr1Context simpleExpr1() {
			return getRuleContext(SimpleExpr1Context.class,0);
		}
		public PrefixDefContext prefixDef() {
			return getRuleContext(PrefixDefContext.class,0);
		}
		public PrefixExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterPrefixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitPrefixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitPrefixExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixExprContext prefixExpr() throws RecognitionException {
		PrefixExprContext _localctx = new PrefixExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_prefixExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(352);
				prefixDef();
				}
				break;
			}
			setState(360);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(355);
				simpleExpr();
				}
				break;
			case 2:
				{
				setState(356);
				simpleExpr1(0);
				setState(358);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(357);
					match(T__8);
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleExprContext extends ParserRuleContext {
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public BlockExprContext blockExpr() {
			return getRuleContext(BlockExprContext.class,0);
		}
		public SimpleExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterSimpleExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitSimpleExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitSimpleExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleExprContext simpleExpr() throws RecognitionException {
		SimpleExprContext _localctx = new SimpleExprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_simpleExpr);
		try {
			setState(365);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(362);
				match(T__23);
				setState(363);
				simpleType();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
				blockExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleExpr1Context extends ParserRuleContext {
		public SimpleExpr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpr1; }
	 
		public SimpleExpr1Context() { }
		public void copyFrom(SimpleExpr1Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleExpr1_underscoreContext extends SimpleExpr1Context {
		public SimpleExpr1_underscoreContext(SimpleExpr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterSimpleExpr1_underscore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitSimpleExpr1_underscore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitSimpleExpr1_underscore(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleExpr1_member1Context extends SimpleExpr1Context {
		public SimpleExprContext simpleExpr() {
			return getRuleContext(SimpleExprContext.class,0);
		}
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public SimpleExpr1_member1Context(SimpleExpr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterSimpleExpr1_member1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitSimpleExpr1_member1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitSimpleExpr1_member1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleExpr1_member2Context extends SimpleExpr1Context {
		public SimpleExpr1Context simpleExpr1() {
			return getRuleContext(SimpleExpr1Context.class,0);
		}
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public SimpleExpr1_member2Context(SimpleExpr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterSimpleExpr1_member2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitSimpleExpr1_member2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitSimpleExpr1_member2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleExpr1_applicationContext extends SimpleExpr1Context {
		public SimpleExpr1Context simpleExpr1() {
			return getRuleContext(SimpleExpr1Context.class,0);
		}
		public ArgumentExprsContext argumentExprs() {
			return getRuleContext(ArgumentExprsContext.class,0);
		}
		public SimpleExpr1_applicationContext(SimpleExpr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterSimpleExpr1_application(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitSimpleExpr1_application(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitSimpleExpr1_application(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleExpr1_stableIDContext extends SimpleExpr1Context {
		public StableIdContext stableId() {
			return getRuleContext(StableIdContext.class,0);
		}
		public SimpleExpr1_stableIDContext(SimpleExpr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterSimpleExpr1_stableID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitSimpleExpr1_stableID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitSimpleExpr1_stableID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleExpr1_bracketsContext extends SimpleExpr1Context {
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public SimpleExpr1_bracketsContext(SimpleExpr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterSimpleExpr1_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitSimpleExpr1_brackets(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitSimpleExpr1_brackets(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleExpr1_literalContext extends SimpleExpr1Context {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public SimpleExpr1_literalContext(SimpleExpr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterSimpleExpr1_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitSimpleExpr1_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitSimpleExpr1_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleExpr1Context simpleExpr1() throws RecognitionException {
		return simpleExpr1(0);
	}

	private SimpleExpr1Context simpleExpr1(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SimpleExpr1Context _localctx = new SimpleExpr1Context(_ctx, _parentState);
		SimpleExpr1Context _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_simpleExpr1, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case BooleanLiteral:
			case CharacterLiteral:
			case SymbolLiteral:
			case IntegerLiteral:
			case StringLiteral:
			case FloatingPointLiteral:
				{
				_localctx = new SimpleExpr1_literalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(368);
				literal();
				}
				break;
			case Id:
				{
				_localctx = new SimpleExpr1_stableIDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(369);
				stableId(0);
				}
				break;
			case T__8:
				{
				_localctx = new SimpleExpr1_underscoreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(370);
				match(T__8);
				}
				break;
			case T__5:
				{
				_localctx = new SimpleExpr1_bracketsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(371);
				match(T__5);
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__5) | (1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral))) != 0)) {
					{
					setState(372);
					exprs();
					}
				}

				setState(375);
				match(T__6);
				}
				break;
			case T__23:
			case T__24:
				{
				_localctx = new SimpleExpr1_member1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(376);
				simpleExpr();
				setState(377);
				match(T__3);
				setState(378);
				match(Id);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(389);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(387);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new SimpleExpr1_member2Context(new SimpleExpr1Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_simpleExpr1);
						setState(382);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(383);
						match(T__3);
						setState(384);
						match(Id);
						}
						break;
					case 2:
						{
						_localctx = new SimpleExpr1_applicationContext(new SimpleExpr1Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_simpleExpr1);
						setState(385);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(386);
						argumentExprs();
						}
						break;
					}
					} 
				}
				setState(391);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterExprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitExprs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitExprs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprsContext exprs() throws RecognitionException {
		ExprsContext _localctx = new ExprsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_exprs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			expr();
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(393);
				match(T__2);
				setState(394);
				expr();
				}
				}
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentExprsContext extends ParserRuleContext {
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public ArgumentExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentExprs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterArgumentExprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitArgumentExprs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitArgumentExprs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentExprsContext argumentExprs() throws RecognitionException {
		ArgumentExprsContext _localctx = new ArgumentExprsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_argumentExprs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			match(T__5);
			setState(402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__5) | (1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral))) != 0)) {
				{
				setState(401);
				exprs();
				}
			}

			setState(404);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockExprContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterBlockExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitBlockExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitBlockExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockExprContext blockExpr() throws RecognitionException {
		BlockExprContext _localctx = new BlockExprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_blockExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			match(T__24);
			setState(407);
			block();
			setState(408);
			match(T__25);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<BlockStatContext> blockStat() {
			return getRuleContexts(BlockStatContext.class);
		}
		public BlockStatContext blockStat(int i) {
			return getRuleContext(BlockStatContext.class,i);
		}
		public ResultExprContext resultExpr() {
			return getRuleContext(ResultExprContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(411); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(410);
					blockStat();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(413); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__5) | (1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral))) != 0)) {
				{
				setState(415);
				resultExpr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatContext extends ParserRuleContext {
		public BlockStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStat; }
	 
		public BlockStatContext() { }
		public void copyFrom(BlockStatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BlockStatExprContext extends BlockStatContext {
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public BlockStatExprContext(BlockStatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterBlockStatExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitBlockStatExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitBlockStatExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStatTmplDefContext extends BlockStatContext {
		public TmplDefContext tmplDef() {
			return getRuleContext(TmplDefContext.class,0);
		}
		public List<LocalModifierContext> localModifier() {
			return getRuleContexts(LocalModifierContext.class);
		}
		public LocalModifierContext localModifier(int i) {
			return getRuleContext(LocalModifierContext.class,i);
		}
		public BlockStatTmplDefContext(BlockStatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterBlockStatTmplDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitBlockStatTmplDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitBlockStatTmplDef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStatDefContext extends BlockStatContext {
		public DefContext def() {
			return getRuleContext(DefContext.class,0);
		}
		public BlockStatDefContext(BlockStatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterBlockStatDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitBlockStatDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitBlockStatDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatContext blockStat() throws RecognitionException {
		BlockStatContext _localctx = new BlockStatContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_blockStat);
		int _la;
		try {
			setState(427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				_localctx = new BlockStatDefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(418);
				def();
				}
				break;
			case 2:
				_localctx = new BlockStatTmplDefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(422);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) {
					{
					{
					setState(419);
					localModifier();
					}
					}
					setState(424);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(425);
				tmplDef();
				}
				break;
			case 3:
				_localctx = new BlockStatExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(426);
				expr1();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResultExprContext extends ParserRuleContext {
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public ResultExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resultExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterResultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitResultExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitResultExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResultExprContext resultExpr() throws RecognitionException {
		ResultExprContext _localctx = new ResultExprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_resultExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			expr1();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatternContext extends ParserRuleContext {
		public List<Pattern1Context> pattern1() {
			return getRuleContexts(Pattern1Context.class);
		}
		public Pattern1Context pattern1(int i) {
			return getRuleContext(Pattern1Context.class,i);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			pattern1();
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__26) {
				{
				{
				setState(432);
				match(T__26);
				setState(433);
				pattern1();
				}
				}
				setState(438);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pattern1Context extends ParserRuleContext {
		public TypePatContext typePat() {
			return getRuleContext(TypePatContext.class,0);
		}
		public TerminalNode BoundVarid() { return getToken(ScalyParser.BoundVarid, 0); }
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public Pattern2Context pattern2() {
			return getRuleContext(Pattern2Context.class,0);
		}
		public Pattern1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterPattern1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitPattern1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitPattern1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pattern1Context pattern1() throws RecognitionException {
		Pattern1Context _localctx = new Pattern1Context(_ctx, getState());
		enterRule(_localctx, 60, RULE_pattern1);
		int _la;
		try {
			setState(443);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(439);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << Id) | (1L << BoundVarid))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(440);
				match(T__7);
				setState(441);
				typePat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(442);
				pattern2();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pattern2Context extends ParserRuleContext {
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public Pattern3Context pattern3() {
			return getRuleContext(Pattern3Context.class,0);
		}
		public Pattern2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterPattern2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitPattern2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitPattern2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pattern2Context pattern2() throws RecognitionException {
		Pattern2Context _localctx = new Pattern2Context(_ctx, getState());
		enterRule(_localctx, 62, RULE_pattern2);
		int _la;
		try {
			setState(451);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(445);
				match(Id);
				setState(448);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__27) {
					{
					setState(446);
					match(T__27);
					setState(447);
					pattern3();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(450);
				pattern3();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pattern3Context extends ParserRuleContext {
		public List<SimplePatternContext> simplePattern() {
			return getRuleContexts(SimplePatternContext.class);
		}
		public SimplePatternContext simplePattern(int i) {
			return getRuleContext(SimplePatternContext.class,i);
		}
		public List<TerminalNode> Id() { return getTokens(ScalyParser.Id); }
		public TerminalNode Id(int i) {
			return getToken(ScalyParser.Id, i);
		}
		public List<TerminalNode> NL() { return getTokens(ScalyParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(ScalyParser.NL, i);
		}
		public Pattern3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterPattern3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitPattern3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitPattern3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pattern3Context pattern3() throws RecognitionException {
		Pattern3Context _localctx = new Pattern3Context(_ctx, getState());
		enterRule(_localctx, 64, RULE_pattern3);
		int _la;
		try {
			setState(465);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(453);
				simplePattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(454);
				simplePattern();
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Id) {
					{
					{
					setState(455);
					match(Id);
					setState(457);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NL) {
						{
						setState(456);
						match(NL);
						}
					}

					setState(459);
					simplePattern();
					}
					}
					setState(464);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimplePatternContext extends ParserRuleContext {
		public TerminalNode Varid() { return getToken(ScalyParser.Varid, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public StableIdContext stableId() {
			return getRuleContext(StableIdContext.class,0);
		}
		public PatternsContext patterns() {
			return getRuleContext(PatternsContext.class,0);
		}
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public SimplePatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simplePattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterSimplePattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitSimplePattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitSimplePattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimplePatternContext simplePattern() throws RecognitionException {
		SimplePatternContext _localctx = new SimplePatternContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_simplePattern);
		int _la;
		try {
			setState(498);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(467);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(468);
				match(Varid);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(469);
				literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(470);
				stableId(0);
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(471);
					match(T__5);
					setState(473);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__5) | (1L << T__8) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral) | (1L << Varid) | (1L << BoundVarid))) != 0)) {
						{
						setState(472);
						patterns();
						}
					}

					setState(475);
					match(T__6);
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(478);
				stableId(0);
				setState(479);
				match(T__5);
				setState(483);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
				case 1:
					{
					setState(480);
					patterns();
					setState(481);
					match(T__2);
					}
					break;
				}
				setState(487);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Id) {
					{
					setState(485);
					match(Id);
					setState(486);
					match(T__27);
					}
				}

				setState(489);
				match(T__8);
				setState(490);
				match(T__9);
				setState(491);
				match(T__6);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(493);
				match(T__5);
				setState(495);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__5) | (1L << T__8) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral) | (1L << Varid) | (1L << BoundVarid))) != 0)) {
					{
					setState(494);
					patterns();
					}
				}

				setState(497);
				match(T__6);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatternsContext extends ParserRuleContext {
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public PatternsContext patterns() {
			return getRuleContext(PatternsContext.class,0);
		}
		public PatternsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patterns; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterPatterns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitPatterns(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitPatterns(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternsContext patterns() throws RecognitionException {
		PatternsContext _localctx = new PatternsContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_patterns);
		try {
			setState(507);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(500);
				pattern();
				setState(503);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
				case 1:
					{
					setState(501);
					match(T__2);
					setState(502);
					patterns();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(505);
				match(T__8);
				setState(506);
				match(T__9);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamClausesContext extends ParserRuleContext {
		public List<ParamClauseContext> paramClause() {
			return getRuleContexts(ParamClauseContext.class);
		}
		public ParamClauseContext paramClause(int i) {
			return getRuleContext(ParamClauseContext.class,i);
		}
		public ParamClausesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramClauses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterParamClauses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitParamClauses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitParamClauses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamClausesContext paramClauses() throws RecognitionException {
		ParamClausesContext _localctx = new ParamClausesContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_paramClauses);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(509);
					paramClause();
					}
					} 
				}
				setState(514);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamClauseContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(ScalyParser.NL, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public ParamClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterParamClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitParamClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitParamClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamClauseContext paramClause() throws RecognitionException {
		ParamClauseContext _localctx = new ParamClauseContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_paramClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(515);
				match(NL);
				}
			}

			setState(518);
			match(T__5);
			setState(520);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Id) {
				{
				setState(519);
				params();
				}
			}

			setState(522);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			param();
			setState(529);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(525);
				match(T__2);
				setState(526);
				param();
				}
				}
				setState(531);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public ParamTypeContext paramType() {
			return getRuleContext(ParamTypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			match(Id);
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(533);
				match(T__7);
				setState(534);
				paramType();
				}
			}

			setState(539);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(537);
				match(T__19);
				setState(538);
				expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamTypeContext extends ParserRuleContext {
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public ParamTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterParamType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitParamType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitParamType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamTypeContext paramType() throws RecognitionException {
		ParamTypeContext _localctx = new ParamTypeContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_paramType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			type_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassParamClausesContext extends ParserRuleContext {
		public List<ClassParamClauseContext> classParamClause() {
			return getRuleContexts(ClassParamClauseContext.class);
		}
		public ClassParamClauseContext classParamClause(int i) {
			return getRuleContext(ClassParamClauseContext.class,i);
		}
		public ClassParamClausesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classParamClauses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterClassParamClauses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitClassParamClauses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitClassParamClauses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassParamClausesContext classParamClauses() throws RecognitionException {
		ClassParamClausesContext _localctx = new ClassParamClausesContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_classParamClauses);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(543);
					classParamClause();
					}
					} 
				}
				setState(548);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassParamClauseContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(ScalyParser.NL, 0); }
		public ClassParamsContext classParams() {
			return getRuleContext(ClassParamsContext.class,0);
		}
		public ClassParamClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classParamClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterClassParamClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitClassParamClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitClassParamClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassParamClauseContext classParamClause() throws RecognitionException {
		ClassParamClauseContext _localctx = new ClassParamClauseContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_classParamClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(549);
				match(NL);
				}
			}

			setState(552);
			match(T__5);
			setState(554);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) {
				{
				setState(553);
				classParams();
				}
			}

			setState(556);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassParamsContext extends ParserRuleContext {
		public List<ClassParamContext> classParam() {
			return getRuleContexts(ClassParamContext.class);
		}
		public ClassParamContext classParam(int i) {
			return getRuleContext(ClassParamContext.class,i);
		}
		public ClassParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterClassParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitClassParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitClassParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassParamsContext classParams() throws RecognitionException {
		ClassParamsContext _localctx = new ClassParamsContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_classParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
			classParam();
			setState(563);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(559);
				match(T__2);
				setState(560);
				classParam();
				}
				}
				setState(565);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassParamContext extends ParserRuleContext {
		public ClassParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classParam; }
	 
		public ClassParamContext() { }
		public void copyFrom(ClassParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassParamValContext extends ClassParamContext {
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public ParamTypeContext paramType() {
			return getRuleContext(ParamTypeContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ClassParamValContext(ClassParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterClassParamVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitClassParamVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitClassParamVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassParamVarContext extends ClassParamContext {
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public ParamTypeContext paramType() {
			return getRuleContext(ParamTypeContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ClassParamVarContext(ClassParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterClassParamVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitClassParamVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitClassParamVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassParamContext classParam() throws RecognitionException {
		ClassParamContext _localctx = new ClassParamContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_classParam);
		int _la;
		try {
			setState(594);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				_localctx = new ClassParamValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(569);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) {
					{
					{
					setState(566);
					modifier();
					}
					}
					setState(571);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(572);
				match(T__28);
				setState(573);
				match(Id);
				setState(574);
				match(T__7);
				setState(575);
				paramType();
				setState(578);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(576);
					match(T__19);
					setState(577);
					expr();
					}
				}

				}
				break;
			case 2:
				_localctx = new ClassParamVarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(583);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) {
					{
					{
					setState(580);
					modifier();
					}
					}
					setState(585);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(586);
				match(T__29);
				setState(587);
				match(Id);
				setState(588);
				match(T__7);
				setState(589);
				paramType();
				setState(592);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(590);
					match(T__19);
					setState(591);
					expr();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BindingsContext extends ParserRuleContext {
		public List<BindingContext> binding() {
			return getRuleContexts(BindingContext.class);
		}
		public BindingContext binding(int i) {
			return getRuleContext(BindingContext.class,i);
		}
		public BindingsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindings; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterBindings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitBindings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitBindings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingsContext bindings() throws RecognitionException {
		BindingsContext _localctx = new BindingsContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_bindings);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596);
			match(T__5);
			setState(597);
			binding();
			setState(602);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(598);
				match(T__2);
				setState(599);
				binding();
				}
				}
				setState(604);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(605);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BindingContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public BindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitBinding(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitBinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingContext binding() throws RecognitionException {
		BindingContext _localctx = new BindingContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_binding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==Id) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(610);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(608);
				match(T__7);
				setState(609);
				type_();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifierContext extends ParserRuleContext {
		public LocalModifierContext localModifier() {
			return getRuleContext(LocalModifierContext.class,0);
		}
		public AccessModifierContext accessModifier() {
			return getRuleContext(AccessModifierContext.class,0);
		}
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_modifier);
		try {
			setState(615);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
			case T__32:
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(612);
				localModifier();
				}
				break;
			case T__34:
			case T__35:
				enterOuterAlt(_localctx, 2);
				{
				setState(613);
				accessModifier();
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 3);
				{
				setState(614);
				match(T__30);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalModifierContext extends ParserRuleContext {
		public LocalModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterLocalModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitLocalModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitLocalModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalModifierContext localModifier() throws RecognitionException {
		LocalModifierContext _localctx = new LocalModifierContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_localModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccessModifierContext extends ParserRuleContext {
		public AccessQualifierContext accessQualifier() {
			return getRuleContext(AccessQualifierContext.class,0);
		}
		public AccessModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterAccessModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitAccessModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitAccessModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessModifierContext accessModifier() throws RecognitionException {
		AccessModifierContext _localctx = new AccessModifierContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_accessModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			_la = _input.LA(1);
			if ( !(_la==T__34 || _la==T__35) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(621);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__36) {
				{
				setState(620);
				accessQualifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccessQualifierContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public AccessQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterAccessQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitAccessQualifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitAccessQualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessQualifierContext accessQualifier() throws RecognitionException {
		AccessQualifierContext _localctx = new AccessQualifierContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_accessQualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			match(T__36);
			setState(624);
			_la = _input.LA(1);
			if ( !(_la==T__37 || _la==Id) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(625);
			match(T__38);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateBodyContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(ScalyParser.NL, 0); }
		public List<TemplateStatContext> templateStat() {
			return getRuleContexts(TemplateStatContext.class);
		}
		public TemplateStatContext templateStat(int i) {
			return getRuleContext(TemplateStatContext.class,i);
		}
		public TemplateBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterTemplateBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitTemplateBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitTemplateBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateBodyContext templateBody() throws RecognitionException {
		TemplateBodyContext _localctx = new TemplateBodyContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_templateBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(627);
				match(NL);
				}
			}

			setState(630);
			match(T__24);
			setState(632); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(631);
				templateStat();
				}
				}
				setState(634); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__5) | (1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral))) != 0) );
			setState(636);
			match(T__25);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateStatContext extends ParserRuleContext {
		public DefContext def() {
			return getRuleContext(DefContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public DclContext dcl() {
			return getRuleContext(DclContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TemplateStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterTemplateStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitTemplateStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitTemplateStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateStatContext templateStat() throws RecognitionException {
		TemplateStatContext _localctx = new TemplateStatContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_templateStat);
		int _la;
		try {
			setState(653);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(641);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) {
					{
					{
					setState(638);
					modifier();
					}
					}
					setState(643);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(644);
				def();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(648);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) {
					{
					{
					setState(645);
					modifier();
					}
					}
					setState(650);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(651);
				dcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(652);
				expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DclContext extends ParserRuleContext {
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
	 
		public DclContext() { }
		public void copyFrom(DclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DclValDclContext extends DclContext {
		public ValDclContext valDcl() {
			return getRuleContext(ValDclContext.class,0);
		}
		public DclValDclContext(DclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterDclValDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitDclValDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitDclValDcl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DclDefDclContext extends DclContext {
		public FunDclContext funDcl() {
			return getRuleContext(FunDclContext.class,0);
		}
		public DclDefDclContext(DclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterDclDefDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitDclDefDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitDclDefDcl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DclVarDclContext extends DclContext {
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public DclVarDclContext(DclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterDclVarDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitDclVarDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitDclVarDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_dcl);
		try {
			setState(661);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				_localctx = new DclValDclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(655);
				match(T__28);
				setState(656);
				valDcl();
				}
				break;
			case T__29:
				_localctx = new DclVarDclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(657);
				match(T__29);
				setState(658);
				varDcl();
				}
				break;
			case T__39:
				_localctx = new DclDefDclContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(659);
				match(T__39);
				setState(660);
				funDcl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValDclContext extends ParserRuleContext {
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public ValDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterValDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitValDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitValDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValDclContext valDcl() throws RecognitionException {
		ValDclContext _localctx = new ValDclContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_valDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(663);
			ids();
			setState(664);
			match(T__7);
			setState(665);
			type_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDclContext extends ParserRuleContext {
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public VarDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterVarDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitVarDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitVarDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDclContext varDcl() throws RecognitionException {
		VarDclContext _localctx = new VarDclContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_varDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(667);
			ids();
			setState(668);
			match(T__7);
			setState(669);
			type_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunDclContext extends ParserRuleContext {
		public FunSigContext funSig() {
			return getRuleContext(FunSigContext.class,0);
		}
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public FunDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterFunDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitFunDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitFunDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunDclContext funDcl() throws RecognitionException {
		FunDclContext _localctx = new FunDclContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_funDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
			funSig();
			setState(674);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(672);
				match(T__7);
				setState(673);
				type_();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunSigContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public ParamClausesContext paramClauses() {
			return getRuleContext(ParamClausesContext.class,0);
		}
		public FunSigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funSig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterFunSig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitFunSig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitFunSig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunSigContext funSig() throws RecognitionException {
		FunSigContext _localctx = new FunSigContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_funSig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(676);
			match(Id);
			setState(677);
			paramClauses();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatVarDefContext extends ParserRuleContext {
		public PatVarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patVarDef; }
	 
		public PatVarDefContext() { }
		public void copyFrom(PatVarDefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PatVarDefVarContext extends PatVarDefContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public PatVarDefVarContext(PatVarDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterPatVarDefVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitPatVarDefVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitPatVarDefVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PatVarDefValContext extends PatVarDefContext {
		public PatDefContext patDef() {
			return getRuleContext(PatDefContext.class,0);
		}
		public PatVarDefValContext(PatVarDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterPatVarDefVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitPatVarDefVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitPatVarDefVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatVarDefContext patVarDef() throws RecognitionException {
		PatVarDefContext _localctx = new PatVarDefContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_patVarDef);
		try {
			setState(683);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				_localctx = new PatVarDefValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(679);
				match(T__28);
				setState(680);
				patDef();
				}
				break;
			case T__29:
				_localctx = new PatVarDefVarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(681);
				match(T__29);
				setState(682);
				varDef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefContext extends ParserRuleContext {
		public PatVarDefContext patVarDef() {
			return getRuleContext(PatVarDefContext.class,0);
		}
		public FunDefContext funDef() {
			return getRuleContext(FunDefContext.class,0);
		}
		public TmplDefContext tmplDef() {
			return getRuleContext(TmplDefContext.class,0);
		}
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_def);
		try {
			setState(689);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				setState(685);
				patVarDef();
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 2);
				{
				setState(686);
				match(T__39);
				setState(687);
				funDef();
				}
				break;
			case T__40:
			case T__41:
				enterOuterAlt(_localctx, 3);
				{
				setState(688);
				tmplDef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatDefContext extends ParserRuleContext {
		public List<Pattern2Context> pattern2() {
			return getRuleContexts(Pattern2Context.class);
		}
		public Pattern2Context pattern2(int i) {
			return getRuleContext(Pattern2Context.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public PatDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterPatDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitPatDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitPatDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatDefContext patDef() throws RecognitionException {
		PatDefContext _localctx = new PatDefContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_patDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(691);
			pattern2();
			setState(696);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(692);
				match(T__2);
				setState(693);
				pattern2();
				}
				}
				setState(698);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(701);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(699);
				match(T__7);
				setState(700);
				type_();
				}
			}

			setState(703);
			match(T__19);
			setState(704);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefContext extends ParserRuleContext {
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_varDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706);
			ids();
			setState(707);
			match(T__7);
			setState(708);
			type_();
			setState(709);
			match(T__19);
			setState(710);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunDefContext extends ParserRuleContext {
		public FunSigContext funSig() {
			return getRuleContext(FunSigContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public FunDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterFunDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitFunDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitFunDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunDefContext funDef() throws RecognitionException {
		FunDefContext _localctx = new FunDefContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_funDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(712);
			funSig();
			setState(715);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(713);
				match(T__7);
				setState(714);
				type_();
				}
			}

			setState(717);
			match(T__19);
			setState(718);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TmplDefContext extends ParserRuleContext {
		public ClassDefContext classDef() {
			return getRuleContext(ClassDefContext.class,0);
		}
		public ObjectDefContext objectDef() {
			return getRuleContext(ObjectDefContext.class,0);
		}
		public TmplDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tmplDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterTmplDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitTmplDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitTmplDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TmplDefContext tmplDef() throws RecognitionException {
		TmplDefContext _localctx = new TmplDefContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_tmplDef);
		try {
			setState(724);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__40:
				enterOuterAlt(_localctx, 1);
				{
				setState(720);
				match(T__40);
				setState(721);
				classDef();
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 2);
				{
				setState(722);
				match(T__41);
				setState(723);
				objectDef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDefContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public ClassParamClausesContext classParamClauses() {
			return getRuleContext(ClassParamClausesContext.class,0);
		}
		public ClassTemplateOptContext classTemplateOpt() {
			return getRuleContext(ClassTemplateOptContext.class,0);
		}
		public AccessModifierContext accessModifier() {
			return getRuleContext(AccessModifierContext.class,0);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_classDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(726);
			match(Id);
			setState(728);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				{
				setState(727);
				accessModifier();
				}
				break;
			}
			setState(730);
			classParamClauses();
			setState(731);
			classTemplateOpt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectDefContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public ClassTemplateOptContext classTemplateOpt() {
			return getRuleContext(ClassTemplateOptContext.class,0);
		}
		public ObjectDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterObjectDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitObjectDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitObjectDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectDefContext objectDef() throws RecognitionException {
		ObjectDefContext _localctx = new ObjectDefContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_objectDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(733);
			match(Id);
			setState(734);
			classTemplateOpt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassTemplateOptContext extends ParserRuleContext {
		public ClassTemplateContext classTemplate() {
			return getRuleContext(ClassTemplateContext.class,0);
		}
		public TemplateBodyContext templateBody() {
			return getRuleContext(TemplateBodyContext.class,0);
		}
		public ClassTemplateOptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classTemplateOpt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterClassTemplateOpt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitClassTemplateOpt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitClassTemplateOpt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassTemplateOptContext classTemplateOpt() throws RecognitionException {
		ClassTemplateOptContext _localctx = new ClassTemplateOptContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_classTemplateOpt);
		int _la;
		try {
			setState(744);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(736);
				match(T__42);
				setState(737);
				classTemplate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(742);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
				case 1:
					{
					setState(739);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__42) {
						{
						setState(738);
						match(T__42);
						}
					}

					setState(741);
					templateBody();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassTemplateContext extends ParserRuleContext {
		public ClassParentsContext classParents() {
			return getRuleContext(ClassParentsContext.class,0);
		}
		public TemplateBodyContext templateBody() {
			return getRuleContext(TemplateBodyContext.class,0);
		}
		public ClassTemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classTemplate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterClassTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitClassTemplate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitClassTemplate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassTemplateContext classTemplate() throws RecognitionException {
		ClassTemplateContext _localctx = new ClassTemplateContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_classTemplate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(746);
			classParents();
			setState(748);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				{
				setState(747);
				templateBody();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassParentsContext extends ParserRuleContext {
		public ConstrContext constr() {
			return getRuleContext(ConstrContext.class,0);
		}
		public ClassParentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classParents; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterClassParents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitClassParents(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitClassParents(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassParentsContext classParents() throws RecognitionException {
		ClassParentsContext _localctx = new ClassParentsContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_classParents);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(750);
			constr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstrContext extends ParserRuleContext {
		public AnnotTypeContext annotType() {
			return getRuleContext(AnnotTypeContext.class,0);
		}
		public List<ArgumentExprsContext> argumentExprs() {
			return getRuleContexts(ArgumentExprsContext.class);
		}
		public ArgumentExprsContext argumentExprs(int i) {
			return getRuleContext(ArgumentExprsContext.class,i);
		}
		public ConstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterConstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitConstr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitConstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstrContext constr() throws RecognitionException {
		ConstrContext _localctx = new ConstrContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_constr);
		try {
			int _alt;
			setState(765);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(752);
				annotType();
				setState(756);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(753);
						argumentExprs();
						}
						} 
					}
					setState(758);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(762);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(759);
						argumentExprs();
						}
						} 
					}
					setState(764);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstrExprContext extends ParserRuleContext {
		public SelfInvocationContext selfInvocation() {
			return getRuleContext(SelfInvocationContext.class,0);
		}
		public ConstrBlockContext constrBlock() {
			return getRuleContext(ConstrBlockContext.class,0);
		}
		public ConstrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constrExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterConstrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitConstrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitConstrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstrExprContext constrExpr() throws RecognitionException {
		ConstrExprContext _localctx = new ConstrExprContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_constrExpr);
		try {
			setState(769);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__37:
				enterOuterAlt(_localctx, 1);
				{
				setState(767);
				selfInvocation();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(768);
				constrBlock();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstrBlockContext extends ParserRuleContext {
		public SelfInvocationContext selfInvocation() {
			return getRuleContext(SelfInvocationContext.class,0);
		}
		public List<BlockStatContext> blockStat() {
			return getRuleContexts(BlockStatContext.class);
		}
		public BlockStatContext blockStat(int i) {
			return getRuleContext(BlockStatContext.class,i);
		}
		public ConstrBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constrBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterConstrBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitConstrBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitConstrBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstrBlockContext constrBlock() throws RecognitionException {
		ConstrBlockContext _localctx = new ConstrBlockContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_constrBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(771);
			match(T__24);
			setState(772);
			selfInvocation();
			setState(776);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__5) | (1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral))) != 0)) {
				{
				{
				setState(773);
				blockStat();
				}
				}
				setState(778);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(779);
			match(T__25);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelfInvocationContext extends ParserRuleContext {
		public List<ArgumentExprsContext> argumentExprs() {
			return getRuleContexts(ArgumentExprsContext.class);
		}
		public ArgumentExprsContext argumentExprs(int i) {
			return getRuleContext(ArgumentExprsContext.class,i);
		}
		public SelfInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selfInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterSelfInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitSelfInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitSelfInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelfInvocationContext selfInvocation() throws RecognitionException {
		SelfInvocationContext _localctx = new SelfInvocationContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_selfInvocation);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(781);
			match(T__37);
			setState(783); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(782);
					argumentExprs();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(785); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return stableId_sempred((StableIdContext)_localctx, predIndex);
		case 19:
			return infixExpr_sempred((InfixExprContext)_localctx, predIndex);
		case 22:
			return simpleExpr1_sempred((SimpleExpr1Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean stableId_sempred(StableIdContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean infixExpr_sempred(InfixExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean simpleExpr1_sempred(SimpleExpr1Context _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3>\u0316\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\3\2\3\2\3\3\6\3\u0096\n\3\r\3\16\3\u0097\3\4\7\4\u009b\n\4\f\4\16"+
		"\4\u009e\13\4\3\4\3\4\3\5\5\5\u00a3\n\5\3\5\3\5\5\5\u00a7\n\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5\u00af\n\5\3\6\3\6\3\6\7\6\u00b4\n\6\f\6\16\6\u00b7"+
		"\13\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00bf\n\7\f\7\16\7\u00c2\13\7\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u00c9\n\b\3\t\3\t\3\t\3\t\3\t\7\t\u00d0\n\t\f\t\16"+
		"\t\u00d3\13\t\5\t\u00d5\n\t\3\t\5\t\u00d8\n\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\5\r\u00e5\n\r\3\16\3\16\3\16\7\16\u00ea\n\16\f"+
		"\16\16\16\u00ed\13\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\5\20\u00f6\n"+
		"\20\3\21\3\21\5\21\u00fa\n\21\3\21\3\21\3\21\5\21\u00ff\n\21\3\22\3\22"+
		"\3\22\3\22\3\22\7\22\u0106\n\22\f\22\16\22\u0109\13\22\3\22\3\22\3\22"+
		"\5\22\u010e\n\22\3\22\3\22\3\22\3\22\3\22\7\22\u0115\n\22\f\22\16\22\u0118"+
		"\13\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0120\n\22\3\22\3\22\5\22\u0124"+
		"\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0131"+
		"\n\22\3\22\3\22\3\22\5\22\u0136\n\22\5\22\u0138\n\22\3\22\3\22\5\22\u013c"+
		"\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0148\n\22"+
		"\5\22\u014a\n\22\3\23\3\23\3\24\3\24\5\24\u0150\n\24\3\24\5\24\u0153\n"+
		"\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u015b\n\25\3\25\7\25\u015e\n\25"+
		"\f\25\16\25\u0161\13\25\3\26\5\26\u0164\n\26\3\26\3\26\3\26\5\26\u0169"+
		"\n\26\5\26\u016b\n\26\3\27\3\27\3\27\5\27\u0170\n\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\5\30\u0178\n\30\3\30\3\30\3\30\3\30\3\30\5\30\u017f\n\30"+
		"\3\30\3\30\3\30\3\30\3\30\7\30\u0186\n\30\f\30\16\30\u0189\13\30\3\31"+
		"\3\31\3\31\7\31\u018e\n\31\f\31\16\31\u0191\13\31\3\32\3\32\5\32\u0195"+
		"\n\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\6\34\u019e\n\34\r\34\16\34\u019f"+
		"\3\34\5\34\u01a3\n\34\3\35\3\35\7\35\u01a7\n\35\f\35\16\35\u01aa\13\35"+
		"\3\35\3\35\5\35\u01ae\n\35\3\36\3\36\3\37\3\37\3\37\7\37\u01b5\n\37\f"+
		"\37\16\37\u01b8\13\37\3 \3 \3 \3 \5 \u01be\n \3!\3!\3!\5!\u01c3\n!\3!"+
		"\5!\u01c6\n!\3\"\3\"\3\"\3\"\5\"\u01cc\n\"\3\"\7\"\u01cf\n\"\f\"\16\""+
		"\u01d2\13\"\5\"\u01d4\n\"\3#\3#\3#\3#\3#\3#\5#\u01dc\n#\3#\5#\u01df\n"+
		"#\3#\3#\3#\3#\3#\5#\u01e6\n#\3#\3#\5#\u01ea\n#\3#\3#\3#\3#\3#\3#\5#\u01f2"+
		"\n#\3#\5#\u01f5\n#\3$\3$\3$\5$\u01fa\n$\3$\3$\5$\u01fe\n$\3%\7%\u0201"+
		"\n%\f%\16%\u0204\13%\3&\5&\u0207\n&\3&\3&\5&\u020b\n&\3&\3&\3\'\3\'\3"+
		"\'\7\'\u0212\n\'\f\'\16\'\u0215\13\'\3(\3(\3(\5(\u021a\n(\3(\3(\5(\u021e"+
		"\n(\3)\3)\3*\7*\u0223\n*\f*\16*\u0226\13*\3+\5+\u0229\n+\3+\3+\5+\u022d"+
		"\n+\3+\3+\3,\3,\3,\7,\u0234\n,\f,\16,\u0237\13,\3-\7-\u023a\n-\f-\16-"+
		"\u023d\13-\3-\3-\3-\3-\3-\3-\5-\u0245\n-\3-\7-\u0248\n-\f-\16-\u024b\13"+
		"-\3-\3-\3-\3-\3-\3-\5-\u0253\n-\5-\u0255\n-\3.\3.\3.\3.\7.\u025b\n.\f"+
		".\16.\u025e\13.\3.\3.\3/\3/\3/\5/\u0265\n/\3\60\3\60\3\60\5\60\u026a\n"+
		"\60\3\61\3\61\3\62\3\62\5\62\u0270\n\62\3\63\3\63\3\63\3\63\3\64\5\64"+
		"\u0277\n\64\3\64\3\64\6\64\u027b\n\64\r\64\16\64\u027c\3\64\3\64\3\65"+
		"\7\65\u0282\n\65\f\65\16\65\u0285\13\65\3\65\3\65\7\65\u0289\n\65\f\65"+
		"\16\65\u028c\13\65\3\65\3\65\5\65\u0290\n\65\3\66\3\66\3\66\3\66\3\66"+
		"\3\66\5\66\u0298\n\66\3\67\3\67\3\67\3\67\38\38\38\38\39\39\39\59\u02a5"+
		"\n9\3:\3:\3:\3;\3;\3;\3;\5;\u02ae\n;\3<\3<\3<\3<\5<\u02b4\n<\3=\3=\3="+
		"\7=\u02b9\n=\f=\16=\u02bc\13=\3=\3=\5=\u02c0\n=\3=\3=\3=\3>\3>\3>\3>\3"+
		">\3>\3?\3?\3?\5?\u02ce\n?\3?\3?\3?\3@\3@\3@\3@\5@\u02d7\n@\3A\3A\5A\u02db"+
		"\nA\3A\3A\3A\3B\3B\3B\3C\3C\3C\5C\u02e6\nC\3C\5C\u02e9\nC\5C\u02eb\nC"+
		"\3D\3D\5D\u02ef\nD\3E\3E\3F\3F\7F\u02f5\nF\fF\16F\u02f8\13F\3F\7F\u02fb"+
		"\nF\fF\16F\u02fe\13F\5F\u0300\nF\3G\3G\5G\u0304\nG\3H\3H\3H\7H\u0309\n"+
		"H\fH\16H\u030c\13H\3H\3H\3I\3I\6I\u0312\nI\rI\16I\u0313\3I\2\5\f(.J\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJL"+
		"NPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e"+
		"\u0090\2\b\4\2\3\3\27\31\5\2\13\13..\66\66\4\2\13\13..\3\2\"$\3\2%&\4"+
		"\2((..\2\u034c\2\u0092\3\2\2\2\4\u0095\3\2\2\2\6\u009c\3\2\2\2\b\u00ae"+
		"\3\2\2\2\n\u00b0\3\2\2\2\f\u00b8\3\2\2\2\16\u00c8\3\2\2\2\20\u00d7\3\2"+
		"\2\2\22\u00d9\3\2\2\2\24\u00db\3\2\2\2\26\u00dd\3\2\2\2\30\u00e4\3\2\2"+
		"\2\32\u00e6\3\2\2\2\34\u00ee\3\2\2\2\36\u00f5\3\2\2\2 \u00fe\3\2\2\2\""+
		"\u0149\3\2\2\2$\u014b\3\2\2\2&\u014d\3\2\2\2(\u0154\3\2\2\2*\u0163\3\2"+
		"\2\2,\u016f\3\2\2\2.\u017e\3\2\2\2\60\u018a\3\2\2\2\62\u0192\3\2\2\2\64"+
		"\u0198\3\2\2\2\66\u019d\3\2\2\28\u01ad\3\2\2\2:\u01af\3\2\2\2<\u01b1\3"+
		"\2\2\2>\u01bd\3\2\2\2@\u01c5\3\2\2\2B\u01d3\3\2\2\2D\u01f4\3\2\2\2F\u01fd"+
		"\3\2\2\2H\u0202\3\2\2\2J\u0206\3\2\2\2L\u020e\3\2\2\2N\u0216\3\2\2\2P"+
		"\u021f\3\2\2\2R\u0224\3\2\2\2T\u0228\3\2\2\2V\u0230\3\2\2\2X\u0254\3\2"+
		"\2\2Z\u0256\3\2\2\2\\\u0261\3\2\2\2^\u0269\3\2\2\2`\u026b\3\2\2\2b\u026d"+
		"\3\2\2\2d\u0271\3\2\2\2f\u0276\3\2\2\2h\u028f\3\2\2\2j\u0297\3\2\2\2l"+
		"\u0299\3\2\2\2n\u029d\3\2\2\2p\u02a1\3\2\2\2r\u02a6\3\2\2\2t\u02ad\3\2"+
		"\2\2v\u02b3\3\2\2\2x\u02b5\3\2\2\2z\u02c4\3\2\2\2|\u02ca\3\2\2\2~\u02d6"+
		"\3\2\2\2\u0080\u02d8\3\2\2\2\u0082\u02df\3\2\2\2\u0084\u02ea\3\2\2\2\u0086"+
		"\u02ec\3\2\2\2\u0088\u02f0\3\2\2\2\u008a\u02ff\3\2\2\2\u008c\u0303\3\2"+
		"\2\2\u008e\u0305\3\2\2\2\u0090\u030f\3\2\2\2\u0092\u0093\5\4\3\2\u0093"+
		"\3\3\2\2\2\u0094\u0096\5\6\4\2\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2"+
		"\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\5\3\2\2\2\u0099\u009b\5"+
		"^\60\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\5~"+
		"@\2\u00a0\7\3\2\2\2\u00a1\u00a3\7\3\2\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00af\7\62\2\2\u00a5\u00a7\7\3\2\2"+
		"\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00af"+
		"\7\64\2\2\u00a9\u00af\7/\2\2\u00aa\u00af\7\60\2\2\u00ab\u00af\7\63\2\2"+
		"\u00ac\u00af\7\61\2\2\u00ad\u00af\7\4\2\2\u00ae\u00a2\3\2\2\2\u00ae\u00a6"+
		"\3\2\2\2\u00ae\u00a9\3\2\2\2\u00ae\u00aa\3\2\2\2\u00ae\u00ab\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af\t\3\2\2\2\u00b0\u00b5\7.\2\2"+
		"\u00b1\u00b2\7\5\2\2\u00b2\u00b4\7.\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b7"+
		"\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\13\3\2\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b8\u00b9\b\7\1\2\u00b9\u00ba\7.\2\2\u00ba\u00c0\3\2"+
		"\2\2\u00bb\u00bc\f\3\2\2\u00bc\u00bd\7\6\2\2\u00bd\u00bf\7.\2\2\u00be"+
		"\u00bb\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2"+
		"\2\2\u00c1\r\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4\5\20\t\2\u00c4\u00c5"+
		"\7\7\2\2\u00c5\u00c6\5\16\b\2\u00c6\u00c9\3\2\2\2\u00c7\u00c9\5\22\n\2"+
		"\u00c8\u00c3\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\17\3\2\2\2\u00ca\u00d8"+
		"\5\22\n\2\u00cb\u00d4\7\b\2\2\u00cc\u00d1\5P)\2\u00cd\u00ce\7\5\2\2\u00ce"+
		"\u00d0\5P)\2\u00cf\u00cd\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2"+
		"\2\u00d1\u00d2\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00cc"+
		"\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\7\t\2\2\u00d7"+
		"\u00ca\3\2\2\2\u00d7\u00cb\3\2\2\2\u00d8\21\3\2\2\2\u00d9\u00da\5\24\13"+
		"\2\u00da\23\3\2\2\2\u00db\u00dc\5\26\f\2\u00dc\25\3\2\2\2\u00dd\u00de"+
		"\5\30\r\2\u00de\27\3\2\2\2\u00df\u00e5\5\f\7\2\u00e0\u00e1\7\b\2\2\u00e1"+
		"\u00e2\5\32\16\2\u00e2\u00e3\7\t\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00df\3"+
		"\2\2\2\u00e4\u00e0\3\2\2\2\u00e5\31\3\2\2\2\u00e6\u00eb\5\16\b\2\u00e7"+
		"\u00e8\7\5\2\2\u00e8\u00ea\5\16\b\2\u00e9\u00e7\3\2\2\2\u00ea\u00ed\3"+
		"\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\33\3\2\2\2\u00ed"+
		"\u00eb\3\2\2\2\u00ee\u00ef\5\16\b\2\u00ef\35\3\2\2\2\u00f0\u00f1\7\n\2"+
		"\2\u00f1\u00f6\5\22\n\2\u00f2\u00f3\7\n\2\2\u00f3\u00f4\7\13\2\2\u00f4"+
		"\u00f6\7\f\2\2\u00f5\u00f0\3\2\2\2\u00f5\u00f2\3\2\2\2\u00f6\37\3\2\2"+
		"\2\u00f7\u00fa\5Z.\2\u00f8\u00fa\7\13\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00f8"+
		"\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\7\7\2\2\u00fc\u00ff\5 \21\2\u00fd"+
		"\u00ff\5\"\22\2\u00fe\u00f9\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff!\3\2\2\2"+
		"\u0100\u0101\7\r\2\2\u0101\u0102\7\b\2\2\u0102\u0103\5 \21\2\u0103\u0107"+
		"\7\t\2\2\u0104\u0106\7:\2\2\u0105\u0104\3\2\2\2\u0106\u0109\3\2\2\2\u0107"+
		"\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u010a\3\2\2\2\u0109\u0107\3\2"+
		"\2\2\u010a\u010d\5 \21\2\u010b\u010c\7\16\2\2\u010c\u010e\5 \21\2\u010d"+
		"\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u014a\3\2\2\2\u010f\u0110\7\17"+
		"\2\2\u0110\u0111\7\b\2\2\u0111\u0112\5 \21\2\u0112\u0116\7\t\2\2\u0113"+
		"\u0115\7:\2\2\u0114\u0113\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2"+
		"\2\2\u0116\u0117\3\2\2\2\u0117\u0119\3\2\2\2\u0118\u0116\3\2\2\2\u0119"+
		"\u011a\5 \21\2\u011a\u014a\3\2\2\2\u011b\u011c\7\20\2\2\u011c\u011f\5"+
		" \21\2\u011d\u011e\7\21\2\2\u011e\u0120\5 \21\2\u011f\u011d\3\2\2\2\u011f"+
		"\u0120\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u0122\7\22\2\2\u0122\u0124\5"+
		" \21\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u014a\3\2\2\2\u0125"+
		"\u0126\7\23\2\2\u0126\u0127\5 \21\2\u0127\u0128\7\17\2\2\u0128\u0129\7"+
		"\b\2\2\u0129\u012a\5 \21\2\u012a\u012b\7\t\2\2\u012b\u014a\3\2\2\2\u012c"+
		"\u012d\7\24\2\2\u012d\u014a\5 \21\2\u012e\u0130\7\25\2\2\u012f\u0131\5"+
		" \21\2\u0130\u012f\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u014a\3\2\2\2\u0132"+
		"\u0138\5,\27\2\u0133\u0135\5.\30\2\u0134\u0136\7\13\2\2\u0135\u0134\3"+
		"\2\2\2\u0135\u0136\3\2\2\2\u0136\u0138\3\2\2\2\u0137\u0132\3\2\2\2\u0137"+
		"\u0133\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013a\7\6\2\2\u013a\u013c\3\2"+
		"\2\2\u013b\u0137\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"\u013e\7.\2\2\u013e\u013f\7\26\2\2\u013f\u014a\5 \21\2\u0140\u0141\5."+
		"\30\2\u0141\u0142\5\62\32\2\u0142\u0143\7\26\2\2\u0143\u0144\5 \21\2\u0144"+
		"\u014a\3\2\2\2\u0145\u0147\5&\24\2\u0146\u0148\5\36\20\2\u0147\u0146\3"+
		"\2\2\2\u0147\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u0100\3\2\2\2\u0149"+
		"\u010f\3\2\2\2\u0149\u011b\3\2\2\2\u0149\u0125\3\2\2\2\u0149\u012c\3\2"+
		"\2\2\u0149\u012e\3\2\2\2\u0149\u013b\3\2\2\2\u0149\u0140\3\2\2\2\u0149"+
		"\u0145\3\2\2\2\u014a#\3\2\2\2\u014b\u014c\t\2\2\2\u014c%\3\2\2\2\u014d"+
		"\u014f\5(\25\2\u014e\u0150\7.\2\2\u014f\u014e\3\2\2\2\u014f\u0150\3\2"+
		"\2\2\u0150\u0152\3\2\2\2\u0151\u0153\7:\2\2\u0152\u0151\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\'\3\2\2\2\u0154\u0155\b\25\1\2\u0155\u0156\5*\26"+
		"\2\u0156\u015f\3\2\2\2\u0157\u0158\f\3\2\2\u0158\u015a\7.\2\2\u0159\u015b"+
		"\7:\2\2\u015a\u0159\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015c\3\2\2\2\u015c"+
		"\u015e\5(\25\4\u015d\u0157\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d\3\2"+
		"\2\2\u015f\u0160\3\2\2\2\u0160)\3\2\2\2\u0161\u015f\3\2\2\2\u0162\u0164"+
		"\5$\23\2\u0163\u0162\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u016a\3\2\2\2\u0165"+
		"\u016b\5,\27\2\u0166\u0168\5.\30\2\u0167\u0169\7\13\2\2\u0168\u0167\3"+
		"\2\2\2\u0168\u0169\3\2\2\2\u0169\u016b\3\2\2\2\u016a\u0165\3\2\2\2\u016a"+
		"\u0166\3\2\2\2\u016b+\3\2\2\2\u016c\u016d\7\32\2\2\u016d\u0170\5\30\r"+
		"\2\u016e\u0170\5\64\33\2\u016f\u016c\3\2\2\2\u016f\u016e\3\2\2\2\u0170"+
		"-\3\2\2\2\u0171\u0172\b\30\1\2\u0172\u017f\5\b\5\2\u0173\u017f\5\f\7\2"+
		"\u0174\u017f\7\13\2\2\u0175\u0177\7\b\2\2\u0176\u0178\5\60\31\2\u0177"+
		"\u0176\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017f\7\t"+
		"\2\2\u017a\u017b\5,\27\2\u017b\u017c\7\6\2\2\u017c\u017d\7.\2\2\u017d"+
		"\u017f\3\2\2\2\u017e\u0171\3\2\2\2\u017e\u0173\3\2\2\2\u017e\u0174\3\2"+
		"\2\2\u017e\u0175\3\2\2\2\u017e\u017a\3\2\2\2\u017f\u0187\3\2\2\2\u0180"+
		"\u0181\f\4\2\2\u0181\u0182\7\6\2\2\u0182\u0186\7.\2\2\u0183\u0184\f\3"+
		"\2\2\u0184\u0186\5\62\32\2\u0185\u0180\3\2\2\2\u0185\u0183\3\2\2\2\u0186"+
		"\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188/\3\2\2\2"+
		"\u0189\u0187\3\2\2\2\u018a\u018f\5 \21\2\u018b\u018c\7\5\2\2\u018c\u018e"+
		"\5 \21\2\u018d\u018b\3\2\2\2\u018e\u0191\3\2\2\2\u018f\u018d\3\2\2\2\u018f"+
		"\u0190\3\2\2\2\u0190\61\3\2\2\2\u0191\u018f\3\2\2\2\u0192\u0194\7\b\2"+
		"\2\u0193\u0195\5\60\31\2\u0194\u0193\3\2\2\2\u0194\u0195\3\2\2\2\u0195"+
		"\u0196\3\2\2\2\u0196\u0197\7\t\2\2\u0197\63\3\2\2\2\u0198\u0199\7\33\2"+
		"\2\u0199\u019a\5\66\34\2\u019a\u019b\7\34\2\2\u019b\65\3\2\2\2\u019c\u019e"+
		"\58\35\2\u019d\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u019d\3\2\2\2\u019f"+
		"\u01a0\3\2\2\2\u01a0\u01a2\3\2\2\2\u01a1\u01a3\5:\36\2\u01a2\u01a1\3\2"+
		"\2\2\u01a2\u01a3\3\2\2\2\u01a3\67\3\2\2\2\u01a4\u01ae\5v<\2\u01a5\u01a7"+
		"\5`\61\2\u01a6\u01a5\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a8"+
		"\u01a9\3\2\2\2\u01a9\u01ab\3\2\2\2\u01aa\u01a8\3\2\2\2\u01ab\u01ae\5~"+
		"@\2\u01ac\u01ae\5\"\22\2\u01ad\u01a4\3\2\2\2\u01ad\u01a8\3\2\2\2\u01ad"+
		"\u01ac\3\2\2\2\u01ae9\3\2\2\2\u01af\u01b0\5\"\22\2\u01b0;\3\2\2\2\u01b1"+
		"\u01b6\5> \2\u01b2\u01b3\7\35\2\2\u01b3\u01b5\5> \2\u01b4\u01b2\3\2\2"+
		"\2\u01b5\u01b8\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7="+
		"\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b9\u01ba\t\3\2\2\u01ba\u01bb\7\n\2\2\u01bb"+
		"\u01be\5\34\17\2\u01bc\u01be\5@!\2\u01bd\u01b9\3\2\2\2\u01bd\u01bc\3\2"+
		"\2\2\u01be?\3\2\2\2\u01bf\u01c2\7.\2\2\u01c0\u01c1\7\36\2\2\u01c1\u01c3"+
		"\5B\"\2\u01c2\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4"+
		"\u01c6\5B\"\2\u01c5\u01bf\3\2\2\2\u01c5\u01c4\3\2\2\2\u01c6A\3\2\2\2\u01c7"+
		"\u01d4\5D#\2\u01c8\u01d0\5D#\2\u01c9\u01cb\7.\2\2\u01ca\u01cc\7:\2\2\u01cb"+
		"\u01ca\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01cf\5D"+
		"#\2\u01ce\u01c9\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0"+
		"\u01d1\3\2\2\2\u01d1\u01d4\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3\u01c7\3\2"+
		"\2\2\u01d3\u01c8\3\2\2\2\u01d4C\3\2\2\2\u01d5\u01f5\7\13\2\2\u01d6\u01f5"+
		"\7\65\2\2\u01d7\u01f5\5\b\5\2\u01d8\u01de\5\f\7\2\u01d9\u01db\7\b\2\2"+
		"\u01da\u01dc\5F$\2\u01db\u01da\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01dd"+
		"\3\2\2\2\u01dd\u01df\7\t\2\2\u01de\u01d9\3\2\2\2\u01de\u01df\3\2\2\2\u01df"+
		"\u01f5\3\2\2\2\u01e0\u01e1\5\f\7\2\u01e1\u01e5\7\b\2\2\u01e2\u01e3\5F"+
		"$\2\u01e3\u01e4\7\5\2\2\u01e4\u01e6\3\2\2\2\u01e5\u01e2\3\2\2\2\u01e5"+
		"\u01e6\3\2\2\2\u01e6\u01e9\3\2\2\2\u01e7\u01e8\7.\2\2\u01e8\u01ea\7\36"+
		"\2\2\u01e9\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb"+
		"\u01ec\7\13\2\2\u01ec\u01ed\7\f\2\2\u01ed\u01ee\7\t\2\2\u01ee\u01f5\3"+
		"\2\2\2\u01ef\u01f1\7\b\2\2\u01f0\u01f2\5F$\2\u01f1\u01f0\3\2\2\2\u01f1"+
		"\u01f2\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f5\7\t\2\2\u01f4\u01d5\3\2"+
		"\2\2\u01f4\u01d6\3\2\2\2\u01f4\u01d7\3\2\2\2\u01f4\u01d8\3\2\2\2\u01f4"+
		"\u01e0\3\2\2\2\u01f4\u01ef\3\2\2\2\u01f5E\3\2\2\2\u01f6\u01f9\5<\37\2"+
		"\u01f7\u01f8\7\5\2\2\u01f8\u01fa\5F$\2\u01f9\u01f7\3\2\2\2\u01f9\u01fa"+
		"\3\2\2\2\u01fa\u01fe\3\2\2\2\u01fb\u01fc\7\13\2\2\u01fc\u01fe\7\f\2\2"+
		"\u01fd\u01f6\3\2\2\2\u01fd\u01fb\3\2\2\2\u01feG\3\2\2\2\u01ff\u0201\5"+
		"J&\2\u0200\u01ff\3\2\2\2\u0201\u0204\3\2\2\2\u0202\u0200\3\2\2\2\u0202"+
		"\u0203\3\2\2\2\u0203I\3\2\2\2\u0204\u0202\3\2\2\2\u0205\u0207\7:\2\2\u0206"+
		"\u0205\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u020a\7\b"+
		"\2\2\u0209\u020b\5L\'\2\u020a\u0209\3\2\2\2\u020a\u020b\3\2\2\2\u020b"+
		"\u020c\3\2\2\2\u020c\u020d\7\t\2\2\u020dK\3\2\2\2\u020e\u0213\5N(\2\u020f"+
		"\u0210\7\5\2\2\u0210\u0212\5N(\2\u0211\u020f\3\2\2\2\u0212\u0215\3\2\2"+
		"\2\u0213\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214M\3\2\2\2\u0215\u0213"+
		"\3\2\2\2\u0216\u0219\7.\2\2\u0217\u0218\7\n\2\2\u0218\u021a\5P)\2\u0219"+
		"\u0217\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021d\3\2\2\2\u021b\u021c\7\26"+
		"\2\2\u021c\u021e\5 \21\2\u021d\u021b\3\2\2\2\u021d\u021e\3\2\2\2\u021e"+
		"O\3\2\2\2\u021f\u0220\5\16\b\2\u0220Q\3\2\2\2\u0221\u0223\5T+\2\u0222"+
		"\u0221\3\2\2\2\u0223\u0226\3\2\2\2\u0224\u0222\3\2\2\2\u0224\u0225\3\2"+
		"\2\2\u0225S\3\2\2\2\u0226\u0224\3\2\2\2\u0227\u0229\7:\2\2\u0228\u0227"+
		"\3\2\2\2\u0228\u0229\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022c\7\b\2\2\u022b"+
		"\u022d\5V,\2\u022c\u022b\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022e\3\2\2"+
		"\2\u022e\u022f\7\t\2\2\u022fU\3\2\2\2\u0230\u0235\5X-\2\u0231\u0232\7"+
		"\5\2\2\u0232\u0234\5X-\2\u0233\u0231\3\2\2\2\u0234\u0237\3\2\2\2\u0235"+
		"\u0233\3\2\2\2\u0235\u0236\3\2\2\2\u0236W\3\2\2\2\u0237\u0235\3\2\2\2"+
		"\u0238\u023a\5^\60\2\u0239\u0238\3\2\2\2\u023a\u023d\3\2\2\2\u023b\u0239"+
		"\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023e\3\2\2\2\u023d\u023b\3\2\2\2\u023e"+
		"\u023f\7\37\2\2\u023f\u0240\7.\2\2\u0240\u0241\7\n\2\2\u0241\u0244\5P"+
		")\2\u0242\u0243\7\26\2\2\u0243\u0245\5 \21\2\u0244\u0242\3\2\2\2\u0244"+
		"\u0245\3\2\2\2\u0245\u0255\3\2\2\2\u0246\u0248\5^\60\2\u0247\u0246\3\2"+
		"\2\2\u0248\u024b\3\2\2\2\u0249\u0247\3\2\2\2\u0249\u024a\3\2\2\2\u024a"+
		"\u024c\3\2\2\2\u024b\u0249\3\2\2\2\u024c\u024d\7 \2\2\u024d\u024e\7.\2"+
		"\2\u024e\u024f\7\n\2\2\u024f\u0252\5P)\2\u0250\u0251\7\26\2\2\u0251\u0253"+
		"\5 \21\2\u0252\u0250\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0255\3\2\2\2\u0254"+
		"\u023b\3\2\2\2\u0254\u0249\3\2\2\2\u0255Y\3\2\2\2\u0256\u0257\7\b\2\2"+
		"\u0257\u025c\5\\/\2\u0258\u0259\7\5\2\2\u0259\u025b\5\\/\2\u025a\u0258"+
		"\3\2\2\2\u025b\u025e\3\2\2\2\u025c\u025a\3\2\2\2\u025c\u025d\3\2\2\2\u025d"+
		"\u025f\3\2\2\2\u025e\u025c\3\2\2\2\u025f\u0260\7\t\2\2\u0260[\3\2\2\2"+
		"\u0261\u0264\t\4\2\2\u0262\u0263\7\n\2\2\u0263\u0265\5\16\b\2\u0264\u0262"+
		"\3\2\2\2\u0264\u0265\3\2\2\2\u0265]\3\2\2\2\u0266\u026a\5`\61\2\u0267"+
		"\u026a\5b\62\2\u0268\u026a\7!\2\2\u0269\u0266\3\2\2\2\u0269\u0267\3\2"+
		"\2\2\u0269\u0268\3\2\2\2\u026a_\3\2\2\2\u026b\u026c\t\5\2\2\u026ca\3\2"+
		"\2\2\u026d\u026f\t\6\2\2\u026e\u0270\5d\63\2\u026f\u026e\3\2\2\2\u026f"+
		"\u0270\3\2\2\2\u0270c\3\2\2\2\u0271\u0272\7\'\2\2\u0272\u0273\t\7\2\2"+
		"\u0273\u0274\7)\2\2\u0274e\3\2\2\2\u0275\u0277\7:\2\2\u0276\u0275\3\2"+
		"\2\2\u0276\u0277\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u027a\7\33\2\2\u0279"+
		"\u027b\5h\65\2\u027a\u0279\3\2\2\2\u027b\u027c\3\2\2\2\u027c\u027a\3\2"+
		"\2\2\u027c\u027d\3\2\2\2\u027d\u027e\3\2\2\2\u027e\u027f\7\34\2\2\u027f"+
		"g\3\2\2\2\u0280\u0282\5^\60\2\u0281\u0280\3\2\2\2\u0282\u0285\3\2\2\2"+
		"\u0283\u0281\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0286\3\2\2\2\u0285\u0283"+
		"\3\2\2\2\u0286\u0290\5v<\2\u0287\u0289\5^\60\2\u0288\u0287\3\2\2\2\u0289"+
		"\u028c\3\2\2\2\u028a\u0288\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u028d\3\2"+
		"\2\2\u028c\u028a\3\2\2\2\u028d\u0290\5j\66\2\u028e\u0290\5 \21\2\u028f"+
		"\u0283\3\2\2\2\u028f\u028a\3\2\2\2\u028f\u028e\3\2\2\2\u0290i\3\2\2\2"+
		"\u0291\u0292\7\37\2\2\u0292\u0298\5l\67\2\u0293\u0294\7 \2\2\u0294\u0298"+
		"\5n8\2\u0295\u0296\7*\2\2\u0296\u0298\5p9\2\u0297\u0291\3\2\2\2\u0297"+
		"\u0293\3\2\2\2\u0297\u0295\3\2\2\2\u0298k\3\2\2\2\u0299\u029a\5\n\6\2"+
		"\u029a\u029b\7\n\2\2\u029b\u029c\5\16\b\2\u029cm\3\2\2\2\u029d\u029e\5"+
		"\n\6\2\u029e\u029f\7\n\2\2\u029f\u02a0\5\16\b\2\u02a0o\3\2\2\2\u02a1\u02a4"+
		"\5r:\2\u02a2\u02a3\7\n\2\2\u02a3\u02a5\5\16\b\2\u02a4\u02a2\3\2\2\2\u02a4"+
		"\u02a5\3\2\2\2\u02a5q\3\2\2\2\u02a6\u02a7\7.\2\2\u02a7\u02a8\5H%\2\u02a8"+
		"s\3\2\2\2\u02a9\u02aa\7\37\2\2\u02aa\u02ae\5x=\2\u02ab\u02ac\7 \2\2\u02ac"+
		"\u02ae\5z>\2\u02ad\u02a9\3\2\2\2\u02ad\u02ab\3\2\2\2\u02aeu\3\2\2\2\u02af"+
		"\u02b4\5t;\2\u02b0\u02b1\7*\2\2\u02b1\u02b4\5|?\2\u02b2\u02b4\5~@\2\u02b3"+
		"\u02af\3\2\2\2\u02b3\u02b0\3\2\2\2\u02b3\u02b2\3\2\2\2\u02b4w\3\2\2\2"+
		"\u02b5\u02ba\5@!\2\u02b6\u02b7\7\5\2\2\u02b7\u02b9\5@!\2\u02b8\u02b6\3"+
		"\2\2\2\u02b9\u02bc\3\2\2\2\u02ba\u02b8\3\2\2\2\u02ba\u02bb\3\2\2\2\u02bb"+
		"\u02bf\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bd\u02be\7\n\2\2\u02be\u02c0\5\16"+
		"\b\2\u02bf\u02bd\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1"+
		"\u02c2\7\26\2\2\u02c2\u02c3\5 \21\2\u02c3y\3\2\2\2\u02c4\u02c5\5\n\6\2"+
		"\u02c5\u02c6\7\n\2\2\u02c6\u02c7\5\16\b\2\u02c7\u02c8\7\26\2\2\u02c8\u02c9"+
		"\7\13\2\2\u02c9{\3\2\2\2\u02ca\u02cd\5r:\2\u02cb\u02cc\7\n\2\2\u02cc\u02ce"+
		"\5\16\b\2\u02cd\u02cb\3\2\2\2\u02cd\u02ce\3\2\2\2\u02ce\u02cf\3\2\2\2"+
		"\u02cf\u02d0\7\26\2\2\u02d0\u02d1\5 \21\2\u02d1}\3\2\2\2\u02d2\u02d3\7"+
		"+\2\2\u02d3\u02d7\5\u0080A\2\u02d4\u02d5\7,\2\2\u02d5\u02d7\5\u0082B\2"+
		"\u02d6\u02d2\3\2\2\2\u02d6\u02d4\3\2\2\2\u02d7\177\3\2\2\2\u02d8\u02da"+
		"\7.\2\2\u02d9\u02db\5b\62\2\u02da\u02d9\3\2\2\2\u02da\u02db\3\2\2\2\u02db"+
		"\u02dc\3\2\2\2\u02dc\u02dd\5R*\2\u02dd\u02de\5\u0084C\2\u02de\u0081\3"+
		"\2\2\2\u02df\u02e0\7.\2\2\u02e0\u02e1\5\u0084C\2\u02e1\u0083\3\2\2\2\u02e2"+
		"\u02e3\7-\2\2\u02e3\u02eb\5\u0086D\2\u02e4\u02e6\7-\2\2\u02e5\u02e4\3"+
		"\2\2\2\u02e5\u02e6\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7\u02e9\5f\64\2\u02e8"+
		"\u02e5\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9\u02eb\3\2\2\2\u02ea\u02e2\3\2"+
		"\2\2\u02ea\u02e8\3\2\2\2\u02eb\u0085\3\2\2\2\u02ec\u02ee\5\u0088E\2\u02ed"+
		"\u02ef\5f\64\2\u02ee\u02ed\3\2\2\2\u02ee\u02ef\3\2\2\2\u02ef\u0087\3\2"+
		"\2\2\u02f0\u02f1\5\u008aF\2\u02f1\u0089\3\2\2\2\u02f2\u02f6\5\26\f\2\u02f3"+
		"\u02f5\5\62\32\2\u02f4\u02f3\3\2\2\2\u02f5\u02f8\3\2\2\2\u02f6\u02f4\3"+
		"\2\2\2\u02f6\u02f7\3\2\2\2\u02f7\u0300\3\2\2\2\u02f8\u02f6\3\2\2\2\u02f9"+
		"\u02fb\5\62\32\2\u02fa\u02f9\3\2\2\2\u02fb\u02fe\3\2\2\2\u02fc\u02fa\3"+
		"\2\2\2\u02fc\u02fd\3\2\2\2\u02fd\u0300\3\2\2\2\u02fe\u02fc\3\2\2\2\u02ff"+
		"\u02f2\3\2\2\2\u02ff\u02fc\3\2\2\2\u0300\u008b\3\2\2\2\u0301\u0304\5\u0090"+
		"I\2\u0302\u0304\5\u008eH\2\u0303\u0301\3\2\2\2\u0303\u0302\3\2\2\2\u0304"+
		"\u008d\3\2\2\2\u0305\u0306\7\33\2\2\u0306\u030a\5\u0090I\2\u0307\u0309"+
		"\58\35\2\u0308\u0307\3\2\2\2\u0309\u030c\3\2\2\2\u030a\u0308\3\2\2\2\u030a"+
		"\u030b\3\2\2\2\u030b\u030d\3\2\2\2\u030c\u030a\3\2\2\2\u030d\u030e\7\34"+
		"\2\2\u030e\u008f\3\2\2\2\u030f\u0311\7(\2\2\u0310\u0312\5\62\32\2\u0311"+
		"\u0310\3\2\2\2\u0312\u0313\3\2\2\2\u0313\u0311\3\2\2\2\u0313\u0314\3\2"+
		"\2\2\u0314\u0091\3\2\2\2i\u0097\u009c\u00a2\u00a6\u00ae\u00b5\u00c0\u00c8"+
		"\u00d1\u00d4\u00d7\u00e4\u00eb\u00f5\u00f9\u00fe\u0107\u010d\u0116\u011f"+
		"\u0123\u0130\u0135\u0137\u013b\u0147\u0149\u014f\u0152\u015a\u015f\u0163"+
		"\u0168\u016a\u016f\u0177\u017e\u0185\u0187\u018f\u0194\u019f\u01a2\u01a8"+
		"\u01ad\u01b6\u01bd\u01c2\u01c5\u01cb\u01d0\u01d3\u01db\u01de\u01e5\u01e9"+
		"\u01f1\u01f4\u01f9\u01fd\u0202\u0206\u020a\u0213\u0219\u021d\u0224\u0228"+
		"\u022c\u0235\u023b\u0244\u0249\u0252\u0254\u025c\u0264\u0269\u026f\u0276"+
		"\u027c\u0283\u028a\u028f\u0297\u02a4\u02ad\u02b3\u02ba\u02bf\u02cd\u02d6"+
		"\u02da\u02e5\u02e8\u02ea\u02ee\u02f6\u02fc\u02ff\u0303\u030a\u0313";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}