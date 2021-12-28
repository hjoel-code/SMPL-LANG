package smpl.values.type.simple;

import java.util.*;

public class SMPLList<T> extends SMPLSimple<ArrayList<T>> {
    

    private ArrayList<T> lst;

    public SMPLList() {
        super("list");
    }

    public SMPLList(ArrayList<T>  lst) {
        this();
        this.lst =lst;
    }

    @Override
    public ArrayList<T> getVal() {
        return lst;
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


    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        SMPLList<Integer> ch = new SMPLList<>(arr);

        System.out.println(ch.toString());
    }

}
