package iteratorTask;

import java.util.Iterator;

/**
 * Created by SDotsenko on 08.02.2017.
 */
public class Repka implements Iterator<Product> {//Repka (с полем Product[] products)
    private Product[] products;
    private int currentIndex = 0;

    public Repka(Product[] products) {
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < products.length;
    }

    @Override
    public Product next() {
        return products[currentIndex++];
    }
}