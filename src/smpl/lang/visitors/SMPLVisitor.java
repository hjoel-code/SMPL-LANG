package smpl.lang.visitors;

import smpl.lang.*;
import smpl.sys.SMPLException;
import smpl.lang.visitors.*;

public interface SMPLVisitor<S, T> extends ASTVisitor<SMPLExp, S, T> {
  public T visitSMPLProgram(SMPLProgram sp, S arg) throws SMPLException;

  public T visitStmtSequence(StmtSequence seq, S state) throws SMPLException;

  public T vistSMPLAssignment(SMPLAssignment assignment, S state) throws SMPLException;

  public T visitSMPLStatement(SMPLStatement smplStatement, S state) throws SMPLException;

  // Todo: Add other visitors here
}
