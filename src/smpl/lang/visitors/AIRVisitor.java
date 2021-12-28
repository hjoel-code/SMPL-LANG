package smpl.lang.visitors;

import smpl.sys.SMPLException;
import smpl.lang.*;
import smpl.lang.arith.AIRLit;
import smpl.lang.arith.ASTBinaryExp;
import smpl.lang.arith.ASTUnaryExp;

/**
 * Visitor interface for arithmetic expressions within SMPL contexts
 * @author Daniel Coore <daniel.coore@uwimona.edu.jm>
 * @param <S> The type of the state used by the visitor
 * @param <T> The type returned by the visitor
 */
public interface AIRVisitor<E extends ASTExp<E>, S, T> extends StmtVisitor<E,S,T>   {

    public T visitAIRExpInt(AIRLit exp, S state) throws SMPLException; 
    public T visitASTUnaryExp(ASTUnaryExp exp, S state) throws SMPLException;
    public T visitASTBinaryExp(ASTBinaryExp exp, S state) throws SMPLException;
    
}