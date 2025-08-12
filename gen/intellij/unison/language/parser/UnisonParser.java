// This is a generated file. Not intended for manual editing.
package intellij.unison.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static intellij.unison.language.psi.UnisonTypes.*;
import static intellij.unison.language.parser.UnisonParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
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
  // BOOL_OPERATOR_TOKEN
  public static boolean BOOL_OPERATOR(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BOOL_OPERATOR")) return false;
    if (!nextTokenIs(b, BOOL_OPERATOR_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BOOL_OPERATOR_TOKEN);
    exit_section_(b, m, BOOL_OPERATOR, r);
    return r;
  }

  /* ********************************************************** */
  // BYTES_TOKEN
  public static boolean BYTES(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BYTES")) return false;
    if (!nextTokenIs(b, BYTES_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BYTES_TOKEN);
    exit_section_(b, m, BYTES, r);
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
  // COMPARE_OPERATOR_TOKEN
  public static boolean COMPARE_OPERATOR(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "COMPARE_OPERATOR")) return false;
    if (!nextTokenIs(b, COMPARE_OPERATOR_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMPARE_OPERATOR_TOKEN);
    exit_section_(b, m, COMPARE_OPERATOR, r);
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
  // NUM_OPERATOR_TOKEN
  public static boolean NUM_OPERATOR(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NUM_OPERATOR")) return false;
    if (!nextTokenIs(b, NUM_OPERATOR_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUM_OPERATOR_TOKEN);
    exit_section_(b, m, NUM_OPERATOR, r);
    return r;
  }

  /* ********************************************************** */
  // STRING_TOKEN
  public static boolean STRING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "STRING")) return false;
    if (!nextTokenIs(b, STRING_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_TOKEN);
    exit_section_(b, m, STRING, r);
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
  // qualified_name IDENTIFIER* '=' expression
  //   | (IDENTIFIER '=' expression)+
  //   | '(' literal (',' literal)* ')' '=' '(' expression (',' expression)* ')'
  public static boolean binding(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINDING, "<binding>");
    r = binding_0(b, l + 1);
    if (!r) r = binding_1(b, l + 1);
    if (!r) r = binding_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // qualified_name IDENTIFIER* '=' expression
  private static boolean binding_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = qualified_name(b, l + 1);
    r = r && binding_0_1(b, l + 1);
    r = r && consumeToken(b, "=");
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER*
  private static boolean binding_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!IDENTIFIER(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "binding_0_1", c)) break;
    }
    return true;
  }

  // (IDENTIFIER '=' expression)+
  private static boolean binding_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binding_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!binding_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "binding_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER '=' expression
  private static boolean binding_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IDENTIFIER(b, l + 1);
    r = r && consumeToken(b, "=");
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' literal (',' literal)* ')' '=' '(' expression (',' expression)* ')'
  private static boolean binding_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && literal(b, l + 1);
    r = r && binding_2_2(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, "=");
    r = r && consumeToken(b, "(");
    r = r && expression(b, l + 1);
    r = r && binding_2_7(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' literal)*
  private static boolean binding_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_2_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!binding_2_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "binding_2_2", c)) break;
    }
    return true;
  }

  // ',' literal
  private static boolean binding_2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_2_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' expression)*
  private static boolean binding_2_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_2_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!binding_2_7_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "binding_2_7", c)) break;
    }
    return true;
  }

  // ',' expression
  private static boolean binding_2_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_2_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BOOLEAN BOOL_OPERATOR bool_expr
  //    | num_expr COMPARE_OPERATOR num_expr
  //    | 'not' bool_expr
  //    | num_expr '===' num_expr
  //    | bool_expr (BOOL_OPERATOR bool_expr)+
  //    | '(' bool_expr ')' (BOOL_OPERATOR bool_expr)+
  //    | BOOLEAN
  //    | IDENTIFIER
  public static boolean bool_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_EXPR, "<bool expr>");
    r = bool_expr_0(b, l + 1);
    if (!r) r = bool_expr_1(b, l + 1);
    if (!r) r = bool_expr_2(b, l + 1);
    if (!r) r = bool_expr_3(b, l + 1);
    if (!r) r = bool_expr_4(b, l + 1);
    if (!r) r = bool_expr_5(b, l + 1);
    if (!r) r = BOOLEAN(b, l + 1);
    if (!r) r = IDENTIFIER(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BOOLEAN BOOL_OPERATOR bool_expr
  private static boolean bool_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BOOLEAN(b, l + 1);
    r = r && BOOL_OPERATOR(b, l + 1);
    r = r && bool_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // num_expr COMPARE_OPERATOR num_expr
  private static boolean bool_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = num_expr(b, l + 1);
    r = r && COMPARE_OPERATOR(b, l + 1);
    r = r && num_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'not' bool_expr
  private static boolean bool_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_expr_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "not");
    r = r && bool_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // num_expr '===' num_expr
  private static boolean bool_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_expr_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = num_expr(b, l + 1);
    r = r && consumeToken(b, "===");
    r = r && num_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // bool_expr (BOOL_OPERATOR bool_expr)+
  private static boolean bool_expr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_expr_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bool_expr(b, l + 1);
    r = r && bool_expr_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (BOOL_OPERATOR bool_expr)+
  private static boolean bool_expr_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_expr_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bool_expr_4_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!bool_expr_4_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bool_expr_4_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // BOOL_OPERATOR bool_expr
  private static boolean bool_expr_4_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_expr_4_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BOOL_OPERATOR(b, l + 1);
    r = r && bool_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' bool_expr ')' (BOOL_OPERATOR bool_expr)+
  private static boolean bool_expr_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_expr_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && bool_expr(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && bool_expr_5_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (BOOL_OPERATOR bool_expr)+
  private static boolean bool_expr_5_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_expr_5_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bool_expr_5_3_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!bool_expr_5_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bool_expr_5_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // BOOL_OPERATOR bool_expr
  private static boolean bool_expr_5_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_expr_5_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BOOL_OPERATOR(b, l + 1);
    r = r && bool_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'Nat'
  //   | 'Int'
  //   | 'Char'
  //   | 'Text'
  //   | 'Float'
  //   | 'Double'
  //   | 'Boolean'
  //   | 'Bytes'
  //   | '()'
  public static boolean builtin_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtin_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILTIN_TYPE, "<builtin type>");
    r = consumeToken(b, "Nat");
    if (!r) r = consumeToken(b, "Int");
    if (!r) r = consumeToken(b, "Char");
    if (!r) r = consumeToken(b, "Text");
    if (!r) r = consumeToken(b, "Float");
    if (!r) r = consumeToken(b, "Double");
    if (!r) r = consumeToken(b, "Boolean");
    if (!r) r = consumeToken(b, "Bytes");
    if (!r) r = consumeToken(b, "()");
    exit_section_(b, l, m, r, false, null);
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
  // 'let' (binding)+
  public static boolean definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINITION, "<definition>");
    r = consumeToken(b, "let");
    r = r && definition_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (binding)+
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

  // (binding)
  private static boolean definition_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definition_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binding(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // lambda
  //              | num_expr
  //              | bool_expr
  //              | if_expr
  //              | match_expr
  //              | function_call
  //              | literal
  //              | qualified_name
  //              | qualified_import
  //              | '(' expression ')'
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = lambda(b, l + 1);
    if (!r) r = num_expr(b, l + 1);
    if (!r) r = bool_expr(b, l + 1);
    if (!r) r = if_expr(b, l + 1);
    if (!r) r = match_expr(b, l + 1);
    if (!r) r = function_call(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = qualified_name(b, l + 1);
    if (!r) r = qualified_import(b, l + 1);
    if (!r) r = expression_9(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '(' expression ')'
  private static boolean expression_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('do' expression) | statement+
  public static boolean functionBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionBody")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_BODY, "<function body>");
    r = functionBody_0(b, l + 1);
    if (!r) r = functionBody_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'do' expression
  private static boolean functionBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionBody_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "do");
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // statement+
  private static boolean functionBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionBody_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionBody_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // qualified_name '(' argument_list? ')'
  public static boolean function_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call")) return false;
    if (!nextTokenIs(b, IDENTIFIER_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = qualified_name(b, l + 1);
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
  // '|' bool_expr
  public static boolean guard(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "guard")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GUARD, "<guard>");
    r = consumeToken(b, "|");
    r = r && bool_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'if' bool_expr 'then' expression 'else' expression
  public static boolean if_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IF_EXPR, "<if expr>");
    r = consumeToken(b, "if");
    r = r && bool_expr(b, l + 1);
    r = r && consumeToken(b, "then");
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, "else");
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '\' pattern+ '->' expression
  public static boolean lambda(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAMBDA, "<lambda>");
    r = consumeToken(b, "\\");
    r = r && lambda_1(b, l + 1);
    r = r && consumeToken(b, "->");
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // pattern+
  private static boolean lambda_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!pattern(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lambda_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INT
  //   | DOUBLE | CHAR | STRING | BOOLEAN | BYTES
  //   | '[' ']' | '[' literal (',' literal)* ']'
  //   | '(' literal (',' literal)* ')'
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = INT(b, l + 1);
    if (!r) r = DOUBLE(b, l + 1);
    if (!r) r = CHAR(b, l + 1);
    if (!r) r = STRING(b, l + 1);
    if (!r) r = BOOLEAN(b, l + 1);
    if (!r) r = BYTES(b, l + 1);
    if (!r) r = literal_6(b, l + 1);
    if (!r) r = literal_7(b, l + 1);
    if (!r) r = literal_8(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '[' ']'
  private static boolean literal_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[");
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' literal (',' literal)* ']'
  private static boolean literal_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[");
    r = r && literal(b, l + 1);
    r = r && literal_7_2(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' literal)*
  private static boolean literal_7_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_7_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!literal_7_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "literal_7_2", c)) break;
    }
    return true;
  }

  // ',' literal
  private static boolean literal_7_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_7_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' literal (',' literal)* ')'
  private static boolean literal_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && literal(b, l + 1);
    r = r && literal_8_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' literal)*
  private static boolean literal_8_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_8_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!literal_8_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "literal_8_2", c)) break;
    }
    return true;
  }

  // ',' literal
  private static boolean literal_8_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_8_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (pattern guard?)+ '->' expression
  public static boolean match_case(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_case")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATCH_CASE, "<match case>");
    r = match_case_0(b, l + 1);
    r = r && consumeToken(b, "->");
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (pattern guard?)+
  private static boolean match_case_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_case_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = match_case_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!match_case_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "match_case_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // pattern guard?
  private static boolean match_case_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_case_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern(b, l + 1);
    r = r && match_case_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // guard?
  private static boolean match_case_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_case_0_0_1")) return false;
    guard(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'match' expression+ 'with' match_case+
  public static boolean match_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATCH_EXPR, "<match expr>");
    r = consumeToken(b, "match");
    r = r && match_expr_1(b, l + 1);
    r = r && consumeToken(b, "with");
    r = r && match_expr_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expression+
  private static boolean match_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "match_expr_1", c)) break;
    }
    exit_section_(b, m, null, r);
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
  // INT | DOUBLE
  public static boolean numLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numLiteral")) return false;
    if (!nextTokenIs(b, "<num literal>", DOUBLE_TOKEN, INT_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUM_LITERAL, "<num literal>");
    r = INT(b, l + 1);
    if (!r) r = DOUBLE(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // numLiteral NUM_OPERATOR numLiteral
  //    | numLiteral NUM_OPERATOR num_expr
  //    | IDENTIFIER NUM_OPERATOR num_expr
  //    | '-' num_expr
  //    | 'mod' num_expr num_expr
  //    | numLiteral
  //    | IDENTIFIER
  //    | '(' num_expr ')'
  public static boolean num_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUM_EXPR, "<num expr>");
    r = num_expr_0(b, l + 1);
    if (!r) r = num_expr_1(b, l + 1);
    if (!r) r = num_expr_2(b, l + 1);
    if (!r) r = num_expr_3(b, l + 1);
    if (!r) r = num_expr_4(b, l + 1);
    if (!r) r = numLiteral(b, l + 1);
    if (!r) r = IDENTIFIER(b, l + 1);
    if (!r) r = num_expr_7(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // numLiteral NUM_OPERATOR numLiteral
  private static boolean num_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = numLiteral(b, l + 1);
    r = r && NUM_OPERATOR(b, l + 1);
    r = r && numLiteral(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // numLiteral NUM_OPERATOR num_expr
  private static boolean num_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = numLiteral(b, l + 1);
    r = r && NUM_OPERATOR(b, l + 1);
    r = r && num_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER NUM_OPERATOR num_expr
  private static boolean num_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_expr_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IDENTIFIER(b, l + 1);
    r = r && NUM_OPERATOR(b, l + 1);
    r = r && num_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '-' num_expr
  private static boolean num_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_expr_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "-");
    r = r && num_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'mod' num_expr num_expr
  private static boolean num_expr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_expr_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "mod");
    r = r && num_expr(b, l + 1);
    r = r && num_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' num_expr ')'
  private static boolean num_expr_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_expr_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && num_expr(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER '@' pattern
  //           | IDENTIFIER
  //           | '_'
  //           | literal
  //           | constructor_pattern
  //           | '(' literal (',' literal)* ')'
  public static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN, "<pattern>");
    r = pattern_0(b, l + 1);
    if (!r) r = IDENTIFIER(b, l + 1);
    if (!r) r = consumeToken(b, "_");
    if (!r) r = literal(b, l + 1);
    if (!r) r = constructor_pattern(b, l + 1);
    if (!r) r = pattern_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER '@' pattern
  private static boolean pattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IDENTIFIER(b, l + 1);
    r = r && consumeToken(b, "@");
    r = r && pattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' literal (',' literal)* ')'
  private static boolean pattern_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && literal(b, l + 1);
    r = r && pattern_5_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' literal)*
  private static boolean pattern_5_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_5_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!pattern_5_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_5_2", c)) break;
    }
    return true;
  }

  // ',' literal
  private static boolean pattern_5_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_5_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // builtin_type ('.' IDENTIFIER)*
  public static boolean qualified_import(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualified_import")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUALIFIED_IMPORT, "<qualified import>");
    r = builtin_type(b, l + 1);
    r = r && qualified_import_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('.' IDENTIFIER)*
  private static boolean qualified_import_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualified_import_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!qualified_import_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "qualified_import_1", c)) break;
    }
    return true;
  }

  // '.' IDENTIFIER
  private static boolean qualified_import_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualified_import_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ".");
    r = r && IDENTIFIER(b, l + 1);
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
  //             | topLevelTypeDefinition
  //             | binding
  //             | ability_decl
  //             | type_decl
  //             | definition
  //             | expression
  //             | COMMENT
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = namespace_decl(b, l + 1);
    if (!r) r = use_import(b, l + 1);
    if (!r) r = topLevelTypeDefinition(b, l + 1);
    if (!r) r = binding(b, l + 1);
    if (!r) r = ability_decl(b, l + 1);
    if (!r) r = type_decl(b, l + 1);
    if (!r) r = definition(b, l + 1);
    if (!r) r = expression(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // qualified_name ':' (('forall' | '∀') IDENTIFIER+ '.')? ('''{' IDENTIFIER (',' IDENTIFIER )* '}')? type_expr functionBody
  public static boolean topLevelTypeDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelTypeDefinition")) return false;
    if (!nextTokenIs(b, IDENTIFIER_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = qualified_name(b, l + 1);
    r = r && consumeToken(b, ":");
    r = r && topLevelTypeDefinition_2(b, l + 1);
    r = r && topLevelTypeDefinition_3(b, l + 1);
    r = r && type_expr(b, l + 1);
    r = r && functionBody(b, l + 1);
    exit_section_(b, m, TOP_LEVEL_TYPE_DEFINITION, r);
    return r;
  }

  // (('forall' | '∀') IDENTIFIER+ '.')?
  private static boolean topLevelTypeDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelTypeDefinition_2")) return false;
    topLevelTypeDefinition_2_0(b, l + 1);
    return true;
  }

  // ('forall' | '∀') IDENTIFIER+ '.'
  private static boolean topLevelTypeDefinition_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelTypeDefinition_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = topLevelTypeDefinition_2_0_0(b, l + 1);
    r = r && topLevelTypeDefinition_2_0_1(b, l + 1);
    r = r && consumeToken(b, ".");
    exit_section_(b, m, null, r);
    return r;
  }

  // 'forall' | '∀'
  private static boolean topLevelTypeDefinition_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelTypeDefinition_2_0_0")) return false;
    boolean r;
    r = consumeToken(b, "forall");
    if (!r) r = consumeToken(b, "∀");
    return r;
  }

  // IDENTIFIER+
  private static boolean topLevelTypeDefinition_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelTypeDefinition_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IDENTIFIER(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!IDENTIFIER(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "topLevelTypeDefinition_2_0_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // ('''{' IDENTIFIER (',' IDENTIFIER )* '}')?
  private static boolean topLevelTypeDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelTypeDefinition_3")) return false;
    topLevelTypeDefinition_3_0(b, l + 1);
    return true;
  }

  // '''{' IDENTIFIER (',' IDENTIFIER )* '}'
  private static boolean topLevelTypeDefinition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelTypeDefinition_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "");
    r = r && consumeToken(b, "{");
    r = r && IDENTIFIER(b, l + 1);
    r = r && topLevelTypeDefinition_3_0_3(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' IDENTIFIER )*
  private static boolean topLevelTypeDefinition_3_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelTypeDefinition_3_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!topLevelTypeDefinition_3_0_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "topLevelTypeDefinition_3_0_3", c)) break;
    }
    return true;
  }

  // ',' IDENTIFIER
  private static boolean topLevelTypeDefinition_3_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelTypeDefinition_3_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && IDENTIFIER(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( 'unique' | 'structural' )? 'type' qualified_name qualified_name? '=' constructor ( '|' constructor )*
  public static boolean type_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DECL, "<type decl>");
    r = type_decl_0(b, l + 1);
    r = r && consumeToken(b, "type");
    r = r && qualified_name(b, l + 1);
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

  // qualified_name?
  private static boolean type_decl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_3")) return false;
    qualified_name(b, l + 1);
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
  // '[' type_expr IDENTIFIER? ']'
  //   | builtin_type '->' type_expr IDENTIFIER?
  //   | IDENTIFIER '->' type_expr IDENTIFIER?
  //   | '[' IDENTIFIER ']' '->' type_expr IDENTIFIER?
  //   | builtin_type
  //   | '(' type_expr IDENTIFIER? (',' type_expr IDENTIFIER?)* ')'
  //   | qualified_name
  public static boolean type_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_EXPR, "<type expr>");
    r = type_expr_0(b, l + 1);
    if (!r) r = type_expr_1(b, l + 1);
    if (!r) r = type_expr_2(b, l + 1);
    if (!r) r = type_expr_3(b, l + 1);
    if (!r) r = builtin_type(b, l + 1);
    if (!r) r = type_expr_5(b, l + 1);
    if (!r) r = qualified_name(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '[' type_expr IDENTIFIER? ']'
  private static boolean type_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[");
    r = r && type_expr(b, l + 1);
    r = r && type_expr_0_2(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER?
  private static boolean type_expr_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_0_2")) return false;
    IDENTIFIER(b, l + 1);
    return true;
  }

  // builtin_type '->' type_expr IDENTIFIER?
  private static boolean type_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = builtin_type(b, l + 1);
    r = r && consumeToken(b, "->");
    r = r && type_expr(b, l + 1);
    r = r && type_expr_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER?
  private static boolean type_expr_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_1_3")) return false;
    IDENTIFIER(b, l + 1);
    return true;
  }

  // IDENTIFIER '->' type_expr IDENTIFIER?
  private static boolean type_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IDENTIFIER(b, l + 1);
    r = r && consumeToken(b, "->");
    r = r && type_expr(b, l + 1);
    r = r && type_expr_2_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER?
  private static boolean type_expr_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_2_3")) return false;
    IDENTIFIER(b, l + 1);
    return true;
  }

  // '[' IDENTIFIER ']' '->' type_expr IDENTIFIER?
  private static boolean type_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[");
    r = r && IDENTIFIER(b, l + 1);
    r = r && consumeToken(b, "]");
    r = r && consumeToken(b, "->");
    r = r && type_expr(b, l + 1);
    r = r && type_expr_3_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER?
  private static boolean type_expr_3_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_3_5")) return false;
    IDENTIFIER(b, l + 1);
    return true;
  }

  // '(' type_expr IDENTIFIER? (',' type_expr IDENTIFIER?)* ')'
  private static boolean type_expr_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && type_expr(b, l + 1);
    r = r && type_expr_5_2(b, l + 1);
    r = r && type_expr_5_3(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER?
  private static boolean type_expr_5_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_5_2")) return false;
    IDENTIFIER(b, l + 1);
    return true;
  }

  // (',' type_expr IDENTIFIER?)*
  private static boolean type_expr_5_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_5_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_expr_5_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_expr_5_3", c)) break;
    }
    return true;
  }

  // ',' type_expr IDENTIFIER?
  private static boolean type_expr_5_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_5_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && type_expr(b, l + 1);
    r = r && type_expr_5_3_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER?
  private static boolean type_expr_5_3_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_5_3_0_2")) return false;
    IDENTIFIER(b, l + 1);
    return true;
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
  // 'use' ( qualified_import | qualified_name )
  public static boolean use_import(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_import")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, USE_IMPORT, "<use import>");
    r = consumeToken(b, "use");
    r = r && use_import_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // qualified_import | qualified_name
  private static boolean use_import_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_import_1")) return false;
    boolean r;
    r = qualified_import(b, l + 1);
    if (!r) r = qualified_name(b, l + 1);
    return r;
  }

}
