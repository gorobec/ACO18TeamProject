package base.weak1;

import java.util.Scanner;

/**
 * Created by Администратор on 09.12.2016.
 * Вводим два числа, вывести их суму, если она в диапазоне от 11 до 19.
 */
public class Task_4_1_6 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int F1 = sc.nextInt();
        int F2 = sc.nextInt();
        if (F1+F2>=11 && F1+F2 <=19) {
            System.out.println(F1+F2);
        }
        sc.close();
    }
}
