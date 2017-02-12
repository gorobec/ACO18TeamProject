//http://codingbat.com/prob/p107330
package classWork.w4.d2;

public class RecTest {
    public static void main(String[] args) {
//        System.out.println(factorial(5));
//        factorial(5);
        System.out.println(bunnyEars2(2));
    }

    public static int bunnyEars2(int bunnies) {
        if (bunnies < 1) {
            return 0;
        }
        return bunnyEars2(bunnies - 1)+ (bunnies % 2 == 0 ? 2 : 1);
    }


    public static int factorial(int n) {
        if (n < 1) {
            return 1;
        }
        int result = factorial(n - 1) * n;
        System.out.println(result);
        return result;
    }

    public static void f(int i) {
        if (i < 5) {
            System.out.printf("%d ", i);
            f(++i);
            System.out.printf("%d ", i);
        }
    }
}