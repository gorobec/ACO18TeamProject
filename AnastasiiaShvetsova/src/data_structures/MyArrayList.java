package data_structures;

import java.util.*;

/**
 * Created by Nastia on 28.01.17.
 */
public class MyArrayList {
    private int size = 0;
    private Object[] objects;
    public static  final int DEFAULT_SIZE = 10;

    public MyArrayList(int size){
        this.objects = new Object[size];
    }

    public MyArrayList(){
        this(DEFAULT_SIZE);
    }

    public boolean add(Object object) {
        ensureCapacity(size + 1);
        objects[size] = object;
        size++;
        return true;
    }


    public void ensureCapacity(int minEnsureCapacity) {

        int arraylength = objects.length;
        if (minEnsureCapacity > arraylength) {
            Object[] tmp = new Object[minEnsureCapacity];
            System.arraycopy(objects, 0, tmp, 0, size);
            objects = new Object[minEnsureCapacity];
            objects = tmp;
        }
    }

    public void add(int index, Object object) {
        ensureCapacity(size + 1);
        objects[index] = object;
        size++;
    }

    public boolean wrongIndex(int index) {
        return index < 0 || index >= objects.length;
    }

    public Object get(int index) {
        if (wrongIndex(index)) return false;
        return objects[index];
    }

    public boolean remove(int index) {
        if (wrongIndex(index)) return false;
        int numMoved = objects.length - index - 1;
        System.arraycopy(objects, index + 1, objects, index, numMoved);
        objects[--size] = null;
        return true;
    }

    public boolean remove(Object object) {
        if (object == null) {
            for (int i = 0; i < objects.length; i++)
                if (objects[i] == null) {
                    remove(i);
                    return true;
                }
        }

        for (int i = 0; i < objects.length; i++) {
            if(objects[i] != null) {
                if (objects[i].equals(object)) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public Object set(int index, Object object) {
        if (wrongIndex(index)) return false;
        return objects[index] = object;
    }

    public void clear() {
        for (int i = 0; i < objects.length; i++){
            objects[i] = null;
        }
        size = 0;
    }

    public boolean contains(Object object){
        if (object == null) {
            for (int i = 0; i < objects.length; i++)
                if (objects[i] == null) {

                    return true;
                }
        }
        for (int i = 0; i < objects.length; i++){
            if(objects[i] != null) {
                if (objects[i].equals(object)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size != 0 ) return false;
        return true;
    }

    public void printList(){
        System.out.println(Arrays.toString(objects));
    }

}
