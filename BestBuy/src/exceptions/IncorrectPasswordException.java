package exceptions;

/**
 * Created by fmandryka on 23.02.2017.
 */
public class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException() {
    }

    public IncorrectPasswordException(String s) {
        super(s);
    }
}
