package ACB.week2;

/*
Инвертировать массив (без использования допольнительного массива)
 */

import static ACB.week2.ArrayUtils.printArr;

public class task71 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 6, 10, 15};
        int midpoint = arr.length/2;
        int temp;

        for (int i = 0; i < midpoint; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
        printArr(arr);
    }



}
