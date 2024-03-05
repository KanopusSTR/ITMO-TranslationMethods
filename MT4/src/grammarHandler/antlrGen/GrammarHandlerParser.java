// Generated from /home/kanopus/IdeaProjects/MT/MT4/src/grammarHandler/GrammarHandler.g4 by ANTLR 4.13.1
package grammarHandler.antlrGen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GrammarHandlerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, OR=3, NTNAME=4, TNAME=5, REG=6, CODE=7, INHERITED=8, SYNTHESIZED=9, 
		IMPORT=10, WS=11;
	public static final int
		RULE_prog = 0, RULE_srules = 1, RULE_nonterminal = 2, RULE_terminal = 3, 
		RULE_rules = 4, RULE_rule = 5, RULE_part_rule = 6, RULE_myImport = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "srules", "nonterminal", "terminal", "rules", "rule", "part_rule", 
			"myImport"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "' -> skip'", "'|'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "OR", "NTNAME", "TNAME", "REG", "CODE", "INHERITED", 
			"SYNTHESIZED", "IMPORT", "WS"
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
	public String getGrammarFileName() { return "GrammarHandler.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarHandlerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public List<SrulesContext> srules() {
			return getRuleContexts(SrulesContext.class);
		}
		public SrulesContext srules(int i) {
			return getRuleContext(SrulesContext.class,i);
		}
		public List<NonterminalContext> nonterminal() {
			return getRuleContexts(NonterminalContext.class);
		}
		public NonterminalContext nonterminal(int i) {
			return getRuleContext(NonterminalContext.class,i);
		}
		public List<TerminalContext> terminal() {
			return getRuleContexts(TerminalContext.class);
		}
		public TerminalContext terminal(int i) {
			return getRuleContext(TerminalContext.class,i);
		}
		public List<MyImportContext> myImport() {
			return getRuleContexts(MyImportContext.class);
		}
		public MyImportContext myImport(int i) {
			return getRuleContext(MyImportContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarHandlerListener ) ((GrammarHandlerListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarHandlerListener ) ((GrammarHandlerListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarHandlerVisitor ) return ((GrammarHandlerVisitor<? extends T>)visitor).visitProg(this);
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
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1072L) != 0)) {
				{
				setState(20);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(16);
					srules();
					}
					break;
				case 2:
					{
					setState(17);
					nonterminal();
					}
					break;
				case 3:
					{
					setState(18);
					terminal();
					}
					break;
				case 4:
					{
					setState(19);
					myImport();
					}
					break;
				}
				}
				setState(24);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SrulesContext extends ParserRuleContext {
		public TerminalNode TNAME() { return getToken(GrammarHandlerParser.TNAME, 0); }
		public TerminalNode REG() { return getToken(GrammarHandlerParser.REG, 0); }
		public SrulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_srules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarHandlerListener ) ((GrammarHandlerListener)listener).enterSrules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarHandlerListener ) ((GrammarHandlerListener)listener).exitSrules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarHandlerVisitor ) return ((GrammarHandlerVisitor<? extends T>)visitor).visitSrules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SrulesContext srules() throws RecognitionException {
		SrulesContext _localctx = new SrulesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_srules);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(TNAME);
			setState(26);
			match(T__0);
			setState(27);
			match(REG);
			setState(28);
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

	@SuppressWarnings("CheckReturnValue")
	public static class NonterminalContext extends ParserRuleContext {
		public TerminalNode NTNAME() { return getToken(GrammarHandlerParser.NTNAME, 0); }
		public TerminalNode INHERITED() { return getToken(GrammarHandlerParser.INHERITED, 0); }
		public TerminalNode SYNTHESIZED() { return getToken(GrammarHandlerParser.SYNTHESIZED, 0); }
		public RulesContext rules() {
			return getRuleContext(RulesContext.class,0);
		}
		public NonterminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonterminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarHandlerListener ) ((GrammarHandlerListener)listener).enterNonterminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarHandlerListener ) ((GrammarHandlerListener)listener).exitNonterminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarHandlerVisitor ) return ((GrammarHandlerVisitor<? extends T>)visitor).visitNonterminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonterminalContext nonterminal() throws RecognitionException {
		NonterminalContext _localctx = new NonterminalContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nonterminal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(NTNAME);
			setState(31);
			match(INHERITED);
			setState(32);
			match(SYNTHESIZED);
			setState(33);
			match(T__0);
			setState(34);
			rules();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TerminalContext extends ParserRuleContext {
		public TerminalNode TNAME() { return getToken(GrammarHandlerParser.TNAME, 0); }
		public TerminalNode REG() { return getToken(GrammarHandlerParser.REG, 0); }
		public TerminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarHandlerListener ) ((GrammarHandlerListener)listener).enterTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarHandlerListener ) ((GrammarHandlerListener)listener).exitTerminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarHandlerVisitor ) return ((GrammarHandlerVisitor<? extends T>)visitor).visitTerminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerminalContext terminal() throws RecognitionException {
		TerminalContext _localctx = new TerminalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_terminal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(TNAME);
			setState(37);
			match(T__0);
			setState(38);
			match(REG);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RulesContext extends ParserRuleContext {
		public List<RuleContext> rule_() {
			return getRuleContexts(RuleContext.class);
		}
		public RuleContext rule_(int i) {
			return getRuleContext(RuleContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(GrammarHandlerParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(GrammarHandlerParser.OR, i);
		}
		public RulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarHandlerListener ) ((GrammarHandlerListener)listener).enterRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarHandlerListener ) ((GrammarHandlerListener)listener).exitRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarHandlerVisitor ) return ((GrammarHandlerVisitor<? extends T>)visitor).visitRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulesContext rules() throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			rule_();
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(41);
				match(OR);
				setState(42);
				rule_();
				}
				}
				setState(47);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RuleContext extends ParserRuleContext {
		public List<Part_ruleContext> part_rule() {
			return getRuleContexts(Part_ruleContext.class);
		}
		public Part_ruleContext part_rule(int i) {
			return getRuleContext(Part_ruleContext.class,i);
		}
		public RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarHandlerListener ) ((GrammarHandlerListener)listener).enterRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarHandlerListener ) ((GrammarHandlerListener)listener).exitRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarHandlerVisitor ) return ((GrammarHandlerVisitor<? extends T>)visitor).visitRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleContext rule_() throws RecognitionException {
		RuleContext _localctx = new RuleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rule);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(49); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(48);
					part_rule();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(51); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Part_ruleContext extends ParserRuleContext {
		public TerminalNode NTNAME() { return getToken(GrammarHandlerParser.NTNAME, 0); }
		public TerminalNode INHERITED() { return getToken(GrammarHandlerParser.INHERITED, 0); }
		public TerminalNode TNAME() { return getToken(GrammarHandlerParser.TNAME, 0); }
		public TerminalNode CODE() { return getToken(GrammarHandlerParser.CODE, 0); }
		public Part_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_part_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarHandlerListener ) ((GrammarHandlerListener)listener).enterPart_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarHandlerListener ) ((GrammarHandlerListener)listener).exitPart_rule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarHandlerVisitor ) return ((GrammarHandlerVisitor<? extends T>)visitor).visitPart_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Part_ruleContext part_rule() throws RecognitionException {
		Part_ruleContext _localctx = new Part_ruleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_part_rule);
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NTNAME:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(53);
				match(NTNAME);
				setState(54);
				match(INHERITED);
				}
				}
				break;
			case TNAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(TNAME);
				}
				break;
			case CODE:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				match(CODE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MyImportContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(GrammarHandlerParser.IMPORT, 0); }
		public MyImportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_myImport; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarHandlerListener ) ((GrammarHandlerListener)listener).enterMyImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarHandlerListener ) ((GrammarHandlerListener)listener).exitMyImport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarHandlerVisitor ) return ((GrammarHandlerVisitor<? extends T>)visitor).visitMyImport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MyImportContext myImport() throws RecognitionException {
		MyImportContext _localctx = new MyImportContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_myImport);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(IMPORT);
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

	public static final String _serializedATN =
		"\u0004\u0001\u000b>\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u0015\b\u0000\n"+
		"\u0000\f\u0000\u0018\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004,\b\u0004\n\u0004\f\u0004/\t"+
		"\u0004\u0001\u0005\u0004\u00052\b\u0005\u000b\u0005\f\u00053\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006:\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0000\u0000\b\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0000\u0000=\u0000\u0016\u0001\u0000\u0000\u0000\u0002\u0019\u0001\u0000"+
		"\u0000\u0000\u0004\u001e\u0001\u0000\u0000\u0000\u0006$\u0001\u0000\u0000"+
		"\u0000\b(\u0001\u0000\u0000\u0000\n1\u0001\u0000\u0000\u0000\f9\u0001"+
		"\u0000\u0000\u0000\u000e;\u0001\u0000\u0000\u0000\u0010\u0015\u0003\u0002"+
		"\u0001\u0000\u0011\u0015\u0003\u0004\u0002\u0000\u0012\u0015\u0003\u0006"+
		"\u0003\u0000\u0013\u0015\u0003\u000e\u0007\u0000\u0014\u0010\u0001\u0000"+
		"\u0000\u0000\u0014\u0011\u0001\u0000\u0000\u0000\u0014\u0012\u0001\u0000"+
		"\u0000\u0000\u0014\u0013\u0001\u0000\u0000\u0000\u0015\u0018\u0001\u0000"+
		"\u0000\u0000\u0016\u0014\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000"+
		"\u0000\u0000\u0017\u0001\u0001\u0000\u0000\u0000\u0018\u0016\u0001\u0000"+
		"\u0000\u0000\u0019\u001a\u0005\u0005\u0000\u0000\u001a\u001b\u0005\u0001"+
		"\u0000\u0000\u001b\u001c\u0005\u0006\u0000\u0000\u001c\u001d\u0005\u0002"+
		"\u0000\u0000\u001d\u0003\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0004"+
		"\u0000\u0000\u001f \u0005\b\u0000\u0000 !\u0005\t\u0000\u0000!\"\u0005"+
		"\u0001\u0000\u0000\"#\u0003\b\u0004\u0000#\u0005\u0001\u0000\u0000\u0000"+
		"$%\u0005\u0005\u0000\u0000%&\u0005\u0001\u0000\u0000&\'\u0005\u0006\u0000"+
		"\u0000\'\u0007\u0001\u0000\u0000\u0000(-\u0003\n\u0005\u0000)*\u0005\u0003"+
		"\u0000\u0000*,\u0003\n\u0005\u0000+)\u0001\u0000\u0000\u0000,/\u0001\u0000"+
		"\u0000\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.\t\u0001"+
		"\u0000\u0000\u0000/-\u0001\u0000\u0000\u000002\u0003\f\u0006\u000010\u0001"+
		"\u0000\u0000\u000023\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u0000"+
		"34\u0001\u0000\u0000\u00004\u000b\u0001\u0000\u0000\u000056\u0005\u0004"+
		"\u0000\u00006:\u0005\b\u0000\u00007:\u0005\u0005\u0000\u00008:\u0005\u0007"+
		"\u0000\u000095\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u000098\u0001"+
		"\u0000\u0000\u0000:\r\u0001\u0000\u0000\u0000;<\u0005\n\u0000\u0000<\u000f"+
		"\u0001\u0000\u0000\u0000\u0005\u0014\u0016-39";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}