package smpl.lang.evaluators;

import smpl.lang.ASTExp;
import smpl.lang.ASTVar;
import smpl.lang.SMPLExp;
import smpl.lang.SMPLProgram;
import smpl.lang.StmtSequence;
import smpl.lang.compound.Car;
import smpl.lang.compound.CompoundExp;
import smpl.lang.compound.PairExp;
import smpl.lang.statements.PrintStmt;
import smpl.lang.statements.SMPLAssignment;
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

    public ASTEvaluator getEval() {
        return eval;
    }

    @Override
    public SMPLData<SMPLCompound> visitPairExp(PairExp pair,
            SMPLEnvironment<SMPLData<SMPLCompound>> state) throws SMPLException {
        SMPLData exp1 = (SMPLData) pair.getExp1().visit(eval.getSmplStmt(), state.getContext());
        SMPLData exp2 = (SMPLData) pair.getExp2().visit(eval.getSmplStmt(), state.getContext());

        Pair compoundPair = new Pair(exp1, exp2);
        return new SMPLData<SMPLCompound>(compoundPair);
    }

    @Override
    public SMPLData<SMPLCompound> visitSMPLProgram(SMPLProgram sp, SMPLEnvironment<SMPLData<SMPLCompound>> arg)
            throws SMPLException {
        return null;
    }

    @Override
    public SMPLData<SMPLCompound> visitStmtSequence(StmtSequence seq, SMPLEnvironment<SMPLData<SMPLCompound>> state)
            throws SMPLException {
        return null;
    }

    @Override
    public <A extends ASTExp<A>> SMPLData<SMPLCompound> visitSMPLAssignment(SMPLAssignment<A> assignment,
            SMPLEnvironment<SMPLData<SMPLCompound>> state) throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <A extends ASTExp<A>> SMPLData<SMPLCompound> visitPrintStmt(PrintStmt<A> printStmt,
            SMPLEnvironment<SMPLData<SMPLCompound>> state) throws SMPLException {
        return null;
    }

    @Override
    public <A extends ASTExp<A>> SMPLData<SMPLCompound> visitASTVar(ASTVar<A> var,
            SMPLEnvironment<SMPLData<SMPLCompound>> state) throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

}
