package smpl.lang.evaluators;

import smpl.lang.ASTExp;
import smpl.lang.ASTVar;
import smpl.lang.SMPLProgram;
import smpl.lang.StmtSequence;
import smpl.lang.statements.PrintStmt;
import smpl.lang.statements.SMPLAssignment;
import smpl.lang.visitors.StmtVisitor;
import smpl.sys.SMPLContext;
import smpl.sys.SMPLException;
import smpl.values.SMPLData;
import smpl.values.type.compound.Pair;
import smpl.values.type.simple.SMPLArith;
import smpl.values.type.simple.SMPLBool;
import smpl.values.type.simple.SMPLChar;

public class StatementEvaluator implements StmtVisitor<SMPLProgram, SMPLContext, SMPLData<String>> {

    private ASTEvaluator eval;

    public StatementEvaluator(ASTEvaluator eval) {
        this.eval = eval;
    }

    @Override
    public SMPLData<String> visitSMPLProgram(SMPLProgram sp, SMPLContext arg) throws SMPLException {
        return null;
    }

    @Override
    public SMPLData<String> visitStmtSequence(StmtSequence seq, SMPLContext state) throws SMPLException {
        return null;
    }

    @Override
    public <A extends ASTExp<A>> SMPLData<String> visitSMPLAssignment(SMPLAssignment<A> assignment, SMPLContext state)
            throws SMPLException {
        SMPLEvaluator<A> smplEval = (SMPLEvaluator<A>) eval.getSmplStmt();
        System.out.println(assignment.getExp().getExp().getType());
        String type = assignment.getExp().getExp().getType();

        state.getVariableEnvironment().put(assignment.getVar(), type);

        if (type.equals("arith")) {
            state.getAritEnvironment().put(assignment.getVar(), assignment.getExp().visit(smplEval, state));
            state.getAritEnvironment().print();
        } else if (type.equals("string")) {
            state.getStringEnvironment().put(assignment.getVar(), assignment.getExp().visit(smplEval, state));
            state.getStringEnvironment().print();
        } else if (type.equals("pair")) {
            state.getCompoundTypeEnvironment().put(assignment.getVar(), assignment.getExp().visit(smplEval, state));
            state.getCompoundTypeEnvironment().print();
        } else if (type.equals("char")) {
            state.getCharacterEnvironment().put(assignment.getVar(), assignment.getExp().visit(smplEval, state));
            state.getCharacterEnvironment().print();
        } else if (type.equals("bool")) {
            state.getBoolEnvironment().put(assignment.getVar(), assignment.getExp().visit(smplEval, state));
            state.getBoolEnvironment().print();
        }
        return new SMPLData<String>("");
    }

    @Override
    public <A extends ASTExp<A>> SMPLData<String> visitPrintStmt(PrintStmt<A> printStmt, SMPLContext state)
            throws SMPLException {
        SMPLEvaluator<A> smplEval = (SMPLEvaluator<A>) eval.getSmplStmt();
        String type = printStmt.getExp().getExp().getType();

        System.out.println(type);

        if (type.equals("arith")) {
            SMPLData<SMPLArith> smplArith = printStmt.getExp().visit(smplEval, state);
            return new SMPLData<String>(smplArith.toString());
        } else if (type.equals("string")) {
            return printStmt.getExp().visit(smplEval, state);
        } else if (type.equals("pair")) {
            SMPLData<Pair> pair = (SMPLData<Pair>) printStmt.getExp().visit(smplEval, state);
            return new SMPLData<String>(pair.getVal().toString());
        } else if (type.equals("char")) {
            SMPLData<SMPLChar> ch = (SMPLData<SMPLChar>) printStmt.getExp().visit(smplEval, state);
            return new SMPLData<String>(ch.toString());
        } else if (type.equals("bool")) {
            SMPLData<SMPLBool> bool = (SMPLData<SMPLBool>) printStmt.getExp().visit(smplEval, state);
            return new SMPLData<String>(bool.toString());
        } else if (type.equals("var")) {
            return printStmt.getExp().visit(smplEval, state);
        }

        throw new SMPLException("Can't Identify Object : " + printStmt.getExp().getExp().getClass().getName());

    }

    @Override
    public <A extends ASTExp<A>> SMPLData<String> visitASTVar(ASTVar<A> var, SMPLContext state) throws SMPLException {

        String varType = state.getVariableEnvironment().get(var.getVar());

        if (varType.equals("arith")) {
            return new SMPLData(state.getAritEnvironment().get(var.getVar()).toString());
        } else if (varType.equals("string")) {
            return state.getStringEnvironment().get(var.getVar());
        } else if (varType.equals("pair")) {
            return new SMPLData(state.getCompoundTypeEnvironment().get(var.getVar()).toString());
        } else if (varType.equals("char")) {
            return new SMPLData(state.getCharacterEnvironment().get(var.getVar()).toString());
        } else if (varType.equals("bool")) {
            return new SMPLData(state.getBoolEnvironment().get(var.getVar()).toString());
        }

        throw new SMPLException("Unbound Variable: " + var.getVar());
    }

}
