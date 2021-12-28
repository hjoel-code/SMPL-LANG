package smpl.lang.evaluators;

import java.util.ArrayList;

import smpl.lang.*;
import smpl.lang.statements.SMPLStatement;
import smpl.lang.visitors.ASTVisitor;
import smpl.sys.SMPLException;
import smpl.values.SMPLPrimitive;
import smpl.sys.SMPLContext;

public class ASTEvaluator implements ASTVisitor<SMPLProgram, SMPLContext, SMPLPrimitive> {

    // Evaluators
    private ArithEvaluator arithEval;
    private BoolEvaluator boolEval;
    private StringEvaluator strEval;
    private CompoundEvaluator compoundEval;
    private StatementEvaluator stmtEval;
    private SMPLEvaluator smplStmt;
    private CharacterEvaluator charEval;

    private SMPLPrimitive lastResult;

    public ASTEvaluator() {
        arithEval = new ArithEvaluator(this);
        boolEval = new BoolEvaluator(this);
        strEval = new StringEvaluator(this);
        compoundEval = new CompoundEvaluator(this);
        stmtEval = new StatementEvaluator(this);
        smplStmt = new SMPLEvaluator<>(this);
        charEval = new CharacterEvaluator(this);

        lastResult = new SMPLPrimitive();
    }

    public ArithEvaluator getArithEval() {
        return arithEval;
    }

    public BoolEvaluator getBoolEval() {
        return boolEval;
    }

    public StringEvaluator getStrEval() {
        return strEval;
    }

    public CompoundEvaluator getCompoundEval() {
        return compoundEval;
    }

    public StatementEvaluator getStmtEval() {
        return stmtEval;
    }

    public SMPLEvaluator getSmplStmt() {
        return smplStmt;
    }

    public CharacterEvaluator getCharEval() {
        return charEval;
    }

    public SMPLContext  mkInitialContext() {
        return new SMPLMainEnvironment();
    }


    @Override
    public SMPLPrimitive visitSMPLProgram(SMPLProgram sp, SMPLContext arg) throws SMPLException {
        StmtSequence seq = sp.getSeq();
        return seq.visit(this, arg);
    }

    @Override
    public SMPLPrimitive visitStmtSequence(StmtSequence seq, SMPLContext state)
            throws SMPLException {

        ArrayList<SMPLStatement> stmts = seq.getStatements();
        SMPLPrimitive result = lastResult;

        result.resetPrimitive();

        for (SMPLStatement stmt : stmts) {
            String str = stmt.visit(getStmtEval(), state).toString();
            result.appendToPrimitive(str);
        }

        lastResult = result;
        return result;
    }

    public SMPLPrimitive getResult() {
        return lastResult;
    }
}
