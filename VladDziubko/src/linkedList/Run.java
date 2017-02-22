package linkedList;

public class Run {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("1");
        list.add(1, "90");
        list.add("12");
        list.remove(1);
        System.out.println(list.size());
    }
}
