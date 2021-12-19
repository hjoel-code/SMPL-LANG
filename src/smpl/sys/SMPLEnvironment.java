package smpl.sys;

import java.util.HashMap;

public class SMPLEnvironment<T> {
    

    HashMap<String, T> dictionary;
    SMPLEnvironment<T> parent;



    public SMPLEnvironment() {
        parent = null;
        dictionary = new HashMap<>();
    }
}

