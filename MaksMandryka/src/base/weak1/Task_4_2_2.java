package base.weak1;

import java.util.Scanner;

/**
 * Created by Администратор on 09.12.2016.
 * Ввести с клавиатуры три числа, положительные возвести в куб, а отрица-
 тельные заменить на 0.
 */
public class Task_4_2_2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); //Вводится 3 числа через пробел
        int[] input = new int[3];
        input[0] = sc.nextInt();
        input[1] = sc.nextInt();
        input[2] = sc.nextInt();
        sc.close();
        for (int F:input) {
            if (F > 0) {
                System.out.println(Math.pow(F,3));
            } else {
                System.out.println(0);
            }
        }
    }
}
