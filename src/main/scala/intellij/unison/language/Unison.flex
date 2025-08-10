// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
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


WHITE_SPACE = [\ \t\r\n]+

END_OF_LINE_COMMENT="--"[^\r\n]*
TRADITIONAL_COMMENT = "{-" [^-]+ ~"-}" | "{-" "-"+ "-}"
COMMENT = {END_OF_LINE_COMMENT} | {TRADITIONAL_COMMENT}

OPERATOR = [!$%\^&*\-=+<>~\\/|:]*
IDNAME = [a-zA-Z_][a-zA-Z0-9_]*
IDENTIFIER = {OPERATOR} | {IDNAME}
// NAT = [1-9]([0-9]+)?
INT = ("+" | "-")?[0-9]+
// FLOAT = [0-9]+(\.[0-9]+)?
DOUBLE = [0-9]+(\.[0-9]+)?
CHAR = \?.
STRING_SINGLELINE = \" [^\r\n]* \"
STRING_MULTILINE = \"\"\" [^\"]+ ~\"\"\"
STRING = {STRING_SINGLELINE} | {STRING_MULTILINE}
BOOLEAN = "true" | "false"
NUM_OPERATOR = "+" | "-" | "*" | "/" | "%"
BOOL_OPERATOR = "&&" | "||"

%%

{WHITE_SPACE}            { return com.intellij.psi.TokenType.WHITE_SPACE; }
{COMMENT}                { return COMMENT; }

"namespace"              { return NAMESPACE; }
"use"                    { return USE; }

"ability"                { return ABILITY; }
"where"                  { return WHERE; }
"type"                   { return TYPE; }
"structural"             { return STRUCTURAL; }
"unique"                 { return UNIQUE; }

"let"                    { return LET; }
"do"                     { return DO; }
"'"                      { return CIAPEK; }
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
"<"                      { return GT; }
">"                      { return LT; }
"==="                    { return EQ3; }
"+"                      { return PLUS; }
"-"                      { return MINUS; }
"*"                      { return STAR; }
"/"                      { return DIV; }
"%"                      { return MOD; }
"&&"                     { return AND; }
"||"                     { return OR; }
"not"                    { return NOT; }
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

{BOOLEAN}                { return BOOLEAN_TOKEN; }
{CHAR}                   { return CHAR_TOKEN; }
// {BYTES}                  { return BYTES_TOKEN; }
{INT}                    { return INT_TOKEN; }
//{NAT}                    { return NAT_TOKEN; }
//{FLOAT}                  { return FLOAT_TOKEN; }
{DOUBLE}                 { return DOUBLE_TOKEN; }
{STRING}                 { return STRING_TOKEN; }
{IDENTIFIER}             { return IDENTIFIER_TOKEN; }

.                        { return com.intellij.psi.TokenType.BAD_CHARACTER; }
