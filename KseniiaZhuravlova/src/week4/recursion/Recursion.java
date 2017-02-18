package week4.recursion;


public class Recursion {

    static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    static int triangle(int rows) {
        if (rows == 0) return 0;
        return rows + triangle(rows - 1);
    }

    static int sumDigits(int n) {
        if (n == 0) return 0;
        return n % 10 + sumDigits(n / 10);
    }

    static int count7(int n) {
        if (n == 0) return 0;
        if (n % 10 == 7) return 1 + count7(n / 10);
        return count7(n / 10);
    }

    static int count8(int n) {
        if (n == 0) return 0;
        if (n % 100 == 88) return 2 + count8(n / 10);
        if (n % 10 == 8) return 1 + count8(n / 10);
        return count8(n / 10);
    }

    static int powerN(int base, int n) {
        if (n == 0) return 1;
        return base * powerN(base, n - 1);
    }

    static int countX(String str) {
        if (str.length() == 0)
            return 0;
        if (str.charAt(0) == 'x')
            return 1 + countX(str.substring(1));
        return countX(str.substring(1));
    }

    static String changeXY(String str) {
        if (str.length() == 0)
            return str;
        if (str.charAt(0) == 'x')
            return "y" + changeXY(str.substring(1));
        return str.charAt(0) + changeXY(str.substring(1));
    }

    static boolean nestParen(String str) {
        return str.isEmpty() || str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')' && nestParen(str.substring(1, str.length() - 1));

    }

    static String endX(String str) {
        if (str.length() <= 1) return str;
        if (str.charAt(0) == 'x') return endX(str.substring(1)) + "x";
        else return str.charAt(0) + endX(str.substring(1));
    }


}
