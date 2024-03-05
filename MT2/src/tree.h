struct Tree {
    std::string node;
    std::vector<Tree> children;

    Tree(std::string node, const std::vector<Tree> &children)
            : node(std::move(node)), children(children) {}

    explicit Tree(std::string node)
            : node(std::move(node)) {}

    bool operator== (const Tree& other) const {
        if (node == other.node && children.size() == other.children.size()) {
            for (int i = 0; i < children.size(); ++i) {
                if (children[i] != other.children[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    bool operator!= (const Tree& other) const {
        return !operator==(other);
    }

    std::string toString() {
        auto a = "Tree(\"" + node + "\", {";
        for (Tree child: children) {
            a += child.toString() + ",";
        }
        a += "})";
        return a;
    }
};