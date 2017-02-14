package ACO.week3.homework.iterator;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by v21k on 07.02.17.
 */
public class IteratorsTest {

    private static Repka repka;
    private static Rozetka rozetka;
    private static Hotline hotline;

    @BeforeClass
    public static void create(){
        // AL for rozetka
        List<Product> rozetkaProducts = new ArrayList<>();
        rozetkaProducts.add(new Product("Laptop", 400));
        rozetkaProducts.add(new Product("PC", 500));

        // array for repka
        Product[] repkaProducts = {new Product("TV", 200),
                                    new Product("Phone", 200)};

        repka = new Repka(repkaProducts);
        rozetka = new Rozetka(rozetkaProducts);
        hotline = new Hotline(new ArrayList<>());
    }

    @After
    public void tearDown(){
        hotline = new Hotline(new ArrayList<>());
    }

    @Test
    public void testIteratorRepka(){
        hotline.addProducts(repka);
        assertEquals(repka.getProducts().length, hotline.getProducts().size());
    }

    @Test
    public void testIteratorRozetka(){
        hotline.addProducts(rozetka);
        assertEquals(rozetka.getProducts().size(), hotline.getProducts().size());
    }

    @Test
    public void testIteratorAddBoth(){
        hotline.addProducts(rozetka);
        hotline.addProducts(repka);
        int expected = rozetka.getProducts().size() + repka.getProducts().length;
        int actual = hotline.getProducts().size();
        assertEquals(expected, actual);
    }


}
