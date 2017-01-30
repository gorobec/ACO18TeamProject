package data_structures;

/**
 * Created by ksyashka on 28.01.2017.
 */
public interface MyList {

    boolean add(Object object);
    boolean add(int index, Object object);
    Object get(int index);
    Object remove(int index);
    boolean remove(Object object);
    void trimToSize();
    Object set(int index, Object object);
    int size();
    boolean isEmpty();
    boolean contains(Object object);
    void clear();


}
