package smpl.lang;

import smpl.lang.visitors.*;
import smpl.sys.*;
import smpl.lang.evaluators.ASTEvaluator;
import smpl.values.SMPLPrimitive;

public class SMPLProgram extends ASTExp<SMPLProgram> {
    protected StmtSequence stmts;


    public SMPLProgram(StmtSequence stmts) {
        this.stmts = stmts;
    }

    public StmtSequence getSeq() {
        return stmts;
    }

    public <S, T> T visit(ASTVisitor<SMPLProgram, S, T> v, S state) throws SMPLException {
        return v.visitSMPLProgram(this, state);
    }

    /**
     * Execute the instructions in this program with respect to a
     * fresh environment.
     *
     * @param interpreter The interpreter to be used to run this program
     * @return the <code>SMPLPrimitive</code> that results from evaluating
     * the last statement in the sequence of instructions in this
     * program.
     */
    public SMPLPrimitive run(ASTEvaluator interpreter) {
        try {
            SMPLContext state = interpreter.mkInitialContext();
            this.visit(interpreter, state);
            return interpreter.getResult();
        } catch (SMPLException smple) {
            System.out.println("Error encountered: " + smple.report());
            return null;
        }
    }
}   
