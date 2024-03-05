package generator;

import grammarHandler.GrammarHandlerVisitor;
import grammarHandler.antlrGen.GrammarHandlerLexer;
import grammarHandler.antlrGen.GrammarHandlerParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Generator {

	public static void main(String[] args) throws IOException {
		Generator generator = new Generator(args[0], args[1]);
		generator.generateTokens();
		generator.generateLexer();
		generator.generateParser();
		generator.generateTree();
	}

	Set<String> terminals = new HashSet<>();

	Map<String, String> terminalsReg = new HashMap<>();

	Map<String, String> skippedReg = new HashMap<>();
	Map<String, Set<List<GrammarHandlerVisitor.GG>>> transitions = new HashMap<>();
	Map<String, Set<List<GrammarHandlerVisitor.GG>>> transitionsForAttrib = new HashMap<>();
	Set<String> nonterminals = new HashSet<>();
	Set<String> nonterminalsForAttrib = new HashSet<>();
	Map<String, String> nonterminalsReturnType = new HashMap<>();

	List<String> imports = new ArrayList<>();

	FirstFollow ff;
	String folderName;

	public Generator(String fileName, String folderName) throws IOException {
		parseGrammarFile(fileName);
		this.folderName = folderName;
	}

	private void parseGrammarFile(String fileName) throws IOException {
		String text = Files.readString(Paths.get(fileName));
		GrammarHandlerLexer lexer = new GrammarHandlerLexer(CharStreams.fromString(text));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GrammarHandlerParser parser = new GrammarHandlerParser(tokens);
		ParseTree tree = parser.prog();
		GrammarHandlerVisitor visitor = new GrammarHandlerVisitor();
		imports = visitor.getImports();
		transitions = visitor.getTransition();
		transitionsForAttrib = visitor.getTransitionForAttrib();
		terminals = visitor.getTerminals();
		nonterminals = visitor.getNonterminals();
		nonterminalsForAttrib = visitor.getNonterminalsForAttrib();
		nonterminalsReturnType = visitor.getNonterminalsReturnType();
		terminalsReg = visitor.getTerminalsReg();
		skippedReg = visitor.getSkippedReg();
		visitor.visit(tree);
		ff = new FirstFollow(transitions, nonterminals);

		if (!ff.checkLL1()) {
			throw new RuntimeException("Your grammar is not LL1");
		}
	}

	private boolean isCode(String token) {
		return !token.isEmpty() && token.charAt(0) == '{';
	}

	public void generateTokens() throws IOException {
		StringBuilder outputString1 = new StringBuilder(String.format("package generated.%s;", folderName));
		outputString1.append(System.lineSeparator()).append("public enum Tokens {\n");
		outputString1.append("END").append(", ");
		for (String terminal : terminals) {
			outputString1.append(terminal).append(", ");
		}
		outputString1.append(System.lineSeparator()).append("}");

		Files.writeString(Paths.get(String.format("src/generated/%s/Tokens.java", folderName)), outputString1.toString());

		StringBuilder outputString2 = new StringBuilder(String.format("package generated.%s;", folderName));
		outputString2.append(System.lineSeparator()).append("public enum TokensSkipped {\n");
		for (String terminal : skippedReg.keySet()) {
			outputString2.append(terminal).append(", ");
		}
		outputString2.append(System.lineSeparator()).append("}");

		Files.writeString(Paths.get(String.format("src/generated/%s/TokensSkipped.java", folderName)), outputString2.toString());
	}

	public void generateLexer() throws IOException {
		ArrayList<String> newPair = new ArrayList<>();
		newPair.add("new Pair<>(Tokens.END, Pattern.compile(\"^$\"))");
		for (Map.Entry<String, String> terminal : terminalsReg.entrySet()) {
			newPair.add("new Pair<>(" + "Tokens." + terminal.getKey() + ", " + "Pattern.compile(" + terminal.getValue() + "))");
		}

		ArrayList<String> newPairS = new ArrayList<>();
		for (Map.Entry<String, String> terminal : skippedReg.entrySet()) {
			newPairS.add("new Pair<>(" + "TokensSkipped." + terminal.getKey() + ", " + "Pattern.compile(" + terminal.getValue() + "))");
		}

		String string = String.format("""
				package generated.%s;
								
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
						tokens = List.of(%s);
						skipped = List.of(%s);
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
				""".stripIndent(), folderName, String.join(", ", newPair), String.join(", ", newPairS));

		Files.writeString(Paths.get(String.format("src/generated/%s/Lexer.java", folderName)), string);
	}

	public void generateTree() throws IOException {
		Files.writeString(Paths.get("src/generated/Tree.java"), """
				package generated;
					
				import java.util.List;
				import java.util.Arrays;
					
				public class Tree {
					String node;
					List<Tree> children;
							
					public Tree(String node, List<Tree> children) {
						this.node = node;
						this.children = children;
					}
					
					public String getNode() {
						return node;
					}
					
					
					public List<Tree> getChildren() {
						return children;
					}
				}
				""");
	}

	public void generateParser() throws IOException {


		StringBuilder stringNonterm = new StringBuilder();

		StringBuilder stringTerm = new StringBuilder();

		Map<String, Set<GrammarHandlerVisitor.GG>> firsts = ff.firsts;

		Map<String, Set<GrammarHandlerVisitor.GG>> follows = ff.follows;

		for (String term : terminals) {
			stringTerm.append(String.format("""
						public Pair<Tree, String> %s() {
							if (!lexer.curToken.a.toString().equals("%s")) {
								throw new RuntimeException("curToken is not equals required %s");
							}
							Pair<Tree, String> pair = new Pair(new Tree("%s", new ArrayList<>()), lexer.curToken.b);
							lexer.nextToken();
							return pair;
						}
					""".stripIndent(), term, term, term, term));
		}

		for (String nonterminalx : nonterminalsForAttrib) {

			String nonterminal = nonterminalx.split("\\(")[0];
			String nonterminaly = nonterminalx.split("\\(")[1];

			if (nonterminalsReturnType.get(nonterminal).isEmpty()) {
				nonterminalsReturnType.put(nonterminal, "Integer");
			}

			StringBuilder stringFirstTokens = new StringBuilder();

			for (GrammarHandlerVisitor.GG nonterminal1 : firsts.get(nonterminal)) {

				if (nonterminal1.equals(new GrammarHandlerVisitor.GG("EPS"))) {
					for (GrammarHandlerVisitor.GG bb: follows.get(nonterminal)) {
						stringFirstTokens.append(String.format("			case %s:\n", bb));
					}
					stringFirstTokens.append("			{\n");
					stringFirstTokens.append("				Integer ans = 0;\n");
					stringFirstTokens.append(String.format("				return new Pair(new Tree(\"%s\", new ArrayList<>()), value);}\n", nonterminal));
				} else {
					for (List<GrammarHandlerVisitor.GG> list : transitionsForAttrib.get(nonterminal)) {
						if (!isCode(list.get(0).toString())) {
							if (!list.get(0).toString().toLowerCase().equals(list.get(0).toString()) && !Objects.equals(list.get(0).toString(), nonterminal1.toString())) {
								continue;
							}
						}
						stringFirstTokens.append(String.format("			case %s: {\n", nonterminal1));

						stringFirstTokens.append("				Integer ans = 0;\n");

						List<String> locList = new ArrayList<>();
						for (GrammarHandlerVisitor.GG elem : list) {
							if (isCode(elem.toString())) {
								stringFirstTokens.append("				" + elem.toString().substring(1, elem.toString().length() - 1) + "\n");
							} else  if (elem.toString().contains("(")) {
								String retType = elem.toString().split("\\(")[0];
								if (nonterminalsReturnType.get(retType).isEmpty()) {
									nonterminalsReturnType.put(retType, "Integer");
								}
								locList.add(String.format("t%d.a", locList.size() + 1));
								stringFirstTokens.append(String.format("				Pair<Tree, %s> t%d = %s;\n", nonterminalsReturnType.get(retType), locList.size(), elem));
							}else {
								locList.add(String.format("t%d.a", locList.size() + 1));
								stringFirstTokens.append(String.format("				Pair<Tree, %s> t%d = %s();\n", "String", locList.size(), elem));
							}
						}
						stringFirstTokens.append(String.format("				return new Pair(new Tree(\"%s\", Arrays.asList(%s)), ans);}\n", nonterminal, String.join(", ", locList)));
					}
				}
			}

			stringFirstTokens.append(String.format("			default:\n" + "				throw new RuntimeException(\"curToken is not cased in %s\");", nonterminal));

			String nonterminalyNew = "";
			if (nonterminaly.equals(")")) {
				nonterminalyNew = "int value = 0;";
			}
			stringNonterm.append(String.format("""
						public Pair<Tree, %s> %s {
							%s
							switch(lexer.curToken.a) {
					%s
							}
						}
					""".stripIndent(), nonterminalsReturnType.get(nonterminal), nonterminalx, nonterminalyNew, stringFirstTokens));
		}


		StringBuilder sbImports = new StringBuilder();

		for (String myImport : imports) {
			sbImports.append(myImport.substring(1, myImport.length() - 1)).append(System.lineSeparator());
		}

		String string = String.format("""
				package generated.%s;
				
				import java.util.Arrays;
				import java.util.ArrayList;
				import org.antlr.v4.runtime.misc.Pair;
				
				import static java.lang.Integer.parseInt;
				
				import generated.*;
								
				public class Parser {
				
					%s
								
					Lexer lexer;
				 
				 	public Parser(Lexer lexer) {
				 		this.lexer = lexer;
				 	}
					
				%s
				
					public Pair<Tree, %s> parse() {
				 		return s();
				 	}
				}
				""".stripIndent(), folderName, sbImports, stringTerm.append(stringNonterm), nonterminalsReturnType.get("s"));

		Files.writeString(Paths.get(String.format("src/generated/%s/Parser.java", folderName)), string);
	}
}
