// Generated from /home/kanopus/IdeaProjects/MT/MT3/Expr.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, EQUAL=2, COMP=3, OPER=4, LB=5, RB=6, COMA=7, PRINT=8, WHILE=9, 
		COLON=10, IF=11, SINPUT=12, IINPUT=13, LP=14, RP=15, TAB=16, INT=17, VAR=18, 
		STR=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NEWLINE", "EQUAL", "COMP", "OPER", "LB", "RB", "COMA", "PRINT", "WHILE", 
			"COLON", "IF", "SINPUT", "IINPUT", "LP", "RP", "TAB", "INT", "VAR", "STR", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'='", null, null, "'['", "']'", "','", "'print'", "'while'", 
			"':'", "'if'", "'input()'", "'int(input())'", "'('", "')'", "'\\t'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "EQUAL", "COMP", "OPER", "LB", "RB", "COMA", "PRINT", 
			"WHILE", "COLON", "IF", "SINPUT", "IINPUT", "LP", "RP", "TAB", "INT", 
			"VAR", "STR", "WS"
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


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

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
		"\u0004\u0000\u0014\u0083\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0004\u0000"+
		"+\b\u0000\u000b\u0000\f\u0000,\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u00024\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0004\u0010k\b\u0010\u000b\u0010\f\u0010l\u0001\u0011\u0004\u0011p\b"+
		"\u0011\u000b\u0011\f\u0011q\u0001\u0012\u0001\u0012\u0005\u0012v\b\u0012"+
		"\n\u0012\f\u0012y\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0004\u0013"+
		"~\b\u0013\u000b\u0013\f\u0013\u007f\u0001\u0013\u0001\u0013\u0001w\u0000"+
		"\u0014\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014\u0001\u0000\u0006"+
		"\u0002\u0000\n\n\r\r\u0002\u0000<<>>\u0003\u0000*+--//\u0001\u000009\u0001"+
		"\u0000az\u0003\u0000\n\n\r\r  \u0088\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0001*\u0001\u0000\u0000\u0000\u0003.\u0001\u0000\u0000\u0000\u0005"+
		"3\u0001\u0000\u0000\u0000\u00075\u0001\u0000\u0000\u0000\t7\u0001\u0000"+
		"\u0000\u0000\u000b9\u0001\u0000\u0000\u0000\r;\u0001\u0000\u0000\u0000"+
		"\u000f=\u0001\u0000\u0000\u0000\u0011C\u0001\u0000\u0000\u0000\u0013I"+
		"\u0001\u0000\u0000\u0000\u0015K\u0001\u0000\u0000\u0000\u0017N\u0001\u0000"+
		"\u0000\u0000\u0019V\u0001\u0000\u0000\u0000\u001bc\u0001\u0000\u0000\u0000"+
		"\u001de\u0001\u0000\u0000\u0000\u001fg\u0001\u0000\u0000\u0000!j\u0001"+
		"\u0000\u0000\u0000#o\u0001\u0000\u0000\u0000%s\u0001\u0000\u0000\u0000"+
		"\'}\u0001\u0000\u0000\u0000)+\u0007\u0000\u0000\u0000*)\u0001\u0000\u0000"+
		"\u0000+,\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000"+
		"\u0000\u0000-\u0002\u0001\u0000\u0000\u0000./\u0005=\u0000\u0000/\u0004"+
		"\u0001\u0000\u0000\u000001\u0005=\u0000\u000014\u0005=\u0000\u000024\u0007"+
		"\u0001\u0000\u000030\u0001\u0000\u0000\u000032\u0001\u0000\u0000\u0000"+
		"4\u0006\u0001\u0000\u0000\u000056\u0007\u0002\u0000\u00006\b\u0001\u0000"+
		"\u0000\u000078\u0005[\u0000\u00008\n\u0001\u0000\u0000\u00009:\u0005]"+
		"\u0000\u0000:\f\u0001\u0000\u0000\u0000;<\u0005,\u0000\u0000<\u000e\u0001"+
		"\u0000\u0000\u0000=>\u0005p\u0000\u0000>?\u0005r\u0000\u0000?@\u0005i"+
		"\u0000\u0000@A\u0005n\u0000\u0000AB\u0005t\u0000\u0000B\u0010\u0001\u0000"+
		"\u0000\u0000CD\u0005w\u0000\u0000DE\u0005h\u0000\u0000EF\u0005i\u0000"+
		"\u0000FG\u0005l\u0000\u0000GH\u0005e\u0000\u0000H\u0012\u0001\u0000\u0000"+
		"\u0000IJ\u0005:\u0000\u0000J\u0014\u0001\u0000\u0000\u0000KL\u0005i\u0000"+
		"\u0000LM\u0005f\u0000\u0000M\u0016\u0001\u0000\u0000\u0000NO\u0005i\u0000"+
		"\u0000OP\u0005n\u0000\u0000PQ\u0005p\u0000\u0000QR\u0005u\u0000\u0000"+
		"RS\u0005t\u0000\u0000ST\u0005(\u0000\u0000TU\u0005)\u0000\u0000U\u0018"+
		"\u0001\u0000\u0000\u0000VW\u0005i\u0000\u0000WX\u0005n\u0000\u0000XY\u0005"+
		"t\u0000\u0000YZ\u0005(\u0000\u0000Z[\u0005i\u0000\u0000[\\\u0005n\u0000"+
		"\u0000\\]\u0005p\u0000\u0000]^\u0005u\u0000\u0000^_\u0005t\u0000\u0000"+
		"_`\u0005(\u0000\u0000`a\u0005)\u0000\u0000ab\u0005)\u0000\u0000b\u001a"+
		"\u0001\u0000\u0000\u0000cd\u0005(\u0000\u0000d\u001c\u0001\u0000\u0000"+
		"\u0000ef\u0005)\u0000\u0000f\u001e\u0001\u0000\u0000\u0000gh\u0005\t\u0000"+
		"\u0000h \u0001\u0000\u0000\u0000ik\u0007\u0003\u0000\u0000ji\u0001\u0000"+
		"\u0000\u0000kl\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001"+
		"\u0000\u0000\u0000m\"\u0001\u0000\u0000\u0000np\u0007\u0004\u0000\u0000"+
		"on\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000"+
		"\u0000qr\u0001\u0000\u0000\u0000r$\u0001\u0000\u0000\u0000sw\u0005\"\u0000"+
		"\u0000tv\t\u0000\u0000\u0000ut\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000"+
		"\u0000wx\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000xz\u0001\u0000"+
		"\u0000\u0000yw\u0001\u0000\u0000\u0000z{\u0005\"\u0000\u0000{&\u0001\u0000"+
		"\u0000\u0000|~\u0007\u0005\u0000\u0000}|\u0001\u0000\u0000\u0000~\u007f"+
		"\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001"+
		"\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0006"+
		"\u0013\u0000\u0000\u0082(\u0001\u0000\u0000\u0000\u0007\u0000,3lqw\u007f"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}