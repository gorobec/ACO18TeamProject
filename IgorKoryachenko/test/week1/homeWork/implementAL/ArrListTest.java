package week1.homeWork.implementAL;

import static org.junit.Assert.*;
import  org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;
//import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import week1.homeWork.implementAL.ArrList;


public class
ArrListTest {
    private ArrList list;

    @Before
    public void setUp(){
        list = new ArrList();
    }

    @Test
    public void testAddOneElement(){
        boolean actual = list.add("1");

        assertTrue(actual);
        //Assert.assertEquals(3, list.size());
    }

    @Test
    public void testGet(){
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");

        String actual = (String) list.get(2);
        assertThat(actual, is("333"));
    }

    @Test
    public void testSet(){
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");

        list.set(2, "555");
        String actual = (String) list.get(2);
        assertThat(actual, is("555"));
    }

    @Test
    public void testClear(){
        boolean actual = list.clear();
        assertTrue(actual);
    }

    @Test
    public void testToArray(){
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");

        list.toArray(list);
        Object actual[] = list.toArray(list);
        Object [] arr = {"111","222","333","444"};
        assertThat(actual, is(arr));
    }

    @Test
    public void testRemove(){
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");

        boolean actual = list.remove(5);
        assertFalse(actual);
    }

    @Test
    public void testRemoveObject(){
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");

        boolean actual = list.remove("333");
        assertTrue(actual);
    }

    @Test
    public void testContains(){
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");

        boolean actual = list.contains("222");
        assertTrue(actual);
    }

    @Test
    public void testSize(){
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");

        int actual = list.size();
        assertEquals(4, actual);
    }
}
