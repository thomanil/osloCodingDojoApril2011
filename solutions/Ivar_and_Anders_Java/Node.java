package com.ivarnilsen.dojo.tree;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public int getDepth() {
        return 0;
    }
    
    @Override
    public String toString() {
        printname();
        return printme();
    }

    private String printme() {
        System.out.print("\n");
        for (Object o : getChildren()) {
            Node n = (Node) o;
            n.printname();
            System.out.print(n.getPos());
            n.printme();
        }
        return "";
    }

    public int getPos() {
        return 0;
    }

    @SuppressWarnings("rawtypes")
    public List getChildren() {
        return new ArrayList();
    }

    private void printname() {
        switch (getDepth()) {
        case 0:
            System.out.print("parent");;
            break;
        case 1:
            System.out.print("\t");
            System.out.print("child");
            break;
        case 2:
            System.out.print("\t\t");
            System.out.print("grandchild");
            break;
        }
    }

}
