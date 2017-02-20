package to;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Администратор on 20.02.2017.
 */
public class Validator {

    boolean validEmail(String email) {
        Pattern pattern = Pattern.compile("^[a-z0-9_.]+@[a-z0-9_]+\\.[a-z]{2,5}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches() ? true : false;
    }

}
