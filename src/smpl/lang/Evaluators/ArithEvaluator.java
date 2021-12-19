package smpl.lang.Evaluators;

import java.util.HashMap;

import smpl.lang.ArithOps;
import smpl.lang.Visitors.ArithVisitor;
import smpl.sys.SMPLEnvironment;

public class ArithEvaluator implements ArithVisitor<SMPLEnvironment<Double>, Double> {
    

    private final ASTEvaluator eval;

    private HashMap<String, ArithOps> arithOps;



    public ArithEvaluator(ASTEvaluator eval) {
        this.eval = eval;

        arithOps = new HashMap<>();

        for (ArithOps op : ArithOps.values()) {
            arithOps.put(op.getSymbol(), op);
        }
        
    }
}
