package base.weak1;

import java.util.Scanner;

/**
 * Created by Maks on 09.12.2016.
 * Пользователь вводит параметр с консоли (текущий час от 0 до 24)
 Если время от 9 до 18, то выводим "Я на работе", в другом случае "Я отдыхаю")
 */
public class Task_4_1_1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();

        if (hour >= 9 && hour <= 18) {
            System.out.println("Я на работе");
        } else {
            System.out.println("Я отдыхаю");
        }
        sc.close();
    }
}
