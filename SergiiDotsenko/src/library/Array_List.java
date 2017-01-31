package library;
public class Array_List<E> {
    private E[] theData;
    private int size = 0;
    private int capacity = 0;

    public Array_List() {
        this(10);
    }

    public Array_List(int initCapacity) {
        capacity = initCapacity;
        theData = (E[]) new Object[capacity];
    }

    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException();
        }

        if (size == capacity) {
            reallocate();
        }

        theData[size] = e;
        size++;

        return true;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        if (e == null) {
            throw new NullPointerException();
        }

        if (size == capacity) {
            reallocate();
        }

        for (int i = size; i > index; i--) {
            theData[i] = theData[i - 1];
        }

        theData[index] = e;
        size++;
    }

    public void clear() {
        theData = (E[]) new Object[capacity];
        size = 0;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        Array_List<E> otherO = (Array_List<E>) o;

        if (size != otherO.size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!theData[i].equals(otherO.theData[i])) {
                return false;
            }
        }

        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    public int indexOf(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }

        for (int i = 0; i < size; i++) {
            if (theData[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        E temp = theData[index];

        for (int i = index + 1; i < size; i++) {
            theData[i - 1] = theData[i];
        }

        size--;
        return temp;
    }

    public boolean remove(Object o) {
        int indexOfO = indexOf(o);

        if (indexOfO == -1) {
            return false;
        }

        remove(indexOfO);
        return true;
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        if (e == null) {
            throw new NullPointerException();
        }
        E temp = theData[index];
        theData[index] = e;
        return temp;
    }

    public int size() {
        return size;
    }

    private void reallocate() {
        capacity *= 2;
        E[] newArraylist = (E[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newArraylist[i] = theData[i];
        }

        theData = newArraylist;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }
}