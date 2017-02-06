package oop.library.model;

import java.util.Date;

/**
 * Created by fmandryka on 31.01.2017.
 */
public class Reader {

    private static int BOOKS_LIMIT = 3;

    private Edition[] booksTaken;

    String name;
    String surname;
    Date dateOfBirth;

    int id;
    boolean blackListed;

    public Reader(String name, String surname, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isBlackListed() {
        return blackListed;
    }

    public void setBlackListed(boolean blackListed) {
        this.blackListed = blackListed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reader reader = (Reader) o;

        if (!name.equals(reader.name)) return false;
        if (!surname.equals(reader.surname)) return false;
        return dateOfBirth.equals(reader.dateOfBirth);


    }

}
