import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) throws IOException {
		String pythonCode =
				"""
						a = 5 + 5
						b = 3
						a
						c = "text1"
						d = c + " text2"
						print(d)
						while a > b:
							b = b + 1
							print(b)
						if a == b:
							print(c)
						if "a" > "b":
							print("text3")
						""";

		ExprLexer lexer = new ExprLexer(CharStreams.fromString(pythonCode));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprParser parser = new ExprParser(tokens);
		ParseTree tree = parser.prog();
		Visitor visitor = new Visitor();
		Files.writeString(Paths.get("src/Example.c"), visitor.visit(tree));
		try {
			if (new ProcessBuilder("gcc", "-o", "musor", "src/Example.c").start().waitFor() != 0) {
				throw new RuntimeException();
			}
			new ProcessBuilder("./musor").inheritIO().start().waitFor();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}

