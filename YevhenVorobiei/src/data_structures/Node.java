package data_structures;

/**
 * Created by gorobec on 04.02.17.
 */
public class Node<T> {
    T value;
    Node<T> next;
    Node<T> previous;

    public Node(T object) {
        value = object;
    }

    public Node(T object, Node<T> previous) {
        value = object;
        this.previous = previous;
    }
}
