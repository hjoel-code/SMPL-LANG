package smpl.lang.bool;

import smpl.lang.ASTExp;
import smpl.lang.visitors.*;
import smpl.sys.SMPLException;

public class BoolExp extends ASTExp<BoolExp> {
    public Boolean value;
    public String bType;


    public BoolExp(Boolean value) {
        super("bool");
        this.value = value;
    }

    public BoolExp(String type) {
        super("bool");
        this.bType = type;
    }

    public Boolean getValue() {
        return value;
    }

    public String getbType() {
        return bType;
    }

    public <S, T> T visit(BoolVisitor<BoolExp, S, T> v, S state) throws SMPLException {
        return v.visitBoolExp(this, state);
    }

    @Override
    public <S, T> T visit(ASTVisitor<BoolExp, S, T> v, S state) throws SMPLException {
        return visit((BoolVisitor<BoolExp, S, T>)v, state);
    }
}
