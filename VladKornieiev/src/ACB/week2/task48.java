package ACB.week2;

import static ACB.week2.ArrayUtils.generateMas;

/*Eсть два массива одинаковой длины arr1 и arr2 вывести
в консоль значения массива,
который получается в результате суммы arr1[i] + arr2[i]
*/
public class task48 {
    public static void main(String[] args) {
        int[] arr1 = generateMas(25, 100);
        int[] arr2 = generateMas(25, 100);

        int sum = 0;

        for (int i = 0; i < arr1.length ; i++) {
            sum += arr1[i] + arr2[i];
        }

        System.out.println(sum);
    }
}
