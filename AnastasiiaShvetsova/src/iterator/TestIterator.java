package iterator;

import week3.*;

/**
 * Created by Nastia on 09.02.17.
 */
public class TestIterator {
    public static void main(String[] args) {
        Product product1 = new Product("PC", 100);
        Product product2 = new Product("PC", 200);
        Product product3 = new Product("PC", 200);
        Product product4 = new Product("Phone", 200);
        Product product5 = new Product("Phone", 200);
        Product product6 = new Product("Phone2", 200);
        //String string = new String();

        Repka repka = new Repka(5);
        Rozetka rozetka = new Rozetka();
        Hotline hotline = new Hotline();

        repka.addProduct(product1);
        repka.addProduct(product2);
        repka.showRepkaProducts();

        rozetka.addProduct(product3);
        rozetka.addProduct(product4);
        rozetka.addProduct(product5);
        rozetka.showRozetkaProducts();


        hotline.addProducts(rozetka);
        hotline.addProducts(repka);
        hotline.showHotlineProducts();
    }
}
