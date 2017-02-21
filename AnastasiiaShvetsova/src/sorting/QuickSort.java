package sorting;

import java.util.Arrays;

/**
 * Created by anastasiia.shvetsova on 2/21/2017.
 */
public class QuickSort {
    private int[] array;
    public void sortArray(int[] array) {
        if (array.length == 0) {
            return;
        }
        this.array = array;
        quickSort(0, array.length-1);

    }
    public void swap(int i, int j){
         int tmp = array[i];
         array[i] = array[j];
         array[j] = tmp;
    }
    public void quickSort(int indexBegin, int indexEnd) {

        int i = indexBegin;
        int j = indexEnd;
        int middleElement = array[(i + j) / 2];
        while (i <= j) {
            while (array[i] < middleElement) {
                i++;
            }
            while (array[j] > middleElement) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
            }
        }

        if (indexBegin < j)
            quickSort(indexBegin, j);
        if (i < indexEnd)
            quickSort(i, indexEnd);
    }
}
