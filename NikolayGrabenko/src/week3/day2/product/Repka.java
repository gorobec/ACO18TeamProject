package week3.day2.product;

import java.util.Iterator;

/*
Создать классы Rozetka (с полем List<Product> products),
Repka (с полем Product[] products). Унаследовать классы от интерфейса Iterator.
*/

public class Repka implements Iterable, AddProduct {

    private Product[] products = new Product[20];

    @Override
    public boolean addProduct(Product product) {
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
    public Iterator iterator() {
        return new RepkaIterator();
    }

// inner class iterator
    public class RepkaIterator implements Iterator{

        private int currentPos = 0;

        @Override
        public boolean hasNext() {
            return currentPos < products.length;
        }

        @Override
        public Product next() {
            return products[currentPos++];
        }
    }
}
