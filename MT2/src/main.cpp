#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>
#include "cassert"

#include "parser.h"

bool test_base_equal(std::string &&string, Tree &&tree) {
    std::stringstream ss(string);
    auto la = LexicalAnalyzer(&ss);
    auto parser = Parser(la);
    Tree m_tree = parser.parse();
    return m_tree == tree;
}

bool test_base_parse_error(std::string &&string) {
    std::stringstream ss(string);
    auto la = LexicalAnalyzer(&ss);
    auto parser = Parser(la);
    try {
        Tree m_tree = parser.parse();
    } catch (std::invalid_argument &e) {
        return true;
    }
    return false;
}


void test_easy1() {
    assert(test_base_equal("a",
                           Tree("S", {Tree("I", {Tree("A", {Tree("B", {Tree("C", {Tree("a", {}),Tree("C'", {}),}),Tree("B'", {}),}),Tree("A'", {}),}),Tree("I'", {}),}),Tree("S'", {}),})
                           ));
}

void test_easy2() {
    assert(test_base_equal("a or c",
                           Tree("S", {Tree("I", {Tree("A", {Tree("B", {Tree("C", {Tree("a", {}),Tree("C'", {}),}),Tree("B'", {}),}),Tree("A'", {}),}),Tree("I'", {Tree("or", {}),Tree("I", {Tree("A", {Tree("B", {Tree("C", {Tree("a", {}),Tree("C'", {}),}),Tree("B'", {}),}),Tree("A'", {}),}),Tree("I'", {}),}),}),}),Tree("S'", {}),})
                           ));
}

void test_easy3() {
    assert(test_base_equal("a xor c",
                           Tree("S", {Tree("I", {Tree("A", {Tree("B", {Tree("C", {Tree("a", {}),Tree("C'", {}),}),Tree("B'", {}),}),Tree("A'", {Tree("xor", {}),Tree("A", {Tree("B", {Tree("C", {Tree("a", {}),Tree("C'", {}),}),Tree("B'", {}),}),Tree("A'", {}),}),}),}),Tree("I'", {}),}),Tree("S'", {}),})
                           ));
}

void test_easy4() {
    assert(test_base_equal("a and c",
                           Tree("S", {Tree("I", {Tree("A", {Tree("B", {Tree("C", {Tree("a", {}),Tree("C'", {}),}),Tree("B'", {Tree("and", {}),Tree("B", {Tree("C", {Tree("a", {}),Tree("C'", {}),}),Tree("B'", {}),}),}),}),Tree("A'", {}),}),Tree("I'", {}),}),Tree("S'", {}),})
                           ));
}

void test_easy5() {
    assert(test_base_equal("a in c",
                           Tree("S", {Tree("I", {Tree("A", {Tree("B", {Tree("C", {Tree("a", {}),Tree("C'", {Tree("in", {}),Tree("a", {}),}),}),Tree("B'", {}),}),Tree("A'", {}),}),Tree("I'", {}),}),Tree("S'", {}),})
                           ));
}

void test_easy6() {
    assert(test_base_equal("a not in c",
                           Tree("S", {Tree("I", {Tree("A", {Tree("B", {Tree("C", {Tree("a", {}),Tree("C'", {Tree("not in", {}),Tree("a", {}),}),}),Tree("B'", {}),}),Tree("A'", {}),}),Tree("I'", {}),}),Tree("S'", {}),})
                           ));
}

void test_easy7() {
    assert(test_base_equal("a if b else c",
                           Tree("S", {Tree("I", {Tree("A", {Tree("B", {Tree("C", {Tree("a", {}),Tree("C'", {}),}),Tree("B'", {}),}),Tree("A'", {}),}),Tree("I'", {}),}),Tree("S'", {Tree("if", {}),Tree("S", {Tree("I", {Tree("A", {Tree("B", {Tree("C", {Tree("a", {}),Tree("C'", {}),}),Tree("B'", {}),}),Tree("A'", {}),}),Tree("I'", {}),}),Tree("S'", {}),}),Tree("else", {}),Tree("S", {Tree("I", {Tree("A", {Tree("B", {Tree("C", {Tree("a", {}),Tree("C'", {}),}),Tree("B'", {}),}),Tree("A'", {}),}),Tree("I'", {}),}),Tree("S'", {}),}),}),})
    ));
}

void test_parse_error1() {
    assert(true == test_base_parse_error("a)"));
}

void test_parse_error2() {
    assert(true == test_base_parse_error("a b"));
}

void test_parse_error3() {
    assert(true == test_base_parse_error("a or"));
}

void test_parse_error4() {
    assert(true == test_base_parse_error("and x"));
}

void test_parse_error5() {
    assert(true == test_base_parse_error("xor x"));
}

void test_hard() {
    assert(true == test_base_equal("(a in q) or not v and y and (not (b not in a) xor q)",
                                   Tree("S", {Tree("I", {Tree("A", {Tree("B", {Tree("C", {Tree("(", {}),Tree("S", {Tree("I", {Tree("A", {Tree("B", {Tree("C", {Tree("a", {}),Tree("C'", {Tree("in", {}),Tree("a", {}),}),}),Tree("B'", {}),}),Tree("A'", {}),}),Tree("I'", {}),}),Tree("S'", {}),}),Tree(")", {}),}),Tree("B'", {}),}),Tree("A'", {}),}),Tree("I'", {Tree("or", {}),Tree("I", {Tree("A", {Tree("B", {Tree("C", {Tree("not", {}),Tree("C", {Tree("a", {}),Tree("C'", {}),}),}),Tree("B'", {Tree("and", {}),Tree("B", {Tree("C", {Tree("a", {}),Tree("C'", {}),}),Tree("B'", {Tree("and", {}),Tree("B", {Tree("C", {Tree("(", {}),Tree("S", {Tree("I", {Tree("A", {Tree("B", {Tree("C", {Tree("not", {}),Tree("C", {Tree("(", {}),Tree("S", {Tree("I", {Tree("A", {Tree("B", {Tree("C", {Tree("a", {}),Tree("C'", {Tree("not in", {}),Tree("a", {}),}),}),Tree("B'", {}),}),Tree("A'", {}),}),Tree("I'", {}),}),Tree("S'", {}),}),Tree(")", {}),}),}),Tree("B'", {}),}),Tree("A'", {Tree("xor", {}),Tree("A", {Tree("B", {Tree("C", {Tree("a", {}),Tree("C'", {}),}),Tree("B'", {}),}),Tree("A'", {}),}),}),}),Tree("I'", {}),}),Tree("S'", {}),}),Tree(")", {}),}),Tree("B'", {}),}),}),}),}),}),Tree("A'", {}),}),Tree("I'", {}),}),}),}),Tree("S'", {}),})
                                   ));
}

void example(int argc, char *argv[]) {
    if (argc != 4) {
        std::cout << "you must write 3 paths\n";
        return;
    }
    std::ifstream inputFile(argv[1]);
    auto la = LexicalAnalyzer(&inputFile);
    auto parser = Parser(la);
    Tree tree = parser.parse();
    parser.buildDotFile(argv[2], tree);
    std::string command = "dot -Tpng " + std::string(argv[2]) + " -o " + std::string(argv[3]);
    system(command.c_str());
    inputFile.close();
}

int main(int argc, char *argv[]) {
    example(argc, argv);


    test_easy1();
    test_easy2();
    test_easy3();
    test_easy4();
    test_easy5();
    test_easy6();
    test_easy7();

    test_parse_error1();
    test_parse_error2();
    test_parse_error3();
    test_parse_error4();
    test_parse_error5();

    test_hard();
}