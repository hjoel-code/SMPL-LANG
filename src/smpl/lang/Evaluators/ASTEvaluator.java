package smpl.lang.Evaluators;

import smpl.lang.SMPLProgram;
import smpl.lang.Visitors.ASTVisitor;
import smpl.sys.SMPLEnvironment;

public class ASTEvaluator implements ASTVisitor<SMPLProgram, SMPLEnvironment, String> {
    

    SMPLEnvironment env;

    public ASTEvaluator(SMPLEnvironment env) {
        this.env = env;
    }
}
