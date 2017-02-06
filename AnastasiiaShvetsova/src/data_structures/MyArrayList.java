package data_structures;

import java.util.Arrays;
import java.util.*;
import java.util.List;

/**
 * Created by Nastia on 28.01.17.
 */
public class MyArrayList<T> implements MyList<T> {
    private int size = 0;
    private T[] objects;
    public static final int DEFAULT_SIZE = 0;

    public MyArrayList(int size) {
        this.objects = (T[]) new Object[size];
    }

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    public boolean add(T object) {
        ensureCapacity(size + objects.length / 2 + 1);
        objects[size] = object;
        size++;
        return true;
    }


    public void ensureCapacity(int minEnsureCapacity) {

        int arraylength = objects.length;
        if (minEnsureCapacity > arraylength) {
            T[] tmp = (T[]) new Object[minEnsureCapacity];
            System.arraycopy(objects, 0, tmp, 0, size);
            objects = (T[]) new Object[minEnsureCapacity];
            objects = tmp;
        }
    }

    public boolean add(int index, T object) {
        ensureCapacity(size + ((objects.length * 3) / 2 + 1));
        objects[index] = object;
        size++;
        return true;
    }

    public boolean wrongIndex(int index) {
        return index < 0 || index >= objects.length;
    }

    public T get(int index) {
        if (wrongIndex(index)) System.exit(-1);
        return objects[index];
    }

    public boolean remove(int index) {
        if (wrongIndex(index)) return false;
        int numMoved = objects.length - index - 1;
        System.arraycopy(objects, index + 1, objects, index, numMoved);
        objects[--size] = null;
        return true;
    }

    public boolean remove(T object) {
        if (object == null) {
            for (int i = 0; i < objects.length; i++)
                if (objects[i] == null) {
                    remove(i);
                    return true;
                }
        }

        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null) {
                if (objects[i].equals(object)) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean set(int index, T object) {
        if (wrongIndex(index)) return false;
        objects[index] = object;
        return true;
    }

    public boolean clear() {
        for (int i = 0; i < objects.length; i++) {
            objects[i] = null;
        }
        size = 0;
        return true;
    }

    public boolean contains(T object) {
        if (object == null) {
            for (T o : objects)
                if (o == null) {
                    return true;
                }
        }
        for (T o : objects) {
            if (o != null) {
                if (o.equals(object)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printList() {
        System.out.println(Arrays.toString(objects));
    }

    @Override
    public String toString() {
        int count = 0;
        for (T o : objects) {
            if (o != null) {
                count++;
            }
        }
        T[] tmp = (T[]) new Object[count];
        for (int i = 0; i < count; i++) {
            //tmp[i] = objects[i];
            System.arraycopy(objects, i, tmp, i, count);
        }

        return Arrays.toString(tmp);
    }
}
