package smpl.lang.visitors;

import smpl.lang.ASTExp;
import smpl.lang.string.StringLit;
import smpl.sys.SMPLException;

public interface StringVisitor<E extends ASTExp<E>, S, T> extends ASTVisitor<E,S,T> {


    public T visitStringLit(StringLit str, S state) throws SMPLException;

}
