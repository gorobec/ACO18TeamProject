package week1.edition;

abstract class Book implements IEdition {
    public String bookTitle;
    public String genre;
    public String author;

    public Book(String bookTitle, String genre, String author) {
        this.bookTitle = bookTitle;
        this.genre = genre;
        this.author = author;
    }

    public abstract String toString();
}
