package week1.homework.arrayList;

/**
 * Created by serhiim on 30-Jan-17.
 */
public interface MyList<T> {

    boolean add(T object);
    boolean add(int index, T object);
    T getObject(int index);
    T remove(int index);
    boolean remove(T object);
    boolean set(int index, T object);
    boolean clear();
    boolean contains(T object);
    int size();
}
