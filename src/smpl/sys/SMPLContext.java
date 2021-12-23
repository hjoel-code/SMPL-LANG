/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smpl.sys;

import smpl.values.SMPLFunction;
import smpl.values.CompoundType;
import java.util.ArrayList;

/**
 *
 * @author Daniel Coore <daniel.coore@uwimona.edu.jm>
 * Created on 31-Oct-2015
 */
public interface SMPLContext {
    /**
     * Create a new context in which the function environment is extended with
     * new bindings.
     * @param fParams The names to be bound in the new function frame.
     * @param args The corresponding values for the names
     * @return A newly created context containing the new function environment,
     * but leaving all the other components of the context unchanged.
     */
    public SMPLContext extendF(ArrayList<String> fParams, ArrayList<SMPLFunction> args);

    /**
     * Create a new context in which the numerical environment is extended with
     * new bindings.
     * @param nParams The names to be bound in the new numerical environment
     * frame.
     * @param vals The corresponding values for the names
     * @return A newly created context containing the new numerical environment,
     * but leaving all the other components of the context unchanged.
     */
    public SMPLContext extendN(ArrayList<String> nParams, ArrayList<Double> vals);

    /**
     * Lookup a reference to a SMPL function.
     * @param name The identifier of the SMPL function
     * @return The SMPL function associated with the given name in this context
     * @throws SMPLException if the name is not bound to a painter in this
     * context
     */
    public SMPLFunction getF(String name) throws SMPLException;

    /**
     * Lookup a reference to a number
     * @param name The identifier of the Double
     * @return The number associated with the given name in this context
     * @throws SMPLException if the name is not bound to a number in this
     * context
     */
    public Double getN(String name) throws SMPLException;


    /**
     * Loopup reference to a compound type 
     * @param name the indentifier of the compound type
     * @return the compound type associated with the given name in the context 
     * @throws SMPLException if the name is not bound to a compound in this context
     */
    public SMPLPrimitive getC(String name) throws SMPLException; 

    /**
     *
     * @return The numerical environment associated with this context.
     */
    public SMPLEnvironment<Double> getNumEnv();

    /**
     *
     * @return The function environment associated with this context.
     */
    public SMPLEnvironment<SMPLFunction> getFunEnv();

    /**
     *
     * @return The compound data type environment associated with this context.
     */
    public SMPLEnvironment<SMPLPrimitive> getCompEnv();


    /**
     * Store a binding for the given name to the given SMPL function.
     * @param name The identifier of the binding
     * @param p The SMPL function to be associated with the name
     */
    public void putF(String name, SMPLFunction p);

    /**
     * Store a binding for the given name to the given number.
     * @param name The identifier of the binding
     * @param n The numerical value to be associated with the name
     */
    public void putN(String name, Double n);

    /**
     * Store a binding for the given name to a given compound type
     * @param name the indentifier of the binding
     * @param c the compound type value to be associated with the name
     *  
     */
    public void putC(String name, SMPLPrimitive c);
    
}
