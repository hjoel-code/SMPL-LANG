package smpl.lang.arith;

import smpl.lang.ASTBinaryExp;
import smpl.lang.ASTUnaryExp;
import smpl.lang.evaluators.ObjectEvaluator;
import smpl.lang.visitors.AIRVisitor;
import smpl.sys.SMPLContext;
import smpl.sys.SMPLException;
import smpl.values.SMPLData;

public class ArithCalc extends AIRExp {

    private String calcType;
    private ASTBinaryExp<AIRExp> binary;
    private ASTUnaryExp<AIRExp> unary;


    public ArithCalc(ASTBinaryExp<AIRExp> calc) {
        this.calcType = "binary";
        this.binary = calc;
    }

    public ArithCalc(ASTUnaryExp<AIRExp> calc) {
        this.calcType = "unary";
        this.unary = calc;
    }


    public ASTUnaryExp<AIRExp> getUnary() {
        return unary;
    }


    public ASTBinaryExp<AIRExp> getBinary() {
        return binary;
    }


    public String getCalcType() {
        return calcType;
    }



    @Override
    public SMPLData eval(SMPLContext state, ObjectEvaluator eval) throws SMPLException {
        return eval.eval(state, this);
    }

    @Override
    public <S, T> T visit(AIRVisitor<AIRExp, S, T> v, S state) throws SMPLException {
        return v.visitArithCalc(this, state);
    }
    

}
