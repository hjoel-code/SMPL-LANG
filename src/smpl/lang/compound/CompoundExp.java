package smpl.lang.compound;


import smpl.lang.visitors.CompoundVisitor;
import smpl.lang.ASTExp;
import smpl.lang.visitors.ASTVisitor;
import smpl.sys.SMPLException;

public abstract class CompoundExp extends ASTExp<CompoundExp>{
    
    public CompoundExp(String type) {
        super(type);
    }

    
    public abstract <S, T> T visit(CompoundVisitor<CompoundExp, S, T> v, S state) throws SMPLException;

    @Override
    public <S, T> T visit(ASTVisitor<CompoundExp, S, T> v, S state) throws SMPLException {
        return visit( (CompoundVisitor<CompoundExp, S, T>) v, state);
    }
}
