package oop.weak1.task_7_arrayList;


/**
 * Created by fmandryka on 04.02.2017.
 */
public interface myList<T>{

    int size();

    boolean contains(Object o);

    boolean add(T o);

    boolean remove(Object o);

    void clear();

    T get(int i);

    boolean add(int i, T o);

    T remove(int i);

    T set(int i, T o);

    int indexOf(Object o);

    boolean isEmpty();
}
