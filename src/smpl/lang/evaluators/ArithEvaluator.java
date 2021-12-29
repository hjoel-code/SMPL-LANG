package smpl.lang.evaluators;

import java.util.HashMap;

import smpl.lang.visitors.AIRVisitor;
import smpl.sys.*;
import smpl.values.SMPLData;
import smpl.values.type.simple.*;
import smpl.lang.*;
import smpl.lang.arith.AIRExp;
import smpl.lang.arith.AIRLit;
import smpl.lang.arith.ArithCalc;

/**
 * An evaluator for arithmetic subexpressions of SMPL programs.
 */

public class ArithEvaluator implements AIRVisitor<AIRExp, SMPLEnvironment<SMPLData<SMPLArith>>, SMPLData<SMPLArith>> {
    
    
    HashMap<String, UnOpArith> unOpsMap;
    HashMap<String, BinOpArith> binOpsMap;

    private ASTEvaluator eval;

    public ArithEvaluator(ASTEvaluator eval) {
        this.eval = eval;
        init();
    }

    private void init() {
        unOpsMap = new HashMap<>();
        for (UnOpArith op : UnOpArith.values()) {
            unOpsMap.put(op.getSymbol(), op);
        }

        binOpsMap = new HashMap<>();
        for (BinOpArith op : BinOpArith.values()) {
            binOpsMap.put(op.getSymbol(), op);
        }
    }

    @Override
    public SMPLData<SMPLArith> visitAIRExpInt(AIRLit exp, SMPLEnvironment<SMPLData<SMPLArith>> state)
            throws SMPLException {
        return exp.getContext().equals("var") ? exp.getVarExp().visit(this, state) : new SMPLData<SMPLArith>(new SMPLArith(exp.getVal(), exp.getRep()), "arith");
    }

    @Override
    public SMPLData<SMPLArith> visitASTBinaryExp(ASTBinaryExp exp,
            SMPLEnvironment<SMPLData<SMPLArith>> state) throws SMPLException {
        String opName = exp.getOperator();
        BinOpArith op = binOpsMap.get(opName);

        AIRExp leftExp = (AIRExp) exp.getExp1();
        AIRExp rightExp = (AIRExp) exp.getExp2();

        double leftArg = leftExp.visit(this, state).getVal().getVal();
        double rightArg = rightExp.visit(this, state).getVal().getVal();

        return new SMPLData<SMPLArith>(new SMPLArith(op.apply(leftArg, rightArg)), "arith");
    }

    @Override
    public SMPLData<SMPLArith> visitASTUnaryExp(ASTUnaryExp exp, SMPLEnvironment<SMPLData<SMPLArith>> state)
            throws SMPLException {
        String opName = exp.getOperator();
        UnOpArith op = unOpsMap.get(opName);
        AIRExp argExp =  (AIRExp) exp.getExp();
        double arg = argExp.visit(this, state).getVal().getVal();
        return new SMPLData<SMPLArith>(new SMPLArith(op.apply(arg)), "arith");
    }

    @Override
    public SMPLData<SMPLArith> visitSMPLProgram(SMPLProgram sp, SMPLEnvironment<SMPLData<SMPLArith>> arg)
            throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SMPLData<SMPLArith> visitStmtSequence(StmtSequence seq, SMPLEnvironment<SMPLData<SMPLArith>> state)
            throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SMPLData<SMPLArith> visitASTVar(ASTVar<AIRExp> var, SMPLEnvironment<SMPLData<SMPLArith>> state)
            throws SMPLException {
        return state.get(var.getVar());
    }

    @Override
    public SMPLData<SMPLArith> visitArithCalc(ArithCalc exp, SMPLEnvironment<SMPLData<SMPLArith>> state)
            throws SMPLException {
        if (exp.getCalcType().equals("binary")) {
            return exp.getBinary().visit(this, state);
        } else {
            return exp.getUnary().visit(this, state);
        }
    }

}
