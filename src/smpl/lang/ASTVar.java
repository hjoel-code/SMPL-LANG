package smpl.lang;


import smpl.lang.evaluators.ObjectEvaluator;
import smpl.lang.visitors.ASTVisitor;
import smpl.sys.SMPLContext;
import smpl.sys.SMPLException;
import smpl.values.SMPLData;

public class ASTVar<E extends ASTExp<E>> extends ASTExp<E> implements SMPLObject {


    private String var; 

    private String type;

    public ASTVar() {
        this.type = "var";
    }


    public ASTVar(String var) {
        this();
        this.var = var;
        System.out.println("Variable getter: " + var + " " + getType());
    }

    @Override
    public String getType() {
        return type;
    }

    public String getVar() {
        return var;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    
    @Override
    public <S, T> T visit(ASTVisitor<E, S, T> v, S state) throws SMPLException {
        return v.visitASTVar(this, state);
    }

    @Override
    public SMPLData eval(SMPLContext state, ObjectEvaluator eval) throws SMPLException {
       return eval.evalVar(state, this);
    }

}
