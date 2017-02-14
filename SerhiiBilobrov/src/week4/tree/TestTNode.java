package week4.tree;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class TestTNode {

    public static void main(String[] args) {
        TNode root = new TNode(1)
                .addChild(new TNode(2)
                        .addChild(new TNode(3))
                        .addChild(new TNode(3))
                        .addChild(new TNode(3)))
                .addChild(new TNode(2))
                .addChild(new TNode(2)
                        .addChild(new TNode(3)
                                .addChild(new TNode(4))
                                .addChild(new TNode(4))));





    }

    public static int sum(TNode currNode){

        if(currNode == null){
            return 0;
        }

        if(currNode.getSubNodes().isEmpty()){
            return currNode.getValue();
        }

        int acc = currNode.getValue();
        for (TNode child : currNode.getSubNodes()) {
            acc += sum(child);
        }

        return acc;
    }


}
