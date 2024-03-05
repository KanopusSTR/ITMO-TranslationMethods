package generated.hw2;

import java.util.Arrays;
import java.util.ArrayList;
import org.antlr.v4.runtime.misc.Pair;

import static java.lang.Integer.parseInt;

import generated.*;

public class Parser {

	Lexer lexer;

 	public Parser(Lexer lexer) {
 		this.lexer = lexer;
 	}

	public Pair<Tree, String> NOT() {
		Pair<Tree, String> pair = new Pair(new Tree("NOT", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> OR() {
		Pair<Tree, String> pair = new Pair(new Tree("OR", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> IN() {
		Pair<Tree, String> pair = new Pair(new Tree("IN", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> VAR() {
		Pair<Tree, String> pair = new Pair(new Tree("VAR", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> AND() {
		Pair<Tree, String> pair = new Pair(new Tree("AND", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> LPAREN() {
		Pair<Tree, String> pair = new Pair(new Tree("LPAREN", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> NOTIN() {
		Pair<Tree, String> pair = new Pair(new Tree("NOTIN", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> EPS() {
		Pair<Tree, String> pair = new Pair(new Tree("EPS", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> ELSE() {
		Pair<Tree, String> pair = new Pair(new Tree("ELSE", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> XOR() {
		Pair<Tree, String> pair = new Pair(new Tree("XOR", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> RPAREN() {
		Pair<Tree, String> pair = new Pair(new Tree("RPAREN", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, String> IF() {
		Pair<Tree, String> pair = new Pair(new Tree("IF", new ArrayList<>()), lexer.curToken.b);
		lexer.nextToken();
		return pair;
	}
	public Pair<Tree, Integer> aprime() {
		int value = 0;
		switch(lexer.curToken.a) {
			case OR:
			case ELSE:
			case END:
			case RPAREN:
			case IF:
			{
				Integer ans = 0;
				return new Pair(new Tree("aprime", new ArrayList<>()), value);}
			case XOR: {
				Integer ans = 0;
				Pair<Tree, String> t1 = XOR();
				Pair<Tree, Integer> t2 = a();
				return new Pair(new Tree("aprime", Arrays.asList(t1.a, t2.a)), ans);}
			default:
				throw new RuntimeException();
		}
	}
	public Pair<Tree, Integer> b() {
		int value = 0;
		switch(lexer.curToken.a) {
			case NOT: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = c();
				Pair<Tree, Integer> t2 = bprime();
				return new Pair(new Tree("b", Arrays.asList(t1.a, t2.a)), ans);}
			case VAR: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = c();
				Pair<Tree, Integer> t2 = bprime();
				return new Pair(new Tree("b", Arrays.asList(t1.a, t2.a)), ans);}
			case LPAREN: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = c();
				Pair<Tree, Integer> t2 = bprime();
				return new Pair(new Tree("b", Arrays.asList(t1.a, t2.a)), ans);}
			default:
				throw new RuntimeException();
		}
	}
	public Pair<Tree, Integer> a() {
		int value = 0;
		switch(lexer.curToken.a) {
			case NOT: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = b();
				Pair<Tree, Integer> t2 = aprime();
				return new Pair(new Tree("a", Arrays.asList(t1.a, t2.a)), ans);}
			case VAR: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = b();
				Pair<Tree, Integer> t2 = aprime();
				return new Pair(new Tree("a", Arrays.asList(t1.a, t2.a)), ans);}
			case LPAREN: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = b();
				Pair<Tree, Integer> t2 = aprime();
				return new Pair(new Tree("a", Arrays.asList(t1.a, t2.a)), ans);}
			default:
				throw new RuntimeException();
		}
	}
	public Pair<Tree, Integer> s() {
		int value = 0;
		switch(lexer.curToken.a) {
			case NOT: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = i();
				Pair<Tree, Integer> t2 = sprime();
				return new Pair(new Tree("s", Arrays.asList(t1.a, t2.a)), ans);}
			case VAR: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = i();
				Pair<Tree, Integer> t2 = sprime();
				return new Pair(new Tree("s", Arrays.asList(t1.a, t2.a)), ans);}
			case LPAREN: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = i();
				Pair<Tree, Integer> t2 = sprime();
				return new Pair(new Tree("s", Arrays.asList(t1.a, t2.a)), ans);}
			default:
				throw new RuntimeException();
		}
	}
	public Pair<Tree, Integer> c() {
		int value = 0;
		switch(lexer.curToken.a) {
			case NOT: {
				Integer ans = 0;
				Pair<Tree, String> t1 = NOT();
				Pair<Tree, Integer> t2 = c();
				return new Pair(new Tree("c", Arrays.asList(t1.a, t2.a)), ans);}
			case VAR: {
				Integer ans = 0;
				Pair<Tree, String> t1 = VAR();
				Pair<Tree, Integer> t2 = cprime();
				return new Pair(new Tree("c", Arrays.asList(t1.a, t2.a)), ans);}
			case LPAREN: {
				Integer ans = 0;
				Pair<Tree, String> t1 = LPAREN();
				Pair<Tree, Integer> t2 = s();
				Pair<Tree, String> t3 = RPAREN();
				return new Pair(new Tree("c", Arrays.asList(t1.a, t2.a, t3.a)), ans);}
			default:
				throw new RuntimeException();
		}
	}
	public Pair<Tree, Integer> sprime() {
		int value = 0;
		switch(lexer.curToken.a) {
			case ELSE:
			case END:
			case RPAREN:
			{
				Integer ans = 0;
				return new Pair(new Tree("sprime", new ArrayList<>()), value);}
			case IF: {
				Integer ans = 0;
				Pair<Tree, String> t1 = IF();
				Pair<Tree, Integer> t2 = s();
				Pair<Tree, String> t3 = ELSE();
				Pair<Tree, Integer> t4 = s();
				return new Pair(new Tree("sprime", Arrays.asList(t1.a, t2.a, t3.a, t4.a)), ans);}
			default:
				throw new RuntimeException();
		}
	}
	public Pair<Tree, Integer> i() {
		int value = 0;
		switch(lexer.curToken.a) {
			case NOT: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = a();
				Pair<Tree, Integer> t2 = iprime();
				return new Pair(new Tree("i", Arrays.asList(t1.a, t2.a)), ans);}
			case VAR: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = a();
				Pair<Tree, Integer> t2 = iprime();
				return new Pair(new Tree("i", Arrays.asList(t1.a, t2.a)), ans);}
			case LPAREN: {
				Integer ans = 0;
				Pair<Tree, Integer> t1 = a();
				Pair<Tree, Integer> t2 = iprime();
				return new Pair(new Tree("i", Arrays.asList(t1.a, t2.a)), ans);}
			default:
				throw new RuntimeException();
		}
	}
	public Pair<Tree, Integer> cprime() {
		int value = 0;
		switch(lexer.curToken.a) {
			case IN: {
				Integer ans = 0;
				Pair<Tree, String> t1 = IN();
				Pair<Tree, String> t2 = VAR();
				return new Pair(new Tree("cprime", Arrays.asList(t1.a, t2.a)), ans);}
			case NOTIN: {
				Integer ans = 0;
				Pair<Tree, String> t1 = NOTIN();
				Pair<Tree, String> t2 = VAR();
				return new Pair(new Tree("cprime", Arrays.asList(t1.a, t2.a)), ans);}
			case OR:
			case AND:
			case ELSE:
			case XOR:
			case END:
			case RPAREN:
			case IF:
			{
				Integer ans = 0;
				return new Pair(new Tree("cprime", new ArrayList<>()), value);}
			default:
				throw new RuntimeException();
		}
	}
	public Pair<Tree, Integer> bprime() {
		int value = 0;
		switch(lexer.curToken.a) {
			case AND: {
				Integer ans = 0;
				Pair<Tree, String> t1 = AND();
				Pair<Tree, Integer> t2 = b();
				return new Pair(new Tree("bprime", Arrays.asList(t1.a, t2.a)), ans);}
			case OR:
			case ELSE:
			case XOR:
			case END:
			case RPAREN:
			case IF:
			{
				Integer ans = 0;
				return new Pair(new Tree("bprime", new ArrayList<>()), value);}
			default:
				throw new RuntimeException();
		}
	}
	public Pair<Tree, Integer> iprime() {
		int value = 0;
		switch(lexer.curToken.a) {
			case OR: {
				Integer ans = 0;
				Pair<Tree, String> t1 = OR();
				Pair<Tree, Integer> t2 = i();
				return new Pair(new Tree("iprime", Arrays.asList(t1.a, t2.a)), ans);}
			case ELSE:
			case END:
			case RPAREN:
			case IF:
			{
				Integer ans = 0;
				return new Pair(new Tree("iprime", new ArrayList<>()), value);}
			default:
				throw new RuntimeException();
		}
	}


	public Pair<Tree, Integer> parse() {
 		return s();
 	}
}
