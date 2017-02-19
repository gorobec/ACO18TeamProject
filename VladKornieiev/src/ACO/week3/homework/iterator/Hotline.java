package ACO.week3.homework.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by v21k on 07.02.17.
 */
public class Hotline {
    private List<Product> products = new ArrayList<>();

    public Hotline(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void  addProducts(Iterator<Product> iterator){
        while (iterator.hasNext()) {
            products.add(iterator.next());
        }
    }
}
