package smpl.lang.string;


import smpl.sys.SMPLException;
import smpl.lang.ASTExp;
import smpl.lang.visitors.*;

public abstract class StringExp extends ASTExp<StringExp>{

    private String sType;

    public StringExp(String type) {
        super("string");
        this.sType = type;
      }
    


      public String getsType() {
          return sType;
      }


    public abstract <S, T> T visit(StringVisitor<StringExp, S, T> v, S state) throws SMPLException;
      
}
