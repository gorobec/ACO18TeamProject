package ACO.data_structures;

import java.util.Iterator;

/**
 * Created by v21k on 06.02.17.
 */
public class MyLinkedList<E> implements MyList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public boolean add(E element) {
        if (size == 0) {
            head = tail = new Node<E>(null, element, null);
        } else {
            tail.next = new Node<E>(tail, element, null);
            tail = tail.next;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == size) {
            add(element);
        } else {
            // looking for node at this index
            Node<E> nodeAtThisIndex = findNodeByIndex(index);
            // save prev (for better understanding)
            Node<E> prev = nodeAtThisIndex.prev;
            // insert new node
            prev.next = new Node<>(prev, element, nodeAtThisIndex);
            nodeAtThisIndex.prev = prev.next;
            size++;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> node = head; node != null; node = node.next) {
                if (node.item == null) {
                    deleteNode(node);
                    return true;
                }
            }
        } else {
            for (Node<E> node = head; node != null; node = node.next) {
                if (o.equals(node.item)) {
                    deleteNode(node);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {

        Node<E> forDelete = findNodeByIndex(index);
        E element = forDelete.item;
        deleteNode(forDelete);

        return element;
    }

    @Override
    public void clear() {
        Node<E> nodeForDelete = head;

        while (nodeForDelete != null) {
            Node<E> next = nodeForDelete.next;
            nodeForDelete.item = null;
            nodeForDelete.next = nodeForDelete.prev = null;
            nodeForDelete = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        return findNodeByIndex(index).item;
    }

    @Override
    public E set(int index, E element) {

        Node<E> nodeToSet = findNodeByIndex(index);
        E tmp = nodeToSet.item;
        nodeToSet.item = element;

        return tmp;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> iterator = head;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (o == iterator.item) {
                    return i;
                }
                iterator = iterator.next;
            }

        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(iterator.item)) {

                    return i;
                }
                iterator = iterator.next;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    private Node<E> findNodeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> iterator = head;

        for (int i = 0; i < index; i++) {
            iterator = iterator.next;
        }

        return iterator;
    }

    private boolean deleteNode(Node<E> forDelete) {
        // change links for next and prev
        if (forDelete != head) {
            forDelete.prev.next = forDelete.next;
        } else {
            head = forDelete.next;
        }

        if (forDelete != tail) {
            forDelete.next.prev = forDelete.prev;
        } else {
            tail = forDelete.prev;
        }

        // delete links for deleted Node
        forDelete.prev = forDelete.next = null;
        forDelete.item = null;
        size--;
        return true;
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LLIterator();
    }

    private class LLIterator implements Iterator<E> {
        private Node<E> first;
        private E tmp;

        private LLIterator() {
            this.first = head;
        }

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public E next() {
            tmp = first.item;
            first = first.next;
            return tmp;
        }
    }
}
