package base.weak1;

import java.util.Scanner;

/**
 * Created by Администратор on 10.12.2016.
 * Посчитать сколько раз встречается символ 8 в заданном числе, которое вводит юзер
 */
public class Task_5_3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long Num = sc.nextLong();
        int counter = 0;
        while (Num > 0) {
            if (Num % 10 == 8) {
                counter++;
            }
            Num /= 10;
        }
        System.out.println(counter);
    }
}
