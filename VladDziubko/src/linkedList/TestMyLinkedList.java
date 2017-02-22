package linkedList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMyLinkedList {
    MyLinkedList<Object> list;

    @Before
    public void setUp() {
        list = new MyLinkedList<>();
    }

    @After
    public void tearDown() {
        list = null;
    }

    @Test
    public void testAddObject() {
        list.add(12);
        list.add(2);
        list.add(1);
        Assert.assertTrue(list.size() == 3);
    }

    @Test
    public void testSize() {
        list.add(12);
        list.add(12);
        Assert.assertEquals(true, list.size() == 2);
    }

    @Test
    public void testClear() {
        list.add(12);
        list.add(12);
        list.add(12);
        list.add(12);
        list.add(12);
        list.clear();
        Assert.assertTrue(list.size() == 0);
    }

    @Test
    public void testIsEmpty() {
        list.add(111);
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void testGet() {
        list.add("1");
        Assert.assertEquals("1", list.get(0));
    }

    @Test
    public void testSet() {
        list.add(123);
        list.set(0, 20);
        Assert.assertEquals(20, list.get(0));
    }

    @Test
    public void testAddByIndex() {
        list.add(0, "1");
        list.add(1, "2");
        //list.add(0, "3");
        Assert.assertEquals("1", list.get(0));
    }

    @Test
    public void testRemoveByValue() {
        list.add("1");
        list.add("3");
        list.add("2");
        list.remove("1");
        Assert.assertTrue(list.size() == 2);
        Assert.assertEquals("3", list.get(0));
    }

    @Test
    public void testRemoveByIndex(){
        list.add("21");
        list.add("22");
        list.add("12");
        list.remove(1);
        Assert.assertTrue(list.size() == 2);
    }

    @Test
    public void testContains(){
        list.add("pop");
        list.add("lpop");
        list.add("lopop");
        list.add("lolpop");
        Assert.assertTrue(list.contains("lolpop"));
        Assert.assertFalse(list.contains("sdfdsfdasf"));
    }
}
