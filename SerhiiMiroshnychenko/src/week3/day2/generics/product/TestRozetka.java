package week3.day2.generics.product;

import week3.day2.generics.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by serhiim on 05-Feb-17.
 */
public class TestRozetka {
    public static void main(String[] args) {
        Rozetka<Product> rozetka = new Rozetka<>();
       // Rozetka<String> rozetka3 = new Rozetka<>();
        List<Product> products = new LinkedList<>();
        List<Phone> phones = new LinkedList<>();
        List<PC> pcs = new LinkedList<>();

        Rozetka.find(products, new Product());
        Rozetka.find(products, new Phone());
        Rozetka.find(products, new PC());
        //Rozetka.find(products, "22"); cant search String in products

        Rozetka.copy(phones, products);
        Rozetka.copy(pcs, products);
        //Rozetka.copy(products, phones);
        //Rozetka.copy(pcs, phones);

    }
}
