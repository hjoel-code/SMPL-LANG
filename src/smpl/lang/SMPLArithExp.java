// package smpl.lang;

// import smpl.lang.visitors.*;
// import smpl.sys.SMPLException;

// public abstract class SMPLArithExp extends ASTExp<SMPLArithExp> {
//     public abstract <S, T> T visit(AIRVisitor<S, T> v, S state) throws SMPLException;

//     @Override
//     public <S, T> T visit(ASTVisitor<SMPLArithExp, S, T> v, S state) throws SMPLException {
//         return visit((AIRVisitor<S, T> ) v, state);
//     }

// }
