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
        assertEquals(1, list.size());
        assertTrue(actual);
    }

    @Test
    public void testAddElementToIndex() {
        assertTrue(list.add(3, "3"));
        for (int i = 0; i < 3; i++) {
            assertTrue(list.getObjectArr()[i] == null);
        }
        assertEquals(list.getObject(3), "3");
        for (int i = 4; i < list.getObjectArr().length; i++) {
            assertTrue(list.getObjectArr()[i] == null);
        }
    }

    @Test
    public void testRemoveWhenElementPresent() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("1"));
        assertTrue(list.remove("1"));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveByIndex() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("1"));
        assertEquals(list.remove(1), "1");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveByInvalidIndex() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("1"));
        list.remove(5);
    }

    @Test
    public void testIsEmpty() {
        assertEquals(0, list.size());
    }

    @Test
    public void testContainsWhenElementPresent() {
        list.add("1");
        assertTrue(list.contains("1"));

    }

    @Test
    public void testContainsWhenElementNotPresent() {
        list.add("1");

        assertFalse(list.contains("2"));
    }

    @Test
    public void testSetWhenIndexIsValid() {
        list.set(0, "1");
        assertEquals(list.getObject(0), "1");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSetWhenIndexIsNotValid() {
        list.set(15, "1");
    }

    @Test
    public void testClearArrayList() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("1"));
        assertTrue(list.clear());
        for (Object anObject : list.getObjectArr()) {
            assertEquals(null, anObject);
        }

    }

}
