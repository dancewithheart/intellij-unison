/* Unison lexer specification */
/* ===================== User Code =================== */
package intellij.unison;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static intellij.unison.language.psi.UnisonTypes.*;

%%
/* ===================== Options and declarations =================== */

%public
%class UnisonLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%ignorecase


NEWLINE = (\n | \r\n)+
WHITE_SPACE = [\ \t]+

END_OF_LINE_COMMENT="--"[^\r\n]*
TRADITIONAL_COMMENT = "{-" [^-]+ ~"-}" | "{-" "-"+ "-}"
COMMENT = {END_OF_LINE_COMMENT} | {TRADITIONAL_COMMENT}

OPERATOR = [!$%\^&*\-=+<>~\\/|:]*
IDNAME = [a-zA-Z_][a-zA-Z0-9_]*
IDENTIFIER = {OPERATOR} | {IDNAME}
HEXDIGIT = [a-z0-9]
INT = ("+" | "-")?[0-9]+
// FLOAT = [0-9]+(\.[0-9]+)?
DOUBLE = ("+" | "-")?[0-9]+\.[0-9]+
BYTES = "0xs" {HEXDIGIT}+
CHAR = \?.
STRING_SINGLELINE = \" ([^\"\r\n] | \\\")* \"
STRING_MULTILINE = \"\"\" [^\"]+ ~\"\"\"
STRING = {STRING_SINGLELINE} | {STRING_MULTILINE}
BOOLEAN = "true" | "false"
NUM_OPERATOR = "+" | "-" | "*" | "/" | "%" | "Nat.+" | "Nat.-" | "Nat.*" | "Nat./" | "Nat.%"
BOOL_OPERATOR = "&&" | "||"
COMPARE_OPERATOR = "<" | ">" | "<=" | ">=" | "!=" | "===" | "Nat.!=" | "Nat.<" | "Nat.>" | "Nat.<=" | "Nat.>="

%%

{WHITE_SPACE}            { return com.intellij.psi.TokenType.WHITE_SPACE; }
{NEWLINE}                { return NEWLINE; }
{COMMENT}                { return COMMENT; }

"namespace"              { return NAMESPACE; }
"use"                    { return USE; }
"alias"                  { return ALIAS; }
"handle"                 { return HANDLE; }

"ability"                { return ABILITY; }
"where"                  { return WHERE; }
"type"                   { return TYPE; }
"structural"             { return STRUCTURAL; }
"unique"                 { return UNIQUE; }

"forall"                 { return FORALL; }
"let"                    { return LET; }
"do"                     { return DO; }
"'"                      { return CIAPEK; }
"'{"                     { return LBRACECIAPEK; }
"!"                      { return BANG; }

"if"                     { return IF; }
"then"                   { return THEN; }
"else"                   { return ELSE; }

"match"                  { return MATCH; }
"with"                   { return WITH; }
"cases"                  { return CASES; }
"where"                  { return WHERE; }

"@"                      { return AT; }
"->"                     { return ARROW; }
":"                      { return COLON; }
"="                      { return EQ; }
"<"                      { return LT; }
">"                      { return GT; }
">="                     { return GE; }
"<="                     { return LE; }
"!="                     { return NE; }
"==="                    { return EQ3; }
"+"                      { return PLUS; }
"-"                      { return MINUS; }
"*"                      { return STAR; }
"/"                      { return DIV; }
"%"                      { return MODS; }
"&&"                     { return AND; }
"||"                     { return OR; }
"not"                    { return NOT; }
"mod"                    { return MODW; }
"|"                      { return BAR; }
","                      { return COMMA; }
"("                      { return LPAREN; }
")"                      { return RPAREN; }
"["                      { return LPARENSQ; }
"]"                      { return RPARENSQ; }
"{"                      { return LBRACE; }
"}"                      { return RBRACE; }
"."                      { return DOT; }
"\\"                     { return LAMBDA; }
"_"                      { return UNDERSCORE; }
"otherwise"              { return OTHERWISE; }
"typeLink"               { return TYPELINK; }
"termLink"               { return TERMLINK; }
"Nat"                    { return NAT; }
"Int"                    { return INT; }
"Char"                   { return CHAR; }
"Text"                   { return TEXT; }
"Float"                  { return FLOAT; }
"Double"                 { return DOUBLE; }
"Boolean"                { return BOOLEAN; }
"Bytes"                  { return BYTES; }
"()"                     { return EMPTYBRACES; }
"∀"                      { return FORALLSYMBOL; }

{NEWLINE}                { return NEWLINE_TOKEN; }
{BOOLEAN}                { return BOOLEAN_TOKEN; }
{CHAR}                   { return CHAR_TOKEN; }
{BYTES}                  { return BYTES_TOKEN; }
{INT}                    { return INT_TOKEN; }
//{NAT}                    { return NAT_TOKEN; }
//{FLOAT}                  { return FLOAT_TOKEN; }
{DOUBLE}                 { return DOUBLE_TOKEN; }
{STRING}                 { return STRING_TOKEN; }
{IDENTIFIER}             { return IDENTIFIER_TOKEN; }
{NUM_OPERATOR}           { return NUM_OPERATOR_TOKEN; }
{BOOL_OPERATOR}          { return BOOL_OPERATOR_TOKEN; }
{COMPARE_OPERATOR}       { return COMPARE_OPERATOR_TOKEN; }

.                        { return com.intellij.psi.TokenType.BAD_CHARACTER; }
