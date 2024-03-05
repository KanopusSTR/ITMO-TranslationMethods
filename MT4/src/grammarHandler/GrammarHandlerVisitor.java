package grammarHandler;

import grammarHandler.antlrGen.GrammarHandlerBaseVisitor;
import grammarHandler.antlrGen.GrammarHandlerParser;

import java.util.*;

public class GrammarHandlerVisitor extends GrammarHandlerBaseVisitor<String> {

	Set<String> nonterminals = new HashSet<>();
	Map<String, String> nonterminalsReturnType = new HashMap<>();
	Set<String> nonterminalsForAttrib = new HashSet<>();
	Set<String> terminals = new HashSet<>();
	Map<String, String> skippedReg = new HashMap<>();
	Map<String, String> terminalsReg = new HashMap<>();
	Map<String, Set<List<GG>>> transition = new HashMap<>();

	Map<String, Set<List<GG>>> transitionForAttrib = new HashMap<>();

	List<String> imports = new ArrayList<>();


	public static class GG {
		String bb;

		public GG(String string) {
			this.bb = string;
		}

		@Override
		public boolean equals(Object me) {
			if (me instanceof GG gg1) {
				return Objects.equals(this.bb, gg1.bb);
			} else return false;
		}

		@Override
		public int hashCode() {
			return bb.hashCode();
		}

		@Override
		public String toString() {
			return bb;
		}
	}

	@Override
	public String visitNonterminal(GrammarHandlerParser.NonterminalContext ctx) {
		nonterminals.add(ctx.NTNAME().getText());
		nonterminalsForAttrib.add(ctx.NTNAME().getText() + ctx.INHERITED());
		String string = ctx.SYNTHESIZED().getText().substring(1, ctx.SYNTHESIZED().getText().length() - 1);
		nonterminalsReturnType.put(ctx.NTNAME().getText(), string.split(" ")[0]);
		visit(ctx.rules());
		return ctx.NTNAME().getText();
	}

	public String visitTerminal(GrammarHandlerParser.TerminalContext ctx) {
		terminals.add(ctx.TNAME().getText());
		String reg = ctx.REG().getText();
		terminalsReg.put(ctx.TNAME().getText(), reg);
		return ctx.TNAME().getText();
	}

	public String visitMyImport(GrammarHandlerParser.MyImportContext ctx) {
		imports.add(ctx.IMPORT().getText());
		return ctx.IMPORT().getText();
	}

	public String visitSrules(GrammarHandlerParser.SrulesContext ctx) {
		String reg = ctx.REG().getText();
		skippedReg.put(ctx.TNAME().getText(), reg);
		return ctx.TNAME().getText();
	}

	public String visitRule(GrammarHandlerParser.RuleContext ctx) {
		String name = ((GrammarHandlerParser.NonterminalContext) ctx.parent.parent).NTNAME().getText();
		ArrayList<GG> list = new ArrayList<>();
		ArrayList<GG> listForAttrib = new ArrayList<>();
		for (GrammarHandlerParser.Part_ruleContext prule : ctx.part_rule()) {
			if (prule.NTNAME() != null) {
				list.add(new GG(prule.NTNAME().getText()));
				listForAttrib.add(new GG(prule.NTNAME().getText() + prule.INHERITED()));
			} else if (prule.TNAME() != null) {
				list.add(new GG(prule.TNAME().getText()));
				listForAttrib.add(new GG(prule.TNAME().getText()));
			} else if (prule.CODE() != null) {
				listForAttrib.add(new GG(prule.CODE().getText()));
			}
		}
		transition.compute(name, (a, b) -> {
			if (b == null) {
				b = new HashSet<>();
			}
			b.add(list);
			return b;
		});
		transitionForAttrib.compute(name, (a, b) -> {
			if (b == null) {
				b = new HashSet<>();
			}
			b.add(listForAttrib);
			return b;
		});
		return visit(ctx.part_rule(0));
	}

	public Set<String> getTerminals() {
		return terminals;
	}

	public Set<String> getNonterminals() {
		return nonterminals;
	}
	public Set<String> getNonterminalsForAttrib() {
		return nonterminalsForAttrib;
	}
	public Map<String, String> getNonterminalsReturnType() {
		return nonterminalsReturnType;
	}


	public Map<String, String> getTerminalsReg() {
		return terminalsReg;
	}

	public Map<String, String> getSkippedReg() {
		return skippedReg;
	}

	public Map<String, Set<List<GG>>> getTransition() {
		return transition;
	}

	public List<String> getImports() {
		return imports;
	}

	public Map<String, Set<List<GG>>> getTransitionForAttrib() {
		return transitionForAttrib;
	}
}
