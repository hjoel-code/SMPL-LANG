package smpl.lang.statements;

import smpl.sys.*;
import smpl.lang.ASTExp;
import smpl.lang.visitors.ASTVisitor;
import smpl.lang.visitors.StatementVisitor;

public abstract class SMPLStatement extends ASTExp<SMPLStatement> {

    public abstract <S, T> T visit(StatementVisitor<SMPLStatement, S, T> v, S state) throws SMPLException;


    @Override
    public <S, T> T visit(ASTVisitor<SMPLStatement, S, T> v, S state) throws SMPLException {
        return visit( (StatementVisitor<SMPLStatement, S, T>) v, state);
    }
    
}