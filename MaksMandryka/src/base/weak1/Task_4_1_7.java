package base.weak1;

import java.util.Scanner;

/**
 * Created by Администратор on 09.12.2016.
 * Вводим два числа, если одно из них делиться на другое без остатка,
 * то выводим тру и показываем результат деления (целую часть от деления  и остачу)
 в другом случае выводим false и показываем результат деления (целую часть от деления  и остачу)
 */
public class Task_4_1_7 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int F1 = sc.nextInt();
        int F2 = sc.nextInt();
        if (F1%F2 == 0) {
            System.out.println(true + " Целая часть от деления " + F1/F2 + ", остаток " + F1%F2);
        } else {
            System.out.println(false + " Целая часть от деления " + F1/F2 + ", остаток " + F1%F2);
        }
        sc.close();
    }
}
