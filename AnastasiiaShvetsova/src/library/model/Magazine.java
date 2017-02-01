package library.model;

/**
 * Created by anastasiia.shvetsova on 1/30/2017.
 */
public class Magazine extends PrintEdition {
    String name;
    Page[] pages;

    public Magazine(Author author, int year, String name) {
        super(author, year);
        this.name = name;
    }
    @Override
    public String toString() {
        return
                "{" + author.toString() + ", " + year + ", " + name +
                        '}';
    }
}
