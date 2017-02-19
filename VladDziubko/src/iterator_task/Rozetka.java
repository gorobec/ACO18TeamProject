package iterator_task;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Rozetka<E> implements Iterator<Product> {
    private List<Product> products = new LinkedList<>();
    private int currIndex = 0;
    private int index = 0;

    Rozetka() {
    }

    public Rozetka(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public boolean hasNext() {
        if (currIndex < products.size()) {
            currIndex++;
            return true;
        }
        return false;
    }

    @Override
    public Product next() {
        if(index >= products.size()){
            throw new IndexOutOfBoundsException("Out of the array length!");
        }
        return products.get(index++);
    }


}
