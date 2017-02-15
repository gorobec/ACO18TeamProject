package recursion;

/**
 * Created by anastasiia.shvetsova on 2/15/2017.
 */
public class CountX {
    public int countX(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int index = str.length() - 1;
        int resCompare = 0;
        if (str.charAt(index) == 'x') {
            resCompare = 1;
        }

        return resCompare + countX(str.substring(0, index));
    }

}
