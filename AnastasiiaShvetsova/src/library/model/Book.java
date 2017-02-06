package library.model;

import library.model.enums.BookGenre;

/**
 * Created by anastasiia.shvetsova on 1/30/2017.
 */
public class Book extends PrintEdition {
    private BookGenre genre;

    public Book(Author author, int year, String name) {
        super(author, year, name);
    }

    public Book(Author author, int year, String name, BookGenre bookGenre) {
        super(author, year, name);
        this.genre = bookGenre;
    }

    @Override
    public String toString() {
        return
                "{" + author.toString() + ", " + year + ", " + name + ", " + genre +
                        '}';
    }
}
