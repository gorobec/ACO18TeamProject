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
    private Node<T> elements;

    @Override
    public boolean add(T object) {
        if (head == null) {
            head = tail = new Node<T>(object);
        } else {
            tail.next = new Node<T>(object);
            tail.next.previous = tail;
            tail = tail.next;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, T object) {
        Node newNode = new Node<T>(object);
        if (wrongIndex(index)) return false;
        if (head == null && index == 0) {
            head = tail = new Node<T>(object);
            return true;
        }
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                newNode.next = current;

                if (index == 0) {
                    head = newNode;
                    newNode.previous = null;
                } else {
                    newNode.previous = current.previous;
                    newNode.previous.next = current.previous.next;

                }
                if (index == size - 1) {
                    tail = newNode;
                    newNode.next = null;
                } else {
                    newNode.next.previous = current.previous;
                }

                current.previous = newNode;
            }
            current = current.next;
        }
        size++;
        return true;

    }

    @Override
    public boolean remove(int index) {
        Node forDeleteNode = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                if (index == 0) {
                    head = forDeleteNode.next;
                    size--;
                    return  true;
                } else if (index == size - 1) {
                    tail = forDeleteNode.previous;
                    size--;
                    return  true;
                } else {
                    forDeleteNode.previous.next = forDeleteNode.next;
                    forDeleteNode.next.previous = forDeleteNode.previous;
                }

                forDeleteNode.previous = null;
                forDeleteNode.next = null;
            }

            forDeleteNode = forDeleteNode.next;
        }
        size--;
        return true;
    }

    public boolean wrongIndex(int index) {
        return index < 0 || index > size - 1;
    }

    @Override
    public T get(int index) {
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                if (index == 0){
                    return head.value;
                }
                if (index == size -1){
                    return tail.value;
                }
            }
            currentNode = currentNode.next;
        }
        return (T) currentNode.value;
    }

    public Node<T> findNode(T object) {
        Node<T> tmpNode = head;
        if (object == null) {
            for (int i = 0; i < size(); i++) {
                if (object == tmpNode.value) {
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
        if (forDeleteNode != head) {
            forDeleteNode.previous.next = forDeleteNode.next;
        } else {
            head = forDeleteNode.next;
        }
        if (forDeleteNode != tail) {
            forDeleteNode.next.previous = forDeleteNode.previous;

        } else {
            tail = forDeleteNode.previous;
        }
        forDeleteNode.previous = null;
        forDeleteNode.next = null;
        size--;
        return true;
    }

    @Override
    public boolean set(int index, T object) {
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                if (index == 0){
                    head.value = object;
                }
                if (index == size -1){
                    tail.value = object;
                }
                currentNode.value = object;
            }
            currentNode = currentNode.next;
        }
        return true;
    }

    @Override
    public boolean clear() {
        for (int i = 0; i < size ; i++) {
           remove(0);
        }
        return true;
    }

    @Override
    public boolean contains(T object) {
        Node<T> tmpNode = head;
        if (object == null) {
            for (int i = 0; i < size(); i++) {
                if (object == tmpNode.value) {
                    return true;
                }
                tmpNode = tmpNode.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (object.equals(tmpNode.value)) {
                    return true;
                }
                tmpNode = tmpNode.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
