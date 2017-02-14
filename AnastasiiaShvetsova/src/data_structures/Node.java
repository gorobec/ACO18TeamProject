package data_structures;

/**
 * Created by Nastia on 07.02.17.
 */
public class Node<T> {
    T value;
    Node<T> previous;
    Node<T> next;

    public Node(T val){
        value = val;
    }
    public Node(T val, Node<T> previous){
        value = val;
        this.previous = previous;
    }

}
