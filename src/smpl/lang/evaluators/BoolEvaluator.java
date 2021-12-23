package smpl.lang.evaluators;

import java.util.HashMap;

import smpl.lang.visitors.BoolVisitor;
import smpl.sys.SMPLEnvironment;

public class BoolEvaluator implements BoolVisitor<SMPLEnvironment<Boolean>, Boolean> {
    

    private final ASTEvaluator eval;


    private HashMap<String, BoolOps> boolOps;
    private HashMap<String, LogicOps> logicOps;

    public BoolEvaluator(ASTEvaluator eval) {
        this.eval = eval;

        boolOps = new HashMap<>();
        for (BoolOps op :  BoolOps.values()) {
            boolOps.put(op.getSymbol(), op);
        }


        logicOps = new HashMap<>();
        for (LogicOps op : LogicOps.values()) {
            logicOps.put(op.getSymbol(), op);
        }
    }
}
