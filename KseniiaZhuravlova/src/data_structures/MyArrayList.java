package data_structures;

import java.util.*;

/**
 * Created by ksyashka on 26.01.2017.
 */
public class MyArrayList implements MyList {
    private Object[] objects;
    private int size;

    public static final int DEFAULT_SIZE = 10;

    public MyArrayList(Object[] objects) {
        this.objects = objects;
        while (!(objects[size] == null)) {
            size++;
        }

    }

    public MyArrayList(int size) {
        this.objects = new Object[size];
    }

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    private boolean rangeCheck(int index) {
        if (index >= size || index < 0) {
            System.out.printf("Index - %d, size: - %d\n", index, size);
            return false;
        }
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        if (objects.length < minCapacity) {
            minCapacity = 3 * size / 2 + 1;
            Object[] temp = new Object[minCapacity];
            System.arraycopy(objects, 0, temp, 0, size);
            objects = new Object[minCapacity];
            objects = temp;
        }
    }

    private int indexOf(Object object) {
        if (object == null) {
            for (int i = 0; i < size; i++)
                if (objects[i] == null) return i;
        } else {
            for (int i = 0; i < size; i++)
                if (object.equals(objects[i])) return i;
        }
        return -1;
    }

    public void printArrayList() {
        System.out.println(Arrays.toString(objects));
    }

    public boolean add(Object object) {
        ensureCapacity(size + 1);
        objects[size++] = object;
        return true;
    }

    public boolean add(int index, Object object) {
        if (index > size || index < 0) System.exit(-1);
        ensureCapacity(size + 1);
        System.arraycopy(objects, index, objects, index + 1, size++ - index);
        objects[index] = object;
        return true;
    }

    public Object get(int index) {
        if (!rangeCheck(index)) System.exit(-1);
        return objects[index];
    }

    public Object set(int index, Object object) {
        if (!rangeCheck(index)) return false;
        Object result = objects[index];
        objects[index] = object;
        return result;
    }

    public Object remove(int index) {
        if (!rangeCheck(index)) return false;
        Object result = objects[index];
        System.arraycopy(objects, index + 1, objects, index, objects.length - index - 1);
        objects[--size] = null;
        return result;
    }

    public boolean remove(Object object) {
        int index = 0;
        if (object == null) while (index != size && !(objects[index] == null)) index++;
        else while (index != size && !(object.equals(objects[index]))) index++;
        if (index != size) {
            System.arraycopy(objects, index + 1, objects, index, objects.length - index - 1);
            objects[--size] = null;
        }
        return true;
    }

    public void trimToSize() {
        if (size < objects.length)
            objects = Arrays.copyOf(objects, size);
    }

    public void clear() {
        for (int i = 0; i < size; i++)
            objects[i] = null;
        size = 0;
    }

    public boolean contains(Object object) {
        return indexOf(object) >= 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
