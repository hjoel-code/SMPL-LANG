package smpl.lang.Evaluators;

public interface Operators<E, T> {

    public String getSymbol();
    public T apply(E arg1, E arg2);
    
}
