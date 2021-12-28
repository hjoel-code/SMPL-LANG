package smpl.values.type.simple;

public class SMPLString extends SMPLSimple<String> {

    private String str;

    public SMPLString(String str) {
        super("string");
        this.str = str;
    }

    @Override
    public String getVal() {
        return str;
    }

    @Override
    public String toString() {
        return str;
    }
}
