package data_structures;

/**
 * Created by ksyashka on 28.01.2017.
 */
public interface MyList<T> {

    boolean add(T object);
    boolean add(int index, T object);
    Object get(int index);
    Object remove(int index);
    boolean remove(T object);
    void trimToSize();
    Object set(int index, T object);
    int size();
    boolean isEmpty();
    boolean contains(Object object);
    void clear();


}
