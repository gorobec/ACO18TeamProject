package week4.recursion1;

public class RunRecursion {

    public static void main(String[] args) {
//        System.out.println(factorial(5));
//        System.out.println(bunnyEars(5));
//        System.out.println(fibonacci(10));
//        System.out.println(bunnyEars2(4));
//        System.out.println(triangle(5));
//        System.out.println(sumDigits(123));
//        System.out.println(count7(77717127));
//        System.out.println(count8(883838838));
//        System.out.println(powerN(3,3));
//        System.out.println(countX("xkmkdfxxdXXkx"));
//        System.out.println(countHi("hixhixxxhidfHi"));
//        System.out.println(changeXY("xxyyxxa"));
//        System.out.println(changePi("apiasdaipisapia"));

    }
    /*
    Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1.
    Compute the result recursively (without loops).

    factorial(1) → 1
    factorial(2) → 2
    factorial(3) → 6
    */

    public static int factorial(int n) {
        if (n == 1) return 1;
        return factorial(n - 1) * n;
    }

    /*
    We have a number of bunnies and each bunny has two big floppy ears.
    We want to compute the total number of ears across all the bunnies recursively
    (without loops or multiplication).

    bunnyEars(0) → 0
    bunnyEars(1) → 2
    bunnyEars(2) → 4
    */

    public static int bunnyEars(int bunnies) {
        if (bunnies == 0)
            return 0;

        int myEars = 2;
        int returnVal = bunnyEars(bunnies - 1);
        return myEars + returnVal;

    }

