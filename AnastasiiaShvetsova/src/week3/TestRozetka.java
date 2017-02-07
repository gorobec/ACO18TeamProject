package week3;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by Nastia on 05.02.17.
 */
public class TestRozetka {
    public static void main(String[] args) {
        Rozetka<Product> rozetka = new Rozetka<>();
        //Rozetka<PC> rozetka1 = new Rozetka<>();
        List<String> strings = new LinkedList<>();

        List<Product> products = new LinkedList<>();
        List<Phone> phones = new LinkedList<>();
        List<PC> pcs = new LinkedList<>();

        Rozetka.find(products, new Product());
        Rozetka.find(phones, new Phone());
        //Rozetka.find(String, new Phone());

        Rozetka.copy(phones, products);
    }
}
