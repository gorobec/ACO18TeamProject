package editions;

import utils.EditionType;

/**
 * Created by zhenia on 03.02.17.
 */
public class Newspaper extends Edition {
    public Newspaper(String name, String author, int year) {
        super(name, author, year);
        type = EditionType.NEWSPAPER;
    }

    @Override
    public String toString() {
        return String.format("Newspaper \"%s\", %s, %d", name, author, year);
    }
}
