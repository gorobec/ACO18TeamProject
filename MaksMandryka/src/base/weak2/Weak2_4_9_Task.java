package base.weak2;

import static base.weak2.ArrayUtils.*;

/**
 * Created by Администратор on 18.12.2016.
 * Задать два массива случайными числами от 25 до 75. Определить у какого из массивов больше парных елементов.
 */
public class Weak2_4_9_Task {

    public static void main(String[] args) {

        int[] arr1 = new int[20];
        int[] arr2 = new int[20];

        int diff;

        fillRandomRange(arr1,25,75);
        fillRandomRange(arr2,25,75);

        diff = evenCount(arr1) - evenCount(arr2);

        if (diff > 0) {
            System.out.println("У первого массива больше парных элементов");
        } else if (diff < 0) {
            System.out.println("У второго массива больше парных элементов");
        } else {
            System.out.println("Количество парных элементов в массивах равно");
        }
    }
}
