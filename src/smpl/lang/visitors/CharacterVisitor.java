package smpl.lang.visitors;

import smpl.lang.ASTExp;
import smpl.lang.chars.CharLit;
import smpl.sys.SMPLException;

public interface CharacterVisitor<E extends ASTExp<E>, S, T> extends ASTVisitor<E, S, T>{
    

    public T visitCharLit(CharLit ch, S state) throws SMPLException;
}
