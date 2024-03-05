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
