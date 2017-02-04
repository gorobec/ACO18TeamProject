package library.model;

/**
 * Created by serhiim on 29-Jan-17.
 */
public class Book extends PrintedEdition {
    private String author;

    public Book(){

    }

    public Book(String name, String author, String editionName, String editionAddress, String date, Genre genre, int copiesCount ) {
        super(editionName, editionAddress, name, date, genre, copiesCount);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
    @Override
    public String toString(){
        return String.format("%s, %s, %s, %s", author, super.getName(), super.getEditionName(), super.getDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (!super.getName().equals(book.getName())) return false;
        if (!super.getDate().equals(book.getDate())) return false;
        if (!super.getEditionName().equals(book.getEditionName())) return false;
        return getAuthor().equals(book.getAuthor());
    }
}
