package iteratorTask;

import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

/**
 * Created by SDotsenko on 08.02.2017.
 */
public class IteratorsTests {
    private static Repka repka;
    private static Rozetka rozetka;
    private static Hotline hotline;

    @BeforeClass
    public static void create() {
        List<Product> rozetkaProducts = new ArrayList<>();
        rozetkaProducts.add(new Product("rozetka1", 1));
        rozetkaProducts.add(new Product("rozetka2", 2));
        rozetkaProducts.add(new Product("rozetka3", 3));
        Product[] repkaProducts = {new Product("repka1", 4), new Product("repka2", 5)};
        repka = new Repka(repkaProducts);
        rozetka = new Rozetka(rozetkaProducts);
        hotline = new Hotline();
    }

    @After
    public void tearDown() {
        hotline = new Hotline();
    }

    @Test
    public void testIteratorRepka() {
        hotline.addProducts(repka);
        assertEquals(repka.getProducts().length, hotline.getProducts().size());
    }

    @Test
    public void testIteratorRozetka() {
        hotline.addProducts(rozetka);
        assertEquals(rozetka.getProducts().size(), hotline.getProducts().size());
    }
}
