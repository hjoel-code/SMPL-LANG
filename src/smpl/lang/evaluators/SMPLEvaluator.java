package smpl.lang.evaluators;

import smpl.sys.*;
import smpl.values.*;
import java.util.*;
import smpl.lang.visitors.*;
import smpl.lang.*;

public class SMPLEvaluator implements SMPLVisitor<SMPLContext, SMPLPrimitive> {
  private final ArithEvaluator arithEval;
  protected Double result; // result of evaluation
  private Double defaultValue;
  private Class<Double> myClass; 
  SMPLPrimitive lastResult;

  protected SMPLEvaluator() {
    this.arithEval = new ArithEvaluator();
    lastResult = new SMPLPrimitive<Double>(0D);
  }

  public SMPLPrimitive getResult() {
    return lastResult;
  }

  public SMPLEvaluator(Double defaultValue) {
    // this.defaultValue = defaultVal;
    // myClass = Double.class;
    // result = defaultValue;
  }

  @Override
  public SMPLPrimitive visitSMPLProgram(SMPLProgram sp, SMPLContext arg) 
    throws SMPLException {
    StmtSequence stmts = sp.getSeq();

    return stmts.visit(this, arg);
  }

  /**
   * @return a freshly created global context suitable for visiting top level
   * expressions.
   */
  public SMPLContext mkInitialContext() {
    // throw new UnsupportedOperationException("Implement this to return a new global context");    
      return new SMPLCompositer(new SMPLEnvironment<Double>(), new SMPLEnvironment<SMPLFunction>());
  }

  public SMPLPrimitive visitStmtSequence(StmtSequence seq, SMPLContext state) throws SMPLException {
    return new SMPLPrimitive<Double>(0D);
  }

  public SMPLPrimitive vistSMPLAssignment(SMPLAssignment assignment, SMPLContext state) throws SMPLException {
    return new SMPLPrimitive<Double>(0D);
  }

  public SMPLPrimitive visitSMPLStatement(SMPLStatement smplStatement, SMPLContext state) throws SMPLException {
    return new SMPLPrimitive<Double>(0D);
  }
}