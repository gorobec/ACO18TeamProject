package week3.task;

import java.util.LinkedList;
import java.util.List;

public class TestRozetka {
    public static void main(String[] args) {
        Rozetka<Product> rozetka1 = new Rozetka<>();

        List<Product> products = new LinkedList<>();
        List<Phone> phones = new LinkedList<>();
        List<Pc> pcs = new LinkedList<>();

        Rozetka.find(products, new Product());
        Rozetka.find(phones, new Phone());
        Rozetka.copy(phones, products);
    }
}
