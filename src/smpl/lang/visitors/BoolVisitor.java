package smpl.lang.visitors;

import smpl.lang.ASTExp;
import smpl.lang.bool.BinaryCompareExp;
import smpl.lang.bool.BoolExp;
import smpl.sys.SMPLException;


public interface BoolVisitor<E extends ASTExp<E>, S, T> extends ASTVisitor<E,S,T>   {
    
    public T visitCompareExp(BinaryCompareExp exp, S state) throws SMPLException;
    public T visitBoolExp(BoolExp exp, S state) throws SMPLException;

}
