package oop.week4.recursion;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Администратор on 14.02.2017.
 */
public class TestRecursion {

    RecursionUtils rec = new RecursionUtils();

    @Before
    public void setUp() {

    }


    @Test
    public void testBunnyEars2() {
        assertEquals(0, rec.bunnyEars2(0));
        assertEquals(2, rec.bunnyEars2(1));
        assertEquals(5, rec.bunnyEars2(2));
        assertEquals(7, rec.bunnyEars2(3));
        assertEquals(10, rec.bunnyEars2(4));
        assertEquals(12, rec.bunnyEars2(5));
        assertEquals(15, rec.bunnyEars2(6));
        assertEquals(25, rec.bunnyEars2(10));
    }

    @Test
    public void testTriangle() {
        assertEquals(0, rec.triangle(0));
        assertEquals(1, rec.triangle(1));
        assertEquals(3, rec.triangle(2));
        assertEquals(6, rec.triangle(3));
        assertEquals(10, rec.triangle(4));
        assertEquals(15, rec.triangle(5));
        assertEquals(21, rec.triangle(6));
        assertEquals(28, rec.triangle(7));
    }

    @Test
    public void testFibonacci() {
        assertEquals(0, rec.fibonacci(0));
        assertEquals(1, rec.fibonacci(1));
        assertEquals(1, rec.fibonacci(2));
        assertEquals(2, rec.fibonacci(3));
        assertEquals(3, rec.fibonacci(4));
        assertEquals(5, rec.fibonacci(5));
        assertEquals(8, rec.fibonacci(6));
        assertEquals(13, rec.fibonacci(7));
    }

    @Test
    public void testSumDigits() {
        assertEquals(9, rec.sumDigits(126));
        assertEquals(13, rec.sumDigits(49));
        assertEquals(3, rec.sumDigits(12));
        assertEquals(1, rec.sumDigits(10));
        assertEquals(1, rec.sumDigits(1));
        assertEquals(0, rec.sumDigits(0));
        assertEquals(10, rec.sumDigits(730));
        assertEquals(4, rec.sumDigits(1111));
        assertEquals(5, rec.sumDigits(11111));
        assertEquals(3, rec.sumDigits(10110));
        assertEquals(10, rec.sumDigits(235));
    }


    @Test
    public void testCount7() {
        assertEquals(2, rec.count7(717));
        assertEquals(1, rec.count7(7));
        assertEquals(0, rec.count7(123));
        assertEquals(2, rec.count7(77));
        assertEquals(1, rec.count7(7123));
        assertEquals(3, rec.count7(771237));
        assertEquals(4, rec.count7(771737));
        assertEquals(2, rec.count7(47571));
        assertEquals(6, rec.count7(777777));
        assertEquals(4, rec.count7(70701277));
        assertEquals(5, rec.count7(777576197));
        assertEquals(0, rec.count7(99999));
        assertEquals(1, rec.count7(99799));
    }

    @Test
    public void testCount8() {
        assertEquals(1, rec.count8(8));
        assertEquals(2, rec.count8(818));
        assertEquals(4, rec.count8(8818));
        assertEquals(4, rec.count8(8088));
        assertEquals(0, rec.count8(123));
        assertEquals(2, rec.count8(81238));
        assertEquals(6, rec.count8(88788));
        assertEquals(1, rec.count8(8234));
        assertEquals(1, rec.count8(2348));
        assertEquals(3, rec.count8(23884));
        assertEquals(0, rec.count8(0));
        assertEquals(5, rec.count8(1818188));
        assertEquals(5, rec.count8(8818181));
        assertEquals(1, rec.count8(1080));
        assertEquals(3, rec.count8(188));
        assertEquals(9, rec.count8(88888));
        assertEquals(2, rec.count8(9898));
        assertEquals(1, rec.count8(78));
    }

    @Test
    public void testPowerN() {
        assertEquals(3, rec.powerN(3, 1));
        assertEquals(9, rec.powerN(3, 2));
        assertEquals(27, rec.powerN(3, 3));
        assertEquals(2, rec.powerN(2, 1));
        assertEquals(4, rec.powerN(2, 2));
        assertEquals(8, rec.powerN(2, 3));
        assertEquals(16, rec.powerN(2, 4));
        assertEquals(32, rec.powerN(2, 5));
        assertEquals(10, rec.powerN(10, 1));
        assertEquals(100, rec.powerN(10, 2));
        assertEquals(1000, rec.powerN(10, 3));

    }


    @Test
    public void testCountX() {
        assertEquals(4, rec.countX("xxhixx"));
        assertEquals(3, rec.countX("xhixhix"));
        assertEquals(0, rec.countX("hi"));
        assertEquals(0, rec.countX("h"));
        assertEquals(1, rec.countX("x"));
        assertEquals(0, rec.countX(""));
        assertEquals(0, rec.countX("hihi"));
        assertEquals(0, rec.countX("hiAAhi12hi"));

    }


    @Test
    public void testCountHi() {
        assertEquals(1, rec.countHi("xxhixx"));
        assertEquals(2, rec.countHi("xhixhix"));
        assertEquals(1, rec.countHi("hi"));
        assertEquals(2, rec.countHi("hihih"));
        assertEquals(0, rec.countHi("h"));
        assertEquals(0, rec.countHi(""));
        assertEquals(4, rec.countHi("ihihihihih"));
        assertEquals(5, rec.countHi("ihihihihihi"));
        assertEquals(3, rec.countHi("hiAAhi12hi"));
        assertEquals(3, rec.countHi("xhixhxihihhhih"));
        assertEquals(1, rec.countHi("ship"));
    }

