package recursion;

/**
 * Created by Nastia on 15.02.17.
 */
public class NoX {
    public String noX(String str) {
        String subStr = "x";
        String newStr = "";
        if (!str.contains(subStr)) {
            return str;
        }

        if (str.contains(subStr)) {
            newStr = str.replace(subStr, "");
        }

        return noX(str.replace(str, newStr));
    }

}
