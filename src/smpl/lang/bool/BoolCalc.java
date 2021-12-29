package smpl.lang.bool;

import smpl.lang.ASTBinaryExp;
import smpl.lang.ASTUnaryExp;
import smpl.lang.evaluators.ObjectEvaluator;
import smpl.lang.visitors.BoolVisitor;
import smpl.sys.SMPLContext;
import smpl.sys.SMPLException;
import smpl.values.SMPLData;

public class BoolCalc extends BoolExp {

    private String calcType;
    private ASTBinaryExp<BoolExp> binary;
    private ASTUnaryExp<BoolExp> unary;


    public BoolCalc(ASTBinaryExp<BoolExp> calc) {
        this.calcType = "binary";
        this.binary = calc;
    }

    public BoolCalc(ASTUnaryExp<BoolExp> calc) {
        this.calcType = "unary";
        this.unary = calc;
    }


    public ASTUnaryExp<BoolExp> getUnary() {
        return unary;
    }


    public ASTBinaryExp<BoolExp> getBinary() {
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
    public <S, T> T visit(BoolVisitor<BoolExp, S, T> v, S state) throws SMPLException {
        return v.visitBoolCalc(this, state);
    }
    

}
