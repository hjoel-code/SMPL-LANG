package smpl.values;

public class SMPLPrimitive {
  private String primitive;

  public static SMPLPrimitive no_result = new SMPLPrimitive("No Result");

  public SMPLPrimitive() {}

  public SMPLPrimitive(String primitive) {
    this.primitive = primitive;
  }

  public String getPrimitive() {
    return primitive;
  }

  public void appendToPrimitive(String str) {
    primitive += " " + str;
  }

  public void resetPrimitive() {
      primitive = "";
  }
}