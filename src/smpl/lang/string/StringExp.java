package smpl.lang.string;

import smpl.sys.SMPLException;
import smpl.lang.ASTExp;
import smpl.lang.SMPLObject;
import smpl.lang.visitors.*;

public abstract class StringExp extends ASTExp<StringExp> implements SMPLObject {

    private String type;

    public StringExp() {
        this.type = "string";
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    public abstract <S, T> T visit(StringVisitor<StringExp, S, T> v, S state) throws SMPLException;

    @Override
    public <S, T> T visit(ASTVisitor<StringExp, S, T> v, S state) throws SMPLException {
        return visit( (StringVisitor<StringExp, S, T>) v, state);
    }

}
