package smpl.lang;

import smpl.lang.Visitors.ASTVisitor;

public class SMPLAssignment extends SMPLProgram {
    

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

    public <S, T> T visit(ASTVisitor<SMPLProgram, S, T> v, S state) throws Exception {
        // TODO Auto-generated method stub
        return super.visit(v, state);
    }

    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
