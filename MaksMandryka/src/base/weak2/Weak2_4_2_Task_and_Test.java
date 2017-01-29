package base.weak2;

import java.util.Arrays;

import static base.weak2.ArrayUtils.*;

/**
 * Created by Администратор on 18.12.2016.
 * Поменять местами наибольший
 * и наименьший элементы в массиве
 */
public class Weak2_4_2_Task_and_Test {

    public static void main(String[] args) {

        int[] array1 = {1, 3, 5, 7, 2, 8, 3, 9, 11, -1, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] array2 = {1000, 3, 5, 7, 2, 8, 3, 9, 11, -1000, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] array3 = {1, 3, 5, 0, 9, 8, 3, 9, 0};
        int[] array4 = {1, 1, 5, 7, 2};
        int[] array5 = {1};

        int[] arrayExp1 = {1, 3, 5, 7, 2, 8, 3, 9, 11, 23, 5, 2, 8, 3, 21, 3, 5, -1, 8};
        int[] arrayExp2 = {-1000, 3, 5, 7, 2, 8, 3, 9, 11, 1000, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] arrayExp3 = {1, 3, 5, 9, 0, 8, 3, 9, 0}; //меняет местами только первые попавшиеся максимальный и минимальный элементы
        int[] arrayExp4 = {7, 1, 5, 1, 2}; //меняет местами только первые попавшиеся максимальный и минимальный элементы
        int[] arrayExp5 = {1};

        System.out.println("Тест 1: " + Arrays.equals(arrayExp1, maxMinShift(array1)));
        System.out.println("Тест 2: " + Arrays.equals(arrayExp2, maxMinShift(array2)));
        System.out.println("Тест 3: " + Arrays.equals(arrayExp3, maxMinShift(array3)));
        System.out.println("Тест 4: " + Arrays.equals(arrayExp4, maxMinShift(array4)));
        System.out.println("Тест 5: " + Arrays.equals(arrayExp5, maxMinShift(array5)));

    }
}
