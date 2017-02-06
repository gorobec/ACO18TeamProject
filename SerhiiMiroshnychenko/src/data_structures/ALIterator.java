package data_structures;

import java.util.Iterator;
import java.util.PrimitiveIterator;

/**
 * Created by serhiim on 05-Feb-17.
 */
public class ALIterator<T> implements Iterator<T> {

    private MyArrayList<T> list;
    private T currentElement;
    private int currentPosition;

    public ALIterator(MyArrayList<T> list){
        this.list = list;
        currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < list.size();
    }

    @Override
    public T next() {
        return list.getObjectArr()[currentPosition++];
    }
}
