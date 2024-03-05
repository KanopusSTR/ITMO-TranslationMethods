package generated.hw2;

import java.util.regex.*;
import java.util.List;
import org.antlr.v4.runtime.misc.Pair;

public class Lexer {
	String text;
	public Pair<Tokens, String> curToken;
	List<Pair<Tokens, Pattern>> tokens;
	List<Pair<TokensSkipped, Pattern>> skipped;

	public Lexer(String text) {
		this.text = text;
		tokens = List.of(new Pair<>(Tokens.END, Pattern.compile("^$")), new Pair<>(Tokens.NOT, Pattern.compile("not")), new Pair<>(Tokens.OR, Pattern.compile("or")), new Pair<>(Tokens.IN, Pattern.compile("in")), new Pair<>(Tokens.VAR, Pattern.compile("[a-z]+")), new Pair<>(Tokens.AND, Pattern.compile("and")), new Pair<>(Tokens.LPAREN, Pattern.compile("\\(")), new Pair<>(Tokens.NOTIN, Pattern.compile("not in")), new Pair<>(Tokens.EPS, Pattern.compile("EPS")), new Pair<>(Tokens.ELSE, Pattern.compile("else")), new Pair<>(Tokens.XOR, Pattern.compile("xor")), new Pair<>(Tokens.RPAREN, Pattern.compile("\\)")), new Pair<>(Tokens.IF, Pattern.compile("if")));
		skipped = List.of(new Pair<>(TokensSkipped.WS, Pattern.compile("[ \t\n\r]+")));
		nextToken();
	}

	public void nextToken() {
		boolean flag = true;
		while (flag) {
			flag = false;
			for (Pair<TokensSkipped, Pattern> token : skipped){
				Matcher matcher = token.b.matcher(text);
				if (matcher.lookingAt()) {
					text = text.substring(matcher.end());
					matcher.reset(text);
					flag = true;
					break;
				}
			}
		}
		for (Pair<Tokens, Pattern> token : tokens){
			Matcher matcher = token.b.matcher(text);
			if (matcher.lookingAt()) {
				String text0 = text.substring(0, matcher.end());
				text = text.substring(matcher.end());
				curToken = new Pair(token.a, text0);
				matcher.reset(text);
				break;
			}
		}
	}
}
