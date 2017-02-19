package oop.week3.task_1;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by fmandryka on 05.02.2017.
 */
public class TestRozetka {
    public static void main(String[] args) {
        Rozetka<Product> rozetka = new Rozetka<>();
        Rozetka<PC> rozetka2 = new Rozetka<>();
        Rozetka<Phone> rozetka3 = new Rozetka<>();

        List<Product> products = new LinkedList<>();
        List<PC> products2 = new LinkedList<>();
        List<Phone> phones = new LinkedList<>();

        Rozetka.find(products, new Product());
        Rozetka.find(phones, new Phone());

    }
}
