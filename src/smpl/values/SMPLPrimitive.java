package smpl.values;

public class SMPLPrimitive<T> {
  private T primitive;

  public static SMPLPrimitive no_result = new SMPLPrimitive<String>("No Result");

  public SMPLPrimitive() {}

  public SMPLPrimitive(T primitive) {
    this.primitive = primitive;
  }

  public T getPrimitive() {
    return primitive;
  }
}