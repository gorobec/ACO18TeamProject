package week2.day1;

/**
 * Created by serhiim on 28-Jan-17.
 */
public class BinarySearch {


//    private static int compare(int query, int element) {
//        if (query > element) return 1;
//        if (query < element) return -1;
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        int query = 1;
//        int a = compare(query, 2);
//        System.out.println(a);
//
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
//
//
//    }

    public static void main(String[] args) {
        int[] arr = { 1,12,23,34,55,61,67,88,89,101 };
        System.out.println(rank(55, arr));
    }

    public static int rank(int val, int[] arr) {
        return rank(val, arr, 0, arr.length-1);
    }

    private static int rank(int val, int[] arr, int lo, int hi) {
        if (lo > hi) return -1;

        int mid = lo + (hi - lo) / 2;

        if (val < arr[mid]) {
            return rank(val, arr, lo, mid - 1);
        } else if (val > arr[mid]) {
            return rank(val, arr, mid + 1, hi);
        } else {
            return mid;
        }
    }
}
