package smpl.values.type.compound;

import smpl.values.type.DataType;


public abstract class SMPLCompound implements DataType<SMPLCompound> {

    private String type;

    public SMPLCompound(String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }
    
}
