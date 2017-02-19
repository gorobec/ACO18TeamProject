package week3.iteratortask;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by ksyashka on 09.02.2017.
 */
public class TestHotline {
    private Hotline<Product> hotline = new Hotline<>();


    @Test
    public void testAddProducts() {
        Rozetka<Product> rozetka = new Rozetka<>();
        rozetka.addProduct("camera", 980);
        rozetka.addProduct("phone", 756);
        rozetka.addProduct("lamp", 98);

        Repka repka = new Repka();
        repka.addProduct("iron", 256);
        repka.addProduct("curling", 198);

        assertTrue(hotline.addProducts(rozetka));
        assertTrue(hotline.addProducts(repka));
        assertTrue(hotline.size() == (rozetka.size() + repka.size()));
    }

    @Test
    public void testToStringHotline() {
        Rozetka<Product> rozetka = new Rozetka<>();
        rozetka.addProduct("camera", 980);
        rozetka.addProduct("phone", 756);

        assertTrue(hotline.addProducts(rozetka));
        String expected = "Product: name - camera, price - 980\nProduct: name - phone, price - 756\n";
        assertEquals(expected,hotline.toString());


    }


}
