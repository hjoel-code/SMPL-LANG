package smpl.lang.evaluators;

import smpl.lang.visitors.SMPLVisitor;
import smpl.sys.SMPLContext;
import smpl.sys.SMPLException;
import smpl.lang.*;
import smpl.lang.arith.AIRExp;
import smpl.lang.arith.AIRLit;
import smpl.lang.arith.ASTBinaryExp;
import smpl.lang.arith.ASTUnaryExp;
import smpl.lang.bool.BinaryCompareExp;
import smpl.lang.bool.BoolExp;
import smpl.lang.chars.CharExp;
import smpl.lang.chars.CharLit;
import smpl.lang.compound.Car;
import smpl.lang.compound.Cdr;
import smpl.lang.compound.CompoundExp;
import smpl.lang.string.StringExp;
import smpl.lang.string.StringLit;
import smpl.values.*;
import smpl.values.type.compound.Pair;
import smpl.values.type.compound.SMPLCompound;

public class SMPLEvaluator<E extends ASTExp<E>> implements SMPLVisitor<SMPLExp<E>, SMPLContext, SMPLData> {

    private ASTEvaluator eval;

    public SMPLEvaluator(ASTEvaluator eval) {
        this.eval = eval;
    }

    @Override
    public <A extends ASTExp<A>> SMPLData visitSMPLExp(SMPLExp<A> expr, SMPLContext state) throws SMPLException {
        String type = expr.getExp().getType();
        if (type.equals("arith")) {

            AIRExp exp = (AIRExp) expr.getExp();
            type = exp.getaType();

            try {

                if (type.equals("arithLit") | type.equals("arithVar")) {
                    AIRLit aExp = (AIRLit) expr.getExp();
                    return aExp.visit(eval.getArithEval(), state.getAritEnvironment());
                } else if (type.equals("arithBinary")) {
                    ASTBinaryExp aExp = (ASTBinaryExp) expr.getExp();
                    return aExp.visit(eval.getArithEval(), state.getAritEnvironment());
                } else if (type.equals("arithUnary")) {
                    ASTUnaryExp aExp = (ASTUnaryExp) expr.getExp();
                    return aExp.visit(eval.getArithEval(), state.getAritEnvironment());
                }

            } catch (Exception err) {

                throw new SMPLException(err.getMessage());

            }

        } else if (type.equals("string")) {

            StringExp exp = (StringExp) expr.getExp();
            type = exp.getsType();

            try {

                if (type.equals("stringLit") | type.equals("stringVar")) {
                    StringLit sExp = (StringLit) expr.getExp();
                    return sExp.visit(eval.getStrEval(), state.getStringEnvironment()); 
                }

            } catch (Exception err) {

                throw new SMPLException(err.getMessage());

            }
        } else if (type.equals("pair")) {

            CompoundExp cExp = (CompoundExp) expr.getExp();
            return cExp.visit(eval.getCompoundEval(), state.getCompoundTypeEnvironment());

        } else if (type.equals("char")) {

            CharExp ch = (CharExp) expr.getExp();
            type = ch.getcType();

            if (type.equals("charLit")) {
                CharLit chExp = (CharLit) ch;
                System.out.println(chExp.getRef());
                return chExp.visit(eval.getCharEval(), state.getCharacterEnvironment());
            }
            

        } else if (type.equals("bool")) {

            BoolExp bool = (BoolExp) expr.getExp();
            type = bool.getbType();
            
            if (type == null) {
                return bool.visit(eval.getBoolEval(), state.getBoolEnvironment());
            } else {
                BinaryCompareExp boolExp = (BinaryCompareExp) bool;
                return boolExp.visit(eval.getBoolEval(), state.getBoolEnvironment());
            }
        } else if (type.equals("var")) {
            ASTVar<A> var = (ASTVar<A>) expr.getExp();
            return var.visit(eval.getStmtEval(), state);
        }
        throw new SMPLException("Invalid Expression");

    }

    @Override
    public SMPLData visitSMPLProgram(SMPLProgram sp, SMPLContext arg) throws SMPLException {
        return null;
    }

    @Override
    public SMPLData visitStmtSequence(StmtSequence seq, SMPLContext state) throws SMPLException {
        return null;
    }

    @Override
    public <A extends ASTExp<A>> SMPLData visitCARExp(Car<A> exp, SMPLContext state) throws SMPLException {
        SMPLExp<A> smpl = (SMPLExp<A>) exp;

        SMPLData<SMPLCompound> pair = (SMPLData<SMPLCompound>) this.visitSMPLExp(smpl, state);
        Pair pairVal = (Pair) pair.getVal();
        return pairVal.getArg1();
    }

    @Override
    public <A extends ASTExp<A>> SMPLData visitCDRExp(Cdr<A> exp, SMPLContext state) throws SMPLException {
        SMPLExp<A> smpl = (SMPLExp<A>) exp;

        SMPLData<SMPLCompound> pair = (SMPLData<SMPLCompound>) this.visitSMPLExp(smpl, state);
        Pair pairVal = (Pair) pair.getVal();
        return pairVal.getArg2();
    }

}
