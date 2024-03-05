// Generated from /home/kanopus/IdeaProjects/MT/MT3/Expr.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExprParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#hline}.
	 * @param ctx the parse tree
	 */
	void enterHline(ExprParser.HlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#hline}.
	 * @param ctx the parse tree
	 */
	void exitHline(ExprParser.HlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#eline}.
	 * @param ctx the parse tree
	 */
	void enterEline(ExprParser.ElineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#eline}.
	 * @param ctx the parse tree
	 */
	void exitEline(ExprParser.ElineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#inner}.
	 * @param ctx the parse tree
	 */
	void enterInner(ExprParser.InnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#inner}.
	 * @param ctx the parse tree
	 */
	void exitInner(ExprParser.InnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(ExprParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(ExprParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#while}.
	 * @param ctx the parse tree
	 */
	void enterWhile(ExprParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#while}.
	 * @param ctx the parse tree
	 */
	void exitWhile(ExprParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(ExprParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(ExprParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#vard}.
	 * @param ctx the parse tree
	 */
	void enterVard(ExprParser.VardContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#vard}.
	 * @param ctx the parse tree
	 */
	void exitVard(ExprParser.VardContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExprParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExprParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(ExprParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(ExprParser.PrintContext ctx);
}