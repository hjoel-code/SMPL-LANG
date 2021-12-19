package smpl.lang;

import smpl.lang.Visitors.ASTVisitor;
import smpl.lang.Visitors.STRVisitor;

public abstract class SMPLStringExp extends ASTExp<SMPLStringExp> {


    public abstract <S, T> T visit(STRVisitor<S, T> v, S state) throws Exception;
    
    @Override
    public <S, T> T visit(ASTVisitor<SMPLStringExp, S, T> v, S state) throws Exception {
        return  visit((STRVisitor<S, T>) v, state);
    }
    
}
