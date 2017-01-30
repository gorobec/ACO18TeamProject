package biblio;

/**
 * Created by Мастер on 29.01.2017.
 */
public class Book extends Edition {

    String name;
    String author;
    boolean isHave;

    public Book(String namePublisher, String name, String author) {
        super(namePublisher);
        this.name = name;
        this.author = author;
    }


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
