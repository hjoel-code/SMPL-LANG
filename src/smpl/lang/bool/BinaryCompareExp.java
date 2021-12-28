package smpl.lang.bool;

import smpl.lang.ASTExp;
import smpl.lang.arith.AIRExp;
import smpl.lang.visitors.ASTVisitor;
import smpl.lang.visitors.BoolVisitor;
import smpl.sys.SMPLException;

public class BinaryCompareExp extends BoolExp {
    
    private AIRExp leftExp;
    private AIRExp rightExp;

    private BoolExp leftBool;
    private BoolExp rightBool;

    private String op;

    public BinaryCompareExp(String op, ASTExp<AIRExp> exp1, ASTExp<AIRExp> exp2) {
        super("binary");
        leftExp = (AIRExp) exp1;
        rightExp = (AIRExp) exp2;
        this.op = op;
    }

    public BinaryCompareExp(String op, BoolExp exp1, BoolExp exp2) {
        super("logic");
        leftBool = (BoolExp) exp1;
        rightBool = (BoolExp) exp2;
        this.op = op;
    }

    public BinaryCompareExp(String op, BoolExp exp1) {
        super("not");
        leftBool = (BoolExp) exp1;
        this.op = op;
    }

    public AIRExp getLeftArith() {
        return leftExp;
    }

    public AIRExp getRightArith() {
        return rightExp;
    }

    public BoolExp getLeftBool() {
        return leftBool;
    }

    public BoolExp getRightBool() {
        return rightBool;
    }

    public String getOp() {
        return op;
    }

    @Override
    public <S, T> T visit(BoolVisitor<BoolExp, S, T> v, S state) throws SMPLException {
        return v.visitCompareExp(this, state);
    }

    @Override
    public <S, T> T visit(ASTVisitor<BoolExp, S, T> v, S state) throws SMPLException {
        return visit( (BoolVisitor<BoolExp, S, T>) v, state);
    }


}
