package smpl.lang.evaluators;

import java.util.HashMap;

import smpl.lang.bool.BinaryCompareExp;
import smpl.lang.bool.BoolExp;
import smpl.lang.visitors.BoolVisitor;
import smpl.sys.SMPLEnvironment;
import smpl.sys.SMPLException;
import smpl.values.SMPLData;
import smpl.lang.SMPLProgram;
import smpl.lang.StmtSequence;
import smpl.lang.arith.AIRExp;
import smpl.values.type.simple.*;

public class BoolEvaluator implements BoolVisitor<BoolExp, SMPLEnvironment<SMPLData<SMPLBool>>, SMPLData<SMPLBool>> {

    private final ASTEvaluator eval;

    private HashMap<String, BoolOps> boolOps;
    private HashMap<String, LogicOps> logicOps;

    public BoolEvaluator(ASTEvaluator eval) {
        this.eval = eval;

        boolOps = new HashMap<>();
        for (BoolOps op : BoolOps.values()) {
            boolOps.put(op.getSymbol(), op);
        }

        logicOps = new HashMap<>();
        for (LogicOps op : LogicOps.values()) {
            logicOps.put(op.getSymbol(), op);
        }
    }

    public SMPLData<SMPLBool> visitCompareExp(BinaryCompareExp exp, SMPLEnvironment<SMPLData<SMPLBool>> state) throws SMPLException {
        String type = exp.getbType();

        if (type.equals("logic")) {
            String opName = exp.getOp();
            LogicOps op = logicOps.get(opName);
            
            BoolExp leftExp = exp.getLeftBool();
            BoolExp rightExp = exp.getRightBool();

            Boolean leftArg = leftExp.visit(this, state).getVal().getVal();
            boolean rightArg = rightExp.visit(this, state).getVal().getVal();

            return new SMPLData<SMPLBool>(new SMPLBool(op.apply(leftArg, rightArg)));

        } else if (type.equals("binary")) {
            String opName = exp.getOp();
            BoolOps op = boolOps.get(opName);
            
            AIRExp leftExp = exp.getLeftArith();
            AIRExp rightExp = exp.getRightArith();

            double leftArg = leftExp.visit(eval.getArithEval(), state.getContext().getAritEnvironment()).getVal().getVal();
            double rightArg = rightExp.visit(eval.getArithEval(), state.getContext().getAritEnvironment()).getVal().getVal();

            return new SMPLData<SMPLBool>(new SMPLBool(op.apply(leftArg, rightArg)));
        } else {
            String opName = exp.getOp();
            LogicOps op = logicOps.get(opName);
            
            BoolExp leftExp = exp.getLeftBool();

            Boolean leftArg = leftExp.visit(this, state).getVal().getVal();

            return new SMPLData<SMPLBool>(new SMPLBool(op.apply(leftArg, null)));
        }
    }

    // public SMPLData<SMPLBool> visitLogicExp(ASTBinaryExp exp, SMPLEnvironment<SMPLData<SMPLBool>> state) throws SMPLException {
    //     String opName = exp.getOperator();
    //     LogicOps op = logicOps.get(opName);

    //     BoolExp leftExp = (BoolExp) exp.getExp1();
    //     BoolExp rightExp = (BoolExp) exp.getExp2();

    //     boolean leftArg = leftExp.visit(this, state).getVal().getVal();
    //     boolean rightArg = rightExp.visit(this, state).getVal().getVal();

    //     return new SMPLData<SMPLBool>(new SMPLBool(op.apply(leftArg, rightArg)));
    // }

    @Override
    public SMPLData<SMPLBool> visitSMPLProgram(SMPLProgram sp, SMPLEnvironment<SMPLData<SMPLBool>> arg) throws SMPLException {
        return null;
    }

    @Override
    public SMPLData<SMPLBool> visitStmtSequence(StmtSequence seq, SMPLEnvironment<SMPLData<SMPLBool>> state) throws SMPLException {
        return null;
    }

    @Override
    public SMPLData<SMPLBool> visitBoolExp(BoolExp exp, SMPLEnvironment<SMPLData<SMPLBool>> state)
            throws SMPLException {
        return new SMPLData<SMPLBool>(new SMPLBool(exp.getValue()));
    }


    

}
