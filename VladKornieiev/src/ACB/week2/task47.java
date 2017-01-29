package ACB.week2;

/*
Вывести в консоль элементы той половины одномерного
массива у которой среднее арифметическое максимальное
*/

import static ACB.week2.ArrayUtils.generateMas;
import static ACB.week2.ArrayUtils.printArr;

public class task47 {
    public static void main(String[] args) {
        int[] arr = generateMas(10, 100);

        int midpoint = arr.length / 2;

        int sumleft = 0;
        int sumright = 0;

        //counting sum
        for (int i = 0; i < arr.length; i++) {
            sumleft += (i < midpoint) ? arr[i] : (sumright += arr[i]);
        }

        // print
        if (sumleft / midpoint >= sumright / (arr.length - midpoint)) {
            for (int i = 0; i < midpoint; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            for (int i = midpoint; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
