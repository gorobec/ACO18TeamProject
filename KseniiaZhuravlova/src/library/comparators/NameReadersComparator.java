package library.comparators;

import library.model.Reader;

import java.util.Comparator;

/**
 * Created by ksyashka on 31.01.2017.
 */
public class NameReadersComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Reader r1 = (Reader) o1;
        Reader r2 = (Reader) o2;

        return r1.getName().compareTo(r2.getName());
    }
}