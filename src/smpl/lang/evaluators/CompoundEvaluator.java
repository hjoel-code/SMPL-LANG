package smpl.lang.evaluators;

import smpl.lang.ASTBinaryExp;
import smpl.lang.ASTUnaryExp;
import smpl.lang.ASTVar;
import smpl.lang.SMPLProgram;
import smpl.lang.StmtSequence;
import smpl.lang.compound.CompoundExp;
import smpl.lang.compound.PairExp;
import smpl.lang.visitors.CompoundVisitor;
import smpl.sys.SMPLEnvironment;
import smpl.sys.SMPLException;
import smpl.values.type.compound.*;
import smpl.values.SMPLData;

public class CompoundEvaluator
        implements CompoundVisitor<CompoundExp, SMPLEnvironment<SMPLData<SMPLCompound>>, SMPLData<SMPLCompound>> {

    private ASTEvaluator eval;

    public CompoundEvaluator(ASTEvaluator eval) {
        this.eval = eval;
    }

    @Override
    public SMPLData<SMPLCompound> visitSMPLProgram(SMPLProgram sp, SMPLEnvironment<SMPLData<SMPLCompound>> arg)
            throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SMPLData<SMPLCompound> visitStmtSequence(StmtSequence seq, SMPLEnvironment<SMPLData<SMPLCompound>> state)
            throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SMPLData<SMPLCompound> visitASTVar(ASTVar<CompoundExp> var, SMPLEnvironment<SMPLData<SMPLCompound>> state)
            throws SMPLException {
        return state.get(var.getVar());
    }

    @Override
    public SMPLData<SMPLCompound> visitASTBinaryExp(ASTBinaryExp biExp, SMPLEnvironment<SMPLData<SMPLCompound>> state)
            throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SMPLData<SMPLCompound> visitASTUnaryExp(ASTUnaryExp urExp, SMPLEnvironment<SMPLData<SMPLCompound>> state)
            throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SMPLData<SMPLCompound> visitPairExp(PairExp pair, SMPLEnvironment<SMPLData<SMPLCompound>> state)
            throws SMPLException {

        if (pair.getContext().equals("var")) {
            return pair.getVarExp().visit(this, state);
        } else {
            SMPLData exp1 = (SMPLData) pair.getObj1().eval(state.getContext(), eval.getObjectEvaluator());
            SMPLData exp2 = (SMPLData) pair.getObj2().eval(state.getContext(), eval.getObjectEvaluator());

            Pair compoundPair = new Pair(exp1, exp2);
            return new SMPLData<SMPLCompound>(compoundPair, "pair");
        }
    }

}
