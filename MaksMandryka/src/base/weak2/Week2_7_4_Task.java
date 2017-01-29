package base.weak2;

import java.util.Scanner;

import static base.weak2.ArrayUtils.*;

/**
 * Created by Администратор on 17.12.2016.
 * Сдвинуть массив на заданное количество позиций // {1,2,3,4,5} -> 2 = {4,5,1,2,3}; {1,2,3,4,5} -> 3 = {3,4,5,1,2}
 * Количество позиций и массив указывает пользователь
 */
public class Week2_7_4_Task {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int offset = sc.nextInt();


        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }

        array = shiftArray(array, offset);
    }

}


