package week3.day2.homeWork.changeList;
import java.lang.String;

public class HalfNode<String> {
    String value;
    HalfNode<String> next;

    public HalfNode(String value, HalfNode<String> next) {
        this.value = value;
        this.next = next;
    }

    public HalfNode(String value) {
        this.value = value;
    }
}
