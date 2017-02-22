package exceptions;

/**
 * Created by ksyashka on 22.02.2017.
 */
public class TicketIsEmptyException extends Exception {
    public TicketIsEmptyException(String message) {
        super(message);
    }
}
