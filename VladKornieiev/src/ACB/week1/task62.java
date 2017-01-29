package ACB.week1;

import java.util.Scanner;

/*
Вычислить факториал числа
 */

public class task62 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int a = sc.nextInt();
        int result = 1;

        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        System.out.println(result);
    }
}
