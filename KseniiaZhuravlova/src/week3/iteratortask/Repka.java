package week3.iteratortask;

import java.util.Iterator;

/**
 * Created by ksyashka on 09.02.2017.
 */
public class Repka implements Iterator<Product> {
    private Product[] products = new Product[10];
    private int size = 0;
    private int index = 0;

    public int size() {
        return size;
    }

    public boolean addProduct(String name, int price){
        products[size++] = new Product(name,price);
        return true;
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public Product next() {
        return products[index++];
    }
}
