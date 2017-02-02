package library.model;

/**
 * Created by serhiim on 29-Jan-17.
 */
public class Book extends PrintedEdition {
    private String bookName;
    private String author;

    public Book(String bookName, String author, String editionName, String editionAddress, String date, String genre, int copiesCount ) {
        super(editionName, editionAddress, date, genre, copiesCount);
        this.bookName = bookName;
        this.author = author;
    }




    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }
    @Override
    public String toString(){
        return String.format("%s, %s, %s, %s", author, bookName, super.getEditionName(), super.getDate());
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (!bookName.equals(book.getBookName())) return false;
        if (!super.getDate().equals(book.getDate())) return false;
        if (!super.getEditionName().equals(book.getEditionName())) return false;
        return getAuthor().equals(book.getAuthor());
    }
}
