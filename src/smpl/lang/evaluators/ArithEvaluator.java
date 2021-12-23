package smpl.lang.evaluators;

import java.util.HashMap;

import smpl.lang.visitors.AIRVisitor;
import smpl.sys.*;
import smpl.lang.*;

/**
 * An evaluator for arithmetic subexpressions of SMPL programs.
 */
 
public class ArithEvaluator implements AIRVisitor<SMPLEnvironment<Double>, Double> {
    HashMap<String, UnOpArith> unOpsMap;
    HashMap<String, BinOpArith> binOpsMap;
    
    public ArithEvaluator() {
        init();
    }
    
    private void init() {
        unOpsMap = new HashMap<>();
        for (UnOpArith op : UnOpArith.values()) {
            unOpsMap.put(op.getSymbol(), op);
        }
        
        binOpsMap = new HashMap<>();
        for (BinOpArith op: BinOpArith.values()) {
            binOpsMap.put(op.getSymbol(), op);
        }
    }
    
    /* Methods specific to Arithmetic expressions */
    @Override
    public Double visitAIRExpInt(AIRExpInt exp, SMPLEnvironment<Double> env) throws SMPLException {
    return new Double(exp.getVal());
    }
    
    /* Methods from the generic ASTVisitor interface */

    @Override
    public Double visitVar(ASTVar<AIRExp> var, SMPLEnvironment<Double> state) throws SMPLException {
        return state.get(var.getId());        
    }

    @Override
    public Double visitUnaryExp(ASTUnaryExp<AIRExp> exp, SMPLEnvironment<Double> env) throws SMPLException {
        String opName = exp.getOperator();
        UnOpArith op = unOpsMap.get(opName);
        ASTExp<AIRExp> argExp = exp.getExp();
        double arg = argExp.visit(this, env);
        return op.apply(arg);
    }

    @Override
    public Double visitBinaryExp(ASTBinaryExp<AIRExp> exp, SMPLEnvironment<Double> env) throws SMPLException {
        String opName = exp.getOperator();
        BinOpArith op = binOpsMap.get(opName);
        ASTExp<AIRExp> leftExp = exp.getExp1();
        ASTExp<AIRExp> rightExp = exp.getExp2();
        double leftArg = leftExp.visit(this, env);
        double rightArg = rightExp.visit(this, env);
        return op.apply(leftArg, rightArg);
    }
}
