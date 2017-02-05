package ACO.data_structures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by v21k on 29.01.17.
 */

public class MyArrayListTest {
    private MyArrayList list;

    @Before
    public void setUp() {
        list = new MyArrayList();
    }

    @After
    public void tearDown() {
        list = null;
    }

    // ADD TESTS

    @Test
    public void testAddOneElement() {
        boolean actual = list.add("1");
        assertTrue(actual);
        assertEquals(1, list.size());
    }

    @Test
    public void testAddThreeElements() {
        assertEquals(0, list.size());
        assertTrue(list.add("1"));
        assertEquals(1, list.size());
        assertTrue(list.add("2"));
        assertEquals(2, list.size());
        assertTrue(list.add("3"));
        assertEquals(3, list.size());
    }

    @Test
    public void testAddByIndex() {
        list.add(0, 2);
        assertEquals(2, list.get(0));
        list.add(1, 3);
        assertEquals(3, list.get(1));
    }

    // REMOVE TEST

    @Test
    public void testRemoveWhenElementPresent() {
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        assertTrue(list.add("3"));
        assertTrue(list.remove("1"));
        assertEquals("2", list.remove(0));
        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveWhenNoElementPresent() {
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        assertTrue(list.add("3"));
        assertTrue(list.remove("2"));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveWhenEmptyList() {
        assertEquals(0, list.size());
        assertFalse(list.remove("2"));
        assertEquals(0, list.size());
    }

    @Test
    public void testRemoveNullWhenNoElement() {
        assertEquals(0, list.size());
        assertFalse(list.remove(null));
        assertEquals(0, list.size());
    }

    @Test
    public void testRemoveNullWhenElementPresent() {
        assertTrue(list.add("1"));
        assertTrue(list.add(null));
        assertTrue(list.add(null));
        assertTrue(list.remove(null));
        assertEquals(2, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testremoveWrongIndex() {
        list.remove(-1);
        list.remove(5);
        list.remove(list.size());
    }

    // GET TESTS

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWrongIndex() {
        list.get(2);
    }

    @Test
    public void testGetNullWhenElementPresent() {
        list.add(null);
        assertEquals(null, list.get(0));
    }

    // SET TESTS

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWrongIndex() {
        list.add("1");
        list.add("2");
        list.set(2, "3");
    }

    @Test
    public void testSet() {
        list.add("1");
        list.set(0, "2");
        assertEquals("2", list.get(0));
    }

    // contains test

    @Test
    public void testContainsWhenElementPresent() {
        list.add("1");
        assertTrue(list.contains("1"));
    }

    @Test
    public void testContainsWhenNoElement() {
        list.add("1");
        assertFalse(list.contains("2"));
    }

    // indexOf test

    @Test
    public void testIndexOf() {
        list.add("abc");
        assertEquals(0, list.indexOf("abc"));
        assertEquals(-1, list.indexOf("dbc"));
    }
}






