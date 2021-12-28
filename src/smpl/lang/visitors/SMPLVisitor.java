package smpl.lang.visitors;


import smpl.lang.*;
import smpl.lang.compound.Car;
import smpl.lang.compound.Cdr;
import smpl.sys.SMPLException;

public interface SMPLVisitor<E extends ASTExp<E>, S, T> extends ASTVisitor<SMPLExp<E>,S,T>  {
    
    public <A extends ASTExp<A>> T visitSMPLExp(SMPLExp<A> exp, S state) throws SMPLException;
    public <A extends ASTExp<A>> T visitCARExp(Car<A> exp, S state) throws SMPLException;
    public <A extends ASTExp<A>> T visitCDRExp(Cdr<A> exp, S state) throws SMPLException;
    
}
