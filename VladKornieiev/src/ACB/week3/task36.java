package ACB.week3;

/*
Нули

Требуется найти самую длинную непрерывную цепочку нулей
и единиц в последовательности цифр.

Вход:
10001101001

Выход:
(2,4) - цепочка нулей
(5,6) - цепочка единиц
*/

// REWRITE THIS LATER
//TODO afafasf

public class task36 {
    public static void main(String[] args) {
        String s = "111000";
        System.out.println(countChar(s, "0"));
        System.out.println(countChar(s, "1"));
    }

    public static String countChar (String input, String pattern) {
        int max = 0;
        String maxPattern = "";

        // looking for max sequence of pattern
        for (int i = 0; i < input.length(); i++) {
            String s = "";
            for (int j = 0; j <= i; j++) {
                s += pattern;
            }
            max = (input.contains(s)) ? i + 1 : max;
        }

        // filling string maxPattern = <pattern> * <max> times;
        for (int i = 0; i < max; i++) {
            maxPattern += pattern;
        }
        return String.format("(%d-%d)", (input.indexOf(maxPattern) + 1),
                (input.indexOf(maxPattern) + max));
    }
}

