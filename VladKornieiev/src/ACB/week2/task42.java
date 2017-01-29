package ACB.week2;

/*
2) Поменять местами наибольший
и наименьший элементы в массиве
*/

import static ACB.week2.ArrayUtils.generateMas;
import static ACB.week2.ArrayUtils.printArr;

public class task42 {
    public static void main(String[] args) {

        // generate mass
        int size = 5;
        int range = 10;
        int[] arr = generateMas(size, range);

        // finding indexes
        int min = arr[0];
        int max = arr[0];
        int maxIndex = 25;
        int minIndex = 25;

        for (int i = 0; i < arr.length-1 ; i++) {
            max = (arr[i] > max) ? arr[i] : max;
            maxIndex = (arr[i] == max) ?  i : maxIndex;

            min = (arr[i] < min) ? arr[i] : min;
            minIndex = (arr[i] == min) ? i : minIndex;
        }

        // check what's going now
        printArr(arr);

        // swap
        int temp = arr[minIndex];
        arr[minIndex] = arr[maxIndex];
        arr[maxIndex] = temp;

        // print indexes and edited array
        System.out.println(maxIndex + ", " + minIndex);
        printArr(arr);
    }
}
