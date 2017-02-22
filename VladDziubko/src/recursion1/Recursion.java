package recursion1;

public class Recursion {
    /*Given n of 1 or more, return the factorial of n,
    which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).
    factorial(1) → 1
    factorial(2) → 2
    factorial(3) → 6   */

    public int factorial(int n) {
        if(n == 1){
            return 1;
        }
        return factorial(n - 1) * n;
    }

    /*We have bunnies standing in a line, numbered 1, 2, ...
    The odd bunnies (1, 3, ..) have the normal 2 ears.
    The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot.
    Recursively return the number of "ears" in the bunny
    line 1, 2, ... n (without loops or multiplication).
    bunnyEars2(0) → 0
    bunnyEars2(1) → 2
    bunnyEars2(2) → 5*/

    public int bunnyEars2(int bunnies) {
        if(bunnies == 0){
            return 0;
        }
        return bunnies % 2 == 0 ? bunnyEars2(bunnies - 1) + 3 :
                bunnyEars2(bunnies - 1) + 2;
    }

    /*Given a string, compute recursively a new string where identical
    chars that are adjacent in the original string are separated from each other by a "*".
    pairStar("hello") → "hel*lo"
    pairStar("xxyy") → "x*xy*y"
    pairStar("aaaa") → "a*a*a*a"*/

    public String pairStar(String str) {
        if(str.length() < 2){
            return str;
        }
        return str.substring(0, 1).equals(str.substring(1, 2)) ?
                str.substring(0, 1) + "*" + pairStar(str.substring(1)) :
                str.substring(0, 1) + pairStar(str.substring(1));
    }

    /*We have a number of bunnies and each bunny has two big floppy ears.
     We want to compute the total number of ears across all the bunnies
     recursively (without loops or multiplication).
    bunnyEars(0) → 0
    bunnyEars(1) → 2
    bunnyEars(2) → 4*/

    public int bunnyEars(int bunnies) {
        int ears = 2;
        if(bunnies == 0){
            return 0;
        }
        int res = 2 + bunnyEars(bunnies - 1);
        return res;
    }

    /*We have triangle made of blocks. T
    he topmost row has 1 block, the next row down has 2 blocks,
    the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication)
     the total number of blocks in such a triangle with the given number of rows.
    triangle(0) → 0
    triangle(1) → 1
    triangle(2) → 3*/

    public int triangle(int rows) {
        if(rows == 0){
            return 0;
        }
        if(rows == 1){
            return 1;
        }
        return triangle(rows - 1) + rows;
    }

    /*Given an array of ints, compute recursively if the array contains somewhere a value followed
    in the array by that value times 10. We'll use the convention of considering only the part of the
    array that begins at the given index. In this way, a recursive call can pass index+1 to move down
     the array. The initial call will pass in index as 0.
    array220([1, 2, 20], 0) → true
    array220([3, 30], 0) → true
    array220([3], 0) → false*/

    public boolean array220(int[] nums, int index) {
        if(index >= nums.length - 1){
            return false;
        }
        if(nums[index + 1] == nums[index] * 10){
            return true;
        }
        return array220(nums, index + 1);
    }

    /*The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive
     definition. The first two values in the sequence are 0 and 1 (essentially 2 base cases).
      Each subsequent value is the sum of the previous two values, so the whole sequence is:
      0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. Define a recursive fibonacci(n) method that returns
      the nth fibonacci number, with n=0 representing the start of the sequence.
    fibonacci(0) → 0
    fibonacci(1) → 1
    fibonacci(2) → 1*/

    public int fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /*Given base and n that are both 1 or more, compute recursively (no loops) the value of
     base to the n power, so powerN(3, 2) is 9 (3 squared).
    powerN(3, 1) → 3
    powerN(3, 2) → 9
    powerN(3, 3) → 27*/

    public int powerN(int base, int n) {
        //return (int)Math.pow(base, n);
        if(n == 0){
            return 1;
        }
        return base * powerN(base, n - 1);
    }

    /*Given an array of ints, compute recursively if the array contains a 6.
    We'll use the convention of considering only the part of the array that begins at the given index.
    In this way, a recursive call can pass index+1 to move down the array. The initial call will pass
    in index as 0.
    array6([1, 6, 4], 0) → true
    array6([1, 4], 0) → false
    array6([6], 0) → true*/

    public boolean array6(int[] nums, int index) {
        if(index > nums.length - 1){
            return false;
        }
        return nums[index] == 6 ? true : array6(nums, index + 1);
    }

    /*Given a string, compute recursively a new string where all the adjacent chars are now
    separated by a "*".
    allStar("hello") → "h*e*l*l*o"
    allStar("abc") → "a*b*c"
    allStar("ab") → "a*b"*/

    public String allStar(String str) {
        if(str.length() < 2){
            return str;
        }
        return str.substring(0, 1) + "*" + allStar(str.substring(1));
    }

    /*We'll say that a "pair" in a string is two instances of a char separated by a char.
    So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA" contains 3 pairs -- 2
    for A and 1 for x. Recursively compute the number of pairs in the given string.
    countPairs("axa") → 1
    countPairs("axax") → 2
    countPairs("axbx") → 1*/

    public int countPairs(String str) {
        if(str.length() < 3){
            return 0;
        }
        return str.substring(0, 1).equals(str.substring(2, 3)) ?
                1 + countPairs(str.substring(1)) : countPairs(str.substring(1));
    }

}
