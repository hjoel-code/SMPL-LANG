package smpl.lang.evaluators;





import smpl.lang.ASTBinaryExp;
import smpl.lang.ASTUnaryExp;
import smpl.lang.ASTVar;
import smpl.lang.SMPLProgram;
import smpl.lang.string.StringExp;
import smpl.lang.string.StringLit;
import smpl.lang.StmtSequence;
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
    public SMPLData<String> visitSMPLProgram(SMPLProgram sp, SMPLEnvironment<SMPLData<String>> arg)
            throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SMPLData<String> visitStmtSequence(StmtSequence seq, SMPLEnvironment<SMPLData<String>> state)
            throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SMPLData<String> visitASTVar(ASTVar<StringExp> var, SMPLEnvironment<SMPLData<String>> state)
            throws SMPLException {
        // TODO Auto-generated method stub
        return state.get(var.getVar());
    }

    @Override
    public SMPLData<String> visitASTBinaryExp(ASTBinaryExp biExp, SMPLEnvironment<SMPLData<String>> state)
            throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SMPLData<String> visitASTUnaryExp(ASTUnaryExp urExp, SMPLEnvironment<SMPLData<String>> state)
            throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SMPLData<String> visitStringLit(StringLit str, SMPLEnvironment<SMPLData<String>> state)
            throws SMPLException {
        return str.getContext().equals("var") ? str.getVarExp().visit(this, state) : new SMPLData<String>(str.getStr(), "string");
    }

}
