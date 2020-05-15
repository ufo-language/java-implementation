grammar UFO;

@lexer::header {
package main.java.parser;
import main.java.data.D_String;
}

@parser::header {
package main.java.parser;
}

@lexer::members {
  void normalizeQuotedString() {
    String text = getText();
    String withoutQuotes = text.substring(1, text.length() - 1);
    String unescaped = D_String.unescapify(withoutQuotes);
    setText(unescaped);
  }
}

/* parser */

prog
    : any+ EOF
    ;

any
    : op=prefixOps any   # prefixRule
    | any '[' any ']'    # subscriptRule
    | any level5ops any  # infixOpRule
    | any parenList      # applicationRule
    | any level4ops any  # infixOpRule
    | any level3ops any  # infixOpRule
    | any level2ops any  # infixOpRule
    | any bindingOp any  # bindingOpRule
    | any level1ops any  # infixOpRule
    | expr               # exprRule
    | collection         # collectionRule
    | atom               # atomRule
    ;

prefixOps : '-' | '+' | 'not';

level5ops : '.' | ':' ; 
level4ops : '^' | '..' ;
level3ops : '*' | '/' | '//' | '%' ;
level2ops : '+' | '-' | '::' | ':>' | ':?' | '++' | '+++' ;
bindingOp : '=' ;
level1ops : ':=' | '=~' | '==' | '!=' | '<' | '>' | '<=' | '>=' | '##'
          | 'in' | 'is' | 'isnot' | 'and' | 'or' | 'xor' ;

parenList
     : '(' ')'
     | '(' any (',' any)* ')'
     ;

// Expressions ======================================================

exprSeq : any* ;
bindingSeq : cBinding (',' cBinding)* ;
commaSepExprs : any (',' any)* ;

expr
    : eAsync
    | eCobegin
    | eFun
    | eIf
    | eLet
    | eLoop
    | eNondet
    | eQuote
    | eSeq
    | eWhile
    ;

eAsync     : 'async' exprSeq 'end' ;

eBackQuote : '`' any '`' ;

eCobegin   : 'cobegin' exprSeq 'end' ;

eFun       : op=('fun' | 'fun#') aIdent? eFunRules 'end' ;
eFunRules  : parenList '=' exprSeq ('|' eFunRules) *;

eIf        : 'if' any 'then' exprSeq ('else' exprSeq)? 'end' ;

eLet       : 'let' bindingSeq ('in' exprSeq 'end')? ;

eLoop      : 'loop' any 'do' exprSeq 'end' ;

eNondet    : 'nondet' exprSeq 'end' ;

eQuote     : '\'' any '\'' ;

eSeq       : 'do' exprSeq 'end' ;

eWhile     : 'while' any 'do' exprSeq 'end' ;

// Collections ======================================================

collection
    : cArray
    | cHash
    | cList
    | cQueue
    | cSet
    | cStack
    | cTerm
    ;

cArray : '{' commaSepExprs? '}' ;

cBinding : cBindingLhs '=' any ;
cBindingLhs
    : atom
    | collection
    | eQuote
    | '(' any ')'
    ;

cHash  : '#{' bindingSeq? '}' ;

cList  : '[' commaSepExprs? ']'
       | '[' any '|' any ']'
       ;

cQueue : '~[' commaSepExprs? ']' ;

cSet   : '${' commaSepExprs? '}' ;

cStack : '$[' commaSepExprs? ']' ;

cTerm  : aSymbol cArray cTermAttrib? ;
cTermAttrib
    : visOp='%' any
    | visOp='/' any
    ;

// Atoms ============================================================

atom
    : aBoolean
    | aIdent
    | aInteger
    | aNil
    | aReal
    | aString
    | aSymbol
    | '(' any ')'
    ;

aBoolean : 'true' | 'false' ;

aIdent   : IDENT | level1ops | bindingOp | level2ops | level3ops | level4ops | level5ops ;

aInteger : INTEGER ;

aNil     : 'nil' ;

aReal    : FLOAT ;

aString  : STRING ;

aSymbol  : SYMBOL ;

// Lexer ============================================================

/* lexer rules are analyzed in the order that they appear,
   and they are allowed to be ambiguous.
*/

WS
    : ([ \t\n\r] | COMMENT) -> skip
    ;

NEWLINE
    : ('\r'? '\n' | '\r')+
    ;

INTEGER
    : DIGIT (DIGIT | '_')*
    ;

FLOAT
    : DIGIT (DIGIT | '_')* '.' (DIGIT | '_')+
    ;

SYMBOL
    : UCASE (LCASE | UCASE | DIGIT | '_')*
    ;

IDENT
    : (LCASE | '_') (LCASE | UCASE | DIGIT | '_')* [?!]?
    ;

STRING
    : '"' STR_CHAR* '"' { normalizeQuotedString(); }
    ;

/* reusable fragments */

fragment COMMENT
    : ';-' .*? '-;'
    | ';' ~[-] ~[\r\n]*
	;

fragment DIGIT : [0-9] ;
fragment UCASE : [A-Z] ;
fragment LCASE : [a-z] ;

fragment STR_CHAR
    : ~['\\\r\n"]
    | ESCAPED_CHAR
    ;

fragment ESCAPED_CHAR
    : '\\' .
    ;