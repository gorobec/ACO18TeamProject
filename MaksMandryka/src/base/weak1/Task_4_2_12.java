package base.weak1;

import java.util.Scanner;

/**
 * Created by Администратор on 09.12.2016.
 * Написать программу, которая в зависимости от характера ветра выдает
 сообщение о его скорости от 1до 4 м/с - слабый (1); от 5-10 м/c -
 умеренный (2); от 9-18 м/c - сильный (3); больше 19 м/c - ураганный (4).
 */
public class Task_4_2_12 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();

        if (V > 19) {
            System.out.println("Ураганный ветер");
        } else if (V > 8){
            System.out.println("Сильный ветер");
        } else if (V > 4){
            System.out.println("Умеренный ветер");
        } else if (V > 0){
            System.out.println("Слабый ветер");
        } else {
            System.out.println("Безветренно");
        }
        sc.close();
    }
}
