package recursion;

/**
 * Created by zhenia on 17.02.17.
 */
public class ChangeXY {
    public static String changeXY(String str) {
        if(str == null || str.length() == 0) return "";

        int posX = str.indexOf("x");

        return posX == -1 ? str :
                changeXY(str.substring(0, posX) +
                        "y" +
                        str.substring(posX + 1, str.length()));
    }

}
