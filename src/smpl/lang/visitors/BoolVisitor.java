package smpl.lang.visitors;

import smpl.lang.SMPLBoolExp;

public interface BoolVisitor<S, T> extends ASTVisitor<SMPLBoolExp, S, T> {
    
}
