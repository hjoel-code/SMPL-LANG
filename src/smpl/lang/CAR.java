package smpl.lang;

import smpl.lang.compound.CompoundExp;
import smpl.lang.compound.PairExp;
import smpl.lang.evaluators.ObjectEvaluator;
import smpl.sys.SMPLContext;
import smpl.sys.SMPLException;
import smpl.values.SMPLData;
import smpl.values.type.compound.Pair;
import smpl.values.type.compound.SMPLCompound;

public class CAR implements SMPLObject {

    private String type;

    private PairExp var;

    public CAR(PairExp exp) {
        this.type = "car";
        this.var = exp;
    }

    public CAR(CompoundExp var) {
        this.type = "car";
        this.var = (PairExp) var;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public SMPLData eval(SMPLContext state, ObjectEvaluator eval) throws SMPLException {

        SMPLData<SMPLCompound> data = var.visit(eval.getEval().getCompoundEval(), state.getCompoundTypeEnvironment());
        Pair pair = (Pair) data.getVal();
        return pair.getArg1();
    }
    
}
