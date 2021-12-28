package smpl.lang.statements;

import smpl.lang.ASTExp;
import smpl.lang.SMPLExp;
import smpl.lang.SMPLProgram;
import smpl.lang.visitors.ASTVisitor;
import smpl.lang.visitors.StmtVisitor;
import smpl.sys.SMPLException;

public class PrintStmt<E extends ASTExp<E>> extends ASTExp<E> implements SMPLStatement {
    
    private SMPLExp<E> exp;

    public PrintStmt(SMPLExp<E> exp) {
        super("print");
        this.exp = exp;
    }

    public SMPLExp<E> getExp() {
        return exp;
    }

    @Override
    public <S, T> T visit(StmtVisitor<SMPLProgram, S, T> v, S state) throws SMPLException {
        return v.visitPrintStmt(this, state);
    }
 
    @Override
    public <S, T> T visit(ASTVisitor<E, S, T> v, S state) throws SMPLException {
        return visit( (StmtVisitor<E, S, T>) v, state);
    }
}
