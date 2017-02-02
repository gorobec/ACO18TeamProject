package library.model;

/**
 * Created by ksyashka on 31.01.2017.
 */
public class Book extends Edition {
    private Genre genre;

    public Book(String name, String author, int year, int number, Genre genre) {
        super(name, author, year, number);
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("Book: name - %30s, author - %20s, year - %5d, genre - %8s, number - %3d", getName(),
                getAuthor(), getYear(), genre, getNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        if (genre == book.genre) return super.equals(o);
        return false;
    }

}

