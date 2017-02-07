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
        checkIndexAdd(index);

        if (index == size) {
            add(element);
        } else {
            // looking for node at this index
            Node<E> nodeAtThisIndex = findNodeByIndex(index);
            // save prev and next (for better understanding)
            Node prev = nodeAtThisIndex.prev;
            Node next = nodeAtThisIndex;
            // insert new node
            prev.next = new Node(prev, element, next);
            next.prev = prev.next;
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
        checkIndex(index);

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
        checkIndex(index);

        return findNodeByIndex(index).item;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);

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

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkIndexAdd(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node<E> findNodeByIndex(int index) {
        if (index < 0 || index > size) {
            return null;
        }

        Node<E> iterator = head;

        for (int i = 0; i < index; i++) {
            iterator = iterator.next;
        }
        return iterator;
    }

    private boolean deleteNode(Node<E> forDelete) {
        if (forDelete == null) return false;

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
        size--;
        return true;
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentPosition = 0;

            @Override
            public boolean hasNext() {
                return currentPosition < size;
            }

            @Override
            public E next() {
                return findNodeByIndex(currentPosition++).item;
            }
        };
    }
}