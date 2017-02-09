package library.utils;

public interface ListMy <T> {

    boolean add(T o);

    boolean add(int index, T o);

    T get(int index);

    boolean remove(int index);

    boolean remove(T obj);

    boolean set(int index, T obj);

    void clear();

    boolean contains(T obj);

    int size();
}
