package data_structures;

/**
 * Created by gorobec on 04.02.17.
 */
public class TestList {
    public static void main(String[] args) {
        MyList<String> list = new MyLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.remove("5");
    }
}
