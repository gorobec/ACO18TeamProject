package week3.iteratortask;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by ksyashka on 09.02.2017.
 */
public class Rozetka<T> implements Iterator<Product> {
    private List<Product> products = new LinkedList<>();
    private int index = 0;

    public boolean addProduct(String name, int price) {
        products.add(new Product(name, price));
        return true;
    }

    public int size() {return products.size();}

    @Override
    public boolean hasNext() {
        return index < products.size();
    }

    @Override
    public Product next() {
        return products.get(index++);
    }

}

