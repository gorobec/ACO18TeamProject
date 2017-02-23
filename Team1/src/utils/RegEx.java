package utils;

/**
 * Created by v21k on 23.02.17.
 */
public class RegEx {
    public static final String ONLY_ALPHA = "[a-zA-Z]+";
    public static final String ONLY_NUMERIC = "[0-9]+";
    public static final String USERNAME = "^[a-zA-Z0-9]{3,}$";
    public static final String PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$";
    public static final String EMAIL = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
}
