package smpl.values.type.compound;

import java.util.ArrayList;

import smpl.values.SMPLData;

public class Vector extends SMPLCompound{

    private ArrayList<SMPLData> lst;
    
    public Vector() {
        super("vect");
    }

    public Vector(ArrayList<SMPLData> lst) {
        this();
        this.lst = lst;
    }

    @Override
    public SMPLCompound getVal() {
        return this;
    }


    @Override
    public String toString() {
        String opt = "[ ";
        
        for (int i = 0; i < lst.size(); i++) {

            opt += lst.get(i).toString();
            opt += i == (lst.size()-1) ? " " : ", ";
        }

        opt += "]";


        return opt;
    }


}
