package data_structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by anastasiia.shvetsova on 1/31/2017.
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

    //@Test
    /*public void testAddByIndex(){
        assertTrue(list.add(0,2));
        assertTrue(list.add(1,6));
    }*/
    @Test
    public void testWrongIndex(){
        list.add("black");
        list.add("white");
        assertTrue(list.wrongIndex(1));
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
        list.add("blue");
        list.add("red");
        assertEquals("pink", list.set(1, "pink"));
        assertEquals("grey", list.set(2, "grey"));
        assertEquals("green", list.set(1, "green"));
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
        list.add("black");
        list.add("white");
        list.add("blue");
        list.add("red");
        int size = list.size();
        assertTrue(list.isEmpty());
    }
}