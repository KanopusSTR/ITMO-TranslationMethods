enum Token {
    LPAREN,
    RPAREN,
    END,
    AND,
    OR,
    XOR,
    IN,
    NOT,
    NOTIN,
    VAR,
    IF,
    ELSE
};

inline std::string ToString(Token t) {
    switch (t) {
        case LPAREN:
            return "(";
        case RPAREN:
            return ")";
        case END:
            return "$";
        case AND:
            return "and";
        case OR:
            return "or";
        case XOR:
            return "xor";
        case IN:
            return "in";
        case NOT:
            return "not";
        case NOTIN:
            return "not in";
        case VAR:
            return "variable";
        case IF:
            return "if";
        case ELSE:
            return "else";
        default:
            return "unknown";
    }
}