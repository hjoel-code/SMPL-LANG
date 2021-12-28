package smpl.values.type.simple;


import smpl.values.type.DataType;


public abstract class SMPLSimple<T> implements DataType<T> {

    private String type;

    public SMPLSimple(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
}
