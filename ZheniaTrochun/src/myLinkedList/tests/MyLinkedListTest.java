package tests;

import linkedList.MyLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhenia on 02.02.17.
 */
public class MyLinkedListTest {

    private MyLinkedList<String> list;

    @Before
    public void setUp(){
        String[] arr = {"0", "1", "2", "3", "4", "5"};
        list = new MyLinkedList(arr);

    }

    @Test
    public void testAdd(){
        Assert.assertTrue(list.add("1"));
        Assert.assertEquals(7, list.size());

        list.add(0, "0");
        Assert.assertEquals(8, list.size());

    }

    @Test
    public void testGet(){
        Assert.assertEquals("0", list.get(0));
        Assert.assertEquals("1", list.get(1));
        Assert.assertEquals("2", list.get(2));
        Assert.assertEquals("3", list.get(3));
    }

    @Test
    public void testRemove(){
        Assert.assertEquals("0", list.remove(0));
        Assert.assertEquals(5, list.size());
        Assert.assertEquals("1", list.remove(0));
        Assert.assertNull(list.remove(5));
    }

    @Test
    public void testForEach(){
        for (String str : list) {
            System.out.println(str);
        }
    }

    @Test
    public void testSet(){
        Assert.assertEquals(list.set(0, "not zero"), "not zero");
        Assert.assertEquals("not zero", list.get(0));
        Assert.assertNull(list.set(-1, "error"));
    }

    @Test
    public void testClear(){
        Assert.assertEquals(6, list.size());
        list.clear();
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testContains(){
        Assert.assertTrue(list.contains("0"));
        Assert.assertFalse(list.contains("error"));
    }
}
