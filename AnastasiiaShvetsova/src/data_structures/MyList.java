package data_structures;

/**
 * Created by Nastia on 06.02.17.
 */
public interface MyList<T> {
    boolean add(T object);
    boolean add(int index, T object);
    T get(int index);
    boolean remove(T object);
    boolean set(int index, T object);
    boolean clear();
    boolean contains(T object);
    int size();
    boolean isEmpty();
}
