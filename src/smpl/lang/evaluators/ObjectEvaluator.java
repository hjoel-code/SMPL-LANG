



package smpl.lang.evaluators;

import smpl.lang.ASTVar;
import smpl.lang.SMPLObject;
import smpl.lang.arith.AIRExp;
import smpl.lang.bool.BoolExp;
import smpl.lang.chars.CharExp;
import smpl.lang.compound.CompoundExp;
import smpl.lang.compound.PairExp;
import smpl.lang.string.StringExp;
import smpl.sys.SMPLContext;
import smpl.sys.SMPLException;
import smpl.values.SMPLData;

public class ObjectEvaluator {

    private ASTEvaluator eval;

    public ObjectEvaluator(ASTEvaluator eval) {
        this.eval = eval;
    }

    public ASTEvaluator getEval() {
        return eval;
    }


    public SMPLData eval(SMPLContext state, SMPLObject obj) throws SMPLException    {
        
        String type = obj.getType();
        System.out.println("This is the Evaluator");
        System.out.println(type);

        if (type.equals("arith")) {
            AIRExp exp = (AIRExp) obj;
            return exp.visit(eval.getArithEval(), state.getAritEnvironment());
        } else if (type.equals("bool")) {
            BoolExp exp = (BoolExp) obj;
            return exp.visit(eval.getBoolEval(), state.getBoolEnvironment());
        } else if (type.equals("string")) {
            StringExp exp = (StringExp) obj;
            return exp.visit(eval.getStrEval(), state.getStringEnvironment());
        } else if (type.equals("char")) {
            CharExp exp = (CharExp) obj;
            return exp.visit(eval.getCharEval(), state.getCharacterEnvironment());
        } else if (type.equals("pair")) {
            PairExp exp = (PairExp) obj;
            return exp.visit(eval.getCompoundEval(), state.getCompoundTypeEnvironment());
        } else {
            throw new SMPLException("Failed to Evaluate input");
        }
    }


    public SMPLData evalVar(SMPLContext state, ASTVar obj) throws SMPLException {

        String type = state.getVariableEnvironment().get(obj.getVar());
        System.out.println("This is the Variable Getter");
        System.out.println(type);

        if (type.equals("arith")) {
            ASTVar<AIRExp> exp = (ASTVar<AIRExp>) obj;
            return exp.visit(eval.getArithEval(), state.getAritEnvironment());
        } else if (type.equals("bool")) {
            ASTVar<BoolExp> exp = (ASTVar<BoolExp>) obj;
            return exp.visit(eval.getBoolEval(), state.getBoolEnvironment());
        } else if (type.equals("string")) {
            ASTVar<StringExp> exp = (ASTVar<StringExp>) obj;
            return exp.visit(eval.getStrEval(), state.getStringEnvironment());
        } else if (type.equals("char")) {
            ASTVar<CharExp> exp = (ASTVar<CharExp>) obj;
            return exp.visit(eval.getCharEval(), state.getCharacterEnvironment());
        } else if (type.equals("pair")) {
            ASTVar<CompoundExp> exp = (ASTVar<CompoundExp>) obj;
            return exp.visit(eval.getCompoundEval(), state.getCompoundTypeEnvironment());
        } else {
            throw new SMPLException("Failed to Evaluate input");
        }
    }
}



