package ACB.week2;

import static ACB.week2.ArrayUtils.generateMas;
import static ACB.week2.ArrayUtils.printArr;

/*
Заданы два массива одинаковой длинны
c любыми значениями скопировать данные
из первого массива во второй
*/
public class task43 {
    public static void main(String[] args) {
        int[] arr1 = generateMas(10, 100);
        int[] arr2 = generateMas(10, 250);

        // check if they are different
        printArr(arr1);
        printArr(arr2);

        for (int i = 0; i < arr1.length ; i++) {
            arr2[i]=arr1[i];
        }

        // check
        printArr(arr1);
        printArr(arr2);
    }
}
