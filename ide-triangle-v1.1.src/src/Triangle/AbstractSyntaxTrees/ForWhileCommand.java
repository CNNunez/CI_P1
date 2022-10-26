/*
 * @(#)WhileCommand.java                        2.1 2003/10/07
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

package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ForWhileCommand extends Command {

  public ForWhileCommand(Identifier iAST,Identifier iAST2, Expression eAST,Expression eAST2,Expression eAST3, Command cAST, SourcePosition commandPos) {
    super (commandPos);
    I = iAST;
    I2 = iAST2;
    E = eAST;
    E2 = eAST2;
    E3 = eAST3;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitForWhileCommand(this, o);
  }

  public Identifier I, I2;
  public Expression E, E2, E3;
  public Command C;
}
