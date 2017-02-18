package ACO.sort_algorithms;

import java.util.Arrays;

/**
 * Created by v21k on 15.02.17.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {5,1,6,9,2};
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int low, int high) {
        int index = partition(array,low,high);
        if (low < index-1){
            quickSort(array,low, index-1);
        }
        if (index < high){
            quickSort(array,index,high);
        }
    }

    private static int partition(int arr[], int left, int right){
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };

        return i;
    }
}
