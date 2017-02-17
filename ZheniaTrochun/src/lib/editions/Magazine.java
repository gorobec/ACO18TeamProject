package editions;

import utils.EditionType;

/**
 * Created by zhenia on 03.02.17.
 */
public class Magazine extends Edition {
    public Magazine(String name, String author, int year) {
        super(name, author, year);
        type = EditionType.MAGAZINE;
    }

    @Override
    public String toString() {
        return String.format("Magazine \"%s\", %s, %d", name, author, year);
    }
}
