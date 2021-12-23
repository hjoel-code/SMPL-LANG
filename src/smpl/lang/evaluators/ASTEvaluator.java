package smpl.lang.evaluators;

import smpl.lang.SMPLProgram;
import smpl.lang.visitors.ASTVisitor;
import smpl.sys.SMPLEnvironment;

public class ASTEvaluator implements ASTVisitor<SMPLProgram, SMPLEnvironment<String>, String> {
    

    private final ArithEvaluator arithEval;
    private final BoolEvaluator boolEval;
    private final StringEvaluator strEval;
    
    public ASTEvaluator() {
        arithEval = new ArithEvaluator(this);
        boolEval = new BoolEvaluator(this);
        strEval = new StringEvaluator(this);
    }


    public ArithEvaluator getArithEval() {
        return arithEval;
    }
    
    public BoolEvaluator getBoolEval() {
        return boolEval;
    }

    public StringEvaluator getStrEval() {
        return strEval;
    }
}
