package week3.day2.homeWork;

public class Node<T>  {
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

    public Node(T value, Node<T> next, Node<T> previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }
}
