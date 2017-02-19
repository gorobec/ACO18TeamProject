package recursion;

/**
 * Created by Nastia on 15.02.17.
 */
public class ChangePi {
    public String changePi(String str) {
        String subStr = "pi";
        String newStr = "";
        if (!str.contains(subStr)) {
            return str;
        }

        if (str.contains(subStr)) {
            newStr = str.replace(subStr, "3.14");
        }

        return changePi(str.replace(str, newStr));
    }
}
