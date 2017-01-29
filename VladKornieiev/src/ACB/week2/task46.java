package ACB.week2;

import static ACB.week2.ArrayUtils.generateMas;

/*
Найти среднее арифметическое массива
*/
public class task46 {
    public static void main(String[] args) {
        int[] arr = generateMas(100, 100);

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println("Avg is: " + sum/arr.length);

    }
}
