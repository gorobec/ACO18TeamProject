package base.weak1;

import java.util.Scanner;

/**
 * Created by Администратор on 09.12.2016.
 * Вводим два числа, сравнить последнии цифры этих чисел (пользоваться оператором %)
 */
public class Task_4_1_8 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int F1 = sc.nextInt();
        int F2 = sc.nextInt();
        if (F1%10 == F2%10) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        sc.close();
    }
}
