package iteratorTask;

import java.util.*;

/**
 * Created by SDotsenko on 08.02.2017.
 */
public class Rozetka implements Iterator<Product> {//Создать классы Rozetka (с полем List<Product> products)
    private List<Product> products;
    private int currentIndex = 0;

    public Rozetka(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < products.size();
    }

    @Override
    public Product next() {
        return products.get(currentIndex++);
    }
}
