package base.weak2;

import java.util.Arrays;

import static base.weak2.ArrayUtils.*;

/**
 * Created by Администратор on 18.12.2016.
 * Заданы два массива одинаковой длинны с любыми значениями скопировать данные из первого массива во второй
 */
public class Weak2_4_3_Task_and_Test {

    public static void main(String[] args) {

        int[] array1 = {1, 3, 5, 7, 2, 8, 3, 9, 11, -1, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] array2 = {1000, 3, 5, 7, 2, 8, 3, 9, 11, -1000, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] array3 = {1, 3, 5, 0, 9, 8, 3, 9, 0};
        int[] array4 = {1, 1, 5, 7, 2};
        int[] array5 = {1};

        int[] arrayCopy1 = copyArray(array1);
        int[] arrayCopy2 = copyArray(array2);
        int[] arrayCopy3 = copyArray(array3);
        int[] arrayCopy4 = copyArray(array4);
        int[] arrayCopy5 = copyArray(array5);

        System.out.println("Тест 1: " + Arrays.equals(arrayCopy1, array1));
        System.out.println("Тест 2: " + Arrays.equals(arrayCopy2, array2));
        System.out.println("Тест 3: " + Arrays.equals(arrayCopy3, array3));
        System.out.println("Тест 4: " + Arrays.equals(arrayCopy4, array4));
        System.out.println("Тест 5: " + Arrays.equals(arrayCopy5, array5));

    }
}
