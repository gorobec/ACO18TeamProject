package base.weak2;

import java.util.Arrays;
import java.util.Scanner;

import static base.weak2.ArrayUtils.shiftArray;

/**
 * Created by Администратор on 17.12.2016.
 * Сдвинуть массив на заданное количество позиций // {1,2,3,4,5} -> 2 = {4,5,1,2,3}; {1,2,3,4,5} -> 3 = {3,4,5,1,2}
 * Количество позиций и массив указывает пользователь
 */
public class Week2_7_4_Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = 10;
        int offset1 = 0;
        int offset2 = 1;
        int offset3 = 3;
        int offset4 = 5;
        int offset5 = 7;
        int offset6 = 10;
        int offset7 = 15;

        int[] array1 = new int[size];
        int[] array2 = new int[size];
        int[] array3 = new int[size];
        int[] array4 = new int[size];
        int[] array5 = new int[size];
        int[] array6 = new int[size];
        int[] array7 = new int[size];

        for (int i = 0; i < size; i++) {
            array1[i] = i + 1;
            array2[i] = i + 1;
            array3[i] = i + 1;
            array4[i] = i + 1;
            array5[i] = i + 1;
            array6[i] = i + 1;
            array7[i] = i + 1;
        }

        int[] arrExp1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arrExp2 = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arrExp3 = {8, 9, 10, 1, 2, 3, 4, 5, 6, 7};
        int[] arrExp4 = {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};
        int[] arrExp5 = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int[] arrExp6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arrExp7 = {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};

        System.out.println("Тест 1: " + Arrays.equals(arrExp1, shiftArray(array1, offset1)));
        System.out.println("Тест 2: " + Arrays.equals(arrExp2, shiftArray(array2, offset2)));
        System.out.println("Тест 3: " + Arrays.equals(arrExp3, shiftArray(array3, offset3)));
        System.out.println("Тест 4: " + Arrays.equals(arrExp4, shiftArray(array4, offset4)));
        System.out.println("Тест 5: " + Arrays.equals(arrExp5, shiftArray(array5, offset5)));
        System.out.println("Тест 6: " + Arrays.equals(arrExp6, shiftArray(array6, offset6)));
        System.out.println("Тест 7: " + Arrays.equals(arrExp7, shiftArray(array7, offset7)));

    }

}


