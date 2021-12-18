package smpl.lang;

public abstract class SMPLExp extends ASTExp<SMPLExp> {
    


    public abstract <S, T> T visit(SMPLVisitor<S, T> v, S state) throws Exception;

    @Override
    public <S, T> T visit(ASTVisitor<SMPLExp, S, T> v, S state) throws Exception {
        return visit((SMPLVisitor<S, T>) v, state);
    }

}
