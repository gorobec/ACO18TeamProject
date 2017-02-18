package iteratorTask;

import java.util.*;

/**
 * Created by SDotsenko on 08.02.2017.
 */
public class Hotline {/*Создать класс Hotline (с полем List<Product> products), и методом addProducts (Iterator iterator),
    который будет добавлять продукты (которые входят в класс либо Rozetka либо Repka) в свой список продуктов.*/
    private List<Product> products;

    public Hotline() {
        this.products = new ArrayList<>(0);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProducts(Iterator<Product> iterator) {
        while (iterator.hasNext()) {
            products.add(iterator.next());
        }
    }
}
