package week1.dynamicArray;

import org.junit.Assert;
import org.junit.Test;

public class TestNewArrayList {
    NewArrayList list = new NewArrayList(10);

    @Test
    public void testSize(){
        list.add("la");
        list.add("do");
        list.add("re");
        list.add("mi");
        list.add("fa");
        list.add("sol");
        Assert.assertTrue(list.size() == 6);
        Assert.assertEquals(true, list.size() != 0);
    }

    @Test
    public void testGet(){
        list.add("sol");
        Assert.assertTrue(list.get(0) != null);
        Assert.assertEquals("sol", list.get(0));
    }

    @Test
    public void testClear(){
        list.add("la");
        list.add("do");
        list.add("re");
        list.add("mi");
        list.add("fa");
        list.add("sol");
        list.clear();
        Assert.assertTrue(list.size() == 0);
    }

    @Test
    public void testSet(){
        list.add(1);
        list.set(0, 2);
        Assert.assertEquals(true, (Integer) list.get(0) == 2);
    }

    @Test
    public void testAdd(){
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        Assert.assertEquals(true, list.size() == 11);
        Assert.assertTrue(list.add(2));
    }

    @Test
    public void testAddWithIndex(){
        list.add(0, 1);
        list.add(1, 1);
        list.add(2, 1);
        list.add(3, 1);
        list.add(4, 1);
        list.add(5, 1);
        list.add(6, 1);
        list.add(7, 1);
        list.add(8, 1);
        list.add(9, 1);
        list.add(10, 1);
        Assert.assertTrue(list.add(2, 7));
        Assert.assertEquals(7, list.get(2));
    }

    @Test
    public void testContains(){
        list.add("java");
        Assert.assertTrue(list.contains("java"));
    }

    @Test
    public void testIndexRemove(){
        list.add(1);
        list.add(1);
        list.add(1);
        list.remove(1);
        Assert.assertTrue(list.size() == 2);
    }

    @Test
    public void testObjectRemove(){
        list.add(1);
        list.add(1);
        list.add(1);
        list.remove(list.get(2));
        Assert.assertTrue(list.size() == 2);
    }
}
