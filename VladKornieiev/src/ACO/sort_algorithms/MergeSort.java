package ACO.sort_algorithms;

import java.util.Arrays;

/**
 * Created by v21k on 15.02.17.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,3};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    public static int[] mergeSort(int[] array){
        int n = array.length;
        if (n <= 1){
            return array;
        }

        int midpoint = n / 2;

        int[] a = new int[midpoint];
        int[] b = new  int[n-midpoint];

        System.arraycopy(array,0,a,0,midpoint);
        System.arraycopy(array,midpoint,b,0,n-midpoint);

        a = mergeSort(a);
        b = mergeSort(b);

        return merge(a,b);
    }

    private static int[] merge (int[] a, int[] b){
        int i = 0;
        int j = 0;
        int c = 0;

        int[] result = new int[a.length + b.length];

        while (i<a.length && j < b.length){
            if (a[i] > b[j]){
                result[c] = b[j];
                j++;
                c++;
            } else {
                result[c] = a[i];
                i++;
                c++;
            }
        }

        while (i < a.length){
            result[c] = a[i];
            i++;
            c++;
        }

        while (j < b.length){
            result[c] = b[j];
            j++;
            c++;
        }

        return result;
    }
}
