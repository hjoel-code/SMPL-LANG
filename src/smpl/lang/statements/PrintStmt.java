package smpl.lang.statements;


import smpl.lang.SMPLObject;
import smpl.lang.visitors.StatementVisitor;
import smpl.sys.SMPLException;

public class PrintStmt extends SMPLStatement {
    
    private SMPLObject exp;

    public PrintStmt(SMPLObject exp) {
        this.exp = exp;
    }

    public SMPLObject getExp() {
        return exp;
    }

    @Override
    public <S, T> T visit(StatementVisitor<SMPLStatement, S, T> v, S state) throws SMPLException {
        return v.visitPrintStmt(this, state);
    }

    

    
    
}
