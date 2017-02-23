package exception;

/**
 * Created by v21k on 19.02.17.
 */
public class NoSuchProductException extends StoreException {
    public NoSuchProductException(String message) {
        super(message);
    }
}
