

package smpl.lang;

import smpl.sys.SMPLException;
import smpl.lang.visitors.ASTVisitor;


public class ASTUnaryExp<E extends ASTExp<E>> extends ASTExp<E> {

    String operator;
    SMPLObject exp;

    public ASTUnaryExp(String op, SMPLObject exp) {
        operator = op;
        this.exp = exp;
    }

    public String getOperator() {
        return operator;
    }
    
    public SMPLObject getExp() {
        return exp;
    }

    @Override
    public <S, T> T visit(ASTVisitor<E, S, T> v, S state) throws SMPLException {
        return v.visitASTUnaryExp(this, state);
    }


}
