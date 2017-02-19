package week3.day2.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
Создать классы Rozetka (с полем List<Product> products),
Repka (с полем Product[] products). Унаследовать классы от интерфейса Iterator.
*/

public class Rozetka implements Iterable, AddProduct  {

    private List<Product> products = new ArrayList<>();

    @Override
    public boolean addProduct(Product product) {
        products.add(product);
        return true;
    }

    @Override
    public Iterator iterator() {
        return new RozetkaIterator();
    }

    public class RozetkaIterator implements Iterator{

        private  int currentPos = 0;

        @Override
        public boolean hasNext() {
            return currentPos < products.size();
        }

        @Override
        public Product next() {
            return products.get(currentPos++);
        }
    }
}
