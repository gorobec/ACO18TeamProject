package base.weak1;

import java.util.Scanner;

/**
 * Created by Администратор on 09.12.2016.
 * Вводим 2 числа. Если первое число больше второго, то вывести на экран разницу чисел.
 * Если второе больше, то выводим сумму.
 */
public class Task_4_1_5 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int F1 = sc.nextInt();
        int F2 = sc.nextInt();

        if (F1 > F2) {
            System.out.println(F1-F2);
        } else if (F1 < F2){
            System.out.println(F1+F2);
        }
        sc.close();
    }
}
