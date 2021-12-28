package smpl.lang.statements;

import smpl.lang.ASTExp;
import smpl.lang.SMPLExp;
import smpl.lang.SMPLProgram;
import smpl.lang.visitors.*;
import smpl.sys.*;

public class SMPLAssignment<E extends ASTExp<E>> extends ASTExp<E> implements SMPLStatement {
    
    protected String var;
    protected SMPLExp<E> exp;
    
    public SMPLAssignment(String id, SMPLExp<E> exp) {
        super("assign");
        this.var = id;
        this.exp = exp;
    }

    public String getVar() {
        return this.var;
    }

    public SMPLExp<E> getExp() {
        return this.exp;
    }

    @Override
    public <S, T> T visit(StmtVisitor<SMPLProgram, S, T> v, S state) throws SMPLException {
        return v.visitSMPLAssignment(this, state);
    }

    @Override
    public <S, T> T visit(ASTVisitor<E, S, T> v, S state) throws SMPLException {
        return visit((StmtVisitor<E, S, T>) v, state);
    }
}
