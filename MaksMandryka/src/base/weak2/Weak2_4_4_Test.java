package base.weak2;

import static base.weak2.ArrayUtils.intArrayToString;
import static base.weak2.StringUtils.countString;

/**
 * Created by Администратор on 18.12.2016.
 * Посчитать сколько цифр(цифра задается пользователем) в массиве
 */
public class Weak2_4_4_Test {

    public static void main(String[] args) {

        int num = 8;

        int[] array1 = {156757, 23465573, 87667565, 1233454, 9954643, 764523, 57734576, 909678675, 1456757, 23434343, 1236454128};
        int[] array2 = {1, 123645412};
        int[] array3 = {764523, 8, 57734576, 909678675, 1456757, 23434343, 1236454128};
        int[] array4 = {-84576, 909678675, -1456757, 23434343, -18888128};
        int[] array5 = {1236454128, -1, -8, -123};
        int[] array6 = {88888888};

        int exp1 = 3;
        int exp2 = 0;
        int exp3 = 3;
        int exp4 = 7;
        int exp5 = 2;
        int exp6 = 8;

        String str1 = intArrayToString(array1);
        String str2 = intArrayToString(array2);
        String str3 = intArrayToString(array3);
        String str4 = intArrayToString(array4);
        String str5 = intArrayToString(array5);
        String str6 = intArrayToString(array6);

        int count1 = countString(str1, String.valueOf(num));
        int count2 = countString(str2, String.valueOf(num));
        int count3 = countString(str3, String.valueOf(num));
        int count4 = countString(str4, String.valueOf(num));
        int count5 = countString(str5, String.valueOf(num));
        int count6 = countString(str6, String.valueOf(num));

        System.out.println("Тест 1: " + (exp1 == count1));
        System.out.println("Тест 2: " + (exp2 == count2));
        System.out.println("Тест 3: " + (exp3 == count3));
        System.out.println("Тест 4: " + (exp4 == count4));
        System.out.println("Тест 5: " + (exp5 == count5));
        System.out.println("Тест 6: " + (exp6 == count6));

    }
}
