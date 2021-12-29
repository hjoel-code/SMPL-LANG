package smpl.lang.visitors;

import smpl.lang.ASTExp;
import smpl.lang.bool.BoolCalc;
import smpl.lang.bool.BoolLit;
import smpl.sys.SMPLException;


public interface BoolVisitor<E extends ASTExp<E>, S, T> extends ASTVisitor<E,S,T>   {
    
    public T visitBoolLit(BoolLit exp, S state) throws SMPLException;
    public T visitBoolCalc(BoolCalc exp, S state) throws SMPLException;

}
