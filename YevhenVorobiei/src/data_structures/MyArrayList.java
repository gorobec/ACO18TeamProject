package data_structures;

/**
 * Created by gorobec on 29.01.17.
 */
public class MyArrayList<T> implements MyList<T>{


    public static final int DEFAULT_SIZE = 10;
    private T[] elementData;
    private int size;

    public MyArrayList(int size) {
        elementData = (T[])new Object[size];
    }

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    public boolean add(T o){
        return false;
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
    public Object set(int index, Object object) {
        return null;
    }

    public T remove(int index){
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


}
