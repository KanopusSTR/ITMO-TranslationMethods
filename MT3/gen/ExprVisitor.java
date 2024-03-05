// Generated from /home/kanopus/IdeaProjects/MT/MT3/Expr.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ExprParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#hline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHline(ExprParser.HlineContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#eline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEline(ExprParser.ElineContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#inner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInner(ExprParser.InnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(ExprParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(ExprParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(ExprParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#vard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVard(ExprParser.VardContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ExprParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(ExprParser.PrintContext ctx);
}