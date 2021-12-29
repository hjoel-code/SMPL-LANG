package smpl.lang.chars;

import smpl.lang.ASTExp;
import smpl.lang.SMPLObject;
import smpl.lang.visitors.ASTVisitor;
import smpl.lang.visitors.CharacterVisitor;
import smpl.sys.SMPLException;

public abstract class CharExp extends ASTExp<CharExp> implements SMPLObject{

    private final String type;

    public CharExp() {
        this.type = "char";
    }

    @Override
    public void setType(String type) {
    }

    public String getType() {
        return type;
    }

    public abstract <S, T> T visit(CharacterVisitor<CharExp, S, T> v, S state) throws SMPLException;

    @Override
    public <S, T> T visit(ASTVisitor<CharExp, S, T> v, S state) throws SMPLException {
        return visit((CharacterVisitor<CharExp, S, T>) v, state);
    }
}
