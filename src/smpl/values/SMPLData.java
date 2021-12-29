package smpl.values;


public class SMPLData<T> {
    

    private T val;
    private String type;

    public SMPLData(T val, String type) {
        this.val = val;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public T getVal() {
        return val;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
