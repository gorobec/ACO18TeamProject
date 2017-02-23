package exceptions;

/**
 * Created by fmandryka on 23.02.2017.
 */
public class IllegalPasswordFormatException extends Exception {
    public IllegalPasswordFormatException(String s) {
        super(s);
    }
}
