package smpl.lang;

import smpl.lang.compound.CompoundExp;
import smpl.lang.compound.PairExp;
import smpl.lang.evaluators.ObjectEvaluator;
import smpl.sys.SMPLContext;
import smpl.sys.SMPLException;
import smpl.values.SMPLData;
import smpl.values.type.compound.Pair;
import smpl.values.type.compound.SMPLCompound;

public class CDR implements SMPLObject {

    private String type;

    private PairExp var;

    public CDR(PairExp exp) {
        this.type = "cdr";
        this.var = exp;
    }

    public CDR(CompoundExp var) {
        this.type = "cdr";
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
        return pair.getArg2();
    }

}
