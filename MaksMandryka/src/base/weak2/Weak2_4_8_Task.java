package base.weak2;

import static base.weak2.ArrayUtils.*;

/**
 * Created by Администратор on 18.12.2016.
 * Eсть два массива одинаковой длины arr1 и arr2 вывести в консоль значения массива,
 * который получается в результате суммы arr1[i] + arr2[i]
 */
public class Weak2_4_8_Task {

    public static void main(String[] args) {

        int[] arr1 = {1, 3, 5, 7, 2, 8, 3, 9, 11, -1, 5, 2, 8, 3, 21, 3, 5, 23, 8};
        int[] arr2 = {23, 21, 1, 3, 1, 54, 2, 1, 7, 2, 1, 1, 8, 7, 25, 4, 5, 1, 0};

        concatPrint(arr1, arr2);

    }
}
