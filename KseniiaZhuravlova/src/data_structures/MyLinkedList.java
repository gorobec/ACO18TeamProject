package data_structures;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by ksyashka on 04.02.2017.
 */
public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public boolean add(T object) {
        if (head == null) {
            head = tail = new Node<>(object);
        } else {
            tail.next = new Node<>(object, tail);
            tail = tail.next;
        }
        size++;
        return true;
    }

    private boolean rangeCheck(int index) {
        if (index >= size || index < 0) {
            System.out.printf("Index - %d, size: - %d\n", index, size);
            return false;
        }
        return true;
    }

    @Override
    public boolean add(int index, T object) {
        if (index > size || index < 0) System.exit(-1);
        if (index == size) add(object);
        else {
            if (index == 0) {
                head.previous = new Node<>(object, null, head);
                head = head.previous;
            } else {
                Node<T> currentNode = head;
                for (int i = 0; i < index; i++)
                    currentNode = currentNode.next;
                currentNode.previous.next = new Node<>(object, currentNode.previous, currentNode);
                currentNode.previous = currentNode.previous.next;
            }
            size++;
        }
        return true;
    }

    @Override
    public T get(int index) {
        if (!rangeCheck(index)) System.exit(-1);
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.next;
        return currentNode.value;
    }

    @Override
    public T remove(int index) {
        if (!rangeCheck(index)) System.exit(-1);
        Node<T> currentNode = head;
        if (index == 0) {
            head = head.next;
        } else {
            for (int i = 0; i < index; i++)
                currentNode = currentNode.next;
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }
        size--;
        return currentNode.value;
    }

    @Override
    public boolean remove(T object) {
        Node<T> forDelete = findNode(object);
        if (forDelete == null) return false;
        if (forDelete != head) {
            forDelete.previous.next = forDelete.next;
        } else {
            head = forDelete.next;
        }
        if (forDelete != tail) {
            forDelete.next.previous = forDelete.previous;
        } else {
            tail = forDelete.previous;
        }
        size--;
        return true;
    }

    private Node<T> findNode(T object) {
        Node<T> iterator = head;
        if (object == null) {
            for (int i = 0; i < size; i++) {
                if (object == iterator.value)
                    return iterator;
                iterator = iterator.next;
            }

        } else {
            for (int i = 0; i < size; i++) {
                if (object.equals(iterator.value))
                    return iterator;
                iterator = iterator.next;
            }
        }
        return null;
    }

    @Override
    public T set(int index, T object) {
        if (!rangeCheck(index)) System.exit(-1);
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.next;
        T returnValue = currentNode.value;
        currentNode.value = object;
        return returnValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    private int indexOf(Object object) {
        Node<T> iterator = head;
        if (object == null) {
            for (int i = 0; i < size; i++) {
                if (null == iterator.value)
                    return i;
                iterator = iterator.next;
            }

        } else {
            for (int i = 0; i < size; i++) {
                if (object.equals(iterator.value))
                    return i;
                iterator = iterator.next;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new LLIterator();
    }

    private class LLIterator implements Iterator<T> {
        Node<T> currentNode = head;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            Node<T> returnNode = currentNode;
            currentNode = currentNode.next;
            return returnNode.value;
        }
    }

    private static class Node<V> {
        V value;
        Node<V> next;
        Node<V> previous;

        private Node(V value) {
            this.value = value;
        }

        private Node(V value, Node<V> previous) {
            this.value = value;
            this.previous = previous;
        }

        private Node(V value, Node<V> previous, Node<V> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
}