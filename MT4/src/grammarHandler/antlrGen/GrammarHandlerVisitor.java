// Generated from /home/kanopus/IdeaProjects/MT/MT4/src/grammarHandler/GrammarHandler.g4 by ANTLR 4.13.1
package grammarHandler.antlrGen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarHandlerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarHandlerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarHandlerParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(GrammarHandlerParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarHandlerParser#srules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSrules(GrammarHandlerParser.SrulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarHandlerParser#nonterminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonterminal(GrammarHandlerParser.NonterminalContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarHandlerParser#terminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminal(GrammarHandlerParser.TerminalContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarHandlerParser#rules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRules(GrammarHandlerParser.RulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarHandlerParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule(GrammarHandlerParser.RuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarHandlerParser#part_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPart_rule(GrammarHandlerParser.Part_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarHandlerParser#myImport}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMyImport(GrammarHandlerParser.MyImportContext ctx);
}