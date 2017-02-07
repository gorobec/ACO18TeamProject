package data_structures;

import java.util.List;

/**
 * Created by Nastia on 07.02.17.
 */
public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private Node<T> previous;
    private Node<T> next;
    private int size = 0;

    @Override
    public boolean add(T object) {
        if (head == null) {
            head = tail = new Node<T>(object);
        } else {
            tail.next = new Node<T>(object, tail);
            //tail.next.previous = tail;
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
    public boolean remove(int index) {
        return false;
    }

    public boolean wrongIndex(int index) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    public Node<T> findNode(T object) {
        Node<T> tmpNode = head;
        if (object == null){
            for (int i = 0; i < size() ; i++) {
                if(object == tmpNode.value){
                    return tmpNode;
                }
                tmpNode = tmpNode.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (object.equals(tmpNode.value)) {
                    return tmpNode;
                }
                tmpNode = tmpNode.next;
            }
        }
        return null;
    }



    @Override
    public boolean remove(T object) {
        Node<T> forDeleteNode = findNode(object);
        if (forDeleteNode == null) return false;
        if(forDeleteNode != head){
            forDeleteNode.previous.next = forDeleteNode.next;
        } else {
            head = forDeleteNode.next;
        }
        if(forDeleteNode != tail){
            forDeleteNode.next.previous = forDeleteNode.previous;

        }else {
            tail = forDeleteNode.previous;
        }
        forDeleteNode.previous = null;
        forDeleteNode.next = null;
        size--;
        return true;
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
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
