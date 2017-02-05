package week3.day1.generics.product;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by gorobec on 05.02.17.
 */
public class TestRozetka {
    public static void main(String[] args) {
        Rozetka<Product> rozetka = new Rozetka<>();
        List<String> strings = new LinkedList<>();

        List<Product> products = new LinkedList<>();
        List<Phone> phones = new LinkedList<>();
        List<PC> pcs = new LinkedList<>();

        Rozetka.find(products, new Product());
        Rozetka.find(phones, new Phone());
//        Rozetka.find(strings, new String());



    }
}
