// Generated from UFO.g4 by ANTLR 4.8

package main.java.parser;
import main.java.data.D_String;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class UFOLexer extends Lexer {
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
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, WS=63, NEWLINE=64, INTEGER=65, FLOAT=66, 
		SYMBOL=67, IDENT=68, STRING=69;
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
			"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
			"T__49", "T__50", "T__51", "T__52", "T__53", "T__54", "T__55", "T__56", 
			"T__57", "T__58", "T__59", "T__60", "T__61", "WS", "NEWLINE", "INTEGER", 
			"FLOAT", "SYMBOL", "IDENT", "STRING", "COMMENT", "DIGIT", "UCASE", "LCASE", 
			"STR_CHAR", "ESCAPED_CHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", "'-'", "'+'", "'not'", "'.'", "':'", "'^'", "'..'", 
			"'*'", "'/'", "'//'", "'%'", "'::'", "':>'", "':?'", "'++'", "'+++'", 
			"'='", "':='", "'=~'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", 
			"'##'", "'in'", "'is'", "'isnot'", "'and'", "'or'", "'xor'", "'('", "')'", 
			"','", "'async'", "'end'", "'`'", "'cobegin'", "'fun'", "'fun#'", "'|'", 
			"'if'", "'then'", "'else'", "'let'", "'loop'", "'do'", "'nondet'", "'''", 
			"'while'", "'{'", "'}'", "'#{'", "'~['", "'${'", "'$['", "'true'", "'false'", 
			"'nil'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "WS", "NEWLINE", "INTEGER", "FLOAT", "SYMBOL", "IDENT", 
			"STRING"
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


	  void normalizeQuotedString() {
	    String text = getText();
	    String withoutQuotes = text.substring(1, text.length() - 1);
	    String unescaped = D_String.unescapify(withoutQuotes);
	    setText(unescaped);
	  }


	public UFOLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "UFO.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 68:
			STRING_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 normalizeQuotedString(); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2G\u01d1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3"+
		"!\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"(\3(\3(\3(\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3,\3,\3,\3,\3,\3"+
		"-\3-\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3"+
		"\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3"+
		"\64\3\64\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\38\38\39\3"+
		"9\39\3:\3:\3:\3;\3;\3;\3<\3<\3<\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3?\3"+
		"?\3?\3?\3@\3@\5@\u0168\n@\3@\3@\3A\5A\u016d\nA\3A\3A\6A\u0171\nA\rA\16"+
		"A\u0172\3B\3B\3B\7B\u0178\nB\fB\16B\u017b\13B\3C\3C\3C\7C\u0180\nC\fC"+
		"\16C\u0183\13C\3C\3C\3C\6C\u0188\nC\rC\16C\u0189\3D\3D\3D\3D\3D\7D\u0191"+
		"\nD\fD\16D\u0194\13D\3E\3E\5E\u0198\nE\3E\3E\3E\3E\7E\u019e\nE\fE\16E"+
		"\u01a1\13E\3E\5E\u01a4\nE\3F\3F\7F\u01a8\nF\fF\16F\u01ab\13F\3F\3F\3F"+
		"\3G\3G\3G\3G\7G\u01b4\nG\fG\16G\u01b7\13G\3G\3G\3G\3G\3G\7G\u01be\nG\f"+
		"G\16G\u01c1\13G\5G\u01c3\nG\3H\3H\3I\3I\3J\3J\3K\3K\5K\u01cd\nK\3L\3L"+
		"\3L\3\u01b5\2M\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g"+
		"\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F"+
		"\u008bG\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\3\2\n\5\2\13\f"+
		"\17\17\"\"\4\2##AA\3\2//\4\2\f\f\17\17\3\2\62;\3\2C\\\3\2c|\7\2\f\f\17"+
		"\17$$))^^\2\u01e3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k"+
		"\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2"+
		"\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2"+
		"\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b"+
		"\3\2\2\2\3\u0099\3\2\2\2\5\u009b\3\2\2\2\7\u009d\3\2\2\2\t\u009f\3\2\2"+
		"\2\13\u00a1\3\2\2\2\r\u00a5\3\2\2\2\17\u00a7\3\2\2\2\21\u00a9\3\2\2\2"+
		"\23\u00ab\3\2\2\2\25\u00ae\3\2\2\2\27\u00b0\3\2\2\2\31\u00b2\3\2\2\2\33"+
		"\u00b5\3\2\2\2\35\u00b7\3\2\2\2\37\u00ba\3\2\2\2!\u00bd\3\2\2\2#\u00c0"+
		"\3\2\2\2%\u00c3\3\2\2\2\'\u00c7\3\2\2\2)\u00c9\3\2\2\2+\u00cc\3\2\2\2"+
		"-\u00cf\3\2\2\2/\u00d2\3\2\2\2\61\u00d5\3\2\2\2\63\u00d7\3\2\2\2\65\u00d9"+
		"\3\2\2\2\67\u00dc\3\2\2\29\u00df\3\2\2\2;\u00e2\3\2\2\2=\u00e5\3\2\2\2"+
		"?\u00e8\3\2\2\2A\u00ee\3\2\2\2C\u00f2\3\2\2\2E\u00f5\3\2\2\2G\u00f9\3"+
		"\2\2\2I\u00fb\3\2\2\2K\u00fd\3\2\2\2M\u00ff\3\2\2\2O\u0105\3\2\2\2Q\u0109"+
		"\3\2\2\2S\u010b\3\2\2\2U\u0113\3\2\2\2W\u0117\3\2\2\2Y\u011c\3\2\2\2["+
		"\u011e\3\2\2\2]\u0121\3\2\2\2_\u0126\3\2\2\2a\u012b\3\2\2\2c\u012f\3\2"+
		"\2\2e\u0134\3\2\2\2g\u0137\3\2\2\2i\u013e\3\2\2\2k\u0140\3\2\2\2m\u0146"+
		"\3\2\2\2o\u0148\3\2\2\2q\u014a\3\2\2\2s\u014d\3\2\2\2u\u0150\3\2\2\2w"+
		"\u0153\3\2\2\2y\u0156\3\2\2\2{\u015b\3\2\2\2}\u0161\3\2\2\2\177\u0167"+
		"\3\2\2\2\u0081\u0170\3\2\2\2\u0083\u0174\3\2\2\2\u0085\u017c\3\2\2\2\u0087"+
		"\u018b\3\2\2\2\u0089\u0197\3\2\2\2\u008b\u01a5\3\2\2\2\u008d\u01c2\3\2"+
		"\2\2\u008f\u01c4\3\2\2\2\u0091\u01c6\3\2\2\2\u0093\u01c8\3\2\2\2\u0095"+
		"\u01cc\3\2\2\2\u0097\u01ce\3\2\2\2\u0099\u009a\7]\2\2\u009a\4\3\2\2\2"+
		"\u009b\u009c\7_\2\2\u009c\6\3\2\2\2\u009d\u009e\7/\2\2\u009e\b\3\2\2\2"+
		"\u009f\u00a0\7-\2\2\u00a0\n\3\2\2\2\u00a1\u00a2\7p\2\2\u00a2\u00a3\7q"+
		"\2\2\u00a3\u00a4\7v\2\2\u00a4\f\3\2\2\2\u00a5\u00a6\7\60\2\2\u00a6\16"+
		"\3\2\2\2\u00a7\u00a8\7<\2\2\u00a8\20\3\2\2\2\u00a9\u00aa\7`\2\2\u00aa"+
		"\22\3\2\2\2\u00ab\u00ac\7\60\2\2\u00ac\u00ad\7\60\2\2\u00ad\24\3\2\2\2"+
		"\u00ae\u00af\7,\2\2\u00af\26\3\2\2\2\u00b0\u00b1\7\61\2\2\u00b1\30\3\2"+
		"\2\2\u00b2\u00b3\7\61\2\2\u00b3\u00b4\7\61\2\2\u00b4\32\3\2\2\2\u00b5"+
		"\u00b6\7\'\2\2\u00b6\34\3\2\2\2\u00b7\u00b8\7<\2\2\u00b8\u00b9\7<\2\2"+
		"\u00b9\36\3\2\2\2\u00ba\u00bb\7<\2\2\u00bb\u00bc\7@\2\2\u00bc \3\2\2\2"+
		"\u00bd\u00be\7<\2\2\u00be\u00bf\7A\2\2\u00bf\"\3\2\2\2\u00c0\u00c1\7-"+
		"\2\2\u00c1\u00c2\7-\2\2\u00c2$\3\2\2\2\u00c3\u00c4\7-\2\2\u00c4\u00c5"+
		"\7-\2\2\u00c5\u00c6\7-\2\2\u00c6&\3\2\2\2\u00c7\u00c8\7?\2\2\u00c8(\3"+
		"\2\2\2\u00c9\u00ca\7<\2\2\u00ca\u00cb\7?\2\2\u00cb*\3\2\2\2\u00cc\u00cd"+
		"\7?\2\2\u00cd\u00ce\7\u0080\2\2\u00ce,\3\2\2\2\u00cf\u00d0\7?\2\2\u00d0"+
		"\u00d1\7?\2\2\u00d1.\3\2\2\2\u00d2\u00d3\7#\2\2\u00d3\u00d4\7?\2\2\u00d4"+
		"\60\3\2\2\2\u00d5\u00d6\7>\2\2\u00d6\62\3\2\2\2\u00d7\u00d8\7@\2\2\u00d8"+
		"\64\3\2\2\2\u00d9\u00da\7>\2\2\u00da\u00db\7?\2\2\u00db\66\3\2\2\2\u00dc"+
		"\u00dd\7@\2\2\u00dd\u00de\7?\2\2\u00de8\3\2\2\2\u00df\u00e0\7%\2\2\u00e0"+
		"\u00e1\7%\2\2\u00e1:\3\2\2\2\u00e2\u00e3\7k\2\2\u00e3\u00e4\7p\2\2\u00e4"+
		"<\3\2\2\2\u00e5\u00e6\7k\2\2\u00e6\u00e7\7u\2\2\u00e7>\3\2\2\2\u00e8\u00e9"+
		"\7k\2\2\u00e9\u00ea\7u\2\2\u00ea\u00eb\7p\2\2\u00eb\u00ec\7q\2\2\u00ec"+
		"\u00ed\7v\2\2\u00ed@\3\2\2\2\u00ee\u00ef\7c\2\2\u00ef\u00f0\7p\2\2\u00f0"+
		"\u00f1\7f\2\2\u00f1B\3\2\2\2\u00f2\u00f3\7q\2\2\u00f3\u00f4\7t\2\2\u00f4"+
		"D\3\2\2\2\u00f5\u00f6\7z\2\2\u00f6\u00f7\7q\2\2\u00f7\u00f8\7t\2\2\u00f8"+
		"F\3\2\2\2\u00f9\u00fa\7*\2\2\u00faH\3\2\2\2\u00fb\u00fc\7+\2\2\u00fcJ"+
		"\3\2\2\2\u00fd\u00fe\7.\2\2\u00feL\3\2\2\2\u00ff\u0100\7c\2\2\u0100\u0101"+
		"\7u\2\2\u0101\u0102\7{\2\2\u0102\u0103\7p\2\2\u0103\u0104\7e\2\2\u0104"+
		"N\3\2\2\2\u0105\u0106\7g\2\2\u0106\u0107\7p\2\2\u0107\u0108\7f\2\2\u0108"+
		"P\3\2\2\2\u0109\u010a\7b\2\2\u010aR\3\2\2\2\u010b\u010c\7e\2\2\u010c\u010d"+
		"\7q\2\2\u010d\u010e\7d\2\2\u010e\u010f\7g\2\2\u010f\u0110\7i\2\2\u0110"+
		"\u0111\7k\2\2\u0111\u0112\7p\2\2\u0112T\3\2\2\2\u0113\u0114\7h\2\2\u0114"+
		"\u0115\7w\2\2\u0115\u0116\7p\2\2\u0116V\3\2\2\2\u0117\u0118\7h\2\2\u0118"+
		"\u0119\7w\2\2\u0119\u011a\7p\2\2\u011a\u011b\7%\2\2\u011bX\3\2\2\2\u011c"+
		"\u011d\7~\2\2\u011dZ\3\2\2\2\u011e\u011f\7k\2\2\u011f\u0120\7h\2\2\u0120"+
		"\\\3\2\2\2\u0121\u0122\7v\2\2\u0122\u0123\7j\2\2\u0123\u0124\7g\2\2\u0124"+
		"\u0125\7p\2\2\u0125^\3\2\2\2\u0126\u0127\7g\2\2\u0127\u0128\7n\2\2\u0128"+
		"\u0129\7u\2\2\u0129\u012a\7g\2\2\u012a`\3\2\2\2\u012b\u012c\7n\2\2\u012c"+
		"\u012d\7g\2\2\u012d\u012e\7v\2\2\u012eb\3\2\2\2\u012f\u0130\7n\2\2\u0130"+
		"\u0131\7q\2\2\u0131\u0132\7q\2\2\u0132\u0133\7r\2\2\u0133d\3\2\2\2\u0134"+
		"\u0135\7f\2\2\u0135\u0136\7q\2\2\u0136f\3\2\2\2\u0137\u0138\7p\2\2\u0138"+
		"\u0139\7q\2\2\u0139\u013a\7p\2\2\u013a\u013b\7f\2\2\u013b\u013c\7g\2\2"+
		"\u013c\u013d\7v\2\2\u013dh\3\2\2\2\u013e\u013f\7)\2\2\u013fj\3\2\2\2\u0140"+
		"\u0141\7y\2\2\u0141\u0142\7j\2\2\u0142\u0143\7k\2\2\u0143\u0144\7n\2\2"+
		"\u0144\u0145\7g\2\2\u0145l\3\2\2\2\u0146\u0147\7}\2\2\u0147n\3\2\2\2\u0148"+
		"\u0149\7\177\2\2\u0149p\3\2\2\2\u014a\u014b\7%\2\2\u014b\u014c\7}\2\2"+
		"\u014cr\3\2\2\2\u014d\u014e\7\u0080\2\2\u014e\u014f\7]\2\2\u014ft\3\2"+
		"\2\2\u0150\u0151\7&\2\2\u0151\u0152\7}\2\2\u0152v\3\2\2\2\u0153\u0154"+
		"\7&\2\2\u0154\u0155\7]\2\2\u0155x\3\2\2\2\u0156\u0157\7v\2\2\u0157\u0158"+
		"\7t\2\2\u0158\u0159\7w\2\2\u0159\u015a\7g\2\2\u015az\3\2\2\2\u015b\u015c"+
		"\7h\2\2\u015c\u015d\7c\2\2\u015d\u015e\7n\2\2\u015e\u015f\7u\2\2\u015f"+
		"\u0160\7g\2\2\u0160|\3\2\2\2\u0161\u0162\7p\2\2\u0162\u0163\7k\2\2\u0163"+
		"\u0164\7n\2\2\u0164~\3\2\2\2\u0165\u0168\t\2\2\2\u0166\u0168\5\u008dG"+
		"\2\u0167\u0165\3\2\2\2\u0167\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a"+
		"\b@\2\2\u016a\u0080\3\2\2\2\u016b\u016d\7\17\2\2\u016c\u016b\3\2\2\2\u016c"+
		"\u016d\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u0171\7\f\2\2\u016f\u0171\7\17"+
		"\2\2\u0170\u016c\3\2\2\2\u0170\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172"+
		"\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0082\3\2\2\2\u0174\u0179\5\u008f"+
		"H\2\u0175\u0178\5\u008fH\2\u0176\u0178\7a\2\2\u0177\u0175\3\2\2\2\u0177"+
		"\u0176\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u0179\u017a\3\2"+
		"\2\2\u017a\u0084\3\2\2\2\u017b\u0179\3\2\2\2\u017c\u0181\5\u008fH\2\u017d"+
		"\u0180\5\u008fH\2\u017e\u0180\7a\2\2\u017f\u017d\3\2\2\2\u017f\u017e\3"+
		"\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182"+
		"\u0184\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u0187\7\60\2\2\u0185\u0188\5"+
		"\u008fH\2\u0186\u0188\7a\2\2\u0187\u0185\3\2\2\2\u0187\u0186\3\2\2\2\u0188"+
		"\u0189\3\2\2\2\u0189\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u0086\3\2"+
		"\2\2\u018b\u0192\5\u0091I\2\u018c\u0191\5\u0093J\2\u018d\u0191\5\u0091"+
		"I\2\u018e\u0191\5\u008fH\2\u018f\u0191\7a\2\2\u0190\u018c\3\2\2\2\u0190"+
		"\u018d\3\2\2\2\u0190\u018e\3\2\2\2\u0190\u018f\3\2\2\2\u0191\u0194\3\2"+
		"\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0088\3\2\2\2\u0194"+
		"\u0192\3\2\2\2\u0195\u0198\5\u0093J\2\u0196\u0198\7a\2\2\u0197\u0195\3"+
		"\2\2\2\u0197\u0196\3\2\2\2\u0198\u019f\3\2\2\2\u0199\u019e\5\u0093J\2"+
		"\u019a\u019e\5\u0091I\2\u019b\u019e\5\u008fH\2\u019c\u019e\7a\2\2\u019d"+
		"\u0199\3\2\2\2\u019d\u019a\3\2\2\2\u019d\u019b\3\2\2\2\u019d\u019c\3\2"+
		"\2\2\u019e\u01a1\3\2\2\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\u01a3\3\2\2\2\u01a1\u019f\3\2\2\2\u01a2\u01a4\t\3\2\2\u01a3\u01a2\3\2"+
		"\2\2\u01a3\u01a4\3\2\2\2\u01a4\u008a\3\2\2\2\u01a5\u01a9\7$\2\2\u01a6"+
		"\u01a8\5\u0095K\2\u01a7\u01a6\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01a7"+
		"\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ac\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ac"+
		"\u01ad\7$\2\2\u01ad\u01ae\bF\3\2\u01ae\u008c\3\2\2\2\u01af\u01b0\7=\2"+
		"\2\u01b0\u01b1\7/\2\2\u01b1\u01b5\3\2\2\2\u01b2\u01b4\13\2\2\2\u01b3\u01b2"+
		"\3\2\2\2\u01b4\u01b7\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6"+
		"\u01b8\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b8\u01b9\7/\2\2\u01b9\u01c3\7=\2"+
		"\2\u01ba\u01bb\7=\2\2\u01bb\u01bf\n\4\2\2\u01bc\u01be\n\5\2\2\u01bd\u01bc"+
		"\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0"+
		"\u01c3\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01af\3\2\2\2\u01c2\u01ba\3\2"+
		"\2\2\u01c3\u008e\3\2\2\2\u01c4\u01c5\t\6\2\2\u01c5\u0090\3\2\2\2\u01c6"+
		"\u01c7\t\7\2\2\u01c7\u0092\3\2\2\2\u01c8\u01c9\t\b\2\2\u01c9\u0094\3\2"+
		"\2\2\u01ca\u01cd\n\t\2\2\u01cb\u01cd\5\u0097L\2\u01cc\u01ca\3\2\2\2\u01cc"+
		"\u01cb\3\2\2\2\u01cd\u0096\3\2\2\2\u01ce\u01cf\7^\2\2\u01cf\u01d0\13\2"+
		"\2\2\u01d0\u0098\3\2\2\2\30\2\u0167\u016c\u0170\u0172\u0177\u0179\u017f"+
		"\u0181\u0187\u0189\u0190\u0192\u0197\u019d\u019f\u01a3\u01a9\u01b5\u01bf"+
		"\u01c2\u01cc\4\b\2\2\3F\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}