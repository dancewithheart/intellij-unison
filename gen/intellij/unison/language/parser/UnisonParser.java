// This is a generated file. Not intended for manual editing.
package intellij.unison.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static intellij.unison.language.psi.UnisonTypes.*;
import static intellij.unison.language.parser.UnisonParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement"})
public class UnisonParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return unisonFile(b, l + 1);
  }

  /* ********************************************************** */
  // 'true' | 'false'
  public static boolean BOOLEAN(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BOOLEAN")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN, "<boolean>");
    r = consumeToken(b, "true");
    if (!r) r = consumeToken(b, "false");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CHAR_TOKEN
  public static boolean CHAR(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CHAR")) return false;
    if (!nextTokenIs(b, CHAR_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CHAR_TOKEN);
    exit_section_(b, m, CHAR, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_TOKEN
  public static boolean DOUBLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOUBLE")) return false;
    if (!nextTokenIs(b, DOUBLE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOUBLE_TOKEN);
    exit_section_(b, m, DOUBLE, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER_TOKEN
  public static boolean IDENTIFIER(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IDENTIFIER")) return false;
    if (!nextTokenIs(b, IDENTIFIER_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER_TOKEN);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // INT_TOKEN
  public static boolean INT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INT")) return false;
    if (!nextTokenIs(b, INT_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INT_TOKEN);
    exit_section_(b, m, INT, r);
    return r;
  }

  /* ********************************************************** */
  // TEXT_TOKEN
  public static boolean TEXT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEXT")) return false;
    if (!nextTokenIs(b, TEXT_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TEXT_TOKEN);
    exit_section_(b, m, TEXT, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ':' type_expr
  public static boolean ability_constructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ability_constructor")) return false;
    if (!nextTokenIs(b, IDENTIFIER_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IDENTIFIER(b, l + 1);
    r = r && consumeToken(b, ":");
    r = r && type_expr(b, l + 1);
    exit_section_(b, m, ABILITY_CONSTRUCTOR, r);
    return r;
  }

  /* ********************************************************** */
  // ( 'unique' | 'structural' )? 'ability' IDENTIFIER type_params? 'where' '{' ability_constructor* '}'
  public static boolean ability_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ability_decl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ABILITY_DECL, "<ability decl>");
    r = ability_decl_0(b, l + 1);
    r = r && consumeToken(b, "ability");
    r = r && IDENTIFIER(b, l + 1);
    r = r && ability_decl_3(b, l + 1);
    r = r && consumeToken(b, "where");
    r = r && consumeToken(b, "{");
    r = r && ability_decl_6(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( 'unique' | 'structural' )?
  private static boolean ability_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ability_decl_0")) return false;
    ability_decl_0_0(b, l + 1);
    return true;
  }

  // 'unique' | 'structural'
  private static boolean ability_decl_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ability_decl_0_0")) return false;
    boolean r;
    r = consumeToken(b, "unique");
    if (!r) r = consumeToken(b, "structural");
    return r;
  }

  // type_params?
  private static boolean ability_decl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ability_decl_3")) return false;
    type_params(b, l + 1);
    return true;
  }

  // ability_constructor*
  private static boolean ability_decl_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ability_decl_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ability_constructor(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ability_decl_6", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // expression (',' expression)*
  public static boolean argument_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_LIST, "<argument list>");
    r = expression(b, l + 1);
    r = r && argument_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' expression)*
  private static boolean argument_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argument_list_1", c)) break;
    }
    return true;
  }

  // ',' expression
  private static boolean argument_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // qualified_name type_expr*
  public static boolean constructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor")) return false;
    if (!nextTokenIs(b, IDENTIFIER_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = qualified_name(b, l + 1);
    r = r && constructor_1(b, l + 1);
    exit_section_(b, m, CONSTRUCTOR, r);
    return r;
  }

  // type_expr*
  private static boolean constructor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "constructor_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER pattern*
  public static boolean constructor_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_pattern")) return false;
    if (!nextTokenIs(b, IDENTIFIER_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IDENTIFIER(b, l + 1);
    r = r && constructor_pattern_1(b, l + 1);
    exit_section_(b, m, CONSTRUCTOR_PATTERN, r);
    return r;
  }

  // pattern*
  private static boolean constructor_pattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_pattern_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!pattern(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "constructor_pattern_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'let' (IDENTIFIER '=' expression)+
  public static boolean definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINITION, "<definition>");
    r = consumeToken(b, "let");
    r = r && definition_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (IDENTIFIER '=' expression)+
  private static boolean definition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definition_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = definition_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!definition_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "definition_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER '=' expression
  private static boolean definition_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definition_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IDENTIFIER(b, l + 1);
    r = r && consumeToken(b, "=");
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // literal
  //              | IDENTIFIER
  //              | qualified_name
  //              | function_call
  //              | lambda
  //              | if_expr
  //              | match_expr
  //              | '(' expression ')'
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = literal(b, l + 1);
    if (!r) r = IDENTIFIER(b, l + 1);
    if (!r) r = qualified_name(b, l + 1);
    if (!r) r = function_call(b, l + 1);
    if (!r) r = lambda(b, l + 1);
    if (!r) r = if_expr(b, l + 1);
    if (!r) r = match_expr(b, l + 1);
    if (!r) r = expression_7(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '(' expression ')'
  private static boolean expression_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER '(' argument_list? ')'
  public static boolean function_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call")) return false;
    if (!nextTokenIs(b, IDENTIFIER_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IDENTIFIER(b, l + 1);
    r = r && consumeToken(b, "(");
    r = r && function_call_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, FUNCTION_CALL, r);
    return r;
  }

  // argument_list?
  private static boolean function_call_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call_2")) return false;
    argument_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'if' expression 'then' expression 'else' expression
  public static boolean if_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IF_EXPR, "<if expr>");
    r = consumeToken(b, "if");
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, "then");
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, "else");
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '\' pattern '->' expression
  public static boolean lambda(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAMBDA, "<lambda>");
    r = consumeToken(b, "\\");
    r = r && pattern(b, l + 1);
    r = r && consumeToken(b, "->");
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // INT | DOUBLE | CHAR | TEXT | BOOLEAN
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = INT(b, l + 1);
    if (!r) r = DOUBLE(b, l + 1);
    if (!r) r = CHAR(b, l + 1);
    if (!r) r = TEXT(b, l + 1);
    if (!r) r = BOOLEAN(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '|' pattern '->' expression
  public static boolean match_case(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_case")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATCH_CASE, "<match case>");
    r = consumeToken(b, "|");
    r = r && pattern(b, l + 1);
    r = r && consumeToken(b, "->");
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'match' expression 'with' match_case+
  public static boolean match_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATCH_EXPR, "<match expr>");
    r = consumeToken(b, "match");
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, "with");
    r = r && match_expr_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // match_case+
  private static boolean match_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expr_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = match_case(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!match_case(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "match_expr_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'namespace' qualified_name
  public static boolean namespace_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_decl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMESPACE_DECL, "<namespace decl>");
    r = consumeToken(b, "namespace");
    r = r && qualified_name(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  //           | '_'
  //           | literal
  //           | constructor_pattern
  //           | '(' pattern ')'
  public static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN, "<pattern>");
    r = IDENTIFIER(b, l + 1);
    if (!r) r = consumeToken(b, "_");
    if (!r) r = literal(b, l + 1);
    if (!r) r = constructor_pattern(b, l + 1);
    if (!r) r = pattern_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '(' pattern ')'
  private static boolean pattern_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && pattern(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ('.' IDENTIFIER)*
  public static boolean qualified_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualified_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IDENTIFIER(b, l + 1);
    r = r && qualified_name_1(b, l + 1);
    exit_section_(b, m, QUALIFIED_NAME, r);
    return r;
  }

  // ('.' IDENTIFIER)*
  private static boolean qualified_name_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualified_name_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!qualified_name_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "qualified_name_1", c)) break;
    }
    return true;
  }

  // '.' IDENTIFIER
  private static boolean qualified_name_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualified_name_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ".");
    r = r && IDENTIFIER(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // namespace_decl
  //             | use_import
  //             | topLevelDefinition
  //             | ability_decl
  //             | type_decl
  //             | definition
  //             | expression
  //             | comment
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = namespace_decl(b, l + 1);
    if (!r) r = use_import(b, l + 1);
    if (!r) r = topLevelDefinition(b, l + 1);
    if (!r) r = ability_decl(b, l + 1);
    if (!r) r = type_decl(b, l + 1);
    if (!r) r = definition(b, l + 1);
    if (!r) r = expression(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER '=' expression
  public static boolean topLevelDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelDefinition")) return false;
    if (!nextTokenIs(b, IDENTIFIER_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IDENTIFIER(b, l + 1);
    r = r && consumeToken(b, "=");
    r = r && expression(b, l + 1);
    exit_section_(b, m, TOP_LEVEL_DEFINITION, r);
    return r;
  }

  /* ********************************************************** */
  // ( 'unique' | 'structural' )? 'type' IDENTIFIER type_params? '=' constructor ( '|' constructor )*
  public static boolean type_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DECL, "<type decl>");
    r = type_decl_0(b, l + 1);
    r = r && consumeToken(b, "type");
    r = r && IDENTIFIER(b, l + 1);
    r = r && type_decl_3(b, l + 1);
    r = r && consumeToken(b, "=");
    r = r && constructor(b, l + 1);
    r = r && type_decl_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( 'unique' | 'structural' )?
  private static boolean type_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_0")) return false;
    type_decl_0_0(b, l + 1);
    return true;
  }

  // 'unique' | 'structural'
  private static boolean type_decl_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_0_0")) return false;
    boolean r;
    r = consumeToken(b, "unique");
    if (!r) r = consumeToken(b, "structural");
    return r;
  }

  // type_params?
  private static boolean type_decl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_3")) return false;
    type_params(b, l + 1);
    return true;
  }

  // ( '|' constructor )*
  private static boolean type_decl_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_decl_6_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_decl_6", c)) break;
    }
    return true;
  }

  // '|' constructor
  private static boolean type_decl_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "|");
    r = r && constructor(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER | '(' type_expr ')' | type_expr '->' type_expr
  public static boolean type_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_EXPR, "<type expr>");
    r = IDENTIFIER(b, l + 1);
    if (!r) r = type_expr_1(b, l + 1);
    if (!r) r = type_expr_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '(' type_expr ')'
  private static boolean type_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && type_expr(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // type_expr '->' type_expr
  private static boolean type_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_expr(b, l + 1);
    r = r && consumeToken(b, "->");
    r = r && type_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' IDENTIFIER (',' IDENTIFIER)* '}'
  public static boolean type_params(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_params")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_PARAMS, "<type params>");
    r = consumeToken(b, "{");
    r = r && IDENTIFIER(b, l + 1);
    r = r && type_params_2(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' IDENTIFIER)*
  private static boolean type_params_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_params_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_params_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_params_2", c)) break;
    }
    return true;
  }

  // ',' IDENTIFIER
  private static boolean type_params_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_params_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && IDENTIFIER(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // statement*
  static boolean unisonFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unisonFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unisonFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'use' qualified_name ('.' '*')?
  public static boolean use_import(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_import")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, USE_IMPORT, "<use import>");
    r = consumeToken(b, "use");
    r = r && qualified_name(b, l + 1);
    r = r && use_import_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('.' '*')?
  private static boolean use_import_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_import_2")) return false;
    use_import_2_0(b, l + 1);
    return true;
  }

  // '.' '*'
  private static boolean use_import_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_import_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ".");
    r = r && consumeToken(b, "*");
    exit_section_(b, m, null, r);
    return r;
  }

}
