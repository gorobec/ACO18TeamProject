package week3.day2.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
Создать классы Rozetka (с полем List<Product> products),
Repka (с полем Product[] products). Унаследовать классы от интерфейса Iterator.
*/

public class Rozetka<T extends Product> implements Iterator<T>, AddProduct<T> {

    private List<T> products = new ArrayList<>();
    private int currentPos = 0;

    @Override
    public boolean addProduct(T product) {
        products.add(product);
        return true;
    }

    @Override
    public boolean hasNext() {
        return currentPos < products.size();
    }

    @Override
    public T next() {
        return products.get(currentPos++);
    }
}

