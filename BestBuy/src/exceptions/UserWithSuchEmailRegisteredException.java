package exceptions;

/**
 * Created by fmandryka on 23.02.2017.
 */
public class UserWithSuchEmailRegisteredException extends Exception {
    public UserWithSuchEmailRegisteredException(String s) {
        super(s);
    }
}
