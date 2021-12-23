package smpl.lang;

import smpl.sys.*;
import smpl.lang.visitors.SMPLVisitor;

public abstract class SMPLStatement extends ASTNode {
    /**
     * Call the <code>visitSMPLStatement</code> method in the given visitor.
     * @param <S> The type of the state used by the visitor
     * @param <T> The return type of the visitor
     * @param v The visitor visiting this node.
     * @param state The context available to the visitor at the time it 
     * encountered this statement.
     * @return The result of calling the relevant statement visiting method of the given 
     * visitor.
     * @throws smpl.sys.SMPLException     
     */
    public abstract <S, T> T visit(SMPLVisitor<S, T> v, S stage) throws SMPLException;
}
