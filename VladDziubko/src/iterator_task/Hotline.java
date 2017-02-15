package iterator_task;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Hotline<E> {
    private List<Product> products = new LinkedList<>();

    public Hotline() {
    }

    public Hotline(List<Product> products) {
        this.products = products;
    }

    public boolean addProduct(Iterator<Product> iterator) {
        while (iterator.hasNext()) {
            products.add(iterator.next());
        }
        return true;
    }

    public int size() {
        return products.size();
    }

    public void asString() {
        for (Product prod :
                products) {
            System.out.printf("%s %d\n", prod.getName(), prod.getPrice());
        }
    }
}
