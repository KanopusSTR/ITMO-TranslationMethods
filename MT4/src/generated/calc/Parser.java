package generated.calc;

import java.util.Arrays;
import java.util.ArrayList;
import org.antlr.v4.runtime.misc.Pair;

import static java.lang.Integer.parseInt;

import generated.*;

public class Parser {

	public static Integer gcd(Integer a, Integer b) {
    if (b==0) return a;
    return gcd(b,a%b);
}



	Lexer lexer;

 	public Parser(Lexer lexer) {
 		this.lexer = lexer;
 	}

	public Pair<Tree, String> COMMA() {
		if (!lexer.curToken.a.toString().equals("COMMA")) {
			throw new RuntimeException("curToken is not equals required COMMA");
		}
		Pair<Tree, String> pair = new Pair(new Tree("COMMA", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> DIV() {
		if (!lexer.curToken.a.toString().equals("DIV")) {
			throw new RuntimeException("curToken is not equals required DIV");
		}
		Pair<Tree, String> pair = new Pair(new Tree("DIV", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> NUMBER() {
		if (!lexer.curToken.a.toString().equals("NUMBER")) {
			throw new RuntimeException("curToken is not equals required NUMBER");
		}
		Pair<Tree, String> pair = new Pair(new Tree("NUMBER", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> MULT() {
		if (!lexer.curToken.a.toString().equals("MULT")) {
			throw new RuntimeException("curToken is not equals required MULT");
		}
		Pair<Tree, String> pair = new Pair(new Tree("MULT", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> LPAREN() {
		if (!lexer.curToken.a.toString().equals("LPAREN")) {
			throw new RuntimeException("curToken is not equals required LPAREN");
		}
		Pair<Tree, String> pair = new Pair(new Tree("LPAREN", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> EPS() {
		if (!lexer.curToken.a.toString().equals("EPS")) {
			throw new RuntimeException("curToken is not equals required EPS");
		}
		Pair<Tree, String> pair = new Pair(new Tree("EPS", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> GCD() {
		if (!lexer.curToken.a.toString().equals("GCD")) {
			throw new RuntimeException("curToken is not equals required GCD");
		}
		Pair<Tree, String> pair = new Pair(new Tree("GCD", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> RPAREN() {
		if (!lexer.curToken.a.toString().equals("RPAREN")) {
			throw new RuntimeException("curToken is not equals required RPAREN");
		}
		Pair<Tree, String> pair = new Pair(new Tree("RPAREN", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> PLUS() {
		if (!lexer.curToken.a.toString().equals("PLUS")) {
			throw new RuntimeException("curToken is not equals required PLUS");
		}
		Pair<Tree, String> pair = new Pair(new Tree("PLUS", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> MINUS() {
		if (!lexer.curToken.a.toString().equals("MINUS")) {
			throw new RuntimeException("curToken is not equals required MINUS");
		}
		Pair<Tree, String> pair = new Pair(new Tree("MINUS", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, Integer> sprime(Integer value) {
		
		switch(lexer.curToken.a) {
			case COMMA:
			case END:
			case RPAREN:
			{
				Integer ans = 0;
				return new Pair(new Tree("sprime", new ArrayList<>()), value);}
			case PLUS: {
				Integer ans = 0;
				Pair<Tree, String> t1 = PLUS();
				Pair<Tree, Integer> t2 = b();
				ans = value + t2.b;
				Pair<Tree, Integer> t3 = sprime(ans);
				ans = t3.b;
				return new Pair(new Tree("sprime", Arrays.asList(t1.a, t2.a, t3.a)), ans);}
			case MINUS: {
				Integer ans = 0;
				Pair<Tree, String> t1 = MINUS();
				Pair<Tree, Integer> t2 = b();
				ans = value - t2.b;
				Pair<Tree, Integer> t3 = sprime(ans);
				ans = t3.b;
				return new Pair(new Tree("sprime", Arrays.asList(t1.a, t2.a, t3.a)), ans);}
			default:
				throw new RuntimeException("curToken is not cased in sprime");
		}
	}
	public Pair<Tree, Integer> b() {
		int value = 0;
		switch(lexer.curToken.a) {
			case NUMBER: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = d();
				Pair<Tree, Integer> t2 = bprime(t1.b);
				ans = t2.b;
				return new Pair(new Tree("b", Arrays.asList(t1.a, t2.a)), ans);}
			case LPAREN: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = d();
				Pair<Tree, Integer> t2 = bprime(t1.b);
				ans = t2.b;
				return new Pair(new Tree("b", Arrays.asList(t1.a, t2.a)), ans);}
			case GCD: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = d();
				Pair<Tree, Integer> t2 = bprime(t1.b);
				ans = t2.b;
				return new Pair(new Tree("b", Arrays.asList(t1.a, t2.a)), ans);}
			default:
				throw new RuntimeException("curToken is not cased in b");
		}
	}
	public Pair<Tree, Integer> d() {
		int value = 0;
		switch(lexer.curToken.a) {
			case NUMBER: {
				Integer ans = 0;
				Pair<Tree, String> t1 = NUMBER();
				ans = parseInt(t1.b);
				return new Pair(new Tree("d", Arrays.asList(t1.a)), ans);}
			case LPAREN: {
				Integer ans = 0;
				Pair<Tree, String> t1 = LPAREN();
				Pair<Tree, Integer> t2 = s();
				Pair<Tree, String> t3 = RPAREN();
				ans = t2.b;
				return new Pair(new Tree("d", Arrays.asList(t1.a, t2.a, t3.a)), ans);}
			case GCD: {
				Integer ans = 0;
				Pair<Tree, String> t1 = GCD();
				Pair<Tree, String> t2 = LPAREN();
				Pair<Tree, Integer> t3 = s();
				Pair<Tree, String> t4 = COMMA();
				Pair<Tree, Integer> t5 = s();
				Pair<Tree, String> t6 = RPAREN();
				ans = gcd(t3.b, t5.b);
				return new Pair(new Tree("d", Arrays.asList(t1.a, t2.a, t3.a, t4.a, t5.a, t6.a)), ans);}
			default:
				throw new RuntimeException("curToken is not cased in d");
		}
	}
	public Pair<Tree, Integer> s() {
		int value = 0;
		switch(lexer.curToken.a) {
			case NUMBER: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = b();
				Pair<Tree, Integer> t2 = sprime(t1.b);
				ans = t2.b;
				return new Pair(new Tree("s", Arrays.asList(t1.a, t2.a)), ans);}
			case LPAREN: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = b();
				Pair<Tree, Integer> t2 = sprime(t1.b);
				ans = t2.b;
				return new Pair(new Tree("s", Arrays.asList(t1.a, t2.a)), ans);}
			case GCD: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = b();
				Pair<Tree, Integer> t2 = sprime(t1.b);
				ans = t2.b;
				return new Pair(new Tree("s", Arrays.asList(t1.a, t2.a)), ans);}
			default:
				throw new RuntimeException("curToken is not cased in s");
		}
	}
	public Pair<Tree, Integer> bprime(Integer value) {
		
		switch(lexer.curToken.a) {
			case DIV: {
				Integer ans = 0;
				Pair<Tree, String> t1 = DIV();
				Pair<Tree, Integer> t2 = d();
				ans = value / t2.b;
				Pair<Tree, Integer> t3 = bprime(ans);
				ans = t3.b;
				return new Pair(new Tree("bprime", Arrays.asList(t1.a, t2.a, t3.a)), ans);}
			case MULT: {
				Integer ans = 0;
				Pair<Tree, String> t1 = MULT();
				Pair<Tree, Integer> t2 = d();
				ans = value * t2.b;
				Pair<Tree, Integer> t3 = bprime(ans);
				ans = t3.b;
				return new Pair(new Tree("bprime", Arrays.asList(t1.a, t2.a, t3.a)), ans);}
			case COMMA:
			case END:
			case RPAREN:
			case PLUS:
			case MINUS:
			{
				Integer ans = 0;
				return new Pair(new Tree("bprime", new ArrayList<>()), value);}
			default:
				throw new RuntimeException("curToken is not cased in bprime");
		}
	}


	public Pair<Tree, Integer> parse() {
 		return s();
 	}
}
