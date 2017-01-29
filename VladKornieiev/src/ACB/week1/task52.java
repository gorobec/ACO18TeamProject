package ACB.week1;

import java.util.Scanner;

/*
2) Ввести с клавиатуры три числа,
положительные возвести в куб, а отрица-
тельные заменить на 0.
*/

public class task52 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double a, b, c;
        System.out.print("Enter 1st num: ");
        a = sc.nextDouble();
        a = a > 0 ? Math.pow(a, 3) : 0;
        System.out.print("Enter 2nd num: ");
        b = sc.nextDouble();
        b = b > 0 ? Math.pow(b, 3) : 0;
        System.out.print("Enter 3rd num: ");
        c = sc.nextDouble();
        c = c > 0 ? Math.pow(c, 3) : 0;

        System.out.println("a: " + a + "; b: " + b + "; c: " + c);

    }
}
