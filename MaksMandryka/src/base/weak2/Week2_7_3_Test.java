package base.weak2;

import static base.weak2.StringUtils.countString;

/**
 * Created by Администратор on 17.12.2016.
 * Посчитать колличество букв 'a' в строке (искомый символ может быть разным)
 */
public class Week2_7_3_Test {

    public static void main(String[] args) {

        String someString1 = "fkljgjasdwqdlkadalkjdajaklsdklasa";
        String someString2 = "12345568945fcghjgwae   rtertg ew rtew";
        String someString3 = "";
        String someString4 = "aaaaaaa";
        String someString5 = "AAAAaaa";
        String someString6 = "__";
        String someString7 = "&/";

        char toFind1 = 'a';
        char toFind2 = '5';
        char toFind3 = 'a';
        char toFind4 = 'a';
        char toFind5 = 'a';
        char toFind6 = '_';
        char toFind7 = '&';

        int exp1 = 7;
        int exp2 = 3;
        int exp3 = 0;
        int exp4 = 7;
        int exp5 = 3;
        int exp6 = 2;
        int exp7 = 1;

        System.out.println("Тест 1: " + (exp1 == countString(someString1, toFind1)));
        System.out.println("Тест 2: " + (exp2 == countString(someString2, toFind2)));
        System.out.println("Тест 3: " + (exp3 == countString(someString3, toFind3)));
        System.out.println("Тест 4: " + (exp4 == countString(someString4, toFind4)));
        System.out.println("Тест 5: " + (exp5 == countString(someString5, toFind5)));
        System.out.println("Тест 6: " + (exp6 == countString(someString6, toFind6)));
        System.out.println("Тест 7: " + (exp7 == countString(someString7, toFind7)));

    }
}
