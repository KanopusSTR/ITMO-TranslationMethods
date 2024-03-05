grammar Expr;
prog  : (hline NEWLINE)* ;
hline :
	  | while
	  | if
	  | print
	  | vard
      | expr
      ;
eline :
	  | print
	  | vard
      | expr
      ;
inner : (TAB eline NEWLINE)* (TAB eline) ;
cond  : expr COMP expr ;
while : WHILE cond COLON NEWLINE inner ;
if    : IF cond COLON NEWLINE inner ;
vard  : VAR EQUAL expr;
expr: expr OPER expr
      | VAR
      | INT
      | STR
      | SINPUT
      | IINPUT
      ;
print: PRINT LP expr RP ;

NEWLINE     : [\r\n]+ ;
EQUAL		: '=' ;
COMP		: '==' | '>' | '<' ;
OPER		: ('*'|'/'|'+'|'-') ;
LB			: '[' ;
RB			: ']' ;
COMA		: ',' ;
PRINT		: 'print' ;
WHILE		: 'while' ;
COLON		: ':' ;
IF			: 'if' ;
SINPUT      : 'input()' ;
IINPUT      : 'int(input())' ;
LP	    	: '(' ;
RP			: ')' ;
TAB			: '\t' ;
INT         : [0-9]+ ;
VAR         : [a-z]+  ;
STR         : '"' .*? '"' ;
WS          : [ \r\n]+ -> skip ;
