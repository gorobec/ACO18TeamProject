package oop.week4.nodeStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fmandryka on 11.02.2017.
 */
public class NodeStructure<T> {

    private T value;
    private List<NodeStructure<T>> children = new ArrayList<>();


    public NodeStructure(T value, List<NodeStructure<T>> children) {
        this.value = value;
        this.children = children;
    }

    public NodeStructure(T value) {
        this.value = value;
    }

    public NodeStructure addChild(NodeStructure node) {
        this.children.add(node);
        return this;
    }

    public static int countAllChildren(NodeStructure<Integer> node) {

        if (node == null) {
            return 0;
        }

        if (node.children.size() == 0) {
            return node.value;
        }

        int nodev = node.value;

        for (NodeStructure<Integer> ns: node.children) {
            nodev += countAllChildren(ns);
        }

        return nodev;

    }

}
