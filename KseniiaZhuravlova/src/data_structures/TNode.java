package data_structures;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ksyashka on 11.02.2017.
 */
public class TNode{
    private int value;
    private List<TNode> children = new LinkedList<>();

    public TNode(int value) {
        this.value = value;
    }

    public TNode addChild(TNode child){
        children.add(child);
        return this;
    }

    public int sizeChildren(){
        return children.size();
    }

    public List<TNode> getChildren() {
        return children;
    }

    public int getValue() {
        return value;
    }
}
