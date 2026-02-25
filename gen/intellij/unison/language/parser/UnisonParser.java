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
  // ADD_OP_TOKEN
  public static boolean ADD_OP(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ADD_OP")) return false;
    if (!nextTokenIs(b, ADD_OP_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ADD_OP_TOKEN);
    exit_section_(b, m, ADD_OP, r);
    return r;
  }

  /* ********************************************************** */
  // BOOLEAN_TOKEN
  public static boolean BOOLEAN(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BOOLEAN")) return false;
    if (!nextTokenIs(b, BOOLEAN_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BOOLEAN_TOKEN);
    exit_section_(b, m, BOOLEAN, r);
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
  // MUL_OP_TOKEN
  public static boolean MUL_OP(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MUL_OP")) return false;
    if (!nextTokenIs(b, MUL_OP_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MUL_OP_TOKEN);
    exit_section_(b, m, MUL_OP, r);
    return r;
  }

  /* ********************************************************** */
  // OPERATOR_ID_TOKEN
  public static boolean OPERATOR_ID(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OPERATOR_ID")) return false;
    if (!nextTokenIs(b, OPERATOR_ID_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPERATOR_ID_TOKEN);
    exit_section_(b, m, OPERATOR_ID, r);
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
  // LBRACE IDENTIFIER (COMMA IDENTIFIER )* RBRACE
  static boolean abilityRequirements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "abilityRequirements")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && IDENTIFIER(b, l + 1);
    r = r && abilityRequirements_2(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA IDENTIFIER )*
  private static boolean abilityRequirements_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "abilityRequirements_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!abilityRequirements_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "abilityRequirements_2", c)) break;
    }
    return true;
  }

  // COMMA IDENTIFIER
  private static boolean abilityRequirements_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "abilityRequirements_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && IDENTIFIER(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER COLON type_expr
  static boolean ability_constructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ability_constructor")) return false;
    if (!nextTokenIs(b, IDENTIFIER_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IDENTIFIER(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (UNIQUE | STRUCTURAL)? ABILITY IDENTIFIER type_params?
  //  WHERE LBRACE ability_constructor* RBRACE
  public static boolean ability_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ability_decl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ABILITY_DECL, "<ability decl>");
    r = ability_decl_0(b, l + 1);
    r = r && consumeToken(b, ABILITY);
    r = r && IDENTIFIER(b, l + 1);
    r = r && ability_decl_3(b, l + 1);
    r = r && consumeTokens(b, 0, WHERE, LBRACE);
    r = r && ability_decl_6(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (UNIQUE | STRUCTURAL)?
  private static boolean ability_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ability_decl_0")) return false;
    ability_decl_0_0(b, l + 1);
    return true;
  }

  // UNIQUE | STRUCTURAL
  private static boolean ability_decl_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ability_decl_0_0")) return false;
    boolean r;
    r = consumeToken(b, UNIQUE);
    if (!r) r = consumeToken(b, STRUCTURAL);
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
  // mulExpr (ADD_OP mulExpr)*
  static boolean addExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mulExpr(b, l + 1);
    r = r && addExpr_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ADD_OP mulExpr)*
  private static boolean addExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!addExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "addExpr_1", c)) break;
    }
    return true;
  }

  // ADD_OP mulExpr
  private static boolean addExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ADD_OP(b, l + 1);
    r = r && mulExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // notExpr (BOOL_OPERATOR notExpr)*
  static boolean andExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andExpr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = notExpr(b, l + 1);
    r = r && andExpr_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (BOOL_OPERATOR notExpr)*
  private static boolean andExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!andExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "andExpr_1", c)) break;
    }
    return true;
  }

  // BOOL_OPERATOR notExpr
  private static boolean andExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BOOL_OPERATOR(b, l + 1);
    r = r && notExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression (COMMA expression)*
  static boolean argument_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && argument_list_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA expression)*
  private static boolean argument_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argument_list_1", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean argument_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // numLiteral
  //   | qualified_name
  //   | LPAREN numExpr RPAREN
  static boolean atomNum(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomNum")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = numLiteral(b, l + 1);
    if (!r) r = qualified_name(b, l + 1);
    if (!r) r = atomNum_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN numExpr RPAREN
  private static boolean atomNum_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomNum_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && numExpr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // qualified_name IDENTIFIER* EQ expression
  //   | ((IDENTIFIER | UNDERSCORE) EQ expression)+
  //   | LPAREN (IDENTIFIER | UNDERSCORE) (COMMA (IDENTIFIER | UNDERSCORE))* RPAREN EQ LPAREN expression (COMMA expression)* RPAREN
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

  // qualified_name IDENTIFIER* EQ expression
  private static boolean binding_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = qualified_name(b, l + 1);
    r = r && binding_0_1(b, l + 1);
    r = r && consumeToken(b, EQ);
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

  // ((IDENTIFIER | UNDERSCORE) EQ expression)+
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

  // (IDENTIFIER | UNDERSCORE) EQ expression
  private static boolean binding_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binding_1_0_0(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER | UNDERSCORE
  private static boolean binding_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_1_0_0")) return false;
    boolean r;
    r = IDENTIFIER(b, l + 1);
    if (!r) r = consumeToken(b, UNDERSCORE);
    return r;
  }

  // LPAREN (IDENTIFIER | UNDERSCORE) (COMMA (IDENTIFIER | UNDERSCORE))* RPAREN EQ LPAREN expression (COMMA expression)* RPAREN
  private static boolean binding_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && binding_2_1(b, l + 1);
    r = r && binding_2_2(b, l + 1);
    r = r && consumeTokens(b, 0, RPAREN, EQ, LPAREN);
    r = r && expression(b, l + 1);
    r = r && binding_2_7(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER | UNDERSCORE
  private static boolean binding_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_2_1")) return false;
    boolean r;
    r = IDENTIFIER(b, l + 1);
    if (!r) r = consumeToken(b, UNDERSCORE);
    return r;
  }

  // (COMMA (IDENTIFIER | UNDERSCORE))*
  private static boolean binding_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_2_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!binding_2_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "binding_2_2", c)) break;
    }
    return true;
  }

  // COMMA (IDENTIFIER | UNDERSCORE)
  private static boolean binding_2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_2_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && binding_2_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER | UNDERSCORE
  private static boolean binding_2_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_2_2_0_1")) return false;
    boolean r;
    r = IDENTIFIER(b, l + 1);
    if (!r) r = consumeToken(b, UNDERSCORE);
    return r;
  }

  // (COMMA expression)*
  private static boolean binding_2_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_2_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!binding_2_7_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "binding_2_7", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean binding_2_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_2_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BOOLEAN
  //   | comparison
  //   | LPAREN boolExpr RPAREN
  static boolean boolAtom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolAtom")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BOOLEAN(b, l + 1);
    if (!r) r = comparison(b, l + 1);
    if (!r) r = boolAtom_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN boolExpr RPAREN
  private static boolean boolAtom_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolAtom_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && boolExpr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // orExpr
  public static boolean boolExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BOOL_EXPR, "<bool expr>");
    r = orExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_NAT
  //   | KW_INT
  //   | KW_CHAR
  //   | KW_TEXT
  //   | KW_FLOAT
  //   | KW_DOUBLE
  //   | KW_BOOLEAN
  //   | KW_BYTES
  //   | KW_UNIT
  public static boolean builtin_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtin_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILTIN_TYPE, "<builtin type>");
    r = consumeToken(b, KW_NAT);
    if (!r) r = consumeToken(b, KW_INT);
    if (!r) r = consumeToken(b, KW_CHAR);
    if (!r) r = consumeToken(b, KW_TEXT);
    if (!r) r = consumeToken(b, KW_FLOAT);
    if (!r) r = consumeToken(b, KW_DOUBLE);
    if (!r) r = consumeToken(b, KW_BOOLEAN);
    if (!r) r = consumeToken(b, KW_BYTES);
    if (!r) r = consumeToken(b, KW_UNIT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CASES expression+ (guardPattern ARROW expression)+
  public static boolean cases_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cases_expr")) return false;
    if (!nextTokenIs(b, CASES)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASES);
    r = r && cases_expr_1(b, l + 1);
    r = r && cases_expr_2(b, l + 1);
    exit_section_(b, m, CASES_EXPR, r);
    return r;
  }

  // expression+
  private static boolean cases_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cases_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "cases_expr_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (guardPattern ARROW expression)+
  private static boolean cases_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cases_expr_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = cases_expr_2_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!cases_expr_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "cases_expr_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // guardPattern ARROW expression
  private static boolean cases_expr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cases_expr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = guardPattern(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CATCH DO expression
  //   | CATCH expression
  public static boolean catch_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "catch_expr")) return false;
    if (!nextTokenIs(b, CATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = catch_expr_0(b, l + 1);
    if (!r) r = catch_expr_1(b, l + 1);
    exit_section_(b, m, CATCH_EXPR, r);
    return r;
  }

  // CATCH DO expression
  private static boolean catch_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "catch_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CATCH, DO);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CATCH expression
  private static boolean catch_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "catch_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CATCH);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // numExpr COMPARE_OPERATOR numExpr
  //   | qualified_name COMPARE_OPERATOR numExpr
  //   | numExpr COMPARE_OPERATOR qualified_name
  //   | qualified_name COMPARE_OPERATOR qualified_name
  static boolean comparison(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comparison_0(b, l + 1);
    if (!r) r = comparison_1(b, l + 1);
    if (!r) r = comparison_2(b, l + 1);
    if (!r) r = comparison_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // numExpr COMPARE_OPERATOR numExpr
  private static boolean comparison_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = numExpr(b, l + 1);
    r = r && COMPARE_OPERATOR(b, l + 1);
    r = r && numExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // qualified_name COMPARE_OPERATOR numExpr
  private static boolean comparison_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = qualified_name(b, l + 1);
    r = r && COMPARE_OPERATOR(b, l + 1);
    r = r && numExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // numExpr COMPARE_OPERATOR qualified_name
  private static boolean comparison_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = numExpr(b, l + 1);
    r = r && COMPARE_OPERATOR(b, l + 1);
    r = r && qualified_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // qualified_name COMPARE_OPERATOR qualified_name
  private static boolean comparison_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = qualified_name(b, l + 1);
    r = r && COMPARE_OPERATOR(b, l + 1);
    r = r && qualified_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // name pattern*
  static boolean constructor_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_pattern")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = name(b, l + 1);
    r = r && constructor_pattern_1(b, l + 1);
    exit_section_(b, m, null, r);
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
  // qualified_name type_expr*
  public static boolean dataConstructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataConstructor")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATA_CONSTRUCTOR, "<data constructor>");
    r = qualified_name(b, l + 1);
    r = r && dataConstructor_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // type_expr*
  private static boolean dataConstructor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataConstructor_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dataConstructor_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (UNIQUE | STRUCTURAL)? TYPE qualified_name qualified_name? EQ
  //   dataConstructor (BAR dataConstructor)*
  public static boolean dataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATA_TYPE, "<data type>");
    r = dataType_0(b, l + 1);
    r = r && consumeToken(b, TYPE);
    r = r && qualified_name(b, l + 1);
    r = r && dataType_3(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && dataConstructor(b, l + 1);
    r = r && dataType_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (UNIQUE | STRUCTURAL)?
  private static boolean dataType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType_0")) return false;
    dataType_0_0(b, l + 1);
    return true;
  }

  // UNIQUE | STRUCTURAL
  private static boolean dataType_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType_0_0")) return false;
    boolean r;
    r = consumeToken(b, UNIQUE);
    if (!r) r = consumeToken(b, STRUCTURAL);
    return r;
  }

  // qualified_name?
  private static boolean dataType_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType_3")) return false;
    qualified_name(b, l + 1);
    return true;
  }

  // (BAR dataConstructor)*
  private static boolean dataType_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!dataType_6_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dataType_6", c)) break;
    }
    return true;
  }

  // BAR dataConstructor
  private static boolean dataType_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BAR);
    r = r && dataConstructor(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACETICK IDENTIFIER (COMMA IDENTIFIER)* RBRACE
  public static boolean delayedType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "delayedType")) return false;
    if (!nextTokenIs(b, LBRACETICK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACETICK);
    r = r && IDENTIFIER(b, l + 1);
    r = r && delayedType_2(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, DELAYED_TYPE, r);
    return r;
  }

  // (COMMA IDENTIFIER)*
  private static boolean delayedType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "delayedType_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!delayedType_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "delayedType_2", c)) break;
    }
    return true;
  }

  // COMMA IDENTIFIER
  private static boolean delayedType_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "delayedType_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && IDENTIFIER(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DO expression
  //              | useClause
  //              | typed_def
  //              | binding
  //              | lambda
  //              | function_call
  //              | boolExpr
  //              | numExpr
  //              | ifThenElseExpr
  //              | matchExpr
  //              | cases_expr
  //              | literal
  //              | qualified_name
  //              | qualified_import
  //              | let_expr
  //              | catch_expr
  //              | LPAREN expression RPAREN
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = expression_0(b, l + 1);
    if (!r) r = useClause(b, l + 1);
    if (!r) r = typed_def(b, l + 1);
    if (!r) r = binding(b, l + 1);
    if (!r) r = lambda(b, l + 1);
    if (!r) r = function_call(b, l + 1);
    if (!r) r = boolExpr(b, l + 1);
    if (!r) r = numExpr(b, l + 1);
    if (!r) r = ifThenElseExpr(b, l + 1);
    if (!r) r = matchExpr(b, l + 1);
    if (!r) r = cases_expr(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = qualified_name(b, l + 1);
    if (!r) r = qualified_import(b, l + 1);
    if (!r) r = let_expr(b, l + 1);
    if (!r) r = catch_expr(b, l + 1);
    if (!r) r = expression_16(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DO expression
  private static boolean expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DO);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN expression RPAREN
  private static boolean expression_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_16")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DO expression
  //            | nl INDENT statement+ DEDENT
  public static boolean fun_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_body")) return false;
    if (!nextTokenIs(b, "<fun body>", DO, NEWLINE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUN_BODY, "<fun body>");
    r = fun_body_0(b, l + 1);
    if (!r) r = fun_body_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DO expression
  private static boolean fun_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DO);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl INDENT statement+ DEDENT
  private static boolean fun_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && consumeToken(b, INDENT);
    r = r && fun_body_1_2(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // statement+
  private static boolean fun_body_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_body_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fun_body_1_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // qualified_name LPAREN argument_list? RPAREN
  public static boolean function_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL, "<function call>");
    r = qualified_name(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && function_call_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // argument_list?
  private static boolean function_call_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call_2")) return false;
    argument_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BAR (OTHERWISE | boolExpr)
  public static boolean guardPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "guardPattern")) return false;
    if (!nextTokenIs(b, BAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BAR);
    r = r && guardPattern_1(b, l + 1);
    exit_section_(b, m, GUARD_PATTERN, r);
    return r;
  }

  // OTHERWISE | boolExpr
  private static boolean guardPattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "guardPattern_1")) return false;
    boolean r;
    r = consumeToken(b, OTHERWISE);
    if (!r) r = boolExpr(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IF boolExpr THEN expression ELSE expression
  public static boolean ifThenElseExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifThenElseExpr")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && boolExpr(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, ELSE);
    r = r && expression(b, l + 1);
    exit_section_(b, m, IF_THEN_ELSE_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // pattern+ ARROW expression
  public static boolean lambda(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAMBDA, "<lambda>");
    r = lambda_0(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // pattern+
  private static boolean lambda_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!pattern(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lambda_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LET (binding)+
  public static boolean let_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_expr")) return false;
    if (!nextTokenIs(b, LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LET);
    r = r && let_expr_1(b, l + 1);
    exit_section_(b, m, LET_EXPR, r);
    return r;
  }

  // (binding)+
  private static boolean let_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = let_expr_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!let_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "let_expr_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (binding)
  private static boolean let_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binding(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INT
  //   | DOUBLE | CHAR | STRING | BOOLEAN | BYTES
  //   | LPARENSQ RPARENSQ
  //   | LPARENSQ literal (COMMA literal)* RPARENSQ
  //   | LPAREN literal (COMMA literal)* RPAREN
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
    if (!r) r = parseTokens(b, 0, LPARENSQ, RPARENSQ);
    if (!r) r = literal_7(b, l + 1);
    if (!r) r = literal_8(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LPARENSQ literal (COMMA literal)* RPARENSQ
  private static boolean literal_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPARENSQ);
    r = r && literal(b, l + 1);
    r = r && literal_7_2(b, l + 1);
    r = r && consumeToken(b, RPARENSQ);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA literal)*
  private static boolean literal_7_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_7_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!literal_7_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "literal_7_2", c)) break;
    }
    return true;
  }

  // COMMA literal
  private static boolean literal_7_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_7_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN literal (COMMA literal)* RPAREN
  private static boolean literal_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && literal(b, l + 1);
    r = r && literal_8_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA literal)*
  private static boolean literal_8_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_8_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!literal_8_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "literal_8_2", c)) break;
    }
    return true;
  }

  // COMMA literal
  private static boolean literal_8_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_8_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MATCH expression+ WITH NEWLINE INDENT match_case+ DEDENT
  public static boolean matchExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchExpr")) return false;
    if (!nextTokenIs(b, MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MATCH);
    r = r && matchExpr_1(b, l + 1);
    r = r && consumeTokens(b, 0, WITH, NEWLINE, INDENT);
    r = r && matchExpr_5(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, MATCH_EXPR, r);
    return r;
  }

  // expression+
  private static boolean matchExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchExpr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "matchExpr_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // match_case+
  private static boolean matchExpr_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchExpr_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = match_case(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!match_case(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "matchExpr_5", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // pattern (guardPattern ARROW expression)+ NEWLINE
  //             | pattern ARROW expression NEWLINE
  public static boolean match_case(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_case")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATCH_CASE, "<match case>");
    r = match_case_0(b, l + 1);
    if (!r) r = match_case_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // pattern (guardPattern ARROW expression)+ NEWLINE
  private static boolean match_case_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_case_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern(b, l + 1);
    r = r && match_case_0_1(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (guardPattern ARROW expression)+
  private static boolean match_case_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_case_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = match_case_0_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!match_case_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "match_case_0_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // guardPattern ARROW expression
  private static boolean match_case_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_case_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = guardPattern(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // pattern ARROW expression NEWLINE
  private static boolean match_case_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_case_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // unaryExpr (MUL_OP unaryExpr)*
  static boolean mulExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mulExpr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unaryExpr(b, l + 1);
    r = r && mulExpr_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (MUL_OP unaryExpr)*
  private static boolean mulExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mulExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!mulExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mulExpr_1", c)) break;
    }
    return true;
  }

  // MUL_OP unaryExpr
  private static boolean mulExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mulExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MUL_OP(b, l + 1);
    r = r && unaryExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  //               | OPERATOR_ID
  //               | ADD_OP
  //               | MUL_OP
  static boolean name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "name")) return false;
    boolean r;
    r = IDENTIFIER(b, l + 1);
    if (!r) r = OPERATOR_ID(b, l + 1);
    if (!r) r = ADD_OP(b, l + 1);
    if (!r) r = MUL_OP(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // NAMESPACE qualified_name
  public static boolean namespace_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_decl")) return false;
    if (!nextTokenIs(b, NAMESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAMESPACE);
    r = r && qualified_name(b, l + 1);
    exit_section_(b, m, NAMESPACE_DECL, r);
    return r;
  }

  /* ********************************************************** */
  // NEWLINE+
  static boolean nl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nl")) return false;
    if (!nextTokenIs(b, NEWLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEWLINE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, NEWLINE)) break;
      if (!empty_element_parsed_guard_(b, "nl", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NOT notExpr
  //   | boolAtom
  static boolean notExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notExpr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = notExpr_0(b, l + 1);
    if (!r) r = boolAtom(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NOT notExpr
  private static boolean notExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOT);
    r = r && notExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // addExpr
  public static boolean numExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, NUM_EXPR, "<num expr>");
    r = addExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // INT | DOUBLE
  static boolean numLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numLiteral")) return false;
    if (!nextTokenIs(b, "", DOUBLE_TOKEN, INT_TOKEN)) return false;
    boolean r;
    r = INT(b, l + 1);
    if (!r) r = DOUBLE(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // andExpr (BOOL_OPERATOR andExpr)*
  static boolean orExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orExpr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = andExpr(b, l + 1);
    r = r && orExpr_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (BOOL_OPERATOR andExpr)*
  private static boolean orExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!orExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "orExpr_1", c)) break;
    }
    return true;
  }

  // BOOL_OPERATOR andExpr
  private static boolean orExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BOOL_OPERATOR(b, l + 1);
    r = r && andExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // name AT pattern
  //           | name
  //           | UNDERSCORE
  //           | literal
  //           | constructor_pattern
  //           | LPAREN literal (COMMA literal)* RPAREN
  public static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, PATTERN, "<pattern>");
    r = pattern_0(b, l + 1);
    if (!r) r = name(b, l + 1);
    if (!r) r = consumeToken(b, UNDERSCORE);
    if (!r) r = literal(b, l + 1);
    if (!r) r = constructor_pattern(b, l + 1);
    if (!r) r = pattern_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // name AT pattern
  private static boolean pattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = name(b, l + 1);
    r = r && consumeToken(b, AT);
    r = r && pattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN literal (COMMA literal)* RPAREN
  private static boolean pattern_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && literal(b, l + 1);
    r = r && pattern_5_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA literal)*
  private static boolean pattern_5_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_5_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!pattern_5_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_5_2", c)) break;
    }
    return true;
  }

  // COMMA literal
  private static boolean pattern_5_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_5_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (FORALL | FORALLSYMBOL) IDENTIFIER+ DOT
  public static boolean polymorphicType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "polymorphicType")) return false;
    if (!nextTokenIs(b, "<polymorphic type>", FORALL, FORALLSYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POLYMORPHIC_TYPE, "<polymorphic type>");
    r = polymorphicType_0(b, l + 1);
    r = r && polymorphicType_1(b, l + 1);
    r = r && consumeToken(b, DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // FORALL | FORALLSYMBOL
  private static boolean polymorphicType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "polymorphicType_0")) return false;
    boolean r;
    r = consumeToken(b, FORALL);
    if (!r) r = consumeToken(b, FORALLSYMBOL);
    return r;
  }

  // IDENTIFIER+
  private static boolean polymorphicType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "polymorphicType_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IDENTIFIER(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!IDENTIFIER(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "polymorphicType_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // builtin_type (DOT IDENTIFIER)*
  static boolean qualified_import(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualified_import")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = builtin_type(b, l + 1);
    r = r && qualified_import_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean qualified_import_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualified_import_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!qualified_import_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "qualified_import_1", c)) break;
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean qualified_import_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualified_import_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && IDENTIFIER(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // name (DOT name)*
  static boolean qualified_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualified_name")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = name(b, l + 1);
    r = r && qualified_name_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DOT name)*
  private static boolean qualified_name_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualified_name_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!qualified_name_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "qualified_name_1", c)) break;
    }
    return true;
  }

  // DOT name
  private static boolean qualified_name_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualified_name_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NEWLINE
  //             | MULTILINE_COMMENT_TOKEN
  //             | LINE_COMMENT_TOKEN
  //             | namespace_decl
  //             | ability_decl
  //             | dataType
  //             | expression
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = consumeToken(b, NEWLINE);
    if (!r) r = consumeToken(b, MULTILINE_COMMENT_TOKEN);
    if (!r) r = consumeToken(b, LINE_COMMENT_TOKEN);
    if (!r) r = namespace_decl(b, l + 1);
    if (!r) r = ability_decl(b, l + 1);
    if (!r) r = dataType(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LPARENSQ type_expr IDENTIFIER? RPARENSQ
  //   | builtin_type ARROW type_expr IDENTIFIER?
  //   | IDENTIFIER ARROW type_expr IDENTIFIER?
  //   | LPARENSQ IDENTIFIER RPARENSQ ARROW type_expr IDENTIFIER?
  //   | builtin_type
  //   | LPAREN type_expr IDENTIFIER? (COMMA type_expr IDENTIFIER?)* RPAREN
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

  // LPARENSQ type_expr IDENTIFIER? RPARENSQ
  private static boolean type_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPARENSQ);
    r = r && type_expr(b, l + 1);
    r = r && type_expr_0_2(b, l + 1);
    r = r && consumeToken(b, RPARENSQ);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER?
  private static boolean type_expr_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_0_2")) return false;
    IDENTIFIER(b, l + 1);
    return true;
  }

  // builtin_type ARROW type_expr IDENTIFIER?
  private static boolean type_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = builtin_type(b, l + 1);
    r = r && consumeToken(b, ARROW);
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

  // IDENTIFIER ARROW type_expr IDENTIFIER?
  private static boolean type_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IDENTIFIER(b, l + 1);
    r = r && consumeToken(b, ARROW);
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

  // LPARENSQ IDENTIFIER RPARENSQ ARROW type_expr IDENTIFIER?
  private static boolean type_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPARENSQ);
    r = r && IDENTIFIER(b, l + 1);
    r = r && consumeTokens(b, 0, RPARENSQ, ARROW);
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

  // LPAREN type_expr IDENTIFIER? (COMMA type_expr IDENTIFIER?)* RPAREN
  private static boolean type_expr_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && type_expr(b, l + 1);
    r = r && type_expr_5_2(b, l + 1);
    r = r && type_expr_5_3(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER?
  private static boolean type_expr_5_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_5_2")) return false;
    IDENTIFIER(b, l + 1);
    return true;
  }

  // (COMMA type_expr IDENTIFIER?)*
  private static boolean type_expr_5_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_5_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_expr_5_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_expr_5_3", c)) break;
    }
    return true;
  }

  // COMMA type_expr IDENTIFIER?
  private static boolean type_expr_5_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_5_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
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
  // LBRACE IDENTIFIER (COMMA IDENTIFIER)* RBRACE
  static boolean type_params(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_params")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && IDENTIFIER(b, l + 1);
    r = r && type_params_2(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA IDENTIFIER)*
  private static boolean type_params_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_params_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_params_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_params_2", c)) break;
    }
    return true;
  }

  // COMMA IDENTIFIER
  private static boolean type_params_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_params_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && IDENTIFIER(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // qualified_name COLON polymorphicType? delayedType?
  //   type_expr (ARROW abilityRequirements type_expr)*
  //   fun_body
  public static boolean typed_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typed_def")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPED_DEF, "<typed def>");
    r = qualified_name(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && typed_def_2(b, l + 1);
    r = r && typed_def_3(b, l + 1);
    r = r && type_expr(b, l + 1);
    r = r && typed_def_5(b, l + 1);
    r = r && fun_body(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // polymorphicType?
  private static boolean typed_def_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typed_def_2")) return false;
    polymorphicType(b, l + 1);
    return true;
  }

  // delayedType?
  private static boolean typed_def_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typed_def_3")) return false;
    delayedType(b, l + 1);
    return true;
  }

  // (ARROW abilityRequirements type_expr)*
  private static boolean typed_def_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typed_def_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!typed_def_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typed_def_5", c)) break;
    }
    return true;
  }

  // ARROW abilityRequirements type_expr
  private static boolean typed_def_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typed_def_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARROW);
    r = r && abilityRequirements(b, l + 1);
    r = r && type_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MINUS unaryExpr | MODW unaryExpr unaryExpr | atomNum
  static boolean unaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unaryExpr_0(b, l + 1);
    if (!r) r = unaryExpr_1(b, l + 1);
    if (!r) r = atomNum(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MINUS unaryExpr
  private static boolean unaryExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MINUS);
    r = r && unaryExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MODW unaryExpr unaryExpr
  private static boolean unaryExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MODW);
    r = r && unaryExpr(b, l + 1);
    r = r && unaryExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (NEWLINE | statement)*
  static boolean unisonFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unisonFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unisonFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unisonFile", c)) break;
    }
    return true;
  }

  // NEWLINE | statement
  private static boolean unisonFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unisonFile_0")) return false;
    boolean r;
    r = consumeToken(b, NEWLINE);
    if (!r) r = statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // USE (
  //     qualified_import
  //   | qualified_name
  //   | builtin_type
  //   | OPERATOR_ID
  //   | BOOL_OPERATOR
  //   | COMPARE_OPERATOR
  // )+
  public static boolean useClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useClause")) return false;
    if (!nextTokenIs(b, USE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, USE);
    r = r && useClause_1(b, l + 1);
    exit_section_(b, m, USE_CLAUSE, r);
    return r;
  }

  // (
  //     qualified_import
  //   | qualified_name
  //   | builtin_type
  //   | OPERATOR_ID
  //   | BOOL_OPERATOR
  //   | COMPARE_OPERATOR
  // )+
  private static boolean useClause_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useClause_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = useClause_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!useClause_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "useClause_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // qualified_import
  //   | qualified_name
  //   | builtin_type
  //   | OPERATOR_ID
  //   | BOOL_OPERATOR
  //   | COMPARE_OPERATOR
  private static boolean useClause_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useClause_1_0")) return false;
    boolean r;
    r = qualified_import(b, l + 1);
    if (!r) r = qualified_name(b, l + 1);
    if (!r) r = builtin_type(b, l + 1);
    if (!r) r = OPERATOR_ID(b, l + 1);
    if (!r) r = BOOL_OPERATOR(b, l + 1);
    if (!r) r = COMPARE_OPERATOR(b, l + 1);
    return r;
  }

}
