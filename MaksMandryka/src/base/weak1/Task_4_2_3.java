package base.weak1;

import java.util.Scanner;

/**
 * Created by Администратор on 09.12.2016.
 * Дано трехзначное число. Определить: а) верно ли, что все его цифры
 одинаковые; б) есть ли среди его цифр одинаковые.
 */
public class Task_4_2_3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); //Вводится 3 числа через пробел
        int input = sc.nextInt();
        int F1 = input/100;
        int F2 = input/10%10;
        int F3 = input%10;
        if (F1==F2 & F1==F3) {
            System.out.println("Все три числа одинаковые");
        } else if (F1==F2 || F1==F3 || F2==F3) {
            System.out.println("Среди цифр есть одинаковые");
        } else {
            System.out.println("Среди цифр одинаковых не обнаружено");
        }

    }
}
