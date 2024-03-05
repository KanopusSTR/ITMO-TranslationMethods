package generator;

import grammarHandler.GrammarHandlerVisitor;

import java.util.*;

public class FirstFollow {
	Map<String, Set<List<GrammarHandlerVisitor.GG>>> transition;

	Map<String, Set<GrammarHandlerVisitor.GG>> firsts = new HashMap<>();
	Map<String, Set<GrammarHandlerVisitor.GG>> follows = new HashMap<>();

	public FirstFollow(Map<String, Set<List<GrammarHandlerVisitor.GG>>> transition, Set<String> nonterminals) {
		this.transition = transition;
		for (int i = 0; i < 5; i++) {
			for (String nonterminal : nonterminals) {
				if (firsts.containsKey(nonterminal)) {
					firsts.get(nonterminal).addAll(getFirst(nonterminal));
				} else {
					firsts.put(nonterminal, getFirst(nonterminal));
				}
			}
		}

		follows.put("s", new HashSet<>() {{
			add(new GrammarHandlerVisitor.GG("END"));
		}});

		for (int i = 0; i < 10; i++) {
			for (String nonterminal : nonterminals) {
				getFollow(nonterminal);
			}
		}
	}

	public boolean checkLL1() {
		for (Map.Entry<String, Set<List<GrammarHandlerVisitor.GG>>> nonterminals : transition.entrySet()) {
			List<Set<GrammarHandlerVisitor.GG>> firstsList = new ArrayList<>();
			for (List<GrammarHandlerVisitor.GG> list : nonterminals.getValue()) {
				firstsList.add(getSF(list));
			}

			for (int i = 0; i < firstsList.size(); i++) {
				for (int j = 0; j < firstsList.size() && j != i; j++) {
					Set<GrammarHandlerVisitor.GG> first1 = firstsList.get(i);
					Set<GrammarHandlerVisitor.GG> first2 = firstsList.get(j);
					Set<GrammarHandlerVisitor.GG> loc = new HashSet<>(first1);
					loc.retainAll(first2);
					if (!loc.isEmpty()) {
						return false;
					}
				}
			}
			for (int i = 0; i < firstsList.size(); i++) {
				Set<GrammarHandlerVisitor.GG> first1 = firstsList.get(i);
				if (first1.contains(new GrammarHandlerVisitor.GG("EPS"))) {
					for (int j = 0; j < firstsList.size() && j != i; j++) {
						Set<GrammarHandlerVisitor.GG> first2 = firstsList.get(j);
						Set<GrammarHandlerVisitor.GG> loc = new HashSet<>(first2);
						loc.retainAll(follows.get(nonterminals.getKey()));
						if (!loc.isEmpty()) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public Map<String, Set<grammarHandler.GrammarHandlerVisitor.GG>> getFirsts() {
		return firsts;
	}

	public Map<String, Set<grammarHandler.GrammarHandlerVisitor.GG>> getFollows() {
		return follows;
	}

	private Set<GrammarHandlerVisitor.GG> getFirst(String key) {
		Set<GrammarHandlerVisitor.GG> first = new HashSet<>();
		for (List<GrammarHandlerVisitor.GG> list : transition.get(key)) {
			first.addAll(getSF(list));
		}
		return first;
	}


	private Set<GrammarHandlerVisitor.GG> getSF(List<GrammarHandlerVisitor.GG> list) {
		Set<GrammarHandlerVisitor.GG> first = new HashSet<>();
		int curIndex = 0;
		boolean flag = true;
		while (flag) {
			if (curIndex == list.size()) {
				break;
			}
			flag = false;
			Set<GrammarHandlerVisitor.GG> set = getSmallFirst(list.get(curIndex).toString());
			curIndex++;
			first.addAll(set);
			if (set.contains(new GrammarHandlerVisitor.GG("EPS"))) {
				flag = true;
			}
		}
		return first;
	}

	private Set<GrammarHandlerVisitor.GG> getSmallFirst(String key) {
		if (isTerminal(key)) {
			return new HashSet<>() {{
				add(new GrammarHandlerVisitor.GG(key));
			}};
		}
		if (!transition.containsKey(key)) {
			return new HashSet<>() {{
				add(new GrammarHandlerVisitor.GG("EPS"));
			}};
		}
		if (firsts.containsKey(key)) {
			return firsts.get(key);
		}
		return Collections.emptySet();
	}

	private void getFollow(String key) {
		for (List<GrammarHandlerVisitor.GG> list : transition.get(key)) {
			for (int ggIndex = 0; ggIndex < list.size(); ggIndex++) {
				GrammarHandlerVisitor.GG gg = list.get(ggIndex);
				if (!isTerminal(gg.toString())) {
					Set<GrammarHandlerVisitor.GG> set = getSF(list.subList(ggIndex + 1, list.size()));
					if (set.isEmpty()) {
						set.add(new GrammarHandlerVisitor.GG("EPS"));
					}
					Set<GrammarHandlerVisitor.GG> newSet = new HashSet<>(Set.copyOf(set));
					newSet.remove(new GrammarHandlerVisitor.GG("EPS"));
					if (follows.containsKey(gg.toString())) {
						follows.get(gg.toString()).addAll(newSet);
					} else {
						follows.put(gg.toString(), newSet);
					}
					if (set.contains(new GrammarHandlerVisitor.GG("EPS"))) {
						if (follows.containsKey(key)) {
							follows.get(gg.toString()).addAll(follows.get(key));
							;
						}
					}
				}
			}
		}
	}

	private boolean isTerminal(String key) {
		return !(key.toLowerCase()).equals(key);
	}
}
