package base.weak2;

/**
 * Created by Администратор on 20.12.2016.
 */
public class StringUtils {

    public static int countString(String str, String toFind) {

        int count = 0;
        char[] arrChar = str.toCharArray();

        for (char i : arrChar) {
            if (i == toFind.charAt(0)) {
                count += 1;
            }
        }
        return count;
    }

    public static int countString(String str, char toFind) {

        int counter = 0;
        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            if (c == toFind) {
                counter += 1;
            }
        }
        return counter;
    }


    public static int countCode(String str) {

        int count = 0;
        char[] arrChar = str.toCharArray();

        for (int i = 0; i < arrChar.length - 1; i++) {
            if (arrChar.length - i >= 4 && arrChar[i] == 'c' && arrChar[i + 1] == 'o' && arrChar[i + 3] == 'e') {
                count += 1;
            }
        }

        return count;
    }

    public static boolean xyBalance(String str) {

        boolean balanced = false;

        if (!str.contains("x")) {
            balanced = true;
        } else {

            char[] arrChar = str.toCharArray();

            for (int i = arrChar.length - 1; i >= 0; i--) {

                if (arrChar[i] == 'x') {
                    break;
                } else if (arrChar[i] == 'y' & str.contains("x")) {
                    balanced = true;
                }
            }
        }

        return balanced;
    }


    public static boolean prefixAgain(String str, int n) {

        boolean match = false;

        String pref = str.substring(0, n);
        if (n > str.length() - n) {
            match = false;
        } else {

            String remainder = str.substring(n, str.length());

            if (remainder.contains(pref)) {
                match = true;
            } else {
                match = false;
            }
        }

        return match;
    }


    public static String starOut(String str) {

        char[] arr = str.toCharArray();
        StringBuilder strB = new StringBuilder("");

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr.length == 1) {
                    if (arr[i] != '*') {
                        strB.append(arr[i]);
                    }
                } else if (arr[i] != '*' & arr[i + 1] != '*') {
                    strB.append(arr[i]);
                }
            } else if (i == arr.length - 1) {
                if (arr[i] != '*' & arr[i - 1] != '*') {
                    strB.append(arr[i]);
                }
            } else if (arr[i] != '*' & arr[i - 1] != '*' & arr[i + 1] != '*') {
                strB.append(arr[i]);
            }
        }

        return strB.toString();
    }

}
