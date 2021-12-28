package smpl.lang.visitors;

import smpl.lang.ASTExp;
import smpl.lang.ASTVar;
import smpl.lang.statements.PrintStmt;
import smpl.lang.statements.SMPLAssignment;
import smpl.sys.SMPLException;

public interface StmtVisitor<E extends ASTExp<E>, S, T> extends ASTVisitor<E, S, T>{

    public <A extends ASTExp<A>> T visitSMPLAssignment(SMPLAssignment<A> assignment, S state) throws SMPLException;
    public <A extends ASTExp<A>> T visitPrintStmt(PrintStmt<A> printStmt, S state) throws SMPLException;
    public <A extends ASTExp<A>> T visitASTVar(ASTVar<A> var, S state) throws SMPLException;
    
}
