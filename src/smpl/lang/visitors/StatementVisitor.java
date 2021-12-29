package smpl.lang.visitors;

import smpl.lang.ASTExp;
import smpl.lang.statements.PrintStmt;
import smpl.lang.statements.SMPLAssignment;
import smpl.lang.statements.SMPLStatement;
import smpl.sys.SMPLException;

public interface StatementVisitor<E extends ASTExp<E>, S, T> extends ASTVisitor<SMPLStatement, S, T>{

    public T visitSMPLAssignment(SMPLAssignment assignment, S state) throws SMPLException;
    public T visitPrintStmt(PrintStmt printStmt, S state) throws SMPLException;
    
}
