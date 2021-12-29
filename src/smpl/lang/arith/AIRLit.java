package smpl.lang.arith;

import smpl.sys.*;
import smpl.values.SMPLData;
import smpl.values.type.simple.SMPLArith;
import smpl.lang.ASTVar;
import smpl.lang.evaluators.ObjectEvaluator;
import smpl.lang.visitors.*;

public class AIRLit extends AIRExp {

    double value;
    String context;
    String rep;

    ASTVar<AIRExp> varExp;

    public AIRLit(Double v, String rep) {
      super();
      value = v;
      this.rep = rep;
      this.context = "";
    }

    public AIRLit(Integer v, String rep) {
      super();
      value = Double.valueOf(v);
      this.rep = rep;
      this.context = "";
    }

    public AIRLit(ASTVar<AIRExp> v) {
      super();
      this.context = "var";
      this.varExp = v;
    }


    public ASTVar<AIRExp> getVarExp() {
        return varExp;
    }

    public String getContext() {
        return context;
    }

    public String getRep() {
        return rep;
    }

    public double getVal() {
      return value;
    }

    @Override
    public SMPLData<SMPLArith> eval(SMPLContext state, ObjectEvaluator eval) throws SMPLException {
        return (SMPLData<SMPLArith>) eval.eval(state, this);
    }
    

    public <S, T> T visit(AIRVisitor<AIRExp, S, T> v, S arg) throws SMPLException {
        return v.visitAIRExpInt(this, arg);
    }
}
