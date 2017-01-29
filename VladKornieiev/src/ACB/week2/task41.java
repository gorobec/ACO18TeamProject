package ACB.week2;

import static ACB.week2.ArrayUtils.*;

/*
Найти минимальное и максимальное значения в массиве и вывести их на консоль
*/

public class task41 {

    public static void main(String[] args) {
        int size = 10;
        int range = 100;
        int[] arr = generateMas(size, range);

        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length ; i++) {
            max = (arr[i] > max) ? arr[i] : max;
            min = (arr[i] < min) ? arr[i] : min;
        }

        System.out.println(min + ", " + max);
    }
}
