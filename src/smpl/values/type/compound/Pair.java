package smpl.values.type.compound;

import smpl.values.SMPLData;

public class Pair extends SMPLCompound {
    
    private SMPLData arg1;
    private SMPLData arg2;

    public Pair(SMPLData arg1, SMPLData arg2) {
        super("pair");
        this.arg1 = arg1;
        this.arg2 = arg2;
    }
    
    public SMPLData getArg1() {
        return arg1;
    }

    public SMPLData getArg2() {
        return arg2;
    }

    @Override
    public SMPLCompound getVal() {
        return this;
    }

    @Override
    public String toString() {
        return "(" + arg1.toString() + ", " + arg2.toString() + ")";
    }
}