    /*
     The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition.
     The first two values in the sequence are 0 and 1 (essentially 2 base cases).
     Each subsequent value is the sum of the previous two values,
     so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
     Define a recursive fibonacci(n) method that returns the nth fibonacci number,
     with n=0 representing the start of the sequence.

    fibonacci(0) → 0
    fibonacci(1) → 1
    fibonacci(2) → 1
    */

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);

    }

    /*
    We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears.
    The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot.
    Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).

    bunnyEars2(0) → 0
    bunnyEars2(1) → 2
    bunnyEars2(2) → 5
    */

    public static int bunnyEars2(int bunnies) {

        if (bunnies == 0)
            return 0;
        if (bunnies % 2 == 1) {
            return 2 + bunnyEars2(bunnies - 1);
        }
        return 3 + bunnyEars2(bunnies - 1);
    }

    /*
    We have triangle made of blocks.
    The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on.
    Compute recursively (no loops or multiplication) the total number of blocks
    in such a triangle with the given number of rows.

    triangle(0) → 0
    triangle(1) → 1
    triangle(2) → 3
    */

    public static int triangle(int rows) {
        if (rows == 0)
            return 0;
        else
            return rows + triangle(rows - 1);
    }

    /*
    Given a non-negative int n, return the sum of its digits recursively (no loops).
    Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
    while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).

    sumDigits(126) → 9
    sumDigits(49) → 13
    sumDigits(12) → 3
    */

    public static int sumDigits(int n) {
        if (n == 0)
            return 0;
        else
            return sumDigits(n / 10) + n % 10;

    }

    /*
    Given a non-negative int n, return the count of the occurrences of 7 as a digit,
    so for example 717 yields 2. (no loops). Note that mod (%) by 10 yields the rightmost digit
    (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).

    count7(717) → 2
    count7(7) → 1
    count7(123) → 0
    */

    public static int count7(int n) {
        if (n == 0) return 0;
        if (n % 10 == 7) return 1 + count7(n / 10);
        return count7(n / 10);
    }

    /*
    Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit,
    except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4.
    Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
    while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).

    count8(8) → 1
    count8(818) → 2
    count8(8818) → 4
    */

    public static int count8(int n) {
        if (n == 0) return 0;
        if (n % 10 == 8 && (n / 10) % 10 == 8) return 2 + count8(n / 10);
        else if (n % 10 == 8) return 1 + count8(n / 10);
        else return count8(n / 10);
    }

    /*
    Given base and n that are both 1 or more,
    compute recursively (no loops) the value of base to the n power,
    so powerN(3, 2) is 9 (3 squared).

    powerN(3, 1) → 3
    powerN(3, 2) → 9
    powerN(3, 3) → 27
    */

    public static int powerN(int base, int n) {
        if (n == 0) return 1;
        return base * powerN(base, n - 1);
    }

    /*
    Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.

    countX("xxhixx") → 4
    countX("xhixhix") → 3
    countX("hi") → 0
    */

    public static int countX(String str) {
        if (str.length() == 0)
            return 0;
        else if (str.substring(0, 1).equalsIgnoreCase("x")) return 1 + countX(str.substring(1));
        else return countX(str.substring(1));
    }

    /*Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.

    countHi("xxhixx") → 1
    countHi("xhixhix") → 2
    countHi("hi") → 1
    */

    public static int countHi(String str) {
        if (str.length() < 2)
            return 0;
        else if (str.substring(0, 2).equals("hi")) return 1 + countHi(str.substring(1));
        else return countHi(str.substring(1));
    }

    /*
    Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.

    changeXY("codex") → "codey"
    changeXY("xxhixx") → "yyhiyy"
    changeXY("xhixhix") → "yhiyhiy"
    */

    public static String changeXY(String str) {
        if (str.length() < 1) return "";
        if (str.charAt(0) == 'x') return "y" + changeXY(str.substring(1));
        return str.charAt(0) + changeXY(str.substring(1));
    }

    /*
    Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".

    changePi("xpix") → "x3.14x"
    changePi("pipi") → "3.143.14"
    changePi("pip") → "3.14p"
    */

    public static String changePi(String str) {
        if (str.length() < 2) return str;
        if (str.substring(0, 2).equals("pi")) return "3.14" + changePi(str.substring(2));
        return str.substring(0, 1) + changePi(str.substring(1));
    }

    /*Given a string, compute recursively a new string where all the 'x' chars have been removed.

    noX("xaxb") → "ab"
    noX("abc") → "abc"
    noX("xx") → ""
    */

    public static String noX(String str) {
        if (str.length() < 1) return "";
        if (str.charAt(0) == 'x') return "" + noX(str.substring(1));
        return str.charAt(0) + noX(str.substring(1));
    }

    /*Given an array of ints, compute recursively if the array contains a 6.
    We'll use the convention of considering only the part of the array that begins at the given index.
    In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.

    array6([1, 6, 4], 0) → true
    array6([1, 4], 0) → false
    array6([6], 0) → true
    */

    public static boolean array6(int[] nums, int index) {
        if (nums.length == 0 || index > nums.length - 1) return false;
        if (nums[index] == 6) return true;
        return array6(nums, index + 1);
    }

    /*
    Given an array of ints, compute recursively the number of times that the value 11 appears in the array.
    We'll use the convention of considering only the part of the array that begins at the given index.
    In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.

    array11([1, 2, 11], 0) → 1
    array11([11, 11], 0) → 2
    array11([1, 2, 3, 4], 0) → 0
    */

    public static int array11(int[] nums, int index) {
        int count11 = 0;
        if (nums.length == 0 || index > nums.length - 1) return 0;
        if (nums[index] == 11) count11++;
        return count11 + array11(nums, index + 1);
    }

    /*
    Given an array of ints, compute recursively if the array contains somewhere a value
    followed in the array by that value times 10.
    We'll use the convention of considering only the part of the array that begins at the given index.
    In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.

    array220([1, 2, 20], 0) → true
    array220([3, 30], 0) → true
    array220([3], 0) → false
    */

    public static boolean array220(int[] nums, int index) {
        if (nums.length < 2 || index > nums.length - 2) return false;
        if (nums[index] * 10 == nums[index + 1]) return true;
        return array220(nums, index + 1);
    }

    /*
    Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".

    allStar("hello") → "h*e*l*l*o"
    allStar("abc") → "a*b*c"
    allStar("ab") → "a*b"
    */

    public static String allStar(String str) {
        if (str.length() < 2) return str;
        return str.charAt(0) + "*" + allStar(str.substring(1, 2));
    }

    /*
    Given a string, compute recursively a new string where identical chars that are adjacent in the original string
    are separated from each other by a "*".

    pairStar("hello") → "hel*lo"
    pairStar("xxyy") → "x*xy*y"
    pairStar("aaaa") → "a*a*a*a"
    */

    public static String pairStar(String str) {
        if (str.length() < 2) return str;
        if (str.charAt(0) == str.charAt(1))
            return str.charAt(0) + "*" + pairStar(str.substring(1));
        else return str.charAt(0) + pairStar(str.substring(1));
    }

    /*
    Given a string, compute recursively a new string
    where all the lowercase 'x' chars have been moved to the end of the string.

    endX("xxre") → "rexx"
    endX("xxhixx") → "hixxxx"
    endX("xhixhix") → "hihixxx"
    */

    public static String endX(String str) {
        if (str.length() < 2) return str;
        if (str.charAt(0) == 'x') return endX(str.substring(1)) + 'x';
        else return str.charAt(0) + endX(str.substring(1));
    }

    /*
    We'll say that a "pair" in a string is two instances of a char separated by a char.
    So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA" contains 3 pairs -- 2 for A and 1 for x.
    Recursively compute the number of pairs in the given string.

    countPairs("axa") → 1
    countPairs("axax") → 2
    countPairs("axbx") → 1
    */

    public static int countPairs(String str) {
        if (str.length() <= 2) return 0;
        if (str.length() == 2) return 1;
        if (str.substring(0, 1).equals(str.substring(2, 3))) return 1 + countPairs(str.substring(1));
        return countPairs(str.substring(1));
    }

    /*
    Count recursively the total number of "abc" and "aba" substrings that appear in the given string.

    countAbc("abc") → 1
    countAbc("abcxxabc") → 2
    countAbc("abaxxaba") → 2
    */

    public static int countAbc(String str) {
        if (str.length() < 3) return 0;
        if (str.substring(0, 3).equals("abc") || str.substring(0, 3).equals("aba"))
            return 1 + countAbc(str.substring(1));
        return countAbc(str.substring(1));
    }

    /*
    *
    Given a string, compute recursively (no loops) the number of "11" substrings in the string.
    The "11" substrings should not overlap.

    count11("11abc11") → 2
    count11("abc11x11x11") → 3
    count11("111") → 1*/

    public static int count11(String str) {
        if (str.length() < 2) return 0;
        if (str.substring(0, 2).equals("11"))
            return 1 + count11(str.substring(2));
        return count11(str.substring(1));
    }

    /*
    Given a string, return recursively a "cleaned" string where adjacent chars
    that are the same have been reduced to a single char. So "yyzzza" yields "yza".

    stringClean("yyzzza") → "yza"
    stringClean("abbbcdd") → "abcd"
    stringClean("Hello") → "Helo"*/

    public String stringClean(String str) {
        if (str.length() < 2) return str;
        if (str.charAt(0) == str.charAt(1)) return stringClean(str.substring(1));
        return str.charAt(0) + stringClean(str.substring(1));
    }

    /*
    Given a string, compute recursively the number of times lowercase "hi" appears in the string,
    however do not count "hi" that have an 'x' immedately before them.

    countHi2("ahixhi") → 1
    countHi2("ahibhi") → 2
    countHi2("xhixhi") → 0*/

    public int countHi2(String str) {
        if (str.length() < 2)
            return 0;
        else if (str.charAt(str.length() - 3) != 'x' && str.substring(str.length() - 2, str.length()).equals("hi"))
            return 1 + countHi2(str.substring(0, str.length() - 1));
        else return countHi2(str.substring(0, str.length() - 1));
    }
}
