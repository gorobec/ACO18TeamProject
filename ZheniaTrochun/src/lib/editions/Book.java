package editions;

import utils.EditionType;
import utils.Ganre;

/**
 * Created by zhenia on 03.02.17.
 */
public class Book extends Edition {
    private Ganre ganre;

    public Book(String name, String author, int year) {
        super(name, author, year);
        type = EditionType.BOOK;
        ganre = Ganre.ROMAN;
    }

    public Book(String name, String author, int year, Ganre ganre) {
        super(name, author, year);
        type = EditionType.BOOK;
        this.ganre = ganre;
    }

    @Override
    public String toString() {
        return String.format("Book \"%s\", %s, %d, %s", name, author, year, ganre.toString());
    }
}
