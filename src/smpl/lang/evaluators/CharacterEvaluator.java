package smpl.lang.evaluators;

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
    public SMPLData<SMPLChar> visitCharLit(CharLit ch, SMPLEnvironment<SMPLData<SMPLChar>> state) throws SMPLException {
        if (ch.getcType().equals("charLit")) {
            return ch.getRef().equals("#c") ? new SMPLData<SMPLChar>(new SMPLChar(ch.getChar())) : new SMPLData<SMPLChar>(new SMPLChar(ch.getUnicode()));
        } else {
            return new SMPLData<SMPLChar>(state.get(ch.getVar()).getVal());
        }
    }

    

}
