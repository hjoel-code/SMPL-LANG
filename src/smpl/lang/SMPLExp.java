package smpl.lang;

import smpl.lang.visitors.*;
import smpl.sys.SMPLException;

public class SMPLExp<E extends ASTExp<E>> extends ASTExp<SMPLExp<E>> {
    
    private ASTExp<E> exp;

    public SMPLExp(ASTExp<E> exp) {
        super(exp.getType());
        this.exp = exp;
    }

    public SMPLExp(SMPLExp exp) {
        super(exp.getExp().getType());
        this.exp = exp.getExp();
    }

    public ASTExp<E> getExp() {
        return exp;
    }

    public Class<?> getExpType() {
        return exp.getClass();
    }

    public <S, T> T visit(SMPLVisitor<SMPLExp<E>, S, T> v, S state) throws SMPLException {
        return v.visitSMPLExp(this, state);
    }

    @Override
    public <S, T> T visit(ASTVisitor<SMPLExp<E>, S, T> v, S state) throws SMPLException {
        return visit((SMPLVisitor<E, S, T>) v, state);
    }

    

}
