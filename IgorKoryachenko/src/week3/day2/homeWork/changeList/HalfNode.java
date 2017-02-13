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



    static void  pair(HalfNode node){
        if (node.next == null){
            HalfNode newFst = node.next;
            return;
        }
        HalfNode fst = node;
        HalfNode snd = fst.next;
        pair(snd);
        snd.next = fst;
        fst.next = null;

        //return fst;
    }
}
