package oop.week3.task_3_Hotline;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Администратор on 13.02.2017.
 */
public class Repka implements Iterator<Product>{

    Product[] products;

    private int currentPosition = 0;

    public Repka(Product[] products) {
        this.products = products;
    }

    public Repka(int size) {
        this.products = new Product[size];
    }

    public boolean addProduct(Product product) {

        if (product == null) return false;

        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return true;
            }
        }

        Product[] products1 = new Product[products.length+1];
        System.arraycopy(products, 0, products1,0,products.length);
        products1[products.length] = product;
        products = products1;
        return true;
    }


    @Override
    public boolean hasNext() {
        return currentPosition < products.length;
    }

    @Override
    public Product next() {
        currentPosition++;
        return products[currentPosition-1];
    }
}
