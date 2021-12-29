/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smpl.lang;

import smpl.sys.SMPLException;
import smpl.lang.visitors.*;


public class ASTBinaryExp<E extends ASTExp<E>> extends ASTExp<E> {

    String operator;
    SMPLObject exp1;
    SMPLObject exp2;

    public ASTBinaryExp(String operator,SMPLObject exp1, SMPLObject exp2) {
        this.operator = operator;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public String getOperator() {
        return operator;
    }

    public SMPLObject getExp1() {
        return exp1;
    }

    public SMPLObject getExp2() {
        return exp2;
    }

    @Override
    public <S, T> T visit(ASTVisitor<E, S, T> v, S state) throws SMPLException {
        return v.visitASTBinaryExp(this, state);
    }

    

}
