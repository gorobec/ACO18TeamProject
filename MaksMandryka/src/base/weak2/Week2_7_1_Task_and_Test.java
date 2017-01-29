package base.weak2;

import java.util.Arrays;

import static base.weak2.ArrayUtils.*;

/**
 * Created by Администратор on 12.12.2016.
 * Инвертировать массив (без использования допольнительного массива)
 */
public class Week2_7_1_Task_and_Test {

    public static void main(String[] args) {

        int[] array1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] array2 = {1, 3, 5, 7, 2, 8, 3, 9, 11, -1, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] array3 = {1, 1, 5, 7, 2};
        int[] array4 = {1};

        int[] arrExp1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] arrExp2 = {8, 23, 5, 3, 21, 3, 8, 2, 5, -1, 11, 9, 3, 8, 2, 7, 5, 3, 1};
        int[] arrExp3 = {2, 7, 5, 1, 1};
        int[] arrExp4 = {1};

        int[] arrInv1 = arrayInvert(array1);
        int[] arrInv2 = arrayInvert(array2);
        int[] arrInv3 = arrayInvert(array3);
        int[] arrInv4 = arrayInvert(array4);

        System.out.println("Тест 1: " + Arrays.equals(arrInv1, arrExp1));
        System.out.println("Тест 2: " + Arrays.equals(arrInv2, arrExp2));
        System.out.println("Тест 3: " + Arrays.equals(arrInv3, arrExp3));
        System.out.println("Тест 4: " + Arrays.equals(arrInv4, arrExp4));

    }
}
