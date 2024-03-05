#include "lexicalAnalyzer.h"
#include "tree.h"

struct Parser {
    LexicalAnalyzer lex;

    explicit Parser(LexicalAnalyzer lex) : lex(lex) {
        this->lex.nextToken();
    }

    Tree S() {
        switch (lex.curToken) {
            case NOT:
            case VAR:
            case LPAREN: {
                Tree sub = I();
                Tree cont = SPrime();
                return Tree("S", {sub, cont});
            }
            default:
                throw std::invalid_argument("expected [not, a, (], but got " + ToString(lex.curToken) + " in pos " +
                                            std::to_string(lex.curPos));
        }
    }

    Tree SPrime() {
        switch (lex.curToken) {
            case IF: {
                lex.nextToken();
                Tree sub = S();
                lex.nextToken();
                Tree cont = S();
                return Tree("S'", {Tree("if"), sub, Tree("else"), cont});
            }
            case RPAREN:
            case END:
            case ELSE:
                return Tree("S'");
            default:
                throw std::invalid_argument("expected [if], but got " + ToString(lex.curToken) + " in pos " +
                                            std::to_string(lex.curPos));
        }
    }

    Tree I() {
        switch (lex.curToken) {
            case NOT:
            case VAR:
            case LPAREN: {
                Tree sub = A();
                Tree cont = IPrime();
                return Tree("I", {sub, cont});
            }
            default:
                throw std::invalid_argument("expected [not, a, (], but got " + ToString(lex.curToken) + " in pos " +
                                            std::to_string(lex.curPos));
        }
    }

    Tree IPrime() {
        switch (lex.curToken) {
            case OR: {
                lex.nextToken();
                Tree sub = I();
                return Tree("I'", {Tree("or"), sub});
            }
            case RPAREN:
            case END:
            case IF:
            case ELSE:
                return Tree("I'");
            default:
                throw std::invalid_argument("expected [or], but got " + ToString(lex.curToken) + " in pos " +
                                            std::to_string(lex.curPos));
        }
    }

    Tree A() {
        switch (lex.curToken) {
            case VAR:
            case NOT:
            case LPAREN: {
                Tree sub = B();
                Tree cont = APrime();
                return Tree("A", {sub, cont});
            }
            default:
                throw std::invalid_argument(
                        "expected [a, (, not], but got " + ToString(lex.curToken) + " in pos " + std::to_string(lex.curPos));
        }
    }

    Tree APrime() {
        switch (lex.curToken) {
            case XOR: {
                lex.nextToken();
                Tree sub = Tree("xor");
                Tree cont = A();
                return Tree("A'", {sub, cont});
            }
            case RPAREN:
            case OR:
            case END:
            case IF:
            case ELSE:
                return Tree("A'");
            default:
                throw std::invalid_argument(
                        "expected [xor], but got " + ToString(lex.curToken) + " in pos " +
                        std::to_string(lex.curPos));
        }
    }

    Tree B() {
        switch (lex.curToken) {
            case VAR:
            case NOT:
            case LPAREN: {
                Tree sub = C();
                Tree cont = BPrime();
                return Tree("B", {sub, cont});
            }
            default:
                throw std::invalid_argument(
                        "expected [a, (, not], but got " + ToString(lex.curToken) + " in pos " + std::to_string(lex.curPos));
        }
    }

    Tree BPrime() {
        switch (lex.curToken) {
            case AND: {
                lex.nextToken();
                Tree sub = B();
                return Tree("B'", {Tree("and"), sub});
            }
            case XOR:
            case RPAREN:
            case END:
            case OR:
            case IF:
            case ELSE:
                return Tree("B'");
            default:
                throw std::invalid_argument(
                        "expected [and], but got " + ToString(lex.curToken) + " in pos " +
                        std::to_string(lex.curPos));
        }
    }

    Tree C() {
        switch (lex.curToken) {
            case VAR: {
                lex.nextToken();
                Tree sub = Tree("a");
                Tree cont = CPrime();
                return Tree("C", {sub, cont});
            }
            case LPAREN: {
                lex.nextToken();
                Tree sub = S();
                lex.nextToken();
                return Tree("C", {Tree("("), sub, Tree(")")});
            }
            case NOT: {
                lex.nextToken();
                Tree sub = Tree("not");
                Tree cont = C();
                return Tree("C", {sub, cont});
            }
            default:
                throw std::invalid_argument(
                        "expected [a, (, not], but got " + ToString(lex.curToken) + " in pos " + std::to_string(lex.curPos));
        }
    }

    Tree CPrime() {
        switch (lex.curToken) {
            case IN: {
                lex.nextToken();
                lex.nextToken();
                return Tree("C'", {Tree("in"), Tree("a")});
            }
            case NOT:
                lex.nextToken();
                lex.nextToken();
                lex.nextToken();
                return Tree("C'", {Tree("not in"), Tree("a")});
            case OR:
            case XOR:
            case RPAREN:
            case END:
            case AND:
            case IF:
            case ELSE:
                return Tree("C'");
            default:
                throw std::invalid_argument(
                        "expected [in, not in], but got " + ToString(lex.curToken) + " in pos " +
                        std::to_string(lex.curPos));
        }
    }

    Tree parse() {
        auto tree = S();
        if (lex.curToken != END) {
            throw std::invalid_argument("expected $, but got " + ToString(lex.curToken));
        }
        return tree;
    }

    void buildDotFile(const std::string &filename, const Tree &tree) {
        std::ofstream outputFile(filename);
        outputFile << "digraph G {" << std::endl;
        buildDotFileHelper(outputFile, -1, tree);
        outputFile << "}" << std::endl;
    }

    void buildDotFileHelper(std::ofstream &outputFile, int parentIndex, const Tree &tree) {
        int currentIndex = nodeCounter++;
        outputFile << "  node" << currentIndex << " [label=\"" << tree.node << "\"];" << std::endl;
        if (parentIndex != -1) {
            outputFile << "  node" << parentIndex << " -> node" << currentIndex << ";" << std::endl;
        }
        for (const auto &child: tree.children) {
            buildDotFileHelper(outputFile, currentIndex, child);
        }
    }

    int nodeCounter = 0;
};