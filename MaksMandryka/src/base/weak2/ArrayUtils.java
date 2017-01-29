package base.weak2;

/**
 * Created by Администратор on 20.12.2016.
 */
public class ArrayUtils {

    public static int maxInArray(int[] array) {

        int max = array[0];

        for (int i : array) {
            max = max < i ? i : max;
        }

        return max;
    }

    public static int minInArray(int[] array) {

        int min = array[0];

        for (int i : array) {
            min = min > i ? i : min;
        }

        return min;
    }

    //меняет местами только первые попавшиеся максимальный и минимальный элементы
    public static int[] maxMinShift(int[] array) {

        int min = 0, max = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[min] > array[i]) {
                min = i;
            } else if (array[max] < array[i]) {
                max = i;
            }
        }

        int buffer = array[max];
        array[max] = array[min];
        array[min] = buffer;

        return array;
    }

    public static int[] copyArray(int[] arraySource) {

        int[] arrayRecipient = new int[arraySource.length];

        for (int i = 0; i < arraySource.length; i++) {
            arrayRecipient[i] = arraySource[i];
        }

        return arrayRecipient;
    }

    public static String intArrayToString(int[] array) {

        String str = "";

        for (int i : array) {
            str += i;
        }

        return str;
    }

    public static int[] evenOddRandom(int size, int from, int to) {

        int[] array = new int[size];

        to -= 1; //Поправка, чтобы значения не вышли за границы диапазона

        for (int i = 0; i < size; i++) {

            array[i] = (int) (Math.random() * (to - from) + from);

            array[i] += (i % 2 == 0 & array[i] % 2 == 1) ? 1 : (i % 2 == 1 & array[i] % 2 == 0) ? 1 : 0;

        }

        return array;
    }

    public static double mean(int[] array) {

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum / array.length;
    }

    public static int[] maxHalfArray(int[] array) {

        // Если к-во єлементов в массиве нечётное, то центральный єлемент попадает в оба массива
        int[] arr1 = splitArray(array, 0, (array.length - 1) / 2);
        int[] arr2 = splitArray(array, array.length / 2, array.length - 1);

        double mean1 = mean(arr1);
        double mean2 = mean(arr2);

        if (mean1 > mean2) {
            return arr1;
        } else {
            return arr2;
        }

    }

    public static void printArray(int[] array) {

        for (int i = 1; i <= array.length; i++) {
            System.out.print(array[i - 1] + ", ");
        }

        System.out.println();

    }

    public static void concatPrint(int[] arr1, int[] arr2) {

        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i] + arr2[i] + "");
        }
    }

    public static void fillRandomRange(int[] arr, int from, int to) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (to - from) + from);
        }
    }

    public static int evenCount(int[] arr) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count += 1;
            }
        }

        return count;
    }

    public static int[] splitArray(int[] arr, int start, int end) {
        int[] arr2 = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            arr2[i - start] = arr[i];
        }
        return arr2;
    }

    public static int[] arrayInvert(int[] array) {

        int buffer;

        for (int i = 0; i <= (array.length - 1) / 2; i++) {
            buffer = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = buffer;
        }

        return array;
    }

    public static int[] relocateArrayElements(int[] array, int[] indicesArray) {

        int[] arrayCopy = copyArray(array);

        for (int i = 0; i < array.length; i++) {
            array[i] = arrayCopy[indicesArray[i]];
        }

        return array;
    }


    public static int[] shiftArray(int[] array, int offset) {

        if (offset >= array.length) {
            offset %= array.length;
        }

        int[] arrayInd = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (i - offset < 0) {
                arrayInd[i] = array.length - offset + i;
            } else {
                arrayInd[i] = i - offset;
            }
        }

        array = relocateArrayElements(array, arrayInd);

        return array;

    }

}
