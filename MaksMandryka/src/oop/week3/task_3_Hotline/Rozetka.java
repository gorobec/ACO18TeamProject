package oop.week3.task_3_Hotline;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Администратор on 13.02.2017.
 */
public class Rozetka implements Iterator<Product> {

    List<Product> products;

    private int currentPosition = 0;

    public Rozetka(List<Product> products) {
        this.products = products;
    }

    public Rozetka() {
        this.products = new ArrayList<Product>();
    }

    public boolean addProduct(Product product) {

        if (product == null) return false;

        for (Product pr : products) {
            if (pr == null) {
                pr = product;
                return true;
            }
        }

        return products.add(product);
    }


    @Override
    public boolean hasNext() {
        return currentPosition < products.size();
    }

    @Override
    public Product next() {
        currentPosition++;
        return products.get(currentPosition - 1);
    }
}
