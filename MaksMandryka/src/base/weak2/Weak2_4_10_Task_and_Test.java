package base.weak2;

import java.util.Arrays;

import static base.weak2.ArrayUtils.*;

/**
 * Created by Администратор on 18.12.2016.
 * public static int[] splitArray(int[] arr, int start, int end) { // обрезать массив по границам start и end
 * }
 */
public class Weak2_4_10_Task_and_Test {

    public static void main(String[] args) {

        int[] arr1 = {1, 3, 5, 7, 2, 8, 3, 9, 11, -1, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] arr2 = {1, 3, 5, 7, 2, 8, 3, 9, 11, -1, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] arr3 = {1, 3, 5, 7, 2, 8, 3, 9, 11, -1, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] arr4 = {1, 3, 5, 7, 2, 8, 3, 9, 11, -1, 5, 2, 8, 3, 21, 3, 5, 23, 8};

        int start1 = 3;
        int end1 = 17;
        int start2 = 0;
        int end2 = 18;
        int start3 = 0;
        int end3 = 0;
        int start4 = 18;
        int end4 = 18;

        int[] arrExp1 = {7, 2, 8, 3, 9, 11, -1, 5, 2, 8, 3, 21, 3, 5, 23};
        int[] arrExp2 = {1, 3, 5, 7, 2, 8, 3, 9, 11, -1, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] arrExp3 = {1};
        int[] arrExp4 = {8};

        arr1 = splitArray(arr1, start1, end1);
        arr2 = splitArray(arr2, start2, end2);
        arr3 = splitArray(arr3, start3, end3);
        arr4 = splitArray(arr4, start4, end4);

        System.out.println("Тест 1: " + Arrays.equals(arrExp1, arr1));
        System.out.println("Тест 2: " + Arrays.equals(arrExp2, arr2));
        System.out.println("Тест 3: " + Arrays.equals(arrExp3, arr3));
        System.out.println("Тест 4: " + Arrays.equals(arrExp4, arr4));

    }

}
