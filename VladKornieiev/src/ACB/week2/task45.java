package ACB.week2;

import static ACB.week2.ArrayUtils.printArr;

/*
Заполнить массив случайными значениями.
На четных индексах парные значения, на нечетных непарные
*/
public class task45 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int range = 250;

        for (int i = 0; i < arr.length ; i++) {
            int randint = randomNumber(range);
            arr[i] = (i % 2 == 0) ?
                    ((randint % 2 == 0) ? randint : randint + 1): // if true
                    ((randint % 2 != 0) ? randint : randint + 1); // if false
        }
        printArr(arr);
    }

    public static int randomNumber(int a) {
        return (int) (Math.random() * a);
    }
}
