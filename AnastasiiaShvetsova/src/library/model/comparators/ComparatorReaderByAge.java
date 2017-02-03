package library.model.comparators;

import library.model.Reader;

import java.util.Comparator;

/**
 * Created by anastasiia.shvetsova on 2/1/2017.
 */
public class ComparatorReaderByAge implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Reader reader1 = (Reader) o1;
        Reader reader2 = (Reader) o2;

        return Integer.compare(reader1.getAge(), reader2.getAge());
    }
}
