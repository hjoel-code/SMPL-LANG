package smpl.lang.evaluators;

import smpl.lang.ASTExp;
import smpl.lang.ASTVar;
import smpl.lang.SMPLProgram;
import smpl.lang.string.StringExp;
import smpl.lang.string.StringLit;
import smpl.lang.StmtSequence;
import smpl.lang.statements.PrintStmt;
import smpl.lang.statements.SMPLAssignment;
import smpl.lang.visitors.StringVisitor;
import smpl.sys.SMPLException;

import smpl.values.*;

import smpl.sys.SMPLEnvironment;

public class StringEvaluator implements StringVisitor<StringExp, SMPLEnvironment<SMPLData<String>>, SMPLData<String>> {
    

    private ASTEvaluator eval;


    public StringEvaluator(ASTEvaluator eval) {
        this.eval = eval;
    }



    @Override
    public SMPLData<String> visitStringLit(StringLit str, SMPLEnvironment<SMPLData<String>> state)
            throws SMPLException {
        return new SMPLData<String>(str.getStr());
    }



    @Override
    public SMPLData<String> visitSMPLProgram(SMPLProgram sp, SMPLEnvironment<SMPLData<String>> arg)
            throws SMPLException {
        return null;
    }


    @Override
    public SMPLData<String> visitStmtSequence(StmtSequence seq, SMPLEnvironment<SMPLData<String>> state)
            throws SMPLException {
        return null;
    }



    @Override
    public <A extends ASTExp<A>> SMPLData<String> visitSMPLAssignment(SMPLAssignment<A> assignment,
            SMPLEnvironment<SMPLData<String>> state) throws SMPLException {
        return null;
    }



    @Override
    public <A extends ASTExp<A>> SMPLData<String> visitPrintStmt(PrintStmt<A> printStmt,
            SMPLEnvironment<SMPLData<String>> state) throws SMPLException {
        return null;
    }



    @Override
    public <A extends ASTExp<A>> SMPLData<String> visitASTVar(ASTVar<A> var, SMPLEnvironment<SMPLData<String>> state)
            throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

}
