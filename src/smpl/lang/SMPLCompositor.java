package smpl.lang;

import smpl.values.*;
import java.util.ArrayList;

public class SMPLCompositor implements SMPLContext {
  public SMPLEnvironment<Double> numEnv;
  public SMPLEnvironment<SMPLFunction> funEnv;

  public SMPLCompositor(SMPLEnvironment<Double> numEnv, SMPLEnvironment<SMPLFunction> funEnv) {
    this.numEnv = numEnv;
    this.funEnv = funEnv;
  }

  // TODO: Finish implementation

  // public SMPLContext extendF(ArrayList<String> fParams, ArrayList<SMPLFunction> args) {

  // }

  // public SMPLContext extendN(ArrayList<String> nParams, ArrayList<Double> vals) {

  // }

  // public SMPLFunction getF(String name) throws SMPLException {

  // }

  // public Double getN(String name) throws SMPLException {

  // }

  // public SMPLPrimitive getC(String name) throws SMPLException; {

  // }

  // public SMPLEnvironment<Double> getNumEnv() {

  // }

  // public SMPLEnvironment<SMPLFunction> getFunEnv() {

  // }

  // public SMPLEnvironment<SMPLPrimitive> getCompEnv() {

  // }

  // public void putF(String name, SMPLFunction p) {

  // }

  // public void putN(String name, Double n) {

  // }

  // public void putC(String name, SMPLPrimitive c) {

  // }
}