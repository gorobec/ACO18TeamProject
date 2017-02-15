package iterator_task;

import java.util.LinkedList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        List<Product> list = new LinkedList<>();
        list.add(new Product("Bomb", 10));
        list.add(new Product("pen", 4));
        list.add(new Product("pen", 4));
        list.add(new Product("pen", 4));
        list.add(new Product("pen", 4));
        Rozetka<Product> rozetka = new Rozetka<>(list);

        Product prod1 = new Product("paper", 5);
        Product prod2 = new Product("salt", 2);
        Product prod3 = new Product("salt", 2);
        Product prod4 = new Product("salt", 2);
        Product prod5 = new Product("salt", 2);

        Product[] products = {prod1, prod2, prod3, prod4, prod5};
        Repka repka = new Repka(products);

        Hotline<Product> hot = new Hotline<>();
        hot.addProduct(rozetka);
        hot.addProduct(repka);

        System.out.println(hot.size());
        hot.asString();

    }
}
