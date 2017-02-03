package week1.homeWork.implementAL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import week1.homeWork.implementAL.ArrList;

/**
 * Created by Игорь on 29.01.2017.
 */
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

        Assert.assertTrue(actual);
        //Assert.assertEquals(3, list.size());
    }

    @Test
    public void testRemove(){
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");

        boolean actual = list.remove(5);
        Assert.assertFalse(actual);
    }

    @Test
    public void testContains(){
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");

        boolean actual = list.contains("222");
        Assert.assertTrue(actual);
    }

    @Test
    public void testSize(){
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");

        int actual = list.size();
        Assert.assertEquals(4, actual);
    }
}
