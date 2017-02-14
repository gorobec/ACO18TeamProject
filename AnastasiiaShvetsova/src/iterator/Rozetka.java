package iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Nastia on 09.02.17.
 */
public class Rozetka<E extends  Product>  implements Iterator<E>{
    private List<E> products = new ArrayList<>();
    private int currentPosition;
    private int size = 0;

    public boolean addProduct(E product){
        products.add(product);
        size++;
        return true;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < products.size();
    }

    @Override
    public E next() {
        E product =  products.get(currentPosition);
        currentPosition++;
        return product;
    }
    public void showRozetkaProducts(){
        System.out.println("Rozetka's products - " + products);
    }
}
