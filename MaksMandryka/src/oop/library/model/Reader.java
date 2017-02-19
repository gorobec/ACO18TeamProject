package oop.library.model;

import oop.dataStructures.MyArrayList;
import oop.dataStructures.MyList;

import java.util.Calendar;
import java.util.Comparator;

/**
 * Created by fmandryka on 31.01.2017.
 */
public class Reader implements Comparable<Object>{

    public static int BOOKS_LIMIT = 3;

    protected MyList<PrintedEdition> booksTaken = new MyArrayList<>(BOOKS_LIMIT);

    protected String name;
    protected String surname;
    Calendar dateOfBirth;

    int id;
    boolean blackListed;

    public Reader(String name, String surname, Calendar dateOfBirth) {
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

    public MyList<PrintedEdition> getBooksTaken() {
        return booksTaken;
    }


    @Override
    public int compareTo(Object o) {

        Reader rd = (Reader) o;

        if (surname.compareTo(rd.getSurname()) != 0) {

            return surname.compareTo(rd.getSurname());

        } else {

            if (name.compareTo(rd.getName()) != 0) {
                return name.compareTo(rd.getName());
            } else {
                return dateOfBirth.compareTo(rd.getDateOfBirth());
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }


    public static class ReaderCompar implements Comparator<Reader> {

        @Override
        public int compare(Reader r1, Reader r2) {

            return r1.compareTo(r2);
        }
    }
}
