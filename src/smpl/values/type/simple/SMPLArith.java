
package smpl.values.type.simple;


public class SMPLArith extends SMPLSimple<Double>{
    
    private String rep;
    private Double numb;

    public SMPLArith(String rep) {
        super("double");
        this.rep = rep;
    }

    public SMPLArith(Double numb, String rep) {
        super("double");
        this.rep = rep;
        this.numb = numb;
    }

    public SMPLArith(Double numb) {
        super("double");
        this.numb = numb;
        this.rep = "norm";
    }

    public Double getVal() {
        return numb;
    }

    public String getRep() {
        return rep;
    }

    public String toString() {
        
        if ( getRep().equals("#b") ) {
            return Integer.toBinaryString(numb.intValue());
        } else if ( getRep().equals("#x") ) {
            return Integer.toHexString(numb.intValue());
        } else {
            return String.valueOf(numb.intValue());
        }
    }

    public static void main(String[] args) {
        SMPLArith ch = new SMPLArith(88.0);

        System.out.println(ch.toString());
    }

}

