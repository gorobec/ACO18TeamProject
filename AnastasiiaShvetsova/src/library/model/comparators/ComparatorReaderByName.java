package library.model.comparators;

import library.model.Reader;

import java.util.Comparator;

/**
 * Created by anastasiia.shvetsova on 2/1/2017.
 */
public class ComparatorReaderByName implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Reader reader1 = (Reader) o1;
        Reader reader2 = (Reader) o2;

        return reader1.getName().compareTo(reader2.getName());
    }
}
