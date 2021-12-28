package smpl.lang.evaluators;

import smpl.sys.SMPLContext;
import smpl.sys.SMPLEnvironment;



import smpl.values.*;
import smpl.values.type.compound.SMPLCompound;
import smpl.values.type.simple.SMPLArith;
import smpl.values.type.simple.SMPLBool;
import smpl.values.type.simple.SMPLChar;

public class SMPLMainEnvironment implements SMPLContext {

    SMPLEnvironment<SMPLData<SMPLArith>> arithEnvironment;
    SMPLEnvironment<SMPLData<SMPLBool>> boolEnvironment;
    SMPLEnvironment<SMPLData<SMPLCompound>> compoundEnvironment;
    SMPLEnvironment<SMPLData<String>> stringEnvironment;
    SMPLEnvironment<SMPLFunction> functionEnvironment;
    SMPLEnvironment<SMPLData<SMPLChar>> characterEnvironment;

    SMPLEnvironment<String> variabEnvironment;

    public SMPLMainEnvironment() {

        arithEnvironment = new SMPLEnvironment<>(this);
        boolEnvironment = new SMPLEnvironment<>(this);
        compoundEnvironment = new SMPLEnvironment<>(this);
        stringEnvironment = new SMPLEnvironment<>(this);
        functionEnvironment = new SMPLEnvironment<>(this);
        characterEnvironment = new SMPLEnvironment<>(this);
        variabEnvironment = new SMPLEnvironment<>(this);
    }

    @Override
    public SMPLEnvironment<SMPLData<SMPLArith>> getAritEnvironment() {
        return arithEnvironment;
    }

    @Override
    public SMPLEnvironment<SMPLData<SMPLBool>> getBoolEnvironment() {
        return boolEnvironment;
    }

    @Override
    public SMPLEnvironment<SMPLData<SMPLCompound>> getCompoundTypeEnvironment() {
        return compoundEnvironment;
    }

    @Override
    public SMPLEnvironment<SMPLFunction> getFunctionsEnvironemnt() {
        return functionEnvironment;
    }

    @Override
    public SMPLEnvironment<SMPLData<String>> getStringEnvironment() {
        return stringEnvironment;
    }

    public SMPLEnvironment<SMPLData<SMPLChar>> getCharacterEnvironment() {
        return characterEnvironment;
    }

    @Override
    public SMPLEnvironment<String> getVariableEnvironment() {
        return variabEnvironment;
    }

    @Override
    public SMPLContext extendEnvironment() {
        return this.cloneEnvironment();
    }

    

    public SMPLMainEnvironment  cloneEnvironment() {
        SMPLMainEnvironment context = new SMPLMainEnvironment();

        context.arithEnvironment = this.arithEnvironment;
        context.boolEnvironment = this.boolEnvironment;
        context.compoundEnvironment = this.compoundEnvironment;
        context.stringEnvironment = this.stringEnvironment;
        context.functionEnvironment = this.functionEnvironment;
        context.characterEnvironment = this.characterEnvironment;
        context.variabEnvironment = this.variabEnvironment;

        return context;
    }

    

}