package exceptions;

/**
 * Created by fmandryka on 23.02.2017.
 */
public class NoSuchUserException extends Exception {
    public NoSuchUserException() {
    }

    public NoSuchUserException(String s) {
        super(s);
    }
}
