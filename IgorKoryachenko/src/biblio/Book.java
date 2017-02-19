package biblio;

/**
 * Created by Мастер on 29.01.2017.
 */
public class Book extends Edition {

    private String author;


    public Book(String name, int kolvo, String author) {
        super(name, kolvo);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return super.toString() + "Book{" +
                "author='" + author + '\'' +
                '}';
    }
}
