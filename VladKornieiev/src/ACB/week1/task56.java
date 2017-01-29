package ACB.week1;

import java.util.Scanner;

/*
Ввести с экрана число от 1 до 12. По номеру месяца выдать сообщение о
времени года. Если пользователь введет недопустимое число, программа
должна выдать сообщение об ошибке.
 */

public class task56 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month number : ");
        int month = sc.nextInt();

        if (month == 12 || month == 1 || month == 2) {
            System.out.println("It's winter.");
        } else if (month >= 3 && month <= 5) {
            System.out.println("It's spring.");
        } else if (month >= 6 && month <= 8) {
            System.out.println("Its summer.");
        } else if (month >= 9 && month <= 11) {
            System.out.println("It's autumn.");
        } else {
            System.out.println("Wrong number.");
        }

    }
}
