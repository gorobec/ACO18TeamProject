package week4;

import java.util.ArrayList;

public class TNode {
    int val;
    ArrayList<TNode> children;

    public boolean addChild(TNode node){
        this.children.add(node);
        return true;
    }

    /*public static int sum (TNode node){
        if (node.children != null) return 0;
        int summa =sum(node. children);
        return sum(node.children)
    }*/

}

