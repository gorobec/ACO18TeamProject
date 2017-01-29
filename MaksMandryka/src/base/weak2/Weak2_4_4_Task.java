package base.weak2;

import java.util.Scanner;

import static base.weak2.ArrayUtils.*;
import static base.weak2.StringUtils.*;

/**
 * Created by Администратор on 18.12.2016.
 * Посчитать сколько цифр(цифра задается пользователем) в массиве
 */
public class Weak2_4_4_Task {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int count;
        String str = "";

        int[] array = {156757, 23465573, 87667565, 1233454, 9954643, 764523, 57734576, 909678675, 1456757, 23434343, 1236454128};

        str = intArrayToString(array);

        count = countString(str, String.valueOf(num)); //считает сколько раз заданная пользователем цифра попадается в массиве

    }
}
