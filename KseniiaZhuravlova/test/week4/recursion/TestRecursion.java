package week4.recursion;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ksyashka on 16.02.2017.
 */
public class TestRecursion {

    @Test
    public void testFibonacci() {
        assertTrue(Recursion.fibonacci(7) == 13);
        assertTrue(Recursion.fibonacci(5) == 5);
    }

    @Test
    public void testTriangle() {
        assertTrue(Recursion.triangle(7) == 28);
        assertTrue(Recursion.triangle(0) == 0);
    }

    @Test
    public void testSumDigits() {
        assertTrue(Recursion.sumDigits(12345) == 15);
        assertTrue(Recursion.sumDigits(1000) == 1);
    }

    @Test
    public void TestCount7() {
        assertTrue(Recursion.count7(12345) == 0);
        assertTrue(Recursion.count7(1707) == 2);
    }

    @Test
    public void TestCount8() {
        assertTrue(Recursion.count8(808) == 2);
        assertTrue(Recursion.count8(88788) == 6);
    }

    @Test
    public void TestPowerN() {
        assertTrue(Recursion.powerN(3, 3) == 27);
        assertTrue(Recursion.powerN(2, 10) == 1024);
    }

    @Test
    public void TestCountX() {
        assertTrue(Recursion.countX("xxxabcdx") == 4);
        assertTrue(Recursion.countX("") == 0);
    }

    @Test
    public void TestChangeXY() {
        assertTrue(Recursion.changeXY("xxxabcdx").equals("yyyabcdy"));
        assertTrue(Recursion.changeXY("rtyhgf").equals("rtyhgf"));
    }

    @Test
    public void TestNestParen() {
        assertTrue(!Recursion.nestParen("((yy))"));
        assertTrue(Recursion.nestParen("(((())))"));

    }

    @Test
    public void endX() {
        assertTrue(Recursion.endX("xxhixx").equals("hixxxx"));
        assertTrue(Recursion.endX("xx").equals("xx"));
    }
}
