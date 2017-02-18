package iterator_task;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class TestIteratorTask {
    Hotline<Product> hotline = new Hotline<>();

    public List<Product> list = new LinkedList<>();
    Rozetka<Product> rozetka = new Rozetka<>(list);

    Product prod1 = new Product("Meat", 100);
    Product prod2 = new Product("Fish", 90);
    Product[] products = {prod1, prod2};
    Repka repka = new Repka(products);

    @Test
    public void testRozetkaHasNext() {
        list.add(new Product("sugar", 12));
        list.add(new Product("salt", 4));
        list.add(new Product("usb-hub", 8));
        list.add(new Product("mouse", 120));
        Assert.assertTrue(rozetka.hasNext());
        Assert.assertTrue(rozetka.hasNext());
        Assert.assertTrue(rozetka.hasNext());
        Assert.assertTrue(rozetka.hasNext());
        Assert.assertFalse(rozetka.hasNext());
    }

    @Test(expected = Exception.class)
    public void testRozetkaNext() {
        list.add(new Product("bomb", 100));
        list.add(new Product("bomb", 100));
        list.add(new Product("bomb", 100));
        Assert.assertEquals(list.get(0), rozetka.next());
        Assert.assertEquals(list.get(1), rozetka.next());
        Assert.assertEquals(list.get(2), rozetka.next());
        Assert.assertEquals(list.get(3), rozetka.next());
    }

    @Test
    public void testRepkaHasNext() {
        Assert.assertTrue(repka.hasNext());
        Assert.assertTrue(repka.hasNext());
        Assert.assertFalse(repka.hasNext());
    }

    @Test
    public void testRepkaNext(){
        Assert.assertEquals(true, repka.next() != null);
        Assert.assertTrue(repka.next() != null);
    }

    @Test
    public void testAddRozetkaHotline(){
        list.add(new Product("coconut", 25));
        list.add(new Product("Banana", 15));
        hotline.addProduct(rozetka);
        Assert.assertEquals(2, hotline.size());
    }

    @Test
    public void testAddRepkaHotline(){
        hotline.addProduct(repka);
        Assert.assertEquals(2, hotline.size());
    }

    @Test
    public void testSizeHotline(){
        hotline.addProduct(repka);
        list.add(new Product("pencil", 2));
        hotline.addProduct(rozetka);
        Assert.assertEquals(3, hotline.size());
    }
}
