package smpl.lang.string;

import smpl.lang.visitors.ASTVisitor;
import smpl.lang.visitors.StringVisitor;
import smpl.sys.SMPLException;

public class StringLit extends StringExp{
    
    public String str, var;

    public StringLit(String val) {
        super("stringLit");
        this.str = val;
    }

    public StringLit(String var, String type) {
        super("stringVar");
        this.var = var;
      }

    public String getStr() {
        return str;
    }

    public String getVar() {
        return var;
    }

    @Override
    public <S, T> T visit(StringVisitor<StringExp, S, T> v, S state) throws SMPLException {
        return v.visitStringLit(this, state);
    }

    @Override
    public <S, T> T visit(ASTVisitor<StringExp, S, T> v, S state) throws SMPLException {
        return visit( (StringVisitor<StringExp, S, T>) v, state);
    }
}
