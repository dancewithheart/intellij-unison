// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
/* Unison lexer specification */
/* ===================== User Code =================== */
package intellij.unison;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

import intellij.unison.language.psi.UnisonTypes;

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
COMMENT = "--"[^\n]*
END_OF_LINE_COMMENT="--"[^\r\n]*
TRADITIONAL_COMMENT = "{-" [^-]+ ~"-}" | "{-" "-"+ "-}"

IDENTIFIER = [a-zA-Z_][a-zA-Z0-9_]*
NUMBER = [0-9]+(\.[0-9]+)?
STRING = \"([^\"\\]|\\.)*\"
BOOLEAN = "true" | "false"

%%

{WHITE_SPACE}            { return com.intellij.psi.TokenType.WHITE_SPACE; }
{COMMENT}                { return COMMENT; }

"namespace"              { return NAMESPACE; }
"use"                    { return USE; }
"ability"                { return ABILITY; }
"type"                   { return TYPE; }
"let"                    { return LET; }
"if"                     { return IF; }
"then"                   { return THEN; }
"else"                   { return ELSE; }
"match"                  { return MATCH; }
"with"                   { return WITH; }
"->"                     { return ARROW; }
"="                      { return EQ; }
","                      { return COMMA; }
"|"                      { return BAR; }
"("                      { return LPAREN; }
")"                      { return RPAREN; }
"{"                      { return LBRACE; }
"}"                      { return RBRACE; }
"."                      { return DOT; }
"*"                      { return STAR; }
"\\"                     { return LAMBDA; }
"_"                      { return UNDERSCORE; }

{BOOLEAN}                { return BOOLEAN; }
{NUMBER}                 { return NUMBER; }
{STRING}                 { return STRING; }
{IDENTIFIER}             { return IDENTIFIER_TOKEN; }

.                        { return com.intellij.psi.TokenType.BAD_CHARACTER; }
