package ACB.week1;

import java.util.Scanner;

/*
4.8. Вводим два числа, сравнить последнии цифры этих чисел
(пользоваться оператором %)
			124    4    -   true
			1456   567  -   false
			1      2    -   false
			18     98   -   true
*/

public class task48 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1st num: ");
        int a = sc.nextInt();
        System.out.print("Enter 2nd num: ");
        int b = sc.nextInt();

        if ((a % 10) == (b % 10)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
