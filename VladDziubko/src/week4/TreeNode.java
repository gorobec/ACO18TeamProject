package week4;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    private int value;
    private List<TreeNode> nodes = new LinkedList<>();

    public int getValue() {
        return value;
    }

    public List<TreeNode> getNode() {
        return nodes;
    }

    public TreeNode(int value){
        this.value = value;
    }
    public TreeNode addChild(TreeNode treeNode){
        nodes.add(treeNode);
        return this;
    }

    public int childCounter(TreeNode node){
        if(node == null){
            return 0;
        }
        if(node.getNode().isEmpty()){
            return node.getValue();
        }
        int counter = value;
        for(TreeNode child : nodes){
            counter += childCounter(child);
        }
        return counter;
    }

}
