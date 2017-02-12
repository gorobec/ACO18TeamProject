package oop.dataStructures;

import oop.dataStructures.MyArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by fmandryka on 29.01.2017.
 */
public class MyListsTest {

    private MyArrayList<String> list;
//    private MyLinkedList<String> list;

    @Before
    public void setUp() {
        list = new MyArrayList<String>();
//        list = new MyLinkedList<String>();
    }


    @Test
    public void testAddThreeElement(){
        assertTrue(list.add("0"));
        assertEquals(1, list.size());
        assertTrue(list.add("1"));
        assertEquals(2, list.size());
        assertTrue(list.add("2"));
        assertEquals(3, list.size());
    }

    @Test
    public void testRemoveWhenElementPresent(){
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        assertTrue(list.remove("1"));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveWhenEmptyList(){
        assertEquals(0, list.size());
        assertFalse(list.remove("2"));
        assertEquals(0, list.size());
    }

    @Test
    public void testRemoveNullElementPresent(){
        assertTrue(list.add(null));
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        assertTrue(list.remove(null));
        assertEquals(2, list.size());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveWrongIndex(){
        list.remove(-5);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetWhenEmptyList(){
        list.get(-5);
    }

    @After
    public void clear() {
        list.clear();
    }

}
