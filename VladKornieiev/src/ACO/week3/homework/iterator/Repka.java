package ACO.week3.homework.iterator;

import java.util.Iterator;

/**
 * Created by v21k on 07.02.17.
 */
public class Repka implements Iterator<Product> {
    private Product[] products;
    private int currentPos = 0;

    public Repka(Product[] products) {
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    @Override
    public boolean hasNext() {
        return currentPos < products.length;
    }

    @Override
    public Product next() {
        return products[currentPos++];
    }
}
