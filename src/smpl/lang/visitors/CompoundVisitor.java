package smpl.lang.visitors;

import smpl.sys.SMPLException;
import smpl.lang.ASTExp;
import smpl.lang.compound.PairExp;

public interface CompoundVisitor<E extends ASTExp<E>, S, T> extends StmtVisitor<E,S,T>  {
    
    public T visitPairExp(PairExp pair, S state) throws SMPLException;
    
}
