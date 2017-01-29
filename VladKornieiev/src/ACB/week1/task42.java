package ACB.week1;

import java.util.Scanner;

/*
4.2. Пользователь вводит три числа с консоли,
нужно вывести на консоль наибольшее, наименьшее
*/

public class task42 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st num: ");
        int a = sc.nextInt();
        System.out.println("Enter 2nd num: ");
        int b = sc.nextInt();
        System.out.println("Enter 3rd num: ");
        int c = sc.nextInt();

        int max, min;

        max = max(max(a,b), max(b,c));
        min = min(min(a,b), min(b,c));

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);

    }

    public static int min(int a, int b) {
        return a <= b ? a : b;
    }

    public static int max(int a, int b) {
        return a >= b ? a : b;
    }
}
