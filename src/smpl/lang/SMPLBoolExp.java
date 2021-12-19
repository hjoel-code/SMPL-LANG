package smpl.lang;

import smpl.lang.Visitors.*;

public abstract class SMPLBoolExp extends ASTExp<SMPLBoolExp> {
    
    
    public abstract <S, T> T visit(BoolVisitor<S, T> v, S state) throws Exception;

    @Override
    public <S, T> T visit(ASTVisitor<SMPLBoolExp, S, T>  v, S state) throws Exception {
        return visit((BoolVisitor<S, T> ) v, state);
    }

}
