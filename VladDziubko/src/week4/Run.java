package week4;


public class Run {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);

        node.addChild(new TreeNode(2));
        node.addChild(new TreeNode(3));
        node.addChild(new TreeNode(4));

        System.out.println(node.childCounter(node));
    }


}
