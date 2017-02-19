package week3.day2.homeWork.changeList;
import java.lang.String;

public class HalfNode {
    String value;
    HalfNode next;

    public HalfNode(String value, HalfNode next) {
        this.value = value;
        this.next = next;
    }

    public HalfNode(String value) {
        this.value = value;
    }



    static HalfNode  pair(HalfNode node){
        HalfNode newFst = null;
        if (node.next == null){
            newFst = node.next;
            return null;
        }
        HalfNode fst = node;
        HalfNode snd = fst.next;
        pair(snd);
        snd.next = fst;
        fst.next = null;

        return newFst;
    }
}
