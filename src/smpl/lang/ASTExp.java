package smpl.lang;


import smpl.lang.visitors.ASTVisitor;
import smpl.sys.SMPLException;

public abstract class ASTExp<E extends ASTExp<E>> extends ASTNode {

    private String type;

    public ASTExp(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }
    
    /**
     * Call the appropriate visit... method in the visitor with this
     * object and the given argument.  In general, each visitor might
     * need to use different data to flow up and down the tree.
     *
     
     * @param <S> The type of state that the visitor requires
     * @param <T> The return type of the visitor
     * @param v The visitor to be used to visit this node (statement)
     * @param state The state needed by the visitor
     * @return The return value of the visitor calling its method for visiting
     * statements.
     * @throws SMPLException if the visitor encounters an error
     */
    public abstract <S, T> T visit(ASTVisitor<E, S, T> v, S state) throws SMPLException;
}
