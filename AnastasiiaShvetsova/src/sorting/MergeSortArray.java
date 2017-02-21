package sorting;

import java.util.Arrays;

/**
 * Created by anastasiia.shvetsova on 2/21/2017.
 */
public class MergeSortArray {

    public int[] sortArray(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int middle = array.length / 2;
        int[] array1 = Arrays.copyOfRange(array, 0, middle);
        int[] array2 = Arrays.copyOfRange(array, middle, array.length);
        return merge(sortArray(array1), sortArray(array2));
    }

    public int[] merge(int[] array1, int[] array2) {
        int i = 0;
        int j = 0;
        int resultCount = 0;
        int[] result = new int[array1.length + array2.length];
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                result[resultCount] = array1[i];
                resultCount++;
                i++;
            } else {
                result[resultCount] = array2[j];
                resultCount++;
                j++;
            }

        }
        while (i < array1.length) {
            result[resultCount] = array1[i];
            resultCount++;
            i++;
        }
        while (j < array2.length) {
            result[resultCount] = array2[j];
            resultCount++;
            j++;
        }
        return result;
    }
}
