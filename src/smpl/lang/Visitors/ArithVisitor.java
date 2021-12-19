package smpl.lang.Visitors;

import smpl.lang.SMPLArithExp;

public interface ArithVisitor<S, T> extends ASTVisitor<SMPLArithExp, S, T> {

}
