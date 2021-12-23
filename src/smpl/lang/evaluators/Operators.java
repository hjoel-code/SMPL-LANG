package smpl.lang.evaluators;

public interface Operators<E, T> {

    public String getSymbol();
    public T apply(E arg1, E arg2);
    
}
