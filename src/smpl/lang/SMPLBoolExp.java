package smpl.lang;

import smpl.lang.visitors.*;
import smpl.sys.SMPLException;

public abstract class SMPLBoolExp extends ASTExp<SMPLBoolExp> {
    
    public abstract <S, T> T visit(BoolVisitor<S, T> v, S state) throws SMPLException;

    @Override
    public <S, T> T visit(ASTVisitor<S, T>  v, S state) throws SMPLException {
        return visit((BoolVisitor<S, T> ) v, state);
    }

}