    @Test
    public void testChangeXY() {
        assertEquals("codey", rec.changeXY("codex"));
        assertEquals("yyhiyy", rec.changeXY("xxhixx"));
        assertEquals("yhiyhiy", rec.changeXY("xhixhix"));
        assertEquals("hiy", rec.changeXY("hiy"));
        assertEquals("h", rec.changeXY("h"));
        assertEquals("y", rec.changeXY("x"));
        assertEquals("", rec.changeXY(""));
        assertEquals("yyy", rec.changeXY("xxx"));
        assertEquals("yyhyyi", rec.changeXY("yyhxyi"));
        assertEquals("hihi", rec.changeXY("hihi"));
    }

    @Test
    public void testGroupSum() {

        int[] a1 = {2, 4, 8};
        int[] a2 = {1};
        int[] a3 = {9};
        int[] a4 = {};
        int[] a5 = {10, 2, 2, 5};
        int[] a6 = {16, 50, 10, 20, 50};
        int[] a7 = {16, 50, 10, 20, 50, 45, 24};

        assertEquals(true, rec.groupSum(0, a1, 10));
        assertEquals(true, rec.groupSum(0, a1, 14));
        assertEquals(false, rec.groupSum(0, a1, 9));
        assertEquals(true, rec.groupSum(0, a1, 8));
        assertEquals(true, rec.groupSum(1, a1, 8));
        assertEquals(false, rec.groupSum(1, a1, 2));
        assertEquals(true, rec.groupSum(0, a2, 1));
        assertEquals(false, rec.groupSum(0, a3, 1));
        assertEquals(true, rec.groupSum(1, a3, 0));
        assertEquals(true, rec.groupSum(0, a4, 0));
        assertEquals(true, rec.groupSum(0, a5, 17));
        assertEquals(true, rec.groupSum(0, a5, 15));
        assertEquals(true, rec.groupSum(0, a5, 9));
        assertEquals(true, rec.groupSum(0, a6, 100));
        assertEquals(false, rec.groupSum(0, a6, 99));
        assertEquals(false, rec.groupSum(0, a6, 99));
        assertEquals(true, rec.groupSum(0, a7, 44));
    }

    @Test
    public void testGroupSum6() {

        int[] a1 = {5, 6, 2};
        int[] a2 = {1};
        int[] a3 = {9};
        int[] a4 = {};
        int[] a5 = {3, 2, 4, 6};
        int[] a6 = {6, 2, 4, 3};
        int[] a7 = {5, 2, 4, 6};
        int[] a8 = {6, 2, 4, 5};
        int[] a9 = {3, 2, 4, 6};
        int[] a10 = {1, 6, 2, 6, 4};
        int[] a11 = {1, 6, 2, 6, 5};


        assertEquals(true, rec.groupSum6(0, a1, 8));
        assertEquals(false, rec.groupSum6(0, a1, 9));
        assertEquals(false, rec.groupSum6(0, a1, 7));
        assertEquals(true, rec.groupSum6(0, a2, 1));
        assertEquals(false, rec.groupSum6(0, a3, 1));
        assertEquals(true, rec.groupSum6(0, a4, 0));
        assertEquals(true, rec.groupSum6(0, a5, 8));
        assertEquals(true, rec.groupSum6(0, a6, 8));
        assertEquals(false, rec.groupSum6(1, a7, 9));
        assertEquals(false, rec.groupSum6(0, a8, 9));
        assertEquals(false, rec.groupSum6(0, a9, 3));
        assertEquals(true, rec.groupSum6(0, a10, 12));
        assertEquals(true, rec.groupSum6(0, a10, 13));
        assertEquals(false, rec.groupSum6(0, a10, 4));
        assertEquals(false, rec.groupSum6(0, a10, 9));
        assertEquals(true, rec.groupSum6(0, a11, 14));
        assertEquals(true, rec.groupSum6(0, a11, 15));
        assertEquals(false, rec.groupSum6(0, a11, 16));
    }

    @Test
    public void testGroupNoAdj() {

        int[] a1 = {2, 5, 10, 4};
        int[] a2 = {12, 5, 10, 4, 2};
        int[] a3 = {10, 2, 2, 3, 3};
        int[] a4 = {};
        int[] a5 = {1};
        int[] a6 = {9};
        int[] a7 = {5, 10, 4, 1};



        assertEquals(true, rec.groupNoAdj(0, a1, 12));
        assertEquals(false, rec.groupNoAdj(0, a1, 14));
        assertEquals(false, rec.groupNoAdj(0, a1, 7));
        assertEquals(true, rec.groupNoAdj(0, a2, 7));
        assertEquals(true, rec.groupNoAdj(0, a1, 9));
        assertEquals(true, rec.groupNoAdj(0, a3, 15));
        assertEquals(false, rec.groupNoAdj(0, a3, 7));
        assertEquals(true, rec.groupNoAdj(0, a4, 0));
        assertEquals(true, rec.groupNoAdj(0, a5, 1));
        assertEquals(false, rec.groupNoAdj(0, a6, 1));
        assertEquals(true, rec.groupNoAdj(0, a6, 0));
        assertEquals(true, rec.groupNoAdj(0, a7, 11));

    }

}
