package smpl.lang.compound;

import smpl.lang.ASTExp;
import smpl.lang.SMPLExp;
import smpl.lang.visitors.SMPLVisitor;
import smpl.sys.SMPLException;

public class Car<E extends ASTExp<E>> extends SMPLExp<E> {

    
    public Car(ASTExp exp) {
        super(exp);
        System.out.println(super.getType());
    }

    @Override
    public <S, T> T visit(SMPLVisitor<SMPLExp<E>, S, T> v, S state) throws SMPLException {
        return v.visitCARExp(this, state);
    }

}
