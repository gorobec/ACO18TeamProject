package library.model;

import library.model.Author;

/**
 * Created by anastasiia.shvetsova on 1/30/2017.
 */
public class PrintEdition {
    Author author;
    int year;

    public PrintEdition(Author author, int year) {

        this.author = author;
        this.year = year;
    }

    public Author getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return
                "{" + author.toString() + ", " + year +
                        '}';
    }
}
