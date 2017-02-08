package data_structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
 * Created by anastasiia.shvetsova on 1/31/2017.
 */
public abstract class MyListTest {
    protected MyList<String> list;

    @Before
    public abstract void setUp();

    @Test
    public void testAddOneElement(){
        boolean actual = list.add("1");
        boolean expected = true;
        assertTrue(actual);
        assertEquals(1, list.size());
    }

    @Test
    public void testAddThreeElements(){
        assertTrue(list.add("0"));
        assertEquals(1, list.size());
        assertTrue(list.add("1"));
        assertEquals(2, list.size());
        assertTrue(list.add("2"));
        assertEquals(3, list.size());
        assertTrue(list.add("3"));
        assertEquals(4, list.size());
    }

    @Test
    public void testAddByIndex(){
        list.add("1");
        list.add("2");
        list.add("2");

        assertTrue(list.add(0,"2"));

        assertTrue(list.add(1,"6"));
    }

    @Test
    public void testWrongIndex(){
        list.add("black");
        list.add("white");
        assertTrue(list.wrongIndex(4));

    }

    @Test
    public void testGet(){
        list.add("black");
        list.add("white");
        assertEquals("white", list.get(1));
    }

    @Test
    public void testRemoveByIndex(){
        list.add("12");
        list.add("13");
        int oldSize = list.size();
        assertTrue(list.remove(1));
        assertEquals(oldSize - 1, list.size());
    }

    @Test
    public void testRemoveByObject(){
        list.add("black");
        list.add("white");
        assertTrue(list.remove("black"));
    }

    @Test
    public void testSet(){
        list.add("black");
        list.add("white");
        assertTrue(list.set(1, "pink"));
    }

    @Test
    public void testClear(){
        list.add("black");
        list.add("white");
        assertTrue(list.clear());
    }

    @Test
    public  void testContains(){
        list.add("black");
        list.add("white");
        list.add("blue");
        list.add("red");
        assertTrue(list.contains("blue"));
    }

    @Test
    public  void testSize(){
        list.add("black");
        list.add("white");
        list.add("blue");
        list.add("red");
        assertEquals(4,list.size());
    }

    @Test
    public  void testIsEmpty(){
        assertTrue(list.isEmpty());
    }
}