// Generated from /home/kanopus/IdeaProjects/MT/MT4/src/grammarHandler/GrammarHandler.g4 by ANTLR 4.13.1
package grammarHandler.antlrGen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarHandlerParser}.
 */
public interface GrammarHandlerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarHandlerParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(GrammarHandlerParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarHandlerParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(GrammarHandlerParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarHandlerParser#srules}.
	 * @param ctx the parse tree
	 */
	void enterSrules(GrammarHandlerParser.SrulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarHandlerParser#srules}.
	 * @param ctx the parse tree
	 */
	void exitSrules(GrammarHandlerParser.SrulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarHandlerParser#nonterminal}.
	 * @param ctx the parse tree
	 */
	void enterNonterminal(GrammarHandlerParser.NonterminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarHandlerParser#nonterminal}.
	 * @param ctx the parse tree
	 */
	void exitNonterminal(GrammarHandlerParser.NonterminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarHandlerParser#terminal}.
	 * @param ctx the parse tree
	 */
	void enterTerminal(GrammarHandlerParser.TerminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarHandlerParser#terminal}.
	 * @param ctx the parse tree
	 */
	void exitTerminal(GrammarHandlerParser.TerminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarHandlerParser#rules}.
	 * @param ctx the parse tree
	 */
	void enterRules(GrammarHandlerParser.RulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarHandlerParser#rules}.
	 * @param ctx the parse tree
	 */
	void exitRules(GrammarHandlerParser.RulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarHandlerParser#rule}.
	 * @param ctx the parse tree
	 */
	void enterRule(GrammarHandlerParser.RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarHandlerParser#rule}.
	 * @param ctx the parse tree
	 */
	void exitRule(GrammarHandlerParser.RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarHandlerParser#part_rule}.
	 * @param ctx the parse tree
	 */
	void enterPart_rule(GrammarHandlerParser.Part_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarHandlerParser#part_rule}.
	 * @param ctx the parse tree
	 */
	void exitPart_rule(GrammarHandlerParser.Part_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarHandlerParser#myImport}.
	 * @param ctx the parse tree
	 */
	void enterMyImport(GrammarHandlerParser.MyImportContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarHandlerParser#myImport}.
	 * @param ctx the parse tree
	 */
	void exitMyImport(GrammarHandlerParser.MyImportContext ctx);
}