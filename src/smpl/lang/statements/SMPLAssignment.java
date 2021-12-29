package smpl.lang.statements;

import smpl.lang.SMPLObject;
import smpl.lang.visitors.*;
import smpl.sys.*;

public class SMPLAssignment extends SMPLStatement {
    
    protected String var;
    protected SMPLObject exp;
    
    public SMPLAssignment(String id, SMPLObject exp) {
        this.var = id;
        this.exp = exp;
    }

    public String getVar() {
        return this.var;
    }

    public void setExp(SMPLObject exp) {
        this.exp = exp;
    }

    public SMPLObject getExp() {
        return this.exp;
    }

    @Override
    public <S, T> T visit(StatementVisitor<SMPLStatement, S, T> v, S state) throws SMPLException {
        return v.visitSMPLAssignment(this, state);
    }

    
}
