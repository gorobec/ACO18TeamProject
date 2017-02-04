package oop.library.model;

import java.util.Date;

/**
 * Created by fmandryka on 31.01.2017.
 */
public class Reader {

    String name;
    String surname;
    Date dateOfBirth;

    int id;

    private static int BOOKS_LIMIT = 3;

    private Edition[] booksTaken;

}
