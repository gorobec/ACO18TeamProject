package recursion;

/**
 * Created by Nastia on 15.02.17.
 */
public class CountHi {
    //xhixhix
    public int countHi(String str) {
        if (!str.contains("hi")) {
            return 0;
        }
        int res = 0;
        int index = str.length() - 1;
        char elem1 = str.charAt(index);
        char elem2 = str.charAt(index - 1);

        if (elem1 == 'i' && elem2 == 'h') {
            res = 1;
        }
        return res + countHi(str.substring(0, index));
    }

}
