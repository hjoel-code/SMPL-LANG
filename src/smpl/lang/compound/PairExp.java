package smpl.lang.compound;



import smpl.lang.ASTVar;
import smpl.lang.SMPLObject;
import smpl.lang.evaluators.ObjectEvaluator;
import smpl.lang.visitors.*;
import smpl.sys.SMPLContext;
import smpl.sys.SMPLException;
import smpl.values.SMPLData;
import smpl.values.type.compound.SMPLCompound;

public class PairExp extends CompoundExp  implements SMPLObject {

    private SMPLObject obj1;
    private SMPLObject obj2;
    private String context;
    private final String type;
    private ASTVar<CompoundExp> varExp;

    public PairExp(SMPLObject exp1, SMPLObject exp2) {
        this.type = "pair";
        obj1 = exp1;
        obj2 = exp2;
        this.context = "";
    }

    public PairExp(ASTVar<CompoundExp> var) {
        this.type = "pair";
        this.context = "var";
        this.varExp = var;
    }

    public String getContext() {
        return context;
    }

    public ASTVar<CompoundExp> getVarExp() {
        return varExp;
    }

    public SMPLObject getObj1() {
        return obj1;
    }

    public SMPLObject getObj2() {
        return obj2;
    }

    @Override
    public void setType(String type) {
    }

    public String getType() {
        return type;
    }

    @Override
    public SMPLData<SMPLCompound> eval(SMPLContext state, ObjectEvaluator eval) throws SMPLException {
        return eval.eval(state, this);
    }

    @Override
    public <S, T> T visit(CompoundVisitor<CompoundExp, S, T> v, S state) throws SMPLException {
        return v.visitPairExp(this, state);
    }

    
}
