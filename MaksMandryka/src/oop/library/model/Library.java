package oop.library.model;

/**
 * Created by fmandryka on 31.01.2017.
 */
public class Library {

    private static Library lb;

    private Library(){};

    public static Library getInstance() {
        if (Library.lb == null) {
            lb = new Library();
        }
        return lb;
    }


}
