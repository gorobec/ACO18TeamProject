package dataStructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {
    private MyArrayList list;

    @Before
    public void setUp() {
        list = new MyArrayList();
    }

    @Test
    public void testAddOneElement() {
        boolean actual = list.add("1");
        boolean expected = true;
        Assert.assertEquals(expected, actual);
        Assert.assertTrue(actual);
    }
    @Test
    public void testAddThreeElement() {
        Assert.assertEquals(0, list.size());
        Assert.assertTrue("1", list.add("1"));
    }

    @Test
    public void testGetElement() {
        boolean actual = list.add("1");
        boolean expected = true;
        Assert.assertEquals(expected, actual);
        Assert.assertTrue(expected);
    }
}
