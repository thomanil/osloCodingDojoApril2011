package com.ivarnilsen.dojo.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("rawtypes")
public class Lumberjack {

    public static void main(String[] args) {
        Node parent = new Node() {
            @Override
            public List getChildren() {
                return Arrays.asList(createNode(1, 1, new ArrayList()) 
                                    ,createNode(1, 2, Arrays.asList( 
                                             createNode(2, 1, new ArrayList()))) 
                                            ,createNode(2, 2, new ArrayList())) 
                                            ;
            }
                

        };

        System.out.println(parent.toString());
    }
    
    private static Node createNode(final int depth, final int pos, final List children) {
        return new Node() {
            @Override
            public int getDepth() {
                return depth;
            }
            @Override
            public int getPos() {
                return pos;
            }
            
            @Override
            public List getChildren() {
                return children;
            }
        };
    }
    
}
