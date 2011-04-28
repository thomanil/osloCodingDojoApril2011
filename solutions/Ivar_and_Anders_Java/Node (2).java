package com.ivarnilsen.dojo.tree;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public int getDepth() {
        return 0;
    }
   
    public void chop() {
        printMe();
        printOthers();
    }

    private void printOthers() {
        System.out.print("\n");
        for (Object o : getChildren()) {
            Node n = (Node) o;
            n.printMe();
            System.out.print(n.getPos());
            n.printOthers();
        }
    }

    public int getPos() {
        return 0;
    }

    @SuppressWarnings("rawtypes")
    public List getChildren() {
        return new ArrayList();
    }

    public String getName() {
        return "parent";
    }
    
    private void printMe() {
        for (@SuppressWarnings("unused") Object o: new Object[getDepth()]) {
            System.out.print("\t");
        }
        System.out.print(getName());;
    }

}
