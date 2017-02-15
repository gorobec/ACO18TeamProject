package classWork.w4.d2;

public class RecTest {
    public static void main(String[] args) {
//        System.out.println(factorial(5));
//        factorial(5);
//        System.out.println(bunnyEars2(2));
//        System.out.println(count7(777777));
//        System.out.println(bunnyEars(5));
//        System.out.println(fibonacci(20));
//        System.out.println(triangle(6));
//        System.out.println(sumDigits(5));
//        System.out.println(count8(8888));
        System.out.println(powerN(3, 2));
    }

    public static int powerN(int base, int n) {
        return n == 0 ? 1 : powerN(base, n - 1) * base;
    }

    public static int count8(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 10 == 8 && (n / 10) % 10 == 8) {
            return 2 + count8(n / 10);
        }
        if (n % 10 == 8) {
            return 1 + count8(n / 10);
        }
        return count8(n / 10);
    }

    public static int sumDigits(int n) {
        return n < 1 ? 0 : sumDigits(n / 10) + n % 10;
    }

    public static int triangle(int rows) {
        return rows < 1 ? 0 : triangle(rows - 1) + rows;
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == -1) {
            return 1;
        }

        return n > 0 ? fibonacci(n - 2) + fibonacci(n - 1) : fibonacci(n + 2) - fibonacci(n + 1);
    }

    public static int count7(int n) {
        return n < 7 ? 0 : count7(n / 10) + (n % 10 == 7 ? 1 : 0);
    }

    public static int bunnyEars(int bunnies) {
        return bunnies == 0 ? 0 : bunnyEars(bunnies - 1) + 2;
    }

    public static int bunnyEars2(int bunnies) {
        if (bunnies < 1) {
            return 0;
        }
        return bunnyEars2(bunnies - 1) + (bunnies % 2 == 0 ? 3 : 2);
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