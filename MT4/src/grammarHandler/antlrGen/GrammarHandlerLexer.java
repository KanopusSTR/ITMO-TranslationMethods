// Generated from /home/kanopus/IdeaProjects/MT/MT4/src/grammarHandler/GrammarHandler.g4 by ANTLR 4.13.1
package grammarHandler.antlrGen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class GrammarHandlerLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, OR=3, NTNAME=4, TNAME=5, REG=6, CODE=7, INHERITED=8, SYNTHESIZED=9, 
		IMPORT=10, WS=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "OR", "NTNAME", "TNAME", "REG", "CODE", "INHERITED", 
			"SYNTHESIZED", "IMPORT", "WS"
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


	public GrammarHandlerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GrammarHandler.g4"; }

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
		"\u0004\u0000\u000bb\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0004\u0003&\b\u0003\u000b\u0003\f\u0003\'\u0001\u0004\u0004"+
		"\u0004+\b\u0004\u000b\u0004\f\u0004,\u0001\u0005\u0001\u0005\u0005\u0005"+
		"1\b\u0005\n\u0005\f\u00054\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0005\u0006:\b\u0006\n\u0006\f\u0006=\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0005\u0007C\b\u0007\n\u0007\f\u0007"+
		"F\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\bL\b\b\n\b\f\b"+
		"O\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0005\tU\b\t\n\t\f\tX\t\t\u0001"+
		"\t\u0001\t\u0001\n\u0004\n]\b\n\u000b\n\f\n^\u0001\n\u0001\n\u00052;D"+
		"MV\u0000\u000b\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0001\u0000\u0003"+
		"\u0001\u0000az\u0001\u0000AZ\u0002\u0000\t\n  i\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0001\u0017\u0001\u0000\u0000\u0000\u0003\u0019\u0001\u0000\u0000\u0000"+
		"\u0005\"\u0001\u0000\u0000\u0000\u0007%\u0001\u0000\u0000\u0000\t*\u0001"+
		"\u0000\u0000\u0000\u000b.\u0001\u0000\u0000\u0000\r7\u0001\u0000\u0000"+
		"\u0000\u000f@\u0001\u0000\u0000\u0000\u0011I\u0001\u0000\u0000\u0000\u0013"+
		"R\u0001\u0000\u0000\u0000\u0015\\\u0001\u0000\u0000\u0000\u0017\u0018"+
		"\u0005:\u0000\u0000\u0018\u0002\u0001\u0000\u0000\u0000\u0019\u001a\u0005"+
		" \u0000\u0000\u001a\u001b\u0005-\u0000\u0000\u001b\u001c\u0005>\u0000"+
		"\u0000\u001c\u001d\u0005 \u0000\u0000\u001d\u001e\u0005s\u0000\u0000\u001e"+
		"\u001f\u0005k\u0000\u0000\u001f \u0005i\u0000\u0000 !\u0005p\u0000\u0000"+
		"!\u0004\u0001\u0000\u0000\u0000\"#\u0005|\u0000\u0000#\u0006\u0001\u0000"+
		"\u0000\u0000$&\u0007\u0000\u0000\u0000%$\u0001\u0000\u0000\u0000&\'\u0001"+
		"\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000"+
		"(\b\u0001\u0000\u0000\u0000)+\u0007\u0001\u0000\u0000*)\u0001\u0000\u0000"+
		"\u0000+,\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000"+
		"\u0000\u0000-\n\u0001\u0000\u0000\u0000.2\u0005\"\u0000\u0000/1\t\u0000"+
		"\u0000\u00000/\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u000023\u0001"+
		"\u0000\u0000\u000020\u0001\u0000\u0000\u000035\u0001\u0000\u0000\u0000"+
		"42\u0001\u0000\u0000\u000056\u0005\"\u0000\u00006\f\u0001\u0000\u0000"+
		"\u00007;\u0005{\u0000\u00008:\t\u0000\u0000\u000098\u0001\u0000\u0000"+
		"\u0000:=\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000;9\u0001\u0000"+
		"\u0000\u0000<>\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0005"+
		"}\u0000\u0000?\u000e\u0001\u0000\u0000\u0000@D\u0005(\u0000\u0000AC\t"+
		"\u0000\u0000\u0000BA\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000"+
		"DE\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000EG\u0001\u0000\u0000"+
		"\u0000FD\u0001\u0000\u0000\u0000GH\u0005)\u0000\u0000H\u0010\u0001\u0000"+
		"\u0000\u0000IM\u0005[\u0000\u0000JL\t\u0000\u0000\u0000KJ\u0001\u0000"+
		"\u0000\u0000LO\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000MK\u0001"+
		"\u0000\u0000\u0000NP\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000"+
		"PQ\u0005]\u0000\u0000Q\u0012\u0001\u0000\u0000\u0000RV\u0005<\u0000\u0000"+
		"SU\t\u0000\u0000\u0000TS\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000"+
		"VW\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000WY\u0001\u0000\u0000"+
		"\u0000XV\u0001\u0000\u0000\u0000YZ\u0005>\u0000\u0000Z\u0014\u0001\u0000"+
		"\u0000\u0000[]\u0007\u0002\u0000\u0000\\[\u0001\u0000\u0000\u0000]^\u0001"+
		"\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000"+
		"_`\u0001\u0000\u0000\u0000`a\u0006\n\u0000\u0000a\u0016\u0001\u0000\u0000"+
		"\u0000\t\u0000\',2;DMV^\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}