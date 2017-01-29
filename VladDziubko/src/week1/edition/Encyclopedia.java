package week1.edition;

public class Encyclopedia extends Book {
    public Encyclopedia(String bookTitle, String genre, String author) {
        super(bookTitle, genre, author);
    }

    public StringBuilder publishedBy() {
        return new StringBuilder("Book is published by \"Vivat\".");
    }

    public String toString() {
        return String.format("%s, genre -> %s, author -> %s", bookTitle, genre, author);
    }
}
