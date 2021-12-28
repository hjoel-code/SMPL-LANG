package smpl.lang.chars;

import smpl.lang.ASTExp;
import smpl.lang.visitors.ASTVisitor;
import smpl.lang.visitors.CharacterVisitor;
import smpl.sys.SMPLException;

public abstract class CharExp extends ASTExp<CharExp> {
    
    private String cType;

    public CharExp(String type) {
        super("char");
        this.cType = type;

    }

    public String getcType() {
        return cType;
    }

    public abstract <S, T> T visit(CharacterVisitor<CharExp, S, T> v, S state) throws SMPLException;


    @Override
    public <S, T> T visit(ASTVisitor<CharExp, S, T> v, S state) throws SMPLException {
        return visit((CharacterVisitor<CharExp, S, T>) v, state);
    }
}
