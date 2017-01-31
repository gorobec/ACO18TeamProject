package biblio;

/**
 * Created by Мастер on 29.01.2017.
 */
public class Book extends Edition {

    private String author;
    private int kolvo;

    public Book(String name, String author, int kolvo) {
        super(name);
        this.author = author;
        this.kolvo = kolvo;
    }

    @Override
    public String toString() {
        return super.toString() + "Book{" +
                "author='" + author + '\'' +
                '}';
    }
}
