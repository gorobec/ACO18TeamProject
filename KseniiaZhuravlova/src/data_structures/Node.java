package data_structures;

/**
 * Created by ksyashka on 04.02.2017.
 */
public class Node<T> {
    T value;
    Node <T> next;
    Node <T> previous;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> previous) {
        this.value = value;
        this.previous = previous;
    }

    public Node(T value, Node<T> previous, Node<T> next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }
}
