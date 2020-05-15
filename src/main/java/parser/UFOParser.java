// Generated from UFO.g4 by ANTLR 4.8

package main.java.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class UFOParser extends Parser {
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
	public static final int
		RULE_prog = 0, RULE_any = 1, RULE_prefixOps = 2, RULE_level5ops = 3, RULE_level4ops = 4, 
		RULE_level3ops = 5, RULE_level2ops = 6, RULE_bindingOp = 7, RULE_level1ops = 8, 
		RULE_parenList = 9, RULE_exprSeq = 10, RULE_bindingSeq = 11, RULE_commaSepExprs = 12, 
		RULE_expr = 13, RULE_eAsync = 14, RULE_eBackQuote = 15, RULE_eCobegin = 16, 
		RULE_eFun = 17, RULE_eFunRules = 18, RULE_eIf = 19, RULE_eLet = 20, RULE_eLoop = 21, 
		RULE_eNondet = 22, RULE_eQuote = 23, RULE_eSeq = 24, RULE_eWhile = 25, 
		RULE_collection = 26, RULE_cArray = 27, RULE_cBinding = 28, RULE_cBindingLhs = 29, 
		RULE_cHash = 30, RULE_cList = 31, RULE_cQueue = 32, RULE_cSet = 33, RULE_cStack = 34, 
		RULE_cTerm = 35, RULE_cTermAttrib = 36, RULE_atom = 37, RULE_aBoolean = 38, 
		RULE_aIdent = 39, RULE_aInteger = 40, RULE_aNil = 41, RULE_aReal = 42, 
		RULE_aString = 43, RULE_aSymbol = 44;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "any", "prefixOps", "level5ops", "level4ops", "level3ops", "level2ops", 
			"bindingOp", "level1ops", "parenList", "exprSeq", "bindingSeq", "commaSepExprs", 
			"expr", "eAsync", "eBackQuote", "eCobegin", "eFun", "eFunRules", "eIf", 
			"eLet", "eLoop", "eNondet", "eQuote", "eSeq", "eWhile", "collection", 
			"cArray", "cBinding", "cBindingLhs", "cHash", "cList", "cQueue", "cSet", 
			"cStack", "cTerm", "cTermAttrib", "atom", "aBoolean", "aIdent", "aInteger", 
			"aNil", "aReal", "aString", "aSymbol"
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

	@Override
	public String getGrammarFileName() { return "UFO.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public UFOParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(UFOParser.EOF, 0); }
		public List<AnyContext> any() {
			return getRuleContexts(AnyContext.class);
		}
		public AnyContext any(int i) {
			return getRuleContext(AnyContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(90);
				any(0);
				}
				}
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__37) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (INTEGER - 65)) | (1L << (FLOAT - 65)) | (1L << (SYMBOL - 65)) | (1L << (IDENT - 65)) | (1L << (STRING - 65)))) != 0) );
			setState(95);
			match(EOF);
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

	public static class AnyContext extends ParserRuleContext {
		public AnyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any; }
	 
		public AnyContext() { }
		public void copyFrom(AnyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrefixRuleContext extends AnyContext {
		public PrefixOpsContext op;
		public AnyContext any() {
			return getRuleContext(AnyContext.class,0);
		}
		public PrefixOpsContext prefixOps() {
			return getRuleContext(PrefixOpsContext.class,0);
		}
		public PrefixRuleContext(AnyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterPrefixRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitPrefixRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitPrefixRule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CollectionRuleContext extends AnyContext {
		public CollectionContext collection() {
			return getRuleContext(CollectionContext.class,0);
		}
		public CollectionRuleContext(AnyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterCollectionRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitCollectionRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitCollectionRule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomRuleContext extends AnyContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomRuleContext(AnyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterAtomRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitAtomRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitAtomRule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InfixOpRuleContext extends AnyContext {
		public List<AnyContext> any() {
			return getRuleContexts(AnyContext.class);
		}
		public AnyContext any(int i) {
			return getRuleContext(AnyContext.class,i);
		}
		public Level5opsContext level5ops() {
			return getRuleContext(Level5opsContext.class,0);
		}
		public Level4opsContext level4ops() {
			return getRuleContext(Level4opsContext.class,0);
		}
		public Level3opsContext level3ops() {
			return getRuleContext(Level3opsContext.class,0);
		}
		public Level2opsContext level2ops() {
			return getRuleContext(Level2opsContext.class,0);
		}
		public Level1opsContext level1ops() {
			return getRuleContext(Level1opsContext.class,0);
		}
		public InfixOpRuleContext(AnyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterInfixOpRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitInfixOpRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitInfixOpRule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ApplicationRuleContext extends AnyContext {
		public AnyContext any() {
			return getRuleContext(AnyContext.class,0);
		}
		public ParenListContext parenList() {
			return getRuleContext(ParenListContext.class,0);
		}
		public ApplicationRuleContext(AnyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterApplicationRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitApplicationRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitApplicationRule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BindingOpRuleContext extends AnyContext {
		public List<AnyContext> any() {
			return getRuleContexts(AnyContext.class);
		}
		public AnyContext any(int i) {
			return getRuleContext(AnyContext.class,i);
		}
		public BindingOpContext bindingOp() {
			return getRuleContext(BindingOpContext.class,0);
		}
		public BindingOpRuleContext(AnyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterBindingOpRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitBindingOpRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitBindingOpRule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubscriptRuleContext extends AnyContext {
		public List<AnyContext> any() {
			return getRuleContexts(AnyContext.class);
		}
		public AnyContext any(int i) {
			return getRuleContext(AnyContext.class,i);
		}
		public SubscriptRuleContext(AnyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterSubscriptRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitSubscriptRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitSubscriptRule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprRuleContext extends AnyContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprRuleContext(AnyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterExprRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitExprRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitExprRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnyContext any() throws RecognitionException {
		return any(0);
	}

	private AnyContext any(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AnyContext _localctx = new AnyContext(_ctx, _parentState);
		AnyContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_any, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new PrefixRuleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(98);
				((PrefixRuleContext)_localctx).op = prefixOps();
				setState(99);
				any(12);
				}
				break;
			case 2:
				{
				_localctx = new ExprRuleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101);
				expr();
				}
				break;
			case 3:
				{
				_localctx = new CollectionRuleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				collection();
				}
				break;
			case 4:
				{
				_localctx = new AtomRuleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(103);
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(137);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new InfixOpRuleContext(new AnyContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_any);
						setState(106);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(107);
						level5ops();
						setState(108);
						any(11);
						}
						break;
					case 2:
						{
						_localctx = new InfixOpRuleContext(new AnyContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_any);
						setState(110);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(111);
						level4ops();
						setState(112);
						any(9);
						}
						break;
					case 3:
						{
						_localctx = new InfixOpRuleContext(new AnyContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_any);
						setState(114);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(115);
						level3ops();
						setState(116);
						any(8);
						}
						break;
					case 4:
						{
						_localctx = new InfixOpRuleContext(new AnyContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_any);
						setState(118);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(119);
						level2ops();
						setState(120);
						any(7);
						}
						break;
					case 5:
						{
						_localctx = new BindingOpRuleContext(new AnyContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_any);
						setState(122);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(123);
						bindingOp();
						setState(124);
						any(6);
						}
						break;
					case 6:
						{
						_localctx = new InfixOpRuleContext(new AnyContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_any);
						setState(126);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(127);
						level1ops();
						setState(128);
						any(5);
						}
						break;
					case 7:
						{
						_localctx = new SubscriptRuleContext(new AnyContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_any);
						setState(130);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(131);
						match(T__0);
						setState(132);
						any(0);
						setState(133);
						match(T__1);
						}
						break;
					case 8:
						{
						_localctx = new ApplicationRuleContext(new AnyContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_any);
						setState(135);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(136);
						parenList();
						}
						break;
					}
					} 
				}
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class PrefixOpsContext extends ParserRuleContext {
		public PrefixOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterPrefixOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitPrefixOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitPrefixOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixOpsContext prefixOps() throws RecognitionException {
		PrefixOpsContext _localctx = new PrefixOpsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_prefixOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) ) {
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

	public static class Level5opsContext extends ParserRuleContext {
		public Level5opsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_level5ops; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterLevel5ops(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitLevel5ops(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitLevel5ops(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Level5opsContext level5ops() throws RecognitionException {
		Level5opsContext _localctx = new Level5opsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_level5ops);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if ( !(_la==T__5 || _la==T__6) ) {
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

	public static class Level4opsContext extends ParserRuleContext {
		public Level4opsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_level4ops; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterLevel4ops(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitLevel4ops(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitLevel4ops(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Level4opsContext level4ops() throws RecognitionException {
		Level4opsContext _localctx = new Level4opsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_level4ops);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_la = _input.LA(1);
			if ( !(_la==T__7 || _la==T__8) ) {
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

	public static class Level3opsContext extends ParserRuleContext {
		public Level3opsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_level3ops; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterLevel3ops(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitLevel3ops(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitLevel3ops(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Level3opsContext level3ops() throws RecognitionException {
		Level3opsContext _localctx = new Level3opsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_level3ops);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
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

	public static class Level2opsContext extends ParserRuleContext {
		public Level2opsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_level2ops; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterLevel2ops(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitLevel2ops(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitLevel2ops(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Level2opsContext level2ops() throws RecognitionException {
		Level2opsContext _localctx = new Level2opsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_level2ops);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
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

	public static class BindingOpContext extends ParserRuleContext {
		public BindingOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindingOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterBindingOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitBindingOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitBindingOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingOpContext bindingOp() throws RecognitionException {
		BindingOpContext _localctx = new BindingOpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bindingOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(T__18);
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

	public static class Level1opsContext extends ParserRuleContext {
		public Level1opsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_level1ops; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterLevel1ops(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitLevel1ops(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitLevel1ops(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Level1opsContext level1ops() throws RecognitionException {
		Level1opsContext _localctx = new Level1opsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_level1ops);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) ) {
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

	public static class ParenListContext extends ParserRuleContext {
		public List<AnyContext> any() {
			return getRuleContexts(AnyContext.class);
		}
		public AnyContext any(int i) {
			return getRuleContext(AnyContext.class,i);
		}
		public ParenListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterParenList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitParenList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitParenList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenListContext parenList() throws RecognitionException {
		ParenListContext _localctx = new ParenListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parenList);
		int _la;
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				match(T__34);
				setState(157);
				match(T__35);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				match(T__34);
				setState(159);
				any(0);
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__36) {
					{
					{
					setState(160);
					match(T__36);
					setState(161);
					any(0);
					}
					}
					setState(166);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(167);
				match(T__35);
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

	public static class ExprSeqContext extends ParserRuleContext {
		public List<AnyContext> any() {
			return getRuleContexts(AnyContext.class);
		}
		public AnyContext any(int i) {
			return getRuleContext(AnyContext.class,i);
		}
		public ExprSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterExprSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitExprSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitExprSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprSeqContext exprSeq() throws RecognitionException {
		ExprSeqContext _localctx = new ExprSeqContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_exprSeq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__37) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (INTEGER - 65)) | (1L << (FLOAT - 65)) | (1L << (SYMBOL - 65)) | (1L << (IDENT - 65)) | (1L << (STRING - 65)))) != 0)) {
				{
				{
				setState(171);
				any(0);
				}
				}
				setState(176);
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

	public static class BindingSeqContext extends ParserRuleContext {
		public List<CBindingContext> cBinding() {
			return getRuleContexts(CBindingContext.class);
		}
		public CBindingContext cBinding(int i) {
			return getRuleContext(CBindingContext.class,i);
		}
		public BindingSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindingSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterBindingSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitBindingSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitBindingSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingSeqContext bindingSeq() throws RecognitionException {
		BindingSeqContext _localctx = new BindingSeqContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_bindingSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			cBinding();
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(178);
					match(T__36);
					setState(179);
					cBinding();
					}
					} 
				}
				setState(184);
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
			exitRule();
		}
		return _localctx;
	}

	public static class CommaSepExprsContext extends ParserRuleContext {
		public List<AnyContext> any() {
			return getRuleContexts(AnyContext.class);
		}
		public AnyContext any(int i) {
			return getRuleContext(AnyContext.class,i);
		}
		public CommaSepExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commaSepExprs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterCommaSepExprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitCommaSepExprs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitCommaSepExprs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommaSepExprsContext commaSepExprs() throws RecognitionException {
		CommaSepExprsContext _localctx = new CommaSepExprsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_commaSepExprs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			any(0);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__36) {
				{
				{
				setState(186);
				match(T__36);
				setState(187);
				any(0);
				}
				}
				setState(192);
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

	public static class ExprContext extends ParserRuleContext {
		public EAsyncContext eAsync() {
			return getRuleContext(EAsyncContext.class,0);
		}
		public ECobeginContext eCobegin() {
			return getRuleContext(ECobeginContext.class,0);
		}
		public EFunContext eFun() {
			return getRuleContext(EFunContext.class,0);
		}
		public EIfContext eIf() {
			return getRuleContext(EIfContext.class,0);
		}
		public ELetContext eLet() {
			return getRuleContext(ELetContext.class,0);
		}
		public ELoopContext eLoop() {
			return getRuleContext(ELoopContext.class,0);
		}
		public ENondetContext eNondet() {
			return getRuleContext(ENondetContext.class,0);
		}
		public EQuoteContext eQuote() {
			return getRuleContext(EQuoteContext.class,0);
		}
		public ESeqContext eSeq() {
			return getRuleContext(ESeqContext.class,0);
		}
		public EWhileContext eWhile() {
			return getRuleContext(EWhileContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		try {
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__37:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				eAsync();
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				eCobegin();
				}
				break;
			case T__41:
			case T__42:
				enterOuterAlt(_localctx, 3);
				{
				setState(195);
				eFun();
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 4);
				{
				setState(196);
				eIf();
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 5);
				{
				setState(197);
				eLet();
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 6);
				{
				setState(198);
				eLoop();
				}
				break;
			case T__50:
				enterOuterAlt(_localctx, 7);
				{
				setState(199);
				eNondet();
				}
				break;
			case T__51:
				enterOuterAlt(_localctx, 8);
				{
				setState(200);
				eQuote();
				}
				break;
			case T__49:
				enterOuterAlt(_localctx, 9);
				{
				setState(201);
				eSeq();
				}
				break;
			case T__52:
				enterOuterAlt(_localctx, 10);
				{
				setState(202);
				eWhile();
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

	public static class EAsyncContext extends ParserRuleContext {
		public ExprSeqContext exprSeq() {
			return getRuleContext(ExprSeqContext.class,0);
		}
		public EAsyncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eAsync; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterEAsync(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitEAsync(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitEAsync(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EAsyncContext eAsync() throws RecognitionException {
		EAsyncContext _localctx = new EAsyncContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_eAsync);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__37);
			setState(206);
			exprSeq();
			setState(207);
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

	public static class EBackQuoteContext extends ParserRuleContext {
		public AnyContext any() {
			return getRuleContext(AnyContext.class,0);
		}
		public EBackQuoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eBackQuote; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterEBackQuote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitEBackQuote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitEBackQuote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EBackQuoteContext eBackQuote() throws RecognitionException {
		EBackQuoteContext _localctx = new EBackQuoteContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_eBackQuote);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(T__39);
			setState(210);
			any(0);
			setState(211);
			match(T__39);
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

	public static class ECobeginContext extends ParserRuleContext {
		public ExprSeqContext exprSeq() {
			return getRuleContext(ExprSeqContext.class,0);
		}
		public ECobeginContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eCobegin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterECobegin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitECobegin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitECobegin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ECobeginContext eCobegin() throws RecognitionException {
		ECobeginContext _localctx = new ECobeginContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_eCobegin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(T__40);
			setState(214);
			exprSeq();
			setState(215);
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

	public static class EFunContext extends ParserRuleContext {
		public Token op;
		public EFunRulesContext eFunRules() {
			return getRuleContext(EFunRulesContext.class,0);
		}
		public AIdentContext aIdent() {
			return getRuleContext(AIdentContext.class,0);
		}
		public EFunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eFun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterEFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitEFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitEFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EFunContext eFun() throws RecognitionException {
		EFunContext _localctx = new EFunContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_eFun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			((EFunContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__41 || _la==T__42) ) {
				((EFunContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33))) != 0) || _la==IDENT) {
				{
				setState(218);
				aIdent();
				}
			}

			setState(221);
			eFunRules();
			setState(222);
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

	public static class EFunRulesContext extends ParserRuleContext {
		public ParenListContext parenList() {
			return getRuleContext(ParenListContext.class,0);
		}
		public ExprSeqContext exprSeq() {
			return getRuleContext(ExprSeqContext.class,0);
		}
		public List<EFunRulesContext> eFunRules() {
			return getRuleContexts(EFunRulesContext.class);
		}
		public EFunRulesContext eFunRules(int i) {
			return getRuleContext(EFunRulesContext.class,i);
		}
		public EFunRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eFunRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterEFunRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitEFunRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitEFunRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EFunRulesContext eFunRules() throws RecognitionException {
		EFunRulesContext _localctx = new EFunRulesContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_eFunRules);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			parenList();
			setState(225);
			match(T__18);
			setState(226);
			exprSeq();
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(227);
					match(T__43);
					setState(228);
					eFunRules();
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class EIfContext extends ParserRuleContext {
		public AnyContext any() {
			return getRuleContext(AnyContext.class,0);
		}
		public List<ExprSeqContext> exprSeq() {
			return getRuleContexts(ExprSeqContext.class);
		}
		public ExprSeqContext exprSeq(int i) {
			return getRuleContext(ExprSeqContext.class,i);
		}
		public EIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterEIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitEIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitEIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EIfContext eIf() throws RecognitionException {
		EIfContext _localctx = new EIfContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_eIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(T__44);
			setState(235);
			any(0);
			setState(236);
			match(T__45);
			setState(237);
			exprSeq();
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__46) {
				{
				setState(238);
				match(T__46);
				setState(239);
				exprSeq();
				}
			}

			setState(242);
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

	public static class ELetContext extends ParserRuleContext {
		public BindingSeqContext bindingSeq() {
			return getRuleContext(BindingSeqContext.class,0);
		}
		public ExprSeqContext exprSeq() {
			return getRuleContext(ExprSeqContext.class,0);
		}
		public ELetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eLet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterELet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitELet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitELet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ELetContext eLet() throws RecognitionException {
		ELetContext _localctx = new ELetContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_eLet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(T__47);
			setState(245);
			bindingSeq();
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(246);
				match(T__28);
				setState(247);
				exprSeq();
				setState(248);
				match(T__38);
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

	public static class ELoopContext extends ParserRuleContext {
		public AnyContext any() {
			return getRuleContext(AnyContext.class,0);
		}
		public ExprSeqContext exprSeq() {
			return getRuleContext(ExprSeqContext.class,0);
		}
		public ELoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterELoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitELoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitELoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ELoopContext eLoop() throws RecognitionException {
		ELoopContext _localctx = new ELoopContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_eLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(T__48);
			setState(253);
			any(0);
			setState(254);
			match(T__49);
			setState(255);
			exprSeq();
			setState(256);
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

	public static class ENondetContext extends ParserRuleContext {
		public ExprSeqContext exprSeq() {
			return getRuleContext(ExprSeqContext.class,0);
		}
		public ENondetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eNondet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterENondet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitENondet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitENondet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ENondetContext eNondet() throws RecognitionException {
		ENondetContext _localctx = new ENondetContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_eNondet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(T__50);
			setState(259);
			exprSeq();
			setState(260);
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

	public static class EQuoteContext extends ParserRuleContext {
		public AnyContext any() {
			return getRuleContext(AnyContext.class,0);
		}
		public EQuoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eQuote; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterEQuote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitEQuote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitEQuote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EQuoteContext eQuote() throws RecognitionException {
		EQuoteContext _localctx = new EQuoteContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_eQuote);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(T__51);
			setState(263);
			any(0);
			setState(264);
			match(T__51);
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

	public static class ESeqContext extends ParserRuleContext {
		public ExprSeqContext exprSeq() {
			return getRuleContext(ExprSeqContext.class,0);
		}
		public ESeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterESeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitESeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitESeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ESeqContext eSeq() throws RecognitionException {
		ESeqContext _localctx = new ESeqContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_eSeq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(T__49);
			setState(267);
			exprSeq();
			setState(268);
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

	public static class EWhileContext extends ParserRuleContext {
		public AnyContext any() {
			return getRuleContext(AnyContext.class,0);
		}
		public ExprSeqContext exprSeq() {
			return getRuleContext(ExprSeqContext.class,0);
		}
		public EWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterEWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitEWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitEWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EWhileContext eWhile() throws RecognitionException {
		EWhileContext _localctx = new EWhileContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_eWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(T__52);
			setState(271);
			any(0);
			setState(272);
			match(T__49);
			setState(273);
			exprSeq();
			setState(274);
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

	public static class CollectionContext extends ParserRuleContext {
		public CArrayContext cArray() {
			return getRuleContext(CArrayContext.class,0);
		}
		public CHashContext cHash() {
			return getRuleContext(CHashContext.class,0);
		}
		public CListContext cList() {
			return getRuleContext(CListContext.class,0);
		}
		public CQueueContext cQueue() {
			return getRuleContext(CQueueContext.class,0);
		}
		public CSetContext cSet() {
			return getRuleContext(CSetContext.class,0);
		}
		public CStackContext cStack() {
			return getRuleContext(CStackContext.class,0);
		}
		public CTermContext cTerm() {
			return getRuleContext(CTermContext.class,0);
		}
		public CollectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterCollection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitCollection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitCollection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CollectionContext collection() throws RecognitionException {
		CollectionContext _localctx = new CollectionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_collection);
		try {
			setState(283);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__53:
				enterOuterAlt(_localctx, 1);
				{
				setState(276);
				cArray();
				}
				break;
			case T__55:
				enterOuterAlt(_localctx, 2);
				{
				setState(277);
				cHash();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(278);
				cList();
				}
				break;
			case T__56:
				enterOuterAlt(_localctx, 4);
				{
				setState(279);
				cQueue();
				}
				break;
			case T__57:
				enterOuterAlt(_localctx, 5);
				{
				setState(280);
				cSet();
				}
				break;
			case T__58:
				enterOuterAlt(_localctx, 6);
				{
				setState(281);
				cStack();
				}
				break;
			case SYMBOL:
				enterOuterAlt(_localctx, 7);
				{
				setState(282);
				cTerm();
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

	public static class CArrayContext extends ParserRuleContext {
		public CommaSepExprsContext commaSepExprs() {
			return getRuleContext(CommaSepExprsContext.class,0);
		}
		public CArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterCArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitCArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitCArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CArrayContext cArray() throws RecognitionException {
		CArrayContext _localctx = new CArrayContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_cArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(T__53);
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__37) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (INTEGER - 65)) | (1L << (FLOAT - 65)) | (1L << (SYMBOL - 65)) | (1L << (IDENT - 65)) | (1L << (STRING - 65)))) != 0)) {
				{
				setState(286);
				commaSepExprs();
				}
			}

			setState(289);
			match(T__54);
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

	public static class CBindingContext extends ParserRuleContext {
		public CBindingLhsContext cBindingLhs() {
			return getRuleContext(CBindingLhsContext.class,0);
		}
		public AnyContext any() {
			return getRuleContext(AnyContext.class,0);
		}
		public CBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterCBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitCBinding(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitCBinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CBindingContext cBinding() throws RecognitionException {
		CBindingContext _localctx = new CBindingContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_cBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			cBindingLhs();
			setState(292);
			match(T__18);
			setState(293);
			any(0);
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

	public static class CBindingLhsContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public CollectionContext collection() {
			return getRuleContext(CollectionContext.class,0);
		}
		public EQuoteContext eQuote() {
			return getRuleContext(EQuoteContext.class,0);
		}
		public AnyContext any() {
			return getRuleContext(AnyContext.class,0);
		}
		public CBindingLhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cBindingLhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterCBindingLhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitCBindingLhs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitCBindingLhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CBindingLhsContext cBindingLhs() throws RecognitionException {
		CBindingLhsContext _localctx = new CBindingLhsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_cBindingLhs);
		try {
			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(296);
				collection();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(297);
				eQuote();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(298);
				match(T__34);
				setState(299);
				any(0);
				setState(300);
				match(T__35);
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

	public static class CHashContext extends ParserRuleContext {
		public BindingSeqContext bindingSeq() {
			return getRuleContext(BindingSeqContext.class,0);
		}
		public CHashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cHash; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterCHash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitCHash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitCHash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CHashContext cHash() throws RecognitionException {
		CHashContext _localctx = new CHashContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_cHash);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(T__55);
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__51) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (INTEGER - 65)) | (1L << (FLOAT - 65)) | (1L << (SYMBOL - 65)) | (1L << (IDENT - 65)) | (1L << (STRING - 65)))) != 0)) {
				{
				setState(305);
				bindingSeq();
				}
			}

			setState(308);
			match(T__54);
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

	public static class CListContext extends ParserRuleContext {
		public CommaSepExprsContext commaSepExprs() {
			return getRuleContext(CommaSepExprsContext.class,0);
		}
		public List<AnyContext> any() {
			return getRuleContexts(AnyContext.class);
		}
		public AnyContext any(int i) {
			return getRuleContext(AnyContext.class,i);
		}
		public CListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterCList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitCList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitCList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CListContext cList() throws RecognitionException {
		CListContext _localctx = new CListContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_cList);
		int _la;
		try {
			setState(321);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				match(T__0);
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__37) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (INTEGER - 65)) | (1L << (FLOAT - 65)) | (1L << (SYMBOL - 65)) | (1L << (IDENT - 65)) | (1L << (STRING - 65)))) != 0)) {
					{
					setState(311);
					commaSepExprs();
					}
				}

				setState(314);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				match(T__0);
				setState(316);
				any(0);
				setState(317);
				match(T__43);
				setState(318);
				any(0);
				setState(319);
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

	public static class CQueueContext extends ParserRuleContext {
		public CommaSepExprsContext commaSepExprs() {
			return getRuleContext(CommaSepExprsContext.class,0);
		}
		public CQueueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cQueue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterCQueue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitCQueue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitCQueue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CQueueContext cQueue() throws RecognitionException {
		CQueueContext _localctx = new CQueueContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_cQueue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(T__56);
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__37) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (INTEGER - 65)) | (1L << (FLOAT - 65)) | (1L << (SYMBOL - 65)) | (1L << (IDENT - 65)) | (1L << (STRING - 65)))) != 0)) {
				{
				setState(324);
				commaSepExprs();
				}
			}

			setState(327);
			match(T__1);
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

	public static class CSetContext extends ParserRuleContext {
		public CommaSepExprsContext commaSepExprs() {
			return getRuleContext(CommaSepExprsContext.class,0);
		}
		public CSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterCSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitCSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitCSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CSetContext cSet() throws RecognitionException {
		CSetContext _localctx = new CSetContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_cSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(T__57);
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__37) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (INTEGER - 65)) | (1L << (FLOAT - 65)) | (1L << (SYMBOL - 65)) | (1L << (IDENT - 65)) | (1L << (STRING - 65)))) != 0)) {
				{
				setState(330);
				commaSepExprs();
				}
			}

			setState(333);
			match(T__54);
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

	public static class CStackContext extends ParserRuleContext {
		public CommaSepExprsContext commaSepExprs() {
			return getRuleContext(CommaSepExprsContext.class,0);
		}
		public CStackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cStack; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterCStack(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitCStack(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitCStack(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CStackContext cStack() throws RecognitionException {
		CStackContext _localctx = new CStackContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_cStack);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(T__58);
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__37) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (INTEGER - 65)) | (1L << (FLOAT - 65)) | (1L << (SYMBOL - 65)) | (1L << (IDENT - 65)) | (1L << (STRING - 65)))) != 0)) {
				{
				setState(336);
				commaSepExprs();
				}
			}

			setState(339);
			match(T__1);
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

	public static class CTermContext extends ParserRuleContext {
		public ASymbolContext aSymbol() {
			return getRuleContext(ASymbolContext.class,0);
		}
		public CArrayContext cArray() {
			return getRuleContext(CArrayContext.class,0);
		}
		public CTermAttribContext cTermAttrib() {
			return getRuleContext(CTermAttribContext.class,0);
		}
		public CTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterCTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitCTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitCTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CTermContext cTerm() throws RecognitionException {
		CTermContext _localctx = new CTermContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_cTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			aSymbol();
			setState(342);
			cArray();
			setState(344);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(343);
				cTermAttrib();
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

	public static class CTermAttribContext extends ParserRuleContext {
		public Token visOp;
		public AnyContext any() {
			return getRuleContext(AnyContext.class,0);
		}
		public CTermAttribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cTermAttrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterCTermAttrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitCTermAttrib(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitCTermAttrib(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CTermAttribContext cTermAttrib() throws RecognitionException {
		CTermAttribContext _localctx = new CTermAttribContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_cTermAttrib);
		try {
			setState(350);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(346);
				((CTermAttribContext)_localctx).visOp = match(T__12);
				setState(347);
				any(0);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(348);
				((CTermAttribContext)_localctx).visOp = match(T__10);
				setState(349);
				any(0);
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

	public static class AtomContext extends ParserRuleContext {
		public ABooleanContext aBoolean() {
			return getRuleContext(ABooleanContext.class,0);
		}
		public AIdentContext aIdent() {
			return getRuleContext(AIdentContext.class,0);
		}
		public AIntegerContext aInteger() {
			return getRuleContext(AIntegerContext.class,0);
		}
		public ANilContext aNil() {
			return getRuleContext(ANilContext.class,0);
		}
		public ARealContext aReal() {
			return getRuleContext(ARealContext.class,0);
		}
		public AStringContext aString() {
			return getRuleContext(AStringContext.class,0);
		}
		public ASymbolContext aSymbol() {
			return getRuleContext(ASymbolContext.class,0);
		}
		public AnyContext any() {
			return getRuleContext(AnyContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_atom);
		try {
			setState(363);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__59:
			case T__60:
				enterOuterAlt(_localctx, 1);
				{
				setState(352);
				aBoolean();
				}
				break;
			case T__2:
			case T__3:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(353);
				aIdent();
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(354);
				aInteger();
				}
				break;
			case T__61:
				enterOuterAlt(_localctx, 4);
				{
				setState(355);
				aNil();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 5);
				{
				setState(356);
				aReal();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 6);
				{
				setState(357);
				aString();
				}
				break;
			case SYMBOL:
				enterOuterAlt(_localctx, 7);
				{
				setState(358);
				aSymbol();
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 8);
				{
				setState(359);
				match(T__34);
				setState(360);
				any(0);
				setState(361);
				match(T__35);
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

	public static class ABooleanContext extends ParserRuleContext {
		public ABooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aBoolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterABoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitABoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitABoolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ABooleanContext aBoolean() throws RecognitionException {
		ABooleanContext _localctx = new ABooleanContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_aBoolean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			_la = _input.LA(1);
			if ( !(_la==T__59 || _la==T__60) ) {
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

	public static class AIdentContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(UFOParser.IDENT, 0); }
		public Level1opsContext level1ops() {
			return getRuleContext(Level1opsContext.class,0);
		}
		public BindingOpContext bindingOp() {
			return getRuleContext(BindingOpContext.class,0);
		}
		public Level2opsContext level2ops() {
			return getRuleContext(Level2opsContext.class,0);
		}
		public Level3opsContext level3ops() {
			return getRuleContext(Level3opsContext.class,0);
		}
		public Level4opsContext level4ops() {
			return getRuleContext(Level4opsContext.class,0);
		}
		public Level5opsContext level5ops() {
			return getRuleContext(Level5opsContext.class,0);
		}
		public AIdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aIdent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterAIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitAIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitAIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AIdentContext aIdent() throws RecognitionException {
		AIdentContext _localctx = new AIdentContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_aIdent);
		try {
			setState(374);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(367);
				match(IDENT);
				}
				break;
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
				enterOuterAlt(_localctx, 2);
				{
				setState(368);
				level1ops();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 3);
				{
				setState(369);
				bindingOp();
				}
				break;
			case T__2:
			case T__3:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(370);
				level2ops();
				}
				break;
			case T__9:
			case T__10:
			case T__11:
			case T__12:
				enterOuterAlt(_localctx, 5);
				{
				setState(371);
				level3ops();
				}
				break;
			case T__7:
			case T__8:
				enterOuterAlt(_localctx, 6);
				{
				setState(372);
				level4ops();
				}
				break;
			case T__5:
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(373);
				level5ops();
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

	public static class AIntegerContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(UFOParser.INTEGER, 0); }
		public AIntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aInteger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterAInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitAInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitAInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AIntegerContext aInteger() throws RecognitionException {
		AIntegerContext _localctx = new AIntegerContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_aInteger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			match(INTEGER);
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

	public static class ANilContext extends ParserRuleContext {
		public ANilContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aNil; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterANil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitANil(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitANil(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ANilContext aNil() throws RecognitionException {
		ANilContext _localctx = new ANilContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_aNil);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(T__61);
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

	public static class ARealContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(UFOParser.FLOAT, 0); }
		public ARealContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aReal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterAReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitAReal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitAReal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ARealContext aReal() throws RecognitionException {
		ARealContext _localctx = new ARealContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_aReal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(FLOAT);
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

	public static class AStringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(UFOParser.STRING, 0); }
		public AStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterAString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitAString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitAString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AStringContext aString() throws RecognitionException {
		AStringContext _localctx = new AStringContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_aString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			match(STRING);
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

	public static class ASymbolContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(UFOParser.SYMBOL, 0); }
		public ASymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).enterASymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFOListener ) ((UFOListener)listener).exitASymbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UFOVisitor ) return ((UFOVisitor<? extends T>)visitor).visitASymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ASymbolContext aSymbol() throws RecognitionException {
		ASymbolContext _localctx = new ASymbolContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_aSymbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(SYMBOL);
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
		case 1:
			return any_sempred((AnyContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean any_sempred(AnyContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3G\u0185\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\6\2^\n\2\r\2\16\2_\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3k\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\7\3\u008c\n\3\f\3\16\3\u008f\13\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00a5\n\13\f\13"+
		"\16\13\u00a8\13\13\3\13\3\13\5\13\u00ac\n\13\3\f\7\f\u00af\n\f\f\f\16"+
		"\f\u00b2\13\f\3\r\3\r\3\r\7\r\u00b7\n\r\f\r\16\r\u00ba\13\r\3\16\3\16"+
		"\3\16\7\16\u00bf\n\16\f\16\16\16\u00c2\13\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u00ce\n\17\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\5\23\u00de\n\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\7\24\u00e8\n\24\f\24\16\24\u00eb\13\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25\u00f3\n\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u00fd\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u011e\n\34\3\35\3\35\5\35"+
		"\u0122\n\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\5\37\u0131\n\37\3 \3 \5 \u0135\n \3 \3 \3!\3!\5!\u013b\n!\3!\3!"+
		"\3!\3!\3!\3!\3!\5!\u0144\n!\3\"\3\"\5\"\u0148\n\"\3\"\3\"\3#\3#\5#\u014e"+
		"\n#\3#\3#\3$\3$\5$\u0154\n$\3$\3$\3%\3%\3%\5%\u015b\n%\3&\3&\3&\3&\5&"+
		"\u0161\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u016e\n\'\3"+
		"(\3(\3)\3)\3)\3)\3)\3)\3)\5)\u0179\n)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3"+
		".\2\3\4/\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668"+
		":<>@BDFHJLNPRTVXZ\2\n\3\2\5\7\3\2\b\t\3\2\n\13\3\2\f\17\4\2\5\6\20\24"+
		"\3\2\26$\3\2,-\3\2>?\2\u0194\2]\3\2\2\2\4j\3\2\2\2\6\u0090\3\2\2\2\b\u0092"+
		"\3\2\2\2\n\u0094\3\2\2\2\f\u0096\3\2\2\2\16\u0098\3\2\2\2\20\u009a\3\2"+
		"\2\2\22\u009c\3\2\2\2\24\u00ab\3\2\2\2\26\u00b0\3\2\2\2\30\u00b3\3\2\2"+
		"\2\32\u00bb\3\2\2\2\34\u00cd\3\2\2\2\36\u00cf\3\2\2\2 \u00d3\3\2\2\2\""+
		"\u00d7\3\2\2\2$\u00db\3\2\2\2&\u00e2\3\2\2\2(\u00ec\3\2\2\2*\u00f6\3\2"+
		"\2\2,\u00fe\3\2\2\2.\u0104\3\2\2\2\60\u0108\3\2\2\2\62\u010c\3\2\2\2\64"+
		"\u0110\3\2\2\2\66\u011d\3\2\2\28\u011f\3\2\2\2:\u0125\3\2\2\2<\u0130\3"+
		"\2\2\2>\u0132\3\2\2\2@\u0143\3\2\2\2B\u0145\3\2\2\2D\u014b\3\2\2\2F\u0151"+
		"\3\2\2\2H\u0157\3\2\2\2J\u0160\3\2\2\2L\u016d\3\2\2\2N\u016f\3\2\2\2P"+
		"\u0178\3\2\2\2R\u017a\3\2\2\2T\u017c\3\2\2\2V\u017e\3\2\2\2X\u0180\3\2"+
		"\2\2Z\u0182\3\2\2\2\\^\5\4\3\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2"+
		"\2`a\3\2\2\2ab\7\2\2\3b\3\3\2\2\2cd\b\3\1\2de\5\6\4\2ef\5\4\3\16fk\3\2"+
		"\2\2gk\5\34\17\2hk\5\66\34\2ik\5L\'\2jc\3\2\2\2jg\3\2\2\2jh\3\2\2\2ji"+
		"\3\2\2\2k\u008d\3\2\2\2lm\f\f\2\2mn\5\b\5\2no\5\4\3\ro\u008c\3\2\2\2p"+
		"q\f\n\2\2qr\5\n\6\2rs\5\4\3\13s\u008c\3\2\2\2tu\f\t\2\2uv\5\f\7\2vw\5"+
		"\4\3\nw\u008c\3\2\2\2xy\f\b\2\2yz\5\16\b\2z{\5\4\3\t{\u008c\3\2\2\2|}"+
		"\f\7\2\2}~\5\20\t\2~\177\5\4\3\b\177\u008c\3\2\2\2\u0080\u0081\f\6\2\2"+
		"\u0081\u0082\5\22\n\2\u0082\u0083\5\4\3\7\u0083\u008c\3\2\2\2\u0084\u0085"+
		"\f\r\2\2\u0085\u0086\7\3\2\2\u0086\u0087\5\4\3\2\u0087\u0088\7\4\2\2\u0088"+
		"\u008c\3\2\2\2\u0089\u008a\f\13\2\2\u008a\u008c\5\24\13\2\u008bl\3\2\2"+
		"\2\u008bp\3\2\2\2\u008bt\3\2\2\2\u008bx\3\2\2\2\u008b|\3\2\2\2\u008b\u0080"+
		"\3\2\2\2\u008b\u0084\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\5\3\2\2\2\u008f\u008d\3\2\2\2"+
		"\u0090\u0091\t\2\2\2\u0091\7\3\2\2\2\u0092\u0093\t\3\2\2\u0093\t\3\2\2"+
		"\2\u0094\u0095\t\4\2\2\u0095\13\3\2\2\2\u0096\u0097\t\5\2\2\u0097\r\3"+
		"\2\2\2\u0098\u0099\t\6\2\2\u0099\17\3\2\2\2\u009a\u009b\7\25\2\2\u009b"+
		"\21\3\2\2\2\u009c\u009d\t\7\2\2\u009d\23\3\2\2\2\u009e\u009f\7%\2\2\u009f"+
		"\u00ac\7&\2\2\u00a0\u00a1\7%\2\2\u00a1\u00a6\5\4\3\2\u00a2\u00a3\7\'\2"+
		"\2\u00a3\u00a5\5\4\3\2\u00a4\u00a2\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9"+
		"\u00aa\7&\2\2\u00aa\u00ac\3\2\2\2\u00ab\u009e\3\2\2\2\u00ab\u00a0\3\2"+
		"\2\2\u00ac\25\3\2\2\2\u00ad\u00af\5\4\3\2\u00ae\u00ad\3\2\2\2\u00af\u00b2"+
		"\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\27\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b3\u00b8\5:\36\2\u00b4\u00b5\7\'\2\2\u00b5\u00b7\5:"+
		"\36\2\u00b6\u00b4\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\31\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00c0\5\4\3"+
		"\2\u00bc\u00bd\7\'\2\2\u00bd\u00bf\5\4\3\2\u00be\u00bc\3\2\2\2\u00bf\u00c2"+
		"\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\33\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c3\u00ce\5\36\20\2\u00c4\u00ce\5\"\22\2\u00c5\u00ce"+
		"\5$\23\2\u00c6\u00ce\5(\25\2\u00c7\u00ce\5*\26\2\u00c8\u00ce\5,\27\2\u00c9"+
		"\u00ce\5.\30\2\u00ca\u00ce\5\60\31\2\u00cb\u00ce\5\62\32\2\u00cc\u00ce"+
		"\5\64\33\2\u00cd\u00c3\3\2\2\2\u00cd\u00c4\3\2\2\2\u00cd\u00c5\3\2\2\2"+
		"\u00cd\u00c6\3\2\2\2\u00cd\u00c7\3\2\2\2\u00cd\u00c8\3\2\2\2\u00cd\u00c9"+
		"\3\2\2\2\u00cd\u00ca\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce"+
		"\35\3\2\2\2\u00cf\u00d0\7(\2\2\u00d0\u00d1\5\26\f\2\u00d1\u00d2\7)\2\2"+
		"\u00d2\37\3\2\2\2\u00d3\u00d4\7*\2\2\u00d4\u00d5\5\4\3\2\u00d5\u00d6\7"+
		"*\2\2\u00d6!\3\2\2\2\u00d7\u00d8\7+\2\2\u00d8\u00d9\5\26\f\2\u00d9\u00da"+
		"\7)\2\2\u00da#\3\2\2\2\u00db\u00dd\t\b\2\2\u00dc\u00de\5P)\2\u00dd\u00dc"+
		"\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\5&\24\2\u00e0"+
		"\u00e1\7)\2\2\u00e1%\3\2\2\2\u00e2\u00e3\5\24\13\2\u00e3\u00e4\7\25\2"+
		"\2\u00e4\u00e9\5\26\f\2\u00e5\u00e6\7.\2\2\u00e6\u00e8\5&\24\2\u00e7\u00e5"+
		"\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\'\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\7/\2\2\u00ed\u00ee\5\4\3\2"+
		"\u00ee\u00ef\7\60\2\2\u00ef\u00f2\5\26\f\2\u00f0\u00f1\7\61\2\2\u00f1"+
		"\u00f3\5\26\f\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3"+
		"\2\2\2\u00f4\u00f5\7)\2\2\u00f5)\3\2\2\2\u00f6\u00f7\7\62\2\2\u00f7\u00fc"+
		"\5\30\r\2\u00f8\u00f9\7\37\2\2\u00f9\u00fa\5\26\f\2\u00fa\u00fb\7)\2\2"+
		"\u00fb\u00fd\3\2\2\2\u00fc\u00f8\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd+\3"+
		"\2\2\2\u00fe\u00ff\7\63\2\2\u00ff\u0100\5\4\3\2\u0100\u0101\7\64\2\2\u0101"+
		"\u0102\5\26\f\2\u0102\u0103\7)\2\2\u0103-\3\2\2\2\u0104\u0105\7\65\2\2"+
		"\u0105\u0106\5\26\f\2\u0106\u0107\7)\2\2\u0107/\3\2\2\2\u0108\u0109\7"+
		"\66\2\2\u0109\u010a\5\4\3\2\u010a\u010b\7\66\2\2\u010b\61\3\2\2\2\u010c"+
		"\u010d\7\64\2\2\u010d\u010e\5\26\f\2\u010e\u010f\7)\2\2\u010f\63\3\2\2"+
		"\2\u0110\u0111\7\67\2\2\u0111\u0112\5\4\3\2\u0112\u0113\7\64\2\2\u0113"+
		"\u0114\5\26\f\2\u0114\u0115\7)\2\2\u0115\65\3\2\2\2\u0116\u011e\58\35"+
		"\2\u0117\u011e\5> \2\u0118\u011e\5@!\2\u0119\u011e\5B\"\2\u011a\u011e"+
		"\5D#\2\u011b\u011e\5F$\2\u011c\u011e\5H%\2\u011d\u0116\3\2\2\2\u011d\u0117"+
		"\3\2\2\2\u011d\u0118\3\2\2\2\u011d\u0119\3\2\2\2\u011d\u011a\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011d\u011c\3\2\2\2\u011e\67\3\2\2\2\u011f\u0121\78\2\2"+
		"\u0120\u0122\5\32\16\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123"+
		"\3\2\2\2\u0123\u0124\79\2\2\u01249\3\2\2\2\u0125\u0126\5<\37\2\u0126\u0127"+
		"\7\25\2\2\u0127\u0128\5\4\3\2\u0128;\3\2\2\2\u0129\u0131\5L\'\2\u012a"+
		"\u0131\5\66\34\2\u012b\u0131\5\60\31\2\u012c\u012d\7%\2\2\u012d\u012e"+
		"\5\4\3\2\u012e\u012f\7&\2\2\u012f\u0131\3\2\2\2\u0130\u0129\3\2\2\2\u0130"+
		"\u012a\3\2\2\2\u0130\u012b\3\2\2\2\u0130\u012c\3\2\2\2\u0131=\3\2\2\2"+
		"\u0132\u0134\7:\2\2\u0133\u0135\5\30\r\2\u0134\u0133\3\2\2\2\u0134\u0135"+
		"\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137\79\2\2\u0137?\3\2\2\2\u0138\u013a"+
		"\7\3\2\2\u0139\u013b\5\32\16\2\u013a\u0139\3\2\2\2\u013a\u013b\3\2\2\2"+
		"\u013b\u013c\3\2\2\2\u013c\u0144\7\4\2\2\u013d\u013e\7\3\2\2\u013e\u013f"+
		"\5\4\3\2\u013f\u0140\7.\2\2\u0140\u0141\5\4\3\2\u0141\u0142\7\4\2\2\u0142"+
		"\u0144\3\2\2\2\u0143\u0138\3\2\2\2\u0143\u013d\3\2\2\2\u0144A\3\2\2\2"+
		"\u0145\u0147\7;\2\2\u0146\u0148\5\32\16\2\u0147\u0146\3\2\2\2\u0147\u0148"+
		"\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\7\4\2\2\u014aC\3\2\2\2\u014b"+
		"\u014d\7<\2\2\u014c\u014e\5\32\16\2\u014d\u014c\3\2\2\2\u014d\u014e\3"+
		"\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\79\2\2\u0150E\3\2\2\2\u0151\u0153"+
		"\7=\2\2\u0152\u0154\5\32\16\2\u0153\u0152\3\2\2\2\u0153\u0154\3\2\2\2"+
		"\u0154\u0155\3\2\2\2\u0155\u0156\7\4\2\2\u0156G\3\2\2\2\u0157\u0158\5"+
		"Z.\2\u0158\u015a\58\35\2\u0159\u015b\5J&\2\u015a\u0159\3\2\2\2\u015a\u015b"+
		"\3\2\2\2\u015bI\3\2\2\2\u015c\u015d\7\17\2\2\u015d\u0161\5\4\3\2\u015e"+
		"\u015f\7\r\2\2\u015f\u0161\5\4\3\2\u0160\u015c\3\2\2\2\u0160\u015e\3\2"+
		"\2\2\u0161K\3\2\2\2\u0162\u016e\5N(\2\u0163\u016e\5P)\2\u0164\u016e\5"+
		"R*\2\u0165\u016e\5T+\2\u0166\u016e\5V,\2\u0167\u016e\5X-\2\u0168\u016e"+
		"\5Z.\2\u0169\u016a\7%\2\2\u016a\u016b\5\4\3\2\u016b\u016c\7&\2\2\u016c"+
		"\u016e\3\2\2\2\u016d\u0162\3\2\2\2\u016d\u0163\3\2\2\2\u016d\u0164\3\2"+
		"\2\2\u016d\u0165\3\2\2\2\u016d\u0166\3\2\2\2\u016d\u0167\3\2\2\2\u016d"+
		"\u0168\3\2\2\2\u016d\u0169\3\2\2\2\u016eM\3\2\2\2\u016f\u0170\t\t\2\2"+
		"\u0170O\3\2\2\2\u0171\u0179\7F\2\2\u0172\u0179\5\22\n\2\u0173\u0179\5"+
		"\20\t\2\u0174\u0179\5\16\b\2\u0175\u0179\5\f\7\2\u0176\u0179\5\n\6\2\u0177"+
		"\u0179\5\b\5\2\u0178\u0171\3\2\2\2\u0178\u0172\3\2\2\2\u0178\u0173\3\2"+
		"\2\2\u0178\u0174\3\2\2\2\u0178\u0175\3\2\2\2\u0178\u0176\3\2\2\2\u0178"+
		"\u0177\3\2\2\2\u0179Q\3\2\2\2\u017a\u017b\7C\2\2\u017bS\3\2\2\2\u017c"+
		"\u017d\7@\2\2\u017dU\3\2\2\2\u017e\u017f\7D\2\2\u017fW\3\2\2\2\u0180\u0181"+
		"\7G\2\2\u0181Y\3\2\2\2\u0182\u0183\7E\2\2\u0183[\3\2\2\2\35_j\u008b\u008d"+
		"\u00a6\u00ab\u00b0\u00b8\u00c0\u00cd\u00dd\u00e9\u00f2\u00fc\u011d\u0121"+
		"\u0130\u0134\u013a\u0143\u0147\u014d\u0153\u015a\u0160\u016d\u0178";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}