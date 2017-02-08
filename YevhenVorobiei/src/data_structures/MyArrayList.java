package data_structures;

import java.util.Iterator;

/**
 * Created by gorobec on 29.01.17.
 */
public class MyArrayList<T> implements MyList<T>{


    private static final int DEFAULT_SIZE = 10;
    private T[] elementData;
    private int size;


    @SuppressWarnings(value = "unchecked")
    public MyArrayList(int size) {
        elementData = (T[])new Object[size];
    }

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    public boolean add(T o){
        elementData[size] = o;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, Object object) {
        return false;
    }


    public int size(){
        return size;
    }

    public boolean remove(Object o){
        return false;
    }

    @Override
    public void trimToSize() {

    }

    @Override
    public T set(int index, T object) {
        return null;
    }

    public T remove(int index){
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[size--] = null;
        return null;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public boolean contains(Object object) {
        return false;
    }

    @Override
    public void clear() {

    }

    public T get(int index) {
        if(index > size) System.exit(-1);
        return elementData[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ALIterator();
    }

    private class ALIterator implements Iterator<T>{

        private int currentPosition;

        private ALIterator() {
            currentPosition = 0;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < size;
        }

        @Override
        public T next() {

            return elementData[currentPosition++];
        }
    }
}
