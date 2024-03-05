package generated.calc;

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
		tokens = List.of(new Pair<>(Tokens.END, Pattern.compile("^$")), new Pair<>(Tokens.COMMA, Pattern.compile(",")), new Pair<>(Tokens.DIV, Pattern.compile("\\/")), new Pair<>(Tokens.NUMBER, Pattern.compile("[0-9]+")), new Pair<>(Tokens.MULT, Pattern.compile("\\*")), new Pair<>(Tokens.LPAREN, Pattern.compile("\\(")), new Pair<>(Tokens.EPS, Pattern.compile("EPS")), new Pair<>(Tokens.GCD, Pattern.compile("gcd")), new Pair<>(Tokens.RPAREN, Pattern.compile("\\)")), new Pair<>(Tokens.PLUS, Pattern.compile("\\+")), new Pair<>(Tokens.MINUS, Pattern.compile("\\-")));
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
