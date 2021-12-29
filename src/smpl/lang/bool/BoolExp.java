package smpl.lang.bool;

import smpl.lang.ASTExp;
import smpl.lang.SMPLObject;
import smpl.lang.visitors.*;
import smpl.sys.SMPLException;

public abstract class BoolExp extends ASTExp<BoolExp> implements SMPLObject {



    private final String type;

    public BoolExp() {
        this.type = "bool";
    }

    @Override
    public void setType(String type) {
    }

    @Override
    public String getType() {
        return type;
    }

    public abstract <S, T> T visit(BoolVisitor<BoolExp, S, T> v, S state) throws SMPLException;


    @Override
    public <S, T> T visit(ASTVisitor<BoolExp, S, T> v, S state) throws SMPLException {
        return visit((BoolVisitor<BoolExp, S, T>)v, state);
    }
}


