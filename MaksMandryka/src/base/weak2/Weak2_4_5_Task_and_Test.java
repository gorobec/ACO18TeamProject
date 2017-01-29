package base.weak2;

import static base.weak2.ArrayUtils.*;
import static base.weak2.ArrayUtils.evenOddRandom;

/**
 * Created by Администратор on 18.12.2016.
 * Заполнить массив случайными значениями. На четных индексах парные значения, на нечетных непарные
 */
public class Weak2_4_5_Task_and_Test {

    public static void main(String[] args) {

        int from1 = 20;
        int to1 = 250;
        int from2 = 10;
        int to2 = 15;

        int[] array1 = evenOddRandom(10, from1, to1);
        int[] array2 = evenOddRandom(10, from2, to2);

        //Проверка чётности, нечётности значений в массиве
        for (int i = 0; i < array1.length; i++) {
            if ((i % 2 == 0 & array1[i] % 2 != 0) | (i % 2 != 0 & array1[i] % 2 == 0)) {
                System.out.println("Error in array even-odd balance!");
            }
        }

        //Проверка лимитов максимального и минимального значений в массиве
        if (to1 < maxInArray(array1) || from1 > minInArray(array1)) {
            System.out.println("Error in array max or min limits");
        }

        for (int i = 0; i < array2.length; i++) {
            if ((i % 2 == 0 & array2[i] % 2 != 0) | (i % 2 != 0 & array2[i] % 2 == 0)) {
                System.out.println("Error in array even-odd balance!");
            }
        }

        if (to2 < maxInArray(array2) || from2 > minInArray(array2)) {
            System.out.println("Error in array max or min limits");
        }

    }
}
