package week3.iteratortask;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ksyashka on 09.02.2017.
 */
public class Hotline<T> {
    private List<Product> products = new LinkedList<>();

    public boolean addProducts(Iterator<Product> iterator) {
        while (iterator.hasNext()) {
            products.add(iterator.next());
        }
        return true;
    }

    public int size(){return products.size();}

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Product product : products) {
            str.append(product);
            str.append("\n");
        }
        return str.toString();
    }


}
