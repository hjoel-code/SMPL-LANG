package smpl.lang.arith;

import smpl.sys.*;
import smpl.lang.ASTExp;
import smpl.lang.SMPLObject;
import smpl.lang.visitors.*;

public abstract class AIRExp extends ASTExp<AIRExp> implements SMPLObject {

  private final String type;

  public AIRExp() {
    this.type = "arith";
  }

  @Override
    public void setType(String type) {
    }


  @Override
  public String getType() {
      return type;
  }

  public abstract <S, T> T visit(AIRVisitor<AIRExp, S, T> v, S state) throws SMPLException;

  @Override
  public <S, T> T visit(ASTVisitor<AIRExp, S, T> v, S state) throws SMPLException {
    return visit((AIRVisitor<AIRExp, S, T>) v, state);
  }

}
