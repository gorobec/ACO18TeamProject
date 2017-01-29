package base.weak2;

import static base.weak2.ArrayUtils.*;

/**
 * Created by Администратор on 18.12.2016.
 * Найти среднее арифметическое массива
 */
public class Weak2_4_6_Task_and_Test {

    public static void main(String[] args) {

        int[] array1 = {1, 3, 5, 7, 2, 8, 3, 9, 11, -1, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] array2 = {1000, 3, 5, 7, 2, 8, 3, 9, 11, -1000, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] array3 = {1, 3, 5, 0, 9, 8, 3, 9, 0};
        int[] array4 = {1, 1, 5, 7, 2};
        int[] array5 = {1};

        double meanExp1 = 126 / 19;
        double meanExp2 = 126 / 19;
        double meanExp3 = 37 / 9;
        double meanExp4 = 16 / 5;
        double meanExp5 = 1;

        System.out.println("Тест 1: " + (meanExp1 == mean(array1)));
        System.out.println("Тест 2: " + (meanExp2 == mean(array2)));
        System.out.println("Тест 3: " + (meanExp3 == mean(array3)));
        System.out.println("Тест 4: " + (meanExp4 == mean(array4)));
        System.out.println("Тест 5: " + (meanExp5 == mean(array5)));


    }
}
