package library.model;

/**
 * Created by User on 30.01.2017.
 */
public abstract class Editions {

    private String name;
    private String author;
    private int publicationYear;

    public Editions(String name, String author, int publicationYear) {
        this.name = name;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public Editions(String name, int publicationYear) {
        this.name = name;
        this.publicationYear = publicationYear;
    }

//    public abstract String showEdition ();


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
