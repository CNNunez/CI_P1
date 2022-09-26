/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    OPERATOR	= 3,

    // reserved words - must be in alphabetical order...
    //Edited by Jhonny Diaz
    ARRAY		= 4,
//    BEGIN		= 5, Deleting BEGIN -- Jhonny Diaz
    CONST		= 5,
    DO			= 6,
    ELSE		= 7,
    END			= 8,
    FOR                 = 9, //Adding FOR -- Johnny Diaz
    FROM                = 10,//Adding FROM -- Johnny Diaz
    FUNC		= 11,
    IF			= 12,
    IN			= 13,
    INIT                = 14,//Adding INIT -- Johnny Diaz
    LEAVE               = 15,//Adding LEAVE -- Johnny Diaz
    LET			= 16,
    LOCAL               = 17,//Adding LOCAL -- Johnny Diaz
    LOOP                = 18,//Adding LOOP -- Johnny Diaz
    NEXT                = 19,//Adding NEXT -- Johnny Diaz
    NIL                 = 20,//Adding NIL -- Johnny Diaz
    OF			= 21,
    PROC		= 22,
    REC                 = 23,//Adding REC -- Johnny Diaz
    RECORD		= 24,
    RETURN              = 25,//Adding RETURN -- Johnny Diaz
    SELECT              = 26,//Adding SELECT -- Johnny Diaz
    TO                  = 27,//Adding TO -- Johnny Diaz
    THEN		= 28,
    TYPE		= 29,
    UNTIL               = 30,//Adding UNTIL -- Johnny Diaz
    VAR			= 31,
    WHEN                = 32,//Adding WHEN -- Johnny Diaz
    WHILE		= 33,
    // punctuation...
    DOT			= 34,
    COLON		= 35,
    SEMICOLON	        = 36,
    COMMA		= 37,
    BECOMES		= 38,
    IS			= 39,
    PIPE                = 40,//Adding PIPE -- Johnny Diaz

    // brackets...
    LPAREN		= 41,
    RPAREN		= 42,
    LBRACKET	        = 43,
    RBRACKET	        = 44,
    LCURLY		= 45,
    RCURLY		= 46,

    // special tokens...
    EOT			= 47,
    ERROR		= 48;

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "array",
//    "begin", Deleting BEGIN
    "const",
    "do",
    "else",
    "end",
    "for",//Adding FOR -- Johnny Diaz
    "from",//Adding FROM -- Johnny Diaz
    "func",
    "if",
    "in",
    "init",//Adding INIT -- Johnny Diaz
    "leave",//Adding LEAVE -- Johnny Diaz
    "let",
    "local",//Adding LOCAL -- Johnny Diaz
    "loop",//Adding LOOP -- Johnny Diaz
    "next",//Adding NEXT -- Johnny Diaz
    "nil",//Adding NIL -- Johnny Diaz
    "of",
    "proc",
    "rec",//Adding REC -- Johnny Diaz
    "record",
    "return",//Adding RETURN -- Johnny Diaz
    "select",//Adding SELECT -- Johnny Diaz
    "to",//Adding TO -- Johnny Diaz
    "then",
    "type",
    "until",//Adding UNTIL -- Johnny Diaz
    "var",
    "while",
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "|",//Adding PIPE -- Johnny Diaz
    "(",
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>"
  };

  private final static int	firstReservedWord = Token.ARRAY,
  				lastReservedWord  = Token.WHILE;

}
