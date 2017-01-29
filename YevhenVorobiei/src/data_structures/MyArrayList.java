package data_structures;

/**
 * Created by gorobec on 29.01.17.
 */
public class MyArrayList {


    public static final int DEFAULT_SIZE = 10;
    private Object[] elementData;
    private int size;

    public MyArrayList(int size) {
        elementData = new Object[size];
    }

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    public boolean add(Object o){
        return false;
    }


    public int size(){
        return size;
    }

    public boolean remove(Object o){
        return false;
    }
    public Object remove(int index){
        return null;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Object get(int index) {
        if(index > size) System.exit(-1);
        return elementData[index];
    }
}
