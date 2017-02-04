package oop.library.model;

import oop.weak1.task_7_arrayList.MyArrayList;

/**
 * Created by fmandryka on 31.01.2017.
 */
public class Library {

    private static Library lb;

    private MyArrayList<Reader> readers;
    private MyArrayList<Edition> fullCatalog;

    private Library(){};

    public static Library getInstance() {
        if (Library.lb == null) {
            lb = new Library();
        }
        return lb;
    }


}
