package iterator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Nastia on 09.02.17.
 */
public class Repka<E extends Product> implements Iterator<E> {
    private E[] products;
    private int size;
    private int currentPosition = 0;

    @SuppressWarnings("unchecked")
    public Repka(Class<E> c, int size){
        this.products = (E[]) Array.newInstance(c, size);
    }

    @SuppressWarnings("unchecked")
    public boolean addProduct(E product){
        if(size > products.length) return false;
        E[] tmpArray =  (E[]) Array.newInstance(Product.class, size+1);
        System.arraycopy(products, 0, tmpArray, 0, 1);
        products = (E[]) Array.newInstance(Product.class, size+1);
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
    public E next() {
        return products[currentPosition++];
    }

    public void showRepkaProducts(){
        System.out.println("Repka's products - " + Arrays.toString(products));
    }

}
