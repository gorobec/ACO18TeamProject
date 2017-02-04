package week1.homework.arrayList;

/**
 * Created by serhiim on 30-Jan-17.
 */
public interface MyList {

    boolean add(Object object);
    boolean add(int index, Object object);
    Object getObject(int index);
    boolean remove(int index);
    boolean remove(Object object);
    boolean set(int index, Object object);
    boolean clear();
    boolean contains(Object object);
    int size();
}
