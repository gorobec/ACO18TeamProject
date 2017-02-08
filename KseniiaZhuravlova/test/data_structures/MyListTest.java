package data_structures;

import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.Iterator;
/**
 * Created by ksyashka on 29.01.2017.
 */
public abstract class MyListTest {

    protected MyList<String> list;

    @Before
    public abstract void setUp();

    @Test
    public void testAddOneElement() {
        boolean actual = list.add("1");
        assertTrue(actual);
        assertEquals(1, list.size());
    }

    @Test
    public void testAddThreeElement() {
        assertTrue(list.add("0"));
        assertEquals(1, list.size());
        assertTrue(list.add("1"));
        assertEquals(2, list.size());
        assertTrue(list.add("2"));
        assertEquals(3, list.size());
    }

    @Test
    public void testAddManyElement() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        assertTrue(list.add("3"));
        assertTrue(list.add("4"));
        assertTrue(list.add("5"));
        assertTrue(list.add("6"));
        assertTrue(list.add("7"));
        assertTrue(list.add("8"));
        assertTrue(list.add("9"));
        assertTrue(list.add("10"));
        assertEquals(11, list.size());
    }

    @Test
    public void testAddElementByIndex() {
        assertTrue(list.add(0, "2"));
        assertEquals(1, list.size());
    }


    @Test
    public void testGetObject() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        Object expected = "1";
        Object actual = list.get(1);
        assertEquals(expected, actual);
    }


    @Test
    public void testGetNullObject() {
        assertTrue(list.add("0"));
        assertTrue(list.add(null));
        assertTrue(list.add("2"));
        Object actual = list.get(1);
        assertEquals(null, actual);
    }

    @Test
    public void testSetObject() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        Object expected = "1";
        Object actual = list.set(1, "3");
        assertEquals(expected, actual);
        expected = "3";
        actual = list.get(1);
        assertEquals(expected, actual);
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
    public void testRemoveWhenElementNoPresent() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("1"));
        assertTrue(list.remove("2"));
        assertEquals(3, list.size());
    }

    @Test
    public void testRemoveNullElement() {
        assertTrue(list.add("0"));
        assertTrue(list.add(null));
        assertTrue(list.add("1"));
        assertTrue(list.remove(null));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveByIndex() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        Object expected = "1";
        Object actual = list.remove(1);
        assertEquals(expected, actual);

    }

    @Test
    public void testContainsWhenElementPresent() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        assertTrue(list.contains("2"));

    }

    @Test
    public void testContainsWhenElementNoPresent() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        assertTrue(!list.contains("3"));
    }

    @Test
    public void testContainsNullElement() {
        assertTrue(list.add("0"));
        assertTrue(list.add(null));
        assertTrue(list.add("2"));
        assertTrue(list.contains(null));
    }

    @Test
    public void testContainsNullElementWhenNoNull() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        assertTrue(!list.contains(null));
    }

    @Test
    public void testSize() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        assertTrue(list.size() == 6);
    }

    @Test
    public void testIsEmptyTrue() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        assertTrue(!list.isEmpty());
    }

    @Test
    public void testTrimToSize() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        list.trimToSize();
        assertTrue(3 == list.size());
    }

    @Test
    public void testClear() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        list.clear();
        list.trimToSize();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIterator(){
        assertTrue(list.add("A"));
        assertTrue(list.add("B"));
        assertTrue(list.add("C"));
        assertTrue(list.add("D"));
        assertTrue(list.add("E"));
        Iterator<String> iterator = list.iterator();
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        assertEquals("D", iterator.next());
        assertEquals("E", iterator.next());

    }
}
