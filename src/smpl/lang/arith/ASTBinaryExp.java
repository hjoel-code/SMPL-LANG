/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smpl.lang.arith;

import smpl.sys.SMPLException;
import smpl.lang.ASTExp;
import smpl.lang.visitors.*;


public class ASTBinaryExp extends AIRExp {
    String operator;
    AIRExp exp1;
    AIRExp exp2;

    public ASTBinaryExp(String operator, ASTExp<AIRExp> exp1, ASTExp<AIRExp> exp2) {
        super("arithBinary");
        this.operator = operator;
        this.exp1 = (AIRExp) exp1;
        this.exp2 = (AIRExp) exp2;

        System.out.println(getType());
    }

    public String getOperator() {
        return operator;
    }

    public AIRExp getExp1() {
        return exp1;
    }

    public AIRExp getExp2() {
        return exp2;
    }

    @Override
    public <S, T> T visit(AIRVisitor<AIRExp, S, T> v, S state) throws SMPLException {
        return v.visitASTBinaryExp(this, state);
    }

}
