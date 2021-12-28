
package smpl.values.type.simple;

public class SMPLBool extends SMPLSimple<Boolean>{
    
    private Boolean val;

    public SMPLBool(Boolean val) {
        super("bool");
        this.val = val;
    }

    @Override
    public Boolean getVal() {
        return val;
    }

    @Override
    public String toString() {
        if (val) {
            return "True";
        } else {
            return "False";
        }
    }

    public static void main(String[] args) {
        SMPLBool ch = new SMPLBool(true);
        System.out.println(ch.toString());
    }

}

