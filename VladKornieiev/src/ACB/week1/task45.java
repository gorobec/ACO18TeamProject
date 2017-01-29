package ACB.week1;

import java.util.Scanner;

/*
 4.5. Вводим 2 числа. Если первое число больше второго,
 то вывести на экран разницу чисел. Если второе больше, то выводим сумму.
 */

public class task45 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1st num: ");
        int a = sc.nextInt();
        System.out.print("Enter 2nd num: ");
        int b = sc.nextInt();

        int result = a > b ? (a-b) : (a+b);

        System.out.println(result);
    }
}
