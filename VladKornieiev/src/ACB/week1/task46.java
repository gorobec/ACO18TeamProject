package ACB.week1;

import java.util.Scanner;

/*
4.6. Вводим два числа, вывести их суму,
если она в диапазоне от 11 до 19.
 */
public class task46 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1st num: ");
        int a = sc.nextInt();
        System.out.print("Enter 2nd num: ");
        int b = sc.nextInt();

        if ((a+b) >= 11 && (a+b) <= 19) {
            System.out.println(a+b);
        }

    }
}
