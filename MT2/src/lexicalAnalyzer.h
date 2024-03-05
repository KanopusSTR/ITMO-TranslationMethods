#include <iostream>
#include "token.h"

struct LexicalAnalyzer {
    std::istream *is;
    char curChar = -1;
    int curPos;
    Token curToken = LPAREN;

    explicit LexicalAnalyzer(std::istream *is) {
        this->is = is;
        curPos = 0;
        nextChar();
    }

    void nextToken() {
        while (isBlank(curChar) && !is->eof()) {
            nextChar();
        }
        switch (curChar) {
            case '(' :
                nextChar();
                curToken = Token::LPAREN;
                break;
            case 'a': {
                nextChar();
                if (curChar == 'n') {
                    nextChar();
                    if (curChar == 'd') {
                        nextChar();
                        curToken = Token::AND;
                    }
                } else {
                    curToken = Token::VAR;
                }
                break;
            }
            case 'o' :
                nextChar();
                if (curChar == 'r') {
                    curToken = Token::OR;
                } else {
                    curToken = Token::VAR;
                }
                nextChar();
                break;
            case 'i' :
                nextChar();
                if (curChar == 'n') {
                    nextChar();
                    if (curToken == Token::NOT) {
                        curToken = Token::NOTIN;
                    } else {
                        curToken = Token::IN;
                    }
                } else if (curChar == 'f') {
                    nextChar();
                    curToken = Token::IF;
                } else {
                    curToken = Token::VAR;
                }
                break;
            case 'n' :
                nextChar();
                if (curChar == 'o') {
                    nextChar();
                    if (curChar == 't') {
                        nextChar();
                        curToken = Token::NOT;
                    }
                } else {
                    curToken = Token::VAR;
                }
                break;
            case 'x' :
                nextChar();
                if (curChar == 'o') {
                    nextChar();
                    if (curChar == 'r') {
                        nextChar();
                        curToken = Token::XOR;
                    }
                } else {
                    curToken = Token::VAR;
                }
                break;
            case 'e':
                nextChar();
                if (curChar == 'l') {
                    nextChar();
                    if (curChar == 's') {
                        nextChar();
                        if (curChar == 'e') {
                            nextChar();
                            curToken = Token::ELSE;
                        }
                    }
                } else {
                    curToken = Token::VAR;
                }
                break;
            case ')' :
                nextChar();
                curToken = Token::RPAREN;
                break;
            default:
                if (isalpha(curChar)) {
                    nextChar();
                    curToken = Token::VAR;
                } else {
                    curToken = Token::END;
                }
                break;
        }
    }

private:
    static bool isBlank(int c) {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }

    void nextChar() {
        curPos++;
        try {
            if (is->peek() == EOF) {
                curChar = EOF;
            } else {
                is->get(curChar);
            }
        } catch (int e) {
            std::cout << "error occurred " << e << "\n";
        }
    }
};