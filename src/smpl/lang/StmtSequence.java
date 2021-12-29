package smpl.lang;

import java.util.*;
import smpl.sys.*;
import smpl.lang.statements.SMPLStatement;
import smpl.lang.visitors.ASTVisitor;
/**
 * An instance of the <code>StmtSequence</code> class is a sequence of
 * <code>SMPLExp</code> objects.  Each expression representation is
 * treated as if it were a statement -- even if it yields a result.
 *
 * @author </a>
 * @version 1.0
 */
public class StmtSequence extends ASTExp<SMPLProgram> {

    protected ArrayList<SMPLStatement> sequence;

    /**
     * Create an empty sequence of statements
     *
     */
    public StmtSequence() {
      sequence = new ArrayList<>();
    }

    /**
     * Creates a new <code>StmtSequence</code> instance.
     *
     * @param seq an <code>ArrayList</code> value
     */
    public StmtSequence(ArrayList<SMPLStatement> seq) {
      this();
      sequence = seq;
    }

    /**
     * Add an SMPL statement to the end of this sequence.
     *
     * @param stmt the statement to be added.
     */
    public void addStatement(SMPLStatement stmt) {
      sequence.add(stmt);
    }

    public final ArrayList<SMPLStatement> getStatements() {
      return sequence;
    }

    @Override
    public <S, T> T visit(ASTVisitor<SMPLProgram, S, T> v, S state) throws SMPLException {
        return v.visitStmtSequence(this, state);
    }

  }

