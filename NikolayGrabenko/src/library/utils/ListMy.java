package library.utils;

/**
 * Created by User on 28.01.2017.
 */
public interface ListMy {

    boolean add(Object o);

    boolean add(int index, Object o);

    Object get(int index);

    boolean remove(int index);

    boolean remove(Object obj);

    boolean set(int index, Object obj);

    void clear();

    boolean contains(Object obj);

    int size();
}
