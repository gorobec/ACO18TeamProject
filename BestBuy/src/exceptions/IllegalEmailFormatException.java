package exceptions;

/**
 * Created by fmandryka on 23.02.2017.
 */
public class IllegalEmailFormatException extends Exception {
    public IllegalEmailFormatException(String s) {
        super(s);
    }
}
