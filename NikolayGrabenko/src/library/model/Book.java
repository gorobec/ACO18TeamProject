package library.model;

/**
 * Created by User on 30.01.2017.
 */
public class Book extends PrintedEditions {

    public Book(String name, String author, int publicationYear, int numberOfCopies, int numberOfPages) {
        super(name, author, publicationYear, numberOfCopies, numberOfPages);
    }
}
