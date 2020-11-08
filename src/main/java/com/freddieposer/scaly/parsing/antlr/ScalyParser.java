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
		RULE_literal = 0, RULE_ids = 1, RULE_stableId = 2, RULE_type_ = 3, RULE_functionArgTypes = 4, 
		RULE_infixType = 5, RULE_compoundType = 6, RULE_simpleType = 7, RULE_types = 8, 
		RULE_refinement = 9, RULE_refineStat = 10, RULE_typePat = 11, RULE_ascription = 12, 
		RULE_expr = 13, RULE_expr1 = 14, RULE_prefixDef = 15, RULE_postfixExpr = 16, 
		RULE_infixExpr = 17, RULE_prefixExpr = 18, RULE_simpleExpr = 19, RULE_simpleExpr1 = 20, 
		RULE_exprs = 21, RULE_argumentExprs = 22, RULE_blockExpr = 23, RULE_block = 24, 
		RULE_blockStat = 25, RULE_resultExpr = 26, RULE_pattern = 27, RULE_pattern1 = 28, 
		RULE_pattern2 = 29, RULE_pattern3 = 30, RULE_simplePattern = 31, RULE_patterns = 32, 
		RULE_paramClauses = 33, RULE_paramClause = 34, RULE_params = 35, RULE_param = 36, 
		RULE_paramType = 37, RULE_classParamClauses = 38, RULE_classParamClause = 39, 
		RULE_classParams = 40, RULE_classParam = 41, RULE_bindings = 42, RULE_binding = 43, 
		RULE_modifier = 44, RULE_localModifier = 45, RULE_accessModifier = 46, 
		RULE_accessQualifier = 47, RULE_templateBody = 48, RULE_templateStat = 49, 
		RULE_dcl = 50, RULE_valDcl = 51, RULE_varDcl = 52, RULE_funDcl = 53, RULE_funSig = 54, 
		RULE_patVarDef = 55, RULE_def = 56, RULE_patDef = 57, RULE_varDef = 58, 
		RULE_funDef = 59, RULE_tmplDef = 60, RULE_classDef = 61, RULE_objectDef = 62, 
		RULE_classTemplateOpt = 63, RULE_classTemplate = 64, RULE_classParents = 65, 
		RULE_constr = 66, RULE_constrExpr = 67, RULE_constrBlock = 68, RULE_selfInvocation = 69, 
		RULE_topStatSeq = 70, RULE_topStat = 71, RULE_compilationUnit = 72;
	private static String[] makeRuleNames() {
		return new String[] {
			"literal", "ids", "stableId", "type_", "functionArgTypes", "infixType", 
			"compoundType", "simpleType", "types", "refinement", "refineStat", "typePat", 
			"ascription", "expr", "expr1", "prefixDef", "postfixExpr", "infixExpr", 
			"prefixExpr", "simpleExpr", "simpleExpr1", "exprs", "argumentExprs", 
			"blockExpr", "block", "blockStat", "resultExpr", "pattern", "pattern1", 
			"pattern2", "pattern3", "simplePattern", "patterns", "paramClauses", 
			"paramClause", "params", "param", "paramType", "classParamClauses", "classParamClause", 
			"classParams", "classParam", "bindings", "binding", "modifier", "localModifier", 
			"accessModifier", "accessQualifier", "templateBody", "templateStat", 
			"dcl", "valDcl", "varDcl", "funDcl", "funSig", "patVarDef", "def", "patDef", 
			"varDef", "funDef", "tmplDef", "classDef", "objectDef", "classTemplateOpt", 
			"classTemplate", "classParents", "constr", "constrExpr", "constrBlock", 
			"selfInvocation", "topStatSeq", "topStat", "compilationUnit"
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(ScalyParser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(ScalyParser.FloatingPointLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(ScalyParser.BooleanLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(ScalyParser.CharacterLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(ScalyParser.StringLiteral, 0); }
		public TerminalNode SymbolLiteral() { return getToken(ScalyParser.SymbolLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_literal);
		int _la;
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(146);
					match(T__0);
					}
				}

				setState(149);
				match(IntegerLiteral);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(150);
					match(T__0);
					}
				}

				setState(153);
				match(FloatingPointLiteral);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				match(BooleanLiteral);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(155);
				match(CharacterLiteral);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(156);
				match(StringLiteral);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(157);
				match(SymbolLiteral);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(158);
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
		enterRule(_localctx, 2, RULE_ids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(Id);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(162);
				match(T__2);
				setState(163);
				match(Id);
				}
				}
				setState(168);
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_stableId, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(170);
				match(Id);
				}
				break;
			case 2:
				{
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Id) {
					{
					setState(171);
					match(Id);
					setState(172);
					match(T__3);
					}
				}

				setState(179);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
					{
					setState(175);
					match(T__4);
					}
					break;
				case T__5:
					{
					setState(176);
					match(T__5);
					setState(177);
					match(T__3);
					setState(178);
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
			setState(188);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StableIdContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stableId);
					setState(183);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(184);
					match(T__3);
					setState(185);
					match(Id);
					}
					} 
				}
				setState(190);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		enterRule(_localctx, 6, RULE_type_);
		try {
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				functionArgTypes();
				setState(192);
				match(T__6);
				setState(193);
				type_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
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
		enterRule(_localctx, 8, RULE_functionArgTypes);
		int _la;
		try {
			setState(211);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case NL:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				infixType();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				match(T__7);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__10) | (1L << NL))) != 0)) {
					{
					setState(200);
					paramType();
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(201);
						match(T__2);
						setState(202);
						paramType();
						}
						}
						setState(207);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(210);
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
		enterRule(_localctx, 10, RULE_infixType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			compoundType();
			setState(218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(214);
					match(Id);
					setState(215);
					compoundType();
					}
					} 
				}
				setState(220);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		enterRule(_localctx, 12, RULE_compoundType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
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
		enterRule(_localctx, 14, RULE_simpleType);
		int _la;
		try {
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				stableId(0);
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(224);
					match(T__3);
					setState(225);
					match(T__9);
					}
				}

				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				match(T__7);
				setState(229);
				types();
				setState(230);
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
		enterRule(_localctx, 16, RULE_types);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			type_();
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(235);
				match(T__2);
				setState(236);
				type_();
				}
				}
				setState(241);
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
		enterRule(_localctx, 18, RULE_refinement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(242);
				match(NL);
				}
			}

			setState(245);
			match(T__10);
			setState(247); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(246);
				refineStat();
				}
				}
				setState(249); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__41))) != 0) );
			setState(251);
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
		enterRule(_localctx, 20, RULE_refineStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
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
		enterRule(_localctx, 22, RULE_typePat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
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
		enterRule(_localctx, 24, RULE_ascription);
		try {
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				match(T__12);
				setState(258);
				infixType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				match(T__12);
				setState(260);
				match(T__13);
				setState(261);
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
		enterRule(_localctx, 26, RULE_expr);
		try {
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(266);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__7:
					{
					setState(264);
					bindings();
					}
					break;
				case T__13:
					{
					setState(265);
					match(T__13);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(268);
				match(T__6);
				setState(269);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
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
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public SimpleExprContext simpleExpr() {
			return getRuleContext(SimpleExprContext.class,0);
		}
		public SimpleExpr1Context simpleExpr1() {
			return getRuleContext(SimpleExpr1Context.class,0);
		}
		public ArgumentExprsContext argumentExprs() {
			return getRuleContext(ArgumentExprsContext.class,0);
		}
		public PostfixExprContext postfixExpr() {
			return getRuleContext(PostfixExprContext.class,0);
		}
		public AscriptionContext ascription() {
			return getRuleContext(AscriptionContext.class,0);
		}
		public Expr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterExpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitExpr1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitExpr1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr1Context expr1() throws RecognitionException {
		Expr1Context _localctx = new Expr1Context(_ctx, getState());
		enterRule(_localctx, 28, RULE_expr1);
		int _la;
		try {
			setState(346);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				match(T__15);
				setState(274);
				match(T__7);
				setState(275);
				expr();
				setState(276);
				match(T__8);
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(277);
					match(NL);
					}
					}
					setState(282);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(283);
				expr();
				setState(286);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(284);
					match(T__16);
					setState(285);
					expr();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				match(T__17);
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
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(300);
				match(T__18);
				setState(301);
				expr();
				setState(304);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(302);
					match(T__19);
					setState(303);
					expr();
					}
					break;
				}
				setState(308);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(306);
					match(T__20);
					setState(307);
					expr();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(310);
				match(T__21);
				setState(311);
				expr();
				setState(312);
				match(T__17);
				setState(313);
				match(T__7);
				setState(314);
				expr();
				setState(315);
				match(T__8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(317);
				match(T__22);
				setState(318);
				expr();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(319);
				match(T__23);
				setState(321);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(320);
					expr();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(332);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(328);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						setState(323);
						simpleExpr();
						}
						break;
					case 2:
						{
						setState(324);
						simpleExpr1(0);
						setState(326);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__13) {
							{
							setState(325);
							match(T__13);
							}
						}

						}
						break;
					}
					setState(330);
					match(T__3);
					}
					break;
				}
				setState(334);
				match(Id);
				setState(335);
				match(T__24);
				setState(336);
				expr();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(337);
				simpleExpr1(0);
				setState(338);
				argumentExprs();
				setState(339);
				match(T__24);
				setState(340);
				expr();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(342);
				postfixExpr();
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(343);
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
		enterRule(_localctx, 30, RULE_prefixDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
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
		enterRule(_localctx, 32, RULE_postfixExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			infixExpr(0);
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(351);
				match(Id);
				}
				break;
			}
			setState(359);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(354);
					prefixDef();
					setState(355);
					simpleExpr1(0);
					}
					} 
				}
				setState(361);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(362);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_infixExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(366);
			prefixExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(376);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InfixExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_infixExpr);
					setState(368);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(369);
					match(Id);
					setState(371);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NL) {
						{
						setState(370);
						match(NL);
						}
					}

					setState(373);
					infixExpr(2);
					}
					} 
				}
				setState(378);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
		enterRule(_localctx, 36, RULE_prefixExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(379);
				prefixDef();
				}
				break;
			}
			setState(387);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(382);
				simpleExpr();
				}
				break;
			case 2:
				{
				setState(383);
				simpleExpr1(0);
				setState(385);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(384);
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
		enterRule(_localctx, 38, RULE_simpleExpr);
		try {
			setState(395);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(389);
				match(T__28);
				setState(392);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(390);
					classTemplate();
					}
					break;
				case 2:
					{
					setState(391);
					templateBody();
					}
					break;
				}
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(394);
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
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public StableIdContext stableId() {
			return getRuleContext(StableIdContext.class,0);
		}
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public SimpleExprContext simpleExpr() {
			return getRuleContext(SimpleExprContext.class,0);
		}
		public TerminalNode Id() { return getToken(ScalyParser.Id, 0); }
		public SimpleExpr1Context simpleExpr1() {
			return getRuleContext(SimpleExpr1Context.class,0);
		}
		public ArgumentExprsContext argumentExprs() {
			return getRuleContext(ArgumentExprsContext.class,0);
		}
		public SimpleExpr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpr1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).enterSimpleExpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScalyListener ) ((ScalyListener)listener).exitSimpleExpr1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScalyVisitor ) return ((ScalyVisitor<? extends T>)visitor).visitSimpleExpr1(this);
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_simpleExpr1, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
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
				setState(398);
				literal();
				}
				break;
			case T__4:
			case T__5:
			case Id:
				{
				setState(399);
				stableId(0);
				}
				break;
			case T__13:
				{
				setState(400);
				match(T__13);
				}
				break;
			case T__7:
				{
				setState(401);
				match(T__7);
				setState(403);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral))) != 0)) {
					{
					setState(402);
					exprs();
					}
				}

				setState(405);
				match(T__8);
				}
				break;
			case T__10:
			case T__28:
				{
				setState(406);
				simpleExpr();
				setState(407);
				match(T__3);
				setState(408);
				match(Id);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(422);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(420);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
					case 1:
						{
						_localctx = new SimpleExpr1Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_simpleExpr1);
						setState(412);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(414);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__13) {
							{
							setState(413);
							match(T__13);
							}
						}

						setState(416);
						match(T__3);
						setState(417);
						match(Id);
						}
						break;
					case 2:
						{
						_localctx = new SimpleExpr1Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_simpleExpr1);
						setState(418);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(419);
						argumentExprs();
						}
						break;
					}
					} 
				}
				setState(424);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
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
		enterRule(_localctx, 42, RULE_exprs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			expr();
			setState(430);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(426);
					match(T__2);
					setState(427);
					expr();
					}
					} 
				}
				setState(432);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
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
		enterRule(_localctx, 44, RULE_argumentExprs);
		int _la;
		try {
			setState(454);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(433);
				match(T__7);
				setState(435);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral))) != 0)) {
					{
					setState(434);
					exprs();
					}
				}

				setState(437);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(438);
				match(T__7);
				setState(442);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
				case 1:
					{
					setState(439);
					exprs();
					setState(440);
					match(T__2);
					}
					break;
				}
				setState(444);
				postfixExpr();
				setState(445);
				match(T__12);
				setState(446);
				match(T__13);
				setState(447);
				match(T__14);
				setState(448);
				match(T__8);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(451);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(450);
					match(NL);
					}
				}

				setState(453);
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
		enterRule(_localctx, 46, RULE_blockExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			match(T__10);
			setState(457);
			block();
			setState(458);
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
		enterRule(_localctx, 48, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(461); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(460);
					blockStat();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(463); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(466);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral))) != 0)) {
				{
				setState(465);
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
		enterRule(_localctx, 50, RULE_blockStat);
		int _la;
		try {
			setState(477);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(468);
				def();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(472);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36))) != 0)) {
					{
					{
					setState(469);
					localModifier();
					}
					}
					setState(474);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(475);
				tmplDef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(476);
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
		enterRule(_localctx, 52, RULE_resultExpr);
		try {
			setState(489);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(479);
				expr1();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(484);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__7:
					{
					setState(480);
					bindings();
					}
					break;
				case T__13:
					{
					setState(481);
					match(T__13);
					setState(482);
					match(T__12);
					setState(483);
					compoundType();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(486);
				match(T__6);
				setState(487);
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
		enterRule(_localctx, 54, RULE_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			pattern1();
			setState(496);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__29) {
				{
				{
				setState(492);
				match(T__29);
				setState(493);
				pattern1();
				}
				}
				setState(498);
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
		enterRule(_localctx, 56, RULE_pattern1);
		int _la;
		try {
			setState(503);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(499);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << Id) | (1L << BoundVarid))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(500);
				match(T__12);
				setState(501);
				typePat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(502);
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
		enterRule(_localctx, 58, RULE_pattern2);
		int _la;
		try {
			setState(511);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(505);
				match(Id);
				setState(508);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__30) {
					{
					setState(506);
					match(T__30);
					setState(507);
					pattern3();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(510);
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
		enterRule(_localctx, 60, RULE_pattern3);
		int _la;
		try {
			setState(525);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(513);
				simplePattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(514);
				simplePattern();
				setState(522);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Id) {
					{
					{
					setState(515);
					match(Id);
					setState(517);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NL) {
						{
						setState(516);
						match(NL);
						}
					}

					setState(519);
					simplePattern();
					}
					}
					setState(524);
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
		enterRule(_localctx, 62, RULE_simplePattern);
		int _la;
		try {
			setState(558);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(527);
				match(T__13);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(528);
				match(Varid);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(529);
				literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(530);
				stableId(0);
				setState(536);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(531);
					match(T__7);
					setState(533);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__13) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral) | (1L << Varid) | (1L << BoundVarid))) != 0)) {
						{
						setState(532);
						patterns();
						}
					}

					setState(535);
					match(T__8);
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(538);
				stableId(0);
				setState(539);
				match(T__7);
				setState(543);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
				case 1:
					{
					setState(540);
					patterns();
					setState(541);
					match(T__2);
					}
					break;
				}
				setState(547);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Id) {
					{
					setState(545);
					match(Id);
					setState(546);
					match(T__30);
					}
				}

				setState(549);
				match(T__13);
				setState(550);
				match(T__14);
				setState(551);
				match(T__8);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(553);
				match(T__7);
				setState(555);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__13) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral) | (1L << Varid) | (1L << BoundVarid))) != 0)) {
					{
					setState(554);
					patterns();
					}
				}

				setState(557);
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
		enterRule(_localctx, 64, RULE_patterns);
		try {
			setState(567);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(560);
				pattern();
				setState(563);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
				case 1:
					{
					setState(561);
					match(T__2);
					setState(562);
					patterns();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(565);
				match(T__13);
				setState(566);
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
		enterRule(_localctx, 66, RULE_paramClauses);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(569);
					paramClause();
					}
					} 
				}
				setState(574);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
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
		enterRule(_localctx, 68, RULE_paramClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(575);
				match(NL);
				}
			}

			setState(578);
			match(T__7);
			setState(580);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Id) {
				{
				setState(579);
				params();
				}
			}

			setState(582);
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
		enterRule(_localctx, 70, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			param();
			setState(589);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(585);
				match(T__2);
				setState(586);
				param();
				}
				}
				setState(591);
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
		enterRule(_localctx, 72, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(592);
			match(Id);
			setState(595);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(593);
				match(T__12);
				setState(594);
				paramType();
				}
			}

			setState(599);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(597);
				match(T__24);
				setState(598);
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
		enterRule(_localctx, 74, RULE_paramType);
		try {
			setState(607);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(601);
				type_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(602);
				match(T__6);
				setState(603);
				type_();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(604);
				type_();
				setState(605);
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
		enterRule(_localctx, 76, RULE_classParamClauses);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(609);
					classParamClause();
					}
					} 
				}
				setState(614);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
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
		enterRule(_localctx, 78, RULE_classParamClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(616);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(615);
				match(NL);
				}
			}

			setState(618);
			match(T__7);
			setState(620);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << Id))) != 0)) {
				{
				setState(619);
				classParams();
				}
			}

			setState(622);
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
		enterRule(_localctx, 80, RULE_classParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			classParam();
			setState(629);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(625);
				match(T__2);
				setState(626);
				classParam();
				}
				}
				setState(631);
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
		enterRule(_localctx, 82, RULE_classParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) {
				{
				{
				setState(632);
				modifier();
				}
				}
				setState(637);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(639);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__31 || _la==T__32) {
				{
				setState(638);
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

			setState(641);
			match(Id);
			setState(642);
			match(T__12);
			setState(643);
			paramType();
			setState(646);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(644);
				match(T__24);
				setState(645);
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
		enterRule(_localctx, 84, RULE_bindings);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(648);
			match(T__7);
			setState(649);
			binding();
			setState(654);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(650);
				match(T__2);
				setState(651);
				binding();
				}
				}
				setState(656);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(657);
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
		enterRule(_localctx, 86, RULE_binding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(659);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==Id) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(662);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(660);
				match(T__12);
				setState(661);
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
		enterRule(_localctx, 88, RULE_modifier);
		try {
			setState(667);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__34:
			case T__35:
			case T__36:
				enterOuterAlt(_localctx, 1);
				{
				setState(664);
				localModifier();
				}
				break;
			case T__37:
			case T__38:
				enterOuterAlt(_localctx, 2);
				{
				setState(665);
				accessModifier();
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 3);
				{
				setState(666);
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
		enterRule(_localctx, 90, RULE_localModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(669);
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
		enterRule(_localctx, 92, RULE_accessModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
			_la = _input.LA(1);
			if ( !(_la==T__37 || _la==T__38) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(673);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__39) {
				{
				setState(672);
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
		enterRule(_localctx, 94, RULE_accessQualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(675);
			match(T__39);
			setState(676);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==Id) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(677);
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
		enterRule(_localctx, 96, RULE_templateBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(679);
				match(NL);
				}
			}

			setState(682);
			match(T__10);
			setState(684); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(683);
				templateStat();
				}
				}
				setState(686); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral))) != 0) );
			setState(688);
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
		enterRule(_localctx, 98, RULE_templateStat);
		int _la;
		try {
			setState(705);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(693);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) {
					{
					{
					setState(690);
					modifier();
					}
					}
					setState(695);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(696);
				def();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(700);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) {
					{
					{
					setState(697);
					modifier();
					}
					}
					setState(702);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(703);
				dcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(704);
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
		enterRule(_localctx, 100, RULE_dcl);
		try {
			setState(713);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
				enterOuterAlt(_localctx, 1);
				{
				setState(707);
				match(T__31);
				setState(708);
				valDcl();
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 2);
				{
				setState(709);
				match(T__32);
				setState(710);
				varDcl();
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 3);
				{
				setState(711);
				match(T__41);
				setState(712);
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
		enterRule(_localctx, 102, RULE_valDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(715);
			ids();
			setState(716);
			match(T__12);
			setState(717);
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
		enterRule(_localctx, 104, RULE_varDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(719);
			ids();
			setState(720);
			match(T__12);
			setState(721);
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
		enterRule(_localctx, 106, RULE_funDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(723);
			funSig();
			setState(726);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(724);
				match(T__12);
				setState(725);
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
		enterRule(_localctx, 108, RULE_funSig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(728);
			match(Id);
			setState(729);
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
		enterRule(_localctx, 110, RULE_patVarDef);
		try {
			setState(735);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
				enterOuterAlt(_localctx, 1);
				{
				setState(731);
				match(T__31);
				setState(732);
				patDef();
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 2);
				{
				setState(733);
				match(T__32);
				setState(734);
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
		enterRule(_localctx, 112, RULE_def);
		try {
			setState(741);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(737);
				patVarDef();
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 2);
				{
				setState(738);
				match(T__41);
				setState(739);
				funDef();
				}
				break;
			case T__42:
			case T__43:
				enterOuterAlt(_localctx, 3);
				{
				setState(740);
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
		enterRule(_localctx, 114, RULE_patDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(743);
			pattern2();
			setState(748);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(744);
				match(T__2);
				setState(745);
				pattern2();
				}
				}
				setState(750);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(753);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(751);
				match(T__12);
				setState(752);
				type_();
				}
			}

			setState(755);
			match(T__24);
			setState(756);
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
		enterRule(_localctx, 116, RULE_varDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(758);
			ids();
			setState(759);
			match(T__12);
			setState(760);
			type_();
			setState(761);
			match(T__24);
			setState(762);
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
		enterRule(_localctx, 118, RULE_funDef);
		int _la;
		try {
			setState(791);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(764);
				funSig();
				setState(767);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(765);
					match(T__12);
					setState(766);
					type_();
					}
				}

				setState(769);
				match(T__24);
				setState(770);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(772);
				funSig();
				setState(774);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(773);
					match(NL);
					}
				}

				setState(776);
				match(T__10);
				setState(777);
				block();
				setState(778);
				match(T__11);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(780);
				match(T__4);
				setState(781);
				paramClause();
				setState(782);
				paramClauses();
				setState(789);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__24:
					{
					setState(783);
					match(T__24);
					setState(784);
					constrExpr();
					}
					break;
				case T__10:
				case NL:
					{
					setState(786);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NL) {
						{
						setState(785);
						match(NL);
						}
					}

					setState(788);
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
		enterRule(_localctx, 120, RULE_tmplDef);
		try {
			setState(797);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__42:
				enterOuterAlt(_localctx, 1);
				{
				setState(793);
				match(T__42);
				setState(794);
				classDef();
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 2);
				{
				setState(795);
				match(T__43);
				setState(796);
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
		enterRule(_localctx, 122, RULE_classDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(799);
			match(Id);
			setState(801);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
			case 1:
				{
				setState(800);
				accessModifier();
				}
				break;
			}
			setState(803);
			classParamClauses();
			setState(804);
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
		enterRule(_localctx, 124, RULE_objectDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(806);
			match(Id);
			setState(807);
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
		enterRule(_localctx, 126, RULE_classTemplateOpt);
		int _la;
		try {
			setState(817);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(809);
				match(T__44);
				setState(810);
				classTemplate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(815);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
				case 1:
					{
					setState(812);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__44) {
						{
						setState(811);
						match(T__44);
						}
					}

					setState(814);
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
		enterRule(_localctx, 128, RULE_classTemplate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(819);
			classParents();
			setState(821);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				{
				setState(820);
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
		enterRule(_localctx, 130, RULE_classParents);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(823);
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
		enterRule(_localctx, 132, RULE_constr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(828);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(825);
					argumentExprs();
					}
					} 
				}
				setState(830);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
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
		enterRule(_localctx, 134, RULE_constrExpr);
		try {
			setState(833);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(831);
				selfInvocation();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(832);
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
		enterRule(_localctx, 136, RULE_constrBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(835);
			match(T__10);
			setState(836);
			selfInvocation();
			setState(840);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__31) | (1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << Id) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << SymbolLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << FloatingPointLiteral))) != 0)) {
				{
				{
				setState(837);
				blockStat();
				}
				}
				setState(842);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(843);
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
		enterRule(_localctx, 138, RULE_selfInvocation);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(845);
			match(T__4);
			setState(847); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(846);
					argumentExprs();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(849); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,116,_ctx);
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
		enterRule(_localctx, 140, RULE_topStatSeq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(852); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(851);
				topStat();
				}
				}
				setState(854); 
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
		enterRule(_localctx, 142, RULE_topStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(859);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) {
				{
				{
				setState(856);
				modifier();
				}
				}
				setState(861);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(862);
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
		enterRule(_localctx, 144, RULE_compilationUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(864);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return stableId_sempred((StableIdContext)_localctx, predIndex);
		case 17:
			return infixExpr_sempred((InfixExprContext)_localctx, predIndex);
		case 20:
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
		"\tI\4J\tJ\3\2\5\2\u0096\n\2\3\2\3\2\5\2\u009a\n\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\5\2\u00a2\n\2\3\3\3\3\3\3\7\3\u00a7\n\3\f\3\16\3\u00aa\13\3\3\4\3"+
		"\4\3\4\3\4\5\4\u00b0\n\4\3\4\3\4\3\4\3\4\5\4\u00b6\n\4\5\4\u00b8\n\4\3"+
		"\4\3\4\3\4\7\4\u00bd\n\4\f\4\16\4\u00c0\13\4\3\5\3\5\3\5\3\5\3\5\5\5\u00c7"+
		"\n\5\3\6\3\6\3\6\3\6\3\6\7\6\u00ce\n\6\f\6\16\6\u00d1\13\6\5\6\u00d3\n"+
		"\6\3\6\5\6\u00d6\n\6\3\7\3\7\3\7\7\7\u00db\n\7\f\7\16\7\u00de\13\7\3\b"+
		"\3\b\3\t\3\t\3\t\5\t\u00e5\n\t\3\t\3\t\3\t\3\t\5\t\u00eb\n\t\3\n\3\n\3"+
		"\n\7\n\u00f0\n\n\f\n\16\n\u00f3\13\n\3\13\5\13\u00f6\n\13\3\13\3\13\6"+
		"\13\u00fa\n\13\r\13\16\13\u00fb\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\5\16\u0109\n\16\3\17\3\17\5\17\u010d\n\17\3\17\3\17\3\17"+
		"\5\17\u0112\n\17\3\20\3\20\3\20\3\20\3\20\7\20\u0119\n\20\f\20\16\20\u011c"+
		"\13\20\3\20\3\20\3\20\5\20\u0121\n\20\3\20\3\20\3\20\3\20\3\20\7\20\u0128"+
		"\n\20\f\20\16\20\u012b\13\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0133"+
		"\n\20\3\20\3\20\5\20\u0137\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u0144\n\20\3\20\3\20\3\20\5\20\u0149\n\20\5\20\u014b"+
		"\n\20\3\20\3\20\5\20\u014f\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u015b\n\20\5\20\u015d\n\20\3\21\3\21\3\22\3\22\5\22\u0163"+
		"\n\22\3\22\3\22\3\22\7\22\u0168\n\22\f\22\16\22\u016b\13\22\3\22\5\22"+
		"\u016e\n\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0176\n\23\3\23\7\23\u0179"+
		"\n\23\f\23\16\23\u017c\13\23\3\24\5\24\u017f\n\24\3\24\3\24\3\24\5\24"+
		"\u0184\n\24\5\24\u0186\n\24\3\25\3\25\3\25\5\25\u018b\n\25\3\25\5\25\u018e"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0196\n\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u019d\n\26\3\26\3\26\5\26\u01a1\n\26\3\26\3\26\3\26\3\26\7"+
		"\26\u01a7\n\26\f\26\16\26\u01aa\13\26\3\27\3\27\3\27\7\27\u01af\n\27\f"+
		"\27\16\27\u01b2\13\27\3\30\3\30\5\30\u01b6\n\30\3\30\3\30\3\30\3\30\3"+
		"\30\5\30\u01bd\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u01c6\n\30"+
		"\3\30\5\30\u01c9\n\30\3\31\3\31\3\31\3\31\3\32\6\32\u01d0\n\32\r\32\16"+
		"\32\u01d1\3\32\5\32\u01d5\n\32\3\33\3\33\7\33\u01d9\n\33\f\33\16\33\u01dc"+
		"\13\33\3\33\3\33\5\33\u01e0\n\33\3\34\3\34\3\34\3\34\3\34\5\34\u01e7\n"+
		"\34\3\34\3\34\3\34\5\34\u01ec\n\34\3\35\3\35\3\35\7\35\u01f1\n\35\f\35"+
		"\16\35\u01f4\13\35\3\36\3\36\3\36\3\36\5\36\u01fa\n\36\3\37\3\37\3\37"+
		"\5\37\u01ff\n\37\3\37\5\37\u0202\n\37\3 \3 \3 \3 \5 \u0208\n \3 \7 \u020b"+
		"\n \f \16 \u020e\13 \5 \u0210\n \3!\3!\3!\3!\3!\3!\5!\u0218\n!\3!\5!\u021b"+
		"\n!\3!\3!\3!\3!\3!\5!\u0222\n!\3!\3!\5!\u0226\n!\3!\3!\3!\3!\3!\3!\5!"+
		"\u022e\n!\3!\5!\u0231\n!\3\"\3\"\3\"\5\"\u0236\n\"\3\"\3\"\5\"\u023a\n"+
		"\"\3#\7#\u023d\n#\f#\16#\u0240\13#\3$\5$\u0243\n$\3$\3$\5$\u0247\n$\3"+
		"$\3$\3%\3%\3%\7%\u024e\n%\f%\16%\u0251\13%\3&\3&\3&\5&\u0256\n&\3&\3&"+
		"\5&\u025a\n&\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0262\n\'\3(\7(\u0265\n(\f(\16"+
		"(\u0268\13(\3)\5)\u026b\n)\3)\3)\5)\u026f\n)\3)\3)\3*\3*\3*\7*\u0276\n"+
		"*\f*\16*\u0279\13*\3+\7+\u027c\n+\f+\16+\u027f\13+\3+\5+\u0282\n+\3+\3"+
		"+\3+\3+\3+\5+\u0289\n+\3,\3,\3,\3,\7,\u028f\n,\f,\16,\u0292\13,\3,\3,"+
		"\3-\3-\3-\5-\u0299\n-\3.\3.\3.\5.\u029e\n.\3/\3/\3\60\3\60\5\60\u02a4"+
		"\n\60\3\61\3\61\3\61\3\61\3\62\5\62\u02ab\n\62\3\62\3\62\6\62\u02af\n"+
		"\62\r\62\16\62\u02b0\3\62\3\62\3\63\7\63\u02b6\n\63\f\63\16\63\u02b9\13"+
		"\63\3\63\3\63\7\63\u02bd\n\63\f\63\16\63\u02c0\13\63\3\63\3\63\5\63\u02c4"+
		"\n\63\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u02cc\n\64\3\65\3\65\3\65\3\65"+
		"\3\66\3\66\3\66\3\66\3\67\3\67\3\67\5\67\u02d9\n\67\38\38\38\39\39\39"+
		"\39\59\u02e2\n9\3:\3:\3:\3:\5:\u02e8\n:\3;\3;\3;\7;\u02ed\n;\f;\16;\u02f0"+
		"\13;\3;\3;\5;\u02f4\n;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3=\3=\3=\5=\u0302\n"+
		"=\3=\3=\3=\3=\3=\5=\u0309\n=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\5=\u0315\n"+
		"=\3=\5=\u0318\n=\5=\u031a\n=\3>\3>\3>\3>\5>\u0320\n>\3?\3?\5?\u0324\n"+
		"?\3?\3?\3?\3@\3@\3@\3A\3A\3A\5A\u032f\nA\3A\5A\u0332\nA\5A\u0334\nA\3"+
		"B\3B\5B\u0338\nB\3C\3C\3D\7D\u033d\nD\fD\16D\u0340\13D\3E\3E\5E\u0344"+
		"\nE\3F\3F\3F\7F\u0349\nF\fF\16F\u034c\13F\3F\3F\3G\3G\6G\u0352\nG\rG\16"+
		"G\u0353\3H\6H\u0357\nH\rH\16H\u0358\3I\7I\u035c\nI\fI\16I\u035f\13I\3"+
		"I\3I\3J\3J\3J\2\5\6$*K\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,"+
		".\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\2\t\4\2\3\3\34\36\5\2\20\20\60\60"+
		"88\3\2\"#\4\2\20\20\60\60\3\2%\'\3\2()\4\2\7\7\60\60\2\u03ad\2\u00a1\3"+
		"\2\2\2\4\u00a3\3\2\2\2\6\u00b7\3\2\2\2\b\u00c6\3\2\2\2\n\u00d5\3\2\2\2"+
		"\f\u00d7\3\2\2\2\16\u00df\3\2\2\2\20\u00ea\3\2\2\2\22\u00ec\3\2\2\2\24"+
		"\u00f5\3\2\2\2\26\u00ff\3\2\2\2\30\u0101\3\2\2\2\32\u0108\3\2\2\2\34\u0111"+
		"\3\2\2\2\36\u015c\3\2\2\2 \u015e\3\2\2\2\"\u0160\3\2\2\2$\u016f\3\2\2"+
		"\2&\u017e\3\2\2\2(\u018d\3\2\2\2*\u019c\3\2\2\2,\u01ab\3\2\2\2.\u01c8"+
		"\3\2\2\2\60\u01ca\3\2\2\2\62\u01cf\3\2\2\2\64\u01df\3\2\2\2\66\u01eb\3"+
		"\2\2\28\u01ed\3\2\2\2:\u01f9\3\2\2\2<\u0201\3\2\2\2>\u020f\3\2\2\2@\u0230"+
		"\3\2\2\2B\u0239\3\2\2\2D\u023e\3\2\2\2F\u0242\3\2\2\2H\u024a\3\2\2\2J"+
		"\u0252\3\2\2\2L\u0261\3\2\2\2N\u0266\3\2\2\2P\u026a\3\2\2\2R\u0272\3\2"+
		"\2\2T\u027d\3\2\2\2V\u028a\3\2\2\2X\u0295\3\2\2\2Z\u029d\3\2\2\2\\\u029f"+
		"\3\2\2\2^\u02a1\3\2\2\2`\u02a5\3\2\2\2b\u02aa\3\2\2\2d\u02c3\3\2\2\2f"+
		"\u02cb\3\2\2\2h\u02cd\3\2\2\2j\u02d1\3\2\2\2l\u02d5\3\2\2\2n\u02da\3\2"+
		"\2\2p\u02e1\3\2\2\2r\u02e7\3\2\2\2t\u02e9\3\2\2\2v\u02f8\3\2\2\2x\u0319"+
		"\3\2\2\2z\u031f\3\2\2\2|\u0321\3\2\2\2~\u0328\3\2\2\2\u0080\u0333\3\2"+
		"\2\2\u0082\u0335\3\2\2\2\u0084\u0339\3\2\2\2\u0086\u033e\3\2\2\2\u0088"+
		"\u0343\3\2\2\2\u008a\u0345\3\2\2\2\u008c\u034f\3\2\2\2\u008e\u0356\3\2"+
		"\2\2\u0090\u035d\3\2\2\2\u0092\u0362\3\2\2\2\u0094\u0096\7\3\2\2\u0095"+
		"\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u00a2\7\64"+
		"\2\2\u0098\u009a\7\3\2\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u00a2\7\66\2\2\u009c\u00a2\7\61\2\2\u009d\u00a2\7"+
		"\62\2\2\u009e\u00a2\7\65\2\2\u009f\u00a2\7\63\2\2\u00a0\u00a2\7\4\2\2"+
		"\u00a1\u0095\3\2\2\2\u00a1\u0099\3\2\2\2\u00a1\u009c\3\2\2\2\u00a1\u009d"+
		"\3\2\2\2\u00a1\u009e\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2"+
		"\3\3\2\2\2\u00a3\u00a8\7\60\2\2\u00a4\u00a5\7\5\2\2\u00a5\u00a7\7\60\2"+
		"\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9"+
		"\3\2\2\2\u00a9\5\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\b\4\1\2\u00ac"+
		"\u00b8\7\60\2\2\u00ad\u00ae\7\60\2\2\u00ae\u00b0\7\6\2\2\u00af\u00ad\3"+
		"\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b5\3\2\2\2\u00b1\u00b6\7\7\2\2\u00b2"+
		"\u00b3\7\b\2\2\u00b3\u00b4\7\6\2\2\u00b4\u00b6\7\60\2\2\u00b5\u00b1\3"+
		"\2\2\2\u00b5\u00b2\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00ab\3\2\2\2\u00b7"+
		"\u00af\3\2\2\2\u00b8\u00be\3\2\2\2\u00b9\u00ba\f\4\2\2\u00ba\u00bb\7\6"+
		"\2\2\u00bb\u00bd\7\60\2\2\u00bc\u00b9\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\7\3\2\2\2\u00c0\u00be\3\2\2\2"+
		"\u00c1\u00c2\5\n\6\2\u00c2\u00c3\7\t\2\2\u00c3\u00c4\5\b\5\2\u00c4\u00c7"+
		"\3\2\2\2\u00c5\u00c7\5\f\7\2\u00c6\u00c1\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7"+
		"\t\3\2\2\2\u00c8\u00d6\5\f\7\2\u00c9\u00d2\7\n\2\2\u00ca\u00cf\5L\'\2"+
		"\u00cb\u00cc\7\5\2\2\u00cc\u00ce\5L\'\2\u00cd\u00cb\3\2\2\2\u00ce\u00d1"+
		"\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d2\u00ca\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\3\2"+
		"\2\2\u00d4\u00d6\7\13\2\2\u00d5\u00c8\3\2\2\2\u00d5\u00c9\3\2\2\2\u00d6"+
		"\13\3\2\2\2\u00d7\u00dc\5\16\b\2\u00d8\u00d9\7\60\2\2\u00d9\u00db\5\16"+
		"\b\2\u00da\u00d8\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc"+
		"\u00dd\3\2\2\2\u00dd\r\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e0\5\24\13"+
		"\2\u00e0\17\3\2\2\2\u00e1\u00e4\5\6\4\2\u00e2\u00e3\7\6\2\2\u00e3\u00e5"+
		"\7\f\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00eb\3\2\2\2\u00e6"+
		"\u00e7\7\n\2\2\u00e7\u00e8\5\22\n\2\u00e8\u00e9\7\13\2\2\u00e9\u00eb\3"+
		"\2\2\2\u00ea\u00e1\3\2\2\2\u00ea\u00e6\3\2\2\2\u00eb\21\3\2\2\2\u00ec"+
		"\u00f1\5\b\5\2\u00ed\u00ee\7\5\2\2\u00ee\u00f0\5\b\5\2\u00ef\u00ed\3\2"+
		"\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\23\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f6\7<\2\2\u00f5\u00f4\3\2\2\2"+
		"\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f9\7\r\2\2\u00f8\u00fa"+
		"\5\26\f\2\u00f9\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00f9\3\2\2\2"+
		"\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\7\16\2\2\u00fe\25"+
		"\3\2\2\2\u00ff\u0100\5f\64\2\u0100\27\3\2\2\2\u0101\u0102\5\b\5\2\u0102"+
		"\31\3\2\2\2\u0103\u0104\7\17\2\2\u0104\u0109\5\f\7\2\u0105\u0106\7\17"+
		"\2\2\u0106\u0107\7\20\2\2\u0107\u0109\7\21\2\2\u0108\u0103\3\2\2\2\u0108"+
		"\u0105\3\2\2\2\u0109\33\3\2\2\2\u010a\u010d\5V,\2\u010b\u010d\7\20\2\2"+
		"\u010c\u010a\3\2\2\2\u010c\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f"+
		"\7\t\2\2\u010f\u0112\5\34\17\2\u0110\u0112\5\36\20\2\u0111\u010c\3\2\2"+
		"\2\u0111\u0110\3\2\2\2\u0112\35\3\2\2\2\u0113\u0114\7\22\2\2\u0114\u0115"+
		"\7\n\2\2\u0115\u0116\5\34\17\2\u0116\u011a\7\13\2\2\u0117\u0119\7<\2\2"+
		"\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b"+
		"\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u0120\5\34\17\2"+
		"\u011e\u011f\7\23\2\2\u011f\u0121\5\34\17\2\u0120\u011e\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u015d\3\2\2\2\u0122\u0123\7\24\2\2\u0123\u0124\7"+
		"\n\2\2\u0124\u0125\5\34\17\2\u0125\u0129\7\13\2\2\u0126\u0128\7<\2\2\u0127"+
		"\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2"+
		"\2\2\u012a\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012d\5\34\17\2\u012d"+
		"\u015d\3\2\2\2\u012e\u012f\7\25\2\2\u012f\u0132\5\34\17\2\u0130\u0131"+
		"\7\26\2\2\u0131\u0133\5\34\17\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2"+
		"\2\u0133\u0136\3\2\2\2\u0134\u0135\7\27\2\2\u0135\u0137\5\34\17\2\u0136"+
		"\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u015d\3\2\2\2\u0138\u0139\7\30"+
		"\2\2\u0139\u013a\5\34\17\2\u013a\u013b\7\24\2\2\u013b\u013c\7\n\2\2\u013c"+
		"\u013d\5\34\17\2\u013d\u013e\7\13\2\2\u013e\u015d\3\2\2\2\u013f\u0140"+
		"\7\31\2\2\u0140\u015d\5\34\17\2\u0141\u0143\7\32\2\2\u0142\u0144\5\34"+
		"\17\2\u0143\u0142\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u015d\3\2\2\2\u0145"+
		"\u014b\5(\25\2\u0146\u0148\5*\26\2\u0147\u0149\7\20\2\2\u0148\u0147\3"+
		"\2\2\2\u0148\u0149\3\2\2\2\u0149\u014b\3\2\2\2\u014a\u0145\3\2\2\2\u014a"+
		"\u0146\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\7\6\2\2\u014d\u014f\3\2"+
		"\2\2\u014e\u014a\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"\u0151\7\60\2\2\u0151\u0152\7\33\2\2\u0152\u015d\5\34\17\2\u0153\u0154"+
		"\5*\26\2\u0154\u0155\5.\30\2\u0155\u0156\7\33\2\2\u0156\u0157\5\34\17"+
		"\2\u0157\u015d\3\2\2\2\u0158\u015a\5\"\22\2\u0159\u015b\5\32\16\2\u015a"+
		"\u0159\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015d\3\2\2\2\u015c\u0113\3\2"+
		"\2\2\u015c\u0122\3\2\2\2\u015c\u012e\3\2\2\2\u015c\u0138\3\2\2\2\u015c"+
		"\u013f\3\2\2\2\u015c\u0141\3\2\2\2\u015c\u014e\3\2\2\2\u015c\u0153\3\2"+
		"\2\2\u015c\u0158\3\2\2\2\u015d\37\3\2\2\2\u015e\u015f\t\2\2\2\u015f!\3"+
		"\2\2\2\u0160\u0162\5$\23\2\u0161\u0163\7\60\2\2\u0162\u0161\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0169\3\2\2\2\u0164\u0165\5 \21\2\u0165\u0166\5*"+
		"\26\2\u0166\u0168\3\2\2\2\u0167\u0164\3\2\2\2\u0168\u016b\3\2\2\2\u0169"+
		"\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2"+
		"\2\2\u016c\u016e\7<\2\2\u016d\u016c\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"#\3\2\2\2\u016f\u0170\b\23\1\2\u0170\u0171\5&\24\2\u0171\u017a\3\2\2\2"+
		"\u0172\u0173\f\3\2\2\u0173\u0175\7\60\2\2\u0174\u0176\7<\2\2\u0175\u0174"+
		"\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0179\5$\23\4\u0178"+
		"\u0172\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2"+
		"\2\2\u017b%\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u017f\5 \21\2\u017e\u017d"+
		"\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0185\3\2\2\2\u0180\u0186\5(\25\2\u0181"+
		"\u0183\5*\26\2\u0182\u0184\7\20\2\2\u0183\u0182\3\2\2\2\u0183\u0184\3"+
		"\2\2\2\u0184\u0186\3\2\2\2\u0185\u0180\3\2\2\2\u0185\u0181\3\2\2\2\u0186"+
		"\'\3\2\2\2\u0187\u018a\7\37\2\2\u0188\u018b\5\u0082B\2\u0189\u018b\5b"+
		"\62\2\u018a\u0188\3\2\2\2\u018a\u0189\3\2\2\2\u018b\u018e\3\2\2\2\u018c"+
		"\u018e\5\60\31\2\u018d\u0187\3\2\2\2\u018d\u018c\3\2\2\2\u018e)\3\2\2"+
		"\2\u018f\u0190\b\26\1\2\u0190\u019d\5\2\2\2\u0191\u019d\5\6\4\2\u0192"+
		"\u019d\7\20\2\2\u0193\u0195\7\n\2\2\u0194\u0196\5,\27\2\u0195\u0194\3"+
		"\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u019d\7\13\2\2\u0198"+
		"\u0199\5(\25\2\u0199\u019a\7\6\2\2\u019a\u019b\7\60\2\2\u019b\u019d\3"+
		"\2\2\2\u019c\u018f\3\2\2\2\u019c\u0191\3\2\2\2\u019c\u0192\3\2\2\2\u019c"+
		"\u0193\3\2\2\2\u019c\u0198\3\2\2\2\u019d\u01a8\3\2\2\2\u019e\u01a0\f\4"+
		"\2\2\u019f\u01a1\7\20\2\2\u01a0\u019f\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1"+
		"\u01a2\3\2\2\2\u01a2\u01a3\7\6\2\2\u01a3\u01a7\7\60\2\2\u01a4\u01a5\f"+
		"\3\2\2\u01a5\u01a7\5.\30\2\u01a6\u019e\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a7"+
		"\u01aa\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9+\3\2\2\2"+
		"\u01aa\u01a8\3\2\2\2\u01ab\u01b0\5\34\17\2\u01ac\u01ad\7\5\2\2\u01ad\u01af"+
		"\5\34\17\2\u01ae\u01ac\3\2\2\2\u01af\u01b2\3\2\2\2\u01b0\u01ae\3\2\2\2"+
		"\u01b0\u01b1\3\2\2\2\u01b1-\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b3\u01b5\7"+
		"\n\2\2\u01b4\u01b6\5,\27\2\u01b5\u01b4\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6"+
		"\u01b7\3\2\2\2\u01b7\u01c9\7\13\2\2\u01b8\u01bc\7\n\2\2\u01b9\u01ba\5"+
		",\27\2\u01ba\u01bb\7\5\2\2\u01bb\u01bd\3\2\2\2\u01bc\u01b9\3\2\2\2\u01bc"+
		"\u01bd\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf\5\"\22\2\u01bf\u01c0\7"+
		"\17\2\2\u01c0\u01c1\7\20\2\2\u01c1\u01c2\7\21\2\2\u01c2\u01c3\7\13\2\2"+
		"\u01c3\u01c9\3\2\2\2\u01c4\u01c6\7<\2\2\u01c5\u01c4\3\2\2\2\u01c5\u01c6"+
		"\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c9\5\60\31\2\u01c8\u01b3\3\2\2\2"+
		"\u01c8\u01b8\3\2\2\2\u01c8\u01c5\3\2\2\2\u01c9/\3\2\2\2\u01ca\u01cb\7"+
		"\r\2\2\u01cb\u01cc\5\62\32\2\u01cc\u01cd\7\16\2\2\u01cd\61\3\2\2\2\u01ce"+
		"\u01d0\5\64\33\2\u01cf\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01cf\3"+
		"\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d4\3\2\2\2\u01d3\u01d5\5\66\34\2\u01d4"+
		"\u01d3\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\63\3\2\2\2\u01d6\u01e0\5r:\2"+
		"\u01d7\u01d9\5\\/\2\u01d8\u01d7\3\2\2\2\u01d9\u01dc\3\2\2\2\u01da\u01d8"+
		"\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01dd\3\2\2\2\u01dc\u01da\3\2\2\2\u01dd"+
		"\u01e0\5z>\2\u01de\u01e0\5\36\20\2\u01df\u01d6\3\2\2\2\u01df\u01da\3\2"+
		"\2\2\u01df\u01de\3\2\2\2\u01e0\65\3\2\2\2\u01e1\u01ec\5\36\20\2\u01e2"+
		"\u01e7\5V,\2\u01e3\u01e4\7\20\2\2\u01e4\u01e5\7\17\2\2\u01e5\u01e7\5\16"+
		"\b\2\u01e6\u01e2\3\2\2\2\u01e6\u01e3\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8"+
		"\u01e9\7\t\2\2\u01e9\u01ea\5\62\32\2\u01ea\u01ec\3\2\2\2\u01eb\u01e1\3"+
		"\2\2\2\u01eb\u01e6\3\2\2\2\u01ec\67\3\2\2\2\u01ed\u01f2\5:\36\2\u01ee"+
		"\u01ef\7 \2\2\u01ef\u01f1\5:\36\2\u01f0\u01ee\3\2\2\2\u01f1\u01f4\3\2"+
		"\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f39\3\2\2\2\u01f4\u01f2"+
		"\3\2\2\2\u01f5\u01f6\t\3\2\2\u01f6\u01f7\7\17\2\2\u01f7\u01fa\5\30\r\2"+
		"\u01f8\u01fa\5<\37\2\u01f9\u01f5\3\2\2\2\u01f9\u01f8\3\2\2\2\u01fa;\3"+
		"\2\2\2\u01fb\u01fe\7\60\2\2\u01fc\u01fd\7!\2\2\u01fd\u01ff\5> \2\u01fe"+
		"\u01fc\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0202\3\2\2\2\u0200\u0202\5>"+
		" \2\u0201\u01fb\3\2\2\2\u0201\u0200\3\2\2\2\u0202=\3\2\2\2\u0203\u0210"+
		"\5@!\2\u0204\u020c\5@!\2\u0205\u0207\7\60\2\2\u0206\u0208\7<\2\2\u0207"+
		"\u0206\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020b\5@"+
		"!\2\u020a\u0205\3\2\2\2\u020b\u020e\3\2\2\2\u020c\u020a\3\2\2\2\u020c"+
		"\u020d\3\2\2\2\u020d\u0210\3\2\2\2\u020e\u020c\3\2\2\2\u020f\u0203\3\2"+
		"\2\2\u020f\u0204\3\2\2\2\u0210?\3\2\2\2\u0211\u0231\7\20\2\2\u0212\u0231"+
		"\7\67\2\2\u0213\u0231\5\2\2\2\u0214\u021a\5\6\4\2\u0215\u0217\7\n\2\2"+
		"\u0216\u0218\5B\"\2\u0217\u0216\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u0219"+
		"\3\2\2\2\u0219\u021b\7\13\2\2\u021a\u0215\3\2\2\2\u021a\u021b\3\2\2\2"+
		"\u021b\u0231\3\2\2\2\u021c\u021d\5\6\4\2\u021d\u0221\7\n\2\2\u021e\u021f"+
		"\5B\"\2\u021f\u0220\7\5\2\2\u0220\u0222\3\2\2\2\u0221\u021e\3\2\2\2\u0221"+
		"\u0222\3\2\2\2\u0222\u0225\3\2\2\2\u0223\u0224\7\60\2\2\u0224\u0226\7"+
		"!\2\2\u0225\u0223\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0227\3\2\2\2\u0227"+
		"\u0228\7\20\2\2\u0228\u0229\7\21\2\2\u0229\u022a\7\13\2\2\u022a\u0231"+
		"\3\2\2\2\u022b\u022d\7\n\2\2\u022c\u022e\5B\"\2\u022d\u022c\3\2\2\2\u022d"+
		"\u022e\3\2\2\2\u022e\u022f\3\2\2\2\u022f\u0231\7\13\2\2\u0230\u0211\3"+
		"\2\2\2\u0230\u0212\3\2\2\2\u0230\u0213\3\2\2\2\u0230\u0214\3\2\2\2\u0230"+
		"\u021c\3\2\2\2\u0230\u022b\3\2\2\2\u0231A\3\2\2\2\u0232\u0235\58\35\2"+
		"\u0233\u0234\7\5\2\2\u0234\u0236\5B\"\2\u0235\u0233\3\2\2\2\u0235\u0236"+
		"\3\2\2\2\u0236\u023a\3\2\2\2\u0237\u0238\7\20\2\2\u0238\u023a\7\21\2\2"+
		"\u0239\u0232\3\2\2\2\u0239\u0237\3\2\2\2\u023aC\3\2\2\2\u023b\u023d\5"+
		"F$\2\u023c\u023b\3\2\2\2\u023d\u0240\3\2\2\2\u023e\u023c\3\2\2\2\u023e"+
		"\u023f\3\2\2\2\u023fE\3\2\2\2\u0240\u023e\3\2\2\2\u0241\u0243\7<\2\2\u0242"+
		"\u0241\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0244\3\2\2\2\u0244\u0246\7\n"+
		"\2\2\u0245\u0247\5H%\2\u0246\u0245\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u0248"+
		"\3\2\2\2\u0248\u0249\7\13\2\2\u0249G\3\2\2\2\u024a\u024f\5J&\2\u024b\u024c"+
		"\7\5\2\2\u024c\u024e\5J&\2\u024d\u024b\3\2\2\2\u024e\u0251\3\2\2\2\u024f"+
		"\u024d\3\2\2\2\u024f\u0250\3\2\2\2\u0250I\3\2\2\2\u0251\u024f\3\2\2\2"+
		"\u0252\u0255\7\60\2\2\u0253\u0254\7\17\2\2\u0254\u0256\5L\'\2\u0255\u0253"+
		"\3\2\2\2\u0255\u0256\3\2\2\2\u0256\u0259\3\2\2\2\u0257\u0258\7\33\2\2"+
		"\u0258\u025a\5\34\17\2\u0259\u0257\3\2\2\2\u0259\u025a\3\2\2\2\u025aK"+
		"\3\2\2\2\u025b\u0262\5\b\5\2\u025c\u025d\7\t\2\2\u025d\u0262\5\b\5\2\u025e"+
		"\u025f\5\b\5\2\u025f\u0260\7\21\2\2\u0260\u0262\3\2\2\2\u0261\u025b\3"+
		"\2\2\2\u0261\u025c\3\2\2\2\u0261\u025e\3\2\2\2\u0262M\3\2\2\2\u0263\u0265"+
		"\5P)\2\u0264\u0263\3\2\2\2\u0265\u0268\3\2\2\2\u0266\u0264\3\2\2\2\u0266"+
		"\u0267\3\2\2\2\u0267O\3\2\2\2\u0268\u0266\3\2\2\2\u0269\u026b\7<\2\2\u026a"+
		"\u0269\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u026e\7\n"+
		"\2\2\u026d\u026f\5R*\2\u026e\u026d\3\2\2\2\u026e\u026f\3\2\2\2\u026f\u0270"+
		"\3\2\2\2\u0270\u0271\7\13\2\2\u0271Q\3\2\2\2\u0272\u0277\5T+\2\u0273\u0274"+
		"\7\5\2\2\u0274\u0276\5T+\2\u0275\u0273\3\2\2\2\u0276\u0279\3\2\2\2\u0277"+
		"\u0275\3\2\2\2\u0277\u0278\3\2\2\2\u0278S\3\2\2\2\u0279\u0277\3\2\2\2"+
		"\u027a\u027c\5Z.\2\u027b\u027a\3\2\2\2\u027c\u027f\3\2\2\2\u027d\u027b"+
		"\3\2\2\2\u027d\u027e\3\2\2\2\u027e\u0281\3\2\2\2\u027f\u027d\3\2\2\2\u0280"+
		"\u0282\t\4\2\2\u0281\u0280\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0283\3\2"+
		"\2\2\u0283\u0284\7\60\2\2\u0284\u0285\7\17\2\2\u0285\u0288\5L\'\2\u0286"+
		"\u0287\7\33\2\2\u0287\u0289\5\34\17\2\u0288\u0286\3\2\2\2\u0288\u0289"+
		"\3\2\2\2\u0289U\3\2\2\2\u028a\u028b\7\n\2\2\u028b\u0290\5X-\2\u028c\u028d"+
		"\7\5\2\2\u028d\u028f\5X-\2\u028e\u028c\3\2\2\2\u028f\u0292\3\2\2\2\u0290"+
		"\u028e\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0293\3\2\2\2\u0292\u0290\3\2"+
		"\2\2\u0293\u0294\7\13\2\2\u0294W\3\2\2\2\u0295\u0298\t\5\2\2\u0296\u0297"+
		"\7\17\2\2\u0297\u0299\5\b\5\2\u0298\u0296\3\2\2\2\u0298\u0299\3\2\2\2"+
		"\u0299Y\3\2\2\2\u029a\u029e\5\\/\2\u029b\u029e\5^\60\2\u029c\u029e\7$"+
		"\2\2\u029d\u029a\3\2\2\2\u029d\u029b\3\2\2\2\u029d\u029c\3\2\2\2\u029e"+
		"[\3\2\2\2\u029f\u02a0\t\6\2\2\u02a0]\3\2\2\2\u02a1\u02a3\t\7\2\2\u02a2"+
		"\u02a4\5`\61\2\u02a3\u02a2\3\2\2\2\u02a3\u02a4\3\2\2\2\u02a4_\3\2\2\2"+
		"\u02a5\u02a6\7*\2\2\u02a6\u02a7\t\b\2\2\u02a7\u02a8\7+\2\2\u02a8a\3\2"+
		"\2\2\u02a9\u02ab\7<\2\2\u02aa\u02a9\3\2\2\2\u02aa\u02ab\3\2\2\2\u02ab"+
		"\u02ac\3\2\2\2\u02ac\u02ae\7\r\2\2\u02ad\u02af\5d\63\2\u02ae\u02ad\3\2"+
		"\2\2\u02af\u02b0\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1"+
		"\u02b2\3\2\2\2\u02b2\u02b3\7\16\2\2\u02b3c\3\2\2\2\u02b4\u02b6\5Z.\2\u02b5"+
		"\u02b4\3\2\2\2\u02b6\u02b9\3\2\2\2\u02b7\u02b5\3\2\2\2\u02b7\u02b8\3\2"+
		"\2\2\u02b8\u02ba\3\2\2\2\u02b9\u02b7\3\2\2\2\u02ba\u02c4\5r:\2\u02bb\u02bd"+
		"\5Z.\2\u02bc\u02bb\3\2\2\2\u02bd\u02c0\3\2\2\2\u02be\u02bc\3\2\2\2\u02be"+
		"\u02bf\3\2\2\2\u02bf\u02c1\3\2\2\2\u02c0\u02be\3\2\2\2\u02c1\u02c4\5f"+
		"\64\2\u02c2\u02c4\5\34\17\2\u02c3\u02b7\3\2\2\2\u02c3\u02be\3\2\2\2\u02c3"+
		"\u02c2\3\2\2\2\u02c4e\3\2\2\2\u02c5\u02c6\7\"\2\2\u02c6\u02cc\5h\65\2"+
		"\u02c7\u02c8\7#\2\2\u02c8\u02cc\5j\66\2\u02c9\u02ca\7,\2\2\u02ca\u02cc"+
		"\5l\67\2\u02cb\u02c5\3\2\2\2\u02cb\u02c7\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cc"+
		"g\3\2\2\2\u02cd\u02ce\5\4\3\2\u02ce\u02cf\7\17\2\2\u02cf\u02d0\5\b\5\2"+
		"\u02d0i\3\2\2\2\u02d1\u02d2\5\4\3\2\u02d2\u02d3\7\17\2\2\u02d3\u02d4\5"+
		"\b\5\2\u02d4k\3\2\2\2\u02d5\u02d8\5n8\2\u02d6\u02d7\7\17\2\2\u02d7\u02d9"+
		"\5\b\5\2\u02d8\u02d6\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9m\3\2\2\2\u02da"+
		"\u02db\7\60\2\2\u02db\u02dc\5D#\2\u02dco\3\2\2\2\u02dd\u02de\7\"\2\2\u02de"+
		"\u02e2\5t;\2\u02df\u02e0\7#\2\2\u02e0\u02e2\5v<\2\u02e1\u02dd\3\2\2\2"+
		"\u02e1\u02df\3\2\2\2\u02e2q\3\2\2\2\u02e3\u02e8\5p9\2\u02e4\u02e5\7,\2"+
		"\2\u02e5\u02e8\5x=\2\u02e6\u02e8\5z>\2\u02e7\u02e3\3\2\2\2\u02e7\u02e4"+
		"\3\2\2\2\u02e7\u02e6\3\2\2\2\u02e8s\3\2\2\2\u02e9\u02ee\5<\37\2\u02ea"+
		"\u02eb\7\5\2\2\u02eb\u02ed\5<\37\2\u02ec\u02ea\3\2\2\2\u02ed\u02f0\3\2"+
		"\2\2\u02ee\u02ec\3\2\2\2\u02ee\u02ef\3\2\2\2\u02ef\u02f3\3\2\2\2\u02f0"+
		"\u02ee\3\2\2\2\u02f1\u02f2\7\17\2\2\u02f2\u02f4\5\b\5\2\u02f3\u02f1\3"+
		"\2\2\2\u02f3\u02f4\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5\u02f6\7\33\2\2\u02f6"+
		"\u02f7\5\34\17\2\u02f7u\3\2\2\2\u02f8\u02f9\5\4\3\2\u02f9\u02fa\7\17\2"+
		"\2\u02fa\u02fb\5\b\5\2\u02fb\u02fc\7\33\2\2\u02fc\u02fd\7\20\2\2\u02fd"+
		"w\3\2\2\2\u02fe\u0301\5n8\2\u02ff\u0300\7\17\2\2\u0300\u0302\5\b\5\2\u0301"+
		"\u02ff\3\2\2\2\u0301\u0302\3\2\2\2\u0302\u0303\3\2\2\2\u0303\u0304\7\33"+
		"\2\2\u0304\u0305\5\34\17\2\u0305\u031a\3\2\2\2\u0306\u0308\5n8\2\u0307"+
		"\u0309\7<\2\2\u0308\u0307\3\2\2\2\u0308\u0309\3\2\2\2\u0309\u030a\3\2"+
		"\2\2\u030a\u030b\7\r\2\2\u030b\u030c\5\62\32\2\u030c\u030d\7\16\2\2\u030d"+
		"\u031a\3\2\2\2\u030e\u030f\7\7\2\2\u030f\u0310\5F$\2\u0310\u0317\5D#\2"+
		"\u0311\u0312\7\33\2\2\u0312\u0318\5\u0088E\2\u0313\u0315\7<\2\2\u0314"+
		"\u0313\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0316\3\2\2\2\u0316\u0318\5\u008a"+
		"F\2\u0317\u0311\3\2\2\2\u0317\u0314\3\2\2\2\u0318\u031a\3\2\2\2\u0319"+
		"\u02fe\3\2\2\2\u0319\u0306\3\2\2\2\u0319\u030e\3\2\2\2\u031ay\3\2\2\2"+
		"\u031b\u031c\7-\2\2\u031c\u0320\5|?\2\u031d\u031e\7.\2\2\u031e\u0320\5"+
		"~@\2\u031f\u031b\3\2\2\2\u031f\u031d\3\2\2\2\u0320{\3\2\2\2\u0321\u0323"+
		"\7\60\2\2\u0322\u0324\5^\60\2\u0323\u0322\3\2\2\2\u0323\u0324\3\2\2\2"+
		"\u0324\u0325\3\2\2\2\u0325\u0326\5N(\2\u0326\u0327\5\u0080A\2\u0327}\3"+
		"\2\2\2\u0328\u0329\7\60\2\2\u0329\u032a\5\u0080A\2\u032a\177\3\2\2\2\u032b"+
		"\u032c\7/\2\2\u032c\u0334\5\u0082B\2\u032d\u032f\7/\2\2\u032e\u032d\3"+
		"\2\2\2\u032e\u032f\3\2\2\2\u032f\u0330\3\2\2\2\u0330\u0332\5b\62\2\u0331"+
		"\u032e\3\2\2\2\u0331\u0332\3\2\2\2\u0332\u0334\3\2\2\2\u0333\u032b\3\2"+
		"\2\2\u0333\u0331\3\2\2\2\u0334\u0081\3\2\2\2\u0335\u0337\5\u0084C\2\u0336"+
		"\u0338\5b\62\2\u0337\u0336\3\2\2\2\u0337\u0338\3\2\2\2\u0338\u0083\3\2"+
		"\2\2\u0339\u033a\5\u0086D\2\u033a\u0085\3\2\2\2\u033b\u033d\5.\30\2\u033c"+
		"\u033b\3\2\2\2\u033d\u0340\3\2\2\2\u033e\u033c\3\2\2\2\u033e\u033f\3\2"+
		"\2\2\u033f\u0087\3\2\2\2\u0340\u033e\3\2\2\2\u0341\u0344\5\u008cG\2\u0342"+
		"\u0344\5\u008aF\2\u0343\u0341\3\2\2\2\u0343\u0342\3\2\2\2\u0344\u0089"+
		"\3\2\2\2\u0345\u0346\7\r\2\2\u0346\u034a\5\u008cG\2\u0347\u0349\5\64\33"+
		"\2\u0348\u0347\3\2\2\2\u0349\u034c\3\2\2\2\u034a\u0348\3\2\2\2\u034a\u034b"+
		"\3\2\2\2\u034b\u034d\3\2\2\2\u034c\u034a\3\2\2\2\u034d\u034e\7\16\2\2"+
		"\u034e\u008b\3\2\2\2\u034f\u0351\7\7\2\2\u0350\u0352\5.\30\2\u0351\u0350"+
		"\3\2\2\2\u0352\u0353\3\2\2\2\u0353\u0351\3\2\2\2\u0353\u0354\3\2\2\2\u0354"+
		"\u008d\3\2\2\2\u0355\u0357\5\u0090I\2\u0356\u0355\3\2\2\2\u0357\u0358"+
		"\3\2\2\2\u0358\u0356\3\2\2\2\u0358\u0359\3\2\2\2\u0359\u008f\3\2\2\2\u035a"+
		"\u035c\5Z.\2\u035b\u035a\3\2\2\2\u035c\u035f\3\2\2\2\u035d\u035b\3\2\2"+
		"\2\u035d\u035e\3\2\2\2\u035e\u0360\3\2\2\2\u035f\u035d\3\2\2\2\u0360\u0361"+
		"\5z>\2\u0361\u0091\3\2\2\2\u0362\u0363\5\u008eH\2\u0363\u0093\3\2\2\2"+
		"y\u0095\u0099\u00a1\u00a8\u00af\u00b5\u00b7\u00be\u00c6\u00cf\u00d2\u00d5"+
		"\u00dc\u00e4\u00ea\u00f1\u00f5\u00fb\u0108\u010c\u0111\u011a\u0120\u0129"+
		"\u0132\u0136\u0143\u0148\u014a\u014e\u015a\u015c\u0162\u0169\u016d\u0175"+
		"\u017a\u017e\u0183\u0185\u018a\u018d\u0195\u019c\u01a0\u01a6\u01a8\u01b0"+
		"\u01b5\u01bc\u01c5\u01c8\u01d1\u01d4\u01da\u01df\u01e6\u01eb\u01f2\u01f9"+
		"\u01fe\u0201\u0207\u020c\u020f\u0217\u021a\u0221\u0225\u022d\u0230\u0235"+
		"\u0239\u023e\u0242\u0246\u024f\u0255\u0259\u0261\u0266\u026a\u026e\u0277"+
		"\u027d\u0281\u0288\u0290\u0298\u029d\u02a3\u02aa\u02b0\u02b7\u02be\u02c3"+
		"\u02cb\u02d8\u02e1\u02e7\u02ee\u02f3\u0301\u0308\u0314\u0317\u0319\u031f"+
		"\u0323\u032e\u0331\u0333\u0337\u033e\u0343\u034a\u0353\u0358\u035d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}