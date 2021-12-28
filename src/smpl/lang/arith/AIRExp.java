package smpl.lang.arith;

import smpl.sys.*;
import smpl.lang.ASTExp;
import smpl.lang.visitors.*;

public abstract class AIRExp extends ASTExp<AIRExp> {

  private String aType;

  public AIRExp(String type) {
    super("arith");
    this.aType = type;
  }

  public String getaType() {
    return aType;
  }

  public abstract <S, T> T visit(AIRVisitor<AIRExp, S, T> v, S state) throws SMPLException;

  @Override
  public <S, T> T visit(ASTVisitor<AIRExp, S, T> v, S state) throws SMPLException {
    return visit((AIRVisitor<AIRExp, S, T>) v, state);
  }

}
