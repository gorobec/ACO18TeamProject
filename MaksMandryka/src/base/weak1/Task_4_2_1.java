package base.weak1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Администратор on 09.12.2016.
 * Ввести с клавиатуры значения трех сторон треугольника a, b и c и опреде-
 лить, является ли он прямоугольным. Ответ вывести в виде сообщения.
 */
public class Task_4_2_1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); //Вводится 3 числа через пробел
        int[] input = new int[3];
        input[0] = sc.nextInt();
        input[1] = sc.nextInt();
        input[2] = sc.nextInt();
        Arrays.sort(input);
        sc.close();
        if (Math.pow(input[2],2) == Math.pow(input[0],2)+Math.pow(input[1],2)) {
            System.out.println("Треугольник прямоугольный");
        } else {
            System.out.println("Треугольник не прямоугольный");
        }
    }
}
