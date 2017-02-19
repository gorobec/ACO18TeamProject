package week3.day2.homeWork.changeList;

/**
 * Created by Мастер on 11.02.2017.
 */
public class RunList {

    public static void main(String[] args) {
        ListUtils list = new ListUtils();
        /*list.add("111");
        list.add("222");
        list.add("333");*/
       // list.createStringList();
        HalfNode node7 = new HalfNode("G");
        HalfNode node6 = new HalfNode("F", node7);
        HalfNode node5 = new HalfNode("E", node6);
        HalfNode node4 = new HalfNode("D", node5);
        HalfNode node3 = new HalfNode("C", node4);
        HalfNode node2 = new HalfNode("B", node3);
        HalfNode node1 = new HalfNode("A", node2);
        HalfNode.pair(node1);
       /* System.out.println(node1.value);
        System.out.println(node2.value);
        System.out.println(node3.value);
        System.out.println(node4.value);
        System.out.println(node5.value);
        System.out.println(node6.value);
        System.out.println(tail.value);*/


        System.out.println(node7.value);
        System.out.println(node7.next.value);
        System.out.println(node6.next.value);
        System.out.println(node5.next.value);
        System.out.println(node4.next.value);
        System.out.println(node3.next.value);
        System.out.println(node2.next.value);


    }
}
