package iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Nastia on 09.02.17.
 */
public class Repka<E extends Product> implements Iterator<Product> {
    private Product[] products;
    private int size;
    private int currentPosition = 0;

    public Repka(int size){
        this.products = new Product[size];
    }

    public boolean addProduct(Product product){
        if(size > products.length) return false;
        Product[] tmpArray = new Product[size+1];
        System.arraycopy(products, 0, tmpArray, 0, 1);
        products = new Product[size+1];
        products = tmpArray;
        products[size] = product;
        size++;
        return true;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < products.length;
    }

    @Override
    public Product next() {
        return products[currentPosition++];
    }

    public void showRepkaProducts(){
        System.out.println("Repka's products - " + Arrays.toString(products));
    }

}
