import java.util.HashSet;
import java.util.Objects;

public class Visitor extends ExprBaseVisitor<String> {

	HashSet<String> vars = new HashSet<>();

	HashSet<String> stringVariables = new HashSet<>();
	HashSet<String> intVariables = new HashSet<>();

	@Override
	public String visitCond(ExprParser.CondContext ctx) {
		String child1 = visit(ctx.getChild(0));
		if (intVariables.contains(child1)) {
			return "%s %s %s".formatted(visit(ctx.getChild(0)), ctx.COMP().getText(), visit(ctx.getChild(2)));
		} else {
			if (Objects.equals(ctx.COMP().getText(), "==")) {
				return "%s%s, %s)".formatted("strcmp(", visit(ctx.getChild(0)), visit(ctx.getChild(2)));
			} else if (Objects.equals(ctx.COMP().getText(), ">")) {
				return "%s%s, %s) > 0".formatted("strcmp(", visit(ctx.getChild(0)), visit(ctx.getChild(2)));
			} else {
				return "%s%s, %s) < 0".formatted("strcmp(", visit(ctx.getChild(0)), visit(ctx.getChild(2)));
			}
		}
	}

	@Override
	public String visitVard(ExprParser.VardContext ctx) {
		vars.add(ctx.VAR().getText());
		if (isExprInt(ctx.expr())) {
			intVariables.add(ctx.VAR().getText());
			if (ctx.expr().IINPUT() != null) {
				return visit((ctx.expr()));
			} else {
				return "%s %s %s".formatted(ctx.VAR().getText(), ctx.EQUAL().getText(), visit(ctx.expr()));
			}
		} else {
			stringVariables.add(ctx.VAR().getText());
			if (ctx.expr().SINPUT() != null) {
				return visit((ctx.expr()));
			} else {
				return "%s %s %s".formatted(ctx.VAR().getText(), ctx.EQUAL().getText(), visit(ctx.expr()));
			}
		}
	}

	public String visitIf(ExprParser.IfContext ctx) {
		return "if (%s) {%s%s".formatted(visit(ctx.cond()), System.lineSeparator(), visit(ctx.inner()));
	}

	public String visitWhile(ExprParser.WhileContext ctx) {
		return "while (%s) {%s%s".formatted(visit(ctx.cond()), System.lineSeparator(), visit(ctx.inner()));
	}

	public String visitInner(ExprParser.InnerContext ctx) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < (ctx.eline()).size() - 1; i++) {
			str.append("\t\t").append(visit(ctx.eline(i))).append(";").append(ctx.NEWLINE(i).getText());
		}
		str.append("\t\t").append(visit(ctx.eline(ctx.eline().size() - 1))).
				append(";").
				append(System.lineSeparator()).
				append("\t}");

		return str.toString();
	}

	@Override
	public String visitExpr(ExprParser.ExprContext ctx) {
		boolean isInt = isExprInt(ctx);

		StringBuilder str = new StringBuilder();
		if (ctx.INT() != null) {
			str.append(ctx.INT().getText());
		} else if (ctx.STR() != null) {
			str.append(ctx.STR().getText());
		}  else if (ctx.VAR() != null) {
			str.append(ctx.VAR().getText());
		} else if (ctx.IINPUT() != null) {
			String var = ctx.parent.getChild(0).getText();
			str.append("(scanf(\"%ld\", &").append(var).append("), ").append(var).append(")");
		} else if (ctx.SINPUT() != null) {
			String var = ctx.parent.getChild(0).getText();
			str.append("(scanf(\"%s\", &").append(var).append("), ").append(var).append(")");
		} else if (isInt) {
			str.append(visit(ctx.expr(0)));
			str.append(" ");
			str.append(ctx.OPER().getText());
			str.append(" ");
			str.append(visit(ctx.expr(1)));
		} else {
			str.append("concat(");
			str.append(visit(ctx.expr(0)));
			str.append(", ");
			str.append(visit(ctx.expr(1)));
			str.append(")");
		}
		return str.toString();
	}

	@Override
	public String visitPrint(ExprParser.PrintContext ctx) {
		if (isExprInt(ctx.expr())) {
			return "printf(\"%%ld\\n\", %s)".formatted(visit(ctx.expr()));
		}
		return "printf(\"%%s\\n\", %s)".formatted(visit(ctx.expr()));
	}

	@Override
	public String visitProg(ExprParser.ProgContext ctx) {
		StringBuilder str = new StringBuilder();
		str.append("int main() {").append(System.lineSeparator());
		for (int i = 0; i < (ctx.hline()).size(); i++) {
			str.append("\t").append(visit(ctx.hline(i)));
			str.append(";").append(ctx.NEWLINE(i).getText());
		}
		str.append("}");
		StringBuilder newStr = new StringBuilder();
		newStr.append("""
				#include <stdio.h>
				#include <stdlib.h>
				#include <stdint.h>
				#include <string.h>
				
				char* concat(char* str1, char* str2) {
				    char* ans = malloc(strlen(str1) + strlen(str2) + 1);
				    ans[0] = '\\0';
				    strcat(ans, str1);
				    strcat(ans, str2);
				    return ans;
				}
				
				""");
		for (String var : vars) {
			if (stringVariables.contains(var)) {
				newStr.append("char* ").append(var).append(";").append(System.lineSeparator());
			} else {
				newStr.append("int64_t ").append(var).append(";").append(System.lineSeparator());
			}
		}
		newStr.append(System.lineSeparator());
		return newStr.append(str).toString();
	}

	private boolean isExprInt(ExprParser.ExprContext ctx) {
		if (ctx.VAR() != null) {
			return intVariables.contains(ctx.VAR().getText());
		} else if (ctx.INT() != null) {
			return true;
		} else if (ctx.STR() != null) {
			return false;
		} else if (ctx.IINPUT() != null) {
			return true;
		} else if (ctx.SINPUT() != null) {
			return false;
		} else {
			return isExprInt(ctx.expr(0));
		}
	}
}
