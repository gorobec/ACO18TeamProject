package iterator_task;

import java.util.Iterator;

public class Repka implements Iterator<Product> {
    private Product[] products;
    private int currentIndex = 0;
    private int size = 0;

    public Repka() {
    }

    public Repka(Product[] products) {
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean hasNext() {
        if (currentIndex < products.length) {
            currentIndex++;
            return true;
        }
        return false;
    }

    @Override
    public Product next() {
        if (size >= products.length) {
            throw new IndexOutOfBoundsException("Out of the array length!");
        }
        return products[size++];
    }
}

