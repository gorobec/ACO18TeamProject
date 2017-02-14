package library.comparators;

import library.model.Reader;

import java.util.Comparator;

/**
 * Created by User on 31.01.2017.
 */
public class ReaderSurNameComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Reader reader1 = (Reader) o1;
        Reader reader2 = (Reader) o2;
        return reader1.getSurName().compareTo(reader2.getSurName());
    }
}
