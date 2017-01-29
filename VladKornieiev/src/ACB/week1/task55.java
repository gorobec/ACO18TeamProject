package ACB.week1;

import java.util.Scanner;

/*
Даны три числа a, b, c. Определить, имеется ли среди них хотя бы одна
пара равных
 */

public class task55 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a, b, c;

        System.out.print("Enter 1st num: ");
        a = sc.nextInt();
        System.out.print("Enter 2nd num: ");
        b = sc.nextInt();
        System.out.print("Enter 3rd num: ");
        c = sc.nextInt();

        boolean result = (a==b) || (a==c) || (c==b) ? true : false;

        System.out.println(result);

    }
}
