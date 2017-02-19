package week3.day2.product;

import java.util.Iterator;

public class RunHotline {
    public static void main(String[] args) {

        Product p1 = new Product("Iphone6", 800);
        Product p2 = new Product("Iphone5", 450);
        Product p3 = new Product("Galaxy7", 800);
        Product p4 = new Product("Xiaomi3", 150);
        Product p5 = new Product("Nokia", 1200);

        Rozetka rozetka = new Rozetka();
        rozetka.addProduct(p1);
        rozetka.addProduct(p4);

        Repka repka = new Repka () ;
        repka.addProduct(p2);
        repka.addProduct(p3);
        repka.addProduct(p5);

        Iterator rozetkaIterator = rozetka.iterator();

        Iterator repkaIterator = repka.iterator();

        Hotline hotline = new Hotline();
        hotline.addProducts(rozetkaIterator);
        System.out.println("Products in Rozetka:");
        System.out.println(hotline.showAllProducts());
        hotline.addProducts(repkaIterator);
        System.out.println("Products in Rozetka and Repka:");
        System.out.println(hotline.showAllProducts());

    }
}
