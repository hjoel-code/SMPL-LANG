package smpl.lang;

import smpl.lang.Visitors.*;

public abstract class SMPLArithExp extends ASTExp<SMPLArithExp> {
    

    public abstract <S, T> T visit(ArithVisitor<S, T> v, S state) throws Exception;

    @Override
    public <S, T> T visit(ASTVisitor<SMPLArithExp, S, T> v, S state) throws Exception {
        return visit((ArithVisitor<S, T> ) v, state);
    }

}
