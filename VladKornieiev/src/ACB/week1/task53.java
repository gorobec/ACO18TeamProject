package ACB.week1;

import java.util.Scanner;

/*
3) Дано трехзначное число. Определить:
а) верно ли, что все его цифры
одинаковые;
б) есть ли среди его цифр одинаковые.
*/

public class task53 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 3-digits number: ");
        int a = sc.nextInt();
        int first = a % 10;
        a /= 10;
        int second = a % 10;
        int third = a / 10;

        if (first == second && first == third) {
            System.out.println("All three the same");
        } else if (first == second || first == third || second == third) {
            System.out.println("2 same numbers");
        }
    }
}