package ACO.data_structures;

import java.util.Iterator;

/**
 * Created by v21k on 25.01.17.
 */
public class MyArrayList<E> implements MyList<E> {
    // for default constructor
    private static final int DEFAULT_SIZE = 5;

    private Object[] elements;
    private int size = 0;
    private int count = 0;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_SIZE];
        size = DEFAULT_SIZE;
    }

    public MyArrayList(E[] elements) {
        this.elements = elements;
        size = elements.length;
    }

    public MyArrayList(int size) {
        if (size > 0) {
            elements = new Object[size];
            this.size = size;
        } else if (size == 0) {
            this.elements = new Object[DEFAULT_SIZE];
            size = DEFAULT_SIZE;
        } else {
            System.out.println("Wrong input, index must be positive number.");
            throw new IllegalArgumentException();
        }
    }

    public boolean add(E o) {
        if (count == size) {
            ensureCapacity(5);
            elements[count++] = o;
        } else {
            elements[count++] = o;
        }
        return true;
    }

    public void add(int index, E o) {
        indexCheckForAdd(index);

        if (count == size) {
            ensureCapacity(5);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index - 1);
        elements[index] = o;
        count++;
    }

    public E remove(int index) {
        checkIndex(index);
        Object tmp = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[count--] = null;
        return (E) tmp;
    }

    public boolean remove(Object o) {
        if (indexOf(o) >= 0) {
            remove(indexOf(o));
            return true;
        }
        return false;
    }

    public int size() {
        return count;
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    public E set(int index, E o) {
        checkIndex(index);
        Object tmp = elements[index];
        elements[index] = o;
        return (E) tmp;
    }

    public void clear() {
        for (int i = 0; i < count; i++) {
            elements[i] = null;
        }
        count = 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < count; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < count; i++) {
                if (elements[i].equals(o)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void ensureCapacity(int number) {
        E[] tmp = (E[]) new Object[size + number];
        System.arraycopy(elements, 0, tmp, 0, size);
        elements = tmp;
        size += number;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void indexCheckForAdd(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ALIterator();
    }

    private class ALIterator implements Iterator<E> {
        int currentPosition;

        private ALIterator() {
            currentPosition = 0;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < size();
        }

        @Override
        public E next() {
            return (E) elements[currentPosition++];
        }
    }
}
