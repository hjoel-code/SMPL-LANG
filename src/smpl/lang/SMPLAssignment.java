package smpl.lang;

import smpl.lang.visitors.*;
import smpl.sys.*;
import smpl.values.*;

public class SMPLAssignment extends SMPLStatement {
    protected String var;
    protected ASTExp<SMPLExp> exp;
    
    public SMPLAssignment(String id, ASTExp<SMPLExp> exp) {
        this.var = id;
        this.exp = exp;
    }

    public String getVar() {
        return this.var;
    }

    public ASTExp<SMPLExp> getExp() {
        return this.exp;
    }

    @Override
    public <S, T> T visit(SMPLVisitor<S, T> v, S arg) throws SMPLException {
        return v.visitSMPLAssignment(this, arg);
    }

    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
