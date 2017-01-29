package base.weak2;

import java.util.Arrays;

import static base.weak2.ArrayUtils.*;

/**
 * Created by Администратор on 18.12.2016.
 * Вывести в консоль элементы той половины одномерного массива у которой среднее арифметическое максимальное
 */
public class Weak2_4_7_Task_and_Test {

    public static void main(String[] args) {

        int[] array1 = {1, 3, 5, 7, 2, 8, 3, 9, 11, -1, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] array2 = {1000, 3, 5, 7, 2, 8, 3, 9, 11, -1000, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] array3 = {1, 3, 5, 0, 9, 8, 3, 9};
        int[] array4 = {1, 1, 5, 7, 2};
        int[] array5 = {1};


        int[] arrExp1 = {-1, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] arrExp2 = {1000, 3, 5, 7, 2, 8, 3, 9, 11, -1000};
        int[] arrExp3 = {9, 8, 3, 9};
        int[] arrExp4 = {5, 7, 2};
        int[] arrExp5 = {1};

        int[] maxHalfArray1 = maxHalfArray(array1);
        int[] maxHalfArray2 = maxHalfArray(array2);
        int[] maxHalfArray3 = maxHalfArray(array3);
        int[] maxHalfArray4 = maxHalfArray(array4);
        int[] maxHalfArray5 = maxHalfArray(array5);

        System.out.println("Тест 1: " + Arrays.equals(maxHalfArray1, arrExp1));
        System.out.println("Тест 2: " + Arrays.equals(maxHalfArray2, arrExp2));
        System.out.println("Тест 3: " + Arrays.equals(maxHalfArray3, arrExp3));
        System.out.println("Тест 4: " + Arrays.equals(maxHalfArray4, arrExp4));
        System.out.println("Тест 5: " + Arrays.equals(maxHalfArray5, arrExp5));

        printArray(maxHalfArray1);
        printArray(maxHalfArray2);
        printArray(maxHalfArray3);
        printArray(maxHalfArray4);
        printArray(maxHalfArray5);

    }
}
