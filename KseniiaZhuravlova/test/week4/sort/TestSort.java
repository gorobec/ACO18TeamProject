package week4.sort;

import org.junit.Test;
import week4.recursion.Recursion;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ksyashka on 17.02.2017.
 */
public abstract class TestSort{
    protected Sort<Integer> sort;


    @Test
    public void testSort(){
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(900);
        list.add(-1);
        list.add(11);
        list.add(189);
        list.add(7);
        list.add(-200);
        List<Integer> expected = new ArrayList<>();
        expected.add(-200);
        expected.add(-1);
        expected.add(7);
        expected.add(9);
        expected.add(11);
        expected.add(189);
        expected.add(900);
        long start = System.nanoTime();
        list = sort.mySort(list);
        long finish = System.nanoTime();
        long timeConsumedMillis = finish - start;
        assertEquals(expected,list);
        System.out.println(timeConsumedMillis);
    }
}
