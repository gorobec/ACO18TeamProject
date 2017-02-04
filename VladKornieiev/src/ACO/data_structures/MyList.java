package ACO.data_structures;

/**
 * Created by v21k on 04.02.17.
 */
public interface MyList<E> {
    boolean add(E element);

    void add(int index, E element);

    boolean remove(Object o);

    E remove(int index);

    void clear();

    E get(int index);

    E set(int index, E element);

    int indexOf(Object o);

    int size();

    boolean contains(Object o);
}
