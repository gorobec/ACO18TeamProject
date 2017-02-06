package library.comparators;

import library.model.Reader;

import java.util.Comparator;

/**
 * Created by ksyashka on 31.01.2017.
 */
public class SurnameComparator<T> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        Reader r1 = (Reader) o1;
        Reader r2 = (Reader) o2;

        return r1.getSurname().compareTo(r2.getSurname());
    }

}
