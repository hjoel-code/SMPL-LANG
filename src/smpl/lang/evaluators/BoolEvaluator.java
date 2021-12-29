package smpl.lang.evaluators;

import java.util.HashMap;

import smpl.lang.bool.BoolCalc;
import smpl.lang.bool.BoolExp;
import smpl.lang.bool.BoolLit;
import smpl.lang.visitors.BoolVisitor;
import smpl.sys.SMPLEnvironment;
import smpl.sys.SMPLException;
import smpl.values.SMPLData;
import smpl.lang.ASTBinaryExp;
import smpl.lang.ASTUnaryExp;
import smpl.lang.ASTVar;
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

    @Override
    public SMPLData<SMPLBool> visitSMPLProgram(SMPLProgram sp, SMPLEnvironment<SMPLData<SMPLBool>> arg)
            throws SMPLException {
        return null;
    }

    @Override
    public SMPLData<SMPLBool> visitStmtSequence(StmtSequence seq, SMPLEnvironment<SMPLData<SMPLBool>> state)
            throws SMPLException {
        return null;
    }

    @Override
    public SMPLData<SMPLBool> visitASTVar(ASTVar<BoolExp> var, SMPLEnvironment<SMPLData<SMPLBool>> state)
            throws SMPLException {
        return state.get(var.getVar());
    }

    @Override
    public SMPLData<SMPLBool> visitASTBinaryExp(ASTBinaryExp biExp, SMPLEnvironment<SMPLData<SMPLBool>> state)
            throws SMPLException {

        String type = biExp.getExp1().getType();

        if (type.equals("arith")) {

            String opName = biExp.getOperator();
            BoolOps op = boolOps.get(opName);

            AIRExp leftExp = (AIRExp) biExp.getExp1();
            AIRExp rightExp = (AIRExp) biExp.getExp2();

            double leftArg = leftExp.visit(eval.getArithEval(), state.getContext().getAritEnvironment()).getVal()
                    .getVal();
            double rightArg = rightExp.visit(eval.getArithEval(), state.getContext().getAritEnvironment()).getVal()
                    .getVal();

            return new SMPLData<SMPLBool>(new SMPLBool(op.apply(leftArg, rightArg)), "bool");

        } else {

            String opName = biExp.getOperator();
            LogicOps op = logicOps.get(opName);

            BoolExp leftExp = (BoolExp) biExp.getExp1();
            BoolExp rightExp = (BoolExp) biExp.getExp2();

            boolean leftArg = leftExp.visit(this, state).getVal().getVal();
            boolean rightArg = rightExp.visit(this, state).getVal().getVal();

            return new SMPLData<SMPLBool>(new SMPLBool(op.apply(leftArg, rightArg)), "bool");
        }
    }

    @Override
    public SMPLData<SMPLBool> visitASTUnaryExp(ASTUnaryExp urExp, SMPLEnvironment<SMPLData<SMPLBool>> state)
            throws SMPLException {

        String opName = urExp.getOperator();
        BoolOps op = boolOps.get(opName);

        AIRExp leftExp = (AIRExp) urExp.getExp();

        double leftArg = leftExp.visit(eval.getArithEval(), state.getContext().getAritEnvironment()).getVal()
                .getVal();

        return new SMPLData<SMPLBool>(new SMPLBool(op.apply(leftArg, null)), "bool");
    }

    @Override
    public SMPLData<SMPLBool> visitBoolLit(BoolLit exp, SMPLEnvironment<SMPLData<SMPLBool>> state)
            throws SMPLException {
        return exp.getContext().equals("var") ? exp.getVarExp().visit(this, state)
                : new SMPLData<SMPLBool>(new SMPLBool(exp.getBool()), "bool");
    }

    @Override
    public SMPLData<SMPLBool> visitBoolCalc(BoolCalc exp, SMPLEnvironment<SMPLData<SMPLBool>> state)
            throws SMPLException {
        if (exp.getCalcType().equals("binary")) {
            return exp.getBinary().visit(this, state);
        } else {
            return exp.getUnary().visit(this, state);
        }
    }

}
