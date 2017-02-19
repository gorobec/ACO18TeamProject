package oop.week3.task_3_Hotline;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Администратор on 13.02.2017.
 */
public class Hotline {

    private List<Product> products = new ArrayList<>();

    public boolean addProducts(Iterator<Product> iterator) {

        while (iterator.hasNext()) {
            products.add(iterator.next());
        }
        return true;
    }

    public List<Product> getProducts() {
        return products;
    }
}
