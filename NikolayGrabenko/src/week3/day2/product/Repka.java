package week3.day2.product;

import java.util.Iterator;

/*
Создать классы Rozetka (с полем List<Product> products),
Repka (с полем Product[] products). Унаследовать классы от интерфейса Iterator.
*/

public class Repka<T extends Product> implements Iterator<T>, AddProduct<T> {

    private T[] products = (T[]) new Product[20];
    private int currentPos = 0;

    @Override
    public boolean addProduct(T product) {
        boolean wasAdded = false;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                wasAdded = true;
                break;
            }
        }
        return wasAdded;
    }

    @Override
    public boolean hasNext() {
        return currentPos < products.length;
    }

    @Override
    public T next() {
        return products[currentPos++];
    }

}
