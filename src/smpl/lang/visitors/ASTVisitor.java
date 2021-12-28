package smpl.lang.visitors;

import smpl.sys.SMPLException;
import smpl.lang.*;

/**
 *
 * @author Daniel Coore <daniel.coore@uwimona.edu.jm>
 * @param <E> The type of subexpression that will be visited.
 * @param <S> The type of the context needed by this visitor
 * @param <T> The return type of the result of visiting nodes
 */
public interface ASTVisitor<E extends ASTExp<E>, S, T>  {

    public T visitSMPLProgram(SMPLProgram sp, S arg) throws SMPLException;
    public T visitStmtSequence(StmtSequence seq, S state) throws SMPLException;

}
