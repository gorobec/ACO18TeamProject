package base.weak1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Администратор on 09.12.2016.
 *Пользователь вводит три числа с консоли, нужно вывести на консоль наибольшее, наименьшее
 */
public class Task_4_1_2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); //Вводится 3 числа через пробел
        int[] input = new int[3];
        input[0] = sc.nextInt();
        input[1] = sc.nextInt();
        input[2] = sc.nextInt();
        Arrays.sort(input);
        sc.close();
        System.out.println("Минимальное значение " + input[0]);
        System.out.println("Максимальное значение " + input[2]);
    }
}
