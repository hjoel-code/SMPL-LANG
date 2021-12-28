package smpl.lang.arith;

import smpl.sys.*;
import smpl.lang.visitors.*;

public class AIRLit extends AIRExp {

    double value;
    String var;
    String rep;

    public AIRLit(Double v, String rep) {
      super("arithLit");
      value = v;
      this.rep = rep;
    }

    public AIRLit(Integer v, String rep) {
      super("arithLit");
      value = Double.valueOf(v);
      this.rep = rep;
    }

    public AIRLit(String var) {
      super("arithVar");
      this.var = var;
    }

    public String getVar() {
        return var;
    }

    public String getRep() {
        return rep;
    }

    public double getVal() {
      return value;
    }
    

    public <S, T> T visit(AIRVisitor<AIRExp, S, T> v, S arg) throws SMPLException {
        return v.visitAIRExpInt(this, arg);
    }
}
