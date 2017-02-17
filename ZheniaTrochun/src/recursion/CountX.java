package recursion;

/**
 * Created by zhenia on 17.02.17.
 */
public class CountX {
    public static int countX(String str) {
        if(str == null || str.length() == 0) return 0;

        return  (str.substring(0, 1).equals("x") ? 1 : 0) + countX(str.substring(1));
    }
}
