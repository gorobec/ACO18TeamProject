package oop.dataStructures;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by Администратор on 09.02.2017.
 */
public class MyLinkedList<T> implements MyList<T>, Iterable<T> {

    protected int size;
    MyNode<T> first;
    MyNode<T> last;

    public MyLinkedList() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) > -1;
    }

    @Override
    public boolean add(T o) {

        MyNode<T> node = new MyNode<T>(o, null, null);

        if (last == null) {
            first = last = node;
            size++;
        } else if (size == 1) {
            node.prev = last;
            first.next = node;
            last = node;
            size++;
        } else {
            node.prev = last;
            last.next = node;
            last = node;
            size++;
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {

        if (size == 0) {
            return false;
        }

        MyNode<T> node = first;

        do {
            if (node.element == null || node.element.equals(o)) {
                unlink(node);
                return true;
            }
            node = node.next;
        } while (node != null);

        return false;
    }

    @Override
    public void clear() {

        for (MyNode<T> node = first; node != null; node = node.next) {
            node.next = null;
            node.prev = null;
        }

        first = last = null;
        size = 0;

    }

    @Override
    public T get(int i) {

        checkIndex(i);

        MyNode<T> node = first;

        for (int j = 0; j < i; j++) {
            node = node.next;
        }

        return node.element;
    }

    @Override
    public boolean add(int i, T o) {

        checkIndexforExtension(i);

        MyNode<T> newNode = new MyNode<>(o, null, null);

        MyNode<T> node = first;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }

        if (first == null) {
            first = last = newNode;
        } else if (node == first) {
            first.prev = newNode;
            newNode.next = first;
            newNode.prev = null;
            first = newNode;
        } else if (node == null) {
            last.next = newNode;
            newNode.next = null;
            newNode.prev = last;
            last = newNode;
        } else {
            newNode.next = node;
            newNode.prev = node.prev;
            node.prev.next = newNode;
            node.prev = newNode;
        }
        size++;
        return true;
    }


    @Override
    public T remove(int i) {
        checkIndex(i);

        MyNode<T> node = first;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        unlink(node);

        return node.element;
    }

    @Override
    public T set(int i, T o) {
        checkIndex(i);

        MyNode<T> node = first;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }

        T oldElem = node.element;
        node.element = o;

        return oldElem;
    }

    @Override
    public int indexOf(Object o) {

        int count = 0;
        for (MyNode<T> node = first; node != null; node = node.next) {
            if (o == null && node.element == null) {
                return count;
            } else if (o != null && node.element != null && node.element.equals(o)) {
                return count;
            }
            count++;
        }

        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void sort(Comparator<? super T> c) {
        // как нибудь потом
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (MyNode<T> node = first; node != null; node = node.next)
            result[i++] = node.element;
        return result;
    }


    private T unlink(MyNode<T> node) {

        T element = node.element;

        if (node == first) {
            first = first.next;
            first.prev.next = null;
            first.prev = null;
        } else if (node == last) {
            last = last.prev;
            last.next.prev = null;
            last.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = node.prev = null;
        }

        size--;
        return element;
    }

    private boolean checkIndex(int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("No such index");
        }

        return true;
    }

    private boolean checkIndexforExtension(int index) {

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("No such index");
        }

        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>();
    }

    private class LinkedListIterator<T> implements Iterator<T> {

        private MyNode<T> current;
        private int currentIndex;

        LinkedListIterator() {
            current = (MyNode<T>) first;
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            T elem = current.element;
            current = current.next;
            currentIndex++;
            return elem;
        }

    }

//    public ListIterator<T> listIterator() {
//        return new LinkedListIterator<T>();
//    }


    private class MyNode<E> {

        E element;
        MyNode<E> prev;
        MyNode<E> next;

        public MyNode(E element, MyNode<E> prev, MyNode<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

    }
}
