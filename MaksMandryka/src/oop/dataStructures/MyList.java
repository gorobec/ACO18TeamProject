package oop.dataStructures;


import java.util.Comparator;

/**
 * Created by fmandryka on 04.02.2017.
 */
public interface MyList<T>{

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

    public void sort(Comparator<? super T> c);
}
