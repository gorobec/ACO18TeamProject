package data_structures;

/**
 * Created by ksyashka on 11.02.2017.
 */
public class TestNode {
    public static void main(String[] args) {
        TNode root = new TNode(1)
                .addChild(new TNode(2)
                        .addChild(new TNode(3))
                        .addChild(new TNode(3))
                        .addChild(new TNode(3)))
                .addChild(new TNode(2))
                .addChild(new TNode(2)
                        .addChild(new TNode(3))
                        .addChild(new TNode(3))
                        .addChild(new TNode(3)));
        System.out.println(sumValue(root));
    }

    public static int sumValue(TNode currNode) {
        if (currNode == null) return 0;
        if (currNode.getChildren().isEmpty()) return currNode.getValue();

        int acc = currNode.getValue();
        for (TNode child : currNode.getChildren())
            acc += sumValue(child);
        return acc;
    }
}
