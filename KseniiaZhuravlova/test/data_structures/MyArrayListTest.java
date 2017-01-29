package data_structures;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by ksyashka on 29.01.2017.
 */
public class MyArrayListTest {

    private MyArrayList list;

    @Before
    public void setUp(){
        list = new MyArrayList();
    }

    @Test
    public void testAddOneElement(){
        boolean actual = list.add("1");
        assertTrue(actual);
        assertEquals(1, list.size());
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
    public void testAddElementByIndex(){
        assertTrue(list.add(0,"2"));
        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveWhenElemetPresent(){
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("1"));
        assertTrue(list.remove("1"));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveWhenNoElemetPresent(){
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("1"));
        assertTrue(list.remove("2"));
        assertEquals(3, list.size());
    }
}
