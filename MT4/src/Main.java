import generated.*;
import org.antlr.v4.runtime.misc.Pair;


public class Main {

	private static String printTree(Tree tree) {
		String a = "Tree(\"" + tree.getNode() + "\", {";
		for (Tree child: tree.getChildren()) {
			a += printTree(child) + ",";
		}
		a += "})";
		return a;
	}

	public static void main(String[] args) {
		generated.calc.Lexer lexer = new generated.calc.Lexer("gcd(7 + 14, 56)*3 + 5");
		generated.calc.Parser parser = new generated.calc.Parser(lexer);
		Pair<Tree, Integer> tree = parser.parse();
		System.out.println(printTree(tree.a));
		System.out.println(tree.b);

		generated.hw2.Lexer lexer2 = new generated.hw2.Lexer("a in b");
		generated.hw2.Parser parser2 = new generated.hw2.Parser(lexer2);
		Pair<Tree, Integer> tree2 = parser2.parse();
		System.out.println(printTree(tree2.a));
		System.out.println(tree2.b);
	}
}