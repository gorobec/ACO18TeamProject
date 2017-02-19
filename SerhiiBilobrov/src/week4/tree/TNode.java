package week4.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class TNode {

    private int value;
    private List<TNode> subNodes;

    public TNode(int value) {
        this.value = value;
        this.subNodes = new LinkedList<>();
    }

    // builder pattern
    public TNode addChild(TNode child) {
        subNodes.add(child);
        return this;
    }

    public List<TNode> getSubNodes() {
        return subNodes;
    }

    public int getValue() {
        return value;
    }
}
