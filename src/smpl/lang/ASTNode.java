package smpl.lang;

public abstract class ASTNode {
    @Override
    public String toString()  {
        return "no String representation defined for " + getClass();
    }
}
