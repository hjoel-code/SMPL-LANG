package smpl.lang.string;

import smpl.lang.ASTVar;
import smpl.lang.evaluators.ObjectEvaluator;
import smpl.lang.visitors.StringVisitor;
import smpl.sys.SMPLContext;
import smpl.sys.SMPLException;
import smpl.values.SMPLData;
import smpl.values.type.simple.SMPLString;

public class StringLit extends StringExp {
    
    private String str, context;
    private ASTVar<StringExp> varExp;


    public StringLit(String str) {
        this.str = str;
        this.context = "";
    }

    public StringLit(ASTVar<StringExp> var) {
        this.context = "var";
        this.varExp = var;
    }

    public String getContext() {
        return context;
    }

    public ASTVar<StringExp> getVarExp() {
        return varExp;
    }

    public String getStr() {
        return str;
    }

    @Override
    public SMPLData<SMPLString> eval(SMPLContext state, ObjectEvaluator eval) throws SMPLException {
        return eval.eval(state, this);
    }

    @Override
    public <S, T> T visit(StringVisitor<StringExp, S, T> v, S state) throws SMPLException {
        return v.visitStringLit(this, state);
    }
}
