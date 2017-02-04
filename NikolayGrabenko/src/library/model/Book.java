package library.model;


public class Book extends PrintedEditions {

    private String typeOfCoverege;
    private BookGenre genre;

    public Book(String name, String author, int publicationYear, int numberOfCopies, int numberOfPages) {
        super(name, author, publicationYear, numberOfCopies, numberOfPages);
    }

    public Book(String name, String author, int publicationYear, int numberOfCopiesAvailable, int numberOfPages, String typeOfCoverege) {
        super(name, author, publicationYear, numberOfCopiesAvailable, numberOfPages);
        this.typeOfCoverege = typeOfCoverege;
    }

    public Book(String name, int publicationYear, String typeOfCoverege, BookGenre genre) {
        super(name, publicationYear);
        this.typeOfCoverege = typeOfCoverege;
        this.genre = genre;
    }
}
