package library.model;

import library.model.enums.MagazineGenre;

/**
 * Created by anastasiia.shvetsova on 1/30/2017.
 */
public class Magazine extends PrintEdition {
    private MagazineGenre genre;

    public Magazine(Author author, int year, String name, MagazineGenre genre) {
        super(author, year, name);
        this.genre = genre;
    }
}
