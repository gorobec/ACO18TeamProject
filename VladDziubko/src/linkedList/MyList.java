package linkedList;

interface MyList<E> {
    public int size();

    public boolean contains(Object o);

    public boolean add(E e);

    public boolean remove(E o);

    public void clear();

    public E get(int index);

    public E set(int index, E element);

    public boolean add(int index, E element);

    public E remove(int index);

    public int indexOf(Object o);

    public boolean isEmpty();
}
