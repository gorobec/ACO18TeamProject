package library.model.comparators;

import library.model.Reader;

import java.util.Comparator;

/**
 * Created by anastasiia.shvetsova on 2/1/2017.
 */
public class ComparatorReaderByName implements Comparator {
    @Override
    public int compare(Object obj1, Object obj2) {
        Reader reader1 = (Reader) obj1;
        Reader reader2 = (Reader) obj2;

        return reader1.getName().compareTo(reader2.getName());
    }
}
