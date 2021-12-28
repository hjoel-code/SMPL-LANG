package smpl.lang.compound;

import smpl.lang.SMPLExp;
import smpl.lang.visitors.*;
import smpl.sys.SMPLException;

public class PairExp extends CompoundExp {

    private SMPLExp exp1;
    private SMPLExp exp2;


    public PairExp(SMPLExp exp1, SMPLExp exp2) {
        super("pair");
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public SMPLExp getExp1() {
        return exp1;
    }

    public SMPLExp getExp2() {
        return exp2;
    }

    @Override
    public String getType() {
        return super.getType();
    }

    
    public <S, T> T visit(CompoundVisitor<CompoundExp, S, T> v, S state) throws SMPLException {
        return v.visitPairExp(this, state);
    }
    
}
