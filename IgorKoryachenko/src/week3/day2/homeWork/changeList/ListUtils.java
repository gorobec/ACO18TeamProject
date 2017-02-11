package week3.day2.homeWork.changeList;
import java.lang.String;

public class ListUtils implements A {
    HalfNode<String> tail;
    int size;

    public void createStringList(){

            HalfNode <String> tail = new HalfNode<>("G");
            HalfNode <String> node6 = new HalfNode<>("F", tail);
            HalfNode <String> node5 = new HalfNode<>("E", node6);
            HalfNode <String> node4 = new HalfNode<>("D", node5);
            HalfNode <String> node3 = new HalfNode<>("C", node4);
            HalfNode <String> node2 = new HalfNode<>("B", node3);
            HalfNode <String> node1 = new HalfNode<>("A", node2);
    }

    public static A reversion(A node){
        HalfNode fst = new HalfNode(node);
        HalfNode snd = new HalfNode(node);
        HalfNode temp = new HalfNode(node);
        return node;
    }

    void pair(HalfNode node){
        HalfNode fst = node;
        HalfNode snd = fst.next;

        if (snd != tail) pair(snd.next);
        if (fst != node) {
            snd.next = fst;
        }

        //System.out.println(snd.value);


        //return fst;
    }

    public boolean add(String str){
        if (size == 0){
            tail = new HalfNode<>( str);
        } else {
            HalfNode<String> node = new HalfNode<>(str);
            tail.next = node;
            node = tail;

        }
        return true;
    }

    @Override
    public void setNext(A next) {

    }

    @Override
    public A getNext() {

        return null;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
