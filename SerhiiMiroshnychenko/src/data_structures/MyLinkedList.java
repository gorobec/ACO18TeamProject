package data_structures;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by serhiim on 04-Feb-17.
 */
public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public boolean add(T object) {
        if (head == null){
            head = tail = new Node<>(object);
        } else {
            tail.next = new Node<>(object);
            tail.next.previous = tail;
            tail = tail.next;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, T object) {
        return false;
    }

    @Override
    public T getObject(int index) {
        return null;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean remove(T object) {
        Node<T> forDelete = findNode(object);
        if (forDelete == null) return false;
        if (forDelete != head){
            forDelete.previous.next = forDelete.next;
            //TODO kill links
        } else {
            head = forDelete.next;

        }
        forDelete.previous = null;
        if(forDelete != tail) {
            forDelete.next.previous = forDelete.previous;
            //TODO kill links
        } else {
            tail = forDelete.previous;
            tail.next = null;
        }
        forDelete.previous = null;
        size--;
        return true;
    }

    public Node<T> findNode(T object) {
        Node<T> iterator = head;
        if (object ==  null){
            for (int i = 0; i < size; i++) {
                if (object.equals(iterator.value)){
                    return iterator;
                }
                iterator = iterator.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (object.equals(iterator.value)) {
                    return iterator;
                }
                iterator = iterator.next;
            }
        }
        return null;
    }

    @Override
    public boolean set(int index, T object) {
        return false;
    }

    @Override
    public boolean clear() {
        return false;
    }

    @Override
    public boolean contains(T object) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
