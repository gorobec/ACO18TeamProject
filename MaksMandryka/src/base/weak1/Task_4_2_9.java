package base.weak1;

import java.util.Scanner;

/**
 * Created by Администратор on 09.12.2016.
 * Написать программу вычисления идеального веса пользователя (рост-
 100). Выдать рекомендации о необходимости поправиться либо поху-
 деть.
 */
public class Task_4_2_9 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        double H = sc.nextDouble();
        double W = sc.nextDouble();

        if (W>H-100) {
            System.out.println("Вам желательно похудеть на " + (W-H+100) + " кг");
        } else if (W<H-100){
            System.out.println("Вам желательно поправиться на " + (H-100-W)+ " кг");
        } else {
            System.out.println("Поздравляем! У вас идеальный вес");
        }
        sc.close();
    }
}
