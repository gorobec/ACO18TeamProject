package week1.homework.arrayList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * Created by serhiim on 29-Jan-17.
 */
public class MyArrayListTest {
    private MyArrayList list;

    @Before
    public void setUP() {
        list = new MyArrayList();
    }

    @Test
    public void testAddOneElement() {
        boolean actual = list.add("1");
        assertEquals(1, list.size);
        assertTrue(actual);
    }

    @Test
    public void testRemoveWhenElementPresent() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("1"));
        assertTrue(list.remove("1"));
        assertEquals(2, list.size);
        assertFalse(list.remove("2"));
        assertEquals(2, list.size);
    }

    @Test
    public void testRemoveByIndex() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("1"));
        assertTrue(list.remove(1));
        assertEquals(null, list.getObjectArr()[1]);

    }

    @Test
    public void testIsEmpty() {
        assertEquals(0, list.size());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testThrowException() {
        list.throwException();
    }

    @Test
    public void testContainsWhenElementPresent() {
        list.add("1");
        assertTrue(list.contains("1"));
        assertFalse(list.contains("2"));
    }
}
