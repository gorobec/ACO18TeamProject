package oop.week4.nodeStructure;

/**
 * Created by fmandryka on 11.02.2017.
 */
public class Run {
    public static void main(String[] args) {

        NodeStructure<Integer> node1 = new NodeStructure<Integer>(1);

        node1.addChild(new NodeStructure(2));
        node1.addChild(new NodeStructure(3));
        node1.addChild(new NodeStructure(4));
        node1.addChild(new NodeStructure(5));

        int sum = NodeStructure.countAllChildren(node1);





        int i = 5;

    }
}
