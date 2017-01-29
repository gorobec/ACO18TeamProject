package ACB.week1;

import java.util.Scanner;

/*
4.7. Вводим два числа,
если одно из них делиться на другое без остатка,
то выводим тру и показываем результат деления
(целую часть от деления  и остачу)
в другом случае выводим false и показываем результат деления
(целую часть от деления  и остачу)
 */
public class task47 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1st num: ");
        int a  = sc.nextInt();
        System.out.print("Enter 2nd num: ");
        int b = sc.nextInt();

        if ((a % b == 0) || (b % a == 0)) {
            System.out.println("True: " + a/b + ", " + a%b);
        } else {
            System.out.println("False: " + a/b + ", "+ a%b);
        }
    }
}
