package ACB.week2;

import static ACB.week2.ArrayUtils.generateMas;
import static ACB.week2.ArrayUtils.printArr;

/*
public static int[] splitArray(int[] arr, int start, int end)
{ // обрезать массив по границам start и end}
*/

public class task410 {
    public static void main(String[] args) {
        int[] arr1 = generateMas(10, 25);
        int[] arr2 = splitArray(arr1, 0, 5);

        // check
        printArr(arr1);
        printArr(arr2);
    }

    public static int[] splitArray (int[] arr, int start, int end){
        int[] outputArray = new int[end-start];

        for (int i = 0; i < end-start; i++) {
            outputArray[i] = arr[start+i];
        }
        return outputArray;
    }
}
