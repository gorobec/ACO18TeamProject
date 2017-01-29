package base.weak1;

import java.util.Scanner;

/**
 * Created by Администратор on 09.12.2016.
 * Вводим число с плавающей точкой с консоли, и проверяем лежит ли оно в диапазоне от 0 до 1
 */
public class Task_4_1_4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        double input = sc.nextDouble();
        if (input>=0 && input <=1) {
            System.out.println("В диапазоне от 0 до 1 включительно");
        }
        sc.close();
    }
}
