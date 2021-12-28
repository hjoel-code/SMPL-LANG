/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smpl.lang.arith;

import smpl.sys.SMPLException;
import smpl.lang.ASTExp;
import smpl.lang.visitors.AIRVisitor;


public class ASTUnaryExp extends AIRExp {
    String operator;
    AIRExp exp;

    public ASTUnaryExp(String op, ASTExp<AIRExp> exp) {
        super("arithUnary");
        operator = op;
        this.exp = (AIRExp) exp;
    }

    public String getOperator() {
        return operator;
    }
    
    public AIRExp getExp() {
        return exp;
    }

    @Override
    public <S, T> T visit(AIRVisitor<AIRExp, S, T> v, S state) throws SMPLException {
        return v.visitASTUnaryExp(this, state);
    }


}
