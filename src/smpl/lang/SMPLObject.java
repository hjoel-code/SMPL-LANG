package smpl.lang;


import smpl.lang.evaluators.ObjectEvaluator;
import smpl.sys.SMPLContext;
import smpl.sys.SMPLException;
import smpl.values.SMPLData;

public interface SMPLObject{
    

    public void setType(String type);
    public String getType();
    public SMPLData eval(SMPLContext state, ObjectEvaluator eval) throws SMPLException;


}
