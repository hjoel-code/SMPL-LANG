package smpl.sys;

import java.io.Reader;
import java.io.StringReader;
import lib3652.util.Interpreter;
import lib3652.util.ResultType;
import lib3652.util.Result;
import lib3652.util.TokenException;

import smpl.lang.*;




public class SMPLInterpreter implements Interpreter {

    SMPLParser parser;
    boolean isVerbose = false;
    SMPLEnvironment globalEnv;



    /**
     * Creates a new SMPL Interpreter with a default global environment.
     */
    public SMPLInterpreter() {
        globalEnv = new SMPLEnvironment();
    }

    /**
     * Create a new SMPL Interpreter that uses the given environment as its global environment
     * @param env Global Environment
     */
    public SMPLInterpreter(SMPLEnvironment env) {
        globalEnv = env;
    }

    public void serVerbose(boolean isVerbose) {
        this.isVerbose = isVerbose;
    }

    public Result run(String input) {
        StringReader reader = new StringReader(input);
        return this.run(reader);
    }

    public Result run(Reader reader) {
        parser = new SMPLParser(new Lexer(reader));

        SMPLProgram program;

        try {
            program = (SMPLParser) parser.parse().value;
        } catch (TokenException error) {
            if (isVerbose)
            System.out.println(error.getMessage());
            return new Result(ResultType.ERROR_LEXER, error.getMessage());
        } catch (Exception e) {
            if (isVerbose)
            System.out.println(e.getMessage());
            return new Result(ResultType.ERROR_PARSER, e.getMessage());
        }


        try {
            int r = program.eval(globalEnv);
            return new Result(ResultType.V_INT, r);
        } catch (Exception e) {
            if (isVerbose) {
            System.out.println(e.getMessage());
            }
            return new Result(ResultType.ERROR_RUNTIME, e.getMessage());
        }
        }
    }



}