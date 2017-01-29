package dataStructures;

import java.util.Objects;

public class MyArrayList {
    private Objects[] elementsData;
    private static final int DEFAULT_SIZE = 10;

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    public MyArrayList(int size) {
        elementsData = new Objects[size];
    }

    public boolean add(Object o){
        return true;
    }

    public int size(){
        return 0;
    }

    public Object get(int index){
        return elementsData[index];
    }
}
