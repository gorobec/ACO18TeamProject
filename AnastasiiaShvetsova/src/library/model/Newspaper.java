package library.model;

import library.model.enums.NewspaperGenre;

/**
 * Created by anastasiia.shvetsova on 1/30/2017.
 */
public class Newspaper extends PrintEdition {
    private NewspaperGenre genre;

    public Newspaper(Author author, int year, String name) {
        super(author, year, name);
    }

    public Newspaper(Author author, int year, String name, NewspaperGenre genre) {
        super(author, year, name);
        this.genre = genre;
    }

}
