package ACO.week3.homework.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * Created by v21k on 07.02.17.
 */
public class Rozetka implements Iterator<Product> {
    private List<Product> products;
    private int currentPos = 0;

    public Rozetka(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public boolean hasNext() {
        return currentPos < products.size();
    }

    @Override
    public Product next() {
        return products.get(currentPos++);
    }
}
