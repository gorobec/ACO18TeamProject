package library.comparators;

import library.model.Edition;

import java.util.Comparator;

/**
 * Created by ksyashka on 31.01.2017.
 */
public class NameEditionsComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        Edition e1 = (Edition) o1;
        Edition e2 = (Edition) o2;
        return e1.getName().compareTo(e2.getName());
    }
}
