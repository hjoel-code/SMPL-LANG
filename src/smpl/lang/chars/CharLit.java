package smpl.lang.chars;

import smpl.lang.visitors.CharacterVisitor;
import smpl.sys.SMPLException;

public class CharLit extends CharExp {


    private Character ch;
    private String unicode;
    private String ref, var;


    public CharLit(char ch, String ref) {
        super("charLit");
        this.ch = Character.valueOf(ch);
        this.ref = ref;
    }

    public CharLit(String unicode, String ref) {
        super("charLit");
        this.unicode = unicode;
        this.ref = ref;
    }

    public CharLit(String var) {
        super("charVar");
        this.var = var;
    }

    public String getUnicode() {
        return unicode;
    }

    public Character getChar() {
        return ch;
    }

    public String getRef() {
        return ref;
    }


    public String getVar() {
        return var;
    }
    
    @Override
    public <S, T> T visit(CharacterVisitor<CharExp, S, T> v, S state) throws SMPLException {
        return v.visitCharLit(this, state);
    }

} 

