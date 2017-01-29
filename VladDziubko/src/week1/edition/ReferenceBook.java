package week1.edition;

public class ReferenceBook extends Book {
    private String classification;
    private boolean findReference;

    public ReferenceBook(String bookTitle, String genre, String author, String classification, boolean findReference) {
        super(bookTitle, genre, author);
        this.classification = classification;
        this.findReference = findReference;
    }

    public StringBuilder publishedBy() {
        return new StringBuilder("Book is published by \"Vivat\".");
    }

    public String toString() {
        return String.format("%s, genre -> %s, author -> %s", bookTitle, genre, author);
    }

    public StringBuilder info() {
        return findReference == true ? new StringBuilder("Found necessary info!") :
                new StringBuilder("Info wasn`t found!");
    }
}
