package library.model;

/**
 * Created by User on 30.01.2017.
 */
public class Book extends PrintedEditions {
    String  typeOfCoverege;

    public Book(String name, String author, int publicationYear, int numberOfCopies, int numberOfPages) {
        super(name, author, publicationYear, numberOfCopies, numberOfPages);
    }

    public Book(String name, String author, int publicationYear, int numberOfCopiesAvailable, int numberOfPages, String typeOfCoverege) {
        super(name, author, publicationYear, numberOfCopiesAvailable, numberOfPages);
        this.typeOfCoverege = typeOfCoverege;
    }
}
