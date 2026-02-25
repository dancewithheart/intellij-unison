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


WHITE_SPACE = [\ \t\r\n]+

LINE_COMMENT="--"[^\r\n]*
MULTILINE_COMMENT = "{-" [^-]+ ~"-}" | "{-" "-"+ "-}"
COMMENT = {LINE_COMMENT} | {MULTILINE_COMMENT}

// https://www.unison-lang.org/docs/language-reference/identifiers/
WORD_IDENT = [a-zA-Z_][a-zA-Z0-9_]*
OP_IDENT   = [!$%\^&*\-+<>~\\/|:]+

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
COMPARE_OPERATOR = "<" | ">" | "<=" | ">=" | "!=" | "===" | "Nat.==" | "Nat.!=" | "Nat.<" | "Nat.>" | "Nat.<=" | "Nat.>="

%%

{WHITE_SPACE}            { return com.intellij.psi.TokenType.WHITE_SPACE; }

// Unison reserved words: https://www.unison-lang.org/docs/language-reference/identifiers/#reserved-words

// Ensure order
// 1 exact keywords / symbols
"namespace"              { return NAMESPACE; }
"use"                    { return USE; }
"alias"                  { return ALIAS; }
"handle"                 { return HANDLE; }
"catch"                  { return CATCH; }
"ability"                { return ABILITY; }
"where"                  { return WHERE; }
"type"                   { return TYPE; }
"structural"             { return STRUCTURAL; }
"unique"                 { return UNIQUE; }
"forall"                 { return FORALL; }
"let"                    { return LET; }
"do"                     { return DO; }
"'"                      { return TICK; }
"'{"                     { return LBRACETICK; }
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
"\\"                     { return BACKSLASH; }
"otherwise"              { return OTHERWISE; }
"typeLink"               { return TYPELINK; }
"termLink"               { return TERMLINK; }
"Nat"                    { return KW_NAT; }
"Int"                    { return KW_INT; }
"Char"                   { return KW_CHAR; }
"Text"                   { return KW_TEXT; }
"Float"                  { return KW_FLOAT; }
"Double"                 { return KW_DOUBLE; }
"Boolean"                { return KW_BOOLEAN; }
"Bytes"                  { return KW_BYTES; }
"()"                     { return KW_UNIT; }
"_"                      { return UNDERSCORE; }
"∀"                      { return FORALLSYMBOL; }

// 2 specific operator tokens
{BOOLEAN}                { return BOOLEAN_TOKEN; }
{CHAR}                   { return CHAR_TOKEN; }
{BYTES}                  { return BYTES_TOKEN; }
{INT}                    { return INT_TOKEN; }
{DOUBLE}                 { return DOUBLE_TOKEN; }
{STRING}                 { return STRING_TOKEN; }

{LINE_COMMENT}           { return LINE_COMMENT_TOKEN; }
{MULTILINE_COMMENT}      { return MULTILINE_COMMENT_TOKEN; }

{NUM_OPERATOR}           { return NUM_OPERATOR_TOKEN; }
{BOOL_OPERATOR}          { return BOOL_OPERATOR_TOKEN; }
{COMPARE_OPERATOR}       { return COMPARE_OPERATOR_TOKEN; }

// 3 word identifiers
{WORD_IDENT}             { return IDENTIFIER_TOKEN; }

// 4. operator identifiers
{OP_IDENT}               { return OPERATOR_ID_TOKEN; }

.                        { return com.intellij.psi.TokenType.BAD_CHARACTER; }
