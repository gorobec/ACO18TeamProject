package oop.weak1.task_7_arrayList;

import java.util.Collection;
import java.util.Objects;

/**
 * Created by Администратор on 27.01.2017.
 */
public class MyArrayList {

    int size = 0;
    Object[] array = new Object[0];

    public MyArrayList() {
    }

    public MyArrayList(int initCapacity) {

        if (initCapacity > 0) {
            Object[] array = new Object[initCapacity];
            this.array = array;
        }
    }

    public MyArrayList(Object[] array) {

        if (array != null && array.length > 0) {
            this.array = array;
            this.size = array.length;
        }
    }


    public void ensureCapacity(int capacity) {

        if (this.array.length < capacity) {

            Object[] array = new Object[capacity];
            System.arraycopy(this.array, 0, array, 0, this.array.length);
            this.array = array;
        }
    }

    public void ensureCapacity() {

        if (this.array.length * 3 / 2 + 1 < Integer.MAX_VALUE) {

            Object[] array = new Object[this.array.length * 3 / 2 + 1];
            System.arraycopy(this.array, 0, array, 0, this.array.length);
            this.array = array;

        } else {
            if (this.array.length != Integer.MAX_VALUE) {

                Object[] array = new Object[Integer.MAX_VALUE];
                System.arraycopy(this.array, 0, array, 0, this.array.length);
                this.array = array;
            }
        }
    }

    public void trimToSize() {

        if (this.array.length != size) {

            Object[] array = new Object[size];
            System.arraycopy(this.array, 0, array, 0, size);
            this.array = array;
        }
    }

    public boolean add(Object o) {

        if (size < this.array.length) {
            this.array[++size-1] = o;
        } else {
            ensureCapacity();
            this.array[++size-1] = o;
        }

        return true;

    }


    public boolean add(int index, Object o) {


        if (index == size -1 || size == this.array.length - 1) {
            ensureCapacity();
        }

        if (index >= 0 && index < size - 1) {

            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = o;
            ++size;
            return true;

        }

        return false;
    }

    public Object get(int index) {

        if (index >= 0 && index < size) {
            return this.array[index];
        }

        throw new ArrayIndexOutOfBoundsException("Недопустимый параметр index");
    }

    public boolean remove(int index) {

        if (index >= 0 && index < size) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
            --size;
            return true;
        }
        throw new IndexOutOfBoundsException();

    }

    public boolean remove(Object o) {

        if (contains(o)) {
            System.arraycopy(array, indexOf(o) + 1, array, indexOf(o), size - 1 - indexOf(o));
            --size;
            return true;
        }
        return false;
    }

    public boolean set(int index, Object o) {

        if (index >= 0 && index < size) {
            this.array[index] = o;
            return true;
        }
        return false;
    }

    public void clear() {

        for (int i = 0; i < size; i++) {
            array[i] = null;
        }

    }

    public int size() {
        return size;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o) {

        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (array[i].equals(o)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                sb.append(array[i].toString() + ", ");
            } else {
                sb.append("null, ");
            }
        }

        return sb.toString();

    }


}
