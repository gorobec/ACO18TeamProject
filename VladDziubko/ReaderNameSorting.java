package week2.library.comparators;

import week2.library.readers.Reader;

import java.util.Comparator;

public class ReaderNameSorting implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Reader r1 = (Reader) o1;
        Reader r2 = (Reader) o2;
        return r1.getName().compareTo(r2.getName());
    }
}
