package week1.dynamicArray;

import java.util.Arrays;
import java.util.Collection;

public class NewArrayList<E> {
    private int size;
    private E[] data;
    private static final int DEF_CAPASITY = 10;
    private static final Object[] EMPTY_DATA = {};
    private static final Object[] DEFAULTCAPASITY_EMPTY = {};

    public NewArrayList() {
        data = (E[]) new Object[DEF_CAPASITY];
    }

    public NewArrayList(int initialCapasity) {
        if (initialCapasity < 0) {
            throw new IllegalArgumentException("Illegal capasity: " + initialCapasity);
        }
        if (initialCapasity > 0) {
            data = (E[]) new Object[initialCapasity];
        }
        if (initialCapasity == 0) {
            data = (E[]) DEFAULTCAPASITY_EMPTY;
        }
    }

    public NewArrayList(Collection<? extends E> c) {
        data = (E[]) c.toArray();
        if ((size = data.length) != 0) {
            if (data.getClass() != Object[].class) {
                data = (E[]) Arrays.copyOf(data, size, Object[].class);
            }
        } else {
            data = (E[]) EMPTY_DATA;
        }
    }

    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if(o.getClass() == this.getClass()){
            return true;
        }
        NewArrayList<E> localList = (NewArrayList<E>) o;
        if (size != localList.size) {
            return false;
        }
        for (int i = 0; i < data.length; i++) {
            if (!(localList.equals(data[i]))) {
                return false;
            }
        }
        return true;
    }

    private void grow(int minCapasity) {
        int oldCapasity = data.length;
        int newCapasity = oldCapasity + 5;
        if (newCapasity - minCapasity < 0) {
            newCapasity = minCapasity;
        }
        data = Arrays.copyOf(data, newCapasity);
    }

    private void ensureCapacity(int minCapacity) {
        int minExpand = (data != DEFAULTCAPASITY_EMPTY) ? 0 : DEF_CAPASITY;
        if (minCapacity > minExpand) {
            if (minCapacity - data.length > 0) {
                grow(minCapacity);
            }
        }
    }

    // size()
    public int size() {
        return size;
    }

    // get()
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    // clear()
    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
        size = 0;
    }

    // set()
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Illegal argument " + index);
        }
        E old = data[index];
        data[index] = element;
        return old;
    }

    // add
    public boolean add(E element) {
        ensureCapacity(size + 1);
        data[size++] = element;
        return true;
    }

    // add by index
    public boolean add(int index, E element) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Illegal argument " + index);
        }
        ensureCapacity(size + 1);
        data =  (E[]) new Object[size + 1];
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
        return true;
    }

    // indexOf
    private int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < data.length; i++) {
                if (o.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    // contains
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    // remove by index
    public E remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E oldVal = data[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        data[--size] = null;
        return oldVal;
    }

    // remove object
    public boolean remove(E o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if(data[i] == null){
                    fastRemove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if(o.equals(data[i])){
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }


    private void fastRemove(int index){
        int numMoved = size - index - 1;
        if(numMoved > 0){
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        data[--size] = null;
    }
}
