package smpl.sys;

import java_cup.runtime.*;
import java.io.*;
import java.util.Scanner;

import lib3652.util.Interpreter;
import lib3652.util.Result;
import lib3652.util.TokenException;


import smpl.lang.*;

public class Repl {
    public static final String PROMPT = ">";
    private static final String MESSAGE = "Type your input at the prompt." +
	"  Terminate with a '.' on a line by itself.\n" +
	"Quit by entering a '.' as the only line or by sending EOF to input.";



    public static void main(String args[]) {

        SMPLInterpreter interp = new SMPLInterpreter();

        if (args.length == 0) {
            System.out.println(MESSAGE);

            repl(new InputStreamReader(System.in), interp);
        }

    }
}