package week1.homework.arrayList;

import java.util.Arrays;

/**
 * Created by serhiim on 29-Jan-17.
 */
public class qwe {

    private int size;
    private Object[] objects;

    public qwe(int size){
        this.size = size;
        this.objects = new Object[size];
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

    public boolean isIndex(int index) {
        if ((index < 0 || index >= objects.length)) return false;
        return true;
    }

    public Object get(int index) {
        if (!isIndex(index)) return false;
        return objects[index];
    }

    public Object remove(int index) {
        if (!isIndex(index)) return false;
        int numMoved = objects.length - index - 1;
        System.arraycopy(objects, index + 1, objects, index, numMoved);
        objects[--size] = null;
        return objects[index];
    }

    public Object remove(Object object) {
        int index = 0;
        if (object == null) {
            for (int i = 0; i < objects.length; i++)
                if (objects[i] == null) {
                    remove(i);
                    return objects[i];
                }
        }

        for (int i = 0; i < objects.length; i++) {
            if(objects[i] != null) {
                if (objects[i].equals(object)) {
                    index = i;
                    remove(i);
                }
            }
        }

        return objects[index];
    }

    public Object set(int index, Object object) {
        if (!isIndex(index)) return false;
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
        int count = 0;
        for (int i = 0; i < objects.length; i++) {
            if(objects[i] != null){
                count++;
            }
        }
        return count;
    }

    public void printList(){
        System.out.println(Arrays.toString(objects));
    }

}
