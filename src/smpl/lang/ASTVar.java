package smpl.lang;

import smpl.lang.statements.SMPLStatement;
import smpl.lang.visitors.ASTVisitor;
import smpl.lang.visitors.StmtVisitor;
import smpl.sys.SMPLException;

public class ASTVar<E extends ASTExp<E>> extends ASTExp<E> implements SMPLStatement{


    private String var;


    public ASTVar(String var) {
        super("var");
        this.var = var;
    }

    public String getVar() {
        return var;
    }

    @Override
    public <S, T> T visit(StmtVisitor<SMPLProgram, S, T> v, S state) throws SMPLException {
        return v.visitASTVar(this, state);
    }

    @Override
    public <S, T> T visit(ASTVisitor<E, S, T> v, S state) throws SMPLException {
        return visit( (StmtVisitor<SMPLProgram, S, T>) v, state);
    }

    
    


}
