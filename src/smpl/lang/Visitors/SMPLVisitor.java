package smpl.lang.Visitors;

import smpl.lang.SMPLExp;

public interface SMPLVisitor<S, T> extends ASTVisitor<SMPLExp, S, T> {
    
}
