package library.model;

/**
 * Created by ksyashka on 31.01.2017.
 */
public interface Edition {
    String toString();
    boolean isAvaible();
    String getName();
    int getYear();
    int getNumber();
    void setNumber(int number);
    String getAuthor();
}