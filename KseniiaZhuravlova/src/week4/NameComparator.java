package week4;

import java.util.Comparator;

/**
 * Created by ksyashka on 15.02.2017.
 */
public class NameComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        Human h1 = (Human) o1;
        Human h2 = (Human) o2;
        return h1.getName().compareTo(h2.getName());
    }
}

