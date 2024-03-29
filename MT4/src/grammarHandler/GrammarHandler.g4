grammar GrammarHandler;
prog 		: (srules | nonterminal | terminal | myImport)* ;
srules      : TNAME ':' REG ' -> skip'                      ;
nonterminal : NTNAME INHERITED SYNTHESIZED ':' rules        ;
terminal    : TNAME ':' REG                                 ;
rules       : rule (OR rule)*                               ;
rule 		: part_rule+		  						    ;
part_rule	: (NTNAME INHERITED) | TNAME | CODE             ;
myImport    : IMPORT                                        ;
OR          : '|'               ;
NTNAME 		: [a-z]+ 			;
TNAME 		: [A-Z]+ 			;
REG         : '"' .*? '"'       ;
CODE        : '{' .*? '}'       ;
INHERITED 	: '(' .*? ')' 		;
SYNTHESIZED : '[' .*? ']' 		;
IMPORT      : '<' .*? '>'       ;
WS 			: [ \t\n]+ -> skip 	;
