package exceptions;

import java.io.IOException;

/**
 * Created by fmandryka on 19.02.2017.
 */
public class NoSuchProductException extends Exception {
    public NoSuchProductException(String s) {
        super(s);
    }
}