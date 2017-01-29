package ACB.week1;

import java.util.Scanner;

/*
4.4. Вводим число с плавающей точкой с консоли,
и проверяем лежит ли оно в диапазоне от 0 до 1
*/
public class task44 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        double num = sc.nextDouble();
        if (num >= 0 && num <= 1) {
            System.out.println("True");
            return;
        }
        System.out.println("False");

    }
}
