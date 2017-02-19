package week2.library.comparators;

import week2.library.readers.Reader;

import java.util.Comparator;

public class ReaderByName implements Comparator<Reader> {
    @Override
    public int compare(Reader o1, Reader o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
