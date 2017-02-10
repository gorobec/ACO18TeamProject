package oop.myLinkedList;

import oop.weak1.task_7_arrayList.MyList;

import java.util.Comparator;

/**
 * Created by Администратор on 09.02.2017.
 */
public class MyLinkedList<T> implements MyList<T> {

    int size;
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
        return indexOf(o) >= -1;
    }

    @Override
    public boolean add(T o) {



        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int i) {
        return null;
    }

    @Override
    public boolean add(int i, T o) {
        return false;
    }

    @Override
    public T remove(int i) {
        return null;
    }

    @Override
    public T set(int i, T o) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void sort(Comparator<? super T> c) {

    }

    private static class MyNode<E> {

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
