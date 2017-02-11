package library.comparators;

import library.model.Reader;

import java.util.Comparator;

/**
 * Created by serhiim on 06-Feb-17.
 */
public class ReaderFirstNameComparator<T extends Reader> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
