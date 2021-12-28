package smpl.values;

public class SMPLData<T> {
    

    private T val;

    public SMPLData(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
