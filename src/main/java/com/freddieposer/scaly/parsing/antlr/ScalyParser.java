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
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		Id=46, BooleanLiteral=47, CharacterLiteral=48, SymbolLiteral=49, IntegerLiteral=50, 
		StringLiteral=51, FloatingPointLiteral=52, Varid=53, BoundVarid=54, Paren=55, 
		Delim=56, Semi=57, NL=58, NEWLINE=59, WS=60, COMMENT=61, LINE_COMMENT=62;
	public static final int
		RULE_compilationUnit = 0, RULE_topStatSeq = 1, RULE_topStat = 2, RULE_literal = 3, 
		RULE_ids = 4, RULE_stableId = 5, RULE_type_ = 6, RULE_functionArgTypes = 7, 
		RULE_infixType = 8, RULE_compoundType = 9, RULE_simpleType = 10, RULE_types = 11, 
		RULE_refinement = 12, RULE_refineStat = 13, RULE_typePat = 14, RULE_ascription = 15, 
		RULE_expr = 16, RULE_expr1 = 17, RULE_prefixDef = 18, RULE_postfixExpr = 19, 
		RULE_infixExpr = 20, RULE_prefixExpr = 21, RULE_simpleExpr = 22, RULE_simpleExpr1 = 23, 
		RULE_exprs = 24, RULE_argumentExprs = 25, RULE_blockExpr = 26, RULE_block = 27, 
		RULE_blockStat = 28, RULE_resultExpr = 29, RULE_pattern = 30, RULE_pattern1 = 31, 
		RULE_pattern2 = 32, RULE_pattern3 = 33, RULE_simplePattern = 34, RULE_patterns = 35, 
		RULE_paramClauses = 36, RULE_paramClause = 37, RULE_params = 38, RULE_param = 39, 
		RULE_paramType = 40, RULE_classParamClauses = 41, RULE_classParamClause = 42, 
		RULE_classParams = 43, RULE_classParam = 44, RULE_bindings = 45, RULE_binding = 46, 
		RULE_modifier = 47, RULE_localModifier = 48, RULE_accessModifier = 49, 
		RULE_accessQualifier = 50, RULE_templateBody = 51, RULE_templateStat = 52, 
		RULE_dcl = 53, RULE_valDcl = 54, RULE_varDcl = 55, RULE_funDcl = 56, RULE_funSig = 57, 
		RULE_patVarDef = 58, RULE_def = 59, RULE_patDef = 60, RULE_varDef = 61, 
		RULE_funDef = 62, RULE_tmplDef = 63, RULE_classDef = 64, RULE_objectDef = 65, 
		RULE_classTemplateOpt = 66, RULE_classTemplate = 67, RULE_classParents = 68, 
		RULE_constr = 69, RULE_constrExpr = 70, RULE_constrBlock = 71, RULE_selfInvocation = 72;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "topStatSeq", "topStat", "literal", "ids", "stableId", 
			"type_", "functionArgTypes", "infixType", "compoundType", "simpleType", 
			"types", "refinement", "refineStat", "typePat", "ascription", "expr", 
			"expr1", "prefixDef", "postfixExpr", "infixExpr", "prefixExpr", "simpleExpr", 
			"simpleExpr1", "exprs", "argumentExprs", "blockExpr", "block", "blockStat", 
			"resultExpr", "pattern", "pattern1", "pattern2", "pattern3", "simplePattern", 
			"patterns", "paramClauses", "paramClause", "params", "param", "paramType", 
			"classParamClauses", "classParamClause", "classParams", "classParam", 
			"bindings", "binding", "modifier", "localModifier", "accessModifier", 
			"accessQualifier", "templateBody", "templateStat", "dcl", "valDcl", "varDcl", 
			"funDcl", "funSig", "patVarDef", "def", "patDef", "varDef", "funDef", 
			"tmplDef", "classDef", "objectDef", "classTemplateOpt", "classTemplate", 
			"classParents", "constr", "constrExpr", "constrBlock", "selfInvocation"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-'", "'null'", "','", "'.'", "'this'", "'super'", "'=>'", "'('", 
			"')'", "'type'", "'{'", "'}'", "':'", "'_'", "'*'", "'if'", "'else'", 
			"'while'", "'try'", "'catch'", "'finally'", "'do'", "'throw'", "'return'", 
			"'='", "'+'", "'~'", "'!'", "'new'", "'|'", "'@'", "'val'", "'var'", 
			"'override'", "'abstract'", "'final'", "'sealed'", "'private'", "'protected'", 
			"'['", "']'", "'def'", "'class'", "'object'", "'extends'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "Id", "BooleanLiteral", 
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
			setState(146);
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
			setState(149); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(148);
				topStat();
				}
				}
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__42) | (1L << T__43))) != 0) );
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
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) {
				{
				{
				setState(153);
				modifier();
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(159);
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
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new Literal_intContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(161);
					match(T__0);
					}
				}

				setState(164);
				match(IntegerLiteral);
				}
				break;
			case 2:
				_localctx = new Literal_floatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(165);
					match(T__0);
					}
				}

				setState(168);
				match(FloatingPointLiteral);
				}
				break;
			case 3:
				_localctx = new Literal_boolContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				match(BooleanLiteral);
				}
				break;
			case 4:
				_localctx = new Literal_charContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				match(CharacterLiteral);
				}
				break;
			case 5:
				_localctx = new Literal_stringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(171);
				match(StringLiteral);
				}
				break;
			case 6:
				_localctx = new Literal_symbolContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(172);
				match(SymbolLiteral);
				}
				break;
			case 7:
				_localctx = new Literal_nullContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(173);
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
			setState(176);
			match(Id);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(177);
				match(T__2);
				setState(178);
				match(Id);
				}
				}
				setState(183);
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
		public List<TerminalNode> Id() { return getTokens(ScalyParser.Id); }
		public TerminalNode Id(int i) {
			return getToken(ScalyParser.Id, i);
		}
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(185);
				match(Id);
				}
				break;
			case 2:
				{
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Id) {
					{
					setState(186);
					match(Id);
					setState(187);
					match(T__3);
					}
				}

				setState(194);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
					{
					setState(190);
					match(T__4);
					}
					break;
				case T__5:
					{
					setState(191);
					match(T__5);
					setState(192);
					match(T__3);
					setState(193);
					match(Id);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(203);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StableIdContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stableId);
					setState(198);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(199);
					match(T__3);
					setState(200);
					match(Id);
					}
					} 
				}
				setState(205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				functionArgTypes();
				setState(207);
				match(T__6);
				setState(208);
				type_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
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
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case NL:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				infixType();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				match(T__7);
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__10) | (1L << NL))) != 0)) {
					{
					setState(215);
					paramType();
					setState(220);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(216);
						match(T__2);
						setState(217);
						paramType();
						}
						}
						setState(222);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(225);
				match(T__8);
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

	public static class InfixTypeContext extends ParserRuleContext {
		public List<CompoundTypeContext> compoundType() {
			return getRuleContexts(CompoundTypeContext.class);
		}
		public CompoundTypeContext compoundType(int i) {
			return getRuleContext(CompoundTypeContext.class,i);
		}
		public List<TerminalNode> Id() { return getTokens(ScalyParser.Id); }
		public TerminalNode Id(int i) {
			return getToken(ScalyParser.Id, i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			compoundType();
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(229);
					match(Id);
					setState(230);
					compoundType();
					}
					} 
				}
				setState(235);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class CompoundTypeContext extends ParserRuleContext {
		public RefinementContext refinement() {
			return getRuleContext(RefinementContext.class,0);
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
			setState(236);
			refinement();
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
		enterRule(_localctx, 20, RULE_simpleType);
		int _la;
		try {
			setState(247);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				stableId(0);
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(239);
					match(T__3);
					setState(240);
					match(T__9);
					}
				}

				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				match(T__7);
				setState(244);
				types();
				setState(245);
				match(T__8);
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
		enterRule(_localctx, 22, RULE_types);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			type_();
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(250);
				match(T__2);
				setState(251);
				type_();
				}
				}
				setState(256);
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

	public static class RefinementContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(ScalyParser.NL, 0); }
		public List<RefineStatContext> refineStat() {
			return getRuleContexts(RefineStatContext.class);
		}
		public RefineStatContext refineStat(int i) {
			return getRuleContext(RefineStatContext.class,i);
		}
		public RefinementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refinement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterRefinement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitRefinement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitRefinement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefinementContext refinement() throws RecognitionException {
		RefinementContext _localctx = new RefinementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_refinement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(257);
				match(NL);
				}
			}

			setState(260);
			match(T__10);
			setState(262); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(261);
				refineStat();
				}
				}
				setState(264); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__41))) != 0) );
			setState(266);
			match(T__11);
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

	public static class RefineStatContext extends ParserRuleContext {
		public DclContext dcl() {
			return getRuleContext(DclContext.class,0);
		}
		public RefineStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refineStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterRefineStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitRefineStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitRefineStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefineStatContext refineStat() throws RecognitionException {
		RefineStatContext _localctx = new RefineStatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_refineStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			dcl();
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
		enterRule(_localctx, 28, RULE_typePat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
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
		enterRule(_localctx, 30, RULE_ascription);
		try {
			setState(277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				match(T__12);
				setState(273);
				infixType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
				match(T__12);
				setState(275);
				match(T__13);
				setState(276);
				match(T__14);
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
		enterRule(_localctx, 32, RULE_expr);
		try {
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__7:
					{
					setState(279);
					bindings();
					}
					break;
				case T__13:
					{
					setState(280);
					match(T__13);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(283);
				match(T__6);
				setState(284);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
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
		enterRule(_localctx, 34, RULE_expr1);
		int _la;
		try {
			setState(361);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new Expr1_ifContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				match(T__15);
				setState(289);
				match(T__7);
				setState(290);
				expr();
				setState(291);
				match(T__8);
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(292);
					match(NL);
					}
					}
					setState(297);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(298);
				expr();
				setState(301);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(299);
					match(T__16);
					setState(300);
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
				setState(303);
				match(T__17);
				setState(304);
				match(T__7);
				setState(305);
				expr();
				setState(306);
				match(T__8);
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(307);
					match(NL);
					}
					}
					setState(312);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(313);
				expr();
				}
				break;
			case 3:
				_localctx = new Expr1_tryContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(315);
				match(T__18);
				setState(316);
				expr();
				setState(319);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(317);
					match(T__19);
					setState(318);
					expr();
					}
					break;
				}
				setState(323);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(321);
					match(T__20);
					setState(322);
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
				setState(325);
				match(T__21);
				setState(326);
				expr();
				setState(327);
				match(T__17);
				setState(328);
				match(T__7);
				setState(329);
				expr();
				setState(330);
				match(T__8);
				}
				break;
			case 5:
				_localctx = new Expr1_throwContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(332);
				match(T__22);
				setState(333);
				expr();
				}
				break;
			case 6:
				_localctx = new Expr1_returnContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(334);
				match(T__23);
				setState(336);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(335);
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
				setState(347);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(343);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						setState(338);
						simpleExpr();
						}
						break;
					case 2:
						{
						setState(339);
						simpleExpr1(0);
						setState(341);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__13) {
							{
							setState(340);
							match(T__13);
							}
						}

						}
						break;
					}
					setState(345);
					match(T__3);
					}
					break;
				}
				setState(349);
				match(Id);
				setState(350);
				match(T__24);
				setState(351);
				expr();
				}
				break;
			case 8:
				_localctx = new Expr1_assignment2Context(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(352);
				simpleExpr1(0);
				setState(353);
				argumentExprs();
				setState(354);
				match(T__24);
				setState(355);
				expr();
				}
				break;
			case 9:
				_localctx = new Expr1_postfixContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(357);
				postfixExpr();
				setState(359);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(358);
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
		enterRule(_localctx, 36, RULE_prefixDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__25) | (1L << T__26) | (1L << T__27))) != 0)) ) {
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
		public List<PrefixDefContext> prefixDef() {
			return getRuleContexts(PrefixDefContext.class);
		}
		public PrefixDefContext prefixDef(int i) {
			return getRuleContext(PrefixDefContext.class,i);
		}
		public List<SimpleExpr1Context> simpleExpr1() {
			return getRuleContexts(SimpleExpr1Context.class);
		}
		public SimpleExpr1Context simpleExpr1(int i) {
			return getRuleContext(SimpleExpr1Context.class,i);
		}
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
		enterRule(_localctx, 38, RULE_postfixExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			infixExpr(0);
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(366);
				match(Id);
				}
				break;
			}
			setState(374);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(369);
					prefixDef();
					setState(370);
					simpleExpr1(0);
					}
					} 
				}
				setState(376);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(377);
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_infixExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(381);
			prefixExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(391);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InfixExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_infixExpr);
					setState(383);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(384);
					match(Id);
					setState(386);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NL) {
						{
						setState(385);
						match(NL);
						}
					}

					setState(388);
					infixExpr(2);
					}
					} 
				}
				setState(393);
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
		enterRule(_localctx, 42, RULE_prefixExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(394);
				prefixDef();
				}
				break;
			}
			setState(402);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(397);
				simpleExpr();
				}
				break;
			case 2:
				{
				setState(398);
				simpleExpr1(0);
				setState(400);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(399);
					match(T__13);
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
		public ClassTemplateContext classTemplate() {
			return getRuleContext(ClassTemplateContext.class,0);
		}
		public TemplateBodyContext templateBody() {
			return getRuleContext(TemplateBodyContext.class,0);
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
		enterRule(_localctx, 44, RULE_simpleExpr);
		try {
			setState(410);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(404);
				match(T__28);
				setState(407);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(405);
					classTemplate();
					}
					break;
				case 2:
					{
					setState(406);
					templateBody();
					}
					break;
				}
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(409);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_simpleExpr1, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
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

				setState(413);
				literal();
				}
				break;
			case T__4:
			case T__5:
			case Id:
				{
				_localctx = new SimpleExpr1_stableIDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(414);
				stableId(0);
				}
				break;
			case T__13:
				{
				_localctx = new SimpleExpr1_underscoreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(415);
				match(T__13);
				}
				break;
			case T__7:
				{
				_localctx = new SimpleExpr1_bracketsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(416);
				match(T__7);
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral))) != 0)) {
					{
					setState(417);
					exprs();
					}
				}

				setState(420);
				match(T__8);
				}
				break;
			case T__10:
			case T__28:
				{
				_localctx = new SimpleExpr1_member1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(421);
				simpleExpr();
				setState(422);
				match(T__3);
				setState(423);
				match(Id);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(437);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(435);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
					case 1:
						{
						_localctx = new SimpleExpr1_member2Context(new SimpleExpr1Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_simpleExpr1);
						setState(427);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(429);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__13) {
							{
							setState(428);
							match(T__13);
							}
						}

						setState(431);
						match(T__3);
						setState(432);
						match(Id);
						}
						break;
					case 2:
						{
						_localctx = new SimpleExpr1_applicationContext(new SimpleExpr1Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_simpleExpr1);
						setState(433);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(434);
						argumentExprs();
						}
						break;
					}
					} 
				}
				setState(439);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
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
		enterRule(_localctx, 48, RULE_exprs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			expr();
			setState(445);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(441);
					match(T__2);
					setState(442);
					expr();
					}
					} 
				}
				setState(447);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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
		public PostfixExprContext postfixExpr() {
			return getRuleContext(PostfixExprContext.class,0);
		}
		public BlockExprContext blockExpr() {
			return getRuleContext(BlockExprContext.class,0);
		}
		public TerminalNode NL() { return getToken(ScalyParser.NL, 0); }
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
		enterRule(_localctx, 50, RULE_argumentExprs);
		int _la;
		try {
			setState(469);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(448);
				match(T__7);
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral))) != 0)) {
					{
					setState(449);
					exprs();
					}
				}

				setState(452);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(453);
				match(T__7);
				setState(457);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(454);
					exprs();
					setState(455);
					match(T__2);
					}
					break;
				}
				setState(459);
				postfixExpr();
				setState(460);
				match(T__12);
				setState(461);
				match(T__13);
				setState(462);
				match(T__14);
				setState(463);
				match(T__8);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(466);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(465);
					match(NL);
					}
				}

				setState(468);
				blockExpr();
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
		enterRule(_localctx, 52, RULE_blockExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			match(T__10);
			setState(472);
			block();
			setState(473);
			match(T__11);
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
		enterRule(_localctx, 54, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(476); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(475);
					blockStat();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(478); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral))) != 0)) {
				{
				setState(480);
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
		public DefContext def() {
			return getRuleContext(DefContext.class,0);
		}
		public TmplDefContext tmplDef() {
			return getRuleContext(TmplDefContext.class,0);
		}
		public List<LocalModifierContext> localModifier() {
			return getRuleContexts(LocalModifierContext.class);
		}
		public LocalModifierContext localModifier(int i) {
			return getRuleContext(LocalModifierContext.class,i);
		}
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public BlockStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterBlockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitBlockStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitBlockStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatContext blockStat() throws RecognitionException {
		BlockStatContext _localctx = new BlockStatContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_blockStat);
		int _la;
		try {
			setState(492);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(483);
				def();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(487);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36))) != 0)) {
					{
					{
					setState(484);
					localModifier();
					}
					}
					setState(489);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(490);
				tmplDef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(491);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BindingsContext bindings() {
			return getRuleContext(BindingsContext.class,0);
		}
		public CompoundTypeContext compoundType() {
			return getRuleContext(CompoundTypeContext.class,0);
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
		enterRule(_localctx, 58, RULE_resultExpr);
		try {
			setState(504);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(494);
				expr1();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(499);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__7:
					{
					setState(495);
					bindings();
					}
					break;
				case T__13:
					{
					setState(496);
					match(T__13);
					setState(497);
					match(T__12);
					setState(498);
					compoundType();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(501);
				match(T__6);
				setState(502);
				block();
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
		enterRule(_localctx, 60, RULE_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			pattern1();
			setState(511);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__29) {
				{
				{
				setState(507);
				match(T__29);
				setState(508);
				pattern1();
				}
				}
				setState(513);
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
		enterRule(_localctx, 62, RULE_pattern1);
		int _la;
		try {
			setState(518);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(514);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << Id) | (1L << BoundVarid))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(515);
				match(T__12);
				setState(516);
				typePat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(517);
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
		enterRule(_localctx, 64, RULE_pattern2);
		int _la;
		try {
			setState(526);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(520);
				match(Id);
				setState(523);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__30) {
					{
					setState(521);
					match(T__30);
					setState(522);
					pattern3();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(525);
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
		enterRule(_localctx, 66, RULE_pattern3);
		int _la;
		try {
			setState(540);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(528);
				simplePattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(529);
				simplePattern();
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Id) {
					{
					{
					setState(530);
					match(Id);
					setState(532);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NL) {
						{
						setState(531);
						match(NL);
						}
					}

					setState(534);
					simplePattern();
					}
					}
					setState(539);
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
		enterRule(_localctx, 68, RULE_simplePattern);
		int _la;
		try {
			setState(573);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(542);
				match(T__13);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(543);
				match(Varid);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(544);
				literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(545);
				stableId(0);
				setState(551);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(546);
					match(T__7);
					setState(548);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__13) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral) | (1L << Varid) | (1L << BoundVarid))) != 0)) {
						{
						setState(547);
						patterns();
						}
					}

					setState(550);
					match(T__8);
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(553);
				stableId(0);
				setState(554);
				match(T__7);
				setState(558);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
				case 1:
					{
					setState(555);
					patterns();
					setState(556);
					match(T__2);
					}
					break;
				}
				setState(562);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Id) {
					{
					setState(560);
					match(Id);
					setState(561);
					match(T__30);
					}
				}

				setState(564);
				match(T__13);
				setState(565);
				match(T__14);
				setState(566);
				match(T__8);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(568);
				match(T__7);
				setState(570);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__13) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral) | (1L << Varid) | (1L << BoundVarid))) != 0)) {
					{
					setState(569);
					patterns();
					}
				}

				setState(572);
				match(T__8);
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
		enterRule(_localctx, 70, RULE_patterns);
		try {
			setState(582);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(575);
				pattern();
				setState(578);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
				case 1:
					{
					setState(576);
					match(T__2);
					setState(577);
					patterns();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(580);
				match(T__13);
				setState(581);
				match(T__14);
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
		enterRule(_localctx, 72, RULE_paramClauses);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(584);
					paramClause();
					}
					} 
				}
				setState(589);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
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
		enterRule(_localctx, 74, RULE_paramClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(590);
				match(NL);
				}
			}

			setState(593);
			match(T__7);
			setState(595);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Id) {
				{
				setState(594);
				params();
				}
			}

			setState(597);
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
		enterRule(_localctx, 76, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			param();
			setState(604);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(600);
				match(T__2);
				setState(601);
				param();
				}
				}
				setState(606);
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
		enterRule(_localctx, 78, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			match(Id);
			setState(610);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(608);
				match(T__12);
				setState(609);
				paramType();
				}
			}

			setState(614);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(612);
				match(T__24);
				setState(613);
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
		enterRule(_localctx, 80, RULE_paramType);
		try {
			setState(622);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(616);
				type_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(617);
				match(T__6);
				setState(618);
				type_();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(619);
				type_();
				setState(620);
				match(T__14);
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
		enterRule(_localctx, 82, RULE_classParamClauses);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(624);
					classParamClause();
					}
					} 
				}
				setState(629);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
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
		enterRule(_localctx, 84, RULE_classParamClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(631);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(630);
				match(NL);
				}
			}

			setState(633);
			match(T__7);
			setState(635);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << Id))) != 0)) {
				{
				setState(634);
				classParams();
				}
			}

			setState(637);
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
		enterRule(_localctx, 86, RULE_classParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(639);
			classParam();
			setState(644);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(640);
				match(T__2);
				setState(641);
				classParam();
				}
				}
				setState(646);
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
		public ClassParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterClassParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitClassParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitClassParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassParamContext classParam() throws RecognitionException {
		ClassParamContext _localctx = new ClassParamContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_classParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(650);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) {
				{
				{
				setState(647);
				modifier();
				}
				}
				setState(652);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(654);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__31 || _la==T__32) {
				{
				setState(653);
				_la = _input.LA(1);
				if ( !(_la==T__31 || _la==T__32) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(656);
			match(Id);
			setState(657);
			match(T__12);
			setState(658);
			paramType();
			setState(661);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(659);
				match(T__24);
				setState(660);
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
		enterRule(_localctx, 90, RULE_bindings);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(663);
			match(T__7);
			setState(664);
			binding();
			setState(669);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(665);
				match(T__2);
				setState(666);
				binding();
				}
				}
				setState(671);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(672);
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
		enterRule(_localctx, 92, RULE_binding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==Id) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(677);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(675);
				match(T__12);
				setState(676);
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
		enterRule(_localctx, 94, RULE_modifier);
		try {
			setState(682);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__34:
			case T__35:
			case T__36:
				enterOuterAlt(_localctx, 1);
				{
				setState(679);
				localModifier();
				}
				break;
			case T__37:
			case T__38:
				enterOuterAlt(_localctx, 2);
				{
				setState(680);
				accessModifier();
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 3);
				{
				setState(681);
				match(T__33);
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
		enterRule(_localctx, 96, RULE_localModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(684);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36))) != 0)) ) {
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
		enterRule(_localctx, 98, RULE_accessModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(686);
			_la = _input.LA(1);
			if ( !(_la==T__37 || _la==T__38) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(688);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__39) {
				{
				setState(687);
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
		enterRule(_localctx, 100, RULE_accessQualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(690);
			match(T__39);
			setState(691);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==Id) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(692);
			match(T__40);
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
		enterRule(_localctx, 102, RULE_templateBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(695);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(694);
				match(NL);
				}
			}

			setState(697);
			match(T__10);
			setState(699); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(698);
				templateStat();
				}
				}
				setState(701); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral))) != 0) );
			setState(703);
			match(T__11);
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
		enterRule(_localctx, 104, RULE_templateStat);
		int _la;
		try {
			setState(720);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(708);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) {
					{
					{
					setState(705);
					modifier();
					}
					}
					setState(710);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(711);
				def();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(715);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) {
					{
					{
					setState(712);
					modifier();
					}
					}
					setState(717);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(718);
				dcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(719);
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
		public ValDclContext valDcl() {
			return getRuleContext(ValDclContext.class,0);
		}
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public FunDclContext funDcl() {
			return getRuleContext(FunDclContext.class,0);
		}
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_dcl);
		try {
			setState(728);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
				enterOuterAlt(_localctx, 1);
				{
				setState(722);
				match(T__31);
				setState(723);
				valDcl();
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 2);
				{
				setState(724);
				match(T__32);
				setState(725);
				varDcl();
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 3);
				{
				setState(726);
				match(T__41);
				setState(727);
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
		enterRule(_localctx, 108, RULE_valDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			ids();
			setState(731);
			match(T__12);
			setState(732);
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
		enterRule(_localctx, 110, RULE_varDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(734);
			ids();
			setState(735);
			match(T__12);
			setState(736);
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
		enterRule(_localctx, 112, RULE_funDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(738);
			funSig();
			setState(741);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(739);
				match(T__12);
				setState(740);
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
		enterRule(_localctx, 114, RULE_funSig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(743);
			match(Id);
			setState(744);
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
		public PatDefContext patDef() {
			return getRuleContext(PatDefContext.class,0);
		}
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public PatVarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patVarDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterPatVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitPatVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitPatVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatVarDefContext patVarDef() throws RecognitionException {
		PatVarDefContext _localctx = new PatVarDefContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_patVarDef);
		try {
			setState(750);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
				enterOuterAlt(_localctx, 1);
				{
				setState(746);
				match(T__31);
				setState(747);
				patDef();
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 2);
				{
				setState(748);
				match(T__32);
				setState(749);
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
		enterRule(_localctx, 118, RULE_def);
		try {
			setState(756);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(752);
				patVarDef();
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 2);
				{
				setState(753);
				match(T__41);
				setState(754);
				funDef();
				}
				break;
			case T__42:
			case T__43:
				enterOuterAlt(_localctx, 3);
				{
				setState(755);
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
		enterRule(_localctx, 120, RULE_patDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(758);
			pattern2();
			setState(763);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(759);
				match(T__2);
				setState(760);
				pattern2();
				}
				}
				setState(765);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(768);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(766);
				match(T__12);
				setState(767);
				type_();
				}
			}

			setState(770);
			match(T__24);
			setState(771);
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
		enterRule(_localctx, 122, RULE_varDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(773);
			ids();
			setState(774);
			match(T__12);
			setState(775);
			type_();
			setState(776);
			match(T__24);
			setState(777);
			match(T__13);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode NL() { return getToken(ScalyParser.NL, 0); }
		public ParamClauseContext paramClause() {
			return getRuleContext(ParamClauseContext.class,0);
		}
		public ParamClausesContext paramClauses() {
			return getRuleContext(ParamClausesContext.class,0);
		}
		public ConstrExprContext constrExpr() {
			return getRuleContext(ConstrExprContext.class,0);
		}
		public ConstrBlockContext constrBlock() {
			return getRuleContext(ConstrBlockContext.class,0);
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
		enterRule(_localctx, 124, RULE_funDef);
		int _la;
		try {
			setState(806);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(779);
				funSig();
				setState(782);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(780);
					match(T__12);
					setState(781);
					type_();
					}
				}

				setState(784);
				match(T__24);
				setState(785);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(787);
				funSig();
				setState(789);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(788);
					match(NL);
					}
				}

				setState(791);
				match(T__10);
				setState(792);
				block();
				setState(793);
				match(T__11);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(795);
				match(T__4);
				setState(796);
				paramClause();
				setState(797);
				paramClauses();
				setState(804);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__24:
					{
					setState(798);
					match(T__24);
					setState(799);
					constrExpr();
					}
					break;
				case T__10:
				case NL:
					{
					setState(801);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NL) {
						{
						setState(800);
						match(NL);
						}
					}

					setState(803);
					constrBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
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
		enterRule(_localctx, 126, RULE_tmplDef);
		try {
			setState(812);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__42:
				enterOuterAlt(_localctx, 1);
				{
				setState(808);
				match(T__42);
				setState(809);
				classDef();
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 2);
				{
				setState(810);
				match(T__43);
				setState(811);
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
		enterRule(_localctx, 128, RULE_classDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(814);
			match(Id);
			setState(816);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				{
				setState(815);
				accessModifier();
				}
				break;
			}
			setState(818);
			classParamClauses();
			setState(819);
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
		enterRule(_localctx, 130, RULE_objectDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(821);
			match(Id);
			setState(822);
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
		enterRule(_localctx, 132, RULE_classTemplateOpt);
		int _la;
		try {
			setState(832);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(824);
				match(T__44);
				setState(825);
				classTemplate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(830);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
				case 1:
					{
					setState(827);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__44) {
						{
						setState(826);
						match(T__44);
						}
					}

					setState(829);
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
		enterRule(_localctx, 134, RULE_classTemplate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(834);
			classParents();
			setState(836);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				{
				setState(835);
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
		enterRule(_localctx, 136, RULE_classParents);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(838);
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
		enterRule(_localctx, 138, RULE_constr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(843);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(840);
					argumentExprs();
					}
					} 
				}
				setState(845);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
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
		enterRule(_localctx, 140, RULE_constrExpr);
		try {
			setState(848);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(846);
				selfInvocation();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(847);
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
		enterRule(_localctx, 142, RULE_constrBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(850);
			match(T__10);
			setState(851);
			selfInvocation();
			setState(855);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__31) | (1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral))) != 0)) {
				{
				{
				setState(852);
				blockStat();
				}
				}
				setState(857);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(858);
			match(T__11);
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
		enterRule(_localctx, 144, RULE_selfInvocation);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(860);
			match(T__4);
			setState(862); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(861);
					argumentExprs();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(864); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
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
		case 20:
			return infixExpr_sempred((InfixExprContext)_localctx, predIndex);
		case 23:
			return simpleExpr1_sempred((SimpleExpr1Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean stableId_sempred(StableIdContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u0365\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\3\2\3\2\3\3\6\3\u0098\n\3\r\3\16\3\u0099\3\4\7\4\u009d\n\4\f"+
		"\4\16\4\u00a0\13\4\3\4\3\4\3\5\5\5\u00a5\n\5\3\5\3\5\5\5\u00a9\n\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5\u00b1\n\5\3\6\3\6\3\6\7\6\u00b6\n\6\f\6\16\6"+
		"\u00b9\13\6\3\7\3\7\3\7\3\7\5\7\u00bf\n\7\3\7\3\7\3\7\3\7\5\7\u00c5\n"+
		"\7\5\7\u00c7\n\7\3\7\3\7\3\7\7\7\u00cc\n\7\f\7\16\7\u00cf\13\7\3\b\3\b"+
		"\3\b\3\b\3\b\5\b\u00d6\n\b\3\t\3\t\3\t\3\t\3\t\7\t\u00dd\n\t\f\t\16\t"+
		"\u00e0\13\t\5\t\u00e2\n\t\3\t\5\t\u00e5\n\t\3\n\3\n\3\n\7\n\u00ea\n\n"+
		"\f\n\16\n\u00ed\13\n\3\13\3\13\3\f\3\f\3\f\5\f\u00f4\n\f\3\f\3\f\3\f\3"+
		"\f\5\f\u00fa\n\f\3\r\3\r\3\r\7\r\u00ff\n\r\f\r\16\r\u0102\13\r\3\16\5"+
		"\16\u0105\n\16\3\16\3\16\6\16\u0109\n\16\r\16\16\16\u010a\3\16\3\16\3"+
		"\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\5\21\u0118\n\21\3\22\3\22"+
		"\5\22\u011c\n\22\3\22\3\22\3\22\5\22\u0121\n\22\3\23\3\23\3\23\3\23\3"+
		"\23\7\23\u0128\n\23\f\23\16\23\u012b\13\23\3\23\3\23\3\23\5\23\u0130\n"+
		"\23\3\23\3\23\3\23\3\23\3\23\7\23\u0137\n\23\f\23\16\23\u013a\13\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\5\23\u0142\n\23\3\23\3\23\5\23\u0146\n\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0153\n\23"+
		"\3\23\3\23\3\23\5\23\u0158\n\23\5\23\u015a\n\23\3\23\3\23\5\23\u015e\n"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u016a\n\23"+
		"\5\23\u016c\n\23\3\24\3\24\3\25\3\25\5\25\u0172\n\25\3\25\3\25\3\25\7"+
		"\25\u0177\n\25\f\25\16\25\u017a\13\25\3\25\5\25\u017d\n\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\5\26\u0185\n\26\3\26\7\26\u0188\n\26\f\26\16\26\u018b"+
		"\13\26\3\27\5\27\u018e\n\27\3\27\3\27\3\27\5\27\u0193\n\27\5\27\u0195"+
		"\n\27\3\30\3\30\3\30\5\30\u019a\n\30\3\30\5\30\u019d\n\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\5\31\u01a5\n\31\3\31\3\31\3\31\3\31\3\31\5\31\u01ac"+
		"\n\31\3\31\3\31\5\31\u01b0\n\31\3\31\3\31\3\31\3\31\7\31\u01b6\n\31\f"+
		"\31\16\31\u01b9\13\31\3\32\3\32\3\32\7\32\u01be\n\32\f\32\16\32\u01c1"+
		"\13\32\3\33\3\33\5\33\u01c5\n\33\3\33\3\33\3\33\3\33\3\33\5\33\u01cc\n"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u01d5\n\33\3\33\5\33\u01d8"+
		"\n\33\3\34\3\34\3\34\3\34\3\35\6\35\u01df\n\35\r\35\16\35\u01e0\3\35\5"+
		"\35\u01e4\n\35\3\36\3\36\7\36\u01e8\n\36\f\36\16\36\u01eb\13\36\3\36\3"+
		"\36\5\36\u01ef\n\36\3\37\3\37\3\37\3\37\3\37\5\37\u01f6\n\37\3\37\3\37"+
		"\3\37\5\37\u01fb\n\37\3 \3 \3 \7 \u0200\n \f \16 \u0203\13 \3!\3!\3!\3"+
		"!\5!\u0209\n!\3\"\3\"\3\"\5\"\u020e\n\"\3\"\5\"\u0211\n\"\3#\3#\3#\3#"+
		"\5#\u0217\n#\3#\7#\u021a\n#\f#\16#\u021d\13#\5#\u021f\n#\3$\3$\3$\3$\3"+
		"$\3$\5$\u0227\n$\3$\5$\u022a\n$\3$\3$\3$\3$\3$\5$\u0231\n$\3$\3$\5$\u0235"+
		"\n$\3$\3$\3$\3$\3$\3$\5$\u023d\n$\3$\5$\u0240\n$\3%\3%\3%\5%\u0245\n%"+
		"\3%\3%\5%\u0249\n%\3&\7&\u024c\n&\f&\16&\u024f\13&\3\'\5\'\u0252\n\'\3"+
		"\'\3\'\5\'\u0256\n\'\3\'\3\'\3(\3(\3(\7(\u025d\n(\f(\16(\u0260\13(\3)"+
		"\3)\3)\5)\u0265\n)\3)\3)\5)\u0269\n)\3*\3*\3*\3*\3*\3*\5*\u0271\n*\3+"+
		"\7+\u0274\n+\f+\16+\u0277\13+\3,\5,\u027a\n,\3,\3,\5,\u027e\n,\3,\3,\3"+
		"-\3-\3-\7-\u0285\n-\f-\16-\u0288\13-\3.\7.\u028b\n.\f.\16.\u028e\13.\3"+
		".\5.\u0291\n.\3.\3.\3.\3.\3.\5.\u0298\n.\3/\3/\3/\3/\7/\u029e\n/\f/\16"+
		"/\u02a1\13/\3/\3/\3\60\3\60\3\60\5\60\u02a8\n\60\3\61\3\61\3\61\5\61\u02ad"+
		"\n\61\3\62\3\62\3\63\3\63\5\63\u02b3\n\63\3\64\3\64\3\64\3\64\3\65\5\65"+
		"\u02ba\n\65\3\65\3\65\6\65\u02be\n\65\r\65\16\65\u02bf\3\65\3\65\3\66"+
		"\7\66\u02c5\n\66\f\66\16\66\u02c8\13\66\3\66\3\66\7\66\u02cc\n\66\f\66"+
		"\16\66\u02cf\13\66\3\66\3\66\5\66\u02d3\n\66\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\5\67\u02db\n\67\38\38\38\38\39\39\39\39\3:\3:\3:\5:\u02e8\n:\3;"+
		"\3;\3;\3<\3<\3<\3<\5<\u02f1\n<\3=\3=\3=\3=\5=\u02f7\n=\3>\3>\3>\7>\u02fc"+
		"\n>\f>\16>\u02ff\13>\3>\3>\5>\u0303\n>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3@\3"+
		"@\3@\5@\u0311\n@\3@\3@\3@\3@\3@\5@\u0318\n@\3@\3@\3@\3@\3@\3@\3@\3@\3"+
		"@\3@\5@\u0324\n@\3@\5@\u0327\n@\5@\u0329\n@\3A\3A\3A\3A\5A\u032f\nA\3"+
		"B\3B\5B\u0333\nB\3B\3B\3B\3C\3C\3C\3D\3D\3D\5D\u033e\nD\3D\5D\u0341\n"+
		"D\5D\u0343\nD\3E\3E\5E\u0347\nE\3F\3F\3G\7G\u034c\nG\fG\16G\u034f\13G"+
		"\3H\3H\5H\u0353\nH\3I\3I\3I\7I\u0358\nI\fI\16I\u035b\13I\3I\3I\3J\3J\6"+
		"J\u0361\nJ\rJ\16J\u0362\3J\2\5\f*\60K\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\2\t\4\2\3\3\34"+
		"\36\5\2\20\20\60\6088\3\2\"#\4\2\20\20\60\60\3\2%\'\3\2()\4\2\7\7\60\60"+
		"\2\u03ad\2\u0094\3\2\2\2\4\u0097\3\2\2\2\6\u009e\3\2\2\2\b\u00b0\3\2\2"+
		"\2\n\u00b2\3\2\2\2\f\u00c6\3\2\2\2\16\u00d5\3\2\2\2\20\u00e4\3\2\2\2\22"+
		"\u00e6\3\2\2\2\24\u00ee\3\2\2\2\26\u00f9\3\2\2\2\30\u00fb\3\2\2\2\32\u0104"+
		"\3\2\2\2\34\u010e\3\2\2\2\36\u0110\3\2\2\2 \u0117\3\2\2\2\"\u0120\3\2"+
		"\2\2$\u016b\3\2\2\2&\u016d\3\2\2\2(\u016f\3\2\2\2*\u017e\3\2\2\2,\u018d"+
		"\3\2\2\2.\u019c\3\2\2\2\60\u01ab\3\2\2\2\62\u01ba\3\2\2\2\64\u01d7\3\2"+
		"\2\2\66\u01d9\3\2\2\28\u01de\3\2\2\2:\u01ee\3\2\2\2<\u01fa\3\2\2\2>\u01fc"+
		"\3\2\2\2@\u0208\3\2\2\2B\u0210\3\2\2\2D\u021e\3\2\2\2F\u023f\3\2\2\2H"+
		"\u0248\3\2\2\2J\u024d\3\2\2\2L\u0251\3\2\2\2N\u0259\3\2\2\2P\u0261\3\2"+
		"\2\2R\u0270\3\2\2\2T\u0275\3\2\2\2V\u0279\3\2\2\2X\u0281\3\2\2\2Z\u028c"+
		"\3\2\2\2\\\u0299\3\2\2\2^\u02a4\3\2\2\2`\u02ac\3\2\2\2b\u02ae\3\2\2\2"+
		"d\u02b0\3\2\2\2f\u02b4\3\2\2\2h\u02b9\3\2\2\2j\u02d2\3\2\2\2l\u02da\3"+
		"\2\2\2n\u02dc\3\2\2\2p\u02e0\3\2\2\2r\u02e4\3\2\2\2t\u02e9\3\2\2\2v\u02f0"+
		"\3\2\2\2x\u02f6\3\2\2\2z\u02f8\3\2\2\2|\u0307\3\2\2\2~\u0328\3\2\2\2\u0080"+
		"\u032e\3\2\2\2\u0082\u0330\3\2\2\2\u0084\u0337\3\2\2\2\u0086\u0342\3\2"+
		"\2\2\u0088\u0344\3\2\2\2\u008a\u0348\3\2\2\2\u008c\u034d\3\2\2\2\u008e"+
		"\u0352\3\2\2\2\u0090\u0354\3\2\2\2\u0092\u035e\3\2\2\2\u0094\u0095\5\4"+
		"\3\2\u0095\3\3\2\2\2\u0096\u0098\5\6\4\2\u0097\u0096\3\2\2\2\u0098\u0099"+
		"\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\5\3\2\2\2\u009b"+
		"\u009d\5`\61\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1"+
		"\u00a2\5\u0080A\2\u00a2\7\3\2\2\2\u00a3\u00a5\7\3\2\2\u00a4\u00a3\3\2"+
		"\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00b1\7\64\2\2\u00a7"+
		"\u00a9\7\3\2\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2"+
		"\2\2\u00aa\u00b1\7\66\2\2\u00ab\u00b1\7\61\2\2\u00ac\u00b1\7\62\2\2\u00ad"+
		"\u00b1\7\65\2\2\u00ae\u00b1\7\63\2\2\u00af\u00b1\7\4\2\2\u00b0\u00a4\3"+
		"\2\2\2\u00b0\u00a8\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b0\u00ac\3\2\2\2\u00b0"+
		"\u00ad\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\t\3\2\2\2"+
		"\u00b2\u00b7\7\60\2\2\u00b3\u00b4\7\5\2\2\u00b4\u00b6\7\60\2\2\u00b5\u00b3"+
		"\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\13\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bb\b\7\1\2\u00bb\u00c7\7\60\2"+
		"\2\u00bc\u00bd\7\60\2\2\u00bd\u00bf\7\6\2\2\u00be\u00bc\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00c4\3\2\2\2\u00c0\u00c5\7\7\2\2\u00c1\u00c2\7\b"+
		"\2\2\u00c2\u00c3\7\6\2\2\u00c3\u00c5\7\60\2\2\u00c4\u00c0\3\2\2\2\u00c4"+
		"\u00c1\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00ba\3\2\2\2\u00c6\u00be\3\2"+
		"\2\2\u00c7\u00cd\3\2\2\2\u00c8\u00c9\f\4\2\2\u00c9\u00ca\7\6\2\2\u00ca"+
		"\u00cc\7\60\2\2\u00cb\u00c8\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3"+
		"\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\r\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1"+
		"\5\20\t\2\u00d1\u00d2\7\t\2\2\u00d2\u00d3\5\16\b\2\u00d3\u00d6\3\2\2\2"+
		"\u00d4\u00d6\5\22\n\2\u00d5\u00d0\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\17"+
		"\3\2\2\2\u00d7\u00e5\5\22\n\2\u00d8\u00e1\7\n\2\2\u00d9\u00de\5R*\2\u00da"+
		"\u00db\7\5\2\2\u00db\u00dd\5R*\2\u00dc\u00da\3\2\2\2\u00dd\u00e0\3\2\2"+
		"\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de"+
		"\3\2\2\2\u00e1\u00d9\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00e5\7\13\2\2\u00e4\u00d7\3\2\2\2\u00e4\u00d8\3\2\2\2\u00e5\21\3\2\2"+
		"\2\u00e6\u00eb\5\24\13\2\u00e7\u00e8\7\60\2\2\u00e8\u00ea\5\24\13\2\u00e9"+
		"\u00e7\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2"+
		"\2\2\u00ec\23\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\5\32\16\2\u00ef"+
		"\25\3\2\2\2\u00f0\u00f3\5\f\7\2\u00f1\u00f2\7\6\2\2\u00f2\u00f4\7\f\2"+
		"\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00fa\3\2\2\2\u00f5\u00f6"+
		"\7\n\2\2\u00f6\u00f7\5\30\r\2\u00f7\u00f8\7\13\2\2\u00f8\u00fa\3\2\2\2"+
		"\u00f9\u00f0\3\2\2\2\u00f9\u00f5\3\2\2\2\u00fa\27\3\2\2\2\u00fb\u0100"+
		"\5\16\b\2\u00fc\u00fd\7\5\2\2\u00fd\u00ff\5\16\b\2\u00fe\u00fc\3\2\2\2"+
		"\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\31"+
		"\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0105\7<\2\2\u0104\u0103\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\7\r\2\2\u0107\u0109\5\34"+
		"\17\2\u0108\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u0108\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\7\16\2\2\u010d\33\3\2\2"+
		"\2\u010e\u010f\5l\67\2\u010f\35\3\2\2\2\u0110\u0111\5\16\b\2\u0111\37"+
		"\3\2\2\2\u0112\u0113\7\17\2\2\u0113\u0118\5\22\n\2\u0114\u0115\7\17\2"+
		"\2\u0115\u0116\7\20\2\2\u0116\u0118\7\21\2\2\u0117\u0112\3\2\2\2\u0117"+
		"\u0114\3\2\2\2\u0118!\3\2\2\2\u0119\u011c\5\\/\2\u011a\u011c\7\20\2\2"+
		"\u011b\u0119\3\2\2\2\u011b\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e"+
		"\7\t\2\2\u011e\u0121\5\"\22\2\u011f\u0121\5$\23\2\u0120\u011b\3\2\2\2"+
		"\u0120\u011f\3\2\2\2\u0121#\3\2\2\2\u0122\u0123\7\22\2\2\u0123\u0124\7"+
		"\n\2\2\u0124\u0125\5\"\22\2\u0125\u0129\7\13\2\2\u0126\u0128\7<\2\2\u0127"+
		"\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2"+
		"\2\2\u012a\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012f\5\"\22\2\u012d"+
		"\u012e\7\23\2\2\u012e\u0130\5\"\22\2\u012f\u012d\3\2\2\2\u012f\u0130\3"+
		"\2\2\2\u0130\u016c\3\2\2\2\u0131\u0132\7\24\2\2\u0132\u0133\7\n\2\2\u0133"+
		"\u0134\5\"\22\2\u0134\u0138\7\13\2\2\u0135\u0137\7<\2\2\u0136\u0135\3"+
		"\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\u013b\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013c\5\"\22\2\u013c\u016c\3"+
		"\2\2\2\u013d\u013e\7\25\2\2\u013e\u0141\5\"\22\2\u013f\u0140\7\26\2\2"+
		"\u0140\u0142\5\"\22\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0145"+
		"\3\2\2\2\u0143\u0144\7\27\2\2\u0144\u0146\5\"\22\2\u0145\u0143\3\2\2\2"+
		"\u0145\u0146\3\2\2\2\u0146\u016c\3\2\2\2\u0147\u0148\7\30\2\2\u0148\u0149"+
		"\5\"\22\2\u0149\u014a\7\24\2\2\u014a\u014b\7\n\2\2\u014b\u014c\5\"\22"+
		"\2\u014c\u014d\7\13\2\2\u014d\u016c\3\2\2\2\u014e\u014f\7\31\2\2\u014f"+
		"\u016c\5\"\22\2\u0150\u0152\7\32\2\2\u0151\u0153\5\"\22\2\u0152\u0151"+
		"\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u016c\3\2\2\2\u0154\u015a\5.\30\2\u0155"+
		"\u0157\5\60\31\2\u0156\u0158\7\20\2\2\u0157\u0156\3\2\2\2\u0157\u0158"+
		"\3\2\2\2\u0158\u015a\3\2\2\2\u0159\u0154\3\2\2\2\u0159\u0155\3\2\2\2\u015a"+
		"\u015b\3\2\2\2\u015b\u015c\7\6\2\2\u015c\u015e\3\2\2\2\u015d\u0159\3\2"+
		"\2\2\u015d\u015e\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\7\60\2\2\u0160"+
		"\u0161\7\33\2\2\u0161\u016c\5\"\22\2\u0162\u0163\5\60\31\2\u0163\u0164"+
		"\5\64\33\2\u0164\u0165\7\33\2\2\u0165\u0166\5\"\22\2\u0166\u016c\3\2\2"+
		"\2\u0167\u0169\5(\25\2\u0168\u016a\5 \21\2\u0169\u0168\3\2\2\2\u0169\u016a"+
		"\3\2\2\2\u016a\u016c\3\2\2\2\u016b\u0122\3\2\2\2\u016b\u0131\3\2\2\2\u016b"+
		"\u013d\3\2\2\2\u016b\u0147\3\2\2\2\u016b\u014e\3\2\2\2\u016b\u0150\3\2"+
		"\2\2\u016b\u015d\3\2\2\2\u016b\u0162\3\2\2\2\u016b\u0167\3\2\2\2\u016c"+
		"%\3\2\2\2\u016d\u016e\t\2\2\2\u016e\'\3\2\2\2\u016f\u0171\5*\26\2\u0170"+
		"\u0172\7\60\2\2\u0171\u0170\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0178\3"+
		"\2\2\2\u0173\u0174\5&\24\2\u0174\u0175\5\60\31\2\u0175\u0177\3\2\2\2\u0176"+
		"\u0173\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2"+
		"\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017b\u017d\7<\2\2\u017c"+
		"\u017b\3\2\2\2\u017c\u017d\3\2\2\2\u017d)\3\2\2\2\u017e\u017f\b\26\1\2"+
		"\u017f\u0180\5,\27\2\u0180\u0189\3\2\2\2\u0181\u0182\f\3\2\2\u0182\u0184"+
		"\7\60\2\2\u0183\u0185\7<\2\2\u0184\u0183\3\2\2\2\u0184\u0185\3\2\2\2\u0185"+
		"\u0186\3\2\2\2\u0186\u0188\5*\26\4\u0187\u0181\3\2\2\2\u0188\u018b\3\2"+
		"\2\2\u0189\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a+\3\2\2\2\u018b\u0189"+
		"\3\2\2\2\u018c\u018e\5&\24\2\u018d\u018c\3\2\2\2\u018d\u018e\3\2\2\2\u018e"+
		"\u0194\3\2\2\2\u018f\u0195\5.\30\2\u0190\u0192\5\60\31\2\u0191\u0193\7"+
		"\20\2\2\u0192\u0191\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0195\3\2\2\2\u0194"+
		"\u018f\3\2\2\2\u0194\u0190\3\2\2\2\u0195-\3\2\2\2\u0196\u0199\7\37\2\2"+
		"\u0197\u019a\5\u0088E\2\u0198\u019a\5h\65\2\u0199\u0197\3\2\2\2\u0199"+
		"\u0198\3\2\2\2\u019a\u019d\3\2\2\2\u019b\u019d\5\66\34\2\u019c\u0196\3"+
		"\2\2\2\u019c\u019b\3\2\2\2\u019d/\3\2\2\2\u019e\u019f\b\31\1\2\u019f\u01ac"+
		"\5\b\5\2\u01a0\u01ac\5\f\7\2\u01a1\u01ac\7\20\2\2\u01a2\u01a4\7\n\2\2"+
		"\u01a3\u01a5\5\62\32\2\u01a4\u01a3\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6"+
		"\3\2\2\2\u01a6\u01ac\7\13\2\2\u01a7\u01a8\5.\30\2\u01a8\u01a9\7\6\2\2"+
		"\u01a9\u01aa\7\60\2\2\u01aa\u01ac\3\2\2\2\u01ab\u019e\3\2\2\2\u01ab\u01a0"+
		"\3\2\2\2\u01ab\u01a1\3\2\2\2\u01ab\u01a2\3\2\2\2\u01ab\u01a7\3\2\2\2\u01ac"+
		"\u01b7\3\2\2\2\u01ad\u01af\f\4\2\2\u01ae\u01b0\7\20\2\2\u01af\u01ae\3"+
		"\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b2\7\6\2\2\u01b2"+
		"\u01b6\7\60\2\2\u01b3\u01b4\f\3\2\2\u01b4\u01b6\5\64\33\2\u01b5\u01ad"+
		"\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01b9\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7"+
		"\u01b8\3\2\2\2\u01b8\61\3\2\2\2\u01b9\u01b7\3\2\2\2\u01ba\u01bf\5\"\22"+
		"\2\u01bb\u01bc\7\5\2\2\u01bc\u01be\5\"\22\2\u01bd\u01bb\3\2\2\2\u01be"+
		"\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\63\3\2\2"+
		"\2\u01c1\u01bf\3\2\2\2\u01c2\u01c4\7\n\2\2\u01c3\u01c5\5\62\32\2\u01c4"+
		"\u01c3\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01d8\7\13"+
		"\2\2\u01c7\u01cb\7\n\2\2\u01c8\u01c9\5\62\32\2\u01c9\u01ca\7\5\2\2\u01ca"+
		"\u01cc\3\2\2\2\u01cb\u01c8\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01cd\3\2"+
		"\2\2\u01cd\u01ce\5(\25\2\u01ce\u01cf\7\17\2\2\u01cf\u01d0\7\20\2\2\u01d0"+
		"\u01d1\7\21\2\2\u01d1\u01d2\7\13\2\2\u01d2\u01d8\3\2\2\2\u01d3\u01d5\7"+
		"<\2\2\u01d4\u01d3\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6"+
		"\u01d8\5\66\34\2\u01d7\u01c2\3\2\2\2\u01d7\u01c7\3\2\2\2\u01d7\u01d4\3"+
		"\2\2\2\u01d8\65\3\2\2\2\u01d9\u01da\7\r\2\2\u01da\u01db\58\35\2\u01db"+
		"\u01dc\7\16\2\2\u01dc\67\3\2\2\2\u01dd\u01df\5:\36\2\u01de\u01dd\3\2\2"+
		"\2\u01df\u01e0\3\2\2\2\u01e0\u01de\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e3"+
		"\3\2\2\2\u01e2\u01e4\5<\37\2\u01e3\u01e2\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4"+
		"9\3\2\2\2\u01e5\u01ef\5x=\2\u01e6\u01e8\5b\62\2\u01e7\u01e6\3\2\2\2\u01e8"+
		"\u01eb\3\2\2\2\u01e9\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01ec\3\2"+
		"\2\2\u01eb\u01e9\3\2\2\2\u01ec\u01ef\5\u0080A\2\u01ed\u01ef\5$\23\2\u01ee"+
		"\u01e5\3\2\2\2\u01ee\u01e9\3\2\2\2\u01ee\u01ed\3\2\2\2\u01ef;\3\2\2\2"+
		"\u01f0\u01fb\5$\23\2\u01f1\u01f6\5\\/\2\u01f2\u01f3\7\20\2\2\u01f3\u01f4"+
		"\7\17\2\2\u01f4\u01f6\5\24\13\2\u01f5\u01f1\3\2\2\2\u01f5\u01f2\3\2\2"+
		"\2\u01f6\u01f7\3\2\2\2\u01f7\u01f8\7\t\2\2\u01f8\u01f9\58\35\2\u01f9\u01fb"+
		"\3\2\2\2\u01fa\u01f0\3\2\2\2\u01fa\u01f5\3\2\2\2\u01fb=\3\2\2\2\u01fc"+
		"\u0201\5@!\2\u01fd\u01fe\7 \2\2\u01fe\u0200\5@!\2\u01ff\u01fd\3\2\2\2"+
		"\u0200\u0203\3\2\2\2\u0201\u01ff\3\2\2\2\u0201\u0202\3\2\2\2\u0202?\3"+
		"\2\2\2\u0203\u0201\3\2\2\2\u0204\u0205\t\3\2\2\u0205\u0206\7\17\2\2\u0206"+
		"\u0209\5\36\20\2\u0207\u0209\5B\"\2\u0208\u0204\3\2\2\2\u0208\u0207\3"+
		"\2\2\2\u0209A\3\2\2\2\u020a\u020d\7\60\2\2\u020b\u020c\7!\2\2\u020c\u020e"+
		"\5D#\2\u020d\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u0211\3\2\2\2\u020f"+
		"\u0211\5D#\2\u0210\u020a\3\2\2\2\u0210\u020f\3\2\2\2\u0211C\3\2\2\2\u0212"+
		"\u021f\5F$\2\u0213\u021b\5F$\2\u0214\u0216\7\60\2\2\u0215\u0217\7<\2\2"+
		"\u0216\u0215\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u021a"+
		"\5F$\2\u0219\u0214\3\2\2\2\u021a\u021d\3\2\2\2\u021b\u0219\3\2\2\2\u021b"+
		"\u021c\3\2\2\2\u021c\u021f\3\2\2\2\u021d\u021b\3\2\2\2\u021e\u0212\3\2"+
		"\2\2\u021e\u0213\3\2\2\2\u021fE\3\2\2\2\u0220\u0240\7\20\2\2\u0221\u0240"+
		"\7\67\2\2\u0222\u0240\5\b\5\2\u0223\u0229\5\f\7\2\u0224\u0226\7\n\2\2"+
		"\u0225\u0227\5H%\2\u0226\u0225\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0228"+
		"\3\2\2\2\u0228\u022a\7\13\2\2\u0229\u0224\3\2\2\2\u0229\u022a\3\2\2\2"+
		"\u022a\u0240\3\2\2\2\u022b\u022c\5\f\7\2\u022c\u0230\7\n\2\2\u022d\u022e"+
		"\5H%\2\u022e\u022f\7\5\2\2\u022f\u0231\3\2\2\2\u0230\u022d\3\2\2\2\u0230"+
		"\u0231\3\2\2\2\u0231\u0234\3\2\2\2\u0232\u0233\7\60\2\2\u0233\u0235\7"+
		"!\2\2\u0234\u0232\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0236\3\2\2\2\u0236"+
		"\u0237\7\20\2\2\u0237\u0238\7\21\2\2\u0238\u0239\7\13\2\2\u0239\u0240"+
		"\3\2\2\2\u023a\u023c\7\n\2\2\u023b\u023d\5H%\2\u023c\u023b\3\2\2\2\u023c"+
		"\u023d\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u0240\7\13\2\2\u023f\u0220\3"+
		"\2\2\2\u023f\u0221\3\2\2\2\u023f\u0222\3\2\2\2\u023f\u0223\3\2\2\2\u023f"+
		"\u022b\3\2\2\2\u023f\u023a\3\2\2\2\u0240G\3\2\2\2\u0241\u0244\5> \2\u0242"+
		"\u0243\7\5\2\2\u0243\u0245\5H%\2\u0244\u0242\3\2\2\2\u0244\u0245\3\2\2"+
		"\2\u0245\u0249\3\2\2\2\u0246\u0247\7\20\2\2\u0247\u0249\7\21\2\2\u0248"+
		"\u0241\3\2\2\2\u0248\u0246\3\2\2\2\u0249I\3\2\2\2\u024a\u024c\5L\'\2\u024b"+
		"\u024a\3\2\2\2\u024c\u024f\3\2\2\2\u024d\u024b\3\2\2\2\u024d\u024e\3\2"+
		"\2\2\u024eK\3\2\2\2\u024f\u024d\3\2\2\2\u0250\u0252\7<\2\2\u0251\u0250"+
		"\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0255\7\n\2\2\u0254"+
		"\u0256\5N(\2\u0255\u0254\3\2\2\2\u0255\u0256\3\2\2\2\u0256\u0257\3\2\2"+
		"\2\u0257\u0258\7\13\2\2\u0258M\3\2\2\2\u0259\u025e\5P)\2\u025a\u025b\7"+
		"\5\2\2\u025b\u025d\5P)\2\u025c\u025a\3\2\2\2\u025d\u0260\3\2\2\2\u025e"+
		"\u025c\3\2\2\2\u025e\u025f\3\2\2\2\u025fO\3\2\2\2\u0260\u025e\3\2\2\2"+
		"\u0261\u0264\7\60\2\2\u0262\u0263\7\17\2\2\u0263\u0265\5R*\2\u0264\u0262"+
		"\3\2\2\2\u0264\u0265\3\2\2\2\u0265\u0268\3\2\2\2\u0266\u0267\7\33\2\2"+
		"\u0267\u0269\5\"\22\2\u0268\u0266\3\2\2\2\u0268\u0269\3\2\2\2\u0269Q\3"+
		"\2\2\2\u026a\u0271\5\16\b\2\u026b\u026c\7\t\2\2\u026c\u0271\5\16\b\2\u026d"+
		"\u026e\5\16\b\2\u026e\u026f\7\21\2\2\u026f\u0271\3\2\2\2\u0270\u026a\3"+
		"\2\2\2\u0270\u026b\3\2\2\2\u0270\u026d\3\2\2\2\u0271S\3\2\2\2\u0272\u0274"+
		"\5V,\2\u0273\u0272\3\2\2\2\u0274\u0277\3\2\2\2\u0275\u0273\3\2\2\2\u0275"+
		"\u0276\3\2\2\2\u0276U\3\2\2\2\u0277\u0275\3\2\2\2\u0278\u027a\7<\2\2\u0279"+
		"\u0278\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027d\7\n"+
		"\2\2\u027c\u027e\5X-\2\u027d\u027c\3\2\2\2\u027d\u027e\3\2\2\2\u027e\u027f"+
		"\3\2\2\2\u027f\u0280\7\13\2\2\u0280W\3\2\2\2\u0281\u0286\5Z.\2\u0282\u0283"+
		"\7\5\2\2\u0283\u0285\5Z.\2\u0284\u0282\3\2\2\2\u0285\u0288\3\2\2\2\u0286"+
		"\u0284\3\2\2\2\u0286\u0287\3\2\2\2\u0287Y\3\2\2\2\u0288\u0286\3\2\2\2"+
		"\u0289\u028b\5`\61\2\u028a\u0289\3\2\2\2\u028b\u028e\3\2\2\2\u028c\u028a"+
		"\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u0290\3\2\2\2\u028e\u028c\3\2\2\2\u028f"+
		"\u0291\t\4\2\2\u0290\u028f\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0292\3\2"+
		"\2\2\u0292\u0293\7\60\2\2\u0293\u0294\7\17\2\2\u0294\u0297\5R*\2\u0295"+
		"\u0296\7\33\2\2\u0296\u0298\5\"\22\2\u0297\u0295\3\2\2\2\u0297\u0298\3"+
		"\2\2\2\u0298[\3\2\2\2\u0299\u029a\7\n\2\2\u029a\u029f\5^\60\2\u029b\u029c"+
		"\7\5\2\2\u029c\u029e\5^\60\2\u029d\u029b\3\2\2\2\u029e\u02a1\3\2\2\2\u029f"+
		"\u029d\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0\u02a2\3\2\2\2\u02a1\u029f\3\2"+
		"\2\2\u02a2\u02a3\7\13\2\2\u02a3]\3\2\2\2\u02a4\u02a7\t\5\2\2\u02a5\u02a6"+
		"\7\17\2\2\u02a6\u02a8\5\16\b\2\u02a7\u02a5\3\2\2\2\u02a7\u02a8\3\2\2\2"+
		"\u02a8_\3\2\2\2\u02a9\u02ad\5b\62\2\u02aa\u02ad\5d\63\2\u02ab\u02ad\7"+
		"$\2\2\u02ac\u02a9\3\2\2\2\u02ac\u02aa\3\2\2\2\u02ac\u02ab\3\2\2\2\u02ad"+
		"a\3\2\2\2\u02ae\u02af\t\6\2\2\u02afc\3\2\2\2\u02b0\u02b2\t\7\2\2\u02b1"+
		"\u02b3\5f\64\2\u02b2\u02b1\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3e\3\2\2\2"+
		"\u02b4\u02b5\7*\2\2\u02b5\u02b6\t\b\2\2\u02b6\u02b7\7+\2\2\u02b7g\3\2"+
		"\2\2\u02b8\u02ba\7<\2\2\u02b9\u02b8\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba"+
		"\u02bb\3\2\2\2\u02bb\u02bd\7\r\2\2\u02bc\u02be\5j\66\2\u02bd\u02bc\3\2"+
		"\2\2\u02be\u02bf\3\2\2\2\u02bf\u02bd\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0"+
		"\u02c1\3\2\2\2\u02c1\u02c2\7\16\2\2\u02c2i\3\2\2\2\u02c3\u02c5\5`\61\2"+
		"\u02c4\u02c3\3\2\2\2\u02c5\u02c8\3\2\2\2\u02c6\u02c4\3\2\2\2\u02c6\u02c7"+
		"\3\2\2\2\u02c7\u02c9\3\2\2\2\u02c8\u02c6\3\2\2\2\u02c9\u02d3\5x=\2\u02ca"+
		"\u02cc\5`\61\2\u02cb\u02ca\3\2\2\2\u02cc\u02cf\3\2\2\2\u02cd\u02cb\3\2"+
		"\2\2\u02cd\u02ce\3\2\2\2\u02ce\u02d0\3\2\2\2\u02cf\u02cd\3\2\2\2\u02d0"+
		"\u02d3\5l\67\2\u02d1\u02d3\5\"\22\2\u02d2\u02c6\3\2\2\2\u02d2\u02cd\3"+
		"\2\2\2\u02d2\u02d1\3\2\2\2\u02d3k\3\2\2\2\u02d4\u02d5\7\"\2\2\u02d5\u02db"+
		"\5n8\2\u02d6\u02d7\7#\2\2\u02d7\u02db\5p9\2\u02d8\u02d9\7,\2\2\u02d9\u02db"+
		"\5r:\2\u02da\u02d4\3\2\2\2\u02da\u02d6\3\2\2\2\u02da\u02d8\3\2\2\2\u02db"+
		"m\3\2\2\2\u02dc\u02dd\5\n\6\2\u02dd\u02de\7\17\2\2\u02de\u02df\5\16\b"+
		"\2\u02dfo\3\2\2\2\u02e0\u02e1\5\n\6\2\u02e1\u02e2\7\17\2\2\u02e2\u02e3"+
		"\5\16\b\2\u02e3q\3\2\2\2\u02e4\u02e7\5t;\2\u02e5\u02e6\7\17\2\2\u02e6"+
		"\u02e8\5\16\b\2\u02e7\u02e5\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8s\3\2\2\2"+
		"\u02e9\u02ea\7\60\2\2\u02ea\u02eb\5J&\2\u02ebu\3\2\2\2\u02ec\u02ed\7\""+
		"\2\2\u02ed\u02f1\5z>\2\u02ee\u02ef\7#\2\2\u02ef\u02f1\5|?\2\u02f0\u02ec"+
		"\3\2\2\2\u02f0\u02ee\3\2\2\2\u02f1w\3\2\2\2\u02f2\u02f7\5v<\2\u02f3\u02f4"+
		"\7,\2\2\u02f4\u02f7\5~@\2\u02f5\u02f7\5\u0080A\2\u02f6\u02f2\3\2\2\2\u02f6"+
		"\u02f3\3\2\2\2\u02f6\u02f5\3\2\2\2\u02f7y\3\2\2\2\u02f8\u02fd\5B\"\2\u02f9"+
		"\u02fa\7\5\2\2\u02fa\u02fc\5B\"\2\u02fb\u02f9\3\2\2\2\u02fc\u02ff\3\2"+
		"\2\2\u02fd\u02fb\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe\u0302\3\2\2\2\u02ff"+
		"\u02fd\3\2\2\2\u0300\u0301\7\17\2\2\u0301\u0303\5\16\b\2\u0302\u0300\3"+
		"\2\2\2\u0302\u0303\3\2\2\2\u0303\u0304\3\2\2\2\u0304\u0305\7\33\2\2\u0305"+
		"\u0306\5\"\22\2\u0306{\3\2\2\2\u0307\u0308\5\n\6\2\u0308\u0309\7\17\2"+
		"\2\u0309\u030a\5\16\b\2\u030a\u030b\7\33\2\2\u030b\u030c\7\20\2\2\u030c"+
		"}\3\2\2\2\u030d\u0310\5t;\2\u030e\u030f\7\17\2\2\u030f\u0311\5\16\b\2"+
		"\u0310\u030e\3\2\2\2\u0310\u0311\3\2\2\2\u0311\u0312\3\2\2\2\u0312\u0313"+
		"\7\33\2\2\u0313\u0314\5\"\22\2\u0314\u0329\3\2\2\2\u0315\u0317\5t;\2\u0316"+
		"\u0318\7<\2\2\u0317\u0316\3\2\2\2\u0317\u0318\3\2\2\2\u0318\u0319\3\2"+
		"\2\2\u0319\u031a\7\r\2\2\u031a\u031b\58\35\2\u031b\u031c\7\16\2\2\u031c"+
		"\u0329\3\2\2\2\u031d\u031e\7\7\2\2\u031e\u031f\5L\'\2\u031f\u0326\5J&"+
		"\2\u0320\u0321\7\33\2\2\u0321\u0327\5\u008eH\2\u0322\u0324\7<\2\2\u0323"+
		"\u0322\3\2\2\2\u0323\u0324\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u0327\5\u0090"+
		"I\2\u0326\u0320\3\2\2\2\u0326\u0323\3\2\2\2\u0327\u0329\3\2\2\2\u0328"+
		"\u030d\3\2\2\2\u0328\u0315\3\2\2\2\u0328\u031d\3\2\2\2\u0329\177\3\2\2"+
		"\2\u032a\u032b\7-\2\2\u032b\u032f\5\u0082B\2\u032c\u032d\7.\2\2\u032d"+
		"\u032f\5\u0084C\2\u032e\u032a\3\2\2\2\u032e\u032c\3\2\2\2\u032f\u0081"+
		"\3\2\2\2\u0330\u0332\7\60\2\2\u0331\u0333\5d\63\2\u0332\u0331\3\2\2\2"+
		"\u0332\u0333\3\2\2\2\u0333\u0334\3\2\2\2\u0334\u0335\5T+\2\u0335\u0336"+
		"\5\u0086D\2\u0336\u0083\3\2\2\2\u0337\u0338\7\60\2\2\u0338\u0339\5\u0086"+
		"D\2\u0339\u0085\3\2\2\2\u033a\u033b\7/\2\2\u033b\u0343\5\u0088E\2\u033c"+
		"\u033e\7/\2\2\u033d\u033c\3\2\2\2\u033d\u033e\3\2\2\2\u033e\u033f\3\2"+
		"\2\2\u033f\u0341\5h\65\2\u0340\u033d\3\2\2\2\u0340\u0341\3\2\2\2\u0341"+
		"\u0343\3\2\2\2\u0342\u033a\3\2\2\2\u0342\u0340\3\2\2\2\u0343\u0087\3\2"+
		"\2\2\u0344\u0346\5\u008aF\2\u0345\u0347\5h\65\2\u0346\u0345\3\2\2\2\u0346"+
		"\u0347\3\2\2\2\u0347\u0089\3\2\2\2\u0348\u0349\5\u008cG\2\u0349\u008b"+
		"\3\2\2\2\u034a\u034c\5\64\33\2\u034b\u034a\3\2\2\2\u034c\u034f\3\2\2\2"+
		"\u034d\u034b\3\2\2\2\u034d\u034e\3\2\2\2\u034e\u008d\3\2\2\2\u034f\u034d"+
		"\3\2\2\2\u0350\u0353\5\u0092J\2\u0351\u0353\5\u0090I\2\u0352\u0350\3\2"+
		"\2\2\u0352\u0351\3\2\2\2\u0353\u008f\3\2\2\2\u0354\u0355\7\r\2\2\u0355"+
		"\u0359\5\u0092J\2\u0356\u0358\5:\36\2\u0357\u0356\3\2\2\2\u0358\u035b"+
		"\3\2\2\2\u0359\u0357\3\2\2\2\u0359\u035a\3\2\2\2\u035a\u035c\3\2\2\2\u035b"+
		"\u0359\3\2\2\2\u035c\u035d\7\16\2\2\u035d\u0091\3\2\2\2\u035e\u0360\7"+
		"\7\2\2\u035f\u0361\5\64\33\2\u0360\u035f\3\2\2\2\u0361\u0362\3\2\2\2\u0362"+
		"\u0360\3\2\2\2\u0362\u0363\3\2\2\2\u0363\u0093\3\2\2\2y\u0099\u009e\u00a4"+
		"\u00a8\u00b0\u00b7\u00be\u00c4\u00c6\u00cd\u00d5\u00de\u00e1\u00e4\u00eb"+
		"\u00f3\u00f9\u0100\u0104\u010a\u0117\u011b\u0120\u0129\u012f\u0138\u0141"+
		"\u0145\u0152\u0157\u0159\u015d\u0169\u016b\u0171\u0178\u017c\u0184\u0189"+
		"\u018d\u0192\u0194\u0199\u019c\u01a4\u01ab\u01af\u01b5\u01b7\u01bf\u01c4"+
		"\u01cb\u01d4\u01d7\u01e0\u01e3\u01e9\u01ee\u01f5\u01fa\u0201\u0208\u020d"+
		"\u0210\u0216\u021b\u021e\u0226\u0229\u0230\u0234\u023c\u023f\u0244\u0248"+
		"\u024d\u0251\u0255\u025e\u0264\u0268\u0270\u0275\u0279\u027d\u0286\u028c"+
		"\u0290\u0297\u029f\u02a7\u02ac\u02b2\u02b9\u02bf\u02c6\u02cd\u02d2\u02da"+
		"\u02e7\u02f0\u02f6\u02fd\u0302\u0310\u0317\u0323\u0326\u0328\u032e\u0332"+
		"\u033d\u0340\u0342\u0346\u034d\u0352\u0359\u0362";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}