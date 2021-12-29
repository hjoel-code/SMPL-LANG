package smpl.lang.evaluators;

import smpl.lang.ASTBinaryExp;
import smpl.lang.ASTUnaryExp;
import smpl.lang.ASTVar;
import smpl.lang.CAR;
import smpl.lang.CDR;
import smpl.lang.SMPLProgram;
import smpl.lang.StmtSequence;
import smpl.lang.statements.PrintStmt;
import smpl.lang.statements.SMPLAssignment;
import smpl.lang.statements.SMPLStatement;
import smpl.lang.visitors.StatementVisitor;
import smpl.sys.SMPLContext;
import smpl.sys.SMPLException;
import smpl.values.SMPLData;
import smpl.values.type.compound.Pair;

public class StatementEvaluator implements StatementVisitor<SMPLProgram, SMPLContext, SMPLData<String>> {

    private ASTEvaluator eval;

    public StatementEvaluator(ASTEvaluator eval) {
        this.eval = eval;
    }

    @Override
    public SMPLData<String> visitSMPLProgram(SMPLProgram sp, SMPLContext arg) throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SMPLData<String> visitStmtSequence(StmtSequence seq, SMPLContext state) throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SMPLData<String> visitASTBinaryExp(ASTBinaryExp biExp, SMPLContext state) throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SMPLData<String> visitASTUnaryExp(ASTUnaryExp urExp, SMPLContext state) throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SMPLData<String> visitSMPLAssignment(SMPLAssignment assignment, SMPLContext state) throws SMPLException {
        String type = assignment.getExp().getType();

        state.getVariableEnvironment().put(assignment.getVar(), type);
        
        System.out.println(type);
        state.getVariableEnvironment().print();

        if (type.equals("arith")) {
            state.getAritEnvironment().put(assignment.getVar(), assignment.getExp().eval(state, this.eval.getObjectEvaluator()));
            state.getAritEnvironment().print();
        } else if (type.equals("string")) {
            state.getStringEnvironment().put(assignment.getVar(), assignment.getExp().eval(state, this.eval.getObjectEvaluator()));
            state.getStringEnvironment().print();
        } else if (type.equals("pair")) {
            state.getCompoundTypeEnvironment().put(assignment.getVar(), assignment.getExp().eval(state, this.eval.getObjectEvaluator()));
            state.getCompoundTypeEnvironment().print();
        } else if (type.equals("char")) {
            state.getCharacterEnvironment().put(assignment.getVar(), assignment.getExp().eval(state, this.eval.getObjectEvaluator()));
        } else if (type.equals("bool")) {
            state.getBoolEnvironment().put(assignment.getVar(), assignment.getExp().eval(state, this.eval.getObjectEvaluator()));
            state.getBoolEnvironment().print();
        } else if (type.equals("cdr")) {
            CDR cdr = (CDR) assignment.getExp();
            type = assignment.getExp().eval(state, this.eval.getObjectEvaluator()).getType();
            cdr.setType(type);
            assignment.setExp(cdr);
            visitSMPLAssignment(assignment, state);
        } else if (type.equals("car")) {
            CAR cdr = (CAR) assignment.getExp();
            type = assignment.getExp().eval(state, this.eval.getObjectEvaluator()).getType();
            cdr.setType(type);
            assignment.setExp(cdr);
            visitSMPLAssignment(assignment, state);
        }

        return new SMPLData<String>("", "string");
    }

    @Override
    public SMPLData<String> visitPrintStmt(PrintStmt printStmt, SMPLContext state) throws SMPLException {
        // TODO Auto-generated method stub
        System.out.println("This is printing type: " + printStmt.getExp().getType());
        System.out.println(printStmt.getExp().getClass().getName());
        return new SMPLData<String>(printStmt.getExp().eval(state, this.eval.getObjectEvaluator()).toString(), "string");
    }

    @Override
    public SMPLData<String> visitASTVar(ASTVar<SMPLStatement> var, SMPLContext state) throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }

    

}
