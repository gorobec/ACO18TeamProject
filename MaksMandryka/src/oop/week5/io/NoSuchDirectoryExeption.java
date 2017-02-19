package oop.week5.io;

/**
 * Created by fmandryka on 18.02.2017.
 */
public class NoSuchDirectoryExeption extends RuntimeException {

    public NoSuchDirectoryExeption(String s) {
        super(s);
    }
}
