package smpl.values.type.simple;

import java.nio.charset.Charset;

public class SMPLChar extends SMPLSimple<Character> {
    

    private char c;
    private String rep;
    private String unicode;

    public SMPLChar() {
        super("char");
    }

    public SMPLChar(char c) {
        this();
        rep = "#c";
        this.c = c;
    }

    public SMPLChar(String unicode) {
        this();
        this.unicode = unicode;
        int hex  = Integer.parseInt(unicode, 16);
        byte b[] = new String(Character.toChars(hex)).getBytes(Charset.forName("UTF-8"));
        String ch = new String(b, Charset.forName("UTF-8"));
        this.c = Character.valueOf(ch.charAt(0));

        rep = "#u";
    }

    public String getRep() {
        return rep;
    }

    @Override
    public Character getVal() {
        return c;
    }

    public String toString() { 
        if (rep.equals("#c")) {
            return String.valueOf(c);
        } else {
            return String.valueOf(c);
        }
        
    }

    public static void main(String[] args) {
        SMPLChar ch = new SMPLChar("00f1");
        System.out.println(ch.toString());
    }

}



 