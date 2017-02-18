package ACO.week2.homework.library.comparators;

import ACO.week2.homework.library.model.Reader;

import java.util.Comparator;

/**
 * Created by v21k on 31.01.17.
 */
public class ReaderByNameComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Reader r1 = (Reader) o1;
        Reader r2 = (Reader) o2;
        return r1.getName().compareTo(r2.getName());
    }
}
