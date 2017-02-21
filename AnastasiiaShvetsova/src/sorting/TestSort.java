package sorting;

import java.util.Arrays;

/**
 * Created by anastasiia.shvetsova on 2/21/2017.
 */
public class TestSort {
    public static void main(String[] args) {
        MergeSortArray el1 = new MergeSortArray();

        int[] array = {20, 1, 5, 6, 7, 90, 15};
        System.out.println(Arrays.toString(el1.sortArray(array)));
    }
}
