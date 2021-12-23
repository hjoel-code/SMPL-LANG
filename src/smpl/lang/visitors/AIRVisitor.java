package smpl.lang.visitors;

import smpl.sys.SMPLException;
import smpl.lang.visitors.*;
import smpl.lang.*;

/**
 * Visitor interface for arithmetic expressions within SMPL contexts
 * @author Daniel Coore <daniel.coore@uwimona.edu.jm>
 * @param <S> The type of the state used by the visitor
 * @param <T> The type returned by the visitor
 */
public interface AIRVisitor<S, T>  extends ASTVisitor<AIRExp, S, T> {
    /* Arithmetic expressions */

    /**
     * Carry out the approrpriate operations for visiting an integer expression.
     * @param exp The integer valued expression being visited
     * @param state The state needed by this visitor.
     * @return The result of visiting the integer expression.
     * @throws SMPLException if an error is encountered.
     */
    public T visitAIRExpInt(AIRExpInt exp, S state) throws SMPLException;
}