package week4.day1;

import java.util.LinkedList;
import java.util.List;

public class Node {

    private int value;

    public int getValue() {
        return value;
    }

    public List getChildren() {
        return children;
    }

    private List children;

    public Node(int numb) {
        this.value = numb;
        this.children = new LinkedList();

    }
//        Node<T> left;
//        Node<T> right;

    public boolean addChild(Node child) {
        boolean wasAdded = false;
        if (child != null) {
            children.add(child);
            wasAdded = true;
        }
        return wasAdded;
    }

    public static int sumOfNodes (Node root){

        if (root == null){
            return 0;
        }
        if (root.getChildren().isEmpty()){
            return root.getValue();
        }
        int sum = root.getValue();
        for (Object child : root.getChildren() ) {
            sum += sumOfNodes((Node) child);
        }
        return sum;
    }
}


