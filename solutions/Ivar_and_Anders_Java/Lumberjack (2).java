package com.ivarnilsen.dojo.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("rawtypes")
public class Lumberjack {

    public static void main(String[] args) {
        Node yggdrasil = new Node() {
            @Override
            public List getChildren() {
                return Arrays.asList(createNode("child", 1, 1, new ArrayList()) 
                                    ,createNode("child", 1, 2, Arrays.asList( 
                                             createNode("grandchild", 2, 1, new ArrayList()))) 
                                            ,createNode("grandchild", 2, 2, Arrays.asList(createNode("grandgrandchild", 3, 1, new ArrayList())))) 
                        ;
            }
                

        };

        yggdrasil.chop();
    }
    
    private static Node createNode(final String name, final int depth, final int pos, final List children) {
        return new Node() {
            
            @Override
            public String getName() {
                return name;
            }
            
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
