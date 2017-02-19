package week3.iteratortask;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by ksyashka on 09.02.2017.
 */
public class Rozetka<T extends Product> implements Iterator<T> {
    private List<T> products = new LinkedList<>();
    private int index = 0;

    @SuppressWarnings({"unchecked", "unused"})
    public boolean addProduct(String name, int price) {
        T temp = (T) new Product(name,price);
        products.add(temp);
        return true;
    }

    public int size() {return products.size();}

    @Override
    public boolean hasNext() {
        return index < products.size();
    }

    @Override
    public T next() {
        return products.get(index++);
    }

}

