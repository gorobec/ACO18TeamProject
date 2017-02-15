package oop.week4.recursion;

/**
 * Created by Администратор on 14.02.2017.
 */
public class RecursionUtils {

    /**
     * We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..)
     * have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because
     * they each have a raised foot. Recursively return the number of "ears" in the bunny
     * line 1, 2, ... n (without loops or multiplication).
     */
    public int bunnyEars2(int bunnies) {

        if (bunnies == 0) {
            return 0;
        }

        int myEars;
        if (bunnies % 2 == 0) {
            myEars = 3;
        } else {
            myEars = 2;
        }

        return myEars + bunnyEars2(bunnies - 1);
    }


    /**
     * We have triangle made of blocks. The topmost row has 1 block, the next row down
     * has 2 blocks, the next row has 3 blocks, and so on. Compute recursively (no loops
     * or multiplication) the total number of blocks in such a triangle with the given number of rows.
     */
    public int triangle(int rows) {

        if (rows == 0) {
            return 0;
        }

        int blocks = rows;

        return blocks + triangle(rows - 1);
    }


    /**
     * The fibonacci sequence is a famous bit of mathematics, and it happens to have
     * a recursive definition. The first two values in the sequence are 0 and 1
     * essentially 2 base cases). Each subsequent value is the sum of the previous two values,
     * so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. Define a recursive
     * fibonacci(n) method that returns the nth fibonacci number, with n=0 representing
     * the start of the sequence.
     */
    public int fibonacci(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    /**
     * Given a non-negative int n, return the sum of its digits recursively (no loops).
     * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while
     * divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
     */
    public int sumDigits(int n) {

        if (n == 0) {
            return 0;
        }

        return n % 10 + sumDigits(n / 10);
    }

    /**
     * Given a non-negative int n, return the count of the occurrences of 7 as a digit,
     * so for example 717 yields 2. (no loops). Note that mod (%) by 10 yields the
     * rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the
     * rightmost digit (126 / 10 is 12).
     */
    public int count7(int n) {

        if (n == 0) {
            return 0;
        }

        int count = n % 10 == 7 ? 1 : 0;

        return count + count7(n / 10);
    }

    /**
     * Given a non-negative int n, compute recursively (no loops) the count of the
     * occurrences of 8 as a digit, except that an 8 with another 8 immediately to
     * its left counts double, so 8818 yields 4. Note that mod (%) by 10 yields the
     * rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost
     * digit (126 / 10 is 12).
     */
    public int count8(int n) {

        if (n == 0) {
            return 0;
        }

        int count = n % 100 == 88 ? 2 : n % 10 == 8 ? 1 : 0;

        return count + count8(n / 10);
    }

    /**
     * Given base and n that are both 1 or more, compute recursively (no loops)
     * the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
     */
    public int powerN(int base, int n) {

        if (n == 0) {
            return 1;
        }

        return base * powerN(base, n - 1);
    }

    /**
     * Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
     */
    public int countX(String str) {

        if (str.length() == 0) {
            return 0;
        }

        int count = str.charAt(str.length() - 1) == 'x' ? 1 : 0;

        return count + countX(str.substring(0, str.length() - 1));
    }


    /**
     * Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.
     */
    public int countHi(String str) {

        if (str.length() == 0) {
            return 0;
        }

        int count = str.endsWith("hi") ? 1 : 0;

        return count + countHi(str.substring(0, str.length() - 1));
    }

    /**
     * Given a string, compute recursively (no loops) a new string where all the
     * lowercase 'x' chars have been changed to 'y' chars.
     */
    public String changeXY(String str) {

        if (str.length() == 0) {
            return "";
        }

        String result;
        if (str.charAt(str.length() - 1) == 'x') {
            result = String.valueOf('y');
        } else {
            result = String.valueOf(str.charAt(str.length() - 1));
        }

        return changeXY(str.substring(0, str.length() - 1)) + result;
    }


    /**
     * Given an array of ints, is it possible to choose a group of some of the ints,
     * such that the group sums to the given target? This is a classic backtracking
     * recursion problem. Once you understand the recursive backtracking strategy in
     * this problem, you can use the same pattern for many problems to search a space
     * of choices. Rather than looking at the whole array, our convention is to consider
     * the part of the array starting at index start and continuing to the end of the
     * array. The caller can specify the whole array simply by passing start as 0. No loops
     * are needed -- the recursive calls progress down the array.
     */


    public boolean groupSum(int start, int[] nums, int target) {

        if (start == nums.length) {
            return true;
        }

        if (groupSum(start + 1, nums, target)) {
            return true;
        }

        int sum = nums[start];

        if (groupSum(start + 1, nums, target - nums[start])) {
            return true;
        }

        return groupSum(start + 1, nums, target - nums[start]);

    }
}
