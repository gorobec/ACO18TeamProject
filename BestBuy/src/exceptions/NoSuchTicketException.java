package exceptions;

import java.io.IOException;

/**
 * Created by fmandryka on 19.02.2017.
 */
public class NoSuchTicketException extends IOException {
    public NoSuchTicketException(String s) {
        super(s);
    }
}
