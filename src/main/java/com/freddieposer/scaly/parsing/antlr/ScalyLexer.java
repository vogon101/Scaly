// Generated from C:/Users/fredd/Google Drive/10. Cambridge/1. Work/6. Part II Dissertation/Scaly/src/main/grammar\Scaly.g4 by ANTLR 4.8
package com.freddieposer.scaly.parsing.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ScalyLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42", "T__43", "T__44", "Id", "BooleanLiteral", "CharacterLiteral", 
			"SymbolLiteral", "IntegerLiteral", "StringLiteral", "FloatingPointLiteral", 
			"Varid", "BoundVarid", "Paren", "Delim", "Semi", "NL", "CharNoBackQuoteOrNewline", 
			"UnicodeEscape", "WhiteSpace", "Opchar", "Op", "Idrest", "StringElement", 
			"MultiLineChars", "HexDigit", "FloatType", "Upper", "Lower", "Letter", 
			"ExponentPart", "PrintableChar", "PrintableCharExceptWhitespace", "CharEscapeSeq", 
			"DecimalNumeral", "HexNumeral", "Digit", "NonZeroDigit", "VaridFragment", 
			"Plainid", "UnicodeLetter", "UnicodeClass_LU", "UnicodeClass_LL", "UnicodeClass_LT", 
			"UnicodeClass_LM", "UnicodeClass_LO", "UnicodeDigit", "NEWLINE", "WS", 
			"COMMENT", "LINE_COMMENT"
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


	public ScalyLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Scaly.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2@\u02b3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3 \3"+
		" \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3*\3*\3+\3+\3+\3+\3"+
		",\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/\3"+
		"/\3/\3/\6/\u0183\n/\r/\16/\u0184\3/\3/\5/\u0189\n/\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\5\60\u0194\n\60\3\61\3\61\3\61\5\61\u0199\n"+
		"\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\5\63\u01a2\n\63\3\63\5\63\u01a5"+
		"\n\63\3\64\3\64\7\64\u01a9\n\64\f\64\16\64\u01ac\13\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u01b8\n\64\3\65\6\65\u01bb\n"+
		"\65\r\65\16\65\u01bc\3\65\3\65\6\65\u01c1\n\65\r\65\16\65\u01c2\3\65\5"+
		"\65\u01c6\n\65\3\65\5\65\u01c9\n\65\3\65\3\65\6\65\u01cd\n\65\r\65\16"+
		"\65\u01ce\3\65\5\65\u01d2\n\65\3\65\5\65\u01d5\n\65\3\65\3\65\3\65\5\65"+
		"\u01da\n\65\3\65\6\65\u01dd\n\65\r\65\16\65\u01de\3\65\5\65\u01e2\n\65"+
		"\3\65\3\65\5\65\u01e6\n\65\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\5\67"+
		"\u01f0\n\67\38\38\39\39\3:\3:\6:\u01f8\n:\r:\16:\u01f9\5:\u01fc\n:\3:"+
		"\3:\3;\3;\3;\5;\u0203\n;\5;\u0205\n;\3<\3<\3=\3=\3=\5=\u020c\n=\3=\3="+
		"\3=\3=\3=\3>\3>\3?\3?\3@\5@\u0218\n@\3@\6@\u021b\n@\r@\16@\u021c\3A\3"+
		"A\7A\u0221\nA\fA\16A\u0224\13A\3A\3A\5A\u0228\nA\3B\3B\5B\u022c\nB\3C"+
		"\3C\7C\u0230\nC\fC\16C\u0233\13C\3D\3D\3E\3E\3F\3F\5F\u023b\nF\3G\3G\5"+
		"G\u023f\nG\3H\3H\3H\3H\5H\u0245\nH\3I\3I\5I\u0249\nI\3I\6I\u024c\nI\r"+
		"I\16I\u024d\3J\3J\3K\3K\3L\3L\3L\3M\3M\3M\7M\u025a\nM\fM\16M\u025d\13"+
		"M\5M\u025f\nM\3N\3N\3N\3N\6N\u0265\nN\rN\16N\u0266\3O\3O\5O\u026b\nO\3"+
		"P\3P\3Q\3Q\3R\3R\3R\3R\3R\3R\3R\5R\u0278\nR\3S\3S\3S\3S\3S\5S\u027f\n"+
		"S\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\6Z\u028e\nZ\rZ\16Z\u028f\3Z\3"+
		"Z\3[\6[\u0295\n[\r[\16[\u0296\3[\3[\3\\\3\\\3\\\3\\\7\\\u029f\n\\\f\\"+
		"\16\\\u02a2\13\\\3\\\3\\\3\\\3\\\3\\\3]\3]\3]\3]\7]\u02ad\n]\f]\16]\u02b0"+
		"\13]\3]\3]\3\u02a0\2^\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63"+
		"e\64g\65i\66k\67m8o9q:s;u<w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087"+
		"\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099"+
		"\2\u009b\2\u009d\2\u009f\2\u00a1\2\u00a3\2\u00a5\2\u00a7\2\u00a9\2\u00ab"+
		"\2\u00ad\2\u00af\2\u00b1\2\u00b3=\u00b5>\u00b7?\u00b9@\3\2\26\4\2NNnn"+
		"\7\2*+]]__}}\177\177\b\2$$))..\60\60==bb\4\2\"(*\u0080\5\2\13\f\17\17"+
		"\"\"\r\2##%%\'(,-//<<>B^^``~~\u0080\u0080\4\2\"#%\u0081\5\2\62;CHch\6"+
		"\2FFHHffhh\5\2&&C\\aa\4\2GGgg\4\2--//\n\2$$))^^ddhhppttvvT\2C\\\u00c2"+
		"\u00d8\u00da\u00e0\u0102\u0138\u013b\u0149\u014c\u017f\u0183\u0184\u0186"+
		"\u018d\u0190\u0193\u0195\u0196\u0198\u019a\u019e\u019f\u01a1\u01a2\u01a4"+
		"\u01ab\u01ae\u01b5\u01b7\u01be\u01c6\u01cf\u01d1\u01dd\u01e0\u01f0\u01f3"+
		"\u01f6\u01f8\u01fa\u01fc\u0234\u023c\u023d\u023f\u0240\u0243\u0248\u024a"+
		"\u0250\u0372\u0374\u0378\u0381\u0388\u038c\u038e\u03a3\u03a5\u03ad\u03d1"+
		"\u03d6\u03da\u03f0\u03f6\u03f9\u03fb\u03fc\u03ff\u0431\u0462\u0482\u048c"+
		"\u04cf\u04d2\u0530\u0533\u0558\u10a2\u10c7\u10c9\u10cf\u1e02\u1e96\u1ea0"+
		"\u1f00\u1f0a\u1f11\u1f1a\u1f1f\u1f2a\u1f31\u1f3a\u1f41\u1f4a\u1f4f\u1f5b"+
		"\u1f61\u1f6a\u1f71\u1fba\u1fbd\u1fca\u1fcd\u1fda\u1fdd\u1fea\u1fee\u1ffa"+
		"\u1ffd\u2104\u2109\u210d\u210f\u2112\u2114\u2117\u211f\u2126\u212f\u2132"+
		"\u2135\u2140\u2141\u2147\u2185\u2c02\u2c30\u2c62\u2c66\u2c69\u2c72\u2c74"+
		"\u2c77\u2c80\u2c82\u2c84\u2ce4\u2ced\u2cef\u2cf4\ua642\ua644\ua66e\ua682"+
		"\ua69c\ua724\ua730\ua734\ua770\ua77b\ua788\ua78d\ua78f\ua792\ua794\ua798"+
		"\ua7af\ua7b2\ua7b3\uff23\uff3cS\2c|\u00b7\u00f8\u00fa\u0101\u0103\u0179"+
		"\u017c\u0182\u0185\u0187\u018a\u0194\u0197\u019d\u01a0\u01a3\u01a5\u01a7"+
		"\u01aa\u01af\u01b2\u01b6\u01b8\u01c1\u01c8\u01ce\u01d0\u01f5\u01f7\u01fb"+
		"\u01fd\u023b\u023e\u0244\u0249\u0295\u0297\u02b1\u0373\u0375\u0379\u037f"+
		"\u0392\u03d0\u03d2\u03d3\u03d7\u03d9\u03db\u03f5\u03f7\u0461\u0463\u0483"+
		"\u048d\u04c1\u04c4\u0531\u0563\u0589\u1d02\u1d2d\u1d6d\u1d79\u1d7b\u1d9c"+
		"\u1e03\u1e9f\u1ea1\u1f09\u1f12\u1f17\u1f22\u1f29\u1f32\u1f39\u1f42\u1f47"+
		"\u1f52\u1f59\u1f62\u1f69\u1f72\u1f7f\u1f82\u1f89\u1f92\u1f99\u1fa2\u1fa9"+
		"\u1fb2\u1fb6\u1fb8\u1fb9\u1fc0\u1fc6\u1fc8\u1fc9\u1fd2\u1fd5\u1fd8\u1fd9"+
		"\u1fe2\u1fe9\u1ff4\u1ff6\u1ff8\u1ff9\u210c\u2115\u2131\u213b\u213e\u213f"+
		"\u2148\u214b\u2150\u2186\u2c32\u2c60\u2c63\u2c6e\u2c73\u2c7d\u2c83\u2cee"+
		"\u2cf0\u2cf5\u2d02\u2d27\u2d29\u2d2f\ua643\ua66f\ua683\ua69d\ua725\ua733"+
		"\ua735\ua77a\ua77c\ua77e\ua781\ua789\ua78e\ua790\ua793\ua797\ua799\ua7ab"+
		"\ua7fc\uab5c\uab66\uab67\ufb02\ufb08\ufb15\ufb19\uff43\uff5c\b\2\u01c7"+
		"\u01cd\u01f4\u1f91\u1f9a\u1fa1\u1faa\u1fb1\u1fbe\u1fce\u1ffe\u1ffe#\2"+
		"\u02b2\u02c3\u02c8\u02d3\u02e2\u02e6\u02ee\u02f0\u0376\u037c\u055b\u0642"+
		"\u06e7\u06e8\u07f6\u07f7\u07fc\u081c\u0826\u082a\u0973\u0e48\u0ec8\u10fe"+
		"\u17d9\u1845\u1aa9\u1c7f\u1d2e\u1d6c\u1d7a\u1dc1\u2073\u2081\u2092\u209e"+
		"\u2c7e\u2c7f\u2d71\u2e31\u3007\u3037\u303d\u3100\ua017\ua4ff\ua60e\ua681"+
		"\ua69e\ua69f\ua719\ua721\ua772\ua78a\ua7fa\ua7fb\ua9d1\ua9e8\uaa72\uaadf"+
		"\uaaf5\uaaf6\uab5e\uab61\uff72\uffa1\u00ec\2\u00ac\u00bc\u01bd\u01c5\u0296"+
		"\u05ec\u05f2\u05f4\u0622\u0641\u0643\u064c\u0670\u0671\u0673\u06d5\u06d7"+
		"\u06fe\u0701\u0712\u0714\u0731\u074f\u07a7\u07b3\u07ec\u0802\u0817\u0842"+
		"\u085a\u08a2\u08b4\u0906\u093b\u093f\u0952\u095a\u0963\u0974\u0982\u0987"+
		"\u098e\u0991\u0992\u0995\u09aa\u09ac\u09b2\u09b4\u09bb\u09bf\u09d0\u09de"+
		"\u09df\u09e1\u09e3\u09f2\u09f3\u0a07\u0a0c\u0a11\u0a12\u0a15\u0a2a\u0a2c"+
		"\u0a32\u0a34\u0a35\u0a37\u0a38\u0a3a\u0a3b\u0a5b\u0a5e\u0a60\u0a76\u0a87"+
		"\u0a8f\u0a91\u0a93\u0a95\u0aaa\u0aac\u0ab2\u0ab4\u0ab5\u0ab7\u0abb\u0abf"+
		"\u0ad2\u0ae2\u0ae3\u0b07\u0b0e\u0b11\u0b12\u0b15\u0b2a\u0b2c\u0b32\u0b34"+
		"\u0b35\u0b37\u0b3b\u0b3f\u0b63\u0b73\u0b85\u0b87\u0b8c\u0b90\u0b92\u0b94"+
		"\u0b97\u0b9b\u0b9c\u0b9e\u0bac\u0bb0\u0bbb\u0bd2\u0c0e\u0c10\u0c12\u0c14"+
		"\u0c2a\u0c2c\u0c3b\u0c3f\u0c8e\u0c90\u0c92\u0c94\u0caa\u0cac\u0cb5\u0cb7"+
		"\u0cbb\u0cbf\u0ce0\u0ce2\u0ce3\u0cf3\u0cf4\u0d07\u0d0e\u0d10\u0d12\u0d14"+
		"\u0d3c\u0d3f\u0d50\u0d62\u0d63\u0d7c\u0d81\u0d87\u0d98\u0d9c\u0db3\u0db5"+
		"\u0dbd\u0dbf\u0dc8\u0e03\u0e32\u0e34\u0e35\u0e42\u0e47\u0e83\u0e84\u0e86"+
		"\u0e8c\u0e8f\u0e99\u0e9b\u0ea1\u0ea3\u0ea5\u0ea7\u0ea9\u0eac\u0ead\u0eaf"+
		"\u0eb2\u0eb4\u0eb5\u0ebf\u0ec6\u0ede\u0ee1\u0f02\u0f49\u0f4b\u0f6e\u0f8a"+
		"\u0f8e\u1002\u102c\u1041\u1057\u105c\u105f\u1063\u1072\u1077\u1083\u1090"+
		"\u10fc\u10ff\u124a\u124c\u124f\u1252\u1258\u125a\u125f\u1262\u128a\u128c"+
		"\u128f\u1292\u12b2\u12b4\u12b7\u12ba\u12c0\u12c2\u12c7\u12ca\u12d8\u12da"+
		"\u1312\u1314\u1317\u131a\u135c\u1382\u1391\u13a2\u13f6\u1403\u166e\u1671"+
		"\u1681\u1683\u169c\u16a2\u16ec\u16f3\u16fa\u1702\u170e\u1710\u1713\u1722"+
		"\u1733\u1742\u1753\u1762\u176e\u1770\u1772\u1782\u17b5\u17de\u1844\u1846"+
		"\u1879\u1882\u18aa\u18ac\u18f7\u1902\u1920\u1952\u196f\u1972\u1976\u1982"+
		"\u19ad\u19c3\u19c9\u1a02\u1a18\u1a22\u1a56\u1b07\u1b35\u1b47\u1b4d\u1b85"+
		"\u1ba2\u1bb0\u1bb1\u1bbc\u1be7\u1c02\u1c25\u1c4f\u1c51\u1c5c\u1c79\u1ceb"+
		"\u1cee\u1cf0\u1cf3\u1cf7\u1cf8\u2137\u213a\u2d32\u2d69\u2d82\u2d98\u2da2"+
		"\u2da8\u2daa\u2db0\u2db2\u2db8\u2dba\u2dc0\u2dc2\u2dc8\u2dca\u2dd0\u2dd2"+
		"\u2dd8\u2dda\u2de0\u3008\u303e\u3043\u3098\u30a1\u30fc\u3101\u312f\u3133"+
		"\u3190\u31a2\u31bc\u31f2\u3201\u3402\u4db7\u4e02\u9fce\ua002\ua016\ua018"+
		"\ua48e\ua4d2\ua4f9\ua502\ua60d\ua612\ua621\ua62c\ua62d\ua670\ua6e7\ua7f9"+
		"\ua803\ua805\ua807\ua809\ua80c\ua80e\ua824\ua842\ua875\ua884\ua8b5\ua8f4"+
		"\ua8f9\ua8fd\ua927\ua932\ua948\ua962\ua97e\ua986\ua9b4\ua9e2\ua9e6\ua9e9"+
		"\ua9f1\ua9fc\uaa00\uaa02\uaa2a\uaa42\uaa44\uaa46\uaa4d\uaa62\uaa71\uaa73"+
		"\uaa78\uaa7c\uaab1\uaab3\uaabf\uaac2\uaac4\uaadd\uaade\uaae2\uaaec\uaaf4"+
		"\uab08\uab0b\uab10\uab13\uab18\uab22\uab28\uab2a\uab30\uabc2\uabe4\uac02"+
		"\ud7a5\ud7b2\ud7c8\ud7cd\ud7fd\uf902\ufa6f\ufa72\ufadb\ufb1f\ufb2a\ufb2c"+
		"\ufb38\ufb3a\ufb3e\ufb40\ufbb3\ufbd5\ufd3f\ufd52\ufd91\ufd94\ufdc9\ufdf2"+
		"\ufdfd\ufe72\ufe76\ufe78\ufefe\uff68\uff71\uff73\uff9f\uffa2\uffc0\uffc4"+
		"\uffc9\uffcc\uffd1\uffd4\uffd9\uffdc\uffde\'\2\62;\u0662\u066b\u06f2\u06fb"+
		"\u07c2\u07cb\u0968\u0971\u09e8\u09f1\u0a68\u0a71\u0ae8\u0af1\u0b68\u0b71"+
		"\u0be8\u0bf1\u0c68\u0c71\u0ce8\u0cf1\u0d68\u0d71\u0de8\u0df1\u0e52\u0e5b"+
		"\u0ed2\u0edb\u0f22\u0f2b\u1042\u104b\u1092\u109b\u17e2\u17eb\u1812\u181b"+
		"\u1948\u1951\u19d2\u19db\u1a82\u1a8b\u1a92\u1a9b\u1b52\u1b5b\u1bb2\u1bbb"+
		"\u1c42\u1c4b\u1c52\u1c5b\ua622\ua62b\ua8d2\ua8db\ua902\ua90b\ua9d2\ua9db"+
		"\ua9f2\ua9fb\uaa52\uaa5b\uabf2\uabfb\uff12\uff1b\4\2\f\f\17\17\2\u02ce"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5"+
		"\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\3\u00bb\3\2\2\2\5\u00bd\3\2\2"+
		"\2\7\u00c2\3\2\2\2\t\u00c4\3\2\2\2\13\u00c6\3\2\2\2\r\u00cb\3\2\2\2\17"+
		"\u00d1\3\2\2\2\21\u00d4\3\2\2\2\23\u00d6\3\2\2\2\25\u00d8\3\2\2\2\27\u00dd"+
		"\3\2\2\2\31\u00df\3\2\2\2\33\u00e1\3\2\2\2\35\u00e3\3\2\2\2\37\u00e5\3"+
		"\2\2\2!\u00e7\3\2\2\2#\u00ea\3\2\2\2%\u00ef\3\2\2\2\'\u00f5\3\2\2\2)\u00f9"+
		"\3\2\2\2+\u00ff\3\2\2\2-\u0107\3\2\2\2/\u010a\3\2\2\2\61\u0110\3\2\2\2"+
		"\63\u0117\3\2\2\2\65\u0119\3\2\2\2\67\u011b\3\2\2\29\u011d\3\2\2\2;\u011f"+
		"\3\2\2\2=\u0123\3\2\2\2?\u0125\3\2\2\2A\u0127\3\2\2\2C\u012b\3\2\2\2E"+
		"\u012f\3\2\2\2G\u0138\3\2\2\2I\u0141\3\2\2\2K\u0147\3\2\2\2M\u014e\3\2"+
		"\2\2O\u0156\3\2\2\2Q\u0160\3\2\2\2S\u0162\3\2\2\2U\u0164\3\2\2\2W\u0168"+
		"\3\2\2\2Y\u016e\3\2\2\2[\u0175\3\2\2\2]\u0188\3\2\2\2_\u0193\3\2\2\2a"+
		"\u0195\3\2\2\2c\u019c\3\2\2\2e\u01a1\3\2\2\2g\u01b7\3\2\2\2i\u01e5\3\2"+
		"\2\2k\u01e7\3\2\2\2m\u01ef\3\2\2\2o\u01f1\3\2\2\2q\u01f3\3\2\2\2s\u01fb"+
		"\3\2\2\2u\u0204\3\2\2\2w\u0206\3\2\2\2y\u0208\3\2\2\2{\u0212\3\2\2\2}"+
		"\u0214\3\2\2\2\177\u0217\3\2\2\2\u0081\u0222\3\2\2\2\u0083\u022b\3\2\2"+
		"\2\u0085\u0231\3\2\2\2\u0087\u0234\3\2\2\2\u0089\u0236\3\2\2\2\u008b\u023a"+
		"\3\2\2\2\u008d\u023e\3\2\2\2\u008f\u0244\3\2\2\2\u0091\u0246\3\2\2\2\u0093"+
		"\u024f\3\2\2\2\u0095\u0251\3\2\2\2\u0097\u0253\3\2\2\2\u0099\u025e\3\2"+
		"\2\2\u009b\u0260\3\2\2\2\u009d\u026a\3\2\2\2\u009f\u026c\3\2\2\2\u00a1"+
		"\u026e\3\2\2\2\u00a3\u0277\3\2\2\2\u00a5\u027e\3\2\2\2\u00a7\u0280\3\2"+
		"\2\2\u00a9\u0282\3\2\2\2\u00ab\u0284\3\2\2\2\u00ad\u0286\3\2\2\2\u00af"+
		"\u0288\3\2\2\2\u00b1\u028a\3\2\2\2\u00b3\u028d\3\2\2\2\u00b5\u0294\3\2"+
		"\2\2\u00b7\u029a\3\2\2\2\u00b9\u02a8\3\2\2\2\u00bb\u00bc\7/\2\2\u00bc"+
		"\4\3\2\2\2\u00bd\u00be\7p\2\2\u00be\u00bf\7w\2\2\u00bf\u00c0\7n\2\2\u00c0"+
		"\u00c1\7n\2\2\u00c1\6\3\2\2\2\u00c2\u00c3\7.\2\2\u00c3\b\3\2\2\2\u00c4"+
		"\u00c5\7\60\2\2\u00c5\n\3\2\2\2\u00c6\u00c7\7v\2\2\u00c7\u00c8\7j\2\2"+
		"\u00c8\u00c9\7k\2\2\u00c9\u00ca\7u\2\2\u00ca\f\3\2\2\2\u00cb\u00cc\7u"+
		"\2\2\u00cc\u00cd\7w\2\2\u00cd\u00ce\7r\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0"+
		"\7t\2\2\u00d0\16\3\2\2\2\u00d1\u00d2\7?\2\2\u00d2\u00d3\7@\2\2\u00d3\20"+
		"\3\2\2\2\u00d4\u00d5\7*\2\2\u00d5\22\3\2\2\2\u00d6\u00d7\7+\2\2\u00d7"+
		"\24\3\2\2\2\u00d8\u00d9\7v\2\2\u00d9\u00da\7{\2\2\u00da\u00db\7r\2\2\u00db"+
		"\u00dc\7g\2\2\u00dc\26\3\2\2\2\u00dd\u00de\7}\2\2\u00de\30\3\2\2\2\u00df"+
		"\u00e0\7\177\2\2\u00e0\32\3\2\2\2\u00e1\u00e2\7<\2\2\u00e2\34\3\2\2\2"+
		"\u00e3\u00e4\7a\2\2\u00e4\36\3\2\2\2\u00e5\u00e6\7,\2\2\u00e6 \3\2\2\2"+
		"\u00e7\u00e8\7k\2\2\u00e8\u00e9\7h\2\2\u00e9\"\3\2\2\2\u00ea\u00eb\7g"+
		"\2\2\u00eb\u00ec\7n\2\2\u00ec\u00ed\7u\2\2\u00ed\u00ee\7g\2\2\u00ee$\3"+
		"\2\2\2\u00ef\u00f0\7y\2\2\u00f0\u00f1\7j\2\2\u00f1\u00f2\7k\2\2\u00f2"+
		"\u00f3\7n\2\2\u00f3\u00f4\7g\2\2\u00f4&\3\2\2\2\u00f5\u00f6\7v\2\2\u00f6"+
		"\u00f7\7t\2\2\u00f7\u00f8\7{\2\2\u00f8(\3\2\2\2\u00f9\u00fa\7e\2\2\u00fa"+
		"\u00fb\7c\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd\7e\2\2\u00fd\u00fe\7j\2\2"+
		"\u00fe*\3\2\2\2\u00ff\u0100\7h\2\2\u0100\u0101\7k\2\2\u0101\u0102\7p\2"+
		"\2\u0102\u0103\7c\2\2\u0103\u0104\7n\2\2\u0104\u0105\7n\2\2\u0105\u0106"+
		"\7{\2\2\u0106,\3\2\2\2\u0107\u0108\7f\2\2\u0108\u0109\7q\2\2\u0109.\3"+
		"\2\2\2\u010a\u010b\7v\2\2\u010b\u010c\7j\2\2\u010c\u010d\7t\2\2\u010d"+
		"\u010e\7q\2\2\u010e\u010f\7y\2\2\u010f\60\3\2\2\2\u0110\u0111\7t\2\2\u0111"+
		"\u0112\7g\2\2\u0112\u0113\7v\2\2\u0113\u0114\7w\2\2\u0114\u0115\7t\2\2"+
		"\u0115\u0116\7p\2\2\u0116\62\3\2\2\2\u0117\u0118\7?\2\2\u0118\64\3\2\2"+
		"\2\u0119\u011a\7-\2\2\u011a\66\3\2\2\2\u011b\u011c\7\u0080\2\2\u011c8"+
		"\3\2\2\2\u011d\u011e\7#\2\2\u011e:\3\2\2\2\u011f\u0120\7p\2\2\u0120\u0121"+
		"\7g\2\2\u0121\u0122\7y\2\2\u0122<\3\2\2\2\u0123\u0124\7~\2\2\u0124>\3"+
		"\2\2\2\u0125\u0126\7B\2\2\u0126@\3\2\2\2\u0127\u0128\7x\2\2\u0128\u0129"+
		"\7c\2\2\u0129\u012a\7n\2\2\u012aB\3\2\2\2\u012b\u012c\7x\2\2\u012c\u012d"+
		"\7c\2\2\u012d\u012e\7t\2\2\u012eD\3\2\2\2\u012f\u0130\7q\2\2\u0130\u0131"+
		"\7x\2\2\u0131\u0132\7g\2\2\u0132\u0133\7t\2\2\u0133\u0134\7t\2\2\u0134"+
		"\u0135\7k\2\2\u0135\u0136\7f\2\2\u0136\u0137\7g\2\2\u0137F\3\2\2\2\u0138"+
		"\u0139\7c\2\2\u0139\u013a\7d\2\2\u013a\u013b\7u\2\2\u013b\u013c\7v\2\2"+
		"\u013c\u013d\7t\2\2\u013d\u013e\7c\2\2\u013e\u013f\7e\2\2\u013f\u0140"+
		"\7v\2\2\u0140H\3\2\2\2\u0141\u0142\7h\2\2\u0142\u0143\7k\2\2\u0143\u0144"+
		"\7p\2\2\u0144\u0145\7c\2\2\u0145\u0146\7n\2\2\u0146J\3\2\2\2\u0147\u0148"+
		"\7u\2\2\u0148\u0149\7g\2\2\u0149\u014a\7c\2\2\u014a\u014b\7n\2\2\u014b"+
		"\u014c\7g\2\2\u014c\u014d\7f\2\2\u014dL\3\2\2\2\u014e\u014f\7r\2\2\u014f"+
		"\u0150\7t\2\2\u0150\u0151\7k\2\2\u0151\u0152\7x\2\2\u0152\u0153\7c\2\2"+
		"\u0153\u0154\7v\2\2\u0154\u0155\7g\2\2\u0155N\3\2\2\2\u0156\u0157\7r\2"+
		"\2\u0157\u0158\7t\2\2\u0158\u0159\7q\2\2\u0159\u015a\7v\2\2\u015a\u015b"+
		"\7g\2\2\u015b\u015c\7e\2\2\u015c\u015d\7v\2\2\u015d\u015e\7g\2\2\u015e"+
		"\u015f\7f\2\2\u015fP\3\2\2\2\u0160\u0161\7]\2\2\u0161R\3\2\2\2\u0162\u0163"+
		"\7_\2\2\u0163T\3\2\2\2\u0164\u0165\7f\2\2\u0165\u0166\7g\2\2\u0166\u0167"+
		"\7h\2\2\u0167V\3\2\2\2\u0168\u0169\7e\2\2\u0169\u016a\7n\2\2\u016a\u016b"+
		"\7c\2\2\u016b\u016c\7u\2\2\u016c\u016d\7u\2\2\u016dX\3\2\2\2\u016e\u016f"+
		"\7q\2\2\u016f\u0170\7d\2\2\u0170\u0171\7l\2\2\u0171\u0172\7g\2\2\u0172"+
		"\u0173\7e\2\2\u0173\u0174\7v\2\2\u0174Z\3\2\2\2\u0175\u0176\7g\2\2\u0176"+
		"\u0177\7z\2\2\u0177\u0178\7v\2\2\u0178\u0179\7g\2\2\u0179\u017a\7p\2\2"+
		"\u017a\u017b\7f\2\2\u017b\u017c\7u\2\2\u017c\\\3\2\2\2\u017d\u0189\5\u00a3"+
		"R\2\u017e\u0182\7b\2\2\u017f\u0183\5w<\2\u0180\u0183\5y=\2\u0181\u0183"+
		"\5\u0097L\2\u0182\u017f\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0181\3\2\2"+
		"\2\u0183\u0184\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0186"+
		"\3\2\2\2\u0186\u0187\7b\2\2\u0187\u0189\3\2\2\2\u0188\u017d\3\2\2\2\u0188"+
		"\u017e\3\2\2\2\u0189^\3\2\2\2\u018a\u018b\7v\2\2\u018b\u018c\7t\2\2\u018c"+
		"\u018d\7w\2\2\u018d\u0194\7g\2\2\u018e\u018f\7h\2\2\u018f\u0190\7c\2\2"+
		"\u0190\u0191\7n\2\2\u0191\u0192\7u\2\2\u0192\u0194\7g\2\2\u0193\u018a"+
		"\3\2\2\2\u0193\u018e\3\2\2\2\u0194`\3\2\2\2\u0195\u0198\7)\2\2\u0196\u0199"+
		"\5\u0093J\2\u0197\u0199\5\u0097L\2\u0198\u0196\3\2\2\2\u0198\u0197\3\2"+
		"\2\2\u0199\u019a\3\2\2\2\u019a\u019b\7)\2\2\u019bb\3\2\2\2\u019c\u019d"+
		"\7)\2\2\u019d\u019e\5\u00a3R\2\u019ed\3\2\2\2\u019f\u01a2\5\u0099M\2\u01a0"+
		"\u01a2\5\u009bN\2\u01a1\u019f\3\2\2\2\u01a1\u01a0\3\2\2\2\u01a2\u01a4"+
		"\3\2\2\2\u01a3\u01a5\t\2\2\2\u01a4\u01a3\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5"+
		"f\3\2\2\2\u01a6\u01aa\7$\2\2\u01a7\u01a9\5\u0083B\2\u01a8\u01a7\3\2\2"+
		"\2\u01a9\u01ac\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ad"+
		"\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ad\u01b8\7$\2\2\u01ae\u01af\7$\2\2\u01af"+
		"\u01b0\7$\2\2\u01b0\u01b1\7$\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\5\u0085"+
		"C\2\u01b3\u01b4\7$\2\2\u01b4\u01b5\7$\2\2\u01b5\u01b6\7$\2\2\u01b6\u01b8"+
		"\3\2\2\2\u01b7\u01a6\3\2\2\2\u01b7\u01ae\3\2\2\2\u01b8h\3\2\2\2\u01b9"+
		"\u01bb\5\u009dO\2\u01ba\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01ba"+
		"\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01c0\7\60\2\2"+
		"\u01bf\u01c1\5\u009dO\2\u01c0\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2"+
		"\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c5\3\2\2\2\u01c4\u01c6\5\u0091"+
		"I\2\u01c5\u01c4\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c8\3\2\2\2\u01c7"+
		"\u01c9\5\u0089E\2\u01c8\u01c7\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01e6"+
		"\3\2\2\2\u01ca\u01cc\7\60\2\2\u01cb\u01cd\5\u009dO\2\u01cc\u01cb\3\2\2"+
		"\2\u01cd\u01ce\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d1"+
		"\3\2\2\2\u01d0\u01d2\5\u0091I\2\u01d1\u01d0\3\2\2\2\u01d1\u01d2\3\2\2"+
		"\2\u01d2\u01d4\3\2\2\2\u01d3\u01d5\5\u0089E\2\u01d4\u01d3\3\2\2\2\u01d4"+
		"\u01d5\3\2\2\2\u01d5\u01e6\3\2\2\2\u01d6\u01d7\5\u009dO\2\u01d7\u01d9"+
		"\5\u0091I\2\u01d8\u01da\5\u0089E\2\u01d9\u01d8\3\2\2\2\u01d9\u01da\3\2"+
		"\2\2\u01da\u01e6\3\2\2\2\u01db\u01dd\5\u009dO\2\u01dc\u01db\3\2\2\2\u01dd"+
		"\u01de\3\2\2\2\u01de\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e1\3\2"+
		"\2\2\u01e0\u01e2\5\u0091I\2\u01e1\u01e0\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2"+
		"\u01e3\3\2\2\2\u01e3\u01e4\5\u0089E\2\u01e4\u01e6\3\2\2\2\u01e5\u01ba"+
		"\3\2\2\2\u01e5\u01ca\3\2\2\2\u01e5\u01d6\3\2\2\2\u01e5\u01dc\3\2\2\2\u01e6"+
		"j\3\2\2\2\u01e7\u01e8\5\u008dG\2\u01e8\u01e9\5\u0081A\2\u01e9l\3\2\2\2"+
		"\u01ea\u01f0\5k\66\2\u01eb\u01ec\7b\2\2\u01ec\u01ed\5k\66\2\u01ed\u01ee"+
		"\7b\2\2\u01ee\u01f0\3\2\2\2\u01ef\u01ea\3\2\2\2\u01ef\u01eb\3\2\2\2\u01f0"+
		"n\3\2\2\2\u01f1\u01f2\t\3\2\2\u01f2p\3\2\2\2\u01f3\u01f4\t\4\2\2\u01f4"+
		"r\3\2\2\2\u01f5\u01fc\7=\2\2\u01f6\u01f8\5u;\2\u01f7\u01f6\3\2\2\2\u01f8"+
		"\u01f9\3\2\2\2\u01f9\u01f7\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fc\3\2"+
		"\2\2\u01fb\u01f5\3\2\2\2\u01fb\u01f7\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd"+
		"\u01fe\b:\2\2\u01fet\3\2\2\2\u01ff\u0205\7\f\2\2\u0200\u0202\7\17\2\2"+
		"\u0201\u0203\7\f\2\2\u0202\u0201\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0205"+
		"\3\2\2\2\u0204\u01ff\3\2\2\2\u0204\u0200\3\2\2\2\u0205v\3\2\2\2\u0206"+
		"\u0207\t\5\2\2\u0207x\3\2\2\2\u0208\u0209\7^\2\2\u0209\u020b\7w\2\2\u020a"+
		"\u020c\7w\2\2\u020b\u020a\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020d\3\2"+
		"\2\2\u020d\u020e\5\u0087D\2\u020e\u020f\5\u0087D\2\u020f\u0210\5\u0087"+
		"D\2\u0210\u0211\5\u0087D\2\u0211z\3\2\2\2\u0212\u0213\t\6\2\2\u0213|\3"+
		"\2\2\2\u0214\u0215\t\7\2\2\u0215~\3\2\2\2\u0216\u0218\7\61\2\2\u0217\u0216"+
		"\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u021a\3\2\2\2\u0219\u021b\5}?\2\u021a"+
		"\u0219\3\2\2\2\u021b\u021c\3\2\2\2\u021c\u021a\3\2\2\2\u021c\u021d\3\2"+
		"\2\2\u021d\u0080\3\2\2\2\u021e\u0221\5\u008fH\2\u021f\u0221\5\u009dO\2"+
		"\u0220\u021e\3\2\2\2\u0220\u021f\3\2\2\2\u0221\u0224\3\2\2\2\u0222\u0220"+
		"\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u0227\3\2\2\2\u0224\u0222\3\2\2\2\u0225"+
		"\u0226\7a\2\2\u0226\u0228\5\177@\2\u0227\u0225\3\2\2\2\u0227\u0228\3\2"+
		"\2\2\u0228\u0082\3\2\2\2\u0229\u022c\t\b\2\2\u022a\u022c\5\u0097L\2\u022b"+
		"\u0229\3\2\2\2\u022b\u022a\3\2\2\2\u022c\u0084\3\2\2\2\u022d\u0230\5\u0083"+
		"B\2\u022e\u0230\5u;\2\u022f\u022d\3\2\2\2\u022f\u022e\3\2\2\2\u0230\u0233"+
		"\3\2\2\2\u0231\u022f\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0086\3\2\2\2\u0233"+
		"\u0231\3\2\2\2\u0234\u0235\t\t\2\2\u0235\u0088\3\2\2\2\u0236\u0237\t\n"+
		"\2\2\u0237\u008a\3\2\2\2\u0238\u023b\t\13\2\2\u0239\u023b\5\u00a7T\2\u023a"+
		"\u0238\3\2\2\2\u023a\u0239\3\2\2\2\u023b\u008c\3\2\2\2\u023c\u023f\4c"+
		"|\2\u023d\u023f\5\u00a9U\2\u023e\u023c\3\2\2\2\u023e\u023d\3\2\2\2\u023f"+
		"\u008e\3\2\2\2\u0240\u0245\5\u008bF\2\u0241\u0245\5\u008dG\2\u0242\u0245"+
		"\5\u00afX\2\u0243\u0245\5\u00abV\2\u0244\u0240\3\2\2\2\u0244\u0241\3\2"+
		"\2\2\u0244\u0242\3\2\2\2\u0244\u0243\3\2\2\2\u0245\u0090\3\2\2\2\u0246"+
		"\u0248\t\f\2\2\u0247\u0249\t\r\2\2\u0248\u0247\3\2\2\2\u0248\u0249\3\2"+
		"\2\2\u0249\u024b\3\2\2\2\u024a\u024c\5\u009dO\2\u024b\u024a\3\2\2\2\u024c"+
		"\u024d\3\2\2\2\u024d\u024b\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u0092\3\2"+
		"\2\2\u024f\u0250\4\"\u0081\2\u0250\u0094\3\2\2\2\u0251\u0252\4#\u0081"+
		"\2\u0252\u0096\3\2\2\2\u0253\u0254\7^\2\2\u0254\u0255\t\16\2\2\u0255\u0098"+
		"\3\2\2\2\u0256\u025f\7\62\2\2\u0257\u025b\5\u009fP\2\u0258\u025a\5\u009d"+
		"O\2\u0259\u0258\3\2\2\2\u025a\u025d\3\2\2\2\u025b\u0259\3\2\2\2\u025b"+
		"\u025c\3\2\2\2\u025c\u025f\3\2\2\2\u025d\u025b\3\2\2\2\u025e\u0256\3\2"+
		"\2\2\u025e\u0257\3\2\2\2\u025f\u009a\3\2\2\2\u0260\u0261\7\62\2\2\u0261"+
		"\u0262\7z\2\2\u0262\u0264\5\u0087D\2\u0263\u0265\5\u0087D\2\u0264\u0263"+
		"\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u0264\3\2\2\2\u0266\u0267\3\2\2\2\u0267"+
		"\u009c\3\2\2\2\u0268\u026b\7\62\2\2\u0269\u026b\5\u009fP\2\u026a\u0268"+
		"\3\2\2\2\u026a\u0269\3\2\2\2\u026b\u009e\3\2\2\2\u026c\u026d\4\63;\2\u026d"+
		"\u00a0\3\2\2\2\u026e\u026f\5k\66\2\u026f\u00a2\3\2\2\2\u0270\u0271\5\u008b"+
		"F\2\u0271\u0272\5\u0081A\2\u0272\u0278\3\2\2\2\u0273\u0274\5\u008dG\2"+
		"\u0274\u0275\5\u0081A\2\u0275\u0278\3\2\2\2\u0276\u0278\5\177@\2\u0277"+
		"\u0270\3\2\2\2\u0277\u0273\3\2\2\2\u0277\u0276\3\2\2\2\u0278\u00a4\3\2"+
		"\2\2\u0279\u027f\5\u00a7T\2\u027a\u027f\5\u00a9U\2\u027b\u027f\5\u00ab"+
		"V\2\u027c\u027f\5\u00adW\2\u027d\u027f\5\u00afX\2\u027e\u0279\3\2\2\2"+
		"\u027e\u027a\3\2\2\2\u027e\u027b\3\2\2\2\u027e\u027c\3\2\2\2\u027e\u027d"+
		"\3\2\2\2\u027f\u00a6\3\2\2\2\u0280\u0281\t\17\2\2\u0281\u00a8\3\2\2\2"+
		"\u0282\u0283\t\20\2\2\u0283\u00aa\3\2\2\2\u0284\u0285\t\21\2\2\u0285\u00ac"+
		"\3\2\2\2\u0286\u0287\t\22\2\2\u0287\u00ae\3\2\2\2\u0288\u0289\t\23\2\2"+
		"\u0289\u00b0\3\2\2\2\u028a\u028b\t\24\2\2\u028b\u00b2\3\2\2\2\u028c\u028e"+
		"\5u;\2\u028d\u028c\3\2\2\2\u028e\u028f\3\2\2\2\u028f\u028d\3\2\2\2\u028f"+
		"\u0290\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0292\bZ\2\2\u0292\u00b4\3\2"+
		"\2\2\u0293\u0295\5{>\2\u0294\u0293\3\2\2\2\u0295\u0296\3\2\2\2\u0296\u0294"+
		"\3\2\2\2\u0296\u0297\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u0299\b[\2\2\u0299"+
		"\u00b6\3\2\2\2\u029a\u029b\7\61\2\2\u029b\u029c\7,\2\2\u029c\u02a0\3\2"+
		"\2\2\u029d\u029f\13\2\2\2\u029e\u029d\3\2\2\2\u029f\u02a2\3\2\2\2\u02a0"+
		"\u02a1\3\2\2\2\u02a0\u029e\3\2\2\2\u02a1\u02a3\3\2\2\2\u02a2\u02a0\3\2"+
		"\2\2\u02a3\u02a4\7,\2\2\u02a4\u02a5\7\61\2\2\u02a5\u02a6\3\2\2\2\u02a6"+
		"\u02a7\b\\\2\2\u02a7\u00b8\3\2\2\2\u02a8\u02a9\7\61\2\2\u02a9\u02aa\7"+
		"\61\2\2\u02aa\u02ae\3\2\2\2\u02ab\u02ad\n\25\2\2\u02ac\u02ab\3\2\2\2\u02ad"+
		"\u02b0\3\2\2\2\u02ae\u02ac\3\2\2\2\u02ae\u02af\3\2\2\2\u02af\u02b1\3\2"+
		"\2\2\u02b0\u02ae\3\2\2\2\u02b1\u02b2\b]\2\2\u02b2\u00ba\3\2\2\2\64\2\u0182"+
		"\u0184\u0188\u0193\u0198\u01a1\u01a4\u01aa\u01b7\u01bc\u01c2\u01c5\u01c8"+
		"\u01ce\u01d1\u01d4\u01d9\u01de\u01e1\u01e5\u01ef\u01f9\u01fb\u0202\u0204"+
		"\u020b\u0217\u021c\u0220\u0222\u0227\u022b\u022f\u0231\u023a\u023e\u0244"+
		"\u0248\u024d\u025b\u025e\u0266\u026a\u0277\u027e\u028f\u0296\u02a0\u02ae"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}