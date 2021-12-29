package smpl.lang.evaluators;

import smpl.lang.ASTBinaryExp;
import smpl.lang.ASTUnaryExp;
import smpl.lang.ASTVar;
import smpl.lang.SMPLProgram;
import smpl.lang.StmtSequence;
import smpl.lang.chars.CharExp;
import smpl.lang.chars.CharLit;
import smpl.lang.visitors.CharacterVisitor;
import smpl.sys.SMPLEnvironment;
import smpl.sys.SMPLException;
import smpl.values.SMPLData;

import smpl.values.type.simple.SMPLChar;

public class CharacterEvaluator implements CharacterVisitor<CharExp, SMPLEnvironment<SMPLData<SMPLChar>>, SMPLData<SMPLChar>>{


    private ASTEvaluator eval;


    public CharacterEvaluator(ASTEvaluator eval) {
        this.eval = eval;
    }

    @Override
    public SMPLData<SMPLChar> visitCharLit(CharLit ch, SMPLEnvironment<SMPLData<SMPLChar>> state) throws SMPLException {
        return ch.getContext().equals("var") ? ch.getVarExp().visit(this, state) : ch.getRef().equals("#c") ? new SMPLData<SMPLChar>(new SMPLChar(ch.getChar()), "char") : new SMPLData<SMPLChar>(new SMPLChar(ch.getUnicode()), "char");
    }

    @Override
    public SMPLData<SMPLChar> visitASTVar(ASTVar<CharExp> var, SMPLEnvironment<SMPLData<SMPLChar>> state)
            throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public SMPLData<SMPLChar> visitSMPLProgram(SMPLProgram sp, SMPLEnvironment<SMPLData<SMPLChar>> arg)
            throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public SMPLData<SMPLChar> visitStmtSequence(StmtSequence seq, SMPLEnvironment<SMPLData<SMPLChar>> state)
            throws SMPLException {
        // TODO Auto-generated method stub
        return null;
            }


    @Override
    public SMPLData<SMPLChar> visitASTBinaryExp(ASTBinaryExp biExp, SMPLEnvironment<SMPLData<SMPLChar>> state)
            throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public SMPLData<SMPLChar> visitASTUnaryExp(ASTUnaryExp urExp, SMPLEnvironment<SMPLData<SMPLChar>> state)
            throws SMPLException {
        // TODO Auto-generated method stub
        return null;
    }


    

    

}
