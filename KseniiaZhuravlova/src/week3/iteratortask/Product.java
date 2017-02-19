package week3.iteratortask;

/**
 * Created by ksyashka on 09.02.2017.
 */
public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Product: name - %s, price - %d", name, price);
    }
}
