package data_structures;

import java.util.Iterator;

/**
 * Created by serhiim on 27-Jan-17.
 */
public class MyArrayList<T> implements MyList<T> {
    private int size;
    private static final int DEFAULT_SIZE = 10;
    private T[] objectArr;


    public MyArrayList(int size) {
        objectArr = (T[])new Object[size];
    }

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    public T[] getObjectArr() {
        return objectArr;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T obj) {
        if (size >= objectArr.length) {
            ensureCapacity(5);
        }
        objectArr[size] = obj;
        size++;

        return true;
    }

    public boolean add(int index, T obj) {
        if (index >= objectArr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        objectArr[index] = obj;
        size++;
        return true;
    }


    public T getObject(int index) {
        if (index < 0 || index > objectArr.length) System.exit(-1);
        return objectArr[index];
    }

    public T remove(int index) {
        if (index < 0 && index < size) throw new ArrayIndexOutOfBoundsException();
        T temp = objectArr[index];
        objectArr[index] = null;
        System.arraycopy(objectArr, index + 1, objectArr, index, size - index);
        size--;
        return temp;
    }


    public boolean remove(Object object) {
        int index;
        for (int i = 0; i < objectArr.length; i++) {
            if (objectArr[i].equals(object)) {
                objectArr[i] = null;
                index = i;
                System.arraycopy(objectArr, index + 1, objectArr, index, size - index);
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean set(int index, T obj) {
        if (index < 0 && index > objectArr.length) throw new ArrayIndexOutOfBoundsException();
        objectArr[index] = obj;
        return true;
    }

    public boolean clear() {
        for (int i = 0; i < objectArr.length; i++) {
            objectArr[i] = null;
        }
        size = 0;
        return true;
    }

    public boolean contains(Object object) {
        if (object == null) {
            for (Object anObjectArr : objectArr) {
                if (anObjectArr == null) {
                    return true;
                }
            }
        }
        for (Object anObjectArr : objectArr) {
            if (anObjectArr != null && anObjectArr.equals(object)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        int count = 0;
        for (Object anObjectArr : objectArr) {
            if (anObjectArr != null) {
                count++;
            }
        }
        return count;
    }

    private void ensureCapacity(int index) {
        T[] temp = (T[]) new Object[objectArr.length + index];
        System.arraycopy(objectArr, 0, temp, 0, objectArr.length);
        objectArr = temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new ALIterator<T>(this);
    }
    private class ALIterator<T> implements Iterator<T> {

        private MyArrayList<T> list;
        private T currentElement;
        private int currentPosition;

        public ALIterator(MyArrayList<T> list){
            this.list = list;
            currentPosition = 0;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < list.size();
        }

        @Override
        public T next() {
            return list.getObjectArr()[currentPosition++];
        }
    }
}


