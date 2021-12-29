package smpl.lang.bool;

import smpl.lang.ASTVar;
import smpl.lang.evaluators.ObjectEvaluator;
import smpl.lang.visitors.BoolVisitor;
import smpl.sys.SMPLContext;
import smpl.sys.SMPLException;
import smpl.values.SMPLData;
import smpl.values.type.simple.SMPLBool;

public class BoolLit extends BoolExp{
    

    private Boolean bool;
    private ASTVar<BoolExp> varExp;
    private String context;


    public BoolLit(Boolean bool) {
        super();
        this.bool = bool;
        this.context = "";
    }

    public BoolLit(ASTVar<BoolExp> var) {
        super();
        varExp = var;
        context = "var";
    }

    public String getContext() {
        return context;
    }


    public ASTVar<BoolExp> getVarExp() {
        return varExp;
    }

    public Boolean getBool() {
        return bool;
    }

    @Override
    public SMPLData<SMPLBool> eval(SMPLContext state, ObjectEvaluator eval) throws SMPLException {
        return eval.eval(state, this);
    }

    @Override
    public <S, T> T visit(BoolVisitor<BoolExp, S, T> v, S state) throws SMPLException {
        return v.visitBoolLit(this, state);
    }
}
