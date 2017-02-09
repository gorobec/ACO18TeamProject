package library.utils;

import library.controller.Library;
import org.junit.*;
import static org.junit.Assert.*;

public abstract  class TestListMy {
    ListMy list;

    @Before
    public abstract void setUp();

    @After
    public void tearDown() {
        list = null;
    }

    @Test
    public void testAdd1Elem() {
        assertTrue(list.add("1"));
    }

    @Test
    public void testAddAndIncreaseCapasity() {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        assertTrue(list.add("11"));
        assertTrue(list.size()==11);
    }

    @Test
    public void testAddByIndex() {
        list.add("0");
        list.add("1");
        list.add("2");
        list.add(1, "3");
        assertEquals("3", list.get(1));
    }

    @Test
    public void testAddByBigIndex() {
        list.add("0");
        list.add("1");
        list.add("2");
        assertFalse(list.add(15, "3"));
    }

    @Test
    public void testRemoveByIndex() {
        list.add("0");
        list.add("1");
        list.add("2");
        list.remove(1);
        assertEquals("2", list.get(1));
    }

    @Test
    public void testRemoveByIndexTrue() {
        list.add("0");
        list.add("1");
        list.add("2");
        assertTrue(list.remove(1));
    }

    @Test
    public void testRemoveByIndexFalse() {
        list.add("0");
        list.add("1");
        list.add("2");
        assertFalse(list.remove(5));
    }

    @Test
    public void testRemoveByObject() {
        list.add("0");
        list.add("1");
        list.add("2");
        assertTrue(list.remove("1"));
        assertEquals("2", list.get(1));
    }

    @Test
    public void testSet() {
        list.add("0");
        list.add("1");
        list.add("2");
        assertTrue(list.set(1, "3"));
        assertEquals("3", list.get(1));
    }

    @Test
    public void testSetNeg() {
        list.add("0");
        list.add("1");
        list.add("2");
        assertFalse(list.set(-1, "3"));
    }

    @Test
    public void testClear() {
        list.add("0");
        list.add("1");
        list.add("2");
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testContainsTrue() {
        list.add("0");
        list.add("1");
        list.add("2");
        assertTrue(list.contains("2"));
    }

    @Test
    public void testContainsFalse() {
        list.add("0");
        list.add("1");
        list.add("2");
        assertFalse(list.contains("3"));
    }

    @Test
    public void testSizeAdd2Elem() {
        list.add("1");
        list.add("2");
        assertEquals(2, list.size());
    }

    @Test
    public void testGet (){
        list.add("1");
        list.add("2");
        list.add("3");
        assertEquals("1",list.get(0));
        assertEquals("2",list.get(1));
        assertEquals("3",list.get(2));
    }
}
