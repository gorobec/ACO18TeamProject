package oop.week3.task_3_Hotline;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Администратор on 13.02.2017.
 */
public class TestHotline {

    Hotline hotline;
    Rozetka rozetka;
    Repka repka;

    Product pr1 = new Product("Phone1", 134.99);
    Product pr2 = new Product("Book", 34.70);
    Product pr3= new Product("Lamp1", 30.65);
    Product pr4= new Product("Lamp2", 26.93);
    Product pr5 = new Product("Phone2", 47.83);
    Product pr6 = new Product("Phone3", 93.29);
    Product pr7 = new Product("NoteBook1", 200.00);
    Product pr8 = new Product("NoteBook2", 967.34);
    Product pr9 = new Product("NoteBook3", 505.99);
    Product pr10 = new Product("SSD", 99.99);
    Product pr11 = new Product("HDD", 34.23);
    Product pr12 = new Product("Iron", 17.44);


    @Before
    public void setUp() {
        hotline = new Hotline();
        rozetka = new Rozetka();
        repka = new Repka(1);
    }


    @Test
    public void testAddProductsToHotline(){
        assertTrue(repka.addProduct(pr1));
        assertTrue(repka.addProduct(pr2));
        assertTrue(repka.addProduct(pr3));
        assertTrue(repka.addProduct(pr4));
        assertTrue(repka.addProduct(pr5));
        assertTrue(repka.addProduct(pr6));
        assertTrue(rozetka.addProduct(pr7));
        assertTrue(rozetka.addProduct(pr8));
        assertTrue(rozetka.addProduct(pr9));
        assertTrue(rozetka.addProduct(pr10));
        assertTrue(rozetka.addProduct(pr11));
        assertTrue(rozetka.addProduct(pr12));

        assertTrue(hotline.addProducts(repka));
        assertTrue(hotline.addProducts(rozetka));

        assertTrue(hotline.getProducts().contains(pr1));
        assertTrue(hotline.getProducts().contains(pr5));
        assertTrue(hotline.getProducts().contains(pr8));
        assertTrue(hotline.getProducts().contains(pr12));

        assertEquals(12, hotline.getProducts().size());

    }


}
