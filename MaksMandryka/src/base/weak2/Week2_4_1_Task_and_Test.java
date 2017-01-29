package base.weak2;

import static base.weak2.ArrayUtils.*;

/**
 * Created by Администратор on 18.12.2016.
 * Найти минимальное и максимальное значения в массиве и вывести их на консоль
 */
public class Week2_4_1_Task_and_Test {
    public static void main(String[] args) {

        int[] array1 = {1, 3, 5, 7, 2, 8, 3, 9, 11, -1, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] array2 = {1000, 3, 5, 7, 2, 8, 3, 9, 11, -1000, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] array3 = {1, 3, 5, 0, 9, 8, 3, 9, 0};
        int[] array4 = {1, 1, 5, 7, 2};
        int[] array5 = {1};

        int maxExp1 = 23;
        int minExp1 = -1;
        int maxExp2 = 1000;
        int minExp2 = -1000;
        int maxExp3 = 9;
        int minExp3 = 0;
        int maxExp4 = 7;
        int minExp4 = 1;
        int maxExp5 = 1;
        int minExp5 = 1;

        int max1 = maxInArray(array1);
        int min1 = minInArray(array1);
        int max2 = maxInArray(array2);
        int min2 = minInArray(array2);
        int max3 = maxInArray(array3);
        int min3 = minInArray(array3);
        int max4 = maxInArray(array4);
        int min4 = minInArray(array4);
        int max5 = maxInArray(array5);
        int min5 = minInArray(array5);

        System.out.print("Тест 1. Минимальное значение в массиве: " + min1 + ". Максимальное значение в массиве: " + max1);
        System.out.println(". Совпадение с ожидаемыми значениями: min " + (min1 == minExp1) + ", max " + (max1 == maxExp1));

        System.out.print("Тест 2. Минимальное значение в массиве: " + min2 + ". Максимальное значение в массиве: " + max2);
        System.out.println(". Совпадение с ожидаемыми значениями: min " + (min2 == minExp2) + ", max " + (max2 == maxExp2));

        System.out.print("Тест 3. Минимальное значение в массиве: " + min3 + ". Максимальное значение в массиве: " + max3);
        System.out.println(". Совпадение с ожидаемыми значениями: min " + (min3 == minExp3) + ", max " + (max3 == maxExp3));

        System.out.print("Тест 4. Минимальное значение в массиве: " + min4 + ". Максимальное значение в массиве: " + max4);
        System.out.println(". Совпадение с ожидаемыми значениями: min " + (min4 == minExp4) + ", max " + (max4 == maxExp4));

        System.out.print("Тест 5. Минимальное значение в массиве: " + min5 + ". Максимальное значение в массиве: " + max5);
        System.out.println(". Совпадение с ожидаемыми значениями: min " + (min5 == minExp5) + ", max " + (max5 == maxExp5));
    }
}
