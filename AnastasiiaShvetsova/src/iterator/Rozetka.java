package iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Nastia on 09.02.17.
 */
public class Rozetka<E extends Product> implements Iterator<Product> {
    private List<Product> products = new ArrayList<>();
    private int currentPosition;
    private int size = 0;

    public boolean addProduct(Product product){
        products.add(product);
        size++;
        return true;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < products.size();
    }

    @Override
    public Product next() {
        Product product =  products.get(currentPosition);
        currentPosition++;
        return product;
    }
    public void showRozetkaProducts(){
        System.out.println("Rozetka's products - " + products);
    }
}
