package ACB.week2;

import static ACB.week2.ArrayUtils.generateMas;
import static ACB.week2.ArrayUtils.printArr;

/*
Сдвинуть массив на заданное количество позиций
// {1,2,3,4,5} -> 2 = {4,5,1,2,3}; {1,2,3,4,5} -> 3 = {3,4,5,1,2}
Количество позиций и массив указывает пользователь
 */
public class task74 {
    public static void main(String[] args) {
        int[] arr = generateMas(5, 10);
        int shift = 4;

        int[] finalArr = new int[arr.length];

        // saving last <shift> elements in new arr
        for (int i = 0; i < shift ; i++) {
            finalArr[i] = arr[arr.length - shift + i];
        }
        // adding from 0 to length-<shift> elements
        for (int i = shift; i < arr.length; i++) {
            finalArr[i] = arr[i-shift];
        }

        printArr(arr);
        printArr(finalArr);
    }
}
