package smpl.lang.statements;

import smpl.sys.*;
import smpl.lang.SMPLProgram;
import smpl.lang.visitors.StmtVisitor;

public interface SMPLStatement {
    

    public <S, T> T visit(StmtVisitor<SMPLProgram, S, T> v, S state) throws SMPLException;

}