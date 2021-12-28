package smpl.sys;

import smpl.values.*;
import smpl.values.type.compound.*;
import smpl.values.type.simple.SMPLArith;
import smpl.values.type.simple.SMPLBool;
import smpl.values.type.simple.SMPLChar;


public interface SMPLContext {
    

    public abstract SMPLEnvironment<SMPLData<SMPLArith>> getAritEnvironment();
    public abstract SMPLEnvironment<SMPLData<SMPLBool>> getBoolEnvironment();
    public abstract SMPLEnvironment<SMPLData<SMPLCompound>> getCompoundTypeEnvironment();
    public abstract SMPLEnvironment<SMPLData<String>> getStringEnvironment();
    public abstract SMPLEnvironment<SMPLFunction> getFunctionsEnvironemnt();
    public abstract SMPLEnvironment<SMPLData<SMPLChar>> getCharacterEnvironment();
    public abstract SMPLEnvironment<String> getVariableEnvironment();

    public abstract SMPLContext extendEnvironment();


}
