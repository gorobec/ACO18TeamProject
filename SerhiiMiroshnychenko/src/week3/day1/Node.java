package week3.day1;

/**
 * Created by serhiim on 04-Feb-17.
 */
public class Node<T> {
    T value;
    Node<T> next;
    Node<T> previous;

    public Node(T object) {
        this.value = object;
    }
}
