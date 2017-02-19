package controller;

/**
 * Created by SDotsenko on 19.02.2017.
 */
public class InvalidInputParameters extends Throwable {
    public InvalidInputParameters(String message) {
        super(message);
    }
}
