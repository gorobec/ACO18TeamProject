package exceptions;

/**
 * Created by fmandryka on 23.02.2017.
 */
public class IllegalPasswordException extends Exception {
    public IllegalPasswordException() {
    }

    public IllegalPasswordException(String s) {
        super(s);
    }
}
