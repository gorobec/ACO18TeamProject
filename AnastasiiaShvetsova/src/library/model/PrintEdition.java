package library.model;

import library.model.Author;

/**
 * Created by anastasiia.shvetsova on 1/30/2017.
 */
public class PrintEdition {
    Author author;
    int year;
    String name;

    public PrintEdition(Author author, int year, String name) {

        this.author = author;
        this.year = year;
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
                "{" + author.toString() + ", " + year + ", " + name +
                        '}';
    }
}
